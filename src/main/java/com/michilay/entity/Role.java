package com.michilay.entity;

import com.michilay.entity.User;

import java.util.List;

public class Role {

    private Integer id;
    private String roleName;
    private String roleDesc;

    //关联属性
    private List<User> users;

    @Override
    public String toString() {
        return "Role{" +
                "id=" + id +
                ", roleName='" + roleName + '\'' +
                ", roleDesc='" + roleDesc + '\'' +
                ", users=" + users +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getRoleDesc() {
        return roleDesc;
    }

    public void setRoleDesc(String roleDesc) {
        this.roleDesc = roleDesc;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public Role(Integer id, String roleName, String roleDesc, List<User> users) {
        this.id = id;
        this.roleName = roleName;
        this.roleDesc = roleDesc;
        this.users = users;
    }

    public Role() {
    }
}
