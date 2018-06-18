package com.scp.designPattern;

public class VendingMachineAbstractFactory {
	public static void main(String[] args) {
		AbstractFactory teaObj=new TeaFactory();
		VendingMachine obj1=AbstractFactoryDesign.getInstance(teaObj);
		System.out.println(obj1);
		
		AbstractFactory coffeeObj=new CoffeeFactory();
		VendingMachine obj2=AbstractFactoryDesign.getInstance(coffeeObj);
		System.out.println(obj2);
		
	}
}
abstract class VendingMachine{
	abstract public String getItem();
	abstract public String isSugerFree();
	abstract public double getPrice();
	@Override
	public String toString() {
		return "VendingMachine [getItem()=" + getItem() + ", isSugerFree()=" + isSugerFree() + ", getPrice()="
				+ getPrice() + "]";
	}
	
	
}
class Coffee extends VendingMachine{

	@Override
	public String getItem() {
		return "Cold Coffee";
	}

	@Override
	public String isSugerFree() {
		return "NO";
	}

	@Override
	public double getPrice() {
		return 150;
	}
}

class Tea extends VendingMachine{

	@Override
	public String getItem() {
		return "Green Tea";
	}

	@Override
	public String isSugerFree() {
		return "YES";
	}

	@Override
	public double getPrice() {
		return 50;
	}
}
class Drink extends VendingMachine{

	@Override
	public String getItem() {
		return "Soda";
	}

	@Override
	public String isSugerFree() {
		return "NO";
	}

	@Override
	public double getPrice() {
		return 30;
	}
}

abstract class AbstractFactory{
	abstract public VendingMachine getItem();
}
class CoffeeFactory extends AbstractFactory{

	@Override
	public VendingMachine getItem() {
		return new Coffee();
	}
}
class TeaFactory extends AbstractFactory{

	@Override
	public VendingMachine getItem() {
		return new Tea();
	}
}
class DrinkFactory extends AbstractFactory{

	@Override
	public VendingMachine getItem() {
		return new Drink();
	}
}
class AbstractFactoryDesign{
	public static VendingMachine getInstance(AbstractFactory aFactory){
		return aFactory.getItem();
	}
}
