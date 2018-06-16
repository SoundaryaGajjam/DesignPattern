package com.scp.designPattern;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class NewInstanceUsingReflection {
	public static void main(String[] args) throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		Student1 ob1=Student1.getInstance();
		System.out.println(ob1);
		Student1 ob2=Student1.getInstance();
		System.out.println(ob2);
		
		System.out.println(ob1==ob2);
		System.out.println("--------------------------");
		Student1 newOb=null;
		Constructor Carray[]=Student1.class.getDeclaredConstructors();
		System.out.println("Total No. of costructors : "+Carray.length);
		for (Constructor item : Carray) {
			item.setAccessible(true);
			Object a[]=item.getParameterTypes();
			System.out.println("No.of Parameters in constructor : "+a.length);
			System.out.println("-----------------------------");
			for (Object x : a) {
				System.out.println("Data type : "+x);
				if(a.length==2)
					newOb=(Student1)item.newInstance(15,"John");
					
			}
		}
		System.out.println("-------------------------------------");
		System.out.println("Creating new instance with new data using reflection mechanism : ");
		System.out.println(newOb);
		System.out.println(ob1==newOb);
	}
}
class Student1{
	private int studId;
	private String studName;
	private static Student1 studOb;
	private Student1() {
		System.out.println("Default constructor....");
	}
	private Student1(int studId, String studName) {
		this(studId);
		this.studId = studId;
		this.studName = studName;
		System.out.println("Parameterized Constructor...id & Name");
	}
	private Student1(int studId) {
		this();
		this.studId = studId;
		this.studName="Nisha";
		System.out.println("Id : "+studId);
		System.out.println("Name  : "+studName);
		System.out.println("Parameterized Constructor...id ");
	}
	@Override
	public String toString() {
		return "\nStudent [studId=" + studId + ", studName=" + studName + "]";
	}
	
	public static Student1 getInstance(){
		if(studOb==null){
			synchronized (Student1.class) {
				if(studOb==null)
					studOb= new Student1(10, "Smith");
			}
		}
		return studOb;
	}
	
	
}