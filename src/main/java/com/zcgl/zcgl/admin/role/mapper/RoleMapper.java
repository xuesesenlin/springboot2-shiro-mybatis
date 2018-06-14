package com.zcgl.zcgl.admin.role.mapper;

import com.zcgl.zcgl.admin.role.model.RoleModel;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @author ld
 * @name
 * @table
 * @remarks
 */
public interface RoleMapper {
    String table = " role_table ";

    @Insert(value = "insert into " + table + " (uuid,name) values (#{model.uuid},#{model.name})")
    int save(@Param("model") RoleModel model);

    @Delete(value = "delete " + table + " where uuid = #{uuid}")
    int delete(@Param("uuid") String uuid);

    @Update(value = "update " + table + " set name = #{name} where uuid = #{uuid}")
    int update(@Param("name") String name, @Param("uuid") String uuid);

    @Select(value = "select * from " + table)
    List<RoleModel> page();

    @Select(value = "select * from " + table + " where name = #{seach}")
    List<RoleModel> pageByName(@Param("seach") String seach);
}
