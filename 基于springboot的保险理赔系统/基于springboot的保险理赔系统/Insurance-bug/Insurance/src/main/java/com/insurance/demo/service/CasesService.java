package com.insurance.demo.service;

import com.insurance.demo.entity.Cases;
import java.util.List;

/**
 * (Cases)表服务接口
 *
 * @author makejava
 * @since 2020-02-23 12:42:46
 */
public interface CasesService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    Cases queryById(Integer id);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<Cases> queryAllByLimit(int offset, int limit);
    List<Cases> queryAllByLimit1(int offset, int limit);
    List<Cases> queryAllByLimit3(int offset, int limit,int reviewID);
    List<Cases> queryAllByLimit4(int offset, int limit,int reviewID);
    List<Cases> queryAllByLimit6(int offset, int limit,int committee);

    /**
     * 新增数据
     *
     * @param cases 实例对象
     * @return 实例对象
     */
    Cases insert(Cases cases);

    /**
     * 修改数据
     *
     * @param cases 实例对象
     * @return 实例对象
     */
    Cases update(Cases cases);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Integer id);

}