package com.crm.web.action.test.mythread;

import java.util.concurrent.Callable;

/**
 * 线程的实现方式 1.继承Thread类 2.实现runnable接口 3.实现callable接口
 * 
 * @author zhang
 *
 */
public class ThreadDemo {

	public static void main(String[] args) {
		/*
		 * Thread thread1 = new thread1("thread1"); Thread thread2 = new
		 * thread2("thread2");
		 * 
		 * thread1.start(); thread2.start(); System.out.println("main....");
		 */
		runn run = new runn();
		
		Thread th1 = new Thread(run);
		Thread th2 = new Thread(run);

		th1.start();
		th2.start();
	}
}

class thread1 extends Thread {

	private String name;

	public thread1() {
		super();
	}

	public thread1(String name) {
		this.name = name;
	}

	@Override
	public void run() {
		synchronized (LockB.class) {
			System.out.println("获得B类锁");
			synchronized (LockA.class) {
				System.out.println("获得A类锁");
				System.out.println("Thread:" + name);
			}
		}
	}
}

class thread2 extends Thread {

	private String name;

	public thread2() {
		super();
	}

	public thread2(String name) {
		this.name = name;
	}

	@Override
	public void run() {
		synchronized (LockA.class) {
			System.out.println("获得A类锁");
			synchronized (LockB.class) {
				System.out.println("获得B类锁");
				System.out.println("Thread:" + name);
			}
		}
	}
}

class runn implements Runnable {
	// 锁对象
	private static final Object obj = new Object();
	//
	private int count = 20;

	@Override
	public void run() {
		while (true) {
			synchronized (obj) {
				if (count >= 0) {
					try {
						System.out.println(Thread.currentThread().getName()
								+ " get number：" + count);
						Thread.sleep(100);
						count--;
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			}
		}
	}

}

class call implements Callable<String>{

	// private ClientService clientService;
	
	@Override
	public String call() throws Exception {
		synchronized (this) {
			// 同步代码块中的逻辑处理
		}
		// String result = clientService.do();
		return "excute callable";
	}
	
}
