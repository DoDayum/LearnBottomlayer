package com.taobao.mq.rocketmq.base.producer;

import com.alibaba.fastjson.JSON;
import com.taobao.common.Html;
import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.common.message.Message;

import java.util.concurrent.TimeUnit;

/**
 * 发送单向消息
 *
 * @author DoDayum
 * @date 2021/3/28 14:45
 */
public class OneWayProducer {


    static Html html = Html.getInstance();

    public static void main(String[] args) throws Exception {
        DefaultMQProducer producer = new DefaultMQProducer(html.getProducerGroup());
        producer.setNamesrvAddr(html.getNamespace());
        producer.start();
        for (int i = 0; i < 10; i++) {
            /**
             * 消息主题
             * 消息的tag
             * 消息内容
             */
            byte[] body = ("hello" + i).getBytes();
            Message msg = new Message(html.getTopic(), html.getTags(), body);
            producer.sendOneway(msg);
            System.out.printf("消息已发送%s%n", JSON.toJSONString(msg));
            TimeUnit.SECONDS.sleep(1L);
        }
        producer.shutdown();
        System.out.println("发送者已关闭");
    }

}
