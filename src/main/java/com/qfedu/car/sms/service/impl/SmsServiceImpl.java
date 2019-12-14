package com.qfedu.car.sms.service.impl;

import com.qfedu.car.common.vo.R;
import com.qfedu.car.config.RedisConfig;
import com.qfedu.car.dto.PhoneCodeDto;
import com.qfedu.car.sms.service.SmsService;
import com.qfedu.car.util.AliSmsUtil;
import com.qfedu.car.util.JedisUtil;
import com.qfedu.car.util.RandomUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author FYY
 * @date 2019/12/11 0011 下午 21:18
 */


@Service
public class SmsServiceImpl implements SmsService {

    @Autowired
    private JedisUtil jedisUtil;

    /**
     *
     * @param phone
     * @return
     */
    @Override
    public R sendSmsCode(String phone) {
        int code;
        //1、通过util类中jedisUtil 类中的checkKey 方法来判断指定的key 是否以过有效期，校验之前的验证码有没有失效
        if(jedisUtil.checkKey(RedisConfig.SMS_CODE+phone)) {
            // 验证码未失效的情况下 的三中方法
            //1、更改有效期 重新设置为10分钟
            code = Integer.parseInt(jedisUtil.getStr(RedisConfig.SMS_CODE + phone)); // 获取key中的验证码
            jedisUtil.setExpire(RedisConfig.SMS_CODE + phone, RedisConfig.SMSCODE_TIME); // 重新设置key 对应的值的有效期，利用热第三Config类中的方法设置

            //2、检测有效期剩余超过1半 不改变直接返回 小于一半 重新更新有效期

            //3、重新生成 把原来覆盖
        } else {
            // 验证码失效的情况下， 重新生成验证码， 调用util 包中RandomUtil 中的封装生成验证码的方法
            code = RandomUtil.createNum(4);
        }
        // 2. 调用util 包中的AliSmsUtil 配置类中的sendSmsCode(int code) 方法来发送短信
        AliSmsUtil.sendSmsCode(phone, code);
        // 3. 往redis 库中添加，对应的键即值和有效时间
        jedisUtil.addStr(RedisConfig.SMS_CODE + phone, code + "", RedisConfig.SMSCODE_TIME);
        return R.OK();
    }

    /**
     * 校验 验证码的有效性
     * @param codeDto 从前端获取得信息， 有验证码，以及电话号码
     * @return
     */
    @Override
    public R checkSmsCode(PhoneCodeDto codeDto) {
        System.out.println(codeDto.getPhone());
        System.out.println(codeDto.getCode());
        // 1. 校验验证码的有效性，通过checkkey方法
        if (jedisUtil.checkKey(RedisConfig.SMS_CODE+codeDto.getPhone())) {
            // 2. 校验是否正确， 即前端的传入的验证码，和存入到key 中的值

            if (codeDto.getCode() == Integer.parseInt(jedisUtil.getStr(RedisConfig.SMS_CODE+codeDto.getPhone()))) {
                return R.OK();
            }
        }
        return R.fail("校验失败");
    }
}
