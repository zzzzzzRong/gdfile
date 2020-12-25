package com.insurance.demo.controller;

import com.insurance.demo.entity.Insurancepolicy;
import com.insurance.demo.service.InsurancepolicyService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (Insurancepolicy)表控制层
 *
 * @author makejava
 * @since 2020-02-22 12:34:26
 */
@RestController
@CrossOrigin(allowCredentials = "true", allowedHeaders = "*")
@RequestMapping("insurancepolicy")
public class InsurancepolicyController {
    /**
     * 服务对象
     */
    @Resource
    private InsurancepolicyService insurancepolicyService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public Insurancepolicy selectOne(Integer id) {
        return this.insurancepolicyService.queryById(id);
    }

    @GetMapping("insert")
    public Insurancepolicy insert(Integer userId, String insuredTime, String beginTime, String endTime, String channel, String salesId, String dispute, String type, String premium) {
        Insurancepolicy insurancepolicy = new Insurancepolicy(userId, insuredTime, beginTime, endTime, channel, salesId, dispute, type, premium);
        return this.insurancepolicyService.insert(insurancepolicy);
    }

    @GetMapping("update")
    public Insurancepolicy update(Insurancepolicy insurancepolicy) {
        return this.insurancepolicyService.update(insurancepolicy);

    }

    @GetMapping("deleteById")
    public boolean deleteById(Integer id) {
        return this.insurancepolicyService.deleteById(id);
    }
}