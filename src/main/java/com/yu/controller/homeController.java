package com.yu.controller;

import com.yu.common.result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class homeController {
    @Autowired

    @PostMapping("/home")
    public result course(){

        return result.failure("home",null);
    }
}
