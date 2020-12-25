package com.insurance.demo.controller;

import com.insurance.demo.entity.Mark;
import com.insurance.demo.service.MarkService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (Mark)表控制层
 *
 * @author makejava
 * @since 2020-02-22 12:34:26
 */
@RestController
@CrossOrigin(allowCredentials = "true", allowedHeaders = "*")
@RequestMapping("mark")
public class MarkController {
    /**
     * 服务对象
     */
    @Resource
    private MarkService markService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public Mark selectOne(Integer id) {
        return this.markService.queryById(id);
    }
    
    @GetMapping("insert")
    public Mark insert(Integer insuranceId, Integer userId, String carHost, String relationship, String carNumber, String carEngine, String carFrame, String carModel, String carSeat, String carDisplacement, String carPower, Integer carFleet, String nature, Double carPrice) {
        Mark mark=new Mark( insuranceId,  userId,  carHost,  relationship,  carNumber,  carEngine,  carFrame,  carModel,  carSeat,  carDisplacement,  carPower,  carFleet,  nature,  carPrice);
        return this.markService.insert(mark);

    }
     @GetMapping("update")
    public Mark update(Mark mark) {
        return this.markService.update(mark);
           
    }
     @GetMapping("deleteById")
     public boolean deleteById(Integer id) {
        return this.markService.deleteById(id) ;
    }
}