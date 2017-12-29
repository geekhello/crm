package com.crm.web.action.test.proxytest;

import java.lang.reflect.Method;

import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

public class CglibProxy implements MethodInterceptor{

	@Override
	public Object intercept(Object obj, Method method, Object[] args,
			MethodProxy methodProxy) throws Throwable {
		System.out.println("do begin:"+methodProxy.getSuperName());
		Object result = methodProxy.invokeSuper(obj, args);
		System.out.println("do after:"+methodProxy.getSuperName());
		return result;
	}

}
