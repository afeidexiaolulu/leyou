package com.leyou.item.controller;

import com.leyou.common.PageResult;
import com.leyou.item.pojo.Brand;
import com.leyou.item.service.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 品牌controller
 *
 * @author
 * @version 1.00
 * @time 2019/12/27 0027  下午 3:23
 */

@Controller
@RequestMapping("/brand")
public class BrandController {

    @Autowired
    private BrandService brandService;

    /**
     * page：当前页，int
     * rows：每页大小，int
     * sortBy：排序字段，String
     * desc：是否为降序，boolean
     * key：搜索关键词，String
     *
     */
    @GetMapping("/page")
    public ResponseEntity<PageResult<Brand>> queryBrandByPage(
            @RequestParam(value = "page", defaultValue = "1") Integer page,
            @RequestParam(value = "rows", defaultValue = "5") Integer rows,
            @RequestParam(value = "sortBy", required = false) String sortBy,
            @RequestParam(value = "desc", required = false) Boolean desc,
            @RequestParam(value = "key", required = false) String key) {

        PageResult<Brand> pageResult =  brandService.queryBrandByPage(page,rows,sortBy,desc,key);
        if(CollectionUtils.isEmpty(pageResult.getItems())){
            ResponseEntity.notFound().build();
        }
        //返回正确结果
        return ResponseEntity.ok(pageResult);
    }


    /**
     * 新增品牌
     * @param brand
     * @param cids
     * @return
     */
    @PostMapping
    public ResponseEntity<Void> addBrand(Brand brand, @RequestParam("cids") List<Long> cids){

        brandService.addBrand(brand, cids);
        //返回结果
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}
