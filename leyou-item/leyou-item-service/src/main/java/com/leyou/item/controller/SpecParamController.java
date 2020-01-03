package com.leyou.item.controller;


import com.leyou.item.pojo.SpecParam;
import com.leyou.item.service.SpecParamService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @author
 * @version 1.00
 * @time 2020/1/2 0002  下午 11:44
 */

@Controller
@RequestMapping("/spec")
public class SpecParamController {

    @Autowired
    private SpecParamService specParamService;

    @GetMapping("/params")
    @ResponseBody
    public ResponseEntity<List<SpecParam>> querySpecParamByGid(@Param("gid") Long gid) {

        List<SpecParam> specParams = specParamService.querySpecParamByGid(gid);

        if (CollectionUtils.isEmpty(specParams)) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(specParams);

    }

}
