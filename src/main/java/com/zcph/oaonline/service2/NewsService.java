package com.zcph.oaonline.service2;

import com.zcph.oaonline.entity.News;
import com.zcph.oaonline.serviceAll.IService;
import com.zcph.oaonline.util.Page;

import java.util.List;
import java.util.Map;

public interface NewsService extends IService<News> {
    /**
     * 根据传入分页参数查询
     * @param page
     * @return
     */
    public List<News> queryNewsList(Page<News> page);
    /**
     * 保存或更新
     * @param news
     * @return
     */
    public Map<String,Object> saveOrUpdateNews(News news);
}
