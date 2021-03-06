package com.cn.system.dao.mapper;

import com.cn.system.dao.model.HtUser;
import com.cn.system.dao.model.HtUserExample;
import java.util.List;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.DeleteProvider;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.UpdateProvider;
import org.apache.ibatis.type.JdbcType;

public interface HtUserMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ht_user
     *
     * @mbg.generated Wed Mar 07 12:44:12 CST 2018
     */
    @SelectProvider(type=HtUserSqlProvider.class, method="countByExample")
    long countByExample(HtUserExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ht_user
     *
     * @mbg.generated Wed Mar 07 12:44:12 CST 2018
     */
    @DeleteProvider(type=HtUserSqlProvider.class, method="deleteByExample")
    int deleteByExample(HtUserExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ht_user
     *
     * @mbg.generated Wed Mar 07 12:44:12 CST 2018
     */
    @Delete({
        "delete from ht_user",
        "where user_id = #{userId,jdbcType=BIGINT}"
    })
    int deleteByPrimaryKey(Long userId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ht_user
     *
     * @mbg.generated Wed Mar 07 12:44:12 CST 2018
     */
    @Insert({
        "insert into ht_user (user_name, password, ",
        "type, nick_name, ",
        "true_name, del, ",
        "state, create_time, ",
        "update_time, fk_create_id, ",
        "fk_update_id, fk_create_name, ",
        "fk_update_name, phone)",
        "values (#{userName,jdbcType=VARCHAR}, #{password,jdbcType=VARCHAR}, ",
        "#{type,jdbcType=SMALLINT}, #{nickName,jdbcType=VARCHAR}, ",
        "#{trueName,jdbcType=VARCHAR}, #{del,jdbcType=SMALLINT}, ",
        "#{state,jdbcType=SMALLINT}, #{createTime,jdbcType=TIMESTAMP}, ",
        "#{updateTime,jdbcType=TIMESTAMP}, #{fkCreateId,jdbcType=BIGINT}, ",
        "#{fkUpdateId,jdbcType=BIGINT}, #{fkCreateName,jdbcType=VARCHAR}, ",
        "#{fkUpdateName,jdbcType=VARCHAR}, #{phone,jdbcType=VARCHAR})"
    })
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="userId", before=false, resultType=Long.class)
    int insert(HtUser record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ht_user
     *
     * @mbg.generated Wed Mar 07 12:44:12 CST 2018
     */
    @InsertProvider(type=HtUserSqlProvider.class, method="insertSelective")
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="userId", before=false, resultType=Long.class)
    int insertSelective(HtUser record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ht_user
     *
     * @mbg.generated Wed Mar 07 12:44:12 CST 2018
     */
    @SelectProvider(type=HtUserSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="user_id", property="userId", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="user_name", property="userName", jdbcType=JdbcType.VARCHAR),
        @Result(column="password", property="password", jdbcType=JdbcType.VARCHAR),
        @Result(column="type", property="type", jdbcType=JdbcType.SMALLINT),
        @Result(column="nick_name", property="nickName", jdbcType=JdbcType.VARCHAR),
        @Result(column="true_name", property="trueName", jdbcType=JdbcType.VARCHAR),
        @Result(column="del", property="del", jdbcType=JdbcType.SMALLINT),
        @Result(column="state", property="state", jdbcType=JdbcType.SMALLINT),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="update_time", property="updateTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="fk_create_id", property="fkCreateId", jdbcType=JdbcType.BIGINT),
        @Result(column="fk_update_id", property="fkUpdateId", jdbcType=JdbcType.BIGINT),
        @Result(column="fk_create_name", property="fkCreateName", jdbcType=JdbcType.VARCHAR),
        @Result(column="fk_update_name", property="fkUpdateName", jdbcType=JdbcType.VARCHAR),
        @Result(column="phone", property="phone", jdbcType=JdbcType.VARCHAR)
    })
    List<HtUser> selectByExample(HtUserExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ht_user
     *
     * @mbg.generated Wed Mar 07 12:44:12 CST 2018
     */
    @Select({
        "select",
        "user_id, user_name, password, type, nick_name, true_name, del, state, create_time, ",
        "update_time, fk_create_id, fk_update_id, fk_create_name, fk_update_name, phone",
        "from ht_user",
        "where user_id = #{userId,jdbcType=BIGINT}"
    })
    @Results({
        @Result(column="user_id", property="userId", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="user_name", property="userName", jdbcType=JdbcType.VARCHAR),
        @Result(column="password", property="password", jdbcType=JdbcType.VARCHAR),
        @Result(column="type", property="type", jdbcType=JdbcType.SMALLINT),
        @Result(column="nick_name", property="nickName", jdbcType=JdbcType.VARCHAR),
        @Result(column="true_name", property="trueName", jdbcType=JdbcType.VARCHAR),
        @Result(column="del", property="del", jdbcType=JdbcType.SMALLINT),
        @Result(column="state", property="state", jdbcType=JdbcType.SMALLINT),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="update_time", property="updateTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="fk_create_id", property="fkCreateId", jdbcType=JdbcType.BIGINT),
        @Result(column="fk_update_id", property="fkUpdateId", jdbcType=JdbcType.BIGINT),
        @Result(column="fk_create_name", property="fkCreateName", jdbcType=JdbcType.VARCHAR),
        @Result(column="fk_update_name", property="fkUpdateName", jdbcType=JdbcType.VARCHAR),
        @Result(column="phone", property="phone", jdbcType=JdbcType.VARCHAR)
    })
    HtUser selectByPrimaryKey(Long userId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ht_user
     *
     * @mbg.generated Wed Mar 07 12:44:12 CST 2018
     */
    @UpdateProvider(type=HtUserSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") HtUser record, @Param("example") HtUserExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ht_user
     *
     * @mbg.generated Wed Mar 07 12:44:12 CST 2018
     */
    @UpdateProvider(type=HtUserSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") HtUser record, @Param("example") HtUserExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ht_user
     *
     * @mbg.generated Wed Mar 07 12:44:12 CST 2018
     */
    @UpdateProvider(type=HtUserSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(HtUser record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ht_user
     *
     * @mbg.generated Wed Mar 07 12:44:12 CST 2018
     */
    @Update({
        "update ht_user",
        "set user_name = #{userName,jdbcType=VARCHAR},",
          "password = #{password,jdbcType=VARCHAR},",
          "type = #{type,jdbcType=SMALLINT},",
          "nick_name = #{nickName,jdbcType=VARCHAR},",
          "true_name = #{trueName,jdbcType=VARCHAR},",
          "del = #{del,jdbcType=SMALLINT},",
          "state = #{state,jdbcType=SMALLINT},",
          "create_time = #{createTime,jdbcType=TIMESTAMP},",
          "update_time = #{updateTime,jdbcType=TIMESTAMP},",
          "fk_create_id = #{fkCreateId,jdbcType=BIGINT},",
          "fk_update_id = #{fkUpdateId,jdbcType=BIGINT},",
          "fk_create_name = #{fkCreateName,jdbcType=VARCHAR},",
          "fk_update_name = #{fkUpdateName,jdbcType=VARCHAR},",
          "phone = #{phone,jdbcType=VARCHAR}",
        "where user_id = #{userId,jdbcType=BIGINT}"
    })
    int updateByPrimaryKey(HtUser record);
}