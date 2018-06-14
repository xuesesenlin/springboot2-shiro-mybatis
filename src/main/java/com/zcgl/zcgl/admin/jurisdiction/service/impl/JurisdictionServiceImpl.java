package com.zcgl.zcgl.admin.jurisdiction.service.impl;

import com.zcgl.zcgl.admin.jurisdiction.mapper.JurisdictionMapper;
import com.zcgl.zcgl.admin.jurisdiction.model.JurisdictionModel;
import com.zcgl.zcgl.admin.jurisdiction.service.JurisdictionService;
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
public class JurisdictionServiceImpl implements JurisdictionService {


    @Autowired
    private JurisdictionMapper mapper;

    @Override
    public ResponseResult<JurisdictionModel> add(JurisdictionModel model) {
        ResponseResult<JurisdictionModel> result = new ResponseResult<>();
//        List<JurisdictionModel> list = mapper.findByParentsAndSysTypeAndJurType(model.getParents(),
//                model.getSysType(),
//                model.getJurType());
//        if (list.size() > 0) {
//            result.setSuccess(false);
//            result.setMessage("权限重复");
//            return result;
//        }
//        mapper.save(model);
//        result.setSuccess(true);
//        result.setMessage("操作成功");
        return result;
    }

    @Override
    public ResponseResult<JurisdictionModel> del(String id) {
        ResponseResult<JurisdictionModel> result = new ResponseResult<>();
//        mapper.delete(id);
//        result.setSuccess(true);
//        result.setMessage("操作成功");
        return result;
    }

    @Override
    public ResponseResult<JurisdictionModel> update(JurisdictionModel model) {
        ResponseResult<JurisdictionModel> result = new ResponseResult<>();
//        int i = mapper.update(model);
//        switch (i) {
//            case 0:
//                result.setSuccess(false);
//                result.setMessage("未操作任何数据");
//                return result;
//            case 1:
//                result.setSuccess(true);
//                result.setMessage("操作成功");
//                return result;
//            default:
//                result.setSuccess(false);
//                result.setMessage("操作失败");
        return result;
//        }
//        return null;
    }

    @Override
    public ResponseResult<JurisdictionModel> getById(String id) {
        ResponseResult<JurisdictionModel> result = new ResponseResult<>();
//        JurisdictionModel model = mapper.getOne(id);
//        if (model != null) {
//            result.setSuccess(true);
//            result.setMessage("操作成功");
//            result.setData(model);
//            return result;
//        } else {
//            result.setSuccess(false);
//            result.setMessage("操作失败");
        return result;
//        }
    }

    @Override
    public ResponseResult<List<JurisdictionModel>> findByParents(String parents) {
        ResponseResult<List<JurisdictionModel>> result = new ResponseResult<>();
        List<JurisdictionModel> list = mapper.findByParents(parents);
        if (list.size() > 0) {
            result.setSuccess(true);
            result.setMessage("操作成功");
            result.setData(list);
            return result;
        } else {
            result.setSuccess(false);
            result.setMessage("操作失败");
            return result;
        }
    }

    @Override
    public ResponseResult<List<JurisdictionModel>> findBySysType(String sysType) {
        ResponseResult<List<JurisdictionModel>> result = new ResponseResult<>();
        List<JurisdictionModel> list = mapper.findBySysType(sysType);
        if (list.size() > 0) {
            result.setSuccess(true);
            result.setMessage("操作成功");
            result.setData(list);
            return result;
        } else {
            result.setSuccess(false);
            result.setMessage("操作失败");
            return result;
        }
    }

    @Override
    public ResponseResult<List<JurisdictionModel>> findByJurType(int jurType) {
        ResponseResult<List<JurisdictionModel>> result = new ResponseResult<>();
        List<JurisdictionModel> list = mapper.findByJurType(jurType);
        if (list.size() > 0) {
            result.setSuccess(true);
            result.setMessage("操作成功");
            result.setData(list);
            return result;
        } else {
            result.setSuccess(false);
            result.setMessage("操作失败");
            return result;
        }
    }

    @Override
    public ResponseResult<List<JurisdictionModel>> pageByName(int pageNow, int pageSize, String name) {
        ResponseResult<List<JurisdictionModel>> result = new ResponseResult<>();
        List<JurisdictionModel> page;
        if (name == null || name.trim().equals(""))
            page = mapper.page();
        else
            page = mapper.pageByName(name);
        if (page.size() > 0) {
            result.setSuccess(true);
            result.setMessage("操作成功");
            result.setData(page);
            return result;
        } else {
            result.setSuccess(false);
            result.setMessage("未找到数据");
            result.setData(new ArrayList<>());
            return result;
        }
    }
}
