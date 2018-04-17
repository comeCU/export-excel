package com.dxr.mgr.service.saas;

import org.springframework.stereotype.Service;

import java.util.List;
/**
 *
 * Created by dongyang.wang on 2018/04/02.
 */
@Service
public interface UserService<T> {

    void save(T record);
    void deleteById(int id);
    void update(T record);
    void insertUser(T record);

    T findById(int id);
    List<T> findAll();



}
