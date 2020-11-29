package com.yu.controller;

import com.yu.common.result;
import com.yu.entity.admin;
import com.yu.mapper.adminMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;

@RestController
public class login {
    @Autowired
    adminMapper adminMapper;

    @GetMapping("/login")
    public result Verify(HttpServletResponse response){
        admin admin = adminMapper.selectOne(null);
        if(admin.getName().equals("admin") && admin.getPassword().equals("123456")){
            return result.success(admin);
        }
        return result.failure(400,"用户名或密码错误",admin);
    }

    @GetMapping("/loginOut")
    public result Verify2(){
        admin admin = adminMapper.selectOne(null);
        if(admin.getName().equals("admin") && admin.getPassword().equals("123456")){
            return result.success(admin);
        }
        return result.failure(400,"用户名或密码错误",admin);
    }
}
