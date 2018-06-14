package com.zcgl.zcgl.publics.token.mapper;

import com.zcgl.zcgl.publics.token.model.TokenModel;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

/**
 * @author ld
 * @name
 * @table
 * @remarks
 */
public interface TokenMapper {

    @Insert(value = "insert into token_table (uuid,account,token,end_time,is_use) values (" +
            "#{model.uuid},#{model.account},#{model.token},#{model.endTimes},#{model.isUser})")
    int save(@Param("model") TokenModel model);

    @Update(value = "update token_table set is_use = 'Y' where token = #{token}")
    int updateToken(@Param("token") String token);

    @Select(value = "select uuid,account,token,end_time,is_use from token_table " +
            "where token = #{token} ORDER BY end_time desc LIMIT 1")
    TokenModel getByToken(@Param("token") String token);
}
