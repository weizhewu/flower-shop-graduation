package com.wzw.flower.repository;

import com.wzw.flower.model.Cover;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @Description: 页面图片
 * @Author: wzw
 * @Date: 2021/4/22 10:48
 * @Version: 1.0
 */
@Repository
public interface CoverRepository extends JpaRepository<Cover,Integer> {
}