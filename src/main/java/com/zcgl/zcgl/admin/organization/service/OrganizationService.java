package com.zcgl.zcgl.admin.organization.service;

import com.zcgl.zcgl.admin.organization.model.OrganizationModel;
import com.zcgl.zcgl.util.resultJson.ResponseResult;

import java.util.List;

/**
 * @author ld
 * @name
 * @table
 * @remarks
 */
public interface OrganizationService {

    ResponseResult<OrganizationModel> add(OrganizationModel model);

    ResponseResult<OrganizationModel> del(String id);

    ResponseResult<OrganizationModel> update(OrganizationModel model);

    ResponseResult<List<OrganizationModel>> findByParents(String parents);
}
