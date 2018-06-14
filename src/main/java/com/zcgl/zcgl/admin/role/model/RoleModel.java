package com.zcgl.zcgl.admin.role.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.io.Serializable;

/**
 * @author ld
 * @name 角色
 * @table role_table
 * @remarks
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class RoleModel implements Serializable {

    //    uuid
    private String uuid;
    //    角色名称
    private String name;

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public RoleModel() {
        super();
    }

    public RoleModel(String uuid, String name) {
        this.uuid = uuid;
        this.name = name;
    }

    @Override
    public String toString() {
        return "RoleModel{" +
                "uuid='" + uuid + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
