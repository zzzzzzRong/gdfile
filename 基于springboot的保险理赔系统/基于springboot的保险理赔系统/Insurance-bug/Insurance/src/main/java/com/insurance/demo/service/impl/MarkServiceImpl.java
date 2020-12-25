package com.insurance.demo.service.impl;

import com.insurance.demo.entity.Mark;
import com.insurance.demo.dao.MarkDao;
import com.insurance.demo.service.MarkService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (Mark)表服务实现类
 *
 * @author makejava
 * @since 2020-02-22 12:33:09
 */
@Service("markService")
public class MarkServiceImpl implements MarkService {
    @Resource
    private MarkDao markDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public Mark queryById(Integer id) {
        return this.markDao.queryById(id);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public List<Mark> queryAllByLimit(int offset, int limit) {
        return this.markDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param mark 实例对象
     * @return 实例对象
     */
    @Override
    public Mark insert(Mark mark) {
        this.markDao.insert(mark);
        return mark;
    }

    /**
     * 修改数据
     *
     * @param mark 实例对象
     * @return 实例对象
     */
    @Override
    public Mark update(Mark mark) {
        this.markDao.update(mark);
        return this.queryById(mark.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer id) {
        return this.markDao.deleteById(id) > 0;
    }
}