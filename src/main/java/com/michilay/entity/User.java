package com.michilay.entity;

import java.util.Date;
import java.util.List;

public class User {
    private Integer userId;
    private String userName;
    private Date birthday;
    private String sex;
    private String address;

    //设计关联属性
    private List<Orders> listOrders;

    //关联角色属性
    private List<Role> listRole;

    public List<Role> getListRole() {
        return listRole;
    }

    public void setListRole(List<Role> listRole) {
        this.listRole = listRole;
    }

    public List<Orders> getListOrders() {
        return listOrders;
    }

    public void setListOrders(List<Orders> listOrders) {
        this.listOrders = listOrders;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", userName='" + userName + '\'' +
                ", birthday=" + birthday +
                ", sex='" + sex + '\'' +
                ", address='" + address + '\'' +

                ", listRole=" + listRole +
                '}';
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public User(Integer userId, String userName, Date birthday, String sex, String address) {
        this.userId = userId;
        this.userName = userName;
        this.birthday = birthday;
        this.sex = sex;
        this.address = address;
    }

    public User() {
    }
}
