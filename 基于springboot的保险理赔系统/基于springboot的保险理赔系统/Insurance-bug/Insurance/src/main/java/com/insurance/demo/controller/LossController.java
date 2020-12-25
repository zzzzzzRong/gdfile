package com.insurance.demo.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.insurance.demo.Vo.DataVo;
import com.insurance.demo.entity.Loss;
import com.insurance.demo.service.LossService;

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

    @GetMapping("queryAllByLimit")
    public DataVo queryAllByLimit(int page, int limit) {
        DataVo dataVo = new DataVo();
        try {
            List<Loss> lossList = lossService.queryAllByLimit((page - 1) * limit, limit);
            dataVo.setData(lossList);
            dataVo.setCount(lossList.size());
            dataVo.setCode(0);

        } catch (Exception e) {
            dataVo.setMsg("查询失败");
            dataVo.setCode(500);
        }
        return dataVo;
    }


    @GetMapping("insert")
    public Loss insert(Integer casesId, Integer userId, String accidentType, String accidentLiability, String accidentLiabilityProportion, String userName, String surveyTime, String surveyLocation, Double medicalPrice, String repairPrice, String rescuePrice, String propertyInsurance, String liabilityInsurance) {
        Loss loss=new Loss(  casesId,userId,accidentType,accidentLiability,accidentLiabilityProportion,userName,surveyTime,surveyLocation,medicalPrice,repairPrice,rescuePrice,propertyInsurance,liabilityInsurance);
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