package com.wzw.flower.repository;

import com.wzw.flower.model.MeaningCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

/**
 * @Description:
 * @Author: wzw
 * @Date: 2021/4/23 9:50
 * @Version: 1.0
 */
@Repository
public interface MeaningCategoryRepository extends JpaRepository<MeaningCategory,Integer> {
    /**
     * 删除一个特殊含义
     * @param meaningCategoryId 特殊含义id
     * @return int
     */
    @Query(value = "delete from meaning_category where meaning_category_id = ?1",nativeQuery = true)
    @Modifying
    @Transactional(rollbackOn = Exception.class)
    int removeOne(String meaningCategoryId);
}