package com.qfedu.car.common.vo;

import com.qfedu.car.common.result.ResultCode;
import lombok.Data;

/**
 * @author FYY
 * @date 2019/12/10 0010 下午 13:57
 */

@Data
public class R {
    private int code;
    private String msg;
    private Object data;

    public static R setR(int code, String msg, Object data) {
        R r = new R();
        r.setCode(code);
        r.setMsg(msg);
        r.setData(data);
        return r;
    }

    public static R OK(Object data) {
        return setR(ResultCode.OK.getVal(),"OK",data);
    }
    public static R OK() {
        return setR(ResultCode.OK.getVal(),"OK",null);
    }
    public static R fail(){
        return setR(ResultCode.ERROR.getVal(),"Error",null);
    }
    public static R fail(String msg){
        return setR(ResultCode.ERROR.getVal(),msg,null);
    }
}
