package com.wen.rabbitMQ.helloworld;

import com.rabbitmq.client.*;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * @author: 7wen
 * @Date: 2023-03-29 17:14
 * @description:
 */
public class Consumer {
    private static final String QUEUE_MESSAGE = "message";

    public static void main(String[] args) throws IOException, TimeoutException {
        ConnectionFactory connectionFactory = new ConnectionFactory();
        connectionFactory.setHost("10.0.0.129");
        connectionFactory.setUsername("admin");
        connectionFactory.setPassword("123");
        Connection connection = connectionFactory.newConnection();
        Channel channel = connection.createChannel();
        DeliverCallback deliverCallback = (v1, msg) -> {
            System.out.println(new String(msg.getBody()).toString());
        };
        CancelCallback cancelCallback = v1 -> {
            System.out.println("消息中断,无法消费.....");
        };
        System.out.println("等待接收消息...");
        channel.basicConsume(QUEUE_MESSAGE, deliverCallback, cancelCallback);
    }
}
