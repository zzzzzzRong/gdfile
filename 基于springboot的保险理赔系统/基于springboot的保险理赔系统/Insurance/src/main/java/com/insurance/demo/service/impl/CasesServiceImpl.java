package com.insurance.demo.service.impl;

import com.insurance.demo.entity.Cases;
import com.insurance.demo.dao.CasesDao;
import com.insurance.demo.service.CasesService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (Cases)表服务实现类
 *
 * @author makejava
 * @since 2020-02-23 12:42:46
 */
@Service("casesService")
public class CasesServiceImpl implements CasesService {
    @Resource
    private CasesDao casesDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public Cases queryById(Integer id) {
        return this.casesDao.queryById(id);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public List<Cases> queryAllByLimit(int offset, int limit) {
        return this.casesDao.queryAllByLimit(offset, limit);
    }
    @Override
    public List<Cases> queryAllByLimit1(int offset, int limit) {
        return this.casesDao.queryAllByLimit1(offset, limit);
    }
    @Override
    public List<Cases> queryAllByLimit3(int offset, int limit,int reviewID) {
        return this.casesDao.queryAllByLimit3(offset, limit, reviewID);
    }
    @Override
    public List<Cases> queryAllByLimit4(int offset, int limit,int reviewID) {
        return this.casesDao.queryAllByLimit4(offset, limit, reviewID);
    }
    @Override
    public List<Cases> queryAllByLimit6(int offset, int limit,int committee) {
        return this.casesDao.queryAllByLimit6(offset, limit,committee);
    }

    /**
     * 新增数据
     *
     * @param cases 实例对象
     * @return 实例对象
     */
    @Override
    public Cases insert(Cases cases) {
        this.casesDao.insert(cases);
        return cases;
    }

    /**
     * 修改数据
     *
     * @param cases 实例对象
     * @return 实例对象
     */
    @Override
    public Cases update(Cases cases) {
        this.casesDao.update(cases);
        return this.queryById(cases.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer id) {
        return this.casesDao.deleteById(id) > 0;
    }
}