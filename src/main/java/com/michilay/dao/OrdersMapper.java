package com.michilay.dao;

import com.michilay.entity.Orders;
import com.michilay.entity.User;
import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.mapping.FetchType;

import java.util.List;

public interface OrdersMapper {

    //查询所有订单关联的用户信息
    List<Orders> findAllOrdersAndUser();

    //查询用户订单信息
    List<Orders> findAll();

    //通过uid查询订单信息
    List<Orders> findOrderbyUid();

    @Select("select * from orders")
    @Results({
            @Result(id = true,column = "id",property = "id"),
            @Result(property="orderTime",column="ordertime"),
            @Result(property="total",column="total"),
            @Result(property = "user",javaType = User.class,column = "user_id",
                    one = @One(select = "com.michilay.dao.UserMapper.findById1",
                            fetchType = FetchType.EAGER))
    })
        public List<Orders> findAllWithUser1();

    @Select("select * from orders where uid = #{uid}")
    public List<Orders> findByUid1(Integer uid);
}
