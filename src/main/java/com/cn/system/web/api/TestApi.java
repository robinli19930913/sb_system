package com.cn.system.web.api;

import com.cn.system.web.service.TestService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by robin on 2018/4/18.
 */
@Controller
@RequestMapping("/api/")
public class TestApi {
    @Resource
    TestService testService;

    @RequestMapping("test")
    @ResponseBody
    public List test(String name){
        return testService.getUserInfos(name);
    }
}
