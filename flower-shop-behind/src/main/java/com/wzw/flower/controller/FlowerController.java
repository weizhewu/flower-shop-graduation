package com.wzw.flower.controller;

import com.wzw.flower.common.Result;
import com.wzw.flower.model.Flower;
import com.wzw.flower.service.FlowerService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @Description:
 * @Author: wzw
 * @Date: 2021/4/21 17:02
 * @Version: 1.0
 */
@RequestMapping("flower/")
@RestController
public class FlowerController {
    @Resource
    private FlowerService flowerService;

    @PostMapping("save")
    public Result saveOne(@RequestBody Flower flower) {
        return flowerService.saveOne(flower);
    }

    @PostMapping("getOneByFlowerId")
    public Result getOneByFlowerId(@RequestParam String flowerId){
        return flowerService.getOneByFlowerId(flowerId);
    }

    @GetMapping("list")
    public Result getAll(){
        return flowerService.getAll();
    }

    @GetMapping("getByType")
    public Result getAllByType(@RequestParam String key,@RequestParam String value){
        return flowerService.getAllByType(key,value);
    }

    @GetMapping("getAllByTypeCategoryId")
    public Result getAllByTypeCategoryId(@RequestParam String typeCategoryId){
        return flowerService.getAllByTypeCategoryId(typeCategoryId);
    }

    @GetMapping("getFive")
    public Result getFiveByNum(){
        return flowerService.getFiveByNum();
    }

    @GetMapping("getNew")
    public Result getNew(){
        return flowerService.getByTime();
    }

    @GetMapping("getByPrice")
    public Result getByPrice(@RequestParam Integer start,@RequestParam Integer end){
        return flowerService.getByPrice(start, end);
    }
}

