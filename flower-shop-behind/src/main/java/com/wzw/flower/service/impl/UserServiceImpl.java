package com.wzw.flower.service.impl;

import com.wzw.flower.common.Result;
import com.wzw.flower.common.ResultCode;
import com.wzw.flower.model.User;
import com.wzw.flower.repository.UserRepository;
import com.wzw.flower.service.UserService;
import com.wzw.flower.utils.UUIDUtils;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Optional;

/**
 * @Description:
 * @Author: wzw
 * @Date: 2021/4/28 11:17
 * @Version: 1.0
 */
@Service
public class UserServiceImpl implements UserService {
    @Resource
    private UserRepository userRepository;

    @Override
    public Result saveOne(User user) {
        User confirm1 = User.builder().phone(user.getPhone()).build();
        Optional<User> confirm2 = userRepository.findOne(Example.of(confirm1));
        if (confirm2.isPresent()){
            Result.failure(ResultCode.USER_PHONE_EXCITED);
        }
        user.setUserId(UUIDUtils.getUuId());
        User result = userRepository.save(user);
        if (result.getUserId() == null || "".equals(result.getUserId())){
            return Result.failure(ResultCode.USER_INSERT_FAIL);
        }
        return Result.success(result);
    }

    @Override
    public Result getByUserId(String userId) {
        User user = User.builder().userId(userId).build();
        Optional<User> confirm = userRepository.findOne(Example.of(user));
        User result = new User();
        if (confirm.isPresent()){
            result = confirm.get();
        }
        if (!confirm.isPresent()){
            Result.failure(ResultCode.USER_GET_FAIL);
        }
        if (result.getIsDeleted() == 1){
            Result.failure(ResultCode.USER_IS_DELETED);
        }
        return Result.success(result);
    }

    @Override
    public Result removeOne(String userId) {
        int result = userRepository.removeOne(userId);
        if (result != 1){
            return Result.failure(ResultCode.USER_DELETE_FAIL);
        }
        return Result.success(result);
    }

    @Override
    public Result updateUser(User user) {
        User result = userRepository.saveAndFlush(user);
        if (!result.getUserId().equals(user.getUserId())){
            return Result.failure(ResultCode.USER_UPDATE_FAIL);
        }
        return Result.success(result);
    }

    @Override
    public Result getUsers() {
        List<User> result = userRepository.findAll();
        if (result.size() == 0){
            return Result.failure(ResultCode.USER_GET_FAIL);
        }
        return Result.success(result);
    }
}
