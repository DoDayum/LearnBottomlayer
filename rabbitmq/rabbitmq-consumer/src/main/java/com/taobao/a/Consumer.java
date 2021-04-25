package com.taobao.a;

import com.rabbitmq.client.*;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * @author DoDayum
 * @date 2021/3/27 0:36
 */
public class Consumer {

    private static final String routingKey = "hello";

    public static void main(String[] args) throws IOException, TimeoutException {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("121.199.61.185");
        factory.setPort(5672);
        factory.setVirtualHost("/itcast");
        factory.setUsername("baiyu");
        factory.setPassword("baiyu");
        Connection connection = factory.newConnection();
        Channel channel = connection.createChannel();
        /**
         * 队列名称
         * 是否持久化
         * 是否只能有一个消费者监听
         * 是否自动删除
         * 参数
         */
        channel.queueDeclare(routingKey, true, false, false, null);
        /**
         * 队列名称
         * 是否自动确认
         * 回调对象
         */
        //TODO 接收消息
        DefaultConsumer consumer = new DefaultConsumer(channel){
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body){
//                System.out.println(consumerTag);
//                System.out.println(envelope);
//                System.out.println(properties);
                System.out.println(new String(body));
            }
        };
        channel.basicConsume(routingKey,true,consumer);
    }

}
