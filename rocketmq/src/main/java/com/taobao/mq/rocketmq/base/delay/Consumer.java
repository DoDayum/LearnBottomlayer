package com.taobao.mq.rocketmq.base.delay;

import com.taobao.common.Html;
import org.apache.rocketmq.client.consumer.DefaultMQPullConsumer;
import org.apache.rocketmq.client.consumer.DefaultMQPushConsumer;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author DoDayum
 * @date 2021/4/3 15:42
 */
public class Consumer {

    static Html html = Html.getInstance();

    public static void main(String[] args) throws Exception {

//        DefaultMQPushConsumer consumer = new DefaultMQPushConsumer(html.getProducerGroup());
//        consumer.setNamesrvAddr(html.getNamespace());
//        consumer.subscribe(html.getTopic(),"*");


        Map<String,String> a = new ConcurrentHashMap<>();



    }

}
