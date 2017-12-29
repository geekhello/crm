package com.crm.web.action.test;
/**
 * 装饰者模式
 * 思想：在不改变类的内容和继承的情况下，动态的扩展该类对象的功能，通过一个包装类，包装类中包含该类的真是对象也就是实现接口
 * @author zhang
 *
 */
public class DecoratorTest {

	public static void main(String[] args) {
		Sourceable sour = new Source();
		Sourceable deco = new Decorator(sour);
		deco.method();
	}
}

// 原始接口
interface Sourceable {
	void method();
}

// 待装饰类
class Source implements Sourceable {

	@Override
	public void method() {
		System.out.println("this is source method");
	}
}

// 装饰类
class Decorator implements Sourceable {

	private Sourceable sour;
	
	public Decorator(Sourceable sour) {
		super();
		this.sour = sour;
	}
	
	@Override
	public void method() {
		System.out.println("before source method");
		sour.method();
		System.out.println("after source method");
	}
	
}