package com.cn.system.dao.model;


import com.cn.system.dao.bean.BaseRequest;

public class RolesMenu extends BaseRequest {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column roles_menu.mid
     *
     * @mbg.generated Wed Mar 07 12:42:47 CST 2018
     */
    private Long mid;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column roles_menu.rid
     *
     * @mbg.generated Wed Mar 07 12:42:47 CST 2018
     */
    private Long rid;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column roles_menu.mid
     *
     * @return the value of roles_menu.mid
     *
     * @mbg.generated Wed Mar 07 12:42:47 CST 2018
     */
    public Long getMid() {
        return mid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column roles_menu.mid
     *
     * @param mid the value for roles_menu.mid
     *
     * @mbg.generated Wed Mar 07 12:42:47 CST 2018
     */
    public void setMid(Long mid) {
        this.mid = mid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column roles_menu.rid
     *
     * @return the value of roles_menu.rid
     *
     * @mbg.generated Wed Mar 07 12:42:47 CST 2018
     */
    public Long getRid() {
        return rid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column roles_menu.rid
     *
     * @param rid the value for roles_menu.rid
     *
     * @mbg.generated Wed Mar 07 12:42:47 CST 2018
     */
    public void setRid(Long rid) {
        this.rid = rid;
    }
}