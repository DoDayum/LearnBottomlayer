package com.taobao.a;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * @author DoDayum
 * @date 2021/3/27 0:18
 */
public class Producer {

    private static final String routingKey = "hello";

    //发送消息
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
         * 交换机名称
         * 路由名称
         * 配置类型
         *
         */
        //TODO 发送消息
        String body = "hello rabbitMq";
        for (int i = 0; i < 10; i++) {
            channel.basicPublish("", routingKey, null, (body+i).getBytes());
        }

        channel.close();
        connection.close();
    }

}
