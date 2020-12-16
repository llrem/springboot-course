package com.yu.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yu.entity.homework;
import com.yu.mapper.homeworkMapper;
import com.yu.service.homeworkService;
import org.springframework.stereotype.Service;

@Service
public class homeworkServiceImpl extends ServiceImpl<homeworkMapper, homework> implements homeworkService {
}
