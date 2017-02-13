package com.hanwha.bean;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by iabad on 07/11/2016.
 */
public abstract class HanwhaHelper<T> extends DaoHelper {
    protected final Logger logger = LoggerFactory.getLogger(HanwhaHelper.class);
    protected final HashMap map = new HashMap();
    protected boolean paging = false;
    protected boolean error = false;
    protected int start = 0;
    protected int limit = 0;


    public int countTotalList() {
        try {
            return countTotalList(map);
        } catch (Exception var2) {
            logger.error(var2.getMessage(), var2.fillInStackTrace());
            return 0;
        }
    }

    public abstract int countTotalList(HashMap var1) throws Exception;

    public List getListRenderer() {
        Object tmp = new ArrayList();

        try {
            if(paging && limit > 0) {
                map.put("skip", Integer.valueOf(start));
                map.put("max", Integer.valueOf(limit));
            }

            tmp = getListRenderer(map, paging);
        } catch (Exception var3) {
            error = true;
            var3.printStackTrace();
        }

        return (List)tmp;
    }

    public abstract List getListRenderer(HashMap var1, boolean var2) throws Exception;

    public boolean testHelper() {
        return false;
    }
}
