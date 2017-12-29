package com.crm.utils;
 
import com.crm.domain.CstCustomer;
 
public class BeanFactory
{
	public static CstCustomer getBean()
		{
			return new CstCustomer();
		}
}

