package com.easemob.robot;

import lombok.Data;

@Data
public class RobotQuestion {
    // 租户ID
    private int tenantId;
    // 业务相关预留字段
    private String theme;
    // session ID
    private String session_id;
    // 访客用户ID
    private String user_id;
    // 消息ID
    private String msg_id;
    // 用户问题
    private String question;
    // 业务场景相关预留字段
    private String service_id;

    //访客ip
    private String user_ip;

    // 渠道(weibo、weixin、webim、phone、app、rest)
    private String origin_type;

    private String channel_id;
    private String channel_name;
}
