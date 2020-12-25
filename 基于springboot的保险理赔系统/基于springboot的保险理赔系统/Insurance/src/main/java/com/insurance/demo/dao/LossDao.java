package com.insurance.demo.dao;

import com.insurance.demo.entity.Loss;
import org.apache.ibatis.annotations.Param;
import java.util.List;

/**
 * (Loss)表数据库访问层
 *
 * @author makejava
 * @since 2020-02-24 11:45:47
 */
public interface LossDao {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    Loss queryById(Integer id);
    Loss selectOneByUserid(Integer id);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<Loss> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param loss 实例对象
     * @return 对象列表
     */
    List<Loss> queryAll(Loss loss);

    /**
     * 新增数据
     *
     * @param loss 实例对象
     * @return 影响行数
     */
    int insert(Loss loss);

    /**
     * 修改数据
     *
     * @param loss 实例对象
     * @return 影响行数
     */
    int update(Loss loss);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Integer id);

}