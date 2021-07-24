package com.michilay.util;


import com.michilay.dao.OrdersMapper;
import com.michilay.dao.UserMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

public class SqlSessionUtil {
    private static InputStream is = null;
    private static SqlSessionFactory build = null;
    private static SqlSession ss = null;
    private static UserMapper um = null;
    private static OrdersMapper om = null;
    static {
        try {
            is = Resources.getResourceAsStream("MyBatis.xml");
        } catch (IOException e) {
            e.printStackTrace();
        }
        SqlSessionFactory build = new SqlSessionFactoryBuilder().build(is);
        ss = build.openSession();
    }
    public static SqlSession getSS(){
        return ss;
    }
    public static void cc() {ss.commit();ss.close();}
}

