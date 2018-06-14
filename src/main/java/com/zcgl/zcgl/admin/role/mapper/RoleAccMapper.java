package com.zcgl.zcgl.admin.role.mapper;

import com.zcgl.zcgl.admin.role.model.RoleAccModel;
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
public interface RoleAccMapper {

    String table = " role_acc_table ";

    @Insert(value = "insert into " + table + " (uuid,role_id,account_id,flag) values (" +
            "#{model.uuid},#{model.roleId},#{model.accountId},#{model.flag})")
    int save(@Param("model") RoleAccModel model);

    @Delete(value = "delete from " + table + " where account_id = #{id}")
    int delByAccountId(@Param("id") String id);

    @Select(value = "select * from " + table + " where account_id = #{accountId}")
    List<RoleAccModel> findByAccountId(@Param("accountId") String accountId);

    @Select(value = "select * from " + table + " where role_id = #{roleId}")
    List<RoleAccModel> findByRoleId(@Param("roleId") String roleId);
}
