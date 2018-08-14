package com.cn.system.web.api.test;

import com.cn.system.web.apiversion.ApiVersion;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by robin on 2018/5/31.
 */
@ApiVersion("1.2")
@Controller
@RequestMapping("version/")
public class VersionTest {
    @RequestMapping("v")
    @ResponseBody
    void test(){
        System.out.println("1241242141");
    }
}
