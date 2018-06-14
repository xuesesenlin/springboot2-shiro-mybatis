package com.zcgl.zcgl.admin.role.mapper;

import com.zcgl.zcgl.admin.role.model.RoleDetailedModel;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author ld
 * @name
 * @table
 * @remarks
 */
public interface RoleDetailedMapper {
    String table = " role_detailed_table ";

    @Insert(value = "insert into " + table + "(uuid,jur_id,role_id) values (" +
            "#{model.uuid},#{model.jurId},#{model.roleId})")
    int save(@Param("model") RoleDetailedModel model);

    @Delete(value = "delete from " + table + " where uuid = #{id}")
    int del(@Param("id") String id);

    @Delete(value = "delete from " + table + " where role_id = #{roleId} and jur_id = #{jurId}")
    int delByJurIdAndRoleId(@Param("roleId") String roleId, @Param("jurId") String jurId);

    @Select(value = "select r.uuid,jur_id,role_id from role_detailed_table r left join jurisdiction_table j " +
            "on j.uuid = r.jur_id where role_id = #{roleId}")
    List<RoleDetailedModel> findByRoleId(@Param("roleId") String roleId);

    @Select(value = "select r.uuid,jur_id,role_id from role_detailed_table r left join jurisdiction_table j " +
            "on j.uuid = r.jur_id where role_id = #{roleId} and jur_id = #{jurId}")
    List<RoleDetailedModel> findByRoleIdAndJurId(@Param("roleId") String roleId, @Param("jurId") String jurId);

}
