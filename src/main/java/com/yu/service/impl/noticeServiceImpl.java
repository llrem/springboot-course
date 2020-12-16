package com.yu.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yu.entity.notice;
import com.yu.mapper.noticeMapper;
import com.yu.service.noticeService;
import org.springframework.stereotype.Service;

@Service
public class noticeServiceImpl extends ServiceImpl<noticeMapper, notice> implements noticeService {
}
