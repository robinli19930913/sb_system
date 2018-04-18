package com.cn.system.web.service;

import com.cn.system.dao.mapper.UserMapperExt;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by robin on 2018/4/18.
 */
@Service
public class TestService {
    @Resource
    UserMapperExt userMapperExt;

    public List getUserInfos(String name){
        return userMapperExt.selectUserInfos(name);
    }
}
