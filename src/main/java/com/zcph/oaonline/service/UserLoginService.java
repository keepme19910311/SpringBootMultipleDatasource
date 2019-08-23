package com.zcph.oaonline.service;

import com.zcph.oaonline.entity.UserLoginTable;
import com.zcph.oaonline.serviceAll.IService;
import com.zcph.oaonline.util.Page;

import java.util.List;
import java.util.Map;

public interface UserLoginService extends IService<UserLoginTable> {
    /**
     * 根据传入分页参数查询
     * @param page
     * @return
     */
    public List<UserLoginTable> queryUserLoginList(Page<UserLoginTable> page);

    /**
     * 保存或更新
     * @param userLoginTable
     * @return
     */
    public Map<String,Object> saveOrUpdateUserLogin(UserLoginTable userLoginTable);
}
