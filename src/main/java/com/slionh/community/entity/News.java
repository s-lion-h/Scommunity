package com.slionh.community.entity;

import java.util.Date;

public class News {
    private Integer idnews;

    private Integer userid;

    private String title;

    private String content;

    private Date createtime;

    private String image;

    public Integer getIdnews() {
        return idnews;
    }

    public void setIdnews(Integer idnews) {
        this.idnews = idnews;
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
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

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image == null ? null : image.trim();
    }
}