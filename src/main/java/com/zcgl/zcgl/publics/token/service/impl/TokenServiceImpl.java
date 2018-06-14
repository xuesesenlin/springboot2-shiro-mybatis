package com.zcgl.zcgl.publics.token.service.impl;

import com.zcgl.zcgl.publics.account.model.AccountModel;
import com.zcgl.zcgl.publics.token.mapper.TokenMapper;
import com.zcgl.zcgl.publics.token.model.TokenModel;
import com.zcgl.zcgl.publics.token.service.TokenService;
import com.zcgl.zcgl.util.jdbc.JDBC;
import com.zcgl.zcgl.util.resultJson.ResponseResult;
import com.zcgl.zcgl.util.uuidUtil.GetUuid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Slf4j
@Service
@Transactional
public class TokenServiceImpl implements TokenService {

    @Autowired
    private TokenMapper mapper;

    @Override
    public ResponseResult<TokenModel> add(TokenModel model) {
        ResponseResult<TokenModel> result = new ResponseResult<>();
        model.setUuid(GetUuid.getUUID());
        mapper.save(model);
        result.setSuccess(true);
        result.setData(model);
        return result;
    }

    @Override
    public ResponseResult<TokenModel> add2(TokenModel model) {
        ResponseResult<TokenModel> result = new ResponseResult<>();
        JDBC jdbc = new JDBC();
        int i = jdbc.update2("insert into token_table (uuid,account,token,end_time,is_use)" +
                " values (?,?,?,?,?)", GetUuid.getUUID(), model.getAccount(), model.getToken(), model.getEndTimes(), model.getIsUse());
        if (i > 0) {
            result.setSuccess(true);
        } else
            result.setSuccess(false);
        return result;
    }

    @Override
    public ResponseResult updateToken(String token) {
        ResponseResult<TokenModel> result = new ResponseResult<>();
        mapper.updateToken(token);
        result.setSuccess(true);
        result.setData(null);
        return result;
    }

    @Override
    public ResponseResult updateToken2(String token) {
        ResponseResult<TokenModel> result = new ResponseResult<>();
        JDBC jdbc = new JDBC();
        int i = jdbc.update("update token_table set is_use = 'Y' where token = ?", token);
        if (i > 0) {
            result.setSuccess(true);
        } else
            result.setSuccess(false);
        return result;
    }

    @Override
    public ResponseResult getByToken(String token) {
        ResponseResult<TokenModel> result = new ResponseResult<>();
        TokenModel model = mapper.getByToken(token);
        if (model != null) {
            result.setSuccess(true);
            result.setData(model);
        } else {
            result.setSuccess(false);
            result.setData(null);
        }
        return result;
    }

    @Override
    public ResponseResult<TokenModel> getByToken2(String token, String token_user) {
        ResponseResult<TokenModel> result = new ResponseResult<>();
        JDBC jdbc = new JDBC();
        List<TokenModel> models = jdbc.queryToken("select uuid,account,token,end_time endTimes,is_use isUse " +
                "from token_table where token=? and account = ? ORDER BY end_time desc LIMIT 1", token, token_user);
        if (models.size() > 0) {
            result.setSuccess(true);
            result.setData(models.get(0));
        } else
            result.setSuccess(false);
        return result;
    }

    @Override
    public ResponseResult<AccountModel> getByToken3(String token) {
        ResponseResult<AccountModel> result = new ResponseResult<>();
        JDBC jdbc = new JDBC();
        List<AccountModel> models = jdbc.queryToken2("select account,password,types from account_table a left join token_table t " +
                "on t.account = a.account where t.token = ?", token);
        if (models.size() > 0) {
            result.setSuccess(true);
            result.setData(models.get(0));
        } else
            result.setSuccess(false);
        return result;
    }
}
