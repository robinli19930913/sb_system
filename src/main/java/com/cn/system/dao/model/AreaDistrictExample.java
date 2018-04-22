package com.cn.system.dao.model;

import java.util.ArrayList;
import java.util.List;

public class AreaDistrictExample {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table area_district
     *
     * @mbg.generated Wed Mar 07 12:42:47 CST 2018
     */
    protected String orderByClause;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table area_district
     *
     * @mbg.generated Wed Mar 07 12:42:47 CST 2018
     */
    protected boolean distinct;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table area_district
     *
     * @mbg.generated Wed Mar 07 12:42:47 CST 2018
     */
    protected List<Criteria> oredCriteria;

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table area_district
     *
     * @mbg.generated Wed Mar 07 12:42:47 CST 2018
     */
    public AreaDistrictExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table area_district
     *
     * @mbg.generated Wed Mar 07 12:42:47 CST 2018
     */
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table area_district
     *
     * @mbg.generated Wed Mar 07 12:42:47 CST 2018
     */
    public String getOrderByClause() {
        return orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table area_district
     *
     * @mbg.generated Wed Mar 07 12:42:47 CST 2018
     */
    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table area_district
     *
     * @mbg.generated Wed Mar 07 12:42:47 CST 2018
     */
    public boolean isDistinct() {
        return distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table area_district
     *
     * @mbg.generated Wed Mar 07 12:42:47 CST 2018
     */
    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table area_district
     *
     * @mbg.generated Wed Mar 07 12:42:47 CST 2018
     */
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table area_district
     *
     * @mbg.generated Wed Mar 07 12:42:47 CST 2018
     */
    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table area_district
     *
     * @mbg.generated Wed Mar 07 12:42:47 CST 2018
     */
    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table area_district
     *
     * @mbg.generated Wed Mar 07 12:42:47 CST 2018
     */
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table area_district
     *
     * @mbg.generated Wed Mar 07 12:42:47 CST 2018
     */
    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table area_district
     *
     * @mbg.generated Wed Mar 07 12:42:47 CST 2018
     */
    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Integer value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Integer value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Integer value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Integer value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Integer value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Integer> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Integer> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Integer value1, Integer value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Integer value1, Integer value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andFkProvIdIsNull() {
            addCriterion("fk_prov_id is null");
            return (Criteria) this;
        }

        public Criteria andFkProvIdIsNotNull() {
            addCriterion("fk_prov_id is not null");
            return (Criteria) this;
        }

        public Criteria andFkProvIdEqualTo(Integer value) {
            addCriterion("fk_prov_id =", value, "fkProvId");
            return (Criteria) this;
        }

        public Criteria andFkProvIdNotEqualTo(Integer value) {
            addCriterion("fk_prov_id <>", value, "fkProvId");
            return (Criteria) this;
        }

        public Criteria andFkProvIdGreaterThan(Integer value) {
            addCriterion("fk_prov_id >", value, "fkProvId");
            return (Criteria) this;
        }

        public Criteria andFkProvIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("fk_prov_id >=", value, "fkProvId");
            return (Criteria) this;
        }

        public Criteria andFkProvIdLessThan(Integer value) {
            addCriterion("fk_prov_id <", value, "fkProvId");
            return (Criteria) this;
        }

        public Criteria andFkProvIdLessThanOrEqualTo(Integer value) {
            addCriterion("fk_prov_id <=", value, "fkProvId");
            return (Criteria) this;
        }

        public Criteria andFkProvIdIn(List<Integer> values) {
            addCriterion("fk_prov_id in", values, "fkProvId");
            return (Criteria) this;
        }

        public Criteria andFkProvIdNotIn(List<Integer> values) {
            addCriterion("fk_prov_id not in", values, "fkProvId");
            return (Criteria) this;
        }

        public Criteria andFkProvIdBetween(Integer value1, Integer value2) {
            addCriterion("fk_prov_id between", value1, value2, "fkProvId");
            return (Criteria) this;
        }

        public Criteria andFkProvIdNotBetween(Integer value1, Integer value2) {
            addCriterion("fk_prov_id not between", value1, value2, "fkProvId");
            return (Criteria) this;
        }

        public Criteria andFkCityIdIsNull() {
            addCriterion("fk_city_id is null");
            return (Criteria) this;
        }

        public Criteria andFkCityIdIsNotNull() {
            addCriterion("fk_city_id is not null");
            return (Criteria) this;
        }

        public Criteria andFkCityIdEqualTo(Integer value) {
            addCriterion("fk_city_id =", value, "fkCityId");
            return (Criteria) this;
        }

        public Criteria andFkCityIdNotEqualTo(Integer value) {
            addCriterion("fk_city_id <>", value, "fkCityId");
            return (Criteria) this;
        }

        public Criteria andFkCityIdGreaterThan(Integer value) {
            addCriterion("fk_city_id >", value, "fkCityId");
            return (Criteria) this;
        }

        public Criteria andFkCityIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("fk_city_id >=", value, "fkCityId");
            return (Criteria) this;
        }

        public Criteria andFkCityIdLessThan(Integer value) {
            addCriterion("fk_city_id <", value, "fkCityId");
            return (Criteria) this;
        }

        public Criteria andFkCityIdLessThanOrEqualTo(Integer value) {
            addCriterion("fk_city_id <=", value, "fkCityId");
            return (Criteria) this;
        }

        public Criteria andFkCityIdIn(List<Integer> values) {
            addCriterion("fk_city_id in", values, "fkCityId");
            return (Criteria) this;
        }

        public Criteria andFkCityIdNotIn(List<Integer> values) {
            addCriterion("fk_city_id not in", values, "fkCityId");
            return (Criteria) this;
        }

        public Criteria andFkCityIdBetween(Integer value1, Integer value2) {
            addCriterion("fk_city_id between", value1, value2, "fkCityId");
            return (Criteria) this;
        }

        public Criteria andFkCityIdNotBetween(Integer value1, Integer value2) {
            addCriterion("fk_city_id not between", value1, value2, "fkCityId");
            return (Criteria) this;
        }

        public Criteria andZipCodeIsNull() {
            addCriterion("zip_code is null");
            return (Criteria) this;
        }

        public Criteria andZipCodeIsNotNull() {
            addCriterion("zip_code is not null");
            return (Criteria) this;
        }

        public Criteria andZipCodeEqualTo(String value) {
            addCriterion("zip_code =", value, "zipCode");
            return (Criteria) this;
        }

        public Criteria andZipCodeNotEqualTo(String value) {
            addCriterion("zip_code <>", value, "zipCode");
            return (Criteria) this;
        }

        public Criteria andZipCodeGreaterThan(String value) {
            addCriterion("zip_code >", value, "zipCode");
            return (Criteria) this;
        }

        public Criteria andZipCodeGreaterThanOrEqualTo(String value) {
            addCriterion("zip_code >=", value, "zipCode");
            return (Criteria) this;
        }

        public Criteria andZipCodeLessThan(String value) {
            addCriterion("zip_code <", value, "zipCode");
            return (Criteria) this;
        }

        public Criteria andZipCodeLessThanOrEqualTo(String value) {
            addCriterion("zip_code <=", value, "zipCode");
            return (Criteria) this;
        }

        public Criteria andZipCodeLike(String value) {
            addCriterion("zip_code like", value, "zipCode");
            return (Criteria) this;
        }

        public Criteria andZipCodeNotLike(String value) {
            addCriterion("zip_code not like", value, "zipCode");
            return (Criteria) this;
        }

        public Criteria andZipCodeIn(List<String> values) {
            addCriterion("zip_code in", values, "zipCode");
            return (Criteria) this;
        }

        public Criteria andZipCodeNotIn(List<String> values) {
            addCriterion("zip_code not in", values, "zipCode");
            return (Criteria) this;
        }

        public Criteria andZipCodeBetween(String value1, String value2) {
            addCriterion("zip_code between", value1, value2, "zipCode");
            return (Criteria) this;
        }

        public Criteria andZipCodeNotBetween(String value1, String value2) {
            addCriterion("zip_code not between", value1, value2, "zipCode");
            return (Criteria) this;
        }

        public Criteria andDistrictNameIsNull() {
            addCriterion("district_name is null");
            return (Criteria) this;
        }

        public Criteria andDistrictNameIsNotNull() {
            addCriterion("district_name is not null");
            return (Criteria) this;
        }

        public Criteria andDistrictNameEqualTo(String value) {
            addCriterion("district_name =", value, "districtName");
            return (Criteria) this;
        }

        public Criteria andDistrictNameNotEqualTo(String value) {
            addCriterion("district_name <>", value, "districtName");
            return (Criteria) this;
        }

        public Criteria andDistrictNameGreaterThan(String value) {
            addCriterion("district_name >", value, "districtName");
            return (Criteria) this;
        }

        public Criteria andDistrictNameGreaterThanOrEqualTo(String value) {
            addCriterion("district_name >=", value, "districtName");
            return (Criteria) this;
        }

        public Criteria andDistrictNameLessThan(String value) {
            addCriterion("district_name <", value, "districtName");
            return (Criteria) this;
        }

        public Criteria andDistrictNameLessThanOrEqualTo(String value) {
            addCriterion("district_name <=", value, "districtName");
            return (Criteria) this;
        }

        public Criteria andDistrictNameLike(String value) {
            addCriterion("district_name like", value, "districtName");
            return (Criteria) this;
        }

        public Criteria andDistrictNameNotLike(String value) {
            addCriterion("district_name not like", value, "districtName");
            return (Criteria) this;
        }

        public Criteria andDistrictNameIn(List<String> values) {
            addCriterion("district_name in", values, "districtName");
            return (Criteria) this;
        }

        public Criteria andDistrictNameNotIn(List<String> values) {
            addCriterion("district_name not in", values, "districtName");
            return (Criteria) this;
        }

        public Criteria andDistrictNameBetween(String value1, String value2) {
            addCriterion("district_name between", value1, value2, "districtName");
            return (Criteria) this;
        }

        public Criteria andDistrictNameNotBetween(String value1, String value2) {
            addCriterion("district_name not between", value1, value2, "districtName");
            return (Criteria) this;
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table area_district
     *
     * @mbg.generated do_not_delete_during_merge Wed Mar 07 12:42:47 CST 2018
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table area_district
     *
     * @mbg.generated Wed Mar 07 12:42:47 CST 2018
     */
    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}