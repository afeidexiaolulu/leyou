package com.leyou.item.controller;

import com.leyou.item.pojo.SpecGroup;
import com.leyou.item.service.SpecGroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @author
 * @version 1.00
 * @time 2020/1/2 0002  下午 11:17
 */

@Controller
@RequestMapping("/spec")
public class SpecGroupController {

    @Autowired
    private SpecGroupService specGroupService;

    @GetMapping("/groups/{cId}")
    @ResponseBody
    public ResponseEntity<List<SpecGroup>> querySpecGroupById(@PathVariable("cId") Long cId){

        List<SpecGroup> specGroups =  specGroupService.querySpecGroupById(cId);

        if(CollectionUtils.isEmpty(specGroups)){
            //返回没有找到结果
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(specGroups);

    }
}
