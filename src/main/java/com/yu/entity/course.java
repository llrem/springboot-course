package com.yu.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@TableName("course")
@AllArgsConstructor
public class course {
    private String id;
    private String name;
    @TableField("admin_id")
    private String adminId;
    @TableField("class")
    private String className;
    private int credit;
    @TableField("class_hour")
    private int classHour;
}
