package com.my.pojo;

import java.util.ArrayList;
import java.util.List;

public class UserBehaviorExample {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table user_behavior
     *
     * @mbggenerated Mon Dec 10 21:16:58 CST 2018
     */
    protected String orderByClause;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table user_behavior
     *
     * @mbggenerated Mon Dec 10 21:16:58 CST 2018
     */
    protected boolean distinct;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table user_behavior
     *
     * @mbggenerated Mon Dec 10 21:16:58 CST 2018
     */
    protected List<Criteria> oredCriteria;

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_behavior
     *
     * @mbggenerated Mon Dec 10 21:16:58 CST 2018
     */
    public UserBehaviorExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_behavior
     *
     * @mbggenerated Mon Dec 10 21:16:58 CST 2018
     */
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_behavior
     *
     * @mbggenerated Mon Dec 10 21:16:58 CST 2018
     */
    public String getOrderByClause() {
        return orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_behavior
     *
     * @mbggenerated Mon Dec 10 21:16:58 CST 2018
     */
    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_behavior
     *
     * @mbggenerated Mon Dec 10 21:16:58 CST 2018
     */
    public boolean isDistinct() {
        return distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_behavior
     *
     * @mbggenerated Mon Dec 10 21:16:58 CST 2018
     */
    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_behavior
     *
     * @mbggenerated Mon Dec 10 21:16:58 CST 2018
     */
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_behavior
     *
     * @mbggenerated Mon Dec 10 21:16:58 CST 2018
     */
    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_behavior
     *
     * @mbggenerated Mon Dec 10 21:16:58 CST 2018
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
     * This method corresponds to the database table user_behavior
     *
     * @mbggenerated Mon Dec 10 21:16:58 CST 2018
     */
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_behavior
     *
     * @mbggenerated Mon Dec 10 21:16:58 CST 2018
     */
    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table user_behavior
     *
     * @mbggenerated Mon Dec 10 21:16:58 CST 2018
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

        public Criteria andUidIsNull() {
            addCriterion("uid is null");
            return (Criteria) this;
        }

        public Criteria andUidIsNotNull() {
            addCriterion("uid is not null");
            return (Criteria) this;
        }

        public Criteria andUidEqualTo(Integer value) {
            addCriterion("uid =", value, "uid");
            return (Criteria) this;
        }

        public Criteria andUidNotEqualTo(Integer value) {
            addCriterion("uid <>", value, "uid");
            return (Criteria) this;
        }

        public Criteria andUidGreaterThan(Integer value) {
            addCriterion("uid >", value, "uid");
            return (Criteria) this;
        }

        public Criteria andUidGreaterThanOrEqualTo(Integer value) {
            addCriterion("uid >=", value, "uid");
            return (Criteria) this;
        }

        public Criteria andUidLessThan(Integer value) {
            addCriterion("uid <", value, "uid");
            return (Criteria) this;
        }

        public Criteria andUidLessThanOrEqualTo(Integer value) {
            addCriterion("uid <=", value, "uid");
            return (Criteria) this;
        }

        public Criteria andUidIn(List<Integer> values) {
            addCriterion("uid in", values, "uid");
            return (Criteria) this;
        }

        public Criteria andUidNotIn(List<Integer> values) {
            addCriterion("uid not in", values, "uid");
            return (Criteria) this;
        }

        public Criteria andUidBetween(Integer value1, Integer value2) {
            addCriterion("uid between", value1, value2, "uid");
            return (Criteria) this;
        }

        public Criteria andUidNotBetween(Integer value1, Integer value2) {
            addCriterion("uid not between", value1, value2, "uid");
            return (Criteria) this;
        }

        public Criteria andBtypeidIsNull() {
            addCriterion("btypeid is null");
            return (Criteria) this;
        }

        public Criteria andBtypeidIsNotNull() {
            addCriterion("btypeid is not null");
            return (Criteria) this;
        }

        public Criteria andBtypeidEqualTo(Integer value) {
            addCriterion("btypeid =", value, "btypeid");
            return (Criteria) this;
        }

        public Criteria andBtypeidNotEqualTo(Integer value) {
            addCriterion("btypeid <>", value, "btypeid");
            return (Criteria) this;
        }

        public Criteria andBtypeidGreaterThan(Integer value) {
            addCriterion("btypeid >", value, "btypeid");
            return (Criteria) this;
        }

        public Criteria andBtypeidGreaterThanOrEqualTo(Integer value) {
            addCriterion("btypeid >=", value, "btypeid");
            return (Criteria) this;
        }

        public Criteria andBtypeidLessThan(Integer value) {
            addCriterion("btypeid <", value, "btypeid");
            return (Criteria) this;
        }

        public Criteria andBtypeidLessThanOrEqualTo(Integer value) {
            addCriterion("btypeid <=", value, "btypeid");
            return (Criteria) this;
        }

        public Criteria andBtypeidIn(List<Integer> values) {
            addCriterion("btypeid in", values, "btypeid");
            return (Criteria) this;
        }

        public Criteria andBtypeidNotIn(List<Integer> values) {
            addCriterion("btypeid not in", values, "btypeid");
            return (Criteria) this;
        }

        public Criteria andBtypeidBetween(Integer value1, Integer value2) {
            addCriterion("btypeid between", value1, value2, "btypeid");
            return (Criteria) this;
        }

        public Criteria andBtypeidNotBetween(Integer value1, Integer value2) {
            addCriterion("btypeid not between", value1, value2, "btypeid");
            return (Criteria) this;
        }

        public Criteria andBcontentidIsNull() {
            addCriterion("bcontentid is null");
            return (Criteria) this;
        }

        public Criteria andBcontentidIsNotNull() {
            addCriterion("bcontentid is not null");
            return (Criteria) this;
        }

        public Criteria andBcontentidEqualTo(Integer value) {
            addCriterion("bcontentid =", value, "bcontentid");
            return (Criteria) this;
        }

        public Criteria andBcontentidNotEqualTo(Integer value) {
            addCriterion("bcontentid <>", value, "bcontentid");
            return (Criteria) this;
        }

        public Criteria andBcontentidGreaterThan(Integer value) {
            addCriterion("bcontentid >", value, "bcontentid");
            return (Criteria) this;
        }

        public Criteria andBcontentidGreaterThanOrEqualTo(Integer value) {
            addCriterion("bcontentid >=", value, "bcontentid");
            return (Criteria) this;
        }

        public Criteria andBcontentidLessThan(Integer value) {
            addCriterion("bcontentid <", value, "bcontentid");
            return (Criteria) this;
        }

        public Criteria andBcontentidLessThanOrEqualTo(Integer value) {
            addCriterion("bcontentid <=", value, "bcontentid");
            return (Criteria) this;
        }

        public Criteria andBcontentidIn(List<Integer> values) {
            addCriterion("bcontentid in", values, "bcontentid");
            return (Criteria) this;
        }

        public Criteria andBcontentidNotIn(List<Integer> values) {
            addCriterion("bcontentid not in", values, "bcontentid");
            return (Criteria) this;
        }

        public Criteria andBcontentidBetween(Integer value1, Integer value2) {
            addCriterion("bcontentid between", value1, value2, "bcontentid");
            return (Criteria) this;
        }

        public Criteria andBcontentidNotBetween(Integer value1, Integer value2) {
            addCriterion("bcontentid not between", value1, value2, "bcontentid");
            return (Criteria) this;
        }

        public Criteria andBcontextidIsNull() {
            addCriterion("bcontextid is null");
            return (Criteria) this;
        }

        public Criteria andBcontextidIsNotNull() {
            addCriterion("bcontextid is not null");
            return (Criteria) this;
        }

        public Criteria andBcontextidEqualTo(Integer value) {
            addCriterion("bcontextid =", value, "bcontextid");
            return (Criteria) this;
        }

        public Criteria andBcontextidNotEqualTo(Integer value) {
            addCriterion("bcontextid <>", value, "bcontextid");
            return (Criteria) this;
        }

        public Criteria andBcontextidGreaterThan(Integer value) {
            addCriterion("bcontextid >", value, "bcontextid");
            return (Criteria) this;
        }

        public Criteria andBcontextidGreaterThanOrEqualTo(Integer value) {
            addCriterion("bcontextid >=", value, "bcontextid");
            return (Criteria) this;
        }

        public Criteria andBcontextidLessThan(Integer value) {
            addCriterion("bcontextid <", value, "bcontextid");
            return (Criteria) this;
        }

        public Criteria andBcontextidLessThanOrEqualTo(Integer value) {
            addCriterion("bcontextid <=", value, "bcontextid");
            return (Criteria) this;
        }

        public Criteria andBcontextidIn(List<Integer> values) {
            addCriterion("bcontextid in", values, "bcontextid");
            return (Criteria) this;
        }

        public Criteria andBcontextidNotIn(List<Integer> values) {
            addCriterion("bcontextid not in", values, "bcontextid");
            return (Criteria) this;
        }

        public Criteria andBcontextidBetween(Integer value1, Integer value2) {
            addCriterion("bcontextid between", value1, value2, "bcontextid");
            return (Criteria) this;
        }

        public Criteria andBcontextidNotBetween(Integer value1, Integer value2) {
            addCriterion("bcontextid not between", value1, value2, "bcontextid");
            return (Criteria) this;
        }

        public Criteria andBweightIsNull() {
            addCriterion("bweight is null");
            return (Criteria) this;
        }

        public Criteria andBweightIsNotNull() {
            addCriterion("bweight is not null");
            return (Criteria) this;
        }

        public Criteria andBweightEqualTo(Integer value) {
            addCriterion("bweight =", value, "bweight");
            return (Criteria) this;
        }

        public Criteria andBweightNotEqualTo(Integer value) {
            addCriterion("bweight <>", value, "bweight");
            return (Criteria) this;
        }

        public Criteria andBweightGreaterThan(Integer value) {
            addCriterion("bweight >", value, "bweight");
            return (Criteria) this;
        }

        public Criteria andBweightGreaterThanOrEqualTo(Integer value) {
            addCriterion("bweight >=", value, "bweight");
            return (Criteria) this;
        }

        public Criteria andBweightLessThan(Integer value) {
            addCriterion("bweight <", value, "bweight");
            return (Criteria) this;
        }

        public Criteria andBweightLessThanOrEqualTo(Integer value) {
            addCriterion("bweight <=", value, "bweight");
            return (Criteria) this;
        }

        public Criteria andBweightIn(List<Integer> values) {
            addCriterion("bweight in", values, "bweight");
            return (Criteria) this;
        }

        public Criteria andBweightNotIn(List<Integer> values) {
            addCriterion("bweight not in", values, "bweight");
            return (Criteria) this;
        }

        public Criteria andBweightBetween(Integer value1, Integer value2) {
            addCriterion("bweight between", value1, value2, "bweight");
            return (Criteria) this;
        }

        public Criteria andBweightNotBetween(Integer value1, Integer value2) {
            addCriterion("bweight not between", value1, value2, "bweight");
            return (Criteria) this;
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table user_behavior
     *
     * @mbggenerated do_not_delete_during_merge Mon Dec 10 21:16:58 CST 2018
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table user_behavior
     *
     * @mbggenerated Mon Dec 10 21:16:58 CST 2018
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