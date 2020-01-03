package com.leyou.item.service;

import com.leyou.item.mapper.SpecParamMapper;
import com.leyou.item.pojo.SpecParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author
 * @version 1.00
 * @time 2020/1/2 0002  下午 11:43
 */

@Service
public class SpecParamService {

    @Autowired
    private SpecParamMapper specParamMapper;

    public List<SpecParam> querySpecParamByGid(Long gid) {

        SpecParam specParam = new SpecParam();
        specParam.setGroupId(gid);
        return specParamMapper.select(specParam);

    }
}
