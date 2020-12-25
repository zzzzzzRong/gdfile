package com.insurance.demo.service;

import com.insurance.demo.entity.Loss;
import com.insurance.demo.entity.User;

import java.util.List;

/**
 * (Loss)表服务接口
 *
 * @author makejava
 * @since 2020-02-24 11:45:47
 */
public interface LossService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    Loss queryById(Integer id);
    Loss selectOneByUserid(Integer id);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<Loss> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param loss 实例对象
     * @return 实例对象
     */
    Loss insert(Loss loss);

    /**
     * 修改数据
     *
     * @param loss 实例对象
     * @return 实例对象
     */
    Loss update(Loss loss);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Integer id);
    


}