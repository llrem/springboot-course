package com.yu.controller;

import com.yu.common.loginInfo;
import com.yu.common.result;
import com.yu.entity.admin;
import com.yu.entity.student;
import com.yu.mapper.adminMapper;
import com.yu.mapper.loginInfoMapper;
import com.yu.mapper.studentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;

@RestController
public class login {
    @Autowired
    adminMapper adminMapper;
    @Autowired
    loginInfoMapper loginInfoMapper;
    @Autowired
    studentMapper studentMapper;

    @PostMapping("/login")
    public result Verify(@RequestBody loginInfo loginInfo, HttpServletResponse response){
        admin admin = adminMapper.selectOne(null);
        loginInfo Info = loginInfoMapper.selectById(loginInfo.getId());
        student student = studentMapper.selectById(loginInfo.getId());

        if(admin.getName().equals(loginInfo.getId()) && admin.getPassword().equals(loginInfo.getPassword())){
            return result.success("admin",admin);
        }
        else if(Info!=null&&student!=null){
            if(Info.getId().equals(loginInfo.getId())&&Info.getPassword().equals(loginInfo.getPassword())){
                return result.success("student",student);
            }
        }
        return result.failure(400,"用户名或密码错误",admin);
    }

    @GetMapping("/loginOut")
    public result Verify2(){
        admin admin = adminMapper.selectOne(null);
        if(admin.getName().equals("admin") && admin.getPassword().equals("123456")){
            return result.success("admin",admin);
        }
        return result.failure(400,"用户名或密码错误",admin);
    }
}
