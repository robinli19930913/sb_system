package com.cn.system.web.api;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by robin.Li on 2018/4/19.
 */
@Controller
public class LoginApi {
    @RequestMapping("/")
    public String index() {
        return "login";
    }
}
