package com.taobao.mq.rocketmq.base.producer;

import com.alibaba.fastjson.JSON;
import com.taobao.common.Html;
import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.SendCallback;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.common.message.Message;

import java.util.concurrent.TimeUnit;

/**
 * 发送异步消息
 *
 * @author DoDayum
 * @date 2021/3/28 14:33
 */
public class AsyncProducer {

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
            producer.send(msg, new SendCallback() {
                @Override
                public void onSuccess(SendResult sendResult) {
                    System.out.printf("发送成功%s%n",JSON.toJSONString(msg));
                }
                @Override
                public void onException(Throwable throwable) {
                    System.out.printf("发送失败%s,失败原因：%s%n",JSON.toJSONString(msg),JSON.toJSONString(throwable));
                }
            });
            TimeUnit.SECONDS.sleep(1L);

        }
        producer.shutdown();
        System.out.println("发送者已关闭");
    }

}
