package com.cn.system.dao.mapper;

import com.cn.system.dao.model.OperationLog;
import com.cn.system.dao.model.OperationLogExample;
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

public interface OperationLogMapper {
    @SelectProvider(type=OperationLogSqlProvider.class, method="countByExample")
    long countByExample(OperationLogExample example);

    @DeleteProvider(type=OperationLogSqlProvider.class, method="deleteByExample")
    int deleteByExample(OperationLogExample example);

    @Insert({
        "insert into operation_log (id, url, ",
        "ip, operation_id, ",
        "operation_name, create_time, ",
        "url_name, controller, ",
        "method, params, ",
        "costTime)",
        "values (#{id,jdbcType=VARCHAR}, #{url,jdbcType=VARCHAR}, ",
        "#{ip,jdbcType=VARCHAR}, #{operationId,jdbcType=BIGINT}, ",
        "#{operationName,jdbcType=VARCHAR}, #{createTime,jdbcType=TIMESTAMP}, ",
        "#{urlName,jdbcType=VARCHAR}, #{controller,jdbcType=VARCHAR}, ",
        "#{method,jdbcType=VARCHAR}, #{params,jdbcType=VARCHAR}, ",
        "#{costtime,jdbcType=VARCHAR})"
    })
    int insert(OperationLog record);

    @InsertProvider(type=OperationLogSqlProvider.class, method="insertSelective")
    int insertSelective(OperationLog record);

    @SelectProvider(type=OperationLogSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.VARCHAR),
        @Result(column="url", property="url", jdbcType=JdbcType.VARCHAR),
        @Result(column="ip", property="ip", jdbcType=JdbcType.VARCHAR),
        @Result(column="operation_id", property="operationId", jdbcType=JdbcType.BIGINT),
        @Result(column="operation_name", property="operationName", jdbcType=JdbcType.VARCHAR),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="url_name", property="urlName", jdbcType=JdbcType.VARCHAR),
        @Result(column="controller", property="controller", jdbcType=JdbcType.VARCHAR),
        @Result(column="method", property="method", jdbcType=JdbcType.VARCHAR),
        @Result(column="params", property="params", jdbcType=JdbcType.VARCHAR),
        @Result(column="costTime", property="costtime", jdbcType=JdbcType.VARCHAR)
    })
    List<OperationLog> selectByExample(OperationLogExample example);

    @UpdateProvider(type=OperationLogSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") OperationLog record, @Param("example") OperationLogExample example);

    @UpdateProvider(type=OperationLogSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") OperationLog record, @Param("example") OperationLogExample example);
}