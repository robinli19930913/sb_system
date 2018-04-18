package com.cn.system.dao.mapper;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * Created by robin on 2018/4/18.
 */
public interface UserMapperExt {
    /*明星列表${name} #{name} 后者会把‘ 当做参数*/
    @Select({"<script>select nick_name nickName from star_info " +
            "<if test='name != null and name != \"\" '>"+
            "  where nick_name like '%${name}%'"+
            "</if>" +
            " limit 20</script>"})
    List<String> selectUserInfos(@Param(value = "name") String name);//@Param(value = "name") 或者 ${_name} mybatis 解析报错 参数不能geter到 class String ****
}
