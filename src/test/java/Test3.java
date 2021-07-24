import com.michilay.dao.OrdersMapper;
import com.michilay.dao.UserMapper;
import com.michilay.entity.Orders;
import com.michilay.entity.User;
import com.michilay.util.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.jupiter.api.Test;

import java.util.List;

public class Test3 {

    @Test
    public void testcache(){
        SqlSession sqlSession = SqlSessionUtil.getSS();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        sqlSession.clearCache();
        List<User> all = mapper.findAll();
        for (User user : all) {
            System.out.println(user);
        }
    }

    @Test
    public void test4(){
        SqlSession sqlSession = SqlSessionUtil.getSS();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User user = mapper.findUserById(1);
        System.out.println(user);
//        sqlSession.close();
//        User use1 = mapper.findUserById(1);
//        System.out.println(use1);
    }

    @Test
    public void test2(){
        UserMapper mapper = SqlSessionUtil.getSS().getMapper(UserMapper.class);
        List<User> users = mapper.selectAll();
        for (User user : users) {
            System.out.println(user);
        }
    }


    @Test
    public void test3(){
        OrdersMapper mapper = SqlSessionUtil.getSS().getMapper(OrdersMapper.class);
        List<Orders> orders = mapper.findAllWithUser1();
        for (Orders order : orders) {
            System.out.println(order);
        }
    }

    @Test
    public void test5(){
        UserMapper userMapper = SqlSessionUtil.getSS().getMapper(UserMapper.class);
        List<User> users = userMapper.findAllWithOrders1();
        for (User user : users) {
            System.out.println(user);
        }
    }

    @Test
    public void test6(){
        UserMapper userMapper = SqlSessionUtil.getSS().getMapper(UserMapper.class);
        List<User> users = userMapper.findAllWithRole1();
        for (User user : users) {
            System.out.println(user);
        }
    }
}
