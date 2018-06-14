package com.zcgl.zcgl.publics.stringFilte.service;

import com.zcgl.zcgl.publics.stringFilte.model.StringFilterModel;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author ld
 * @name
 * @table
 * @remarks
 */
@Service
@Transactional
public interface StringFilterService {

    void save(StringFilterModel model);

    void delete(String uuid);

    void update(StringFilterModel model);

//    ResponseResult<Page<StringFilterModel>> page(int pageNow, int PageSize);
}
