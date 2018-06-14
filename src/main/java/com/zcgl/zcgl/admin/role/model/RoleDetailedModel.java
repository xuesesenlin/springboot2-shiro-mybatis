package com.zcgl.zcgl.admin.role.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.io.Serializable;

/**
 * @author ld
 * @name 角色明细表
 * @table roleDetailed_table
 * @remarks
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class RoleDetailedModel implements Serializable {
    //    uuid
    private String uuid;
    //    权限id
    private String jurId;
    //    角色id
    private String roleId;

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getJurId() {
        return jurId;
    }

    public void setJurId(String jurId) {
        this.jurId = jurId;
    }

    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }

    public RoleDetailedModel() {
        super();
    }

    public RoleDetailedModel(String uuid, String jurId, String roleId) {
        this.uuid = uuid;
        this.jurId = jurId;
        this.roleId = roleId;
    }

    @Override
    public String toString() {
        return "RoleDetailedModel{" +
                "uuid='" + uuid + '\'' +
                ", jurId='" + jurId + '\'' +
                ", roleId='" + roleId + '\'' +
                '}';
    }
}
