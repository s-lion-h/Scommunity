package com.slionh.community.entity;

import java.util.Date;

public class Newscomment {
    private Integer idnewscomment;

    private Integer userid;

    private Integer newsid;

    private String content;

    private Date createtime;

    public Integer getIdnewscomment() {
        return idnewscomment;
    }

    public void setIdnewscomment(Integer idnewscomment) {
        this.idnewscomment = idnewscomment;
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public Integer getNewsid() {
        return newsid;
    }

    public void setNewsid(Integer newsid) {
        this.newsid = newsid;
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