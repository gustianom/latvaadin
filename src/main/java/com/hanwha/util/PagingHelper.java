package com.hanwha.util;

import java.util.HashMap;
import java.util.List;

/**
 * Created by iabad on 07/11/2016.
 */
public interface PagingHelper {
    List getCustomListRenderer(HashMap var1, boolean var2);

    int countTotalList(HashMap var1);
}
