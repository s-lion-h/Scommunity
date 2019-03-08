package com.slionh.community.entity;

public class Webdescription {
    private Integer idwebdescription;

    private String introduction;

    private String phone;

    private String address;

    public Integer getIdwebdescription() {
        return idwebdescription;
    }

    public void setIdwebdescription(Integer idwebdescription) {
        this.idwebdescription = idwebdescription;
    }

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction == null ? null : introduction.trim();
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }
}