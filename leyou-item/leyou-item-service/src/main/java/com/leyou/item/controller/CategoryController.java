package com.leyou.item.controller;

import com.leyou.item.pojo.Category;
import com.leyou.item.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Collections;
import java.util.List;

/**  目录类控制器
 * @author
 * @version 1.00
 * @time 2019/12/27 0027  上午 10:05
 */

@Controller
@RequestMapping("/category")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    //目录树形查询
    @GetMapping("/list")
    public ResponseEntity<List<Category>> queryCategoriesByPid(@RequestParam("pid") Long pid){
        if(pid == null || pid.longValue() <0){
            ResponseEntity.badRequest().build();
        }
        List<Category> categories = categoryService.queryCategoriesByPid(pid);
        if(CollectionUtils.isEmpty(categories)){
            //响应404
            ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(categories);
    }

}
