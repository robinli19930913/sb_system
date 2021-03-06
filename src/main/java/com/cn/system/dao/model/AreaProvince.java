package com.cn.system.dao.model;


import com.cn.system.dao.bean.BaseRequest;

public class AreaProvince extends BaseRequest {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column area_province.id
     *
     * @mbg.generated Wed Mar 07 12:42:47 CST 2018
     */
    private Integer id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column area_province.prov_name
     *
     * @mbg.generated Wed Mar 07 12:42:47 CST 2018
     */
    private String provName;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column area_province.fk_region_id
     *
     * @mbg.generated Wed Mar 07 12:42:47 CST 2018
     */
    private Integer fkRegionId;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column area_province.id
     *
     * @return the value of area_province.id
     *
     * @mbg.generated Wed Mar 07 12:42:47 CST 2018
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column area_province.id
     *
     * @param id the value for area_province.id
     *
     * @mbg.generated Wed Mar 07 12:42:47 CST 2018
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column area_province.prov_name
     *
     * @return the value of area_province.prov_name
     *
     * @mbg.generated Wed Mar 07 12:42:47 CST 2018
     */
    public String getProvName() {
        return provName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column area_province.prov_name
     *
     * @param provName the value for area_province.prov_name
     *
     * @mbg.generated Wed Mar 07 12:42:47 CST 2018
     */
    public void setProvName(String provName) {
        this.provName = provName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column area_province.fk_region_id
     *
     * @return the value of area_province.fk_region_id
     *
     * @mbg.generated Wed Mar 07 12:42:47 CST 2018
     */
    public Integer getFkRegionId() {
        return fkRegionId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column area_province.fk_region_id
     *
     * @param fkRegionId the value for area_province.fk_region_id
     *
     * @mbg.generated Wed Mar 07 12:42:47 CST 2018
     */
    public void setFkRegionId(Integer fkRegionId) {
        this.fkRegionId = fkRegionId;
    }
}