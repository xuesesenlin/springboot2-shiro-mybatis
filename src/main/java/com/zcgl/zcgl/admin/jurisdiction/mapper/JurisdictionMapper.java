package com.zcgl.zcgl.admin.jurisdiction.mapper;

import com.zcgl.zcgl.admin.jurisdiction.model.JurisdictionModel;
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
public interface JurisdictionMapper {

    String table = " jurisdiction_table ";

    List<JurisdictionModel> findByParents(String parents);

    List<JurisdictionModel> findBySysType(String sysType);

    List<JurisdictionModel> findByJurType(int jurType);

    List<JurisdictionModel> findByParentsAndSysTypeAndJurType(String parents,
                                                              String sysType,
                                                              long jurType);

    @Select(value = "select * from jurisdiction_table order by name")
    List<JurisdictionModel> page();

    @Select(value = "select * from jurisdiction_table where name = #{name} order by name")
    List<JurisdictionModel> pageByName(@Param("name") String name);

    @Select(value = "select j.* from role_detailed_table r left join jurisdiction_table j " +
            "on j.uuid = r.jur_id where role_id = #{roleId}")
    List<JurisdictionModel> findByRoleId(@Param("roleId") String roleId);

    @Insert({
            "insert into " + table + " (uuid,name,identification,sys_type,parents,jur_type) values (" +
                    "#{model.uuid},#{model.name},#{model.identification},#{model.sysType},#{model.parents},#{model.jurType})"
    })
    int saveAll(@Param("model") List<JurisdictionModel> model);

    @Delete({
            "delete from" + table
    })
    int deleteAll();
}
