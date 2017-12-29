package com.crm.web.action.test;

import java.io.ByteArrayInputStream;
import java.io.InputStreamReader;
import java.util.Scanner;

/**
 * 1.类适配器模式
 * 有某个类的方法，待适配，目标接口中想要拥有该方法，创建一个适配器类，继承该类实现该接口即可将某类的方法扩展到目标接口中
 * 
 * 2.对象适配器
 * A类中有个doThing()方法，当前使用接口I想拥有这个方法，创建一个适配器类B类，实现I接口，同时B类中包含A类的引用，通过构造的方式引入A类
 * 
 * 3.第三种适配器
 * A类想实现I接口中的某个方法，但是I接口中声明的方法太多，实现的话需要同时重写多个方法，创建一个适配器类B，B实现I接口，然后A类继承B类来实现想要的方法
 * @author zhang
 *
 */
public class AdapterTest {

	public static void main(String[] args) {
		/*target tar = new adapter1();
		tar.method1();
		tar.method2();*/
		Sour sour = new Sour();
		target tar = new adapter2(sour);
		tar.method1();
		tar.method2();
		System.out.printf("100的十六进制：%x,%n",100);
		Scanner sc = new Scanner(System.in);
		String str = sc.next();
		if(str!=null && str.length()<6){
			str = String.format("%06d", Long.valueOf(str));
		}
		System.out.println(str);
	}

}

// 想要扩展的的类
class Sour {
	public void method1(){
		System.out.println("this is Sour method");
	}
}

// 目标接口
interface target {
	// 想要扩展的方法
	public void method1();
	
	public void method2();
}

// 类适配器
class adapter1 extends Sour implements target {

	@Override
	public void method2() {
		// TODO Auto-generated method stub
		System.out.println("this is target method");
	}
	
}

// 对象适配器
class adapter2 implements target {

	// 引入待扩展类的引用
	private Sour sour;
	
	public adapter2(Sour sour) {
		super();
		this.sour = sour;
	}
	
	// 调用待扩展的方法
	@Override
	public void method1() {
		sour.method1();
	}

	@Override
	public void method2() {
		System.out.println("this is target method");
	}
	
}



