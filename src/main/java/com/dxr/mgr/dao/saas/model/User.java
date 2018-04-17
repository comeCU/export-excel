package com.dxr.mgr.dao.saas.model;

import com.dxr.mgr.common.saas.annotation.UserExcel;

import javax.persistence.*;

@Table(name = "user0")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @UserExcel(name="学号")
    @Column(name = "user_id")
    private Integer userId;

    @UserExcel(name="昵称")
    @Column(name = "user_petname")
    private String userPetname;

    @UserExcel(name="姓名")
    @Column(name = "user_name")
    private String userName;

    @UserExcel(name="密码", flag = false)
    @Column(name = "user_pass")
    private String userPass;

    @UserExcel(name="手机号")
    @Column(name = "user_phone")
    private String userPhone;

    @UserExcel(name="邮箱")
    @Column(name = "user_email")
    private String userEmail;

    /**
     * 1为学生，2为教师，3为管理员
     */
    @UserExcel(name="类别")
    @Column(name = "user_grade")
    private Integer userGrade;

    /**
     * 1为正常，2为冻结，3为注销
     */
    @UserExcel(name="账号状态")
    @Column(name = "user_status")
    private Integer userStatus;

    /**
     * @return id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * @return user_id
     */
    public Integer getUserId() {
        return userId;
    }

    /**
     * @param userId
     */
    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    /**
     * @return user_petname
     */
    public String getUserPetname() {
        return userPetname;
    }

    /**
     * @param userPetname
     */
    public void setUserPetname(String userPetname) {
        this.userPetname = userPetname;
    }

    /**
     * @return user_name
     */
    public String getUserName() {
        return userName;
    }

    /**
     * @param userName
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }

    /**
     * @return user_pass
     */
    public String getUserPass() {
        return userPass;
    }

    /**
     * @param userPass
     */
    public void setUserPass(String userPass) {
        this.userPass = userPass;
    }

    /**
     * @return user_phone
     */
    public String getUserPhone() {
        return userPhone;
    }

    /**
     * @param userPhone
     */
    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone;
    }

    /**
     * @return user_email
     */
    public String getUserEmail() {
        return userEmail;
    }

    /**
     * @param userEmail
     */
    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    /**
     * 获取1为学生，2为教师，3为管理员
     *
     * @return user_grade - 1为学生，2为教师，3为管理员
     */
    public Integer getUserGrade() {
        return userGrade;
    }

    /**
     * 设置1为学生，2为教师，3为管理员
     *
     * @param userGrade 1为学生，2为教师，3为管理员
     */
    public void setUserGrade(Integer userGrade) {
        this.userGrade = userGrade;
    }

    /**
     * 获取1为正常，2为冻结，3为注销
     *
     * @return user_status - 1为正常，2为冻结，3为注销
     */
    public Integer getUserStatus() {
        return userStatus;
    }

    /**
     * 设置1为正常，2为冻结，3为注销
     *
     * @param userStatus 1为正常，2为冻结，3为注销
     */
    public void setUserStatus(Integer userStatus) {
        this.userStatus = userStatus;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", userId=" + userId +
                ", userPetname='" + userPetname + '\'' +
                ", userName='" + userName + '\'' +
                ", userPass='" + userPass + '\'' +
                ", userPhone='" + userPhone + '\'' +
                ", userEmail='" + userEmail + '\'' +
                ", userGrade=" + userGrade +
                ", userStatus=" + userStatus +
                '}';
    }
}