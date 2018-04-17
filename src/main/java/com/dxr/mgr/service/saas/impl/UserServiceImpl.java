package com.dxr.mgr.service.saas.impl;

import com.dxr.mgr.dao.saas.mapper.UserMapper;
import com.dxr.mgr.dao.saas.model.User;
import com.dxr.mgr.service.saas.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 *
 * Created by dongyang.wang on 2018/04/02.
 */
@Service
public class UserServiceImpl implements UserService <User> {

    @Autowired
    public UserMapper userMapper;
    @Override
    public void save(User record){
        userMapper.insertSelective(record);
    }
    @Override
    public void deleteById(int id){
        userMapper.deleteByPrimaryKey(id);
    }
    @Override
    public void update(User record){
        userMapper.updateByPrimaryKey(record);
    }
    @Override
    public User findById(int id){

        return userMapper.getUser(id);
    }
    @Override
    public List<User> findAll(){
        return userMapper.getAll();
    }
    @Override
    public void insertUser(User user){
        userMapper.insertUser(user);
    }

}
