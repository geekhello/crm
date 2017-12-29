package com.crm.web.action.test.activemq;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.Message;
import javax.jms.MessageConsumer;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.apache.activemq.ActiveMQConnectionFactory;

public class CopyOfJMSConsumer {

	public static void main(String[] args) {
		// 连接工厂，生产一个消息连接
		ConnectionFactory connectionFactory = null;
		// 消息连接，创建一个消息会话
		Connection conn = null;
		// 会话，一次消息通信线程
		Session session = null;
		// 发送消息目的地
		Destination destination = null;
		// 消息消费者
		MessageConsumer consumer = null;
		
		try {
			connectionFactory = new ActiveMQConnectionFactory(MQConstant.USER, MQConstant.PASS, MQConstant.BROKEN_URL);
			conn = connectionFactory.createConnection();
			conn.start();
			session = conn.createSession(false, Session.AUTO_ACKNOWLEDGE);
			//destination = session.createQueue("queue_message");
			destination = session.createTopic("topic1");
			consumer = session.createConsumer(destination);
			consumer.setMessageListener(new JMSListener());
		}catch(Exception e) {
			
		}
	}
}
