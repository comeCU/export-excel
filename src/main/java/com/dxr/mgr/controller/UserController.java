package com.dxr.mgr.controller;
import com.dxr.mgr.service.saas.impl.UserServiceImpl;
import com.dxr.mgr.dao.saas.model.User;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 *
 * Created by dongyang.wang on 2018/04/02.
 */
@Controller
@RequestMapping("/user/")
public class UserController {

    @Autowired
    UserServiceImpl userService;

    @RequestMapping("add")
    @ResponseBody
    public String add(User user) {
        userService.save(user);
        return "";
    }

    @RequestMapping("delete")
    @ResponseBody
    public String delete(@RequestParam int id) {
	    userService.deleteById(id);
	    return "";
    }

    @RequestMapping("update")
    @ResponseBody
    public String update(User user) {
	    userService.update(user);
	    return "";
    }

    @RequestMapping("detail")
    @ResponseBody
    public String detail(@RequestParam Integer id) {
        User user = userService.findById(id);
        return user.toString();
    }

    @RequestMapping("list")
    @ResponseBody
    public String list(@RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "0") Integer size) {
        PageHelper.startPage(page, size);
        List<User> list = userService.findAll();
        PageInfo pageInfo = new PageInfo(list);
        return list.toString();
    }
}
