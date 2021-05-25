package edu.thn.ciom.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class LeiXingPojoExample {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table t_sjleixing
     *
     * @mbg.generated Thu May 20 10:15:44 CST 2021
     */
    protected String orderByClause;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table t_sjleixing
     *
     * @mbg.generated Thu May 20 10:15:44 CST 2021
     */
    protected boolean distinct;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table t_sjleixing
     *
     * @mbg.generated Thu May 20 10:15:44 CST 2021
     */
    protected List<Criteria> oredCriteria;

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_sjleixing
     *
     * @mbg.generated Thu May 20 10:15:44 CST 2021
     */
    public LeiXingPojoExample() {
        oredCriteria = new ArrayList<>();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_sjleixing
     *
     * @mbg.generated Thu May 20 10:15:44 CST 2021
     */
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_sjleixing
     *
     * @mbg.generated Thu May 20 10:15:44 CST 2021
     */
    public String getOrderByClause() {
        return orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_sjleixing
     *
     * @mbg.generated Thu May 20 10:15:44 CST 2021
     */
    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_sjleixing
     *
     * @mbg.generated Thu May 20 10:15:44 CST 2021
     */
    public boolean isDistinct() {
        return distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_sjleixing
     *
     * @mbg.generated Thu May 20 10:15:44 CST 2021
     */
    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_sjleixing
     *
     * @mbg.generated Thu May 20 10:15:44 CST 2021
     */
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_sjleixing
     *
     * @mbg.generated Thu May 20 10:15:44 CST 2021
     */
    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_sjleixing
     *
     * @mbg.generated Thu May 20 10:15:44 CST 2021
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
     * This method corresponds to the database table t_sjleixing
     *
     * @mbg.generated Thu May 20 10:15:44 CST 2021
     */
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_sjleixing
     *
     * @mbg.generated Thu May 20 10:15:44 CST 2021
     */
    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table t_sjleixing
     *
     * @mbg.generated Thu May 20 10:15:44 CST 2021
     */
    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<>();
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

        public Criteria andSjleixingidIsNull() {
            addCriterion("sjleixingId is null");
            return (Criteria) this;
        }

        public Criteria andSjleixingidIsNotNull() {
            addCriterion("sjleixingId is not null");
            return (Criteria) this;
        }

        public Criteria andSjleixingidEqualTo(Integer value) {
            addCriterion("sjleixingId =", value, "sjleixingid");
            return (Criteria) this;
        }

        public Criteria andSjleixingidNotEqualTo(Integer value) {
            addCriterion("sjleixingId <>", value, "sjleixingid");
            return (Criteria) this;
        }

        public Criteria andSjleixingidGreaterThan(Integer value) {
            addCriterion("sjleixingId >", value, "sjleixingid");
            return (Criteria) this;
        }

        public Criteria andSjleixingidGreaterThanOrEqualTo(Integer value) {
            addCriterion("sjleixingId >=", value, "sjleixingid");
            return (Criteria) this;
        }

        public Criteria andSjleixingidLessThan(Integer value) {
            addCriterion("sjleixingId <", value, "sjleixingid");
            return (Criteria) this;
        }

        public Criteria andSjleixingidLessThanOrEqualTo(Integer value) {
            addCriterion("sjleixingId <=", value, "sjleixingid");
            return (Criteria) this;
        }

        public Criteria andSjleixingidIn(List<Integer> values) {
            addCriterion("sjleixingId in", values, "sjleixingid");
            return (Criteria) this;
        }

        public Criteria andSjleixingidNotIn(List<Integer> values) {
            addCriterion("sjleixingId not in", values, "sjleixingid");
            return (Criteria) this;
        }

        public Criteria andSjleixingidBetween(Integer value1, Integer value2) {
            addCriterion("sjleixingId between", value1, value2, "sjleixingid");
            return (Criteria) this;
        }

        public Criteria andSjleixingidNotBetween(Integer value1, Integer value2) {
            addCriterion("sjleixingId not between", value1, value2, "sjleixingid");
            return (Criteria) this;
        }

        public Criteria andSjleixingnameIsNull() {
            addCriterion("sjleixingName is null");
            return (Criteria) this;
        }

        public Criteria andSjleixingnameIsNotNull() {
            addCriterion("sjleixingName is not null");
            return (Criteria) this;
        }

        public Criteria andSjleixingnameEqualTo(String value) {
            addCriterion("sjleixingName =", value, "sjleixingname");
            return (Criteria) this;
        }

        public Criteria andSjleixingnameNotEqualTo(String value) {
            addCriterion("sjleixingName <>", value, "sjleixingname");
            return (Criteria) this;
        }

        public Criteria andSjleixingnameGreaterThan(String value) {
            addCriterion("sjleixingName >", value, "sjleixingname");
            return (Criteria) this;
        }

        public Criteria andSjleixingnameGreaterThanOrEqualTo(String value) {
            addCriterion("sjleixingName >=", value, "sjleixingname");
            return (Criteria) this;
        }

        public Criteria andSjleixingnameLessThan(String value) {
            addCriterion("sjleixingName <", value, "sjleixingname");
            return (Criteria) this;
        }

        public Criteria andSjleixingnameLessThanOrEqualTo(String value) {
            addCriterion("sjleixingName <=", value, "sjleixingname");
            return (Criteria) this;
        }

        public Criteria andSjleixingnameLike(String value) {
            addCriterion("sjleixingName like", value, "sjleixingname");
            return (Criteria) this;
        }

        public Criteria andSjleixingnameNotLike(String value) {
            addCriterion("sjleixingName not like", value, "sjleixingname");
            return (Criteria) this;
        }

        public Criteria andSjleixingnameIn(List<String> values) {
            addCriterion("sjleixingName in", values, "sjleixingname");
            return (Criteria) this;
        }

        public Criteria andSjleixingnameNotIn(List<String> values) {
            addCriterion("sjleixingName not in", values, "sjleixingname");
            return (Criteria) this;
        }

        public Criteria andSjleixingnameBetween(String value1, String value2) {
            addCriterion("sjleixingName between", value1, value2, "sjleixingname");
            return (Criteria) this;
        }

        public Criteria andSjleixingnameNotBetween(String value1, String value2) {
            addCriterion("sjleixingName not between", value1, value2, "sjleixingname");
            return (Criteria) this;
        }

        public Criteria andSjleixingmarkIsNull() {
            addCriterion("sjleixingMark is null");
            return (Criteria) this;
        }

        public Criteria andSjleixingmarkIsNotNull() {
            addCriterion("sjleixingMark is not null");
            return (Criteria) this;
        }

        public Criteria andSjleixingmarkEqualTo(String value) {
            addCriterion("sjleixingMark =", value, "sjleixingmark");
            return (Criteria) this;
        }

        public Criteria andSjleixingmarkNotEqualTo(String value) {
            addCriterion("sjleixingMark <>", value, "sjleixingmark");
            return (Criteria) this;
        }

        public Criteria andSjleixingmarkGreaterThan(String value) {
            addCriterion("sjleixingMark >", value, "sjleixingmark");
            return (Criteria) this;
        }

        public Criteria andSjleixingmarkGreaterThanOrEqualTo(String value) {
            addCriterion("sjleixingMark >=", value, "sjleixingmark");
            return (Criteria) this;
        }

        public Criteria andSjleixingmarkLessThan(String value) {
            addCriterion("sjleixingMark <", value, "sjleixingmark");
            return (Criteria) this;
        }

        public Criteria andSjleixingmarkLessThanOrEqualTo(String value) {
            addCriterion("sjleixingMark <=", value, "sjleixingmark");
            return (Criteria) this;
        }

        public Criteria andSjleixingmarkLike(String value) {
            addCriterion("sjleixingMark like", value, "sjleixingmark");
            return (Criteria) this;
        }

        public Criteria andSjleixingmarkNotLike(String value) {
            addCriterion("sjleixingMark not like", value, "sjleixingmark");
            return (Criteria) this;
        }

        public Criteria andSjleixingmarkIn(List<String> values) {
            addCriterion("sjleixingMark in", values, "sjleixingmark");
            return (Criteria) this;
        }

        public Criteria andSjleixingmarkNotIn(List<String> values) {
            addCriterion("sjleixingMark not in", values, "sjleixingmark");
            return (Criteria) this;
        }

        public Criteria andSjleixingmarkBetween(String value1, String value2) {
            addCriterion("sjleixingMark between", value1, value2, "sjleixingmark");
            return (Criteria) this;
        }

        public Criteria andSjleixingmarkNotBetween(String value1, String value2) {
            addCriterion("sjleixingMark not between", value1, value2, "sjleixingmark");
            return (Criteria) this;
        }

        public Criteria andSjleixingmark1IsNull() {
            addCriterion("sjleixingMark1 is null");
            return (Criteria) this;
        }

        public Criteria andSjleixingmark1IsNotNull() {
            addCriterion("sjleixingMark1 is not null");
            return (Criteria) this;
        }

        public Criteria andSjleixingmark1EqualTo(String value) {
            addCriterion("sjleixingMark1 =", value, "sjleixingmark1");
            return (Criteria) this;
        }

        public Criteria andSjleixingmark1NotEqualTo(String value) {
            addCriterion("sjleixingMark1 <>", value, "sjleixingmark1");
            return (Criteria) this;
        }

        public Criteria andSjleixingmark1GreaterThan(String value) {
            addCriterion("sjleixingMark1 >", value, "sjleixingmark1");
            return (Criteria) this;
        }

        public Criteria andSjleixingmark1GreaterThanOrEqualTo(String value) {
            addCriterion("sjleixingMark1 >=", value, "sjleixingmark1");
            return (Criteria) this;
        }

        public Criteria andSjleixingmark1LessThan(String value) {
            addCriterion("sjleixingMark1 <", value, "sjleixingmark1");
            return (Criteria) this;
        }

        public Criteria andSjleixingmark1LessThanOrEqualTo(String value) {
            addCriterion("sjleixingMark1 <=", value, "sjleixingmark1");
            return (Criteria) this;
        }

        public Criteria andSjleixingmark1Like(String value) {
            addCriterion("sjleixingMark1 like", value, "sjleixingmark1");
            return (Criteria) this;
        }

        public Criteria andSjleixingmark1NotLike(String value) {
            addCriterion("sjleixingMark1 not like", value, "sjleixingmark1");
            return (Criteria) this;
        }

        public Criteria andSjleixingmark1In(List<String> values) {
            addCriterion("sjleixingMark1 in", values, "sjleixingmark1");
            return (Criteria) this;
        }

        public Criteria andSjleixingmark1NotIn(List<String> values) {
            addCriterion("sjleixingMark1 not in", values, "sjleixingmark1");
            return (Criteria) this;
        }

        public Criteria andSjleixingmark1Between(String value1, String value2) {
            addCriterion("sjleixingMark1 between", value1, value2, "sjleixingmark1");
            return (Criteria) this;
        }

        public Criteria andSjleixingmark1NotBetween(String value1, String value2) {
            addCriterion("sjleixingMark1 not between", value1, value2, "sjleixingmark1");
            return (Criteria) this;
        }

        public Criteria andSjleixingmark2IsNull() {
            addCriterion("sjleixingMark2 is null");
            return (Criteria) this;
        }

        public Criteria andSjleixingmark2IsNotNull() {
            addCriterion("sjleixingMark2 is not null");
            return (Criteria) this;
        }

        public Criteria andSjleixingmark2EqualTo(String value) {
            addCriterion("sjleixingMark2 =", value, "sjleixingmark2");
            return (Criteria) this;
        }

        public Criteria andSjleixingmark2NotEqualTo(String value) {
            addCriterion("sjleixingMark2 <>", value, "sjleixingmark2");
            return (Criteria) this;
        }

        public Criteria andSjleixingmark2GreaterThan(String value) {
            addCriterion("sjleixingMark2 >", value, "sjleixingmark2");
            return (Criteria) this;
        }

        public Criteria andSjleixingmark2GreaterThanOrEqualTo(String value) {
            addCriterion("sjleixingMark2 >=", value, "sjleixingmark2");
            return (Criteria) this;
        }

        public Criteria andSjleixingmark2LessThan(String value) {
            addCriterion("sjleixingMark2 <", value, "sjleixingmark2");
            return (Criteria) this;
        }

        public Criteria andSjleixingmark2LessThanOrEqualTo(String value) {
            addCriterion("sjleixingMark2 <=", value, "sjleixingmark2");
            return (Criteria) this;
        }

        public Criteria andSjleixingmark2Like(String value) {
            addCriterion("sjleixingMark2 like", value, "sjleixingmark2");
            return (Criteria) this;
        }

        public Criteria andSjleixingmark2NotLike(String value) {
            addCriterion("sjleixingMark2 not like", value, "sjleixingmark2");
            return (Criteria) this;
        }

        public Criteria andSjleixingmark2In(List<String> values) {
            addCriterion("sjleixingMark2 in", values, "sjleixingmark2");
            return (Criteria) this;
        }

        public Criteria andSjleixingmark2NotIn(List<String> values) {
            addCriterion("sjleixingMark2 not in", values, "sjleixingmark2");
            return (Criteria) this;
        }

        public Criteria andSjleixingmark2Between(String value1, String value2) {
            addCriterion("sjleixingMark2 between", value1, value2, "sjleixingmark2");
            return (Criteria) this;
        }

        public Criteria andSjleixingmark2NotBetween(String value1, String value2) {
            addCriterion("sjleixingMark2 not between", value1, value2, "sjleixingmark2");
            return (Criteria) this;
        }

        public Criteria andSjleixingphoneIsNull() {
            addCriterion("sjleixingPhone is null");
            return (Criteria) this;
        }

        public Criteria andSjleixingphoneIsNotNull() {
            addCriterion("sjleixingPhone is not null");
            return (Criteria) this;
        }

        public Criteria andSjleixingphoneEqualTo(String value) {
            addCriterion("sjleixingPhone =", value, "sjleixingphone");
            return (Criteria) this;
        }

        public Criteria andSjleixingphoneNotEqualTo(String value) {
            addCriterion("sjleixingPhone <>", value, "sjleixingphone");
            return (Criteria) this;
        }

        public Criteria andSjleixingphoneGreaterThan(String value) {
            addCriterion("sjleixingPhone >", value, "sjleixingphone");
            return (Criteria) this;
        }

        public Criteria andSjleixingphoneGreaterThanOrEqualTo(String value) {
            addCriterion("sjleixingPhone >=", value, "sjleixingphone");
            return (Criteria) this;
        }

        public Criteria andSjleixingphoneLessThan(String value) {
            addCriterion("sjleixingPhone <", value, "sjleixingphone");
            return (Criteria) this;
        }

        public Criteria andSjleixingphoneLessThanOrEqualTo(String value) {
            addCriterion("sjleixingPhone <=", value, "sjleixingphone");
            return (Criteria) this;
        }

        public Criteria andSjleixingphoneLike(String value) {
            addCriterion("sjleixingPhone like", value, "sjleixingphone");
            return (Criteria) this;
        }

        public Criteria andSjleixingphoneNotLike(String value) {
            addCriterion("sjleixingPhone not like", value, "sjleixingphone");
            return (Criteria) this;
        }

        public Criteria andSjleixingphoneIn(List<String> values) {
            addCriterion("sjleixingPhone in", values, "sjleixingphone");
            return (Criteria) this;
        }

        public Criteria andSjleixingphoneNotIn(List<String> values) {
            addCriterion("sjleixingPhone not in", values, "sjleixingphone");
            return (Criteria) this;
        }

        public Criteria andSjleixingphoneBetween(String value1, String value2) {
            addCriterion("sjleixingPhone between", value1, value2, "sjleixingphone");
            return (Criteria) this;
        }

        public Criteria andSjleixingphoneNotBetween(String value1, String value2) {
            addCriterion("sjleixingPhone not between", value1, value2, "sjleixingphone");
            return (Criteria) this;
        }

        public Criteria andSjleixingdizhiIsNull() {
            addCriterion("sjleixingDizhi is null");
            return (Criteria) this;
        }

        public Criteria andSjleixingdizhiIsNotNull() {
            addCriterion("sjleixingDizhi is not null");
            return (Criteria) this;
        }

        public Criteria andSjleixingdizhiEqualTo(String value) {
            addCriterion("sjleixingDizhi =", value, "sjleixingdizhi");
            return (Criteria) this;
        }

        public Criteria andSjleixingdizhiNotEqualTo(String value) {
            addCriterion("sjleixingDizhi <>", value, "sjleixingdizhi");
            return (Criteria) this;
        }

        public Criteria andSjleixingdizhiGreaterThan(String value) {
            addCriterion("sjleixingDizhi >", value, "sjleixingdizhi");
            return (Criteria) this;
        }

        public Criteria andSjleixingdizhiGreaterThanOrEqualTo(String value) {
            addCriterion("sjleixingDizhi >=", value, "sjleixingdizhi");
            return (Criteria) this;
        }

        public Criteria andSjleixingdizhiLessThan(String value) {
            addCriterion("sjleixingDizhi <", value, "sjleixingdizhi");
            return (Criteria) this;
        }

        public Criteria andSjleixingdizhiLessThanOrEqualTo(String value) {
            addCriterion("sjleixingDizhi <=", value, "sjleixingdizhi");
            return (Criteria) this;
        }

        public Criteria andSjleixingdizhiLike(String value) {
            addCriterion("sjleixingDizhi like", value, "sjleixingdizhi");
            return (Criteria) this;
        }

        public Criteria andSjleixingdizhiNotLike(String value) {
            addCriterion("sjleixingDizhi not like", value, "sjleixingdizhi");
            return (Criteria) this;
        }

        public Criteria andSjleixingdizhiIn(List<String> values) {
            addCriterion("sjleixingDizhi in", values, "sjleixingdizhi");
            return (Criteria) this;
        }

        public Criteria andSjleixingdizhiNotIn(List<String> values) {
            addCriterion("sjleixingDizhi not in", values, "sjleixingdizhi");
            return (Criteria) this;
        }

        public Criteria andSjleixingdizhiBetween(String value1, String value2) {
            addCriterion("sjleixingDizhi between", value1, value2, "sjleixingdizhi");
            return (Criteria) this;
        }

        public Criteria andSjleixingdizhiNotBetween(String value1, String value2) {
            addCriterion("sjleixingDizhi not between", value1, value2, "sjleixingdizhi");
            return (Criteria) this;
        }

        public Criteria andSjleixingdateIsNull() {
            addCriterion("sjleixingDate is null");
            return (Criteria) this;
        }

        public Criteria andSjleixingdateIsNotNull() {
            addCriterion("sjleixingDate is not null");
            return (Criteria) this;
        }

        public Criteria andSjleixingdateEqualTo(Date value) {
            addCriterion("sjleixingDate =", value, "sjleixingdate");
            return (Criteria) this;
        }

        public Criteria andSjleixingdateNotEqualTo(Date value) {
            addCriterion("sjleixingDate <>", value, "sjleixingdate");
            return (Criteria) this;
        }

        public Criteria andSjleixingdateGreaterThan(Date value) {
            addCriterion("sjleixingDate >", value, "sjleixingdate");
            return (Criteria) this;
        }

        public Criteria andSjleixingdateGreaterThanOrEqualTo(Date value) {
            addCriterion("sjleixingDate >=", value, "sjleixingdate");
            return (Criteria) this;
        }

        public Criteria andSjleixingdateLessThan(Date value) {
            addCriterion("sjleixingDate <", value, "sjleixingdate");
            return (Criteria) this;
        }

        public Criteria andSjleixingdateLessThanOrEqualTo(Date value) {
            addCriterion("sjleixingDate <=", value, "sjleixingdate");
            return (Criteria) this;
        }

        public Criteria andSjleixingdateIn(List<Date> values) {
            addCriterion("sjleixingDate in", values, "sjleixingdate");
            return (Criteria) this;
        }

        public Criteria andSjleixingdateNotIn(List<Date> values) {
            addCriterion("sjleixingDate not in", values, "sjleixingdate");
            return (Criteria) this;
        }

        public Criteria andSjleixingdateBetween(Date value1, Date value2) {
            addCriterion("sjleixingDate between", value1, value2, "sjleixingdate");
            return (Criteria) this;
        }

        public Criteria andSjleixingdateNotBetween(Date value1, Date value2) {
            addCriterion("sjleixingDate not between", value1, value2, "sjleixingdate");
            return (Criteria) this;
        }

        public Criteria andSjleixingdate1IsNull() {
            addCriterion("sjleixingDate1 is null");
            return (Criteria) this;
        }

        public Criteria andSjleixingdate1IsNotNull() {
            addCriterion("sjleixingDate1 is not null");
            return (Criteria) this;
        }

        public Criteria andSjleixingdate1EqualTo(Date value) {
            addCriterion("sjleixingDate1 =", value, "sjleixingdate1");
            return (Criteria) this;
        }

        public Criteria andSjleixingdate1NotEqualTo(Date value) {
            addCriterion("sjleixingDate1 <>", value, "sjleixingdate1");
            return (Criteria) this;
        }

        public Criteria andSjleixingdate1GreaterThan(Date value) {
            addCriterion("sjleixingDate1 >", value, "sjleixingdate1");
            return (Criteria) this;
        }

        public Criteria andSjleixingdate1GreaterThanOrEqualTo(Date value) {
            addCriterion("sjleixingDate1 >=", value, "sjleixingdate1");
            return (Criteria) this;
        }

        public Criteria andSjleixingdate1LessThan(Date value) {
            addCriterion("sjleixingDate1 <", value, "sjleixingdate1");
            return (Criteria) this;
        }

        public Criteria andSjleixingdate1LessThanOrEqualTo(Date value) {
            addCriterion("sjleixingDate1 <=", value, "sjleixingdate1");
            return (Criteria) this;
        }

        public Criteria andSjleixingdate1In(List<Date> values) {
            addCriterion("sjleixingDate1 in", values, "sjleixingdate1");
            return (Criteria) this;
        }

        public Criteria andSjleixingdate1NotIn(List<Date> values) {
            addCriterion("sjleixingDate1 not in", values, "sjleixingdate1");
            return (Criteria) this;
        }

        public Criteria andSjleixingdate1Between(Date value1, Date value2) {
            addCriterion("sjleixingDate1 between", value1, value2, "sjleixingdate1");
            return (Criteria) this;
        }

        public Criteria andSjleixingdate1NotBetween(Date value1, Date value2) {
            addCriterion("sjleixingDate1 not between", value1, value2, "sjleixingdate1");
            return (Criteria) this;
        }

        public Criteria andSjleixingtypeIsNull() {
            addCriterion("sjleixingType is null");
            return (Criteria) this;
        }

        public Criteria andSjleixingtypeIsNotNull() {
            addCriterion("sjleixingType is not null");
            return (Criteria) this;
        }

        public Criteria andSjleixingtypeEqualTo(Integer value) {
            addCriterion("sjleixingType =", value, "sjleixingtype");
            return (Criteria) this;
        }

        public Criteria andSjleixingtypeNotEqualTo(Integer value) {
            addCriterion("sjleixingType <>", value, "sjleixingtype");
            return (Criteria) this;
        }

        public Criteria andSjleixingtypeGreaterThan(Integer value) {
            addCriterion("sjleixingType >", value, "sjleixingtype");
            return (Criteria) this;
        }

        public Criteria andSjleixingtypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("sjleixingType >=", value, "sjleixingtype");
            return (Criteria) this;
        }

        public Criteria andSjleixingtypeLessThan(Integer value) {
            addCriterion("sjleixingType <", value, "sjleixingtype");
            return (Criteria) this;
        }

        public Criteria andSjleixingtypeLessThanOrEqualTo(Integer value) {
            addCriterion("sjleixingType <=", value, "sjleixingtype");
            return (Criteria) this;
        }

        public Criteria andSjleixingtypeIn(List<Integer> values) {
            addCriterion("sjleixingType in", values, "sjleixingtype");
            return (Criteria) this;
        }

        public Criteria andSjleixingtypeNotIn(List<Integer> values) {
            addCriterion("sjleixingType not in", values, "sjleixingtype");
            return (Criteria) this;
        }

        public Criteria andSjleixingtypeBetween(Integer value1, Integer value2) {
            addCriterion("sjleixingType between", value1, value2, "sjleixingtype");
            return (Criteria) this;
        }

        public Criteria andSjleixingtypeNotBetween(Integer value1, Integer value2) {
            addCriterion("sjleixingType not between", value1, value2, "sjleixingtype");
            return (Criteria) this;
        }

        public Criteria andSjleixingtype1IsNull() {
            addCriterion("sjleixingType1 is null");
            return (Criteria) this;
        }

        public Criteria andSjleixingtype1IsNotNull() {
            addCriterion("sjleixingType1 is not null");
            return (Criteria) this;
        }

        public Criteria andSjleixingtype1EqualTo(Integer value) {
            addCriterion("sjleixingType1 =", value, "sjleixingtype1");
            return (Criteria) this;
        }

        public Criteria andSjleixingtype1NotEqualTo(Integer value) {
            addCriterion("sjleixingType1 <>", value, "sjleixingtype1");
            return (Criteria) this;
        }

        public Criteria andSjleixingtype1GreaterThan(Integer value) {
            addCriterion("sjleixingType1 >", value, "sjleixingtype1");
            return (Criteria) this;
        }

        public Criteria andSjleixingtype1GreaterThanOrEqualTo(Integer value) {
            addCriterion("sjleixingType1 >=", value, "sjleixingtype1");
            return (Criteria) this;
        }

        public Criteria andSjleixingtype1LessThan(Integer value) {
            addCriterion("sjleixingType1 <", value, "sjleixingtype1");
            return (Criteria) this;
        }

        public Criteria andSjleixingtype1LessThanOrEqualTo(Integer value) {
            addCriterion("sjleixingType1 <=", value, "sjleixingtype1");
            return (Criteria) this;
        }

        public Criteria andSjleixingtype1In(List<Integer> values) {
            addCriterion("sjleixingType1 in", values, "sjleixingtype1");
            return (Criteria) this;
        }

        public Criteria andSjleixingtype1NotIn(List<Integer> values) {
            addCriterion("sjleixingType1 not in", values, "sjleixingtype1");
            return (Criteria) this;
        }

        public Criteria andSjleixingtype1Between(Integer value1, Integer value2) {
            addCriterion("sjleixingType1 between", value1, value2, "sjleixingtype1");
            return (Criteria) this;
        }

        public Criteria andSjleixingtype1NotBetween(Integer value1, Integer value2) {
            addCriterion("sjleixingType1 not between", value1, value2, "sjleixingtype1");
            return (Criteria) this;
        }

        public Criteria andSjleixingdoubleIsNull() {
            addCriterion("sjleixingDouble is null");
            return (Criteria) this;
        }

        public Criteria andSjleixingdoubleIsNotNull() {
            addCriterion("sjleixingDouble is not null");
            return (Criteria) this;
        }

        public Criteria andSjleixingdoubleEqualTo(Double value) {
            addCriterion("sjleixingDouble =", value, "sjleixingdouble");
            return (Criteria) this;
        }

        public Criteria andSjleixingdoubleNotEqualTo(Double value) {
            addCriterion("sjleixingDouble <>", value, "sjleixingdouble");
            return (Criteria) this;
        }

        public Criteria andSjleixingdoubleGreaterThan(Double value) {
            addCriterion("sjleixingDouble >", value, "sjleixingdouble");
            return (Criteria) this;
        }

        public Criteria andSjleixingdoubleGreaterThanOrEqualTo(Double value) {
            addCriterion("sjleixingDouble >=", value, "sjleixingdouble");
            return (Criteria) this;
        }

        public Criteria andSjleixingdoubleLessThan(Double value) {
            addCriterion("sjleixingDouble <", value, "sjleixingdouble");
            return (Criteria) this;
        }

        public Criteria andSjleixingdoubleLessThanOrEqualTo(Double value) {
            addCriterion("sjleixingDouble <=", value, "sjleixingdouble");
            return (Criteria) this;
        }

        public Criteria andSjleixingdoubleIn(List<Double> values) {
            addCriterion("sjleixingDouble in", values, "sjleixingdouble");
            return (Criteria) this;
        }

        public Criteria andSjleixingdoubleNotIn(List<Double> values) {
            addCriterion("sjleixingDouble not in", values, "sjleixingdouble");
            return (Criteria) this;
        }

        public Criteria andSjleixingdoubleBetween(Double value1, Double value2) {
            addCriterion("sjleixingDouble between", value1, value2, "sjleixingdouble");
            return (Criteria) this;
        }

        public Criteria andSjleixingdoubleNotBetween(Double value1, Double value2) {
            addCriterion("sjleixingDouble not between", value1, value2, "sjleixingdouble");
            return (Criteria) this;
        }

        public Criteria andSjleixingdouble1IsNull() {
            addCriterion("sjleixingDouble1 is null");
            return (Criteria) this;
        }

        public Criteria andSjleixingdouble1IsNotNull() {
            addCriterion("sjleixingDouble1 is not null");
            return (Criteria) this;
        }

        public Criteria andSjleixingdouble1EqualTo(Double value) {
            addCriterion("sjleixingDouble1 =", value, "sjleixingdouble1");
            return (Criteria) this;
        }

        public Criteria andSjleixingdouble1NotEqualTo(Double value) {
            addCriterion("sjleixingDouble1 <>", value, "sjleixingdouble1");
            return (Criteria) this;
        }

        public Criteria andSjleixingdouble1GreaterThan(Double value) {
            addCriterion("sjleixingDouble1 >", value, "sjleixingdouble1");
            return (Criteria) this;
        }

        public Criteria andSjleixingdouble1GreaterThanOrEqualTo(Double value) {
            addCriterion("sjleixingDouble1 >=", value, "sjleixingdouble1");
            return (Criteria) this;
        }

        public Criteria andSjleixingdouble1LessThan(Double value) {
            addCriterion("sjleixingDouble1 <", value, "sjleixingdouble1");
            return (Criteria) this;
        }

        public Criteria andSjleixingdouble1LessThanOrEqualTo(Double value) {
            addCriterion("sjleixingDouble1 <=", value, "sjleixingdouble1");
            return (Criteria) this;
        }

        public Criteria andSjleixingdouble1In(List<Double> values) {
            addCriterion("sjleixingDouble1 in", values, "sjleixingdouble1");
            return (Criteria) this;
        }

        public Criteria andSjleixingdouble1NotIn(List<Double> values) {
            addCriterion("sjleixingDouble1 not in", values, "sjleixingdouble1");
            return (Criteria) this;
        }

        public Criteria andSjleixingdouble1Between(Double value1, Double value2) {
            addCriterion("sjleixingDouble1 between", value1, value2, "sjleixingdouble1");
            return (Criteria) this;
        }

        public Criteria andSjleixingdouble1NotBetween(Double value1, Double value2) {
            addCriterion("sjleixingDouble1 not between", value1, value2, "sjleixingdouble1");
            return (Criteria) this;
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table t_sjleixing
     *
     * @mbg.generated do_not_delete_during_merge Thu May 20 10:15:44 CST 2021
     */
    public static class Criteria extends GeneratedCriteria {
        protected Criteria() {
            super();
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table t_sjleixing
     *
     * @mbg.generated Thu May 20 10:15:44 CST 2021
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