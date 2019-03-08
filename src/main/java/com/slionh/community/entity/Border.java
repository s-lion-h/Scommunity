package com.slionh.community.entity;

import java.util.Date;

public class Border {
    private Integer idborder;

    private Integer userid;

    private String content;

    private Date createtime;

    private String other;

    public Integer getIdborder() {
        return idborder;
    }

    public void setIdborder(Integer idborder) {
        this.idborder = idborder;
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
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

    public String getOther() {
        return other;
    }

    public void setOther(String other) {
        this.other = other == null ? null : other.trim();
    }
}