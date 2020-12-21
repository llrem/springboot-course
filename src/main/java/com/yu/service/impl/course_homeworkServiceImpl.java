package com.yu.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yu.entity.course_homework;
import com.yu.mapper.course_homeworkMapper;
import com.yu.service.course_homeworkService;
import org.springframework.stereotype.Service;

@Service
public class course_homeworkServiceImpl extends
        ServiceImpl<course_homeworkMapper, course_homework> implements course_homeworkService {
}
