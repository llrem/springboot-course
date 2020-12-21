package com.yu.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;

@Data
@AllArgsConstructor
@TableName("notice")
public class notice {
    private int id;
    private String title;
    private String context;
    private String date;
}
