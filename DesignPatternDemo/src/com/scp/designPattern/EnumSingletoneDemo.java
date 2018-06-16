package com.scp.designPattern;
import com.scp.designPattern.EnumDemo.parameter;

public class EnumSingletoneDemo {
	public static void main(String[] args) {
		parameter ob1=parameter.eObj;
		parameter ob2=parameter.eObj;
		System.out.println(ob1.hashCode());
		System.out.println(ob2.hashCode());
		System.out.println(ob1==ob2);
	}
}
class EnumDemo{
//public static EnumDemo eObj;
	private EnumDemo(){
		
	}
	enum parameter{
		eObj;	//iternally----EnumDemo eObj=new EnumDemo();
	}
}