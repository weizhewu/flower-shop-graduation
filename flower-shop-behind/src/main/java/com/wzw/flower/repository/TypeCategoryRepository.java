package com.wzw.flower.repository;

import com.wzw.flower.model.TypeCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

/**
 * @Description: 花的科目
 * @Author: wzw
 * @Date: 2021/4/21 15:04
 * @Version: 1.0
 */
@Repository
public interface TypeCategoryRepository extends JpaRepository<TypeCategory,Integer> {

    /**
     * 删除一个科目
     * @param typeCategoryId 科目id
     * @return int
     */
    @Query(value = "delete from type_category where type_category_id = ?1",nativeQuery = true)
    @Modifying
    @Transactional(rollbackOn = Exception.class)
    int removeOne(String typeCategoryId);
}
