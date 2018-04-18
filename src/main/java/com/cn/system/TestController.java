package com.cn.system;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by robin on 2018/4/18.
 */
@Controller
public class TestController {
    @RequestMapping("/index")
    public String index(){
        return "welcome";
    }

    @RequestMapping("/test")
    public String test(){
        return "test";
    }
}
