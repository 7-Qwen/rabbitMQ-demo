package com.wen.rabbitMQ.util;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * @author: 7wen
 * @Date: 2023-03-29 20:27
 * @description:
 */
public class RabbitMQUtils {
    private static ConnectionFactory connectionFactory = new ConnectionFactory();
    /**
     * 获取通道
     */
    public static Channel getChannel() {
        connectionFactory.setHost("10.0.0.129");
        connectionFactory.setUsername("admin");
        connectionFactory.setPassword("123");
        Channel channel = null;
        try {
            channel =  connectionFactory.newConnection().createChannel();
        } catch (IOException | TimeoutException e) {
            e.printStackTrace();
        }
        return channel;
    }
}
