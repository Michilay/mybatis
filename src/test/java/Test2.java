import com.michilay.dao.OrdersMapper;
import com.michilay.dao.RoleMapper;
import com.michilay.dao.UserMapper;
import com.michilay.entity.Orders;
import com.michilay.entity.Role;
import com.michilay.entity.User;
import com.michilay.util.SqlSessionUtil;
import org.junit.jupiter.api.Test;

import java.util.List;

public class Test2 {

//    一对一
    @Test
    public void test(){
        OrdersMapper mapper = SqlSessionUtil.getSS().getMapper(OrdersMapper.class);
        List<Orders> orders = mapper.findAllOrdersAndUser();
        for (Orders order:orders){
            System.out.println(order);
        }
    }

//    一对多
    @Test
    public void test1(){
        UserMapper mapper = SqlSessionUtil.getSS().getMapper(UserMapper.class);
        List<User> users = mapper.findAllUserAndOrders();
        for(User user :users){
            System.out.println(user);
        }
    }

//    多对多
    @Test
    public void test2(){
        RoleMapper mapper = SqlSessionUtil.getSS().getMapper(RoleMapper.class);
        List<Role> roles = mapper.findAllRoleAndUser();
        for (Role role : roles) {
            System.out.println(role);
        }
    }


//    嵌套查询
    @Test
    public void test3(){
        OrdersMapper mapper = SqlSessionUtil.getSS().getMapper(OrdersMapper.class);
        List<Orders> all = mapper.findAll();
        for (Orders orders : all) {
            System.out.println(orders);
        }
    }
    @Test
    public void test4(){
        UserMapper mapper = SqlSessionUtil.getSS().getMapper(UserMapper.class);
        List<User> allUserqt = mapper.findAllUserqt();
        for (User user : allUserqt) {
            System.out.println(user);
        }
    }
    @Test
    public void test5(){
        UserMapper mapper = SqlSessionUtil.getSS().getMapper(UserMapper.class);
        List<User> allUser = mapper.findAllWithRole();
        for (User user : allUser) {
            System.out.println(user);
        }
    }
}
