package com.taobao.common;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * start mqbroker.cmd -n 127.0.0.1:9876 autoCreateTopicEnable=true
 *
 * @author DoDayum
 * @date 2021/3/28 14:06
 */
@Data
@Accessors(chain = true)
public class Html {

    private String namespace = "localhost:9876";
    private String topic = "base";
    private String tags = "tag1";
    private String producerGroup = "group1";

    private static Html html = new Html();

    public static Html getInstance(){
        return html;
    }

}
