package com.crm.web.action.test;
/**
 * 普通工厂模式
 * 1.创建一个工厂，对实现了同一接口得不同类进行实例得创建
 * @author zhang
 *
 */
public class CommonFactoryDemo {

	public static void main(String[] args) {
		CommonFactory cf = new CommonFactory();
		IProduct p = cf.createProduct("A");
		p.product();
	}
}

interface IProduct{
	
	void product();
}

class ProductA implements IProduct{

	@Override
	public void product() {
		System.out.println("AAAAAAAAAAAAA");
		
	}
	
}

class ProductB implements IProduct {

	@Override
	public void product() {
		System.out.println("BBBBBBBBBB");
	}
	
}

class CommonFactory {
	
	public IProduct createProduct(String name){
		if("A".equals(name)){
			return new ProductA();
		}else {
			return new ProductB();
		}
	}
}
