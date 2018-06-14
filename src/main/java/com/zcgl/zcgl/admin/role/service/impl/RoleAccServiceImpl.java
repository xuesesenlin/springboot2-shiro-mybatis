package com.zcgl.zcgl.admin.role.service.impl;

import com.zcgl.zcgl.admin.role.mapper.RoleAccMapper;
import com.zcgl.zcgl.admin.role.model.RoleAccModel;
import com.zcgl.zcgl.admin.role.service.RoleAccService;
import com.zcgl.zcgl.util.resultJson.ResponseResult;
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
public class RoleAccServiceImpl implements RoleAccService {

    @Autowired
    private RoleAccMapper mapper;

    @Override
    public ResponseResult<String> setRD(RoleAccModel model) {
        ResponseResult<String> result = new ResponseResult<>();
        List<RoleAccModel> list = mapper.findByAccountId(model.getAccountId());
        if (list.size() > 0) {
            int i = mapper.delByAccountId(model.getAccountId());
            switch (i) {
                case 0:
                    result.setSuccess(false);
                    result.setMessage("未操作任何数据");
                    return result;
                case 1:
                    if (list.get(0).getAccountId().equals(model.getAccountId())
                            && list.get(0).getRoleId().equals(model.getRoleId())) {
                        result.setSuccess(true);
                        result.setMessage("操作成功");
                        result.setData("0");
                        return result;
                    } else
                        break;
                default:
                    result.setSuccess(false);
                    result.setMessage("操作失败");
                    return result;
            }
        }
        mapper.save(model);
        result.setSuccess(true);
        result.setMessage("操作成功");
        result.setData("1");
        return result;
    }

    @Override
    public ResponseResult<List<RoleAccModel>> findByAccountId(String accountId) {
        ResponseResult<List<RoleAccModel>> result = new ResponseResult<>();
        List<RoleAccModel> list = mapper.findByAccountId(accountId);
        if (list.size() > 0) {
            result.setSuccess(true);
            result.setMessage("操作成功");
            result.setData(list);
            return result;
        } else {
            result.setSuccess(false);
            result.setMessage("未获取到数据");
            result.setData(new ArrayList<>());
            return result;
        }
    }

    @Override
    public ResponseResult<List<RoleAccModel>> findByRoleId(String roleId) {
        ResponseResult<List<RoleAccModel>> result = new ResponseResult<>();
        List<RoleAccModel> list = mapper.findByRoleId(roleId);
        if (list.size() > 0) {
            result.setSuccess(true);
            result.setMessage("操作成功");
            result.setData(list);
            return result;
        } else {
            result.setSuccess(false);
            result.setMessage("未获取到数据");
            result.setData(new ArrayList<>());
            return result;
        }
    }
}
