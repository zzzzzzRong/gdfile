package com.insurance.demo.entity;

import java.io.Serializable;

/**
 * (Insurancepolicy)实体类
 *
 * @author makejava
 * @since 2020-02-22 12:33:09
 */
public class Insurancepolicy implements Serializable {
    private static final long serialVersionUID = 820664423359217552L;
    
    private Integer id;
    /**
    * 投保人编号
    */
    private Integer userId;
    /**
    * 投保日期
    */
    private String insuredTime;
    /**
    * 起保日期
    */
    private String beginTime;
    /**
    * 终止日期
    */
    private String endTime;
    /**
    * 销售渠道
    */
    private String channel;
    /**
    * 业务员编号
    */
    private String salesId;
    /**
    * 争议处理
    */
    private String dispute;
    /**
    * 保险种类
    */
    private String type;
    /**
    * 保费
    */
    private String premium;
    /**
    * 预留
    */
    private String reserve;

    public Insurancepolicy() {
    }

    public Insurancepolicy(Integer userId, String insuredTime, String beginTime, String endTime, String channel, String salesId, String dispute, String type, String premium) {
        this.userId = userId;
        this.insuredTime = insuredTime;
        this.beginTime = beginTime;
        this.endTime = endTime;
        this.channel = channel;
        this.salesId = salesId;
        this.dispute = dispute;
        this.type = type;
        this.premium = premium;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getInsuredTime() {
        return insuredTime;
    }

    public void setInsuredTime(String insuredTime) {
        this.insuredTime = insuredTime;
    }

    public String getBeginTime() {
        return beginTime;
    }

    public void setBeginTime(String beginTime) {
        this.beginTime = beginTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public String getChannel() {
        return channel;
    }

    public void setChannel(String channel) {
        this.channel = channel;
    }

    public String getSalesId() {
        return salesId;
    }

    public void setSalesId(String salesId) {
        this.salesId = salesId;
    }

    public String getDispute() {
        return dispute;
    }

    public void setDispute(String dispute) {
        this.dispute = dispute;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getPremium() {
        return premium;
    }

    public void setPremium(String premium) {
        this.premium = premium;
    }

    public String getReserve() {
        return reserve;
    }

    public void setReserve(String reserve) {
        this.reserve = reserve;
    }

}