import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.michilay.dao.UserMapper;
import com.michilay.entity.User;
import com.michilay.util.SqlSessionUtil;
import org.junit.jupiter.api.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Test1 {


    @Test
    public void findUserById(){
        User user = SqlSessionUtil.getSS().getMapper(UserMapper.class).findUserById(1);
        System.out.println(user);
    }

    @Test
    public void findAll(){
        List<User> users = SqlSessionUtil.getSS().getMapper(UserMapper.class).findAll();
        users.forEach((user -> System.out.println(user)));
    }
    @Test
    public void findUser(){
        List<User> users = SqlSessionUtil.getSS().getMapper(UserMapper.class).findUser("%子%");
        users.forEach((user -> System.out.println(user)));
    }
    @Test
    public void findUser1(){
        List<User> users = SqlSessionUtil.getSS().getMapper(UserMapper.class).findUser1("子");
        users.forEach((user -> System.out.println(user)));
    }
    @Test
    public void insertUser1(){
        Date date = null;
        try {
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            date = dateFormat.parse("2015-08-28 18:28:30");
        } catch (ParseException e) {
            e.printStackTrace();
        }
        User user = new User(0, "9琦浩", date, "女", "湖北荆州");
        SqlSessionUtil.getSS().getMapper(UserMapper.class).insertUser1(user);
        System.out.println(user);
        SqlSessionUtil.cc();
    }
    @Test
    public void updateUser(){
        UserMapper userMapper = SqlSessionUtil.getSS().getMapper(UserMapper.class);
        Date date = null;
        try {
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            date = dateFormat.parse("2015-08-28 18:28:30");
        } catch (ParseException e) {
            e.printStackTrace();
        }
        User user = new User();
        user.setUserId(4);
        user.setBirthday(date);
        userMapper.updateUser(user);
        SqlSessionUtil.cc();
    }

    @Test
    public void findUserByIdAndName(){
        User user = SqlSessionUtil.getSS().getMapper(UserMapper.class).findUserByIdAndName(1,"子慕");
        System.out.println(user);
    }
    @Test
    public void fin(){
        UserMapper userMapper = SqlSessionUtil.getSS().getMapper(UserMapper.class);
        User u = new User();
        u.setUserId(1);
        u.setUserName("子慕");
        User user = userMapper.findUserByIdAndName2(u);
        System.out.println(user);
    }

    @Test
    public void find(){
        UserMapper userMapper = SqlSessionUtil.getSS().getMapper(UserMapper.class);
        User u = new User();
        u.setUserName("子");
        u.setSex("男");
        List<User> animateSql = userMapper.findAnimateSql(u);
        for (User user : animateSql) {
            System.out.println(user);
        }
    }

    @Test
    public void findids(){
        UserMapper userMapper = SqlSessionUtil.getSS().getMapper(UserMapper.class);
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        List<User> users= userMapper.findManyId(list);
        for (User user : users){
            System.out.println(user);
        }
    }
    @Test
    public void findids1(){
        UserMapper userMapper = SqlSessionUtil.getSS().getMapper(UserMapper.class);
        Integer[] ids = {1,2,3,4,5};
        List<User> users= userMapper.findManyId1(ids);
        for (User user : users){
            System.out.println(user);
        }
    }



    @Test
    public void test18(){
        UserMapper userMapper =SqlSessionUtil.getSS().getMapper(UserMapper.class);
        PageHelper.startPage(5,2);
        List<User> users = userMapper.findAll();
        for (User user : users){
            System.out.println(user);
        }
//        使用page插件
//        pageinfo包含了所有信息
        PageInfo<User> pageInfo = new PageInfo<>(users);
        System.out.println("总条数"+pageInfo.getTotal());
        System.out.println("当前是第几页"+pageInfo.getPageNum());
        System.out.println("当前是不是第一页"+pageInfo.isIsFirstPage());
        System.out.println("当前是不是最后一页"+pageInfo.isIsLastPage());
        System.out.println("总页数"+pageInfo.getPages());
    }
}
