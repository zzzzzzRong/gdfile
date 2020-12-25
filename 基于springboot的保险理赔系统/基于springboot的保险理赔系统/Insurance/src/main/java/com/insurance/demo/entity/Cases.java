package com.insurance.demo.entity;

import java.util.Date;
import java.io.Serializable;

/**
 * (Cases)实体类
 *
 * @author makejava
 * @since 2020-02-23 12:42:46
 */
public class Cases implements Serializable {
    private static final long serialVersionUID = -50367170587435643L;
    
    private Integer id;
    /**
    * 用户id
    */
    private Integer userId;
    /**
    * 保单id
    */
    private Integer insId;
    /**
    * 标id
    */
    private Integer markId;
    /**
    * 出险日期
    */
    private String accidentTime;
    /**
    * 出险地点
    */
    private String accidentAreaid;
    /**
    * 报案人
    */
    private String userName;
    /**
    * 报案人电话
    */
    private String userPhone;
    /**
    * 车型
    */
    private String carType;
    /**
    * 详情
    */
    private String details;
    /**
    * 审核状态：1等待审核 2定损中 3审核通过 4委员会填报信息 5理赔成功 6审核不通过
     * 1.已报案 2.立案（对应下面的接受受理）  3.审核中  4.审核通过（两个只亮其中一个）
     * 5.审核不通过      6.委员会审核中    7.审核通过   8审核不通过
     * 9.理赔受理中    10理赔结束
    */
    private Integer type;
    /**
    * 不通过原因
    */
    private String cause;
    /**
    * 定损员id
    */
    private Integer reviewId;
    /**
    * 定损员姓名
    */
    private String reviewName;
    /**
    * 委员会id
    */
    private Integer committee;
    /**
    * 报案时间
    */
    private Date occurTime;

    public Cases() {
    }

    public Cases(Integer userId, Integer insId, Integer markId, String accidentTime, String accidentAreaid, String userName, String userPhone, String carType, String details, Integer type, String cause, Integer reviewId, String reviewName, Integer committee, Date occurTime) {
        this.userId = userId;
        this.insId = insId;
        this.markId = markId;
        this.accidentTime = accidentTime;
        this.accidentAreaid = accidentAreaid;
        this.userName = userName;
        this.userPhone = userPhone;
        this.carType = carType;
        this.details = details;
        this.type = type;
        this.cause = cause;
        this.reviewId = reviewId;
        this.reviewName = reviewName;
        this.committee = committee;
        this.occurTime = occurTime;
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

    public Integer getInsId() {
        return insId;
    }

    public void setInsId(Integer insId) {
        this.insId = insId;
    }

    public Integer getMarkId() {
        return markId;
    }

    public void setMarkId(Integer markId) {
        this.markId = markId;
    }

    public String getAccidentTime() {
        return accidentTime;
    }

    public void setAccidentTime(String accidentTime) {
        this.accidentTime = accidentTime;
    }

    public String getAccidentAreaid() {
        return accidentAreaid;
    }

    public void setAccidentAreaid(String accidentAreaid) {
        this.accidentAreaid = accidentAreaid;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPhone() {
        return userPhone;
    }

    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone;
    }

    public String getCarType() {
        return carType;
    }

    public void setCarType(String carType) {
        this.carType = carType;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getCause() {
        return cause;
    }

    public void setCause(String cause) {
        this.cause = cause;
    }

    public Integer getReviewId() {
        return reviewId;
    }

    public void setReviewId(Integer reviewId) {
        this.reviewId = reviewId;
    }

    public String getReviewName() {
        return reviewName;
    }

    public void setReviewName(String reviewName) {
        this.reviewName = reviewName;
    }

    public Integer getCommittee() {
        return committee;
    }

    public void setCommittee(Integer committee) {
        this.committee = committee;
    }

    public Date getOccurTime() {
        return occurTime;
    }

    public void setOccurTime(Date occurTime) {
        this.occurTime = occurTime;
    }

}