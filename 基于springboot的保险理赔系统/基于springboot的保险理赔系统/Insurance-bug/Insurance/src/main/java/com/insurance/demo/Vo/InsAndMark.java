package com.insurance.demo.Vo;

import com.insurance.demo.entity.Insurancepolicy;
import com.insurance.demo.entity.Mark;
import lombok.Data;

/**
 * @USER: Mr.Wang
 * @DATE: 2020/2/22
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
    public Integer getMid() {
		return Mid;
	}

	public void setMid(Integer mid) {
		Mid = mid;
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
