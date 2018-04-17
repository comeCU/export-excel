package com.dxr.mgr.starter.saas;

import com.dxr.mgr.dao.saas.model.User;
import com.dxr.mgr.service.saas.impl.UserServiceImpl;
import com.dxr.mgr.untils.sass.ExportExcel;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * Created by dongyang.wang on 2018/4/2 0002 .
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ApplicationTest {

    @Autowired
    public UserServiceImpl userService;

    @Test
    public void findUserById(){
        System.out.println(userService.findById(1).toString());
    }
    @Test
    public void findAll(){
        System.out.println(userService.findAll());
    }
    @Test
    public void insertUser(){
        for (int i = 0; i < 10000; i++) {
            User user = new User();
//		user.setId(4);						//* ID
            user.setUserEmail(i+"sdker@163.com");	//  邮箱
            user.setUserGrade(2);				//* 用户级别（1:学生2:老师3:管理员）
            user.setUserId(1572111+i);			//* 学号
            user.setUserName("赵六"+i);			//* 姓名
            user.setUserPass("543332"+i);			//* 密码
            user.setUserPetname("哈哈"+i);		//  昵称
            user.setUserPhone("18800343421");	//  手机号
            user.setUserStatus(1);				//* 用户状态（1:正常2:冻结3:注销）
            userService.insertUser(user);
        }

    }
    @Test
    public void exportExcelTest(){
       List<User> userList = userService.findAll();
        ExportExcel.createExcel(userList);
    }
}
