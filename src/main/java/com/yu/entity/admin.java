package com.yu.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class admin {
    @JsonProperty(value = "username")
    private String name;
    private String password;
}
