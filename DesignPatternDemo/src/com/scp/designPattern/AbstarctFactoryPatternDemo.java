package com.scp.designPattern;

public class AbstarctFactoryPatternDemo {
	public static void main(String[] args) {
		
		AbstractFactories iPhnObj=new iPhoneFactory();
				
		Mobile1 obj1=MobileFactory.getMobileInstance(iPhnObj);
		System.out.println(obj1.getClass());
		System.out.println(obj1);
		
		AbstractFactories samsungObj=new SamsungFactory();
		Mobile1 obj2=MobileFactory.getMobileInstance(samsungObj);
		System.out.println(obj2.getClass());
		System.out.println(obj2);
		
		AbstractFactories MiObj=new MiFactory();
		Mobile1 obj3=MobileFactory.getMobileInstance(MiObj);
		System.out.println(obj3.getClass());
		System.out.println(obj3);
		
	}

}

abstract class Mobile1{
	abstract public boolean isBluetoothAvaliable();
	abstract public double getPrice();
	abstract public int getIMEINumber();
	
	public String toString(){
		return "\nBluetooth : "+isBluetoothAvaliable()+"\nPrice : "+getPrice()+"\nIMEI : "+getIMEINumber();
	}
}
class iPhone extends Mobile1 {

	@Override
	public boolean isBluetoothAvaliable() {
		return false;
	}
	@Override
	public double getPrice() {
		return 800000;
	}
	@Override
	public int getIMEINumber() {
		return 1111111;
	}
	
}
class Samsung extends Mobile1{

	@Override
	public boolean isBluetoothAvaliable() {
		return true;
	}
	@Override
	public double getPrice() {
		return 25000;
	}
	@Override
	public int getIMEINumber() {
		return 222222222;
	}
	
}
class Mi extends Mobile1 {
	@Override
	public boolean isBluetoothAvaliable() {
		return true;
	}
	@Override
	public double getPrice() {
		return 10000;
	}
	@Override
	public int getIMEINumber() {
		return 33333333;
	}
}

interface AbstractFactories{
	Mobile1 getMobile();
}
class iPhoneFactory implements AbstractFactories{
	@Override
	public Mobile1 getMobile() {
		return new iPhone();
	}
}
class SamsungFactory implements AbstractFactories{
	@Override
	public Mobile1 getMobile() {
		return new Samsung();
	}
}
class MiFactory implements AbstractFactories{
	@Override
	public Mobile1 getMobile() {
		return new Mi();
	}
}

class MobileFactory{
	public static Mobile1 getMobileInstance(AbstractFactories aFact){
		return aFact.getMobile();
	}
}