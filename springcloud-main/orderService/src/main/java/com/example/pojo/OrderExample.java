package com.example.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class OrderExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public OrderExample() {
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

        public Criteria andTransunitidIsNull() {
            addCriterion("transunitid is null");
            return (Criteria) this;
        }

        public Criteria andTransunitidIsNotNull() {
            addCriterion("transunitid is not null");
            return (Criteria) this;
        }

        public Criteria andTransunitidEqualTo(Integer value) {
            addCriterion("transunitid =", value, "transunitid");
            return (Criteria) this;
        }

        public Criteria andTransunitidNotEqualTo(Integer value) {
            addCriterion("transunitid <>", value, "transunitid");
            return (Criteria) this;
        }

        public Criteria andTransunitidGreaterThan(Integer value) {
            addCriterion("transunitid >", value, "transunitid");
            return (Criteria) this;
        }

        public Criteria andTransunitidGreaterThanOrEqualTo(Integer value) {
            addCriterion("transunitid >=", value, "transunitid");
            return (Criteria) this;
        }

        public Criteria andTransunitidLessThan(Integer value) {
            addCriterion("transunitid <", value, "transunitid");
            return (Criteria) this;
        }

        public Criteria andTransunitidLessThanOrEqualTo(Integer value) {
            addCriterion("transunitid <=", value, "transunitid");
            return (Criteria) this;
        }

        public Criteria andTransunitidIn(List<Integer> values) {
            addCriterion("transunitid in", values, "transunitid");
            return (Criteria) this;
        }

        public Criteria andTransunitidNotIn(List<Integer> values) {
            addCriterion("transunitid not in", values, "transunitid");
            return (Criteria) this;
        }

        public Criteria andTransunitidBetween(Integer value1, Integer value2) {
            addCriterion("transunitid between", value1, value2, "transunitid");
            return (Criteria) this;
        }

        public Criteria andTransunitidNotBetween(Integer value1, Integer value2) {
            addCriterion("transunitid not between", value1, value2, "transunitid");
            return (Criteria) this;
        }

        public Criteria andUseridIsNull() {
            addCriterion("userid is null");
            return (Criteria) this;
        }

        public Criteria andUseridIsNotNull() {
            addCriterion("userid is not null");
            return (Criteria) this;
        }

        public Criteria andUseridEqualTo(Integer value) {
            addCriterion("userid =", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridNotEqualTo(Integer value) {
            addCriterion("userid <>", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridGreaterThan(Integer value) {
            addCriterion("userid >", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridGreaterThanOrEqualTo(Integer value) {
            addCriterion("userid >=", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridLessThan(Integer value) {
            addCriterion("userid <", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridLessThanOrEqualTo(Integer value) {
            addCriterion("userid <=", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridIn(List<Integer> values) {
            addCriterion("userid in", values, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridNotIn(List<Integer> values) {
            addCriterion("userid not in", values, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridBetween(Integer value1, Integer value2) {
            addCriterion("userid between", value1, value2, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridNotBetween(Integer value1, Integer value2) {
            addCriterion("userid not between", value1, value2, "userid");
            return (Criteria) this;
        }

        public Criteria andCreatetimeIsNull() {
            addCriterion("createtime is null");
            return (Criteria) this;
        }

        public Criteria andCreatetimeIsNotNull() {
            addCriterion("createtime is not null");
            return (Criteria) this;
        }

        public Criteria andCreatetimeEqualTo(Date value) {
            addCriterion("createtime =", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeNotEqualTo(Date value) {
            addCriterion("createtime <>", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeGreaterThan(Date value) {
            addCriterion("createtime >", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeGreaterThanOrEqualTo(Date value) {
            addCriterion("createtime >=", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeLessThan(Date value) {
            addCriterion("createtime <", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeLessThanOrEqualTo(Date value) {
            addCriterion("createtime <=", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeIn(List<Date> values) {
            addCriterion("createtime in", values, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeNotIn(List<Date> values) {
            addCriterion("createtime not in", values, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeBetween(Date value1, Date value2) {
            addCriterion("createtime between", value1, value2, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeNotBetween(Date value1, Date value2) {
            addCriterion("createtime not between", value1, value2, "createtime");
            return (Criteria) this;
        }

        public Criteria andSetoutIsNull() {
            addCriterion("setout is null");
            return (Criteria) this;
        }

        public Criteria andSetoutIsNotNull() {
            addCriterion("setout is not null");
            return (Criteria) this;
        }

        public Criteria andSetoutEqualTo(String value) {
            addCriterion("setout =", value, "setout");
            return (Criteria) this;
        }

        public Criteria andSetoutNotEqualTo(String value) {
            addCriterion("setout <>", value, "setout");
            return (Criteria) this;
        }

        public Criteria andSetoutGreaterThan(String value) {
            addCriterion("setout >", value, "setout");
            return (Criteria) this;
        }

        public Criteria andSetoutGreaterThanOrEqualTo(String value) {
            addCriterion("setout >=", value, "setout");
            return (Criteria) this;
        }

        public Criteria andSetoutLessThan(String value) {
            addCriterion("setout <", value, "setout");
            return (Criteria) this;
        }

        public Criteria andSetoutLessThanOrEqualTo(String value) {
            addCriterion("setout <=", value, "setout");
            return (Criteria) this;
        }

        public Criteria andSetoutLike(String value) {
            addCriterion("setout like", value, "setout");
            return (Criteria) this;
        }

        public Criteria andSetoutNotLike(String value) {
            addCriterion("setout not like", value, "setout");
            return (Criteria) this;
        }

        public Criteria andSetoutIn(List<String> values) {
            addCriterion("setout in", values, "setout");
            return (Criteria) this;
        }

        public Criteria andSetoutNotIn(List<String> values) {
            addCriterion("setout not in", values, "setout");
            return (Criteria) this;
        }

        public Criteria andSetoutBetween(String value1, String value2) {
            addCriterion("setout between", value1, value2, "setout");
            return (Criteria) this;
        }

        public Criteria andSetoutNotBetween(String value1, String value2) {
            addCriterion("setout not between", value1, value2, "setout");
            return (Criteria) this;
        }

        public Criteria andDestinationIsNull() {
            addCriterion("destination is null");
            return (Criteria) this;
        }

        public Criteria andDestinationIsNotNull() {
            addCriterion("destination is not null");
            return (Criteria) this;
        }

        public Criteria andDestinationEqualTo(String value) {
            addCriterion("destination =", value, "destination");
            return (Criteria) this;
        }

        public Criteria andDestinationNotEqualTo(String value) {
            addCriterion("destination <>", value, "destination");
            return (Criteria) this;
        }

        public Criteria andDestinationGreaterThan(String value) {
            addCriterion("destination >", value, "destination");
            return (Criteria) this;
        }

        public Criteria andDestinationGreaterThanOrEqualTo(String value) {
            addCriterion("destination >=", value, "destination");
            return (Criteria) this;
        }

        public Criteria andDestinationLessThan(String value) {
            addCriterion("destination <", value, "destination");
            return (Criteria) this;
        }

        public Criteria andDestinationLessThanOrEqualTo(String value) {
            addCriterion("destination <=", value, "destination");
            return (Criteria) this;
        }

        public Criteria andDestinationLike(String value) {
            addCriterion("destination like", value, "destination");
            return (Criteria) this;
        }

        public Criteria andDestinationNotLike(String value) {
            addCriterion("destination not like", value, "destination");
            return (Criteria) this;
        }

        public Criteria andDestinationIn(List<String> values) {
            addCriterion("destination in", values, "destination");
            return (Criteria) this;
        }

        public Criteria andDestinationNotIn(List<String> values) {
            addCriterion("destination not in", values, "destination");
            return (Criteria) this;
        }

        public Criteria andDestinationBetween(String value1, String value2) {
            addCriterion("destination between", value1, value2, "destination");
            return (Criteria) this;
        }

        public Criteria andDestinationNotBetween(String value1, String value2) {
            addCriterion("destination not between", value1, value2, "destination");
            return (Criteria) this;
        }

        public Criteria andTypeIsNull() {
            addCriterion("type is null");
            return (Criteria) this;
        }

        public Criteria andTypeIsNotNull() {
            addCriterion("type is not null");
            return (Criteria) this;
        }

        public Criteria andTypeEqualTo(String value) {
            addCriterion("type =", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotEqualTo(String value) {
            addCriterion("type <>", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeGreaterThan(String value) {
            addCriterion("type >", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeGreaterThanOrEqualTo(String value) {
            addCriterion("type >=", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLessThan(String value) {
            addCriterion("type <", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLessThanOrEqualTo(String value) {
            addCriterion("type <=", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLike(String value) {
            addCriterion("type like", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotLike(String value) {
            addCriterion("type not like", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeIn(List<String> values) {
            addCriterion("type in", values, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotIn(List<String> values) {
            addCriterion("type not in", values, "type");
            return (Criteria) this;
        }

        public Criteria andTypeBetween(String value1, String value2) {
            addCriterion("type between", value1, value2, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotBetween(String value1, String value2) {
            addCriterion("type not between", value1, value2, "type");
            return (Criteria) this;
        }

        public Criteria andEsttimeIsNull() {
            addCriterion("esttime is null");
            return (Criteria) this;
        }

        public Criteria andEsttimeIsNotNull() {
            addCriterion("esttime is not null");
            return (Criteria) this;
        }

        public Criteria andEsttimeEqualTo(Date value) {
            addCriterion("esttime =", value, "esttime");
            return (Criteria) this;
        }

        public Criteria andEsttimeNotEqualTo(Date value) {
            addCriterion("esttime <>", value, "esttime");
            return (Criteria) this;
        }

        public Criteria andEsttimeGreaterThan(Date value) {
            addCriterion("esttime >", value, "esttime");
            return (Criteria) this;
        }

        public Criteria andEsttimeGreaterThanOrEqualTo(Date value) {
            addCriterion("esttime >=", value, "esttime");
            return (Criteria) this;
        }

        public Criteria andEsttimeLessThan(Date value) {
            addCriterion("esttime <", value, "esttime");
            return (Criteria) this;
        }

        public Criteria andEsttimeLessThanOrEqualTo(Date value) {
            addCriterion("esttime <=", value, "esttime");
            return (Criteria) this;
        }

        public Criteria andEsttimeIn(List<Date> values) {
            addCriterion("esttime in", values, "esttime");
            return (Criteria) this;
        }

        public Criteria andEsttimeNotIn(List<Date> values) {
            addCriterion("esttime not in", values, "esttime");
            return (Criteria) this;
        }

        public Criteria andEsttimeBetween(Date value1, Date value2) {
            addCriterion("esttime between", value1, value2, "esttime");
            return (Criteria) this;
        }

        public Criteria andEsttimeNotBetween(Date value1, Date value2) {
            addCriterion("esttime not between", value1, value2, "esttime");
            return (Criteria) this;
        }

        public Criteria andStateIsNull() {
            addCriterion("state is null");
            return (Criteria) this;
        }

        public Criteria andStateIsNotNull() {
            addCriterion("state is not null");
            return (Criteria) this;
        }

        public Criteria andStateEqualTo(String value) {
            addCriterion("state =", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotEqualTo(String value) {
            addCriterion("state <>", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateGreaterThan(String value) {
            addCriterion("state >", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateGreaterThanOrEqualTo(String value) {
            addCriterion("state >=", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateLessThan(String value) {
            addCriterion("state <", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateLessThanOrEqualTo(String value) {
            addCriterion("state <=", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateLike(String value) {
            addCriterion("state like", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotLike(String value) {
            addCriterion("state not like", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateIn(List<String> values) {
            addCriterion("state in", values, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotIn(List<String> values) {
            addCriterion("state not in", values, "state");
            return (Criteria) this;
        }

        public Criteria andStateBetween(String value1, String value2) {
            addCriterion("state between", value1, value2, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotBetween(String value1, String value2) {
            addCriterion("state not between", value1, value2, "state");
            return (Criteria) this;
        }

        public Criteria andWeightIsNull() {
            addCriterion("weight is null");
            return (Criteria) this;
        }

        public Criteria andWeightIsNotNull() {
            addCriterion("weight is not null");
            return (Criteria) this;
        }

        public Criteria andWeightEqualTo(Double value) {
            addCriterion("weight =", value, "weight");
            return (Criteria) this;
        }

        public Criteria andWeightNotEqualTo(Double value) {
            addCriterion("weight <>", value, "weight");
            return (Criteria) this;
        }

        public Criteria andWeightGreaterThan(Double value) {
            addCriterion("weight >", value, "weight");
            return (Criteria) this;
        }

        public Criteria andWeightGreaterThanOrEqualTo(Double value) {
            addCriterion("weight >=", value, "weight");
            return (Criteria) this;
        }

        public Criteria andWeightLessThan(Double value) {
            addCriterion("weight <", value, "weight");
            return (Criteria) this;
        }

        public Criteria andWeightLessThanOrEqualTo(Double value) {
            addCriterion("weight <=", value, "weight");
            return (Criteria) this;
        }

        public Criteria andWeightIn(List<Double> values) {
            addCriterion("weight in", values, "weight");
            return (Criteria) this;
        }

        public Criteria andWeightNotIn(List<Double> values) {
            addCriterion("weight not in", values, "weight");
            return (Criteria) this;
        }

        public Criteria andWeightBetween(Double value1, Double value2) {
            addCriterion("weight between", value1, value2, "weight");
            return (Criteria) this;
        }

        public Criteria andWeightNotBetween(Double value1, Double value2) {
            addCriterion("weight not between", value1, value2, "weight");
            return (Criteria) this;
        }

        public Criteria andSendphoneIsNull() {
            addCriterion("sendphone is null");
            return (Criteria) this;
        }

        public Criteria andSendphoneIsNotNull() {
            addCriterion("sendphone is not null");
            return (Criteria) this;
        }

        public Criteria andSendphoneEqualTo(String value) {
            addCriterion("sendphone =", value, "sendphone");
            return (Criteria) this;
        }

        public Criteria andSendphoneNotEqualTo(String value) {
            addCriterion("sendphone <>", value, "sendphone");
            return (Criteria) this;
        }

        public Criteria andSendphoneGreaterThan(String value) {
            addCriterion("sendphone >", value, "sendphone");
            return (Criteria) this;
        }

        public Criteria andSendphoneGreaterThanOrEqualTo(String value) {
            addCriterion("sendphone >=", value, "sendphone");
            return (Criteria) this;
        }

        public Criteria andSendphoneLessThan(String value) {
            addCriterion("sendphone <", value, "sendphone");
            return (Criteria) this;
        }

        public Criteria andSendphoneLessThanOrEqualTo(String value) {
            addCriterion("sendphone <=", value, "sendphone");
            return (Criteria) this;
        }

        public Criteria andSendphoneLike(String value) {
            addCriterion("sendphone like", value, "sendphone");
            return (Criteria) this;
        }

        public Criteria andSendphoneNotLike(String value) {
            addCriterion("sendphone not like", value, "sendphone");
            return (Criteria) this;
        }

        public Criteria andSendphoneIn(List<String> values) {
            addCriterion("sendphone in", values, "sendphone");
            return (Criteria) this;
        }

        public Criteria andSendphoneNotIn(List<String> values) {
            addCriterion("sendphone not in", values, "sendphone");
            return (Criteria) this;
        }

        public Criteria andSendphoneBetween(String value1, String value2) {
            addCriterion("sendphone between", value1, value2, "sendphone");
            return (Criteria) this;
        }

        public Criteria andSendphoneNotBetween(String value1, String value2) {
            addCriterion("sendphone not between", value1, value2, "sendphone");
            return (Criteria) this;
        }

        public Criteria andRecphoneIsNull() {
            addCriterion("recphone is null");
            return (Criteria) this;
        }

        public Criteria andRecphoneIsNotNull() {
            addCriterion("recphone is not null");
            return (Criteria) this;
        }

        public Criteria andRecphoneEqualTo(String value) {
            addCriterion("recphone =", value, "recphone");
            return (Criteria) this;
        }

        public Criteria andRecphoneNotEqualTo(String value) {
            addCriterion("recphone <>", value, "recphone");
            return (Criteria) this;
        }

        public Criteria andRecphoneGreaterThan(String value) {
            addCriterion("recphone >", value, "recphone");
            return (Criteria) this;
        }

        public Criteria andRecphoneGreaterThanOrEqualTo(String value) {
            addCriterion("recphone >=", value, "recphone");
            return (Criteria) this;
        }

        public Criteria andRecphoneLessThan(String value) {
            addCriterion("recphone <", value, "recphone");
            return (Criteria) this;
        }

        public Criteria andRecphoneLessThanOrEqualTo(String value) {
            addCriterion("recphone <=", value, "recphone");
            return (Criteria) this;
        }

        public Criteria andRecphoneLike(String value) {
            addCriterion("recphone like", value, "recphone");
            return (Criteria) this;
        }

        public Criteria andRecphoneNotLike(String value) {
            addCriterion("recphone not like", value, "recphone");
            return (Criteria) this;
        }

        public Criteria andRecphoneIn(List<String> values) {
            addCriterion("recphone in", values, "recphone");
            return (Criteria) this;
        }

        public Criteria andRecphoneNotIn(List<String> values) {
            addCriterion("recphone not in", values, "recphone");
            return (Criteria) this;
        }

        public Criteria andRecphoneBetween(String value1, String value2) {
            addCriterion("recphone between", value1, value2, "recphone");
            return (Criteria) this;
        }

        public Criteria andRecphoneNotBetween(String value1, String value2) {
            addCriterion("recphone not between", value1, value2, "recphone");
            return (Criteria) this;
        }

        public Criteria andSendnameIsNull() {
            addCriterion("sendname is null");
            return (Criteria) this;
        }

        public Criteria andSendnameIsNotNull() {
            addCriterion("sendname is not null");
            return (Criteria) this;
        }

        public Criteria andSendnameEqualTo(String value) {
            addCriterion("sendname =", value, "sendname");
            return (Criteria) this;
        }

        public Criteria andSendnameNotEqualTo(String value) {
            addCriterion("sendname <>", value, "sendname");
            return (Criteria) this;
        }

        public Criteria andSendnameGreaterThan(String value) {
            addCriterion("sendname >", value, "sendname");
            return (Criteria) this;
        }

        public Criteria andSendnameGreaterThanOrEqualTo(String value) {
            addCriterion("sendname >=", value, "sendname");
            return (Criteria) this;
        }

        public Criteria andSendnameLessThan(String value) {
            addCriterion("sendname <", value, "sendname");
            return (Criteria) this;
        }

        public Criteria andSendnameLessThanOrEqualTo(String value) {
            addCriterion("sendname <=", value, "sendname");
            return (Criteria) this;
        }

        public Criteria andSendnameLike(String value) {
            addCriterion("sendname like", value, "sendname");
            return (Criteria) this;
        }

        public Criteria andSendnameNotLike(String value) {
            addCriterion("sendname not like", value, "sendname");
            return (Criteria) this;
        }

        public Criteria andSendnameIn(List<String> values) {
            addCriterion("sendname in", values, "sendname");
            return (Criteria) this;
        }

        public Criteria andSendnameNotIn(List<String> values) {
            addCriterion("sendname not in", values, "sendname");
            return (Criteria) this;
        }

        public Criteria andSendnameBetween(String value1, String value2) {
            addCriterion("sendname between", value1, value2, "sendname");
            return (Criteria) this;
        }

        public Criteria andSendnameNotBetween(String value1, String value2) {
            addCriterion("sendname not between", value1, value2, "sendname");
            return (Criteria) this;
        }

        public Criteria andRecnameIsNull() {
            addCriterion("recname is null");
            return (Criteria) this;
        }

        public Criteria andRecnameIsNotNull() {
            addCriterion("recname is not null");
            return (Criteria) this;
        }

        public Criteria andRecnameEqualTo(String value) {
            addCriterion("recname =", value, "recname");
            return (Criteria) this;
        }

        public Criteria andRecnameNotEqualTo(String value) {
            addCriterion("recname <>", value, "recname");
            return (Criteria) this;
        }

        public Criteria andRecnameGreaterThan(String value) {
            addCriterion("recname >", value, "recname");
            return (Criteria) this;
        }

        public Criteria andRecnameGreaterThanOrEqualTo(String value) {
            addCriterion("recname >=", value, "recname");
            return (Criteria) this;
        }

        public Criteria andRecnameLessThan(String value) {
            addCriterion("recname <", value, "recname");
            return (Criteria) this;
        }

        public Criteria andRecnameLessThanOrEqualTo(String value) {
            addCriterion("recname <=", value, "recname");
            return (Criteria) this;
        }

        public Criteria andRecnameLike(String value) {
            addCriterion("recname like", value, "recname");
            return (Criteria) this;
        }

        public Criteria andRecnameNotLike(String value) {
            addCriterion("recname not like", value, "recname");
            return (Criteria) this;
        }

        public Criteria andRecnameIn(List<String> values) {
            addCriterion("recname in", values, "recname");
            return (Criteria) this;
        }

        public Criteria andRecnameNotIn(List<String> values) {
            addCriterion("recname not in", values, "recname");
            return (Criteria) this;
        }

        public Criteria andRecnameBetween(String value1, String value2) {
            addCriterion("recname between", value1, value2, "recname");
            return (Criteria) this;
        }

        public Criteria andRecnameNotBetween(String value1, String value2) {
            addCriterion("recname not between", value1, value2, "recname");
            return (Criteria) this;
        }

        public Criteria andContentIsNull() {
            addCriterion("content is null");
            return (Criteria) this;
        }

        public Criteria andContentIsNotNull() {
            addCriterion("content is not null");
            return (Criteria) this;
        }

        public Criteria andContentEqualTo(String value) {
            addCriterion("content =", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentNotEqualTo(String value) {
            addCriterion("content <>", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentGreaterThan(String value) {
            addCriterion("content >", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentGreaterThanOrEqualTo(String value) {
            addCriterion("content >=", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentLessThan(String value) {
            addCriterion("content <", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentLessThanOrEqualTo(String value) {
            addCriterion("content <=", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentLike(String value) {
            addCriterion("content like", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentNotLike(String value) {
            addCriterion("content not like", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentIn(List<String> values) {
            addCriterion("content in", values, "content");
            return (Criteria) this;
        }

        public Criteria andContentNotIn(List<String> values) {
            addCriterion("content not in", values, "content");
            return (Criteria) this;
        }

        public Criteria andContentBetween(String value1, String value2) {
            addCriterion("content between", value1, value2, "content");
            return (Criteria) this;
        }

        public Criteria andContentNotBetween(String value1, String value2) {
            addCriterion("content not between", value1, value2, "content");
            return (Criteria) this;
        }

        public Criteria andSendaddressIsNull() {
            addCriterion("sendaddress is null");
            return (Criteria) this;
        }

        public Criteria andSendaddressIsNotNull() {
            addCriterion("sendaddress is not null");
            return (Criteria) this;
        }

        public Criteria andSendaddressEqualTo(String value) {
            addCriterion("sendaddress =", value, "sendaddress");
            return (Criteria) this;
        }

        public Criteria andSendaddressNotEqualTo(String value) {
            addCriterion("sendaddress <>", value, "sendaddress");
            return (Criteria) this;
        }

        public Criteria andSendaddressGreaterThan(String value) {
            addCriterion("sendaddress >", value, "sendaddress");
            return (Criteria) this;
        }

        public Criteria andSendaddressGreaterThanOrEqualTo(String value) {
            addCriterion("sendaddress >=", value, "sendaddress");
            return (Criteria) this;
        }

        public Criteria andSendaddressLessThan(String value) {
            addCriterion("sendaddress <", value, "sendaddress");
            return (Criteria) this;
        }

        public Criteria andSendaddressLessThanOrEqualTo(String value) {
            addCriterion("sendaddress <=", value, "sendaddress");
            return (Criteria) this;
        }

        public Criteria andSendaddressLike(String value) {
            addCriterion("sendaddress like", value, "sendaddress");
            return (Criteria) this;
        }

        public Criteria andSendaddressNotLike(String value) {
            addCriterion("sendaddress not like", value, "sendaddress");
            return (Criteria) this;
        }

        public Criteria andSendaddressIn(List<String> values) {
            addCriterion("sendaddress in", values, "sendaddress");
            return (Criteria) this;
        }

        public Criteria andSendaddressNotIn(List<String> values) {
            addCriterion("sendaddress not in", values, "sendaddress");
            return (Criteria) this;
        }

        public Criteria andSendaddressBetween(String value1, String value2) {
            addCriterion("sendaddress between", value1, value2, "sendaddress");
            return (Criteria) this;
        }

        public Criteria andSendaddressNotBetween(String value1, String value2) {
            addCriterion("sendaddress not between", value1, value2, "sendaddress");
            return (Criteria) this;
        }

        public Criteria andRecaddressIsNull() {
            addCriterion("recaddress is null");
            return (Criteria) this;
        }

        public Criteria andRecaddressIsNotNull() {
            addCriterion("recaddress is not null");
            return (Criteria) this;
        }

        public Criteria andRecaddressEqualTo(String value) {
            addCriterion("recaddress =", value, "recaddress");
            return (Criteria) this;
        }

        public Criteria andRecaddressNotEqualTo(String value) {
            addCriterion("recaddress <>", value, "recaddress");
            return (Criteria) this;
        }

        public Criteria andRecaddressGreaterThan(String value) {
            addCriterion("recaddress >", value, "recaddress");
            return (Criteria) this;
        }

        public Criteria andRecaddressGreaterThanOrEqualTo(String value) {
            addCriterion("recaddress >=", value, "recaddress");
            return (Criteria) this;
        }

        public Criteria andRecaddressLessThan(String value) {
            addCriterion("recaddress <", value, "recaddress");
            return (Criteria) this;
        }

        public Criteria andRecaddressLessThanOrEqualTo(String value) {
            addCriterion("recaddress <=", value, "recaddress");
            return (Criteria) this;
        }

        public Criteria andRecaddressLike(String value) {
            addCriterion("recaddress like", value, "recaddress");
            return (Criteria) this;
        }

        public Criteria andRecaddressNotLike(String value) {
            addCriterion("recaddress not like", value, "recaddress");
            return (Criteria) this;
        }

        public Criteria andRecaddressIn(List<String> values) {
            addCriterion("recaddress in", values, "recaddress");
            return (Criteria) this;
        }

        public Criteria andRecaddressNotIn(List<String> values) {
            addCriterion("recaddress not in", values, "recaddress");
            return (Criteria) this;
        }

        public Criteria andRecaddressBetween(String value1, String value2) {
            addCriterion("recaddress between", value1, value2, "recaddress");
            return (Criteria) this;
        }

        public Criteria andRecaddressNotBetween(String value1, String value2) {
            addCriterion("recaddress not between", value1, value2, "recaddress");
            return (Criteria) this;
        }

        public Criteria andGoodnameIsNull() {
            addCriterion("goodname is null");
            return (Criteria) this;
        }

        public Criteria andGoodnameIsNotNull() {
            addCriterion("goodname is not null");
            return (Criteria) this;
        }

        public Criteria andGoodnameEqualTo(String value) {
            addCriterion("goodname =", value, "goodname");
            return (Criteria) this;
        }

        public Criteria andGoodnameNotEqualTo(String value) {
            addCriterion("goodname <>", value, "goodname");
            return (Criteria) this;
        }

        public Criteria andGoodnameGreaterThan(String value) {
            addCriterion("goodname >", value, "goodname");
            return (Criteria) this;
        }

        public Criteria andGoodnameGreaterThanOrEqualTo(String value) {
            addCriterion("goodname >=", value, "goodname");
            return (Criteria) this;
        }

        public Criteria andGoodnameLessThan(String value) {
            addCriterion("goodname <", value, "goodname");
            return (Criteria) this;
        }

        public Criteria andGoodnameLessThanOrEqualTo(String value) {
            addCriterion("goodname <=", value, "goodname");
            return (Criteria) this;
        }

        public Criteria andGoodnameLike(String value) {
            addCriterion("goodname like", value, "goodname");
            return (Criteria) this;
        }

        public Criteria andGoodnameNotLike(String value) {
            addCriterion("goodname not like", value, "goodname");
            return (Criteria) this;
        }

        public Criteria andGoodnameIn(List<String> values) {
            addCriterion("goodname in", values, "goodname");
            return (Criteria) this;
        }

        public Criteria andGoodnameNotIn(List<String> values) {
            addCriterion("goodname not in", values, "goodname");
            return (Criteria) this;
        }

        public Criteria andGoodnameBetween(String value1, String value2) {
            addCriterion("goodname between", value1, value2, "goodname");
            return (Criteria) this;
        }

        public Criteria andGoodnameNotBetween(String value1, String value2) {
            addCriterion("goodname not between", value1, value2, "goodname");
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