package com.wzw.flower.repository;

import com.wzw.flower.model.ColorCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;

/**
 * @Description:
 * @Author: wzw
 * @Date: 2021/4/23 9:49
 * @Version: 1.0
 */
public interface ColorCategoryRepository extends JpaRepository<ColorCategory,Integer> {
    /**
     * 删除一个颜色
     * @param colorCategoryId 科目id
     * @return int
     */
    @Query(value = "delete from color_category where color_category_id = ?1",nativeQuery = true)
    @Modifying
    @Transactional(rollbackOn = Exception.class)
    int removeOne(String colorCategoryId);
}
