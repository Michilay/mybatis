package com.michilay.dao;

import com.michilay.entity.Role;
import org.apache.ibatis.annotations.Many;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface RoleMapper {

    //查询所有的角色对用的用户信息
    List<Role> findAllRoleAndUser();


    List<Role> findByUid(Integer uid);


    @Select("SELECT * FROM role r INNER JOIN " +
            "user_role ur ON r.`id` = ur.`rid` " +
            "WHERE ur.`uid` = #{uid};")
    public List<Role> findByUid1(Integer uid);
}
