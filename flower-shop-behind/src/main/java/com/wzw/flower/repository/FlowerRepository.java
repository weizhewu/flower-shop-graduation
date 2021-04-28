package com.wzw.flower.repository;

import com.wzw.flower.model.Flower;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

/**
 * @author wzw
 */
@Repository
public interface FlowerRepository extends JpaRepository<Flower,Integer> {
    /**
     * 根据属性值查询花
     * @param value 属性值
     * @return List<Flower>
     */
    @Query(value = "select * from flower where type_category_id=?1",nativeQuery = true)
    List<Flower> getAllByType(String value);

    /**
     * 根据属性值查询花
     * @param value 属性值
     * @return List<Flower>
     */
    @Query(value = "select * from flower where color_category_id=?1",nativeQuery = true)
    List<Flower> getAllByColor(String value);

    /**
     * 根据属性值查询花
     * @param value 属性值
     * @return List<Flower>
     */
    @Query(value = "select * from flower where area_category_id=?1",nativeQuery = true)
    List<Flower> getAllByArea(String value);

    /**
     * 根据属性值查询花
     * @param value 属性值
     * @return List<Flower>
     */
    @Query(value = "select * from flower where meaning_category_id=?1",nativeQuery = true)
    List<Flower> getAllByMeaning(String value);

    /**
     * 获得卖的最好的五种花
     * @return List<Flower>
     */
    @Query(value = "select * from flower order by num desc ",nativeQuery = true)
    List<Flower> getFiveByNum();

    /**
     * 按时间排序
     * @return List<Flower>
     */
    @Query(value = "select * from flower order by create_time desc ",nativeQuery = true)
    List<Flower> getByTime();
    /**
     * 查询指定价格范围的鲜花
     * @param start 最小值
     * @param end 最大值
     * @return List<Flower>
     */
    @Query(value = "select * from flower where special_price >= ?1 and special_price <=?2",nativeQuery = true)
    List<Flower> getByPrice(double start,double end);
}
