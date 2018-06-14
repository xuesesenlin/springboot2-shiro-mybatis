package com.zcgl.zcgl.admin.organization.mapper;

import com.zcgl.zcgl.admin.organization.model.OrganizationModel;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

/**
 * @author ld
 * @name
 * @table
 * @remarks
 */
public interface OrganizationMapper {

    String table = " organization_table ";

    @Update(value = "update " + table + " set name = ?1 where uuid = ?2")
    int update(String name, String uuid);

    @Select(value = "select * from " + table + " where parents = ?1")
    List<OrganizationModel> findByParents(String parents);
}
