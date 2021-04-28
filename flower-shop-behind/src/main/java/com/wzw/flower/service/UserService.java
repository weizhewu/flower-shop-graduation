package com.wzw.flower.service;

import com.wzw.flower.common.Result;
import com.wzw.flower.model.User;

/**
 * @Description:
 * @Author: wzw
 * @Date: 2021/4/28 11:14
 * @Version: 1.0
 */
public interface UserService {

    /**
     * 新增用户
     * @param user 用户实体类
     * @return Result
     */
    Result saveOne(User user);

    /**
     * 根据userId查询用户
     * @param userId 用户实体类
     * @return Result
     */
    Result getByUserId(String userId);

    /**
     * 注销用户
     * @param userId 用户实体类
     * @return Result
     */
    Result removeOne(String userId);

    /**
     * 更新用户字段
     * @param user 用户实体类
     * @return Result
     */
    Result updateUser(User user);

    /**
     * 查询所有用户
     * @return Result
     */
    Result getUsers();
}