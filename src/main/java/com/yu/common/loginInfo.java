package com.yu.common;

import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
@TableName("user_pwd")
public class loginInfo {
    @JsonProperty(value = "username")
    private String id;
    private String password;
}
