package com.zcph.oaonline.serviceAll.impl;

import com.zcph.oaonline.entity.News;
import com.zcph.oaonline.entity.UserLoginTable;
import com.zcph.oaonline.service.UserLoginService;
import com.zcph.oaonline.service2.NewsService;
import com.zcph.oaonline.serviceAll.JtaTestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.LinkedHashMap;
import java.util.Map;

@Service("jtaTestService")
public class JtaTestServiceImpl implements JtaTestService {
    @Autowired
    @Qualifier("userLoginService")
    private UserLoginService userLoginService;

    @Autowired
    @Qualifier("newsService")
    private NewsService newsService;

    @Override
    @Transactional(transactionManager = "xatx", propagation = Propagation.REQUIRED, rollbackFor = { java.lang.RuntimeException.class })
    public Map<String, Object> insertToTwoDatebaseService() {
        LinkedHashMap<String,Object> resultMap=new LinkedHashMap<String,Object>();
        UserLoginTable userLoginTable=new UserLoginTable();
        userLoginTable.setLoginName("8888");
        userLoginService.saveOrUpdateUserLogin(userLoginTable);

        News news=new News();
        news.setNewsTitle("8888");
        newsService.saveOrUpdateNews(news);
        //测试事务中断
        System.out.println(1/0);

        resultMap.put("state","success");
        resultMap.put("message","分布式事务同步成功");
        return resultMap;
    }
}
