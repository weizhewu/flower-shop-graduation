package com.wzw.flower.repository;

import com.wzw.flower.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

/**
 * @Description:
 * @Author: wzw
 * @Date: 2021/4/28 11:17
 * @Version: 1.0
 */
@Repository
public interface UserRepository extends JpaRepository<User,Integer> {
     /**
     * 注销一个用户
     * @param userId 用户id
     * @return int
     */
    @Query(value = "delete from user where user_id = ?1",nativeQuery = true)
    @Modifying
    @Transactional(rollbackOn = Exception.class)
    int removeOne(String userId);
}