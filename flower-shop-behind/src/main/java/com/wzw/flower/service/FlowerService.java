package com.wzw.flower.service;

import com.wzw.flower.common.Result;
import com.wzw.flower.model.Flower;

/**
 * 与花相关的service
 * @author wzw
 */
public interface FlowerService {
    /**
     * 新增一种花
     * @param flower flower实体类
     * @return ResponseResult
     */
    Result saveOne(Flower flower);

    /**
     * 查询特定的花
     * @param flowerId 花主键
     * @return Result
     */
    Result getOneByFlowerId(String flowerId);

    /**
     * 查询所有的花
     * @return ResponseResult
     */
    Result getAll();

    /**
     * 查询某一科目下的花
     * @param typeCategoryId 科目Id
     * @return ResponseResult
     */
    Result getAllByTypeCategoryId(String typeCategoryId);

    /**
     * 更新花信息
     * @param flower Flower
     * @return Result
     */
    Result updateFlower(Flower flower);

    /**
     * 根据某一分类下的所有花
     * @param key 字段名
     * @param value 值
     * @return Result
     */
    Result getAllByType(String key,String value);

    /**
     * 获得卖的最好的五种花
     * @return Result
     */
    Result getFiveByNum();

    /**
     * 获得最新上架的花
     * @return Result
     */
    Result getByTime();

    /**
     * 查询指定价格范围的鲜花
     * @param start 最小金额
     * @param end 最大金额
     * @return Result
     */
    Result getByPrice(Integer start,Integer end);
}
