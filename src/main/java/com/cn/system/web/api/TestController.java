package com.cn.system.web.api;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by robin on 2018/4/18.
 */
@Controller
public class TestController {
    @RequestMapping("/index")
    public String index(){
        System.out.println("index");
        return "welcome";
    }

    @RequestMapping("/test")
    public String test(){
        return "index";
    }
}
