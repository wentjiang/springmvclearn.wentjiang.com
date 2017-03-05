package com.wentjiang.springmvclearn.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

    Logger logger = LoggerFactory.getLogger(getClass());

    @ResponseBody
    @RequestMapping("converter")
    public String testConverter(Date date) {
        System.out.println(date.toString());
        return "ok";
    }

    @ResponseBody
    @RequestMapping("")
    public String test(){
        logger.info("test");
        return "test";
    }
}
