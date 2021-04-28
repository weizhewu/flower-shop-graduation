package com.wzw.flower.controller;

import com.wzw.flower.common.Result;
import com.wzw.flower.model.User;
import com.wzw.flower.service.UserService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @Description:
 * @Author: wzw
 * @Date: 2021/4/28 14:10
 * @Version: 1.0
 */
@RequestMapping("user/")
@RestController
public class UserController {
    @Resource
    private UserService service;

    @GetMapping("getUsers")
    public Result getUsers(){
        return service.getUsers();
    }

    @PostMapping("/saveOne")
    public Result saveOne(@RequestBody User user){
        return service.saveOne(user);
    }

    @GetMapping("getOne")
    public Result getByUserId(@RequestParam String userId){
        return service.getByUserId(userId);
    }

    @PostMapping("remove")
    public Result removeOne(String userId) {
        return service.removeOne(userId);
    }

    @PostMapping("update")
    public Result updateUser(@RequestBody User user){
        return service.updateUser(user);
    }
}
