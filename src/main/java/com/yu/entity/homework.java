package com.yu.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("homework")
public class homework {
    private String id;
    private String title;
    private String context;
}
