package com.wzw.flower.service.impl;

import com.wzw.flower.common.Result;
import com.wzw.flower.common.ResultCode;
import com.wzw.flower.model.Cover;
import com.wzw.flower.repository.CoverRepository;
import com.wzw.flower.service.CoverService;
import com.wzw.flower.utils.UUIDUtils;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Description:
 * @Author: wzw
 * @Date: 2021/4/22 10:50
 * @Version: 1.0
 */
@Service
public class CoverServiceImpl implements CoverService {

    @Resource
    private CoverRepository coverRepository;

    @Override
    public Result saveOne(Cover cover) {
        cover.setCoverId(UUIDUtils.getUuId());
        Cover result = coverRepository.save(cover);
        if (result.getCoverId() == null || "".equals(result.getCoverId())){
            Result.failure(ResultCode.COVER_INSERT_FAIL);
        }
        return Result.success(result);
    }

    @Override
    public Result getCovers(String type) {
        Cover cover = Cover.builder().type(type).build();
        List<Cover> covers = coverRepository.findAll(Example.of(cover));
        if (covers.size() == 0) {
            return Result.failure(ResultCode.COVER_GET_FAIL);
        }
        return Result.success(covers);
    }
}
