package com.vilin.mybatis.util;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import sun.rmi.runtime.Log;

import java.io.IOException;
import java.io.InputStream;
import java.util.logging.Level;
import java.util.logging.Logger;

public class SqlSessionFactoryUtil {
    private static final String MYBATIS_CONFIG_FILE = "mybatis/mybatis-config.xml";
    private static Logger logger = Logger.getLogger(SqlSessionFactoryUtil.class.getName());

    //class锁
    private static final Class CLASS_LOCK = SqlSessionFactoryUtil.class;

    //SqlSessionFactory对象
    private static SqlSessionFactory sqlSessionFactory = null;
    //私有化构造函数
    private SqlSessionFactoryUtil(){ }

    public static SqlSessionFactory initSqlSessionFactory(){
        InputStream inputStream = null;
        try {
            inputStream = Resources.getResourceAsStream(MYBATIS_CONFIG_FILE);
        } catch (IOException e) {
            logger.log(Level.INFO, null, e);
        }

        synchronized (CLASS_LOCK){
            if(sqlSessionFactory == null){
                sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
            }
            return sqlSessionFactory;
        }
    }

    public static SqlSession openSqlSession(){
        if(sqlSessionFactory == null){
            initSqlSessionFactory();
        }
        return sqlSessionFactory.openSession();
    }
}
