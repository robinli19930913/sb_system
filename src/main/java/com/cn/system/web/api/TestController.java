package com.cn.system.web.api;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by robin on 2018/4/18.
 */
@Controller
public class TestController {
    private static final Logger log = LoggerFactory.getLogger(TestController.class);

    @RequestMapping("/index")
    public String index(){
        System.out.println("index");
        return "welcome";
    }

    @RequestMapping("/test")
    public String test(){
        log.error("log---index.......");
        System.out.println("index.......");
        return "index";
    }
    @RequestMapping("/test/test/test")
    public void test2(){
        System.out.println("index.......");
    }
    @RequestMapping("/test1")
    public ModelAndView test1(ModelAndView modelAndView){
        System.out.println("index.......");
        modelAndView.setViewName("index");
        return modelAndView;
    }
}
