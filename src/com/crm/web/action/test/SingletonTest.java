package com.crm.web.action.test;

import javax.sql.rowset.spi.SyncResolver;

public class SingletonTest {

	public static void main(String[] args) {
		Thread t1 = new Mythread();
		Thread t2 = new Mythread();
		Thread t3 = new Mythread();
		Thread t4 = new Mythread();
		Thread t5 = new Mythread();
		Thread t6 = new Mythread();
		
		t1.start();
		t2.start();
		t3.start();
		t4.start();
		t5.start();
		t6.start();
	}
	
	
}

class Mythread extends Thread {
	@Override
	public void run() {
		try {
			Inton instance = Inton.getInstance();
			System.out.println(instance.hashCode());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

// 饿汉单例模式
class Eargeton {
	
	// 私有化构造函数
	private Eargeton() {
		// TODO Auto-generated constructor stub
	}
	
	private static Eargeton eton = new Eargeton();
	
	public synchronized static Eargeton getInstance(){
		try {
			Thread.sleep(3000);
			eton = new Eargeton();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return eton;
	}
}

// 懒汉单例模式
// 开启多线程访问时会导致单例失效
class Lazyton {
	
	// 私有化构造函数
	private Lazyton() {
		
	}
	
	private static Lazyton lazyton;
	
	public static Lazyton getInstance(){
		if(lazyton==null){
			try {
				Thread.sleep(3000);
				lazyton = new Lazyton();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return lazyton;
	}
	
}

// dcl双检查锁机制
class DouCheckton{
	
	// 私有化构造函数
	private DouCheckton() {}
	
	private static DouCheckton dcton;
	
	public static DouCheckton getInstance()	{
		if(dcton == null) {
			synchronized (DouCheckton.class) {
				if(dcton == null){
					dcton = new DouCheckton();
				}
			}
		}
		return dcton;
	}
}

// 内部类方式
class Inton{
	
	// 私有化构造函数
	private Inton() {}
	
	static {
		System.out.println("静态代码块调用了");
	}
	
	private static class IntonHolder {
		private final static Inton iton = new Inton();
	}
	
	public static Inton getInstance(){
		return IntonHolder.iton; 
	}
}

class InnerClass{
	// 私有化构造函数
	private InnerClass(){};
	
	public static class InnerHolder{
		private static final InnerClass instance = new InnerClass();
	}
	
	public static InnerClass getInstance(){
		return InnerHolder.instance;
	}
}