package com.insurance.demo.service;

import com.insurance.demo.entity.Mark;
import java.util.List;

/**
 * (Mark)表服务接口
 *
 * @author makejava
 * @since 2020-02-22 12:33:09
 */
public interface MarkService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    Mark queryById(Integer id);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<Mark> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param mark 实例对象
     * @return 实例对象
     */
    Mark insert(Mark mark);

    /**
     * 修改数据
     *
     * @param mark 实例对象
     * @return 实例对象
     */
    Mark update(Mark mark);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Integer id);

}