package com.michilay.dao;

import com.michilay.entity.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface UserMapper {

    @Select("Select * from user")
    List<User> selectAll();

    @Select("select * from user where user_id = #{id}")
    public User findById1(Integer id);

    @Select("select * from user")
    @Results({
            @Result(id = true,column = "user_id",property = "userId"),
            @Result(column = "user_name",property = "userName"),
            @Result(property = "birthday",column = "birthday"),
            @Result(property = "sex",column = "sex"),
            @Result(property = "address",column = "address"),
            @Result(property = "Listorders",
                    javaType = List.class,
                    column = "uid",
                    many = @Many(select = "com.michilay.dao.OrdersMapper.findByUid1")

            )
    })
    public List<User> findAllWithOrders1();


    @Select("select * from user")
    @Results({
            @Result(id = true,column = "user_id",property = "userId"),
            @Result(column = "user_name",property = "userName"),
            @Result(property = "birthday",column = "birthday"),
            @Result(property = "sex",column = "sex"),
            @Result(property = "address",column = "address"),
            @Result(property = "ListRole",
            javaType = List.class,
            column = "uid",
            many = @Many(select = "com.michilay.dao.RoleMapper.findByUid1"))
    })
    public List<User> findAllWithRole1();

    User findUserById(int id);
    User findUserByName(String username);
    List<User> findAll();
//    模糊查询
    List<User> findUser(String username);
    List<User> findUser1(String username);

    int insertUser(User user);
    int deleteUser(int id);

//    更新数据
    int updateUser(User user);

//    多条件查询
    User findUserByIdAndName(int id,String username);
//    在参数中指定传入的参数
    User findUserByIdAndName1(@Param(value = "id") int id,@Param("username") String username);
//    通过实体传递参数,最常用的
    User findUserByIdAndName2(User user);

    int insertUser1(User user);


//    动态查询
    List<User> findAnimateSql(User user);

//    枚举集合查询
    List<User> findManyId(List<Integer> ids);

//数组查询
    List<User> findManyId1(Integer[] ids);









    //通过用户查询所有订单信息
    List<User> findAllUserAndOrders();

    //通过id查询所有的用户信息 注意：这个id代表的是uid（嵌套查询）
    User findUserByIdqt(Integer id);

    //查询类用户信息(嵌套查询）关联的订单信息
    List<User> findAllUserqt();

    //查询用户信息关联的角色信息
    List<User> findAllWithRole();

}
