package com.zcph.oaonline.serviceAll;

import java.util.Map;

public interface JtaTestService {
    /**
     * 向两个表内同时插入数据
     * @return
     */
    public Map<String,Object> insertToTwoDatebaseService();
}
