package com.slionh.community.entity;

import java.util.ArrayList;
import java.util.List;

public class BordertopExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public BordertopExample() {
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

        public Criteria andIdbordertopIsNull() {
            addCriterion("idborderTop is null");
            return (Criteria) this;
        }

        public Criteria andIdbordertopIsNotNull() {
            addCriterion("idborderTop is not null");
            return (Criteria) this;
        }

        public Criteria andIdbordertopEqualTo(Integer value) {
            addCriterion("idborderTop =", value, "idbordertop");
            return (Criteria) this;
        }

        public Criteria andIdbordertopNotEqualTo(Integer value) {
            addCriterion("idborderTop <>", value, "idbordertop");
            return (Criteria) this;
        }

        public Criteria andIdbordertopGreaterThan(Integer value) {
            addCriterion("idborderTop >", value, "idbordertop");
            return (Criteria) this;
        }

        public Criteria andIdbordertopGreaterThanOrEqualTo(Integer value) {
            addCriterion("idborderTop >=", value, "idbordertop");
            return (Criteria) this;
        }

        public Criteria andIdbordertopLessThan(Integer value) {
            addCriterion("idborderTop <", value, "idbordertop");
            return (Criteria) this;
        }

        public Criteria andIdbordertopLessThanOrEqualTo(Integer value) {
            addCriterion("idborderTop <=", value, "idbordertop");
            return (Criteria) this;
        }

        public Criteria andIdbordertopIn(List<Integer> values) {
            addCriterion("idborderTop in", values, "idbordertop");
            return (Criteria) this;
        }

        public Criteria andIdbordertopNotIn(List<Integer> values) {
            addCriterion("idborderTop not in", values, "idbordertop");
            return (Criteria) this;
        }

        public Criteria andIdbordertopBetween(Integer value1, Integer value2) {
            addCriterion("idborderTop between", value1, value2, "idbordertop");
            return (Criteria) this;
        }

        public Criteria andIdbordertopNotBetween(Integer value1, Integer value2) {
            addCriterion("idborderTop not between", value1, value2, "idbordertop");
            return (Criteria) this;
        }

        public Criteria andBorderidIsNull() {
            addCriterion("borderId is null");
            return (Criteria) this;
        }

        public Criteria andBorderidIsNotNull() {
            addCriterion("borderId is not null");
            return (Criteria) this;
        }

        public Criteria andBorderidEqualTo(Integer value) {
            addCriterion("borderId =", value, "borderid");
            return (Criteria) this;
        }

        public Criteria andBorderidNotEqualTo(Integer value) {
            addCriterion("borderId <>", value, "borderid");
            return (Criteria) this;
        }

        public Criteria andBorderidGreaterThan(Integer value) {
            addCriterion("borderId >", value, "borderid");
            return (Criteria) this;
        }

        public Criteria andBorderidGreaterThanOrEqualTo(Integer value) {
            addCriterion("borderId >=", value, "borderid");
            return (Criteria) this;
        }

        public Criteria andBorderidLessThan(Integer value) {
            addCriterion("borderId <", value, "borderid");
            return (Criteria) this;
        }

        public Criteria andBorderidLessThanOrEqualTo(Integer value) {
            addCriterion("borderId <=", value, "borderid");
            return (Criteria) this;
        }

        public Criteria andBorderidIn(List<Integer> values) {
            addCriterion("borderId in", values, "borderid");
            return (Criteria) this;
        }

        public Criteria andBorderidNotIn(List<Integer> values) {
            addCriterion("borderId not in", values, "borderid");
            return (Criteria) this;
        }

        public Criteria andBorderidBetween(Integer value1, Integer value2) {
            addCriterion("borderId between", value1, value2, "borderid");
            return (Criteria) this;
        }

        public Criteria andBorderidNotBetween(Integer value1, Integer value2) {
            addCriterion("borderId not between", value1, value2, "borderid");
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