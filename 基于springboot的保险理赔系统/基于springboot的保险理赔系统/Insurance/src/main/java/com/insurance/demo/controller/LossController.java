package com.insurance.demo.controller;

import com.insurance.demo.entity.Loss;
import com.insurance.demo.entity.User;
import com.insurance.demo.service.LossService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * (Loss)表控制层
 *
 * @author makejava
 * @since 2020-02-24 11:45:47
 */
@RestController
@CrossOrigin(allowCredentials = "true", allowedHeaders = "*")
@RequestMapping("loss")
public class LossController {
    /**
     * 服务对象
     */
    @Resource
    private LossService lossService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public Loss selectOne(Integer id) {
        return this.lossService.queryById(id);
    }

    @GetMapping("selectOneByUserid")
    public Loss selectOneByUserid( HttpServletRequest request) {
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        return this.lossService.selectOneByUserid(user.getId());
    }

    @GetMapping("insert")
    public Loss insert(Integer casesId, Integer userId, String accidentType, String accidentLiability, String accidentLiabilityProportion, String userName, String surveyTime, String surveyLocation, Double medicalPrice, String repairPrice, String rescuePrice, String propertyInsurance, String liabilityInsurance) {
        Loss loss=new Loss(  casesId,   userId,   accidentType,   accidentLiability,   accidentLiabilityProportion,   userName,   surveyTime,   surveyLocation,   medicalPrice,   repairPrice,   rescuePrice,   propertyInsurance,   liabilityInsurance);
        this.lossService.insert(loss);
        return loss;
    }
    @GetMapping("update")
    public Loss update(int id,Integer casesId, Integer userId, String accidentType, String accidentLiability, String accidentLiabilityProportion, String userName, String surveyTime, String surveyLocation, Double medicalPrice, String repairPrice, String rescuePrice, String propertyInsurance, String liabilityInsurance) {
        Loss loss=new Loss(  casesId,   userId,   accidentType,   accidentLiability,   accidentLiabilityProportion,   userName,   surveyTime,   surveyLocation,   medicalPrice,   repairPrice,   rescuePrice,   propertyInsurance,   liabilityInsurance);
        loss.setId(id);
        this.lossService.update(loss);
        return loss;
    }
     @GetMapping("deleteById")
     public boolean deleteById(Integer id) {
        return this.lossService.deleteById(id) ;
    }
}