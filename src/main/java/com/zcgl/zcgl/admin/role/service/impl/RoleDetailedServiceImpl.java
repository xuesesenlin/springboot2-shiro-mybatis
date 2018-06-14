package com.zcgl.zcgl.admin.role.service.impl;

import com.zcgl.zcgl.admin.jurisdiction.mapper.JurisdictionMapper;
import com.zcgl.zcgl.admin.jurisdiction.model.JurisdictionModel;
import com.zcgl.zcgl.admin.role.mapper.RoleDetailedMapper;
import com.zcgl.zcgl.admin.role.model.RoleDetailedModel;
import com.zcgl.zcgl.admin.role.service.RoleDetailedService;
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
public class RoleDetailedServiceImpl implements RoleDetailedService {

    @Autowired
    private RoleDetailedMapper mapper;
    @Autowired
    private JurisdictionMapper jurisdictionmapper;

    @Override
    public ResponseResult<String> setRD(RoleDetailedModel model) {
        ResponseResult<String> result = new ResponseResult<>();
        List<RoleDetailedModel> list = mapper.findByRoleIdAndJurId(model.getRoleId(), model.getJurId());
        if (list.size() > 0) {
            int i = mapper.delByJurIdAndRoleId(model.getRoleId(), model.getJurId());
            switch (i) {
                case 0:
                    result.setSuccess(false);
                    result.setMessage("未操作任何数据");
                    return result;
                case 1:
                    result.setSuccess(true);
                    result.setMessage("操作成功");
                    result.setData("0");
                    return result;
                default:
                    result.setSuccess(false);
                    result.setMessage("操作失败");
                    return result;
            }
        } else {
            model.setUuid(GetUuid.getUUID());
            mapper.save(model);
            result.setSuccess(true);
            result.setMessage("操作成功");
            result.setData("1");
            return result;
        }
    }

    @Override
    public ResponseResult<List<RoleDetailedModel>> findByRoleId(String roleId) {
        ResponseResult<List<RoleDetailedModel>> result = new ResponseResult<>();
        List<RoleDetailedModel> list = mapper.findByRoleId(roleId);
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
    public ResponseResult<List<JurisdictionModel>> findByRoleId2(String roleId) {
        ResponseResult<List<JurisdictionModel>> result = new ResponseResult<>();
        List<JurisdictionModel> list = jurisdictionmapper.findByRoleId(roleId);
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
    public ResponseResult<List<RoleDetailedModel>> findByRoleIdAndJurId(String roleId, String jurId) {
        ResponseResult<List<RoleDetailedModel>> result = new ResponseResult<>();
        List<RoleDetailedModel> list = mapper.findByRoleIdAndJurId(roleId, jurId);
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
