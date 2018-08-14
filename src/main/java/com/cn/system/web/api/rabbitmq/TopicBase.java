package com.cn.system.web.api.rabbitmq;

import lombok.Data;

/**
 * Created by robin on 2018/5/23.
 */
@Data
public class TopicBase {
    private String context;//文本信息
    private String routeKey;//标识key
    private String exchange;//路由
}
