package com.yu.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.yu.entity.user;
import com.yu.common.result;
import com.yu.service.adminService;
import com.yu.service.studentService;
import com.yu.service.userService;
import com.yu.utils.JwtUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpServletResponse;

@RestController
public class loginController {
    @Autowired
    userService userService;
    @Autowired
    JwtUtils jwtUtils;
    @Autowired
    studentService studentService;
    @Autowired
    adminService adminService;

    @PostMapping("/login")
    public result test2(@RequestBody user loginInfo, HttpServletResponse response){
        user user = userService.getById(loginInfo.getUsername());

        if (user == null) {
            throw new UnknownAccountException("账户不存在");
        }
        if(!loginInfo.getPassword().equals(user.getPassword())){
            return result.failure("用户名或密码错误",loginInfo);
        }

//        String jwt = jwtUtils.generateToken(user.getUsername());
//        response.setHeader("Authorization", jwt);
//        response.setHeader("Access-control-Expose-Headers", "Authorization");
        if(adminService.getById(loginInfo.getUsername())!=null){
            return result.success("admin",adminService.getById(loginInfo.getUsername()));
        }
        return result.success("student",studentService.getById(loginInfo.getUsername()));
    }
}
