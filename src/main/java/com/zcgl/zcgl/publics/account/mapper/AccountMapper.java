package com.zcgl.zcgl.publics.account.mapper;

import com.github.pagehelper.Page;
import com.zcgl.zcgl.publics.account.model.AccountModel;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author ld
 * @name
 * @table
 * @remarks
 */
public interface AccountMapper {

    String table = " account_table ";

    @Insert({
            "insert into " + table + " (uuid,account,password,types,systime,flag) values (" +
                    "#{model.uuid},#{model.account},#{model.password},#{model.types},#{model.systime},#{model.flag})"
    })
    int save(@Param("model") AccountModel model);

    @Delete({
            "delete " + table + " where uuid = #{uuid}"
    })
    int delete(@Param("uuid") String uuid);

    @Select(value = "select * from " + table + " where account = #{account}")
    AccountModel getByAccount(@Param("account") String account);

    @Select(value = "update " + table + " set password = #{password} where account = #{account}")
    int updatePWD(@Param("account") String account, @Param("password") String password);

    @Select(value = "select * from " + table + " where account = #{account} and types = #{types}")
    AccountModel getByAccountAndTypes(@Param("account") String account, @Param("types") String types);

    @Select(value = "select * from " + table + " where types = 'user'")
    List<AccountModel> find();

    @Select(value = " SELECT"
            + " 	a.uuid,"
            + " 	a.account,"
            + " 	'' AS PASSWORD,"
            + " 	a.flag,"
            + " 	("
            + " 		CASE"
            + " 		WHEN a.types = 'superAdmin' THEN"
            + " 			'超级管理员'"
            + " 		ELSE"
            + " 			("
            + " 				CASE"
            + " 				WHEN a.types = 'admin' THEN"
            + " 					'管理员'"
            + " 				ELSE"
            + " ("
            + " 	CASE"
            + " 	WHEN a.types = 'user' THEN"
            + " 		'普通用户'"
            + " 	ELSE"
            + " 		'普通用户'"
            + " 	END"
            + " )"
            + " 				END"
            + " 			)"
            + " 		END"
            + " 	) AS types,"
            + " 	a.systime"
            + " FROM"
            + " 	account_table a"
            + " WHERE"
            + " 	a.flag = '0'"
            + " ORDER BY a.account")
    Page<AccountModel> page();

    @Select(value = "select * from " + table + " where account = #{account}")
    List<AccountModel> pageByAccount(@Param("account") String account);

    @Select(value = "select * from account_table where uuid NOT in (" +
            "select acc_id from organ_acc_table where flag = '0') and types = 'user' ORDER BY account")
    List<AccountModel> findByNotOrgan();
}
