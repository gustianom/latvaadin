package com.hanwha.dao;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.Reader;
import java.util.Properties;

/**
 * Created by iabad on 07/11/2016.
 */
public class DaoConfig {
    private static final String resource = "xml/oracle/SqlMapConfig.xml";
    private static Properties props = null;

    private static SqlSessionFactory sqlSessionFactory;
    private static DaoConfig sqlFactory;

    private DaoConfig() {

    }

    private static DaoConfig getInstance() throws IOException {
        //System.out.println("");
        //System.out.println("");
        //System.out.println("");
        //System.out.println("");
        //System.out.println("DaoConfig.getInstance");
        Reader reader = null;

        if (sqlFactory == null) {
            System.out.println("resource = " + resource);
            reader = Resources.getResourceAsReader(resource);
            System.out.println("reader = " + reader);

            sqlFactory = new DaoConfig();
            sqlFactory.sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);

        }
        return sqlFactory;
    }

    public static synchronized SqlSessionFactory getSessionFactory() throws IOException {

        if (sqlFactory == null) {
            getInstance();
        }
        return sqlSessionFactory;
    }


    public Object clone() throws CloneNotSupportedException {
        throw new CloneNotSupportedException();
    }
}