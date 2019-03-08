package com.slionh.community.entity;

import java.util.ArrayList;
import java.util.List;

public class MemberExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public MemberExample() {
        oredCriteria = new ArrayList<Criteria>();
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

        public Criteria andIdmemberIsNull() {
            addCriterion("idMember is null");
            return (Criteria) this;
        }

        public Criteria andIdmemberIsNotNull() {
            addCriterion("idMember is not null");
            return (Criteria) this;
        }

        public Criteria andIdmemberEqualTo(Integer value) {
            addCriterion("idMember =", value, "idmember");
            return (Criteria) this;
        }

        public Criteria andIdmemberNotEqualTo(Integer value) {
            addCriterion("idMember <>", value, "idmember");
            return (Criteria) this;
        }

        public Criteria andIdmemberGreaterThan(Integer value) {
            addCriterion("idMember >", value, "idmember");
            return (Criteria) this;
        }

        public Criteria andIdmemberGreaterThanOrEqualTo(Integer value) {
            addCriterion("idMember >=", value, "idmember");
            return (Criteria) this;
        }

        public Criteria andIdmemberLessThan(Integer value) {
            addCriterion("idMember <", value, "idmember");
            return (Criteria) this;
        }

        public Criteria andIdmemberLessThanOrEqualTo(Integer value) {
            addCriterion("idMember <=", value, "idmember");
            return (Criteria) this;
        }

        public Criteria andIdmemberIn(List<Integer> values) {
            addCriterion("idMember in", values, "idmember");
            return (Criteria) this;
        }

        public Criteria andIdmemberNotIn(List<Integer> values) {
            addCriterion("idMember not in", values, "idmember");
            return (Criteria) this;
        }

        public Criteria andIdmemberBetween(Integer value1, Integer value2) {
            addCriterion("idMember between", value1, value2, "idmember");
            return (Criteria) this;
        }

        public Criteria andIdmemberNotBetween(Integer value1, Integer value2) {
            addCriterion("idMember not between", value1, value2, "idmember");
            return (Criteria) this;
        }

        public Criteria andUseridIsNull() {
            addCriterion("userId is null");
            return (Criteria) this;
        }

        public Criteria andUseridIsNotNull() {
            addCriterion("userId is not null");
            return (Criteria) this;
        }

        public Criteria andUseridEqualTo(Integer value) {
            addCriterion("userId =", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridNotEqualTo(Integer value) {
            addCriterion("userId <>", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridGreaterThan(Integer value) {
            addCriterion("userId >", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridGreaterThanOrEqualTo(Integer value) {
            addCriterion("userId >=", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridLessThan(Integer value) {
            addCriterion("userId <", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridLessThanOrEqualTo(Integer value) {
            addCriterion("userId <=", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridIn(List<Integer> values) {
            addCriterion("userId in", values, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridNotIn(List<Integer> values) {
            addCriterion("userId not in", values, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridBetween(Integer value1, Integer value2) {
            addCriterion("userId between", value1, value2, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridNotBetween(Integer value1, Integer value2) {
            addCriterion("userId not between", value1, value2, "userid");
            return (Criteria) this;
        }

        public Criteria andCommunityidIsNull() {
            addCriterion("communityId is null");
            return (Criteria) this;
        }

        public Criteria andCommunityidIsNotNull() {
            addCriterion("communityId is not null");
            return (Criteria) this;
        }

        public Criteria andCommunityidEqualTo(Integer value) {
            addCriterion("communityId =", value, "communityid");
            return (Criteria) this;
        }

        public Criteria andCommunityidNotEqualTo(Integer value) {
            addCriterion("communityId <>", value, "communityid");
            return (Criteria) this;
        }

        public Criteria andCommunityidGreaterThan(Integer value) {
            addCriterion("communityId >", value, "communityid");
            return (Criteria) this;
        }

        public Criteria andCommunityidGreaterThanOrEqualTo(Integer value) {
            addCriterion("communityId >=", value, "communityid");
            return (Criteria) this;
        }

        public Criteria andCommunityidLessThan(Integer value) {
            addCriterion("communityId <", value, "communityid");
            return (Criteria) this;
        }

        public Criteria andCommunityidLessThanOrEqualTo(Integer value) {
            addCriterion("communityId <=", value, "communityid");
            return (Criteria) this;
        }

        public Criteria andCommunityidIn(List<Integer> values) {
            addCriterion("communityId in", values, "communityid");
            return (Criteria) this;
        }

        public Criteria andCommunityidNotIn(List<Integer> values) {
            addCriterion("communityId not in", values, "communityid");
            return (Criteria) this;
        }

        public Criteria andCommunityidBetween(Integer value1, Integer value2) {
            addCriterion("communityId between", value1, value2, "communityid");
            return (Criteria) this;
        }

        public Criteria andCommunityidNotBetween(Integer value1, Integer value2) {
            addCriterion("communityId not between", value1, value2, "communityid");
            return (Criteria) this;
        }

        public Criteria andStatusIsNull() {
            addCriterion("status is null");
            return (Criteria) this;
        }

        public Criteria andStatusIsNotNull() {
            addCriterion("status is not null");
            return (Criteria) this;
        }

        public Criteria andStatusEqualTo(Integer value) {
            addCriterion("status =", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotEqualTo(Integer value) {
            addCriterion("status <>", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThan(Integer value) {
            addCriterion("status >", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("status >=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThan(Integer value) {
            addCriterion("status <", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThanOrEqualTo(Integer value) {
            addCriterion("status <=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusIn(List<Integer> values) {
            addCriterion("status in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotIn(List<Integer> values) {
            addCriterion("status not in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusBetween(Integer value1, Integer value2) {
            addCriterion("status between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("status not between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andMemberlevelIsNull() {
            addCriterion("memberLevel is null");
            return (Criteria) this;
        }

        public Criteria andMemberlevelIsNotNull() {
            addCriterion("memberLevel is not null");
            return (Criteria) this;
        }

        public Criteria andMemberlevelEqualTo(Integer value) {
            addCriterion("memberLevel =", value, "memberlevel");
            return (Criteria) this;
        }

        public Criteria andMemberlevelNotEqualTo(Integer value) {
            addCriterion("memberLevel <>", value, "memberlevel");
            return (Criteria) this;
        }

        public Criteria andMemberlevelGreaterThan(Integer value) {
            addCriterion("memberLevel >", value, "memberlevel");
            return (Criteria) this;
        }

        public Criteria andMemberlevelGreaterThanOrEqualTo(Integer value) {
            addCriterion("memberLevel >=", value, "memberlevel");
            return (Criteria) this;
        }

        public Criteria andMemberlevelLessThan(Integer value) {
            addCriterion("memberLevel <", value, "memberlevel");
            return (Criteria) this;
        }

        public Criteria andMemberlevelLessThanOrEqualTo(Integer value) {
            addCriterion("memberLevel <=", value, "memberlevel");
            return (Criteria) this;
        }

        public Criteria andMemberlevelIn(List<Integer> values) {
            addCriterion("memberLevel in", values, "memberlevel");
            return (Criteria) this;
        }

        public Criteria andMemberlevelNotIn(List<Integer> values) {
            addCriterion("memberLevel not in", values, "memberlevel");
            return (Criteria) this;
        }

        public Criteria andMemberlevelBetween(Integer value1, Integer value2) {
            addCriterion("memberLevel between", value1, value2, "memberlevel");
            return (Criteria) this;
        }

        public Criteria andMemberlevelNotBetween(Integer value1, Integer value2) {
            addCriterion("memberLevel not between", value1, value2, "memberlevel");
            return (Criteria) this;
        }

        public Criteria andDescriptionIsNull() {
            addCriterion("description is null");
            return (Criteria) this;
        }

        public Criteria andDescriptionIsNotNull() {
            addCriterion("description is not null");
            return (Criteria) this;
        }

        public Criteria andDescriptionEqualTo(String value) {
            addCriterion("description =", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionNotEqualTo(String value) {
            addCriterion("description <>", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionGreaterThan(String value) {
            addCriterion("description >", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionGreaterThanOrEqualTo(String value) {
            addCriterion("description >=", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionLessThan(String value) {
            addCriterion("description <", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionLessThanOrEqualTo(String value) {
            addCriterion("description <=", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionLike(String value) {
            addCriterion("description like", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionNotLike(String value) {
            addCriterion("description not like", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionIn(List<String> values) {
            addCriterion("description in", values, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionNotIn(List<String> values) {
            addCriterion("description not in", values, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionBetween(String value1, String value2) {
            addCriterion("description between", value1, value2, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionNotBetween(String value1, String value2) {
            addCriterion("description not between", value1, value2, "description");
            return (Criteria) this;
        }

        public Criteria andOtherIsNull() {
            addCriterion("other is null");
            return (Criteria) this;
        }

        public Criteria andOtherIsNotNull() {
            addCriterion("other is not null");
            return (Criteria) this;
        }

        public Criteria andOtherEqualTo(String value) {
            addCriterion("other =", value, "other");
            return (Criteria) this;
        }

        public Criteria andOtherNotEqualTo(String value) {
            addCriterion("other <>", value, "other");
            return (Criteria) this;
        }

        public Criteria andOtherGreaterThan(String value) {
            addCriterion("other >", value, "other");
            return (Criteria) this;
        }

        public Criteria andOtherGreaterThanOrEqualTo(String value) {
            addCriterion("other >=", value, "other");
            return (Criteria) this;
        }

        public Criteria andOtherLessThan(String value) {
            addCriterion("other <", value, "other");
            return (Criteria) this;
        }

        public Criteria andOtherLessThanOrEqualTo(String value) {
            addCriterion("other <=", value, "other");
            return (Criteria) this;
        }

        public Criteria andOtherLike(String value) {
            addCriterion("other like", value, "other");
            return (Criteria) this;
        }

        public Criteria andOtherNotLike(String value) {
            addCriterion("other not like", value, "other");
            return (Criteria) this;
        }

        public Criteria andOtherIn(List<String> values) {
            addCriterion("other in", values, "other");
            return (Criteria) this;
        }

        public Criteria andOtherNotIn(List<String> values) {
            addCriterion("other not in", values, "other");
            return (Criteria) this;
        }

        public Criteria andOtherBetween(String value1, String value2) {
            addCriterion("other between", value1, value2, "other");
            return (Criteria) this;
        }

        public Criteria andOtherNotBetween(String value1, String value2) {
            addCriterion("other not between", value1, value2, "other");
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