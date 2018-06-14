package com.zcgl.zcgl.admin.jurisdiction.service;


import com.zcgl.zcgl.admin.jurisdiction.model.JurisdictionModel;
import com.zcgl.zcgl.util.resultJson.ResponseResult;

import java.util.List;

/**
 * @author ld
 * @name
 * @table
 * @remarks
 */
public interface JurisdictionService {

    ResponseResult<JurisdictionModel> add(JurisdictionModel model);

    ResponseResult<JurisdictionModel> del(String id);

    ResponseResult<JurisdictionModel> update(JurisdictionModel model);

    ResponseResult<JurisdictionModel> getById(String id);

    ResponseResult<List<JurisdictionModel>> findByParents(String parents);

    ResponseResult<List<JurisdictionModel>> findBySysType(String sysType);

    ResponseResult<List<JurisdictionModel>> findByJurType(int jurType);

    ResponseResult<List<JurisdictionModel>> pageByName(int pageNow, int pageSize, String name);
}
