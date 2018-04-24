package com.cn.system.web.api.ht;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by robin.Li on 2018/4/24.
 */
@Controller
@RequestMapping("statis/")
public class DataStatisController {
    @RequestMapping("tolist")
    public String tolist(){
        return "statis/statis_list";
    }
}
