package com.zcgl.zcgl.admin.role.service;

import com.zcgl.zcgl.admin.role.model.RoleModel;
import com.zcgl.zcgl.util.resultJson.ResponseResult;

import java.util.List;

/**
 * @author ld
 * @name
 * @table
 * @remarks
 */
public interface RoleService {

    ResponseResult<RoleModel> add(RoleModel model);

    ResponseResult<RoleModel> del(String id);

    ResponseResult<RoleModel> update(RoleModel model);

    ResponseResult<List<RoleModel>> pageByName(int pageNow, int pageSize, String seach);
}
