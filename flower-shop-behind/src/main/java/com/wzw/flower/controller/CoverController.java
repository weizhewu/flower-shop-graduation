package com.wzw.flower.controller;

import com.wzw.flower.common.Result;
import com.wzw.flower.service.CoverService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @Description:
 * @Author: wzw
 * @Date: 2021/4/22 11:12
 * @Version: 1.0
 */
@RequestMapping("cover/")
@RestController
public class CoverController {
    @Resource
    private CoverService coverService;

    @GetMapping("getCovers")
    public Result getCovers(@RequestParam String type) {
        return coverService.getCovers(type);
    }
}
