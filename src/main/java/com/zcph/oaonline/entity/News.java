package com.zcph.oaonline.entity;

import java.util.Date;
import javax.persistence.*;

public class News {
    /**
     * 主键
     */
    @Id
    @Column(name = "news_id")
    private String newsId;

    /**
     * 类型字典
     */
    @Column(name = "news_type")
    private Integer newsType;

    /**
     * 标题
     */
    @Column(name = "news_title")
    private String newsTitle;

    /**
     * 简介
     */
    @Column(name = "news_introduction")
    private String newsIntroduction;

    /**
     * 封面图片
     */
    @Column(name = "news_cover")
    private String newsCover;

    /**
     * 内容
     */
    @Column(name = "news_content")
    private String newsContent;

    /**
     * 展示发布时间
     */
    @Column(name = "news_date")
    private Date newsDate;

    /**
     * 阅读次数
     */
    @Column(name = "news_read_times")
    private Integer newsReadTimes;

    /**
     * 创建时间
     */
    @Column(name = "news_create")
    private Date newsCreate;

    /**
     * 更新时间
     */
    @Column(name = "news_update")
    private Date newsUpdate;

    /**
     * 展示状态 0未展示 1展示中
     */
    @Column(name = "news_show_status")
    private Integer newsShowStatus;

    /**
     * 状态 0已删除 1 正常 2未保存
     */
    @Column(name = "news_status")
    private Integer newsStatus;

    /**
     * 备用varchar
     */
    @Column(name = "news_spare_varchar")
    private String newsSpareVarchar;

    /**
     * 备用date
     */
    @Column(name = "news_spare_date")
    private Date newsSpareDate;

    /**
     * 备用int
     */
    @Column(name = "news_spare_int")
    private Integer newsSpareInt;

    /**
     * 获取主键
     *
     * @return news_id - 主键
     */
    public String getNewsId() {
        return newsId;
    }

    /**
     * 设置主键
     *
     * @param newsId 主键
     */
    public void setNewsId(String newsId) {
        this.newsId = newsId == null ? null : newsId.trim();
    }

    /**
     * 获取类型字典
     *
     * @return news_type - 类型字典
     */
    public Integer getNewsType() {
        return newsType;
    }

    /**
     * 设置类型字典
     *
     * @param newsType 类型字典
     */
    public void setNewsType(Integer newsType) {
        this.newsType = newsType;
    }

    /**
     * 获取标题
     *
     * @return news_title - 标题
     */
    public String getNewsTitle() {
        return newsTitle;
    }

    /**
     * 设置标题
     *
     * @param newsTitle 标题
     */
    public void setNewsTitle(String newsTitle) {
        this.newsTitle = newsTitle == null ? null : newsTitle.trim();
    }

    /**
     * 获取简介
     *
     * @return news_introduction - 简介
     */
    public String getNewsIntroduction() {
        return newsIntroduction;
    }

    /**
     * 设置简介
     *
     * @param newsIntroduction 简介
     */
    public void setNewsIntroduction(String newsIntroduction) {
        this.newsIntroduction = newsIntroduction == null ? null : newsIntroduction.trim();
    }

    /**
     * 获取封面图片
     *
     * @return news_cover - 封面图片
     */
    public String getNewsCover() {
        return newsCover;
    }

    /**
     * 设置封面图片
     *
     * @param newsCover 封面图片
     */
    public void setNewsCover(String newsCover) {
        this.newsCover = newsCover == null ? null : newsCover.trim();
    }

    /**
     * 获取内容
     *
     * @return news_content - 内容
     */
    public String getNewsContent() {
        return newsContent;
    }

    /**
     * 设置内容
     *
     * @param newsContent 内容
     */
    public void setNewsContent(String newsContent) {
        this.newsContent = newsContent == null ? null : newsContent.trim();
    }

    /**
     * 获取展示发布时间
     *
     * @return news_date - 展示发布时间
     */
    public Date getNewsDate() {
        return newsDate;
    }

    /**
     * 设置展示发布时间
     *
     * @param newsDate 展示发布时间
     */
    public void setNewsDate(Date newsDate) {
        this.newsDate = newsDate;
    }

    /**
     * 获取阅读次数
     *
     * @return news_read_times - 阅读次数
     */
    public Integer getNewsReadTimes() {
        return newsReadTimes;
    }

    /**
     * 设置阅读次数
     *
     * @param newsReadTimes 阅读次数
     */
    public void setNewsReadTimes(Integer newsReadTimes) {
        this.newsReadTimes = newsReadTimes;
    }

    /**
     * 获取创建时间
     *
     * @return news_create - 创建时间
     */
    public Date getNewsCreate() {
        return newsCreate;
    }

    /**
     * 设置创建时间
     *
     * @param newsCreate 创建时间
     */
    public void setNewsCreate(Date newsCreate) {
        this.newsCreate = newsCreate;
    }

    /**
     * 获取更新时间
     *
     * @return news_update - 更新时间
     */
    public Date getNewsUpdate() {
        return newsUpdate;
    }

    /**
     * 设置更新时间
     *
     * @param newsUpdate 更新时间
     */
    public void setNewsUpdate(Date newsUpdate) {
        this.newsUpdate = newsUpdate;
    }

    /**
     * 获取展示状态 0未展示 1展示中
     *
     * @return news_show_status - 展示状态 0未展示 1展示中
     */
    public Integer getNewsShowStatus() {
        return newsShowStatus;
    }

    /**
     * 设置展示状态 0未展示 1展示中
     *
     * @param newsShowStatus 展示状态 0未展示 1展示中
     */
    public void setNewsShowStatus(Integer newsShowStatus) {
        this.newsShowStatus = newsShowStatus;
    }

    /**
     * 获取状态 0已删除 1 正常 2未保存
     *
     * @return news_status - 状态 0已删除 1 正常 2未保存
     */
    public Integer getNewsStatus() {
        return newsStatus;
    }

    /**
     * 设置状态 0已删除 1 正常 2未保存
     *
     * @param newsStatus 状态 0已删除 1 正常 2未保存
     */
    public void setNewsStatus(Integer newsStatus) {
        this.newsStatus = newsStatus;
    }

    /**
     * 获取备用varchar
     *
     * @return news_spare_varchar - 备用varchar
     */
    public String getNewsSpareVarchar() {
        return newsSpareVarchar;
    }

    /**
     * 设置备用varchar
     *
     * @param newsSpareVarchar 备用varchar
     */
    public void setNewsSpareVarchar(String newsSpareVarchar) {
        this.newsSpareVarchar = newsSpareVarchar == null ? null : newsSpareVarchar.trim();
    }

    /**
     * 获取备用date
     *
     * @return news_spare_date - 备用date
     */
    public Date getNewsSpareDate() {
        return newsSpareDate;
    }

    /**
     * 设置备用date
     *
     * @param newsSpareDate 备用date
     */
    public void setNewsSpareDate(Date newsSpareDate) {
        this.newsSpareDate = newsSpareDate;
    }

    /**
     * 获取备用int
     *
     * @return news_spare_int - 备用int
     */
    public Integer getNewsSpareInt() {
        return newsSpareInt;
    }

    /**
     * 设置备用int
     *
     * @param newsSpareInt 备用int
     */
    public void setNewsSpareInt(Integer newsSpareInt) {
        this.newsSpareInt = newsSpareInt;
    }
}