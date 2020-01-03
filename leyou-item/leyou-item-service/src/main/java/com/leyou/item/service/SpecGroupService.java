package com.leyou.item.service;

import com.leyou.item.mapper.SpecGroupMapper;
import com.leyou.item.pojo.SpecGroup;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/**
 * @author
 * @version 1.00
 * @time 2020/1/2 0002  下午 11:12
 */
@Service
public class SpecGroupService {

    @Autowired
    private SpecGroupMapper specGroupMapper;

    /**
     * 规格参数查询
     * @return
     */
    public List<SpecGroup> querySpecGroupById(Long  cId){

        SpecGroup record = new SpecGroup();
        record.setCid(cId);
        return specGroupMapper.select(record);

    }
}
