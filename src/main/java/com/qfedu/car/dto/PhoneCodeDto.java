package com.qfedu.car.dto;

import lombok.Data;

/**
 * @author FYY
 * @date 2019/12/11 0011 下午 21:34
 */

@Data
public class PhoneCodeDto {
    // 电话
    private String phone;
    // 验证码
    private int code;
}
