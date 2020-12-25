package com.insurance.demo.controller;

import com.insurance.demo.Vo.DataVo;
import com.insurance.demo.dao.CasesDao;
import com.insurance.demo.dao.InsurancepolicyDao;
import com.insurance.demo.dao.MarkDao;
import com.insurance.demo.entity.*;
import com.insurance.demo.service.CasesService;
import com.insurance.demo.service.InsurancepolicyService;
import com.insurance.demo.service.UserService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.List;

/**
 * (Cases)表控制层
 *
 * @author makejava
 * @since 2020-04-23 12:42:46
 */
@RestController
@CrossOrigin(allowCredentials = "true", allowedHeaders = "*")
@RequestMapping("cases")
public class CasesController {
    /**
     * 服务对象
     */
    @Resource
    private CasesService casesService;
    @Resource
    private UserService userService;
    @Resource
    private CasesDao casesDao;

    @Resource
    private InsurancepolicyDao insurancepolicyDao;
    @Resource
    private MarkDao markDao;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public Cases selectOne(Integer id) {
        return this.casesService.queryById(id);
    }

    @GetMapping("insert")
    public Cases insert(HttpServletRequest request, String accidentTime, String areaid, String userName, String userPhone, String carType, String details, String cause, Integer reviewId, String reviewName, Integer committee) {
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        Mark mark = new Mark();
        mark.setUserId(user.getId());
        mark = markDao.queryAll(mark).get(0);
        Cases cases = new Cases(user.getId(), mark.getInsuranceId(), mark.getId(), accidentTime, areaid, userName, userPhone, carType, details, 1, cause, reviewId, reviewName, committee, new Date());
        this.casesService.insert(cases);
        return cases;
    }


    @GetMapping("update")
    public Cases update(int id, String accidentTime,String cause, String reviewName, String areaid, String userName, String userPhone, String carType,
                        String details ) {
        Cases cases = casesService.queryById(id);
        cases.setUserName(userName);
        cases.setAccidentAreaid(areaid);
        cases.setUserPhone(userPhone);
        cases.setCarType(carType);
        cases.setDetails(details);
        if (cause!=null)
        cases.setCause(cause);
        if (reviewName!=null)
        cases.setReviewName(reviewName);
        cases.setAccidentTime(accidentTime);
        this.casesService.update(cases);
        return cases;
    }

    @GetMapping("deleteById")
    public boolean deleteById(Integer id) {
        return this.casesService.deleteById(id);
    }

    @GetMapping("refuse")
    public Cases refuse(Integer id, String cause) {
        Cases c = this.casesService.queryById(id);
        c.setType(5);
        c.setCause(cause);
        return casesService.update(c);
    }

    @GetMapping("refuse2")
    public Cases refuse2(Integer id, String cause) {
        Cases c = this.casesService.queryById(id);
        c.setType(8);
        c.setCause(cause);
        return casesService.update(c);
    }

    //定损员审核通过，
    @GetMapping("passed")
    public Cases passed(Integer id, int comid, HttpServletRequest request) {
        Cases c = this.casesService.queryById(id);
        c.setType(4);
        c.setCommittee(comid);
//        HttpSession session = request.getSession();
//        Admin review = (Admin) session.getAttribute("Review");
//        c.setReviewId(review.getId());
//        c.setReviewName(review.getName());
        return casesService.update(c);
    }

    //  定损员确认受理
    @GetMapping("confirm")
    public Cases confirm(Integer id, HttpServletRequest request) {
        Cases c = this.casesService.queryById(id);
        c.setType(3);
        HttpSession session = request.getSession();
        Admin review = (Admin) session.getAttribute("Review");
        c.setReviewId(review.getId());
        c.setReviewName(review.getName());
        return casesService.update(c);
    }

    //  委员会确认受理
    @GetMapping("confirm2")
    public Cases confirm2(Integer id, HttpServletRequest request) {
        Cases c = this.casesService.queryById(id);
        c.setType(6);
        HttpSession session = request.getSession();
        Admin review = (Admin) session.getAttribute("Review");
//        c.setReviewId(review.getId());
//        c.setReviewName(review.getName());
        return casesService.update(c);
    }

    //  委员会确认理赔
    @GetMapping("againpassed")
    public Cases againpassed(Integer id, HttpServletRequest request) {
        Cases c = this.casesService.queryById(id);
        c.setType(10);
        return casesService.update(c);
    }

    @GetMapping("getIns")
    public Insurancepolicy getIns(Integer userId) {
        Insurancepolicy insurancepolicy = new Insurancepolicy();
        insurancepolicy.setUserId(userId);
        return insurancepolicyDao.queryAll(insurancepolicy).get(0);
    }

    @GetMapping("getMark")
    public Mark getMark(Integer userId) {
        Mark insurancepolicy = new Mark();
        insurancepolicy.setUserId(userId);
        return markDao.queryAll(insurancepolicy).get(0);
    }

    @GetMapping("getType")
    public Cases getType(HttpServletRequest request) {
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        Cases cases = new Cases();
        cases.setUserId(user.getId());
        List<Cases> cases1 = casesDao.queryAll(cases);
        if (cases1.size() > 0) {
            return cases1.get(cases1.size() - 1);
        } else {
            Cases cases2 = new Cases();
            cases2.setType(0);
            return cases2;
        }
    }

    @GetMapping("getUnprocessed")
    public List<Cases> getUnprocessed(HttpServletRequest request) {
        Cases cases = new Cases();
        cases.setType(1);
        List<Cases> cases1 = casesDao.queryAll(cases);
        return cases1;
    }

    @GetMapping("queryAllByLimit")
    public DataVo queryAllByLimit(int page, int limit) {
        System.out.println(page + limit);
        DataVo dataVo = new DataVo();
        try {
            List<Cases> users = casesService.queryAllByLimit((page - 1) * limit, limit);
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
     * 查询待定损员立案
     *
     * @param page
     * @param limit
     * @return
     */
    @GetMapping("queryAllByLimit1")
    public DataVo queryAllByLimit1(Integer page, Integer limit, HttpServletRequest request) {
        System.out.println(page + limit);
        HttpSession session = request.getSession();
        Admin review = (Admin) session.getAttribute("Review");
        DataVo dataVo = new DataVo();
        try {
            List<Cases> users = casesService.queryAllByLimit1((page - 1) * limit, limit);
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
     * 查询待定损员审核
     *
     * @param page
     * @param limit
     * @return
     */
    @GetMapping("queryAllByLimit3")
    public DataVo queryAllByLimit3(Integer page, Integer limit, HttpServletRequest request) {
        System.out.println(page + limit);
        HttpSession session = request.getSession();
        Admin review = (Admin) session.getAttribute("Review");
        DataVo dataVo = new DataVo();
        try {
            List<Cases> users = casesService.queryAllByLimit3((page - 1) * limit, limit, review.getId());
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
     * 查询待委员会确认
     *
     * @param page
     * @param limit
     * @return
     */
    @GetMapping("queryAllByLimit4")
    public DataVo queryAllByLimit4(int page, int limit, HttpServletRequest request) {
        System.out.println(page + limit);
        HttpSession session = request.getSession();
        Admin review = (Admin) session.getAttribute("Review");
        DataVo dataVo = new DataVo();
        try {
            List<Cases> users = casesService.queryAllByLimit4((page - 1) * limit, limit, review.getId());
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
     * 查询待委员会审核
     *
     * @param page
     * @param limit
     * @return
     */
    @GetMapping("queryAllByLimit6")
    public DataVo queryAllByLimit6(int page, int limit, HttpServletRequest request) {
        System.out.println(page + limit);
        HttpSession session = request.getSession();
        Admin review = (Admin) session.getAttribute("Review");
        DataVo dataVo = new DataVo();
        try {
            List<Cases> users = casesService.queryAllByLimit6((page - 1) * limit, limit, review.getId());
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