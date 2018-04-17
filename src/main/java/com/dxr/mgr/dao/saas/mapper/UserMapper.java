package com.dxr.mgr.dao.saas.mapper;

import com.weimob.saas.mybatis.mapper.common.Mapper;
import com.dxr.mgr.dao.saas.model.User;
import org.apache.ibatis.annotations.*;
import tk.mybatis.mapper.common.MySqlMapper;

import java.util.List;


public interface UserMapper<T> extends Mapper<T>, MySqlMapper<T> {
    @Select("SELECT * FROM user0 WHERE id = #{userId}")
    @ResultMap("BaseResultMap")
    User getUser(@Param("userId") int userId);

    @Select("SELECT * FROM user0")
    @ResultMap("BaseResultMap")
    List<User> getAll();

    @Insert("insert into user0 (user_id,user_petname,user_name,user_pass,user_phone,user_email,user_grade,user_status) " +
            "values (#{userId},#{userPetname},#{userName},#{userPass},#{userPhone},#{userEmail},#{userGrade},#{userStatus})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    @ResultMap("BaseResultMap")
    void insertUser(User user);
}
