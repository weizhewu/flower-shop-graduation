package com.wzw.flower.service.impl;

import com.wzw.flower.common.Result;
import com.wzw.flower.service.CategoryService;
import com.wzw.flower.service.FlowerCategoryService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @Description:
 * @Author: wzw
 * @Date: 2021/4/23 14:04
 * @Version: 1.0
 */
@Service
public class CategoryServiceImpl implements CategoryService {

    private final String AREA = "area";
    private final String COLOR = "color";
    private final String MEANING = "meaning";

    @Resource
    private FlowerCategoryService service;

    @Override
    public Result saveOneByTypeAndName(String typeName, String name) {
        if (AREA.equals(typeName)){
            return service.saveOneArea(name);
        }
        if (COLOR.equals(typeName)){
            return service.saveOneColor(name);
        }
        if (MEANING.equals(typeName)){
            return service.saveOneMeaning(name);
        }
        return service.saveOneType(name);
    }

    @Override
    public Result getCategoryByType(String typeName) {
        if (AREA.equals(typeName)){
            return service.getAllArea();
        }
        if (COLOR.equals(typeName)){
            return service.getAllColor();
        }
        if (MEANING.equals(typeName)){
            return service.getAllMeaning();
        }
        return service.getAllType();
    }

    @Override
    public Result delCategoryByTypeAndId(String typeName, String categoryId) {
        if (AREA.equals(typeName)){
            return service.removeOneArea(categoryId);
        }
        if (COLOR.equals(typeName)){
            return service.removeOneColor(categoryId);
        }
        if (MEANING.equals(typeName)){
            return service.removeOneMeaning(categoryId);
        }
        return service.removeOneType(categoryId);
    }
}
