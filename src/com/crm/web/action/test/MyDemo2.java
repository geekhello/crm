package com.crm.web.action.test;

public class MyDemo2 {

	public static void main(String[] args) {
		System.out.println(returnNum());
	}
	public static int returnNum(){
		int num = 12;
		try {
			int a = 2/0;
			return num;
		} catch(Exception e){
			e.printStackTrace();
		} finally {
			num = 13;
			System.out.println("执行finally"+num);
			return num;
		}
	}
}
