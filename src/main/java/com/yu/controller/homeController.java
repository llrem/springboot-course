package com.yu.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.yu.common.result;
import com.yu.entity.admin;
import com.yu.entity.course;
import com.yu.entity.student;
import com.yu.service.courseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
public class homeController {
    @Autowired
    courseService courseService;

    @PostMapping("/home/admin")
    public result course(@RequestBody admin admin){
        QueryWrapper<course> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("admin_id",admin.getId());
        List<course> courseList = courseService.list(queryWrapper);
        return result.success("admin",courseList);
    }

    @PostMapping("/home/student")
    public result courses(@RequestBody student student){
        QueryWrapper<course> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("class",student.getClassId());
        List<course> courseList = courseService.list(queryWrapper);
        return result.failure("student",courseList);
    }

    @PostMapping("/home/addCourse")
    public result addCourse(@RequestBody Map<String,Map<String,String>> map){
        Map<String,String> courseInfo = map.get("courseInfo");
        Map<String,String> adminInfo = map.get("admin");
        String id="1000";
        for(int i=1000;i<10000;i++){
            id = i+"";
            if(courseService.getById(id)==null){
                break;
            }
            else{
                i++;
            }
        }
        course course = new course(id,courseInfo.get("name"),adminInfo.get("id"),adminInfo.get("classId"),
                Integer.parseInt(courseInfo.get("credit")),Integer.parseInt(courseInfo.get("classHour")));
        courseService.save(course);
        return result.success("admin","success");
    }

    @PostMapping("/notice/admin")
    public result notice(@RequestBody admin admin){
        return null;
    }

    @PostMapping("/notice/student")
    public result notice(@RequestBody student student){
        return null;
    }
}
