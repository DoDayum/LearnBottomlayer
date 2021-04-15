package com.taobao.mq.rocketmq.base.order;

import com.taobao.common.Html;
import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.MessageQueueSelector;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.common.message.MessageQueue;

import java.nio.charset.StandardCharsets;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * @author DoDayum
 * @date 2021/3/28 18:04
 */
public class Producer {


    static Html html = Html.getInstance();

    public static void main(String[] args) throws Exception {
        DefaultMQProducer producer = new DefaultMQProducer(html.getProducerGroup());
        producer.setNamesrvAddr(html.getNamespace());
        producer.start();

        List<OrderStep> orderSteps = OrderStep.buildOrders();
        for (int i = 0; i < orderSteps.size(); i++) {
            String body = orderSteps.get(i) + "";
            Message msg = new Message(html.getTopic(), html.getTags(), "i" + i, body.getBytes(StandardCharsets.UTF_8));
            /*
             * 消息
             * 消息队列选择器
             * 选择的队列的业务标识
             */
            SendResult result = producer.send(msg, new MessageQueueSelector() {
                /**
                 *
                 * @param list 队列集合
                 * @param msg 消息对象
                 * @param arg 参数
                 * @return MessageQueue
                 */
                @Override
                public MessageQueue select(List<MessageQueue> list, Message msg, Object arg) {
                    long orderId = (long) arg;
                    long index = orderId % list.size();
                    return list.get(Math.toIntExact(index));
                }
            }, orderSteps.get(i).getOrderId());

            System.out.println("发送结果" + result);
        }
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        String time = dateFormat.format(new Date());
        System.out.println("生产完毕,时间\t" + time);
        producer.shutdown();
        System.out.println("发送者已关闭");

    }

}
