package com.zcgl.zcgl.admin.role.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.io.Serializable;

/**
 * @author ld
 * @name 角色与账户的关联关系
 * @table role_acc_table
 * @remarks
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class RoleAccModel implements Serializable {

    //    uuid
    private String uuid;
    //    角色id
    private String roleId;
    //    账户id
    private String accountId;
    //    flag
    private String flag;

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }

    public RoleAccModel() {
        super();
    }

    public RoleAccModel(String uuid, String roleId, String accountId, String flag) {
        this.uuid = uuid;
        this.roleId = roleId;
        this.accountId = accountId;
        this.flag = flag;
    }

    @Override
    public String toString() {
        return "RoleAccModel{" +
                "uuid='" + uuid + '\'' +
                ", roleId='" + roleId + '\'' +
                ", accountId='" + accountId + '\'' +
                ", flag='" + flag + '\'' +
                '}';
    }
}
