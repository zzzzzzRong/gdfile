package com.insurance.demo.service.impl;

import com.insurance.demo.entity.Insurancepolicy;
import com.insurance.demo.dao.InsurancepolicyDao;
import com.insurance.demo.service.InsurancepolicyService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (Insurancepolicy)表服务实现类
 *
 * @author makejava
 * @since 2020-02-22 12:33:09
 */
@Service("insurancepolicyService")
public class InsurancepolicyServiceImpl implements InsurancepolicyService {
    @Resource
    private InsurancepolicyDao insurancepolicyDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public Insurancepolicy queryById(Integer id) {
        return this.insurancepolicyDao.queryById(id);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public List<Insurancepolicy> queryAllByLimit(int offset, int limit) {
        return this.insurancepolicyDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param insurancepolicy 实例对象
     * @return 实例对象
     */
    @Override
    public Insurancepolicy insert(Insurancepolicy insurancepolicy) {
        this.insurancepolicyDao.insert(insurancepolicy);
        return insurancepolicy;
    }

    /**
     * 修改数据
     *
     * @param insurancepolicy 实例对象
     * @return 实例对象
     */
    @Override
    public Insurancepolicy update(Insurancepolicy insurancepolicy) {
        this.insurancepolicyDao.update(insurancepolicy);
        return this.queryById(insurancepolicy.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer id) {
        return this.insurancepolicyDao.deleteById(id) > 0;
    }
}