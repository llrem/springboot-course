package com.yu.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
@TableName("homework")
public class homework {
    private String id;
    private String title;
    private String context;
    private String Date;
}
