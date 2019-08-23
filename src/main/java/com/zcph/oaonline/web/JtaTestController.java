package com.zcph.oaonline.web;

import com.zcph.oaonline.entity.News;
import com.zcph.oaonline.entity.UserLoginTable;
import com.zcph.oaonline.model.PageRusult;
import com.zcph.oaonline.service.UserLoginService;
import com.zcph.oaonline.service2.NewsService;
import com.zcph.oaonline.serviceAll.JtaTestService;
import com.zcph.oaonline.util.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import tk.mybatis.mapper.util.StringUtil;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/jtaTest")
public class JtaTestController {
    @Autowired
    @Qualifier("userLoginService")
    private UserLoginService userLoginService;

    @Autowired
    @Qualifier("newsService")
    private NewsService newsService;

    @Autowired
    @Qualifier("jtaTestService")
    private JtaTestService jtaTestService;
    @ResponseBody
    @RequestMapping("/queryUserLogin")
    public PageRusult selectUserLoginByPages(Page<UserLoginTable> page){
        List<UserLoginTable> userLoginTableList=userLoginService.queryUserLoginList(page);
        PageRusult<UserLoginTable> pageRusult =new PageRusult<UserLoginTable>(userLoginTableList);
        pageRusult.setCode(0);
        return pageRusult;
    }

    @ResponseBody
    @RequestMapping("/saveOrUpdateUserLogin")
    public Map<String,Object> saveOrUpdateUserLogin(UserLoginTable userLoginTable){
        LinkedHashMap<String,Object> resultMap=new LinkedHashMap<String,Object>();
        try {
            return userLoginService.saveOrUpdateUserLogin(userLoginTable);
        }catch (Exception e){
            resultMap.put("state","fail");
            resultMap.put("message","操作失败");
            return resultMap;
        }
    }

    @ResponseBody
    @RequestMapping("/deleteUserLogin")
    public Map<String,Object> deleteUserLogin(String loginUid){
        LinkedHashMap<String,Object> resultMap=new LinkedHashMap<String,Object>();
        try {
            if(StringUtil.isNotEmpty(loginUid)){
                userLoginService.delete(loginUid);
                resultMap.put("state","success");
                resultMap.put("message","删除用户登录信息表成功");
                return resultMap;
            }else{
                resultMap.put("state","fail");
                resultMap.put("message","删除用户登录信息表失败");
                return resultMap;
            }
        }catch (Exception e){
            resultMap.put("state","fail");
            resultMap.put("message","操作异常，删除用户登录信息表失败");
            return resultMap;
        }
    }

    @ResponseBody
    @RequestMapping("/selectNewsByPages")
    public PageRusult selectNewsByPages(Page<News> page){
        List<News> newsList=newsService.queryNewsList(page);
        PageRusult<News> pageRusult =new PageRusult<News>(newsList);
        pageRusult.setCode(0);
        return pageRusult;
    }

    @ResponseBody
    @RequestMapping("/saveOrUpdateNews")
    public Map<String,Object> saveOrUpdateNews(News news){
        LinkedHashMap<String,Object> resultMap=new LinkedHashMap<String,Object>();
        try {
            return newsService.saveOrUpdateNews(news);
        }catch (Exception e){
            resultMap.put("state","fail");
            resultMap.put("message","操作失败");
            return resultMap;
        }
    }

    @ResponseBody
    @RequestMapping("/deleteNews")
    public Map<String,Object> deleteNews(String newsId){
        LinkedHashMap<String,Object> resultMap=new LinkedHashMap<String,Object>();
        try {
            if(StringUtil.isNotEmpty(newsId)){
                newsService.delete(newsId);
                resultMap.put("state","success");
                resultMap.put("message","删除新闻表成功");
                return resultMap;
            }else{
                resultMap.put("state","fail");
                resultMap.put("message","删除新闻表失败");
                return resultMap;
            }
        }catch (Exception e){
            resultMap.put("state","fail");
            resultMap.put("message","操作异常，删除新闻表失败");
            return resultMap;
        }
    }

    @ResponseBody
    @RequestMapping("/insertToTwoDatebase")
    public Map<String,Object> insertToTwoDatebase(){
        LinkedHashMap<String,Object> resultMap=new LinkedHashMap<String,Object>();
        try {
            return jtaTestService.insertToTwoDatebaseService();
        }catch (Exception e){
            e.printStackTrace();
            resultMap.put("state","fail");
            resultMap.put("message","分布式事务同步失败");
            return resultMap;
        }
    }
}
