package com.hanwha.bean;

import com.hanwha.dao.DaoConfig;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.HashMap;
import java.util.List;

/**
 * Created by iabad on 07/11/2016.
 */
public abstract class DaoHelper {
    public SqlSessionFactory sqlSessionFactory;

    public DaoHelper() {
        try {
            this.sqlSessionFactory = DaoConfig.getSessionFactory();
        } catch (Exception var2) {
            var2.printStackTrace();
        }

    }

    public abstract int countTotalList(HashMap parameter) throws Exception;

    public abstract List getListRenderer(HashMap parameter, boolean navigated) throws Exception;
}