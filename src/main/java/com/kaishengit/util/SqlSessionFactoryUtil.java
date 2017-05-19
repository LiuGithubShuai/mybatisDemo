package com.kaishengit.util;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.Reader;

/**
 * Created by Administrator on 2017/5/8.
 */
public class SqlSessionFactoryUtil {

    private static SqlSessionFactory sqlSessionFactory = builderSqlSessionFactory();

    private static SqlSessionFactory builderSqlSessionFactory() {
        Reader reader = null;
        try {
            reader = Resources.getResourceAsReader("mybatis.xml");
            return new SqlSessionFactoryBuilder().build(reader);
        } catch (IOException e) {
            throw new RuntimeException("读取mybatis.xml错误",e);
        }
    }

    public static SqlSessionFactory getSqlSessionFactory() {
        return sqlSessionFactory;
    }

    public static SqlSession getSqlSession(){
        return getSqlSessionFactory().openSession();
    }

    public static SqlSession getSqlSession(boolean isAutoCommit){
        return getSqlSessionFactory().openSession(isAutoCommit);
    }

}
