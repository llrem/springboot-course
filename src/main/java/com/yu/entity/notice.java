package com.yu.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("notice")
public class notice {
    private String id;
    private String title;
    private String context;
}
