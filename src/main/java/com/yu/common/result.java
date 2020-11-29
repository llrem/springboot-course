package com.yu.common;

import lombok.Data;
import java.io.Serializable;

@Data
public class result implements Serializable {
    private int code;
    private String msg;
    private Object data;

    public static result success(Object data){
        result result = new result();
        result.setCode(200);
        result.setMsg("success");
        result.setData(data);
        return result;
    }

    public static result failure(int code,String msg,Object data){
        result result = new result();
        result.setCode(code);
        result.setMsg(msg);
        result.setData(data);
        return result;
    }
}
