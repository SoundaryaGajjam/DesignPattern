package com.scp.designPattern;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class ReflectionSingletonDemo {
	public static void main(String[] args) throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		reflectionMechanism();
	}

	private static void reflectionMechanism() throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		Mobile m1=Mobile.getInstance();
		Constructor []conArr = Mobile.class.getConstructors();
		Mobile newObj=null;
		
		for (Constructor item : conArr) {
			item.setAccessible(true);
			newObj=(Mobile) item.newInstance();			
		}
		System.out.println("Breaking double checking singletone using reflection mechanism : ");
		System.out.println(m1==newObj);
	}

}
class Mobile{
	private static Mobile mobObj;
	private Mobile(){
		
	}
	
	public static Mobile getInstance(){
		if(mobObj==null){
			synchronized (Mobile.class) {
				if(mobObj==null)
					mobObj=new Mobile();
			 }
		}
		return mobObj;
	}	
}
