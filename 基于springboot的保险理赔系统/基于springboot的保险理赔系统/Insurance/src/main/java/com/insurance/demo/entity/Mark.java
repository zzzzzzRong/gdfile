package com.insurance.demo.entity;

import java.io.Serializable;

/**
 * (Mark)实体类
 *
 * @author makejava
 * @since 2020-02-22 12:33:09
 */
public class Mark implements Serializable {
    private static final long serialVersionUID = 650326767661677191L;
    
    private Integer id;
    /**
    * 保单编号
    */
    private Integer insuranceId;
    /**
    * 投保人编号
    */
    private Integer userId;
    /**
    * 车主
    */
    private String carHost;
    /**
    * 投保人与车辆关系
    */
    private String relationship;
    /**
    * 车牌号
    */
    private String carNumber;
    /**
    * 发动机号
    */
    private String carEngine;
    /**
    * 车架号
    */
    private String carFrame;
    /**
    * 厂牌车型
    */
    private String carModel;
    /**
    * 核定座位
    */
    private String carSeat;
    /**
    * 排量
    */
    private String carDisplacement;
    /**
    * 功率
    */
    private String carPower;
    /**
    * 是否车队车辆
    */
    private Integer carFleet;
    /**
    * 使用性质
    */
    private String nature;
    /**
    * 购置价
    */
    private Double carPrice;

    public Mark(Integer insuranceId, Integer userId, String carHost, String relationship, String carNumber, String carEngine, String carFrame, String carModel, String carSeat, String carDisplacement, String carPower, Integer carFleet, String nature, Double carPrice) {
        this.insuranceId = insuranceId;
        this.userId = userId;
        this.carHost = carHost;
        this.relationship = relationship;
        this.carNumber = carNumber;
        this.carEngine = carEngine;
        this.carFrame = carFrame;
        this.carModel = carModel;
        this.carSeat = carSeat;
        this.carDisplacement = carDisplacement;
        this.carPower = carPower;
        this.carFleet = carFleet;
        this.nature = nature;
        this.carPrice = carPrice;
    }

    public Mark() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getInsuranceId() {
        return insuranceId;
    }

    public void setInsuranceId(Integer insuranceId) {
        this.insuranceId = insuranceId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getCarHost() {
        return carHost;
    }

    public void setCarHost(String carHost) {
        this.carHost = carHost;
    }

    public String getRelationship() {
        return relationship;
    }

    public void setRelationship(String relationship) {
        this.relationship = relationship;
    }

    public String getCarNumber() {
        return carNumber;
    }

    public void setCarNumber(String carNumber) {
        this.carNumber = carNumber;
    }

    public String getCarEngine() {
        return carEngine;
    }

    public void setCarEngine(String carEngine) {
        this.carEngine = carEngine;
    }

    public String getCarFrame() {
        return carFrame;
    }

    public void setCarFrame(String carFrame) {
        this.carFrame = carFrame;
    }

    public String getCarModel() {
        return carModel;
    }

    public void setCarModel(String carModel) {
        this.carModel = carModel;
    }

    public String getCarSeat() {
        return carSeat;
    }

    public void setCarSeat(String carSeat) {
        this.carSeat = carSeat;
    }

    public String getCarDisplacement() {
        return carDisplacement;
    }

    public void setCarDisplacement(String carDisplacement) {
        this.carDisplacement = carDisplacement;
    }

    public String getCarPower() {
        return carPower;
    }

    public void setCarPower(String carPower) {
        this.carPower = carPower;
    }

    public Integer getCarFleet() {
        return carFleet;
    }

    public void setCarFleet(Integer carFleet) {
        this.carFleet = carFleet;
    }

    public String getNature() {
        return nature;
    }

    public void setNature(String nature) {
        this.nature = nature;
    }

    public Double getCarPrice() {
        return carPrice;
    }

    public void setCarPrice(Double carPrice) {
        this.carPrice = carPrice;
    }

}