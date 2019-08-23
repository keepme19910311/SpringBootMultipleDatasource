package com.zcph.oaonline.entity;

import java.util.Date;
import javax.persistence.*;

@Table(name = "user_login_table")
public class UserLoginTable {
    /**
     * 登陆账户主键
     */
    @Id
    @Column(name = "login_uid")
    private String loginUid;

    /**
     * 登陆名
     */
    @Column(name = "login_name")
    private String loginName;

    /**
     * 登陆密码
     */
    @Column(name = "login_password")
    private String loginPassword;

    /**
     * 备注
     */
    private String remarks;

    /**
     * 状态1可用0禁用
     */
    private Integer status;

    /**
     * 上次更新时间
     */
    @Column(name = "update_date")
    private Date updateDate;

    /**
     * 创建时间
     */
    @Column(name = "create_date")
    private Date createDate;

    /**
     * 获取登陆账户主键
     *
     * @return login_uid - 登陆账户主键
     */
    public String getLoginUid() {
        return loginUid;
    }

    /**
     * 设置登陆账户主键
     *
     * @param loginUid 登陆账户主键
     */
    public void setLoginUid(String loginUid) {
        this.loginUid = loginUid == null ? null : loginUid.trim();
    }

    /**
     * 获取登陆名
     *
     * @return login_name - 登陆名
     */
    public String getLoginName() {
        return loginName;
    }

    /**
     * 设置登陆名
     *
     * @param loginName 登陆名
     */
    public void setLoginName(String loginName) {
        this.loginName = loginName == null ? null : loginName.trim();
    }

    /**
     * 获取登陆密码
     *
     * @return login_password - 登陆密码
     */
    public String getLoginPassword() {
        return loginPassword;
    }

    /**
     * 设置登陆密码
     *
     * @param loginPassword 登陆密码
     */
    public void setLoginPassword(String loginPassword) {
        this.loginPassword = loginPassword == null ? null : loginPassword.trim();
    }

    /**
     * 获取备注
     *
     * @return remarks - 备注
     */
    public String getRemarks() {
        return remarks;
    }

    /**
     * 设置备注
     *
     * @param remarks 备注
     */
    public void setRemarks(String remarks) {
        this.remarks = remarks == null ? null : remarks.trim();
    }

    /**
     * 获取状态1可用0禁用
     *
     * @return status - 状态1可用0禁用
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * 设置状态1可用0禁用
     *
     * @param status 状态1可用0禁用
     */
    public void setStatus(Integer status) {
        this.status = status;
    }

    /**
     * 获取上次更新时间
     *
     * @return update_date - 上次更新时间
     */
    public Date getUpdateDate() {
        return updateDate;
    }

    /**
     * 设置上次更新时间
     *
     * @param updateDate 上次更新时间
     */
    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    /**
     * 获取创建时间
     *
     * @return create_date - 创建时间
     */
    public Date getCreateDate() {
        return createDate;
    }

    /**
     * 设置创建时间
     *
     * @param createDate 创建时间
     */
    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }
}