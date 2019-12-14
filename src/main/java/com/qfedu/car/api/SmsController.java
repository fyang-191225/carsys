package com.qfedu.car.api;

import com.qfedu.car.common.vo.R;
import com.qfedu.car.dto.PhoneCodeDto;
import com.qfedu.car.sms.service.SmsService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author FYY
 * @date 2019/12/11 0011 下午 21:19
 */
@Api(value = "短信验证码", tags = "短信验证码")
@RestController
public class SmsController {

    @Autowired
    private SmsService smsService;

    /**
     * 发送短信
     * @param phone
     * @return
     */
    @ApiOperation(value = "发送短信验证码", notes = "发送短信验证码")
    @GetMapping("/api/sms/sendcode.do")
    private R sendSmsCode(String phone) {
        return smsService.sendSmsCode(phone);
    }

    /**
     * 校验
     * @param phoneCodeDto
     * @return
     */
    @ApiOperation(value = "实现校验验证码", notes = "实现校验验证码")
    @PostMapping("/api/sms/checkkey.do")
    private R checkSmsCode(@RequestBody PhoneCodeDto phoneCodeDto) {
        return smsService.checkSmsCode(phoneCodeDto);
    }

}
