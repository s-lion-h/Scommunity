package com.slionh.community.entity;

public class Member {
    private Integer idmember;

    private Integer userid;

    private Integer communityid;

    private Integer status;

    private Integer memberlevel;

    private String description;

    private String other;

    public Integer getIdmember() {
        return idmember;
    }

    public void setIdmember(Integer idmember) {
        this.idmember = idmember;
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public Integer getCommunityid() {
        return communityid;
    }

    public void setCommunityid(Integer communityid) {
        this.communityid = communityid;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getMemberlevel() {
        return memberlevel;
    }

    public void setMemberlevel(Integer memberlevel) {
        this.memberlevel = memberlevel;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    public String getOther() {
        return other;
    }

    public void setOther(String other) {
        this.other = other == null ? null : other.trim();
    }
}