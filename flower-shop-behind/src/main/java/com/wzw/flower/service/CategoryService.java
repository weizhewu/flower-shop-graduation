package com.wzw.flower.service;

import com.wzw.flower.common.Result;


/**
 * @Description: 对area、color、meaning、type等接口进行统一的处理
 * @Author: wzw
 * @Date: 2021/4/23 14:00
 * @Version: 1.0
 */
public interface CategoryService {
    /**
     * 根据类别名称和Id统一删除对应数据
     * @param typeName 类别名称
     * @param name 类别名字
     * @return Result
     */
    Result saveOneByTypeAndName(String typeName,String name);
    /**
     * 根据类别名称统一获得对应数据
     * @param typeName 类别名称
     * @return Result
     */
    Result getCategoryByType(String typeName);

    /**
     * 根据类别名称和Id统一删除对应数据
     * @param typeName 类别名称
     * @param categoryId 分类主键Id
     * @return Result
     */
    Result delCategoryByTypeAndId(String typeName,String categoryId);
}