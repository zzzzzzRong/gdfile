package com.insurance.demo.entity;

import java.io.Serializable;

/**
 * (Loss)实体类
 *
 * @author makejava
 * @since 2020-02-24 11:45:47
 */
public class Loss implements Serializable {
    private static final long serialVersionUID = -59334191421173751L;
    
    private Integer id;
    /**
    * 报案单号
    */
    private Integer casesId;
    /**
    * 投保人编号
    */
    private Integer userId;
    /**
    * 事故类型
    */
    private String accidentType;
    /**
    * 事故责任
    */
    private String accidentLiability;
    /**
    * 事故责任比例
    */
    private String accidentLiabilityProportion;
    /**
    * 驾驶员姓名
    */
    private String userName;
    /**
    * 查勘时间
    */
    private String surveyTime;
    /**
    * 查勘地点
    */
    private String surveyLocation;
    /**
    * 医疗费用
    */
    private Double medicalPrice;
    /**
    * 修车费用
    */
    private String repairPrice;
    /**
    * 施救费用
    */
    private String rescuePrice;
    /**
    * 财产险应赔付费用
    */
    private String propertyInsurance;
    /**
    * 责任险应赔付费用
    */
    private String liabilityInsurance;

    public Loss() {
    }

    public Loss(Integer casesId, Integer userId, String accidentType, String accidentLiability, String accidentLiabilityProportion, String userName, String surveyTime, String surveyLocation, Double medicalPrice, String repairPrice, String rescuePrice, String propertyInsurance, String liabilityInsurance) {
        this.casesId = casesId;
        this.userId = userId;
        this.accidentType = accidentType;
        this.accidentLiability = accidentLiability;
        this.accidentLiabilityProportion = accidentLiabilityProportion;
        this.userName = userName;
        this.surveyTime = surveyTime;
        this.surveyLocation = surveyLocation;
        this.medicalPrice = medicalPrice;
        this.repairPrice = repairPrice;
        this.rescuePrice = rescuePrice;
        this.propertyInsurance = propertyInsurance;
        this.liabilityInsurance = liabilityInsurance;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCasesId() {
        return casesId;
    }

    public void setCasesId(Integer casesId) {
        this.casesId = casesId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getAccidentType() {
        return accidentType;
    }

    public void setAccidentType(String accidentType) {
        this.accidentType = accidentType;
    }

    public String getAccidentLiability() {
        return accidentLiability;
    }

    public void setAccidentLiability(String accidentLiability) {
        this.accidentLiability = accidentLiability;
    }

    public String getAccidentLiabilityProportion() {
        return accidentLiabilityProportion;
    }

    public void setAccidentLiabilityProportion(String accidentLiabilityProportion) {
        this.accidentLiabilityProportion = accidentLiabilityProportion;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getSurveyTime() {
        return surveyTime;
    }

    public void setSurveyTime(String surveyTime) {
        this.surveyTime = surveyTime;
    }

    public String getSurveyLocation() {
        return surveyLocation;
    }

    public void setSurveyLocation(String surveyLocation) {
        this.surveyLocation = surveyLocation;
    }

    public Double getMedicalPrice() {
        return medicalPrice;
    }

    public void setMedicalPrice(Double medicalPrice) {
        this.medicalPrice = medicalPrice;
    }

    public String getRepairPrice() {
        return repairPrice;
    }

    public void setRepairPrice(String repairPrice) {
        this.repairPrice = repairPrice;
    }

    public String getRescuePrice() {
        return rescuePrice;
    }

    public void setRescuePrice(String rescuePrice) {
        this.rescuePrice = rescuePrice;
    }

    public String getPropertyInsurance() {
        return propertyInsurance;
    }

    public void setPropertyInsurance(String propertyInsurance) {
        this.propertyInsurance = propertyInsurance;
    }

    public String getLiabilityInsurance() {
        return liabilityInsurance;
    }

    public void setLiabilityInsurance(String liabilityInsurance) {
        this.liabilityInsurance = liabilityInsurance;
    }

}