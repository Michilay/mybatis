package com.michilay.entity;

public class Orders {

    private Integer id;
    private String orderTime;
    private Double total;

    //根据订单关联用户信息
    private User user;

    @Override
    public String toString() {
        return "Orders{" +
                "id=" + id +
                ", orderTime='" + orderTime + '\'' +
                ", total=" + total +
                ", user=" + user +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getOrderTime() {
        return orderTime;
    }

    public void setOrderTime(String orderTime) {
        this.orderTime = orderTime;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
