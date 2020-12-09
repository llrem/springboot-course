package com.yu.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("course")
public class course {
    private String id;
    private String name;
    @TableField("admin_id")
    private String adminId;
    private String className;
    private int credit;
    @TableField("class_hour")
    private int classHour;
}
