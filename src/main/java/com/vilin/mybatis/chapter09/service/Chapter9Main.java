package com.vilin.mybatis.chapter09.service;

import com.vilin.mybatis.chapter09.mapper.ProcedureMapper;
import com.vilin.mybatis.chapter09.mapper.TFileMapper;
import com.vilin.mybatis.chapter09.pojo.Procedure;
import com.vilin.mybatis.chapter09.pojo.TFile;
import com.vilin.mybatis.util.SqlSessionFactoryUtil;
import org.apache.ibatis.session.SqlSession;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.logging.SimpleFormatter;

public class Chapter9Main {
    public static void main(String[] args) {
//        File file = new File("D:\\page2.PNG");
//        FileInputStream in = null;
//        try {
//            in = new FileInputStream(file);
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        }
//        byte[] bytes = new byte[(int) file.length()];
//        try{
//            in.read(bytes);
//        }catch (IOException e) {
//            e.printStackTrace();
//        }finally {
//            if(in != null){
//                try {
//                    in.close();
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//            }
//        }
//
//        TFile tFile = new TFile();
//        tFile.setFile(bytes);
//        SqlSession sqlSession = SqlSessionFactoryUtil.openSqlSession();
//        try{
//            TFileMapper tFileMapper = sqlSession.getMapper(TFileMapper.class);
//            tFileMapper.insertTFile(tFile);
//            System.out.println(tFile.getId());
//            sqlSession.commit();
//        }catch (Exception e){
//            sqlSession.rollback();
//            e.printStackTrace();
//        }finally {
//            if(sqlSession != null){
//                sqlSession.close();
//            }
//        }
        SqlSession sqlSession = SqlSessionFactoryUtil.openSqlSession();
        ProcedureMapper procedureMapper = sqlSession.getMapper(ProcedureMapper.class);
        int result = 0;
        Procedure procedure = new Procedure();
        procedure.setRoleName("role");
        procedureMapper.count(procedure);
        System.out.println(procedure.getRoleName() + "\t" + procedure.getResult() + "\t");
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        System.out.println(df.format(procedure.getExecDate()));
    }
}
