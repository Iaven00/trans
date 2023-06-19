package com.example.pojo;

import java.util.Date;

public class Transunit {
    private Integer transunitid;

    private String name;

    private String contactemail;

    private Date registrationtime;

    private Integer companyid;

    private Integer total;

    private Integer rest;

    public Integer getTransunitid() {
        return transunitid;
    }

    public void setTransunitid(Integer transunitid) {
        this.transunitid = transunitid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getContactemail() {
        return contactemail;
    }

    public void setContactemail(String contactemail) {
        this.contactemail = contactemail == null ? null : contactemail.trim();
    }

    public Date getRegistrationtime() {
        return registrationtime;
    }

    public void setRegistrationtime(Date registrationtime) {
        this.registrationtime = registrationtime;
    }

    public Integer getCompanyid() {
        return companyid;
    }

    public void setCompanyid(Integer companyid) {
        this.companyid = companyid;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public Integer getRest() {
        return rest;
    }

    public void setRest(Integer rest) {
        this.rest = rest;
    }
}