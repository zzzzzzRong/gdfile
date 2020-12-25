package com.insurance.demo.dao;

import com.insurance.demo.entity.Cases;
import org.apache.ibatis.annotations.Param;
import java.util.List;

/**
 * (Cases)表数据库访问层
 *
 * @author makejava
 * @since 2020-02-23 12:42:46
 */
public interface CasesDao {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    Cases queryById(Integer id);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<Cases> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);
    List<Cases> queryAllByLimit1(@Param("offset") int offset, @Param("limit") int limit);
    List<Cases> queryAllByLimit3(@Param("offset") int offset, @Param("limit") int limit,@Param("reviewID") int reviewID);
    List<Cases> queryAllByLimit4(@Param("offset") int offset, @Param("limit") int limit,@Param("committee") int reviewID);
    List<Cases> queryAllByLimit6(@Param("offset") int offset, @Param("limit") int limit,@Param("committee") int committee);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param cases 实例对象
     * @return 对象列表
     */
    List<Cases> queryAll(Cases cases);

    /**
     * 新增数据
     *
     * @param cases 实例对象
     * @return 影响行数
     */
    int insert(Cases cases);

    /**
     * 修改数据
     *
     * @param cases 实例对象
     * @return 影响行数
     */
    int update(Cases cases);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Integer id);

}