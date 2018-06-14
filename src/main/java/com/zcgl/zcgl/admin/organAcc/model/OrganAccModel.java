package com.zcgl.zcgl.admin.organAcc.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.io.Serializable;

/**
 * @author ld
 * @name 组织机构与账户的关联关系
 * @table organ_acc_table
 * @remarks
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class OrganAccModel implements Serializable {

    //    uuid
    private String uuid;
    //    组织机构id
    private String orgId;
    //    账户id
    private String accId;

    private String flag;

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getOrgId() {
        return orgId;
    }

    public void setOrgId(String orgId) {
        this.orgId = orgId;
    }

    public String getAccId() {
        return accId;
    }

    public void setAccId(String accId) {
        this.accId = accId;
    }

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }

    public OrganAccModel() {
        super();
    }

    public OrganAccModel(String uuid, String orgId, String accId, String flag) {
        this.uuid = uuid;
        this.orgId = orgId;
        this.accId = accId;
        this.flag = flag;
    }

    @Override
    public String toString() {
        return "OrganAccModel{" +
                "uuid='" + uuid + '\'' +
                ", orgId='" + orgId + '\'' +
                ", accId='" + accId + '\'' +
                ", flag='" + flag + '\'' +
                '}';
    }
}
