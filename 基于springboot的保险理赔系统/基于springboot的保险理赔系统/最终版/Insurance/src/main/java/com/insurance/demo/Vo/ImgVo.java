package com.insurance.demo.Vo;

import lombok.Data;

/**
 * @USER: Mr.Wu
 * @DATE: 2020/3/12
 **/
@Data
public class ImgVo {
    private String src;
    private String name;


    public ImgVo(String src, String name) {
        this.src = src;
        this.name = name;
    }
}
