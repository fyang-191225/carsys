package com.qfedu.car.sms.service;

import com.qfedu.car.common.vo.R;
import com.qfedu.car.dto.PhoneCodeDto;

/**
 * @author FYY
 * @date 2019/12/11 0011 下午 21:18
 */

public interface SmsService {
    /**
     * 发送验证码
     * @param phone
     * @return
     */
    R sendSmsCode(String phone);

    /**
     * 校验验证码
     * @param codeDto
     * @return
     */
    R checkSmsCode(PhoneCodeDto codeDto);


}
