package com.xu.xu7x.bean;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author xuhongda on 2019/7/3
 * pojo
 * xu7x
 */
@Data
@Component
@ConfigurationProperties(prefix = "com.xu")
public class ButtonType {

    /**
     * 文件处理方式
     */
    private String readType;
    /**
     * 特殊主题
     */
    private String topic;

}
