package com.vilin.mybatis.util;

import com.vilin.mybatis.chapter02.mapper.RoleMapper2;
import org.apache.ibatis.datasource.pooled.PooledDataSource;
import org.apache.ibatis.mapping.Environment;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.ibatis.transaction.TransactionFactory;
import org.apache.ibatis.transaction.jdbc.JdbcTransactionFactory;

public class MyBatisJavaConfigUtil {

    private final static String dbDriver = "com.mysql.cj.jdbc.Driver";

    private final static String dbURL = "jdbc:mysql://localhost:3306/mybatis_test?serverTimezone=GMT%2B8";

    private final static String username = "root";

    private final static String password = "Lw@1985105";


    public static SqlSessionFactory getSqlSessionFactory(){
        //构建数据库连接池
        PooledDataSource dataSource = new PooledDataSource();
        dataSource.setDriver(dbDriver);
        dataSource.setUrl(dbURL);
        dataSource.setUsername(username);
        dataSource.setPassword(password);

        //创建数据库事务处理方式
        TransactionFactory transactionFactory = new JdbcTransactionFactory();

        //创建了数据库运行环境
        Environment environment = new Environment("development", transactionFactory, dataSource);

        //构建配置对象
        Configuration configuration = new Configuration(environment);

        //加入映射器
        configuration.addMapper(RoleMapper2.class);

        //使用SqlSessionFactoryBuilder构建SqlSessionFactory

        return new SqlSessionFactoryBuilder().build(configuration);
    }
}
