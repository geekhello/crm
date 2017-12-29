package com.crm.web.action.test;
/**
 * 工厂方法模式
 * 创建一个工厂，提供多个工厂方法对同一接口得一些实现类进行实例得创建
 * @author zhang
 *
 */
public class FactoryMethodDemo {

	public static void main(String[] args) {
		FactoryMethod fm = new FactoryMethod();
		IProduct createOne = fm.createOne();
		createOne.product();
	}
}

class FactoryMethod {
	public IProduct createOne(){
		return new ProductA();
	}
	
	public IProduct createTwo(){
		return new ProductB();
	}
}
