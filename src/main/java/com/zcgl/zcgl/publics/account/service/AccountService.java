package com.zcgl.zcgl.publics.account.service;

import com.github.pagehelper.Page;
import com.zcgl.zcgl.publics.account.model.AccountModel;
import com.zcgl.zcgl.publics.login.model.LoginModel;
import com.zcgl.zcgl.util.resultJson.ResponseResult;

import java.util.List;

/**
 * @author ld
 * @name
 * @table
 * @remarks
 */
public interface AccountService {

    /**
     * 新增账户
     *
     * @param model AccountModel
     * @return ResponseResult<AccountModel>
     */
    ResponseResult<AccountModel> add(AccountModel model);

    /**
     * 根据uuid删除账户
     *
     * @param uuid String
     * @return ResponseResult<AccountModel>
     */
    ResponseResult<AccountModel> del(String uuid);

    /**
     * 根据账户修改密码
     *
     * @param model AccountModel
     * @return ResponseResult<AccountModel>
     */
    ResponseResult<AccountModel> updatePWD(LoginModel model);

    /**
     * 根据账户获取单体bean
     *
     * @param account String
     * @return ResponseResult<AccountModel>
     */
    ResponseResult<AccountModel> getByAccount(String account);

    /**
     * 根据账户和类型获取单体bean
     *
     * @param account String
     * @param types   String
     * @return ResponseResult<AccountModel>
     */
    ResponseResult<AccountModel> getByAccountAndTypes(String account,
                                                      String types);

    ResponseResult<List<AccountModel>> find();

    /**
     * 无条件分页查询bean
     *
     * @return ResponseResult<PageAccountModel>>
     */
    ResponseResult<List<AccountModel>> pageByAccount(int pageNow, int pageSize, String account);

    ResponseResult<Page<AccountModel>> page(int pageNow, int pageSize);
}
