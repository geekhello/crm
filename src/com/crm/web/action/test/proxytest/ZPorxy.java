package com.crm.web.action.test.proxytest;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class ZPorxy implements InvocationHandler{
	// 被代理的对象
	private Object proxyed;

	// 构造函数引入被代理对象
	public ZPorxy(Object proxyed){
		this.proxyed = proxyed;
	}
	@Override
	public Object invoke(Object proxy, Method method, Object[] args)
			throws Throwable {
		// TODO Auto-generated method stub
		if("doElse".equals(method.getName())){
			System.out.println("============");
		}
		System.out.println("do begin");
		Object result =  method.invoke(proxyed, args);
		System.out.println("do after");
		return result;
	}

}
