package com.zcgl.zcgl.admin.role.service.impl;

import com.zcgl.zcgl.admin.role.mapper.RoleMapper;
import com.zcgl.zcgl.admin.role.model.RoleModel;
import com.zcgl.zcgl.admin.role.service.RoleService;
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
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleMapper mapper;

    @Override
    public ResponseResult<RoleModel> add(RoleModel model) {
        ResponseResult<RoleModel> result = new ResponseResult<>();
        model.setUuid(GetUuid.getUUID());
        mapper.save(model);
        result.setSuccess(true);
        result.setMessage("操作成功");
        return result;
    }

    @Override
    public ResponseResult<RoleModel> del(String id) {
        ResponseResult<RoleModel> result = new ResponseResult<>();
        mapper.delete(id);
        result.setSuccess(true);
        result.setMessage("操作成功");
        return result;
    }

    @Override
    public ResponseResult<RoleModel> update(RoleModel model) {
        ResponseResult<RoleModel> result = new ResponseResult<>();
        int i = mapper.update(model.getName(), model.getUuid());
        switch (i) {
            case 0:
                result.setSuccess(false);
                result.setMessage("未操作任何数据");
                return result;
            case 1:
                result.setSuccess(true);
                result.setMessage("操作成功");
                return result;
            default:
                result.setSuccess(false);
                result.setMessage("操作失败");
                return result;
        }
    }

    @Override
    public ResponseResult<List<RoleModel>> pageByName(int pageNow, int pageSize, String seach) {
        ResponseResult<List<RoleModel>> result = new ResponseResult<>();
        List<RoleModel> page;
        if (seach == null || seach.trim().equals(""))
            page = mapper.page();
        else
            page = mapper.pageByName(seach);
        if (page.size() > 0) {
            result.setSuccess(true);
            result.setMessage("操作成功");
            result.setData(page);
            return result;
        } else {
            result.setSuccess(false);
            result.setMessage("未获取到任何数据");
            result.setData(new ArrayList<>());
            return result;
        }
    }
}
