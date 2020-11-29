package com.yu.controller;

import com.yu.common.result;
import com.yu.entity.admin;
import com.yu.mapper.adminMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class login {
    @Autowired
    adminMapper adminMapper;

    @GetMapping("/login")
    public result Verify(){
        admin admin = adminMapper.selectOne(null);
        if(admin.getName().equals("admin") && admin.getPassword().equals("123456")){
            return result.success(admin);
        }
        return result.failure(400,"用户名或密码错误",admin);
    }
}
