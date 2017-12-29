package com.crm.web.action.test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.TypeVariable;
import java.math.BigInteger;
import java.util.concurrent.ThreadLocalRandom;

public class MyDemo {

	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		try{
			
			System.out.println(generateUUID());
			// 
			Class clazz = Class.forName("com.crm.web.action.test.TestReflectDemo");
			// 类名
			String className = clazz.getSimpleName();
			System.out.print(Modifier.toString(clazz.getModifiers())+" class "+className+"{\n");
			// 类的属性
			Field[] fields = clazz.getDeclaredFields();
			for(int i=0;i<fields.length;i++){
				String auth = Modifier.toString(fields[i].getModifiers());// 权限public、private
				String type = fields[i].getType().getSimpleName(); // 类型 int、String、Long
				String name = fields[i].getName(); // 属性名字
				System.out.println("\t"+auth+" "+type+" "+name);
			}
			// 类的构造函数
			Constructor con = clazz.getDeclaredConstructor();// 无参构造
			//con.setAccessible(true);
			System.out.println(Modifier.toString(con.getModifiers())+" "+con.getName());
			Constructor conArg = clazz.getDeclaredConstructor(Long.class,String.class,String.class,int.class);// 有参构造
			System.out.println(conArg.getName());
			Class[] typeClazz = conArg.getParameterTypes();
			for(Class var : typeClazz){
				System.out.println(var.getName());
				
			}
			
			// 类的方法
			Method method = clazz.getDeclaredMethod("testGo", String.class,int.class);
			System.out.println(Modifier.toString(method.getModifiers())+" "+method.getReturnType().getSimpleName()+" "+method.getName());
			String str = (String)method.invoke(con.newInstance(), "weiwei",3);
			System.out.println(str);
			System.out.println("}");
			
		}catch( Exception e){
			System.out.println("youcuo");
		}
		System.out.println("捕获错误后代码仍执行");
	}
	
	public static String generateUUID(){
		ThreadLocalRandom current = ThreadLocalRandom.current();
		System.out.println(current.nextInt());
		BigInteger bigInteger = new BigInteger(165, current);
		System.out.println(bigInteger);
		return bigInteger.toString(36).toUpperCase();
	}

	
}

class superclass{
	
	static{
		System.out.println("this is super class");
		
	}
	
	public static final String str = "super class";
}

class subclass extends superclass {
	
	static {
		System.out.println("this is sub class");
		
	}
}

