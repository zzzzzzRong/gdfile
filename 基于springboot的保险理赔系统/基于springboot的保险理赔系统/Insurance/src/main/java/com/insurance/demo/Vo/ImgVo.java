package com.insurance.demo.Vo;

import lombok.Data;

/**
 * @USER: Mr.Wang
 * @DATE: 2020/1/12
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
