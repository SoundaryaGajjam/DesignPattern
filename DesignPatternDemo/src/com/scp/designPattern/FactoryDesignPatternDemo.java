package com.scp.designPattern;

import com.scp.designPattern.EmployeeFactory.EmpType;

public class FactoryDesignPatternDemo {
	public static void main(String[] args) {
		Employee e1=EmployeeFactory.getInstance(EmpType.permentEmp);
		Employee e2=EmployeeFactory.getInstance(EmpType.contractEmp);
		
		System.out.println("ID : " +e1.empId());
		System.out.println("NO of HiliDays : "+e1.NoOfHoliDays());
		System.out.println("Salary : "+e1.getSalary());
		System.out.println("********************");
		System.out.println("ID : " +e2.empId());
		System.out.println("NO of HiliDays : "+e2.NoOfHoliDays());
		System.out.println("Salary : "+e2.getSalary());
		System.out.println("--------------------");
		System.out.println(e1 instanceof PermentEmp);
		System.out.println(e1 instanceof ContractEmp);
		System.out.println(e2 instanceof PermentEmp);
		System.out.println(e2 instanceof ContractEmp);
		
	}

}

abstract class Employee{
	public abstract int getSalary();
	public abstract int NoOfHoliDays();
	public abstract int empId();
}
class PermentEmp extends Employee{

	@Override
	public int getSalary() {
		return 50000;
	}

	@Override
	public int NoOfHoliDays() {
		return 30;
	}

	@Override
	public int empId() {
		return 1010101010;
	}
	
}

class ContractEmp extends Employee{

	@Override
	public int getSalary() {
		return 20000;
	}

	@Override
	public int NoOfHoliDays() {
		return 18;
	}

	@Override
	public int empId() {
		return 99;
	}
	
}

class EmployeeFactory{
	public static Employee getInstance(EmpType type){
		if(type.equals(EmpType.permentEmp))
			return new PermentEmp();
		
		else if(type.equals(EmpType.contractEmp))
			return new ContractEmp();
		
		return null;
		
	}
	
	enum EmpType{
		permentEmp,
		contractEmp;
	}
}