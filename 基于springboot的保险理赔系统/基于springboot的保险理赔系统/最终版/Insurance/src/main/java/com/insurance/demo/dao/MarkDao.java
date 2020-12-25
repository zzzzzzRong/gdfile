package com.insurance.demo.dao;

import com.insurance.demo.entity.Mark;
import org.apache.ibatis.annotations.Param;
import java.util.List;

/**
 * (Mark)表数据库访问层
 *
 * @author makejava
 * @since 2020-02-22 12:33:09
 */
public interface MarkDao {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    Mark queryById(Integer id);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<Mark> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param mark 实例对象
     * @return 对象列表
     */
    List<Mark> queryAll(Mark mark);

    /**
     * 新增数据
     *
     * @param mark 实例对象
     * @return 影响行数
     */
    int insert(Mark mark);

    /**
     * 修改数据
     *
     * @param mark 实例对象
     * @return 影响行数
     */
    int update(Mark mark);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Integer id);

}