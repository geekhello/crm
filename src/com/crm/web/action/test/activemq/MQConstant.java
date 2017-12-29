package com.crm.web.action.test.activemq;

import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.command.ActiveMQMessage;

public class MQConstant {

	// 用户名
	public static final String USER = ActiveMQConnection.DEFAULT_USER;
	// 密码
	public static final String PASS = ActiveMQConnection.DEFAULT_PASSWORD;
	// url
	public static final String BROKEN_URL = "tcp://192.168.3.13:61616";
	// 消息数量
	public static final int MESSAGE_NUM = 5;
	
}
