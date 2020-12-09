package com.yu.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yu.entity.course;
import com.yu.mapper.courseMapper;
import com.yu.service.courseService;
import org.springframework.stereotype.Service;

@Service
public class courseServiceImpl extends ServiceImpl<courseMapper,course> implements courseService{

}
