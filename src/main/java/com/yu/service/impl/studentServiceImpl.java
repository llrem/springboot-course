package com.yu.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yu.entity.student;
import com.yu.mapper.studentMapper;
import com.yu.service.studentService;
import org.springframework.stereotype.Service;


@Service
public class studentServiceImpl extends ServiceImpl<studentMapper, student> implements studentService {
}
