package com.crm.web.action.test.activemq;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.MessageProducer;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.apache.activemq.ActiveMQConnectionFactory;

public class JMSProducer {

	public static void main(String[] args) {
		// 连接工厂，生产一个消息连接
		ConnectionFactory connectionFactory = null;
		// 消息连接，创建一个消息会话
		Connection conn = null;
		// 会话，一次消息通信线程
		Session session = null;
		// 发送消息目的地
		Destination destination = null;
		// 消息发送者
		MessageProducer producer = null;
		connectionFactory = new ActiveMQConnectionFactory(MQConstant.USER, MQConstant.PASS, MQConstant.BROKEN_URL);
		try {
			conn = connectionFactory.createConnection();
			conn.start();
			session = conn.createSession(true, Session.AUTO_ACKNOWLEDGE);
			destination = session.createQueue("queue_message1");// 创建消息队列
			producer = session.createProducer(destination);// 创建消息生产者
			sendMessage(producer, session);
			session.commit();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void sendMessage(MessageProducer producer, Session session) throws Exception{
		for(int i=0;i<MQConstant.MESSAGE_NUM;i++){
			TextMessage message = session.createTextMessage("ActiveMQ发送的消息"+i);
			System.out.println("第"+i+"次发送消息");
			producer.send(message);
		}
	}
}
