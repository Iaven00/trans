package com.example.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TransunitExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TransunitExample() {
        oredCriteria = new ArrayList<>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

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

        public Criteria andTransunitidIsNull() {
            addCriterion("transunitId is null");
            return (Criteria) this;
        }

        public Criteria andTransunitidIsNotNull() {
            addCriterion("transunitId is not null");
            return (Criteria) this;
        }

        public Criteria andTransunitidEqualTo(Integer value) {
            addCriterion("transunitId =", value, "transunitid");
            return (Criteria) this;
        }

        public Criteria andTransunitidNotEqualTo(Integer value) {
            addCriterion("transunitId <>", value, "transunitid");
            return (Criteria) this;
        }

        public Criteria andTransunitidGreaterThan(Integer value) {
            addCriterion("transunitId >", value, "transunitid");
            return (Criteria) this;
        }

        public Criteria andTransunitidGreaterThanOrEqualTo(Integer value) {
            addCriterion("transunitId >=", value, "transunitid");
            return (Criteria) this;
        }

        public Criteria andTransunitidLessThan(Integer value) {
            addCriterion("transunitId <", value, "transunitid");
            return (Criteria) this;
        }

        public Criteria andTransunitidLessThanOrEqualTo(Integer value) {
            addCriterion("transunitId <=", value, "transunitid");
            return (Criteria) this;
        }

        public Criteria andTransunitidIn(List<Integer> values) {
            addCriterion("transunitId in", values, "transunitid");
            return (Criteria) this;
        }

        public Criteria andTransunitidNotIn(List<Integer> values) {
            addCriterion("transunitId not in", values, "transunitid");
            return (Criteria) this;
        }

        public Criteria andTransunitidBetween(Integer value1, Integer value2) {
            addCriterion("transunitId between", value1, value2, "transunitid");
            return (Criteria) this;
        }

        public Criteria andTransunitidNotBetween(Integer value1, Integer value2) {
            addCriterion("transunitId not between", value1, value2, "transunitid");
            return (Criteria) this;
        }

        public Criteria andNameIsNull() {
            addCriterion("name is null");
            return (Criteria) this;
        }

        public Criteria andNameIsNotNull() {
            addCriterion("name is not null");
            return (Criteria) this;
        }

        public Criteria andNameEqualTo(String value) {
            addCriterion("name =", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotEqualTo(String value) {
            addCriterion("name <>", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThan(String value) {
            addCriterion("name >", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThanOrEqualTo(String value) {
            addCriterion("name >=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThan(String value) {
            addCriterion("name <", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThanOrEqualTo(String value) {
            addCriterion("name <=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLike(String value) {
            addCriterion("name like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotLike(String value) {
            addCriterion("name not like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameIn(List<String> values) {
            addCriterion("name in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotIn(List<String> values) {
            addCriterion("name not in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameBetween(String value1, String value2) {
            addCriterion("name between", value1, value2, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotBetween(String value1, String value2) {
            addCriterion("name not between", value1, value2, "name");
            return (Criteria) this;
        }

        public Criteria andContactemailIsNull() {
            addCriterion("contactemail is null");
            return (Criteria) this;
        }

        public Criteria andContactemailIsNotNull() {
            addCriterion("contactemail is not null");
            return (Criteria) this;
        }

        public Criteria andContactemailEqualTo(String value) {
            addCriterion("contactemail =", value, "contactemail");
            return (Criteria) this;
        }

        public Criteria andContactemailNotEqualTo(String value) {
            addCriterion("contactemail <>", value, "contactemail");
            return (Criteria) this;
        }

        public Criteria andContactemailGreaterThan(String value) {
            addCriterion("contactemail >", value, "contactemail");
            return (Criteria) this;
        }

        public Criteria andContactemailGreaterThanOrEqualTo(String value) {
            addCriterion("contactemail >=", value, "contactemail");
            return (Criteria) this;
        }

        public Criteria andContactemailLessThan(String value) {
            addCriterion("contactemail <", value, "contactemail");
            return (Criteria) this;
        }

        public Criteria andContactemailLessThanOrEqualTo(String value) {
            addCriterion("contactemail <=", value, "contactemail");
            return (Criteria) this;
        }

        public Criteria andContactemailLike(String value) {
            addCriterion("contactemail like", value, "contactemail");
            return (Criteria) this;
        }

        public Criteria andContactemailNotLike(String value) {
            addCriterion("contactemail not like", value, "contactemail");
            return (Criteria) this;
        }

        public Criteria andContactemailIn(List<String> values) {
            addCriterion("contactemail in", values, "contactemail");
            return (Criteria) this;
        }

        public Criteria andContactemailNotIn(List<String> values) {
            addCriterion("contactemail not in", values, "contactemail");
            return (Criteria) this;
        }

        public Criteria andContactemailBetween(String value1, String value2) {
            addCriterion("contactemail between", value1, value2, "contactemail");
            return (Criteria) this;
        }

        public Criteria andContactemailNotBetween(String value1, String value2) {
            addCriterion("contactemail not between", value1, value2, "contactemail");
            return (Criteria) this;
        }

        public Criteria andRegistrationtimeIsNull() {
            addCriterion("Registrationtime is null");
            return (Criteria) this;
        }

        public Criteria andRegistrationtimeIsNotNull() {
            addCriterion("Registrationtime is not null");
            return (Criteria) this;
        }

        public Criteria andRegistrationtimeEqualTo(Date value) {
            addCriterion("Registrationtime =", value, "registrationtime");
            return (Criteria) this;
        }

        public Criteria andRegistrationtimeNotEqualTo(Date value) {
            addCriterion("Registrationtime <>", value, "registrationtime");
            return (Criteria) this;
        }

        public Criteria andRegistrationtimeGreaterThan(Date value) {
            addCriterion("Registrationtime >", value, "registrationtime");
            return (Criteria) this;
        }

        public Criteria andRegistrationtimeGreaterThanOrEqualTo(Date value) {
            addCriterion("Registrationtime >=", value, "registrationtime");
            return (Criteria) this;
        }

        public Criteria andRegistrationtimeLessThan(Date value) {
            addCriterion("Registrationtime <", value, "registrationtime");
            return (Criteria) this;
        }

        public Criteria andRegistrationtimeLessThanOrEqualTo(Date value) {
            addCriterion("Registrationtime <=", value, "registrationtime");
            return (Criteria) this;
        }

        public Criteria andRegistrationtimeIn(List<Date> values) {
            addCriterion("Registrationtime in", values, "registrationtime");
            return (Criteria) this;
        }

        public Criteria andRegistrationtimeNotIn(List<Date> values) {
            addCriterion("Registrationtime not in", values, "registrationtime");
            return (Criteria) this;
        }

        public Criteria andRegistrationtimeBetween(Date value1, Date value2) {
            addCriterion("Registrationtime between", value1, value2, "registrationtime");
            return (Criteria) this;
        }

        public Criteria andRegistrationtimeNotBetween(Date value1, Date value2) {
            addCriterion("Registrationtime not between", value1, value2, "registrationtime");
            return (Criteria) this;
        }

        public Criteria andCompanyidIsNull() {
            addCriterion("companyid is null");
            return (Criteria) this;
        }

        public Criteria andCompanyidIsNotNull() {
            addCriterion("companyid is not null");
            return (Criteria) this;
        }

        public Criteria andCompanyidEqualTo(Integer value) {
            addCriterion("companyid =", value, "companyid");
            return (Criteria) this;
        }

        public Criteria andCompanyidNotEqualTo(Integer value) {
            addCriterion("companyid <>", value, "companyid");
            return (Criteria) this;
        }

        public Criteria andCompanyidGreaterThan(Integer value) {
            addCriterion("companyid >", value, "companyid");
            return (Criteria) this;
        }

        public Criteria andCompanyidGreaterThanOrEqualTo(Integer value) {
            addCriterion("companyid >=", value, "companyid");
            return (Criteria) this;
        }

        public Criteria andCompanyidLessThan(Integer value) {
            addCriterion("companyid <", value, "companyid");
            return (Criteria) this;
        }

        public Criteria andCompanyidLessThanOrEqualTo(Integer value) {
            addCriterion("companyid <=", value, "companyid");
            return (Criteria) this;
        }

        public Criteria andCompanyidIn(List<Integer> values) {
            addCriterion("companyid in", values, "companyid");
            return (Criteria) this;
        }

        public Criteria andCompanyidNotIn(List<Integer> values) {
            addCriterion("companyid not in", values, "companyid");
            return (Criteria) this;
        }

        public Criteria andCompanyidBetween(Integer value1, Integer value2) {
            addCriterion("companyid between", value1, value2, "companyid");
            return (Criteria) this;
        }

        public Criteria andCompanyidNotBetween(Integer value1, Integer value2) {
            addCriterion("companyid not between", value1, value2, "companyid");
            return (Criteria) this;
        }

        public Criteria andTotalIsNull() {
            addCriterion("total is null");
            return (Criteria) this;
        }

        public Criteria andTotalIsNotNull() {
            addCriterion("total is not null");
            return (Criteria) this;
        }

        public Criteria andTotalEqualTo(Integer value) {
            addCriterion("total =", value, "total");
            return (Criteria) this;
        }

        public Criteria andTotalNotEqualTo(Integer value) {
            addCriterion("total <>", value, "total");
            return (Criteria) this;
        }

        public Criteria andTotalGreaterThan(Integer value) {
            addCriterion("total >", value, "total");
            return (Criteria) this;
        }

        public Criteria andTotalGreaterThanOrEqualTo(Integer value) {
            addCriterion("total >=", value, "total");
            return (Criteria) this;
        }

        public Criteria andTotalLessThan(Integer value) {
            addCriterion("total <", value, "total");
            return (Criteria) this;
        }

        public Criteria andTotalLessThanOrEqualTo(Integer value) {
            addCriterion("total <=", value, "total");
            return (Criteria) this;
        }

        public Criteria andTotalIn(List<Integer> values) {
            addCriterion("total in", values, "total");
            return (Criteria) this;
        }

        public Criteria andTotalNotIn(List<Integer> values) {
            addCriterion("total not in", values, "total");
            return (Criteria) this;
        }

        public Criteria andTotalBetween(Integer value1, Integer value2) {
            addCriterion("total between", value1, value2, "total");
            return (Criteria) this;
        }

        public Criteria andTotalNotBetween(Integer value1, Integer value2) {
            addCriterion("total not between", value1, value2, "total");
            return (Criteria) this;
        }

        public Criteria andRestIsNull() {
            addCriterion("rest is null");
            return (Criteria) this;
        }

        public Criteria andRestIsNotNull() {
            addCriterion("rest is not null");
            return (Criteria) this;
        }

        public Criteria andRestEqualTo(Integer value) {
            addCriterion("rest =", value, "rest");
            return (Criteria) this;
        }

        public Criteria andRestNotEqualTo(Integer value) {
            addCriterion("rest <>", value, "rest");
            return (Criteria) this;
        }

        public Criteria andRestGreaterThan(Integer value) {
            addCriterion("rest >", value, "rest");
            return (Criteria) this;
        }

        public Criteria andRestGreaterThanOrEqualTo(Integer value) {
            addCriterion("rest >=", value, "rest");
            return (Criteria) this;
        }

        public Criteria andRestLessThan(Integer value) {
            addCriterion("rest <", value, "rest");
            return (Criteria) this;
        }

        public Criteria andRestLessThanOrEqualTo(Integer value) {
            addCriterion("rest <=", value, "rest");
            return (Criteria) this;
        }

        public Criteria andRestIn(List<Integer> values) {
            addCriterion("rest in", values, "rest");
            return (Criteria) this;
        }

        public Criteria andRestNotIn(List<Integer> values) {
            addCriterion("rest not in", values, "rest");
            return (Criteria) this;
        }

        public Criteria andRestBetween(Integer value1, Integer value2) {
            addCriterion("rest between", value1, value2, "rest");
            return (Criteria) this;
        }

        public Criteria andRestNotBetween(Integer value1, Integer value2) {
            addCriterion("rest not between", value1, value2, "rest");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {
        protected Criteria() {
            super();
        }
    }

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