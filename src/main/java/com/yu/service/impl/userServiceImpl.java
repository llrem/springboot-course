package com.yu.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yu.entity.user;
import com.yu.mapper.userMapper;
import com.yu.service.userService;
import org.springframework.stereotype.Service;

@Service
public class userServiceImpl extends ServiceImpl<userMapper, user> implements userService {

}
