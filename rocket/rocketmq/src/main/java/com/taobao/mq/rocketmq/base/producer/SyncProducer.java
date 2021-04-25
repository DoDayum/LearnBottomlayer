package com.taobao.mq.rocketmq.base.producer;

import com.alibaba.fastjson.JSON;
import com.taobao.common.Html;
import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.client.producer.SendStatus;

import java.util.concurrent.TimeUnit;
import org.apache.rocketmq.common.message.Message;

/**
 * 发送同步消息
 *
 * @author DoDayum
 * @date 2021/3/28 14:05
 */
public class SyncProducer {

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
            SendResult result = producer.send(msg);
            SendStatus sendStatus = result.getSendStatus();//状态
            String msgId = result.getMsgId();//消息ID
            Integer queueId = result.getMessageQueue().getQueueId();//队列ID

            System.out.printf("状态:%s,消息Id:%s,队列ID:%s,JSON:%s%n", sendStatus, msgId, queueId, JSON.toJSONString(result));
            TimeUnit.SECONDS.sleep(1L);
        }
        producer.shutdown();
        System.out.println("发送者已关闭");
    }
}
