package com.yu.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@TableName("user_pwd")
@AllArgsConstructor
public class user {
    @TableId(value = "id")
    private String username;
    private String password;
}
