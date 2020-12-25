package com.insurance.demo.controller;

import com.insurance.demo.Vo.DataVo;
import com.insurance.demo.dao.AdminDao;
import com.insurance.demo.entity.Admin;
import com.insurance.demo.entity.User;
import com.insurance.demo.service.AdminService;
import com.insurance.demo.service.UserService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * (Admin)表控制层
 *
 * @author makejava
 * @since 2020-02-22 12:34:26
 */
@RestController
@CrossOrigin(allowCredentials = "true", allowedHeaders = "*")
@RequestMapping("admin")
public class AdminController {
    /**
     * 服务对象
     */
    @Resource
    private AdminService adminService;
    @Resource
    private AdminDao adminDao;

    @GetMapping("Login")
    public DataVo Login(String name, String password,int admin, HttpServletRequest request) {
        DataVo dataVo=new DataVo();
        Admin a = new Admin();
        a.setName(name);
        a.setPassword(password);
        a.setAdmin(admin);
        HttpSession session = request.getSession();
        if (this.adminDao.queryAll(a).size() > 0) {
            a = this.adminDao.queryAll(a).get(0);
            session.setAttribute("Review", a);
            dataVo.setData(a);
            dataVo.setCode(0);
        } else {
            dataVo.setCode(404);
            dataVo.setMsg("登录失败");
        }
        return dataVo;
    }


    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public Admin selectOne(Integer id) {
        return this.adminService.queryById(id);
    }
    
    @GetMapping("insert")
    public Admin insert(String name, String password, Integer admin) {
        Admin a=new Admin( name,  password,  admin,  null);
        this.adminService.insert(a);
        return a;
    }
    @GetMapping("update")
    public Admin update(int id,String name, String password, Integer admin) {
        Admin a=new Admin( name,  password,  admin,  null);
        a.setId(id);
        this.adminService.update(a);
        return a;
    }

     @GetMapping("deleteById")
     public boolean deleteById(Integer id) {
        return this.adminService.deleteById(id) ;
    }

    /**
     * 1管理员2委员会3定损员
     * 分页查询委员会成员
     * @param page
     * @param limit
     * @return
     */
    @GetMapping("queryAllByLimit2")
    public DataVo queryAllByLimit2(int page, int limit) {
        System.out.println(page + limit);
        DataVo dataVo = new DataVo();
        try {
            List<Admin> users = adminService.queryAllByLimit2((page - 1) * limit, limit);
            dataVo.setData(users);
            dataVo.setCount(users.size());
            dataVo.setCode(0);
        } catch (Exception e) {
            dataVo.setMsg("查询失败");
            dataVo.setCode(500);
        }
        return dataVo;
    }
    @GetMapping("queryAllByLimit")
    public DataVo queryAllByLimit(int page, int limit) {
        System.out.println(page + limit);
        DataVo dataVo = new DataVo();
        try {
            List<Admin> users = adminService.queryAllByLimit((page - 1) * limit, limit);
            dataVo.setData(users);
            dataVo.setCount(users.size());
            dataVo.setCode(0);
        } catch (Exception e) {
            dataVo.setMsg("查询失败");
            dataVo.setCode(500);
        }
        return dataVo;
    }
    /**
     * 1管理员2委员会3定损员
     * 分页查询定损成员
     * @param page
     * @param limit
     * @return
     */
    @GetMapping("queryAllByLimit3")
    public DataVo queryAllByLimit3(int page, int limit) {
        System.out.println(page + limit);
        DataVo dataVo = new DataVo();
        try {
            List<Admin> users = adminService.queryAllByLimit3((page - 1) * limit, limit);
            dataVo.setData(users);
            dataVo.setCount(users.size());
            dataVo.setCode(0);
        } catch (Exception e) {
            dataVo.setMsg("查询失败");
            dataVo.setCode(500);
        }
        return dataVo;
    }


}