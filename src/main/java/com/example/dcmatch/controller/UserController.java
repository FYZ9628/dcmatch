package com.example.dcmatch.controller;

import com.example.dcmatch.model.User;
import com.example.dcmatch.result.Search;
import com.example.dcmatch.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 控制层  转发调用
 * 在默认用户登录页面向后台发送认证信息的时候用
 */
@CrossOrigin
@RestController
public class UserController {
    @Autowired
    UserService userService;

    @PostMapping("/api/searchUser")
    public User findAllByNameLike(@RequestBody Search s) throws Exception {

        return userService.getByPhone(s.getKeywords());
    }
}
