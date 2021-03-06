package com.cn.system.dao.model;

import com.cn.system.dao.bean.BaseRequest;

import java.util.Date;

public class Roles extends BaseRequest {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column roles.id
     *
     * @mbg.generated Wed Mar 07 12:42:47 CST 2018
     */
    private Long id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column roles.name
     *
     * @mbg.generated Wed Mar 07 12:42:47 CST 2018
     */
    private String name;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column roles.update_time
     *
     * @mbg.generated Wed Mar 07 12:42:47 CST 2018
     */
    private Date updateTime;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column roles.fk_update_id
     *
     * @mbg.generated Wed Mar 07 12:42:47 CST 2018
     */
    private Long fkUpdateId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column roles.del
     *
     * @mbg.generated Wed Mar 07 12:42:47 CST 2018
     */
    private Short del;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column roles.level
     *
     * @mbg.generated Wed Mar 07 12:42:47 CST 2018
     */
    private Integer level;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column roles.id
     *
     * @return the value of roles.id
     *
     * @mbg.generated Wed Mar 07 12:42:47 CST 2018
     */
    public Long getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column roles.id
     *
     * @param id the value for roles.id
     *
     * @mbg.generated Wed Mar 07 12:42:47 CST 2018
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column roles.name
     *
     * @return the value of roles.name
     *
     * @mbg.generated Wed Mar 07 12:42:47 CST 2018
     */
    public String getName() {
        return name;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column roles.name
     *
     * @param name the value for roles.name
     *
     * @mbg.generated Wed Mar 07 12:42:47 CST 2018
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column roles.update_time
     *
     * @return the value of roles.update_time
     *
     * @mbg.generated Wed Mar 07 12:42:47 CST 2018
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column roles.update_time
     *
     * @param updateTime the value for roles.update_time
     *
     * @mbg.generated Wed Mar 07 12:42:47 CST 2018
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column roles.fk_update_id
     *
     * @return the value of roles.fk_update_id
     *
     * @mbg.generated Wed Mar 07 12:42:47 CST 2018
     */
    public Long getFkUpdateId() {
        return fkUpdateId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column roles.fk_update_id
     *
     * @param fkUpdateId the value for roles.fk_update_id
     *
     * @mbg.generated Wed Mar 07 12:42:47 CST 2018
     */
    public void setFkUpdateId(Long fkUpdateId) {
        this.fkUpdateId = fkUpdateId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column roles.del
     *
     * @return the value of roles.del
     *
     * @mbg.generated Wed Mar 07 12:42:47 CST 2018
     */
    public Short getDel() {
        return del;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column roles.del
     *
     * @param del the value for roles.del
     *
     * @mbg.generated Wed Mar 07 12:42:47 CST 2018
     */
    public void setDel(Short del) {
        this.del = del;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column roles.level
     *
     * @return the value of roles.level
     *
     * @mbg.generated Wed Mar 07 12:42:47 CST 2018
     */
    public Integer getLevel() {
        return level;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column roles.level
     *
     * @param level the value for roles.level
     *
     * @mbg.generated Wed Mar 07 12:42:47 CST 2018
     */
    public void setLevel(Integer level) {
        this.level = level;
    }
}