package com.insurance.demo.service.impl;

import com.insurance.demo.Vo.DataVo;
import com.insurance.demo.entity.Admin;
import com.insurance.demo.dao.AdminDao;
import com.insurance.demo.entity.Cases;
import com.insurance.demo.service.AdminService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (Admin)表服务实现类
 *
 * @author makejava
 * @since 2020-02-22 12:33:09
 */
@Service("adminService")
public class AdminServiceImpl implements AdminService {
    @Resource
    private AdminDao adminDao;

    @Override
    public DataVo queryType1(int page, int limit) {
        //queryAllByLimit3
        DataVo dataVo = new DataVo();
        try {
            List<Cases> cases = adminDao.queryType1((page - 1) * limit, limit);
            dataVo.setData(cases);
            dataVo.setCount(cases.size());
            dataVo.setCode(0);
        } catch (Exception e) {
            dataVo.setMsg("查询失败");
            dataVo.setCode(500);
        }
        return dataVo;
    }
    @Override
    public DataVo queryType2(int page, int limit) {
        //queryAllByLimit3
        DataVo dataVo = new DataVo();
        try {
            List<Cases> cases = adminDao.queryType2((page - 1) * limit, limit);
            dataVo.setData(cases);
            dataVo.setCount(cases.size());
            dataVo.setCode(0);
        } catch (Exception e) {
            dataVo.setMsg("查询失败");
            dataVo.setCode(500);
        }
        return dataVo;
    }

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public Admin queryById(Integer id) {
        return this.adminDao.queryById(id);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public List<Admin> queryAllByLimit(int offset, int limit) {
        return this.adminDao.queryAllByLimit(offset, limit);
    }
    @Override
    public List<Admin> queryAllByLimit2(int offset, int limit) {
        return this.adminDao.queryAllByLimit2(offset, limit);
    }
    @Override
    public List<Admin> queryAllByLimit3(int offset, int limit) {
        return this.adminDao.queryAllByLimit3(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param admin 实例对象
     * @return 实例对象
     */
    @Override
    public Admin insert(Admin admin) {
        this.adminDao.insert(admin);
        return admin;
    }

    /**
     * 修改数据
     *
     * @param admin 实例对象
     * @return 实例对象
     */
    @Override
    public Admin update(Admin admin) {
        this.adminDao.update(admin);
        return this.queryById(admin.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer id) {
        return this.adminDao.deleteById(id) > 0;
    }
}