package com.yu.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.yu.common.result;
import com.yu.entity.*;
import com.yu.service.courseService;
import com.yu.service.course_noticeService;
import com.yu.service.noticeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

@RestController
public class homeController {
    @Autowired
    courseService courseService;
    @Autowired
    noticeService noticeService;
    @Autowired
    course_noticeService course_noticeService;

    @PostMapping("/home/admin")
    public result courseAdmin(@RequestBody admin admin){
        QueryWrapper<course> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("admin_id",admin.getId());
        List<course> courseList = courseService.list(queryWrapper);

        List<course> courses = new ArrayList<>();
        for(course course:courseList){
            if(course.getState().equals("show")){
                courses.add(course);
            }
        }
        return result.success("admin",courses);
    }

    @PostMapping("/home/student")
    public result courseStudent(@RequestBody student student){
        QueryWrapper<course> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("class",student.getClassId());
        List<course> courseList = courseService.list(queryWrapper);
        return result.success("student",courseList);
    }

    @PostMapping("/home/addCourse")
    public result addCourse(@RequestBody Map<String,Map<String,String>> map){
        Map<String,String> courseInfo = map.get("courseInfo");
        Map<String,String> adminInfo = map.get("admin");
        System.out.println(courseInfo.get("classId"));
        course course = new course(0,courseInfo.get("name"),adminInfo.get("id"),courseInfo.get("classId"),
                Integer.parseInt(courseInfo.get("credit")),Integer.parseInt(courseInfo.get("classHour")),"show");
        courseService.save(course);
        return result.success("admin","success");
    }

    @PostMapping("/notice/admin")
    public result noticeAdmin(@RequestBody admin admin){
        List<notice> noticeList = noticeService.list();
        return result.success("admin",noticeList);
    }

    @PostMapping("/notice/student")
    public result noticeStudent(@RequestBody student student){
        //查询课程班级号等于学生班级的课程
        QueryWrapper<course> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("class",student.getClassId());
        List<course> courseList = courseService.list(queryWrapper);

        ArrayList<Integer> list = new ArrayList<>();
        for(course course:courseList){
            int id = course.getId();
            list.add(id);
        }

        //查询course_notice表中课程号等于上面查询到的课程集合
        QueryWrapper<course_notice> queryWrapper2 = new QueryWrapper<>();
        queryWrapper2.in("course_id",list);
        List<course_notice> course_noticeList = course_noticeService.list(queryWrapper2);

        list.clear();
        for(course_notice course_notice:course_noticeList){
            int id = course_notice.getNoticeId();
            list.add(id);
        }

        //查询notice
        QueryWrapper<notice> queryWrapper3 = new QueryWrapper<>();
        queryWrapper3.in("id",list);
        List<notice> noticeList = noticeService.list(queryWrapper3);

        return result.success("student",noticeList);
    }
}
