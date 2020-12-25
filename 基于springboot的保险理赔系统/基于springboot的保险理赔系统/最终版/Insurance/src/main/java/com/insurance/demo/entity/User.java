package com.insurance.demo.entity;

import java.util.Date;
import java.io.Serializable;

/**
 * (User)实体类
 *
 * @author makejava
 * @since 2020-02-22 12:33:09
 */
public class User implements Serializable {
    private static final long serialVersionUID = 706966094127078124L;
    
    private Integer id;
    
    private String name;
    
    private String password;
    /**
    * 性别
    */
    private String sex;
    /**
    * 籍贯
    */
    private String hometown;
    /**
    * 生日
    */
    private Date birthday;
    /**
    * 家庭住址
    */
    private String address;
    /**
    * 是否理赔(如果标和保单都存在，则此字段为1)
    */
    private String reserve;

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", sex='" + sex + '\'' +
                ", hometown='" + hometown + '\'' +
                ", birthday=" + birthday +
                ", address='" + address + '\'' +
                ", reserve='" + reserve + '\'' +
                '}';
    }

    public User() {
    }

    public User(String name, String password, String sex, String hometown, Date birthday, String address, String reserve) {
        this.name = name;
        this.password = password;
        this.sex = sex;
        this.hometown = hometown;
        this.birthday = birthday;
        this.address = address;
        this.reserve = reserve;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getHometown() {
        return hometown;
    }

    public void setHometown(String hometown) {
        this.hometown = hometown;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getReserve() {
        return reserve;
    }

    public void setReserve(String reserve) {
        this.reserve = reserve;
    }

}