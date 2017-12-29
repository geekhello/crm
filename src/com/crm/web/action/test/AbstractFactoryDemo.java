package com.crm.web.action.test;

public class AbstractFactoryDemo {

	public static void main(String[] args) {
		IFactory factory = new BWMFactory();
		ICar car = factory.createBean();
		car.run();
	}
}

interface ICar {
	void run();
}

class BYD implements ICar {

	@Override
	public void run() {
		// TODO Auto-generated method stub
		System.out.println("byd run");
	}
	
}

class BWM implements ICar {

	@Override
	public void run() {
		// TODO Auto-generated method stub
		System.out.println("bwm run");
	}
	
}

interface IFactory{
	
	ICar createBean();
}

class BYDFactory implements IFactory {

	@Override
	public ICar createBean() {
		// TODO Auto-generated method stub
		return new BYD();
	}
	
}

class BWMFactory implements IFactory {

	@Override
	public ICar createBean() {
		// TODO Auto-generated method stub
		return new BWM();
	}
	
}
