package com.insurance.demo.entity;

import java.io.Serializable;

/**
 * (Admin)实体类
 *
 * @author makejava
 * @since 2020-02-22 12:33:09
 */
public class Admin implements Serializable {
    private static final long serialVersionUID = -29484307542742515L;
    
    private Integer id;
    
    private String name;
    
    private String password;
    /**
    * 用户标识：1管理员2委员会3定损员
    */
    private Integer admin;
    /**
    * 预留字段
    */
    private String reserve;

    public Admin() {
    }

    public Admin(String name, String password, Integer admin, String reserve) {
        this.name = name;
        this.password = password;
        this.admin = admin;
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

    public Integer getAdmin() {
        return admin;
    }

    public void setAdmin(Integer admin) {
        this.admin = admin;
    }

    public String getReserve() {
        return reserve;
    }

    public void setReserve(String reserve) {
        this.reserve = reserve;
    }

}