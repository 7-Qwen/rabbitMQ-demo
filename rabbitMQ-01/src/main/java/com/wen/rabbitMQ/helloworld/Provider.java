package com.wen.rabbitMQ.helloworld;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.concurrent.TimeoutException;

/**
 * @author: 7wen
 * @Date: 2023-03-29 17:14
 * @description:
 */
public class Provider {
    private static final String QUEUE_MESSAGE = "message";

    public static void main(String[] args) throws IOException, TimeoutException {
        ConnectionFactory cf = new ConnectionFactory();
        cf.setHost("10.0.0.129");
        cf.setUsername("admin");
        cf.setPassword("123");
        Connection connection = cf.newConnection();
        Channel channel = connection.createChannel();
        channel.queueDeclare(QUEUE_MESSAGE, false, false, false, null);
        String msg = "hello world123";
        //发送消息
        channel.basicPublish("", QUEUE_MESSAGE, null, msg.getBytes(StandardCharsets.UTF_8));
        System.out.println("消息发送完毕");
    }
}
