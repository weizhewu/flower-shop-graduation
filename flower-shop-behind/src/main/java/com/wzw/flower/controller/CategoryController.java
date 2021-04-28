package com.wzw.flower.controller;

import com.sun.org.apache.regexp.internal.RE;
import com.wzw.flower.common.Result;
import com.wzw.flower.service.CategoryService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @Description:
 * @Author: wzw
 * @Date: 2021/4/23 14:19
 * @Version: 1.0
 */
@RequestMapping("category/")
@RestController
public class CategoryController {

    @Resource
    private CategoryService categoryService;

    @PostMapping("save")
    public Result saveOne(@RequestParam String typeName,@RequestParam String name){
        return categoryService.saveOneByTypeAndName(typeName, name);
    }

    @GetMapping("getCategories")
    public Result getAll(@RequestParam String typeName) {
        return categoryService.getCategoryByType(typeName);
    }

    @PostMapping("remove")
    public Result removeOne(@RequestParam String typeName,@RequestParam String categoryId){
        return categoryService.delCategoryByTypeAndId(typeName, categoryId);
    }
}
