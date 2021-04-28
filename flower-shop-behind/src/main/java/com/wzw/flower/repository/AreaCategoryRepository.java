package com.wzw.flower.repository;

import com.wzw.flower.model.AreaCategory;
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
public interface AreaCategoryRepository extends JpaRepository<AreaCategory,Integer> {
    /**
     * 删除一个地区
     * @param areaCategoryId 地区id
     * @return int
     */
    @Query(value = "delete from area_category where area_category_id = ?1",nativeQuery = true)
    @Modifying
    @Transactional(rollbackOn = Exception.class)
    int removeOne(String areaCategoryId);
}