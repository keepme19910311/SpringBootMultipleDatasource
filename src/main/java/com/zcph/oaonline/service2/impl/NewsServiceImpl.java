package com.zcph.oaonline.service2.impl;

import com.github.pagehelper.PageHelper;
import com.zcph.oaonline.entity.News;
import com.zcph.oaonline.mapper2.NewsMapper;
import com.zcph.oaonline.service2.NewsService;
import com.zcph.oaonline.serviceAll.impl.BaseService;
import com.zcph.oaonline.util.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.util.StringUtil;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@Service("newsService")
public class NewsServiceImpl extends BaseService<News> implements NewsService {
    @Autowired
    private NewsMapper newsMapper;
    @Override
    public List<News> queryNewsList(Page<News> page) {
        PageHelper.startPage(page.getPage(),page.getRows());
        return  selectAll();
    }

    @Override
    public Map<String, Object> saveOrUpdateNews(News news) {
        LinkedHashMap<String,Object> resultMap=new LinkedHashMap<String,Object>();
        if(news!=null){
            if(StringUtil.isNotEmpty(news.getNewsId())){//编辑
                if(StringUtil.isNotEmpty(news.getNewsTitle())){
                    updateNotNull(news);
                    resultMap.put("state","success");
                    resultMap.put("message","修改新闻表成功");
                    return resultMap;
                }else{
                    resultMap.put("state","fail");
                    resultMap.put("message","修改新闻表失败，缺少字段");
                    return resultMap;
                }
            }else{//新建
                if(StringUtil.isNotEmpty(news.getNewsTitle())){
                    news.setNewsId(UUID.randomUUID().toString().replaceAll("-",""));
                    saveNotNull(news);
                    resultMap.put("state","success");
                    resultMap.put("message","新建新闻表成功");
                    return resultMap;
                }else{
                    resultMap.put("state","fail");
                    resultMap.put("message","新建新闻表失败，缺少字段");
                    return resultMap;
                }
            }
        }else{
            resultMap.put("state","fail");
            resultMap.put("message","失败");
            return resultMap;
        }

    }
}
