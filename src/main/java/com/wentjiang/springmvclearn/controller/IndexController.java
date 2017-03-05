package com.wentjiang.springmvclearn.controller;

import com.wentjiang.springmvclearn.annotation.NeedUserLogin;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by wentj on 2017/2/22.
 */
@Controller
@RequestMapping("")
public class IndexController {

    Logger logger = LoggerFactory.getLogger(getClass());

    @NeedUserLogin
    @ResponseBody
    @RequestMapping("index")
    public String index() {
        return "OK";
    }

    @RequestMapping("/500")
    public String error500() {
        return "common/500";
    }

    @RequestMapping("/404")
    public String error404() {
        return "common/404";
    }
}
