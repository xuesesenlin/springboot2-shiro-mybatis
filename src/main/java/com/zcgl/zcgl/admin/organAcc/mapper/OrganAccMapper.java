package com.zcgl.zcgl.admin.organAcc.mapper;

import com.zcgl.zcgl.admin.organAcc.model.OrganAccModel;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface OrganAccMapper {
    String table = " organ_acc_table ";

    @Update(value = "update " + table + " set flag = '-1' where uuid = ?1")
    int del(String id);

    @Select(value = "select * from " + table + " where acc_id = ?1 and flag = '0'")
    List<OrganAccModel> findByAccId(String accId);

    @Select(value = "select o.uuid,a.account as acc_id,o.org_id,o.flag from organ_acc_table o " +
            "left join account_table a on a.uuid = o.acc_id where o.org_id = ?1 and o.flag = '0'")
    List<OrganAccModel> findByOrganId(String organId);
}
