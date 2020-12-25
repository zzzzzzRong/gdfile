package com.insurance.demo.controller;

import com.insurance.demo.Vo.DataVo;
import com.insurance.demo.Vo.InsAndMark;
import com.insurance.demo.dao.InsurancepolicyDao;
import com.insurance.demo.dao.MarkDao;
import com.insurance.demo.dao.UserDao;
import com.insurance.demo.entity.Admin;
import com.insurance.demo.entity.Insurancepolicy;
import com.insurance.demo.entity.Mark;
import com.insurance.demo.entity.User;
import com.insurance.demo.service.InsurancepolicyService;
import com.insurance.demo.service.MarkService;
import com.insurance.demo.service.UserService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * (User)表控制层
 *
 * @author makejava
 * @since 2020-02-22 12:34:26
 */
@RestController
@CrossOrigin(allowCredentials = "true", allowedHeaders = "*")
@RequestMapping("user")
public class UserController {
    /**
     * 服务对象
     */
    @Resource
    private UserService userService;
    @Resource
    private UserDao userDao;
    @Resource
    private InsurancepolicyService insurancepolicyService;
    @Resource
    private InsurancepolicyDao insurancepolicyDao;

    @Resource
    private MarkDao markDao;
    @Resource
    private MarkService markService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public User selectOne(Integer id) {
        return this.userService.queryById(id);
    }

    @GetMapping("insert")
    public User insert(String name, String password, String sex, String hometown, String birthday, String address, String reserve) {
        Date date = null;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");//注意月份是MM

        try {
            date = simpleDateFormat.parse(birthday);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        User user = new User(name, password, sex, hometown, date, address, "不可报案");
        this.userService.insert(user);
        return user;
    }

    @GetMapping("update")
    public User update(int id,  HttpServletRequest request,String name, String password, String sex, String hometown, String birthday, String address, String reserve) {
        Date date = null;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");//注意月份是MM
        try {
            date = simpleDateFormat.parse(birthday);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        HttpSession session = request.getSession();
        User user = new User(name, password, sex, hometown, date, address, reserve);
        user.setId(id);
        user=  this.userService.update(user);
        session.removeAttribute("user");
        session.invalidate();
//        session.setAttribute("user", user);
//        User u= (User) session.getAttribute("user");
//        System.out.println(u);
        return user;

    }

    @GetMapping("deleteById")
    public boolean deleteById(Integer id) {
        return this.userService.deleteById(id);
    }

    @GetMapping("queryAllByLimit")
    public DataVo queryAllByLimit(int page, int limit) {
        System.out.println(page + limit);
        DataVo dataVo = new DataVo();
        try {
            List<User> users = userService.queryAllByLimit((page - 1) * limit, limit);
            dataVo.setData(users);
            dataVo.setCount(users.size());
            dataVo.setCode(0);

        } catch (Exception e) {
            dataVo.setMsg("查询失败");
            dataVo.setCode(500);
        }
        return dataVo;
    }


    @GetMapping("insertInsAndMark")
    public Mark insertInsAndMark( String carHost, String relationship, String carNumber, String carEngine, String carFrame, String carModel, String carSeat, String carDisplacement, String carPower, Integer carFleet, String nature, Double carPrice, Integer userId, String insuredTime, String beginTime, String endTime, String channel, String salesId, String dispute, String type, String premium) {
        Insurancepolicy insurancepolicy = new Insurancepolicy(userId, insuredTime, beginTime, endTime, channel, salesId, dispute, type, premium);
        insurancepolicy = this.insurancepolicyService.insert(insurancepolicy);
        Mark mark = new Mark(insurancepolicy.getId(), userId, carHost, relationship, carNumber, carEngine, carFrame, carModel, carSeat, carDisplacement, carPower, carFleet, nature, carPrice);
        User user = userService.queryById(userId);
        user.setReserve("可报案");
        userService.update(user);
        return this.markService.insert(mark);
    }

    @GetMapping("updateInsAndMark")
    public Mark updateInsAndMark(int insuranceId, int mid, String carHost, String relationship, String carNumber, String carEngine, String carFrame, String carModel, String carSeat, String carDisplacement, String carPower, Integer carFleet, String nature, Double carPrice, Integer userId, String insuredTime, String beginTime, String endTime, String channel, String salesId, String dispute, String type, String premium) {
        Insurancepolicy insurancepolicy = new Insurancepolicy(userId, insuredTime, beginTime, endTime, channel, salesId, dispute, type, premium);
        insurancepolicy.setId(insuranceId);
        insurancepolicy = this.insurancepolicyService.update(insurancepolicy);
        Mark mark = new Mark(insurancepolicy.getId(), userId, carHost, relationship, carNumber, carEngine, carFrame, carModel, carSeat, carDisplacement, carPower, carFleet, nature, carPrice);
        mark.setId(mid);
        return this.markService.update(mark);
    }

    @GetMapping("selectByUserid")
    public InsAndMark selectByUserid(Integer userId) {
        Insurancepolicy insurancepolicy = new Insurancepolicy();
        insurancepolicy.setUserId(userId);
        List<Insurancepolicy> insurancepolicies = this.insurancepolicyDao.queryAll(insurancepolicy);
        InsAndMark insAndMark = new InsAndMark();
        insAndMark.setUserId(userId);
        if (insurancepolicies.size() > 0) {
            Mark mark = new Mark();
            mark.setUserId(userId);
            mark = markDao.queryAll(mark).get(0);
            insAndMark = new InsAndMark(mark, insurancepolicies.get(0));

        }
        return insAndMark;
    }

    @GetMapping("Login")
    public DataVo Login(String name, String password, HttpServletRequest request) {
        DataVo dataVo = new DataVo();
        User a = new User();
        a.setName(name);
        a.setPassword(password);
        a.setReserve("可报案");
        HttpSession session = request.getSession();
        if (this.userDao.queryAll(a).size() > 0) {
            a = this.userDao.queryAll(a).get(0);
            session.setAttribute("user", a);
            dataVo.setData(a);
            dataVo.setCode(0);
        } else {
            dataVo.setCode(404);
            dataVo.setMsg("登录失败");
        }
        return dataVo;
    }

    @GetMapping("getSession")
    public DataVo getSession(HttpServletResponse response, HttpServletRequest request) {
        HttpSession session = request.getSession();
        DataVo dataVo=new DataVo();
        User user = (User) session.getAttribute("user");
        if (user==null){
            dataVo.setCode(404);
            dataVo.setMsg("未登录");
        }else {
            user=userService.queryById(user.getId());
            dataVo.setCode(0);
            dataVo.setMsg("已登录");
            dataVo.setData(user);
        }
        return dataVo;

    }

}