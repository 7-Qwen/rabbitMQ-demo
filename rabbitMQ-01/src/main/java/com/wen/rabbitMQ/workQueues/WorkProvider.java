package com.wen.rabbitMQ.workQueues;

import com.rabbitmq.client.Channel;
import com.wen.rabbitMQ.util.RabbitMQUtils;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

/**
 * @author: 7wen
 * @Date: 2023-03-29 20:47
 * @description:
 */
public class WorkProvider {
    private static final String QUEUE_MESSAGE = "message";

    public static void main(String[] args) throws IOException {
        //获取通道
        Channel channel = RabbitMQUtils.getChannel();
        //声明队列
        channel.queueDeclare(QUEUE_MESSAGE, false, false, false, null);
        //发送消息
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            System.out.println("准备发送消息");
            channel.basicPublish("", QUEUE_MESSAGE, null, scanner.next().getBytes(StandardCharsets.UTF_8));
        }
    }
}
