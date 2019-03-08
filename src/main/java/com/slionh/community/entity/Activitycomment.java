package com.slionh.community.entity;

import java.util.Date;

public class Activitycomment {
    private Integer idactivitycomment;

    private Integer userid;

    private Integer activityid;

    private String content;

    private Date createtime;

    public Integer getIdactivitycomment() {
        return idactivitycomment;
    }

    public void setIdactivitycomment(Integer idactivitycomment) {
        this.idactivitycomment = idactivitycomment;
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

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }
}