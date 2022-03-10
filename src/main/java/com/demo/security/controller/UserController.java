package com.demo.security.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Auther guozhiyang
 * @Date 2022-03-10 15:16
 */
@Controller
public class UserController {


    @GetMapping("/hello")
    public String hello() {
        return "demo-sign";
    }

    @GetMapping("/gzy/test")
    @ResponseBody
    public String gztTest() {
        return "hello yangzai";
    }

}
