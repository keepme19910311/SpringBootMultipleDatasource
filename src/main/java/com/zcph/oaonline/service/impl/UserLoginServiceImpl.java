package com.zcph.oaonline.service.impl;

import com.github.pagehelper.PageHelper;
import com.zcph.oaonline.entity.UserLoginTable;
import com.zcph.oaonline.mapper.UserLoginTableMapper;
import com.zcph.oaonline.service.UserLoginService;
import com.zcph.oaonline.serviceAll.impl.BaseService;
import com.zcph.oaonline.util.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.util.StringUtil;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@Service("userLoginService")
public class UserLoginServiceImpl extends BaseService<UserLoginTable> implements UserLoginService {
    @Autowired
    private UserLoginTableMapper userLoginTableMapper;

    @Override
    public List<UserLoginTable> queryUserLoginList(Page<UserLoginTable> page) {
        PageHelper.startPage(page.getPage(),page.getRows());
        return  selectAll();
    }

    @Override
    public Map<String, Object> saveOrUpdateUserLogin(UserLoginTable userLoginTable) {
        LinkedHashMap<String,Object> resultMap=new LinkedHashMap<String,Object>();
        if(userLoginTable!=null){
            if(StringUtil.isNotEmpty(userLoginTable.getLoginUid())){//编辑
                if(StringUtil.isNotEmpty(userLoginTable.getLoginName())){
                    updateNotNull(userLoginTable);
                    resultMap.put("state","success");
                    resultMap.put("message","修改用户登录信息表成功");
                    return resultMap;
                }else{
                    resultMap.put("state","fail");
                    resultMap.put("message","修改用户登录信息表失败，缺少字段");
                    return resultMap;
                }
            }else{//新建
                if(StringUtil.isNotEmpty(userLoginTable.getLoginName())){
                    userLoginTable.setLoginUid(UUID.randomUUID().toString().replaceAll("-",""));
                    saveNotNull(userLoginTable);
                    resultMap.put("state","success");
                    resultMap.put("message","新建用户登录信息表成功");
                    return resultMap;
                }else{
                    resultMap.put("state","fail");
                    resultMap.put("message","新建用户登录信息表失败，缺少字段");
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
