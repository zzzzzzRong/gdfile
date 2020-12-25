package com.insurance.demo.Vo;

import com.insurance.demo.entity.Insurancepolicy;
import com.insurance.demo.entity.Mark;
import lombok.Data;

/**
 * @USER: Mr.Wu
 * @DATE: 2020/3/22
 **/
@Data
public class InsAndMark {

    private Integer Mid;
    /**
     * 保单编号
     */
    private Integer insuranceId;
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

    public InsAndMark(Mark mark, Insurancepolicy insurancepolicy) {
        Mid = mark.getId();
        this.insuranceId = insurancepolicy.getId();
        this.userId = mark.getUserId();
        this.insuredTime = insurancepolicy.getInsuredTime();
        this.beginTime = insurancepolicy.getBeginTime();
        this.endTime = insurancepolicy.getEndTime();
        this.channel = insurancepolicy.getChannel();
        this.salesId = insurancepolicy.getSalesId();
        this.dispute = insurancepolicy.getDispute();
        this.type = insurancepolicy.getType();
        this.premium = insurancepolicy.getPremium();
        this.reserve = insurancepolicy.getReserve();
        this.carHost = mark.getCarHost();
        this.relationship = mark.getRelationship();
        this.carNumber = mark.getCarNumber();
        this.carEngine = mark.getCarEngine();
        this.carFrame = mark.getCarFrame();
        this.carModel = mark.getCarModel();
        this.carSeat = mark.getCarSeat();
        this.carDisplacement = mark.getCarDisplacement();
        this.carPower = mark.getCarPower();
        this.carFleet = mark.getCarFleet();
        this.nature = mark.getNature();
        this.carPrice = mark.getCarPrice();
    }

    public InsAndMark() {
    }
}
