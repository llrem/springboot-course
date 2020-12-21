package com.yu.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.yu.common.result;
import com.yu.entity.admin;
import com.yu.entity.course;
import com.yu.entity.course_notice;
import com.yu.entity.notice;
import com.yu.service.courseService;
import com.yu.service.course_noticeService;
import com.yu.service.noticeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;


@RestController
public class courseController {
    @Autowired
    com.yu.service.course_noticeService course_noticeService;
    @Autowired
    noticeService noticeService;

    @PostMapping("/course/notice")
    public result notice(@RequestBody Map<String,String> courseId){
        QueryWrapper<course_notice> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("course_id",courseId.get("id"));
        List<course_notice> course_noticeList = course_noticeService.list(queryWrapper);

        if(course_noticeList.isEmpty()){
            return result.failure("没有通知",null);
        }
        ArrayList<Integer> list = new ArrayList<>();
        for(course_notice course_notice:course_noticeList){
            int noticeId = course_notice.getNoticeId();
            list.add(noticeId);
        }

        QueryWrapper<notice> queryWrapper2 = new QueryWrapper<>();
        queryWrapper2.in("id",list);
        List<notice> noticeList = noticeService.list(queryWrapper2);

        return result.success("admin",noticeList);
    }
}
