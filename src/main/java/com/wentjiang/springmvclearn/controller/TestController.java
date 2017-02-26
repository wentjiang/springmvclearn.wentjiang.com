package com.wentjiang.springmvclearn.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;

/**
 * Created by wentj on 2017/2/26.
 */
@Controller
@RequestMapping("test")
public class TestController {

    @ResponseBody
    @RequestMapping("converter")
    public String testConverter(Date date){
        System.out.println(date.toString());
        return "ok";
    }
}
