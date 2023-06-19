package com.example.pojo;

import java.util.Date;

public class Order {
    private Integer id;

    private Integer transunitid;

    private Integer userid;

    private Date createtime;

    private String setout;

    private String destination;

    private String type;

    private Date esttime;

    private String state;

    private Double weight;

    private String sendphone;

    private String recphone;

    private String sendname;

    private String recname;

    private String content;

    private String sendaddress;

    private String recaddress;

    private String goodname;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getTransunitid() {
        return transunitid;
    }

    public void setTransunitid(Integer transunitid) {
        this.transunitid = transunitid;
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public String getSetout() {
        return setout;
    }

    public void setSetout(String setout) {
        this.setout = setout == null ? null : setout.trim();
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination == null ? null : destination.trim();
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }

    public Date getEsttime() {
        return esttime;
    }

    public void setEsttime(Date esttime) {
        this.esttime = esttime;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state == null ? null : state.trim();
    }

    public Double getWeight() {
        return weight;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }

    public String getSendphone() {
        return sendphone;
    }

    public void setSendphone(String sendphone) {
        this.sendphone = sendphone == null ? null : sendphone.trim();
    }

    public String getRecphone() {
        return recphone;
    }

    public void setRecphone(String recphone) {
        this.recphone = recphone == null ? null : recphone.trim();
    }

    public String getSendname() {
        return sendname;
    }

    public void setSendname(String sendname) {
        this.sendname = sendname == null ? null : sendname.trim();
    }

    public String getRecname() {
        return recname;
    }

    public void setRecname(String recname) {
        this.recname = recname == null ? null : recname.trim();
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    public String getSendaddress() {
        return sendaddress;
    }

    public void setSendaddress(String sendaddress) {
        this.sendaddress = sendaddress == null ? null : sendaddress.trim();
    }

    public String getRecaddress() {
        return recaddress;
    }

    public void setRecaddress(String recaddress) {
        this.recaddress = recaddress == null ? null : recaddress.trim();
    }

    public String getGoodname() {
        return goodname;
    }

    public void setGoodname(String goodname) {
        this.goodname = goodname == null ? null : goodname.trim();
    }
}