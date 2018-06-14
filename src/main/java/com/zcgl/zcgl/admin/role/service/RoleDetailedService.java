package com.zcgl.zcgl.admin.role.service;

import com.zcgl.zcgl.admin.jurisdiction.model.JurisdictionModel;
import com.zcgl.zcgl.admin.role.model.RoleDetailedModel;
import com.zcgl.zcgl.util.resultJson.ResponseResult;

import java.util.List;

/**
 * @author ld
 * @name
 * @table
 * @remarks
 */
public interface RoleDetailedService {

    ResponseResult<String> setRD(RoleDetailedModel model);

    ResponseResult<List<RoleDetailedModel>> findByRoleId(String roleId);

    ResponseResult<List<JurisdictionModel>> findByRoleId2(String roleId);

    ResponseResult<List<RoleDetailedModel>> findByRoleIdAndJurId(String roleId, String jurId);

}
