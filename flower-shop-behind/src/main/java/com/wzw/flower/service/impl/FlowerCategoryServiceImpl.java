package com.wzw.flower.service.impl;

import com.wzw.flower.common.Result;
import com.wzw.flower.common.ResultCode;
import com.wzw.flower.model.AreaCategory;
import com.wzw.flower.model.ColorCategory;
import com.wzw.flower.model.MeaningCategory;
import com.wzw.flower.model.TypeCategory;
import com.wzw.flower.repository.AreaCategoryRepository;
import com.wzw.flower.repository.ColorCategoryRepository;
import com.wzw.flower.repository.MeaningCategoryRepository;
import com.wzw.flower.repository.TypeCategoryRepository;
import com.wzw.flower.service.FlowerCategoryService;
import com.wzw.flower.utils.UUIDUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Description:
 * @Author: wzw
 * @Date: 2021/4/21 15:09
 * @Version: 1.0
 */
@Service
public class FlowerCategoryServiceImpl implements FlowerCategoryService {
    @Resource
    private AreaCategoryRepository areaCategoryRepository;
    @Resource
    private ColorCategoryRepository colorCategoryRepository;
    @Resource
    private MeaningCategoryRepository meaningCategoryRepository;
    @Resource
    private TypeCategoryRepository typeCategoryRepository;

    @Override
    public Result saveOneArea(String name) {
        AreaCategory areaCategory = AreaCategory.builder()
                .name(name).areaCategoryId(UUIDUtils.getUuId()).build();
        AreaCategory result = areaCategoryRepository.save(areaCategory);
        if (result.getAreaCategoryId() == null || "".equals(result.getAreaCategoryId())){
            return Result.failure(ResultCode.AREA_CATEGORY_INSERT_FAIL);
        }
        return Result.success(result);
    }

    @Override
    public Result getAllArea() {
        List<AreaCategory> list = areaCategoryRepository.findAll();
        if (list.size() == 0) {
            return Result.failure(ResultCode.AREA_CATEGORY_GET_FAIL);
        }
        return Result.success(list);
    }

    @Override
    public Result removeOneArea(String areaCategoryId) {
        int result = areaCategoryRepository.removeOne(areaCategoryId);
        if (result == 0) {
            return Result.failure(ResultCode.AREA_CATEGORY_REMOVE_FAIL);
        }
        return Result.success(result);
    }

    @Override
    public Result saveOneColor(String name) {
        ColorCategory colorCategory = ColorCategory.builder()
                .name(name).colorCategoryId(UUIDUtils.getUuId()).build();
        ColorCategory result = colorCategoryRepository.save(colorCategory);
        if (result.getColorCategoryId() == null || "".equals(result.getColorCategoryId())){
            return Result.failure(ResultCode.COLOR_CATEGORY_INSERT_FAIL);
        }
        return Result.success(result);
    }

    @Override
    public Result getAllColor() {
        List<ColorCategory> list = colorCategoryRepository.findAll();
        if (list.size() == 0) {
            return Result.failure(ResultCode.COLOR_CATEGORY_GET_FAIL);
        }
        return Result.success(list);
    }

    @Override
    public Result removeOneColor(String colorCategoryId) {
        int result = colorCategoryRepository.removeOne(colorCategoryId);
        if (result == 0) {
            return Result.failure(ResultCode.COLOR_CATEGORY_REMOVE_FAIL);
        }
        return Result.success(result);
    }

    @Override
    public Result saveOneMeaning(String name) {
        MeaningCategory meaningCategory = MeaningCategory.builder()
                .name(name).meaningCategoryId(UUIDUtils.getUuId()).build();
        MeaningCategory result = meaningCategoryRepository.save(meaningCategory);
        if (result.getMeaningCategoryId() == null || "".equals(result.getMeaningCategoryId())){
            return Result.failure(ResultCode.MEANING_CATEGORY_INSERT_FAIL);
        }
        return Result.success(result);
    }

    @Override
    public Result getAllMeaning() {
        List<MeaningCategory> list = meaningCategoryRepository.findAll();
        if (list.size() == 0) {
            return Result.failure(ResultCode.MEANING_CATEGORY_GET_FAIL);
        }
        return Result.success(list);
    }

    @Override
    public Result removeOneMeaning(String meaningCategoryId) {
        int result = meaningCategoryRepository.removeOne(meaningCategoryId);
        if (result == 0) {
            return Result.failure(ResultCode.MEANING_CATEGORY_REMOVE_FAIL);
        }
        return Result.success(result);
    }

    @Override
    public Result saveOneType(String name) {
        TypeCategory typeCategory = TypeCategory.builder()
                .name(name).typeCategoryId(UUIDUtils.getUuId()).build();
        TypeCategory result = typeCategoryRepository.save(typeCategory);
        if (result.getTypeCategoryId() == null || "".equals(result.getTypeCategoryId())){
            return Result.failure(ResultCode.TYPE_CATEGORY_INSERT_FAIL);
        }
        return Result.success(result);
    }

    @Override
    public Result getAllType() {
        List<TypeCategory> list = typeCategoryRepository.findAll();
        if (list.size() == 0) {
            return Result.failure(ResultCode.TYPE_CATEGORY_GET_FAIL);
        }
        return Result.success(list);
    }

    @Override
    public Result removeOneType(String typeCategoryId) {
        int result = typeCategoryRepository.removeOne(typeCategoryId);
        if (result == 0) {
            return Result.failure(ResultCode.TYPE_CATEGORY_REMOVE_FAIL);
        }
        return Result.success(result);
    }
}
