package com.slionh.community.entity;

import java.util.Date;

public class Activitymember {
    private Integer idactivitymember;

    private Integer userid;

    private Integer activityid;

    private Integer score;

    private Date createtime;

    public Integer getIdactivitymember() {
        return idactivitymember;
    }

    public void setIdactivitymember(Integer idactivitymember) {
        this.idactivitymember = idactivitymember;
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public Integer getActivityid() {
        return activityid;
    }

    public void setActivityid(Integer activityid) {
        this.activityid = activityid;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }
}