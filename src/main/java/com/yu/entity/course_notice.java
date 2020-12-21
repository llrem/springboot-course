package com.yu.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@TableName("course_notice")
@AllArgsConstructor
public class course_notice {
    @TableField("course_id")
    private int courseId;
    @TableField("notice_id")
    private int noticeId;
}
