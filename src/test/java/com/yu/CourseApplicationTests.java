package com.yu;

import com.yu.entity.notice;
import com.yu.service.noticeService;
import org.junit.jupiter.api.Test;
import org.omg.PortableInterceptor.INACTIVE;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

@SpringBootTest
class CourseApplicationTests {
    @Autowired
    noticeService noticeService;

    @Test
    void contextLoads() {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
    }
}
