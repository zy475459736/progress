package com.zhongyi.satan.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by zhongyi on 2017/12/14.
 */
@Controller
@RequestMapping(value = "/test")
public class SimpleController {
    @ResponseBody
    @RequestMapping(value = "/test", method = RequestMethod.GET)
    public String hello(){
        return "hello world";
    }
}
