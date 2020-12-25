package com.insurance.demo.Vo;

import lombok.Data;

/**
 * @USER: Mr.Wu
 * @DATE: 2020/4/12
 **/
@Data
public class DataVo {
    private int code;
    private String msg;
    private Integer count;
    private Object data;

    public DataVo() {
    }

    public DataVo(int code, String msg, Integer count, Object data) {
        this.code = code;
        this.msg = msg;
        this.count = count;
        this.data = data;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
