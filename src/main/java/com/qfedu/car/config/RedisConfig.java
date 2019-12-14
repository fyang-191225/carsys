package com.qfedu.car.config;

/**
 * @author FYY
 * @date 2019/12/11 0011 下午 21:51
 */

public class RedisConfig {
    //记录令牌
    public static final String TOKEN_KEY="token:";//后面追加手机号
    public static final int TOEKN_TIME=1800;//30分钟

    //记录短信验证码
    public static final String SMS_CODE="sms:code:";//跟上手机号
    public static final int SMSCODE_TIME=600;//10分钟
}
