package com.wzw.flower.service;

import com.wzw.flower.common.Result;

/**
 * @Description: 花的科目
 * @Author: wzw
 * @Date: 2021/4/21 15:06
 * @Version: 1.0
 */
public interface FlowerCategoryService {
    /**
     * 新增一种地区
     * @param name 地区名
     * @return Result
     */
    Result saveOneArea(String name);

    /**
     * 查询所有地区
     * @return Result
     */
    Result getAllArea();

    /**
     * 删除一种地区
     * @param areaCategoryId 地区Id
     * @return Result
     */
    Result removeOneArea(String areaCategoryId);

    /**
     * 新增一种颜色
     * @param name 颜色名
     * @return Result
     */
    Result saveOneColor(String name);

    /**
     * 查询所有颜色
     * @return Result
     */
    Result getAllColor();

    /**
     * 删除一种颜色
     * @param colorCategoryId 颜色Id
     * @return Result
     */
    Result removeOneColor(String colorCategoryId);

    /**
     * 新增一种特殊含义
     * @param name 特殊含义名
     * @return Result
     */
    Result saveOneMeaning(String name);

    /**
     * 查询所有特殊含义
     * @return Result
     */
    Result getAllMeaning();

    /**
     * 删除一种特殊含义
     * @param meaningCategoryId 特殊含义Id
     * @return Result
     */
    Result removeOneMeaning(String meaningCategoryId);


    /**
     * 新增一种科目
     * @param name 科目名
     * @return Result
     */
    Result saveOneType(String name);

    /**
     * 查询所有科目
     * @return Result
     */
    Result getAllType();

    /**
     * 删除一种科目
     * @param typeCategoryId 科目Id
     * @return Result
     */
    Result removeOneType(String typeCategoryId);
}
