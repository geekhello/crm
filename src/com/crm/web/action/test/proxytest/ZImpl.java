package com.crm.web.action.test.proxytest;

public class ZImpl implements ZInterface{

	@Override
	public void doThing() {
		System.out.println("do thing");
		
	}

	@Override
	public void doElse(String name) {
		// TODO Auto-generated method stub
		System.out.println("do else:"+name);
	}

}
