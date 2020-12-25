package com.insurance.demo.service.impl;

import com.insurance.demo.entity.Loss;
import com.insurance.demo.dao.LossDao;
import com.insurance.demo.service.LossService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (Loss)表服务实现类
 *
 * @author makejava
 * @since 2020-02-24 11:45:47
 */
@Service("lossService")
public class LossServiceImpl implements LossService {
    @Resource
    private LossDao lossDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public Loss queryById(Integer id) {
        return this.lossDao.queryById(id);
    }
    @Override
    public Loss selectOneByUserid(Integer id) {
        return this.lossDao.selectOneByUserid(id);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public List<Loss> queryAllByLimit(int offset, int limit) {
        return this.lossDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param loss 实例对象
     * @return 实例对象
     */
    @Override
    public Loss insert(Loss loss) {
        this.lossDao.insert(loss);
        return loss;
    }

    /**
     * 修改数据
     *
     * @param loss 实例对象
     * @return 实例对象
     */
    @Override
    public Loss update(Loss loss) {
        this.lossDao.update(loss);
        return this.queryById(loss.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer id) {
        return this.lossDao.deleteById(id) > 0;
    }
}