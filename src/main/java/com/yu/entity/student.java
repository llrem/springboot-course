package com.yu.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class student {
    private String id;
    private String name;
    private int age;
    private String gender;
    private String classId;
    private String major;
    private String college;

}
