package com.crm.web.action.test.proxytest;

import java.lang.reflect.Proxy;

import org.springframework.cglib.proxy.Enhancer;

public class ProxyDemoTest {

	public static void main(String[] args){
		// jdk代理
		System.out.println("======JDK代理");
		ZInterface zi = new ZImpl();
		ZInterface proxy =  (ZInterface)Proxy.newProxyInstance(zi.getClass().getClassLoader(), zi.getClass().getInterfaces(), new ZPorxy(zi));
		System.out.println("代理类名称："+proxy);
		proxy.doThing();
		proxy.doElse("haha");
		
		
		System.out.println("======CGLIB代理");
		Enhancer en = new Enhancer();
		en.setSuperclass(ZImpl.class);
		en.setCallback(new CglibProxy());
		
		ZInterface cgProxy = (ZInterface)en.create();
		System.out.println("代理类名称："+cgProxy);
		cgProxy.doThing();
		cgProxy.doElse("haha");
	}
}
