package com.slionh.community.entity;

import java.util.Date;

public class Activity {
    private Integer idactivity;

    private Integer communityid;

    private String title;

    private String description;

    private Date starttime;

    private Date endtime;

    private String position;

    private String location;

    private Date createtime;

    private Integer mandatory;

    public Integer getIdactivity() {
        return idactivity;
    }

    public void setIdactivity(Integer idactivity) {
        this.idactivity = idactivity;
    }

    public Integer getCommunityid() {
        return communityid;
    }

    public void setCommunityid(Integer communityid) {
        this.communityid = communityid;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    public Date getStarttime() {
        return starttime;
    }

    public void setStarttime(Date starttime) {
        this.starttime = starttime;
    }

    public Date getEndtime() {
        return endtime;
    }

    public void setEndtime(Date endtime) {
        this.endtime = endtime;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position == null ? null : position.trim();
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location == null ? null : location.trim();
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public Integer getMandatory() {
        return mandatory;
    }

    public void setMandatory(Integer mandatory) {
        this.mandatory = mandatory;
    }

    @Override
    public String toString() {
        return "Activity{" +
                "idactivity=" + idactivity +
                ", communityid=" + communityid +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", starttime=" + starttime +
                ", endtime=" + endtime +
                ", position='" + position + '\'' +
                ", location='" + location + '\'' +
                ", createtime=" + createtime +
                ", mandatory=" + mandatory +
                '}';
    }
}