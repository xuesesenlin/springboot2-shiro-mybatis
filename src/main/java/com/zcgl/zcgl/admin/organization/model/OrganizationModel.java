package com.zcgl.zcgl.admin.organization.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.io.Serializable;

/**
 * @author ld
 * @name 组织机构
 * @table organization_table
 * @remarks
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class OrganizationModel implements Serializable {

    //    uuid
    private String uuid;
    //    结构名称
    @NotBlank(message = "名称不能为空")
    @Size(min = 2, max = 16, message = "名称长度在2-16之间")
    private String name;
    //    机构父级
    @NotBlank(message = "所属父级不能为空")
    private String parents;

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

    public String getParents() {
        return parents;
    }

    public void setParents(String parents) {
        this.parents = parents;
    }

    public OrganizationModel() {
        super();
    }

    public OrganizationModel(String uuid, String name, String parents) {
        this.uuid = uuid;
        this.name = name;
        this.parents = parents;
    }

    @Override
    public String toString() {
        return "OrganizationModel{" +
                "uuid='" + uuid + '\'' +
                ", name='" + name + '\'' +
                ", parents='" + parents + '\'' +
                '}';
    }
}
