package com.qfedu.car.util;

import com.aliyuncs.CommonRequest;
import com.aliyuncs.CommonResponse;
import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.exceptions.ServerException;
import com.aliyuncs.http.MethodType;
import com.aliyuncs.profile.DefaultProfile;

/**
 * @program: CarSys
 * @description:
 * @author: Feri
 * @create: 2019-12-11 11:41
 */

/**
 * 发送短信验证码
 */
public class AliSmsUtil {

    /**
     * 发送短信验证码 有效期10分钟
     * @param code 验证码 6位*/
    public static void sendSmsCode(String phone, int code){
        // 可改
        DefaultProfile profile = DefaultProfile.getProfile("cn-hangzhou", "LTAIhTvqTSmlmjeQ", "X7X9w0Ck5GEIWgP9tl0Q6sgmFjQuMv");
        IAcsClient client = new DefaultAcsClient(profile);

        CommonRequest request = new CommonRequest();
        request.setMethod(MethodType.POST);
        request.setDomain("dysmsapi.aliyuncs.com");
        request.setVersion("2017-05-25");
        request.setAction("SendSms");
        request.putQueryParameter("RegionId", "cn-hangzhou");
        request.putQueryParameter("PhoneNumbers", phone);
        request.putQueryParameter("SignName", "来自邢朋辉的短信");
        request.putQueryParameter("TemplateCode", "SMS_115250125");
        request.putQueryParameter("TemplateParam", "{\"code\":\""+code+"\"}");
        try {
            CommonResponse response = client.getCommonResponse(request);
            System.out.println(response.getData());
        } catch (ServerException e) {
            e.printStackTrace();
        } catch (ClientException e) {
            e.printStackTrace();
        }
    }

}
