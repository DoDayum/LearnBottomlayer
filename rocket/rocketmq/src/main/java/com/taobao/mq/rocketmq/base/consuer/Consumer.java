package com.taobao.mq.rocketmq.base.consuer;

import com.taobao.common.Html;
import org.apache.rocketmq.client.consumer.DefaultMQPushConsumer;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyContext;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyStatus;
import org.apache.rocketmq.client.consumer.listener.MessageListenerConcurrently;
import org.apache.rocketmq.common.message.MessageExt;
import org.apache.rocketmq.common.protocol.heartbeat.MessageModel;

import java.util.List;

/**
 * @author DoDayum
 * @date 2021/3/28 14:55
 */
public class Consumer {

    static Html html = Html.getInstance();

    public static void main(String[] args) throws Exception {
        DefaultMQPushConsumer consumer = new DefaultMQPushConsumer(html.getProducerGroup());
        consumer.setNamesrvAddr(html.getNamespace());
        consumer.subscribe(html.getTopic(),html.getTags());
        consumer.setMessageModel(MessageModel.BROADCASTING);//设置消费者模式,默认负载均衡
        consumer.registerMessageListener(new MessageListenerConcurrently() {
            @Override
            public ConsumeConcurrentlyStatus consumeMessage(List<MessageExt> list, ConsumeConcurrentlyContext consumeConcurrentlyContext) {
                for (MessageExt messageExt : list) {
                    String body = new String(messageExt.getBody());
                    System.out.println(body);
                }
                return ConsumeConcurrentlyStatus.CONSUME_SUCCESS;
            }
        });
        consumer.start();
    }

}
