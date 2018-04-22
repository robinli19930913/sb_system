package com.cn.system.dao.mapper;

import com.cn.system.dao.model.AreaCity;
import com.cn.system.dao.model.AreaCityExample;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;

import java.util.List;

public interface AreaCityMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table area_city
     *
     * @mbg.generated Wed Mar 07 12:42:47 CST 2018
     */
    @SelectProvider(type=AreaCitySqlProvider.class, method="countByExample")
    long countByExample(AreaCityExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table area_city
     *
     * @mbg.generated Wed Mar 07 12:42:47 CST 2018
     */
    @DeleteProvider(type=AreaCitySqlProvider.class, method="deleteByExample")
    int deleteByExample(AreaCityExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table area_city
     *
     * @mbg.generated Wed Mar 07 12:42:47 CST 2018
     */
    @Delete({
        "delete from area_city",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table area_city
     *
     * @mbg.generated Wed Mar 07 12:42:47 CST 2018
     */
    @Insert({
        "insert into area_city (city_name, fk_prov_id, ",
        "pinyin_name, first_pinyin)",
        "values (#{cityName,jdbcType=VARCHAR}, #{fkProvId,jdbcType=INTEGER}, ",
        "#{pinyinName,jdbcType=VARCHAR}, #{firstPinyin,jdbcType=VARCHAR})"
    })
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Integer.class)
    int insert(AreaCity record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table area_city
     *
     * @mbg.generated Wed Mar 07 12:42:47 CST 2018
     */
    @InsertProvider(type=AreaCitySqlProvider.class, method="insertSelective")
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Integer.class)
    int insertSelective(AreaCity record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table area_city
     *
     * @mbg.generated Wed Mar 07 12:42:47 CST 2018
     */
    @SelectProvider(type=AreaCitySqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="city_name", property="cityName", jdbcType=JdbcType.VARCHAR),
        @Result(column="fk_prov_id", property="fkProvId", jdbcType=JdbcType.INTEGER),
        @Result(column="pinyin_name", property="pinyinName", jdbcType=JdbcType.VARCHAR),
        @Result(column="first_pinyin", property="firstPinyin", jdbcType=JdbcType.VARCHAR)
    })
    List<AreaCity> selectByExample(AreaCityExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table area_city
     *
     * @mbg.generated Wed Mar 07 12:42:47 CST 2018
     */
    @Select({
        "select",
        "id, city_name, fk_prov_id, pinyin_name, first_pinyin",
        "from area_city",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="city_name", property="cityName", jdbcType=JdbcType.VARCHAR),
        @Result(column="fk_prov_id", property="fkProvId", jdbcType=JdbcType.INTEGER),
        @Result(column="pinyin_name", property="pinyinName", jdbcType=JdbcType.VARCHAR),
        @Result(column="first_pinyin", property="firstPinyin", jdbcType=JdbcType.VARCHAR)
    })
    AreaCity selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table area_city
     *
     * @mbg.generated Wed Mar 07 12:42:47 CST 2018
     */
    @UpdateProvider(type=AreaCitySqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") AreaCity record, @Param("example") AreaCityExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table area_city
     *
     * @mbg.generated Wed Mar 07 12:42:47 CST 2018
     */
    @UpdateProvider(type=AreaCitySqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") AreaCity record, @Param("example") AreaCityExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table area_city
     *
     * @mbg.generated Wed Mar 07 12:42:47 CST 2018
     */
    @UpdateProvider(type=AreaCitySqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(AreaCity record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table area_city
     *
     * @mbg.generated Wed Mar 07 12:42:47 CST 2018
     */
    @Update({
        "update area_city",
        "set city_name = #{cityName,jdbcType=VARCHAR},",
          "fk_prov_id = #{fkProvId,jdbcType=INTEGER},",
          "pinyin_name = #{pinyinName,jdbcType=VARCHAR},",
          "first_pinyin = #{firstPinyin,jdbcType=VARCHAR}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(AreaCity record);
}