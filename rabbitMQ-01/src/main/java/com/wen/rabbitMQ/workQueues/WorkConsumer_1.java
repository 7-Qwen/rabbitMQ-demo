package com.wen.rabbitMQ.workQueues;

import com.rabbitmq.client.CancelCallback;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.DeliverCallback;
import com.wen.rabbitMQ.util.RabbitMQUtils;

import java.io.IOException;

/**
 * @author: 7wen
 * @Date: 2023-03-29 20:32
 * @description:
 */
public class WorkConsumer_1 {
    private static final String QUEUE_MESSAGE = "message";

    public static void main(String[] args) throws IOException {
        //获取通道
        Channel channel = RabbitMQUtils.getChannel();
        //声明消费回调方法
        DeliverCallback deliverCallback = (v1, msg) -> {
            System.out.println("work2 --- 获取到了消息:" + new String(msg.getBody()).toString());
        };
        CancelCallback cancelCallback = v1 -> {
            System.out.println("消息出现中断,无法获取");
        };
        //消费消息
        channel.basicConsume(QUEUE_MESSAGE, true, deliverCallback, cancelCallback);
    }
}
