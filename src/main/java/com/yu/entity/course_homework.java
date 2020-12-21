package com.yu.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@TableName("course_homework")
@AllArgsConstructor
public class course_homework {
    @TableField("course_id")
    private int courseId;
    @TableField("homework_id")
    private int noticeId;
}
