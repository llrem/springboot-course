package com.yu.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@TableName("course")
@NoArgsConstructor
@AllArgsConstructor
public class course {
    private int id;
    private String name;
    @TableField("admin_id")
    private String adminId;
    @TableField("class")
    private String className;
    private int credit;
    @TableField("class_hour")
    private int classHour;
    private String state;
}
