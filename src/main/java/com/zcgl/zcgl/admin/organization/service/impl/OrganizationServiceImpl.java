package com.zcgl.zcgl.admin.organization.service.impl;

import com.zcgl.zcgl.admin.organAcc.mapper.OrganAccMapper;
import com.zcgl.zcgl.admin.organization.mapper.OrganizationMapper;
import com.zcgl.zcgl.admin.organization.model.OrganizationModel;
import com.zcgl.zcgl.admin.organization.service.OrganizationService;
import com.zcgl.zcgl.util.resultJson.ResponseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author ld
 * @name
 * @table
 * @remarks
 */
@Service
@Transactional
public class OrganizationServiceImpl implements OrganizationService {
    @Autowired
    private OrganizationMapper mapper;
    @Autowired
    private OrganAccMapper organAccMapper;

    @Override
    public ResponseResult<OrganizationModel> add(OrganizationModel model) {
        ResponseResult<OrganizationModel> result = new ResponseResult<>();
//        jpa.save(model);
        result.setSuccess(true);
        result.setMessage("操作成功");
        return result;
    }

    @Override
    public ResponseResult<OrganizationModel> del(String id) {
        ResponseResult<OrganizationModel> result = new ResponseResult<>();
//        List<OrganizationModel> list = jpa.findByParents(id);
//        List<OrganAccModel> list2 = organAccJpa.findByOrganId(id);
//        if (list.size() > 0 || list2.size() > 0) {
//            result.setSuccess(false);
//            result.setMessage("请先删除下级或者人员");
//            return result;
//        }
//        jpa.delete(id);
        result.setSuccess(true);
        result.setMessage("操作成功");
        return result;
    }

    @Override
    public ResponseResult<OrganizationModel> update(OrganizationModel model) {
        ResponseResult<OrganizationModel> result = new ResponseResult<>();
//        int i = jpa.update(model.getName(), model.getUuid());
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
    }

    @Override
    public ResponseResult<List<OrganizationModel>> findByParents(String parents) {
        ResponseResult<List<OrganizationModel>> result = new ResponseResult<>();
//        List<OrganizationModel> list = jpa.findByParents(parents);
//        if (list.size() > 0) {
//            result.setSuccess(true);
//            result.setMessage("操作成功");
//            result.setData(list);
//            return result;
//        } else {
//            result.setSuccess(false);
//            result.setMessage("未获取到数据");
//            result.setData(new ArrayList<>());
        return result;
//        }
    }
}
