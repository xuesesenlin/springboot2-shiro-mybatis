package com.zcgl.zcgl.admin.organAcc.service;

import com.zcgl.zcgl.admin.organAcc.model.OrganAccModel;
import com.zcgl.zcgl.publics.account.model.AccountModel;
import com.zcgl.zcgl.util.resultJson.ResponseResult;

import java.util.List;

/**
 * @author ld
 * @name
 * @table
 * @remarks
 */
public interface OrganAccService {

    ResponseResult<OrganAccModel> add(OrganAccModel model);

    ResponseResult<OrganAccModel> del(String id);

    ResponseResult<List<OrganAccModel>> findByAccId(String accId);

    ResponseResult<List<OrganAccModel>> findByOrganId(String organId);

    ResponseResult<List<AccountModel>> findByNotOrgan();
}
