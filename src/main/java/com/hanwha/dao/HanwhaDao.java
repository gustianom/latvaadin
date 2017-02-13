package com.hanwha.dao;

import org.apache.ibatis.session.SqlSession;

/**
 * Created by iabad on 07/11/2016.
 */
public class HanwhaDao {
    public SqlSession session;

    public HanwhaDao(SqlSession session) {
        this.setSession(session);
    }

    public SqlSession getSession() {
        return this.session;
    }

    private void setSession(SqlSession session) {
        this.session = session;
    }

}
