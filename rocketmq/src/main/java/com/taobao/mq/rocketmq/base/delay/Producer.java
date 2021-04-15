package com.taobao.mq.rocketmq.base.delay;

import com.alibaba.fastjson.JSON;
import com.taobao.common.Html;
import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.client.producer.SendStatus;
import org.apache.rocketmq.common.message.Message;

import java.nio.charset.StandardCharsets;

/**
 * @author DoDayum
 * @date 2021/4/3 15:42
 */
public class Producer {

    static Html html = Html.getInstance();

    public static void main(String[] args) throws Exception {
        DefaultMQProducer producer = new DefaultMQProducer(html.getProducerGroup());
        producer.setNamesrvAddr(html.getNamespace());
        producer.start();

        for (int i = 10; i > 0; i--) {
            Message message = new Message(html.getTopic(), html.getTags(), ("hello " + i).getBytes(StandardCharsets.UTF_8));
            message.setDelayTimeLevel(5);
            SendResult result = producer.send(message);
            SendStatus sendStatus = result.getSendStatus();
            System.out.println("已发送【"+ JSON.toJSONString(sendStatus)+"】");
        }
        System.out.println("发送已完成");
        producer.shutdown();
        System.out.println("发送者已关闭");
    }

}
