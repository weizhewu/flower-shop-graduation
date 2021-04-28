package com.wzw.flower.service.impl;

import com.wzw.flower.common.Result;
import com.wzw.flower.common.ResultCode;
import com.wzw.flower.model.Flower;
import com.wzw.flower.repository.FlowerRepository;
import com.wzw.flower.service.FlowerService;
import com.wzw.flower.utils.HumpToUnderlineUtil;
import com.wzw.flower.utils.UUIDUtils;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;
import java.util.Optional;

/**
 * @author wzw
 */
@Service
public class FlowerServiceImpl implements FlowerService {
    @Resource
    private FlowerRepository repository;

    private final String AREA = "area";
    private final String COLOR = "color";
    private final String MEANING = "meaning";

    @Override
    public Result saveOne(Flower flower) {
        flower.setFlowerId(UUIDUtils.getUuId());
        flower.setCreateTime(new Date());
        Flower result = repository.save(flower);
        if (result.getFlowerId() == null || "".equals(result.getFlowerId())){
            Result.failure(ResultCode.FLOWER_INSERT_FAIL);
        }
        return Result.success(result);
    }

    @Override
    public Result getOneByFlowerId(String flowerId) {
        Flower flower = Flower.builder().flowerId(flowerId).build();
        Optional<Flower> result = repository.findOne(Example.of(flower));
        return result.map(Result::success).orElseGet(() -> Result.failure(ResultCode.FLOWER_GET_FAIL));
    }

    @Override
    public Result getAll() {
        List<Flower> flowers = repository.findAll();
        if (flowers.size() == 0) {
            return Result.failure(ResultCode.FLOWER_GET_FAIL);
        }
        return Result.success(flowers);
    }

//    @Override
//    public Result getHots() {
//        Flower flower = Flower.builder().isHot(1).build();
//        List<Flower> flowers = repository.findAll(Example.of(flower));
//        if (flowers.size() == 0) {
//            return Result.failure(ResultCode.FLOWER_GET_FAIL);
//        }
//        return Result.success(flowers);
//    }

    @Override
    public Result getAllByTypeCategoryId(String typeCategoryId) {
        Flower flower = Flower.builder().typeCategoryId(typeCategoryId).build();
        List<Flower> flowers = repository.findAll(Example.of(flower));
        if (flowers.size() == 0) {
            return Result.failure(ResultCode.FLOWER_GET_FAIL);
        }
        return Result.success(flowers);
    }

    @Override
    public Result updateFlower(Flower flower) {
        Flower result;
        try {
            result = repository.saveAndFlush(flower);
            return Result.success(result);
        } catch (Exception e){
            return Result.failure(ResultCode.FLOWER_UPDATE_FAIL);
        }
    }

    @Override
    public Result getAllByType(String key, String value) {
        List<Flower> flowers = repository.getAllByType(value);
        if (AREA.equals(key)){
            flowers = repository.getAllByArea(value);
        }
        if (COLOR.equals(key)){
            flowers = repository.getAllByColor(value);
        }
        if (MEANING.equals(key)){
            flowers = repository.getAllByMeaning(value);
        }

        if (flowers.size() == 0) {
            return Result.failure(ResultCode.FLOWER_GET_FAIL);
        }
        return Result.success(flowers);
    }

    @Override
    public Result getFiveByNum() {
        List<Flower> flowers = repository.getFiveByNum();
        if (flowers.size() == 0) {
            return Result.failure(ResultCode.FLOWER_GET_FAIL);
        }
        return Result.success(flowers);
    }

    @Override
    public Result getByTime() {
        List<Flower> flowers = repository.getByTime();
        if (flowers.size() == 0) {
            return Result.failure(ResultCode.FLOWER_GET_FAIL);
        }
        return Result.success(flowers);
    }

    @Override
    public Result getByPrice(Integer start, Integer end) {
        List<Flower> flowers = repository.getByPrice(Double.valueOf(start),Double.valueOf(end));
        if (flowers.size() == 0) {
            return Result.failure(ResultCode.FLOWER_GET_FAIL);
        }
        return Result.success(flowers);
    }
}
