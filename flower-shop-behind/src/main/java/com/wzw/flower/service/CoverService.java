package com.wzw.flower.service;

import com.wzw.flower.common.Result;
import com.wzw.flower.model.Cover;


/**
 * @Description:
 * @Author: wzw
 * @Date: 2021/4/22 10:49
 * @Version: 1.0
 */
public interface CoverService {
    /**
     * 添加图片
     * @param cover Cover
     * @return Result
     */
    Result saveOne(Cover cover);

    /**
     * 根据类型查找图片
     * @param type String 类别名称
     * @return Result
     */
    Result getCovers(String type);
}