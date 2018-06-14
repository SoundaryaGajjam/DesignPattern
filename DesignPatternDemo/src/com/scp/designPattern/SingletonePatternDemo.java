package com.scp.designPattern;

import com.sun.swing.internal.plaf.synth.resources.synth;

public class SingletonePatternDemo {
	public static void main(String[] args) {
		
		Student s1=Student.getInstance();
		Student s2=Student.getInstance();
		
		System.out.println(s1==s2);
		
		System.out.println(s1);
		System.out.println(s2);
		
	}

}
class Student{
	/*//egaer initialization
	//private final static Student studOb=new Student();
	
	//static block
	private final static Student studOb;
	static{
		studOb=new Student();
	}*/
	
	
	private Student(){
		
	}
	/*
	 //lazy initialization
	private static Student studOb;
	public static Student getInstance(){
		if(studOb==null)
			studOb=new Student();
		return studOb;
	}*/
	/*
	//ThreadSafe Singletone
	private static Student studOb;
	public synchronized static Student getInstance(){
		if(studOb==null)
			studOb=new Student();
		return studOb;
	}*/
	
	/*//Double Checking Threadsafe singleton
	private static Student studOb;
	public static Student getInstance(){
		if(studOb==null){
			synchronized (Student.class) {
				if(studOb==null)
					studOb=new Student();
				}	
			}
		return studOb;
	}*/
	
	//Bill pugh ----eager initilazztion with static inner cls
	
	private static final class InnerStudent{
		public static Student studOb=new Student();
	}
	public static Student getInstance(){
		return InnerStudent.studOb;
		
	}
}
