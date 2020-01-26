package com.vilin.mybatis.chapter04.service;


import com.vilin.mybatis.chapter04.mapper.StudentMapper;
import com.vilin.mybatis.chapter04.po.MaleStudent;
import com.vilin.mybatis.chapter04.po.Student;
import com.vilin.mybatis.util.SqlSessionFactoryUtil;
import org.apache.ibatis.session.SqlSession;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Chapter4Main {
    private static Logger logger = LogManager.getLogger(Chapter4Main.class);

    public static void main(String[] args) {
        SqlSession sqlSession = null;
        SqlSession sqlSession2 = null;
        try {
            sqlSession = SqlSessionFactoryUtil.openSqlSession();
            StudentMapper studentMapper = sqlSession.getMapper(StudentMapper.class);
            Student student = studentMapper.getStudentById(1);
//            MaleStudent maleStudent = (MaleStudent) studentMapper.getStudentById(1);
            logger.debug("使用同一个session在执行一次");
            Student student2 = studentMapper.getStudentById(1);
            sqlSession.commit();
            logger.debug("现在创建一个新的sqlSession在执行一次");
            sqlSession2 = SqlSessionFactoryUtil.openSqlSession();
            StudentMapper studentMapper2 = sqlSession2.getMapper(StudentMapper.class);
            Student student3 = studentMapper2.getStudentById(1);
            sqlSession2.commit();
        }catch (Exception e){
            logger.info(e);
            sqlSession.rollback();
            sqlSession2.rollback();
        }finally {
            if(sqlSession != null){
                sqlSession.close();
            }
            if(sqlSession2 != null){
                sqlSession2.close();
            }
        }
    }
}
