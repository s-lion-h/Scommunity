package com.slionh.community.entity;

import java.util.Date;

public class Community {
    private Integer idcommunity;

    private String name;

    private String introduction;

    private String logo;

    private Integer president;

    private String teacher;

    private String teacherphone;

    private String other;

    private Date createtime;

    public Integer getIdcommunity() {
        return idcommunity;
    }

    public void setIdcommunity(Integer idcommunity) {
        this.idcommunity = idcommunity;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction == null ? null : introduction.trim();
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo == null ? null : logo.trim();
    }

    public Integer getPresident() {
        return president;
    }

    public void setPresident(Integer president) {
        this.president = president;
    }

    public String getTeacher() {
        return teacher;
    }

    public void setTeacher(String teacher) {
        this.teacher = teacher == null ? null : teacher.trim();
    }

    public String getTeacherphone() {
        return teacherphone;
    }

    public void setTeacherphone(String teacherphone) {
        this.teacherphone = teacherphone == null ? null : teacherphone.trim();
    }

    public String getOther() {
        return other;
    }

    public void setOther(String other) {
        this.other = other == null ? null : other.trim();
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    @Override
    public String toString() {
        return "Community{" +
                "idcommunity=" + idcommunity +
                ", name='" + name + '\'' +
                ", introduction='" + introduction + '\'' +
                ", logo='" + logo + '\'' +
                ", president=" + president +
                ", teacher='" + teacher + '\'' +
                ", teacherphone='" + teacherphone + '\'' +
                ", other='" + other + '\'' +
                ", createtime=" + createtime +
                '}';
    }
}