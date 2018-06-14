package com.zcgl.zcgl.publics.account.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.zcgl.zcgl.publics.account.mapper.AccountMapper;
import com.zcgl.zcgl.publics.account.model.AccountModel;
import com.zcgl.zcgl.publics.account.service.AccountService;
import com.zcgl.zcgl.publics.login.model.LoginModel;
import com.zcgl.zcgl.util.resultJson.ResponseResult;
import com.zcgl.zcgl.util.uuidUtil.GetUuid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ld
 * @name
 * @table
 * @remarks
 */
@Service
@Transactional
public class AccountServiceImpl implements AccountService {

    @Autowired
    private AccountMapper mapper;

    @Override
    public ResponseResult<AccountModel> add(AccountModel model) {
        AccountModel model1 = mapper.getByAccount(model.getAccount());
        if (model1 != null)
            return new ResponseResult<>(false, "账号已存在", null);
        model.setUuid(GetUuid.getUUID());
        model.setSystime(System.currentTimeMillis());
        model.setFlag("0");
        mapper.save(model);
        return new ResponseResult<>(true, "成功", null);
    }

    @Override
    public ResponseResult<AccountModel> del(String uuid) {
        mapper.delete(uuid);
        return new ResponseResult<>(true, "成功", null);
    }

    @Override
    public ResponseResult<AccountModel> updatePWD(LoginModel model) {
        mapper.updatePWD(model.getUsername(), model.getPassword());
        return new ResponseResult<>(true, "成功", null);
    }

    @Override
    public ResponseResult<AccountModel> getByAccount(String account) {
        AccountModel model = mapper.getByAccount(account);
        if (model != null)
            return new ResponseResult<>(true, "成功", model);
        else
            return new ResponseResult<>(false, "未能查询到记录", null);
    }

    @Override
    public ResponseResult<AccountModel> getByAccountAndTypes(String account, String types) {
        AccountModel model = mapper.getByAccountAndTypes(account, types);
        if (model != null)
            return new ResponseResult<>(true, "成功", model);
        else
            return new ResponseResult<>(false, "未能查询到记录", null);
    }

    @Override
    public ResponseResult<Page<AccountModel>> page(int pageNow, int pageSize) {
        PageHelper.startPage(pageNow, pageSize);
        Page<AccountModel> page = mapper.page();
        if (page.size() > 0)
            return new ResponseResult<>(true, "成功", page);
        else
            return new ResponseResult<>(false, "未能查询到记录", null);
    }

    @Override
    public ResponseResult<List<AccountModel>> pageByAccount(int pageNow, int pageSize, String account) {
        List<AccountModel> page = mapper.pageByAccount(account);
        if (page.size() > 0)
            return new ResponseResult<>(true, "成功", page);
        else
            return new ResponseResult<>(false, "未能查询到记录", null);
    }

    @Override
    public ResponseResult<List<AccountModel>> find() {
        List<AccountModel> list = mapper.find();
        if (list.size() > 0)
            return new ResponseResult<>(true, "成功", list);
        else
            return new ResponseResult<>(false, "未能查询到记录", new ArrayList<>());
    }
}
