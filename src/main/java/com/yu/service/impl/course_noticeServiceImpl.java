package com.yu.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yu.entity.course_notice;
import com.yu.mapper.course_noticeMapper;
import com.yu.service.course_noticeService;
import org.springframework.stereotype.Service;

@Service
public class course_noticeServiceImpl extends
        ServiceImpl<course_noticeMapper, course_notice> implements course_noticeService {

}
