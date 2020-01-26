package com.vilin.mybatis.chapter04.service;

import com.sun.istack.internal.logging.Logger;
import com.vilin.mybatis.chapter03.service.Chapter3Main;
import com.vilin.mybatis.chapter04.mapper.StudentMapper;
import com.vilin.mybatis.chapter04.po.MaleStudent;
import com.vilin.mybatis.chapter04.po.Student;
import com.vilin.mybatis.util.SqlSessionFactoryUtil;
import org.apache.ibatis.session.SqlSession;

public class Chapter4Main {
    private static Logger log = Logger.getLogger(Chapter3Main.class);

    public static void main(String[] args) {
        SqlSession sqlSession = null;
        try {
            sqlSession = SqlSessionFactoryUtil.openSqlSession();
            StudentMapper studentMapper = sqlSession.getMapper(StudentMapper.class);
//            Student student = studentMapper.getStudentById(1);
            MaleStudent maleStudent = (MaleStudent) studentMapper.getStudentById(1);
            System.out.println(maleStudent);
            sqlSession.commit();
        }catch (Exception e){
            log.info(e.getMessage());
            sqlSession.rollback();
        }finally {
            if(sqlSession != null){
                sqlSession.close();
            }
        }
    }
}
