package com.taobao.mq.rocketmq.base.order;

import com.taobao.common.Html;
import org.apache.rocketmq.client.consumer.DefaultMQPushConsumer;
import org.apache.rocketmq.client.consumer.listener.ConsumeOrderlyContext;
import org.apache.rocketmq.client.consumer.listener.ConsumeOrderlyStatus;
import org.apache.rocketmq.client.consumer.listener.MessageListenerOrderly;
import org.apache.rocketmq.common.message.MessageExt;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * @author DoDayum
 * @date 2021/3/28 18:22
 */
public class Consumer {
    static Html html = Html.getInstance();

    public static void main(String[] args) throws Exception {
        DefaultMQPushConsumer consumer = new DefaultMQPushConsumer(html.getProducerGroup());
        consumer.setNamesrvAddr(html.getNamespace());
        consumer.subscribe(html.getTopic(), "*");
        consumer.registerMessageListener(new MessageListenerOrderly() {
            /**
             *
             * @param list
             * @param consumeOrderlyContext
             * @return ConsumeOrderlyStatus
             */
            @Override
            public ConsumeOrderlyStatus consumeMessage(List<MessageExt> list, ConsumeOrderlyContext consumeOrderlyContext) {
                for (MessageExt msg : list) {
                    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
                    String time = dateFormat.format(new Date());
                    System.out.println("消费到消息,时间\t" + time);
                    System.out.println("消费消息内容" + new String(msg.getBody()) + "\t线程号:" + Thread.currentThread().getName());
//                    System.out.println("consumeOrderlyContext:"+ JSON.toJSONString(consumeOrderlyContext));
                }
                return ConsumeOrderlyStatus.SUCCESS;
            }
        });
        consumer.start();
        System.out.println("消费者启动");
    }
}
