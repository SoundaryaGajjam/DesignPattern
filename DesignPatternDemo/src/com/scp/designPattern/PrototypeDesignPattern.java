package com.scp.designPattern;

import java.util.*;
public class PrototypeDesignPattern {
	public static void main(String[] args) throws CloneNotSupportedException {
		Color obj1=new Color();
		obj1.load();
		
		Color clonnedObj=(Color) obj1.clone();
		System.out.println(obj1==clonnedObj);
		
		//clonnedObj.load();
	}
}
class Color implements Cloneable{
	ArrayList<String>listOfColor;
	public Color(){
		listOfColor=new ArrayList<>();
	}	
	public  void load(){
		listOfColor.add("Red");
		listOfColor.add("Black");
		listOfColor.add("White");
		listOfColor.add("Green");
		
		System.out.println(listOfColor);
	}
	
	@Override
	protected Object clone() throws CloneNotSupportedException {
		return super.clone();
	}
	
}
