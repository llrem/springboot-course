package com.yu.service.impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yu.entity.admin;
import com.yu.mapper.adminMapper;
import com.yu.service.adminService;
import org.springframework.stereotype.Service;

@Service
public class adminServiceImpl extends ServiceImpl<adminMapper, admin> implements adminService {
    @Override
    public admin getOne(Wrapper<admin> queryWrapper, boolean throwEx) {
        return super.getOne(queryWrapper, throwEx);
    }
}
