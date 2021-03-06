package com.cn.system.dao.mapper;

import com.cn.system.dao.model.RolesMenu;
import com.cn.system.dao.model.RolesMenuExample;
import java.util.List;
import org.apache.ibatis.annotations.DeleteProvider;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.UpdateProvider;
import org.apache.ibatis.type.JdbcType;

public interface RolesMenuMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table roles_menu
     *
     * @mbg.generated Wed Mar 07 12:42:47 CST 2018
     */
    @SelectProvider(type=RolesMenuSqlProvider.class, method="countByExample")
    long countByExample(RolesMenuExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table roles_menu
     *
     * @mbg.generated Wed Mar 07 12:42:47 CST 2018
     */
    @DeleteProvider(type=RolesMenuSqlProvider.class, method="deleteByExample")
    int deleteByExample(RolesMenuExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table roles_menu
     *
     * @mbg.generated Wed Mar 07 12:42:47 CST 2018
     */
    @Insert({
        "insert into roles_menu (mid, rid)",
        "values (#{mid,jdbcType=BIGINT}, #{rid,jdbcType=BIGINT})"
    })
    int insert(RolesMenu record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table roles_menu
     *
     * @mbg.generated Wed Mar 07 12:42:47 CST 2018
     */
    @InsertProvider(type=RolesMenuSqlProvider.class, method="insertSelective")
    int insertSelective(RolesMenu record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table roles_menu
     *
     * @mbg.generated Wed Mar 07 12:42:47 CST 2018
     */
    @SelectProvider(type=RolesMenuSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="mid", property="mid", jdbcType=JdbcType.BIGINT),
        @Result(column="rid", property="rid", jdbcType=JdbcType.BIGINT)
    })
    List<RolesMenu> selectByExample(RolesMenuExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table roles_menu
     *
     * @mbg.generated Wed Mar 07 12:42:47 CST 2018
     */
    @UpdateProvider(type=RolesMenuSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") RolesMenu record, @Param("example") RolesMenuExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table roles_menu
     *
     * @mbg.generated Wed Mar 07 12:42:47 CST 2018
     */
    @UpdateProvider(type=RolesMenuSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") RolesMenu record, @Param("example") RolesMenuExample example);
}