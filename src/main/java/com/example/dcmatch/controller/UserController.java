package com.example.dcmatch.controller;

import com.example.dcmatch.model.School;
import com.example.dcmatch.model.Student;
import com.example.dcmatch.model.User;
import com.example.dcmatch.result.Result;
import com.example.dcmatch.result.Search;
import com.example.dcmatch.service.StudentService;
import com.example.dcmatch.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 控制层  转发调用
 * 在默认用户登录页面向后台发送认证信息的时候用
 */
@CrossOrigin
@RestController
public class UserController {
    @Autowired
    UserService userService;

    @GetMapping("/api/getAllUser")
    public List<User> getAllUser() throws Exception {
        return userService.userList();
    }

    @PostMapping("/api/searchUser")
    public  List<User>  findAllByNameLike(@RequestBody Search s) throws Exception {

        return userService.findAllByNameLike(s.getKeywords());
    }

    @PostMapping("/api/searchUserByAccount")
    public User getUserByAccount(@RequestBody Search s) throws Exception {

        return userService.getByAccount(s.getKeywords());
    }

    @PostMapping("/api/searchUserByPhone")
    public User getUserByPhone(@RequestBody Search s) throws Exception {

        return userService.getByPhone(s.getKeywords());
    }

    @PostMapping("/api/addUser")
    public User addOrUpdateUser(@RequestBody User user) throws Exception {

        boolean bl = userService.accountIsExist(user.getAccount());
        if (bl == true){
            return null;
        }else {
            userService.add(user);
            return user;
        }
    }

    @PostMapping("/api/updateUser")
    public User updateUser(@RequestBody User user) throws Exception {
        boolean bl = userService.accountIsExist(user.getAccount());
        if (bl == true){
            userService.add(user);
            return user;
        }else {
            return null;
        }
    }


    @PostMapping("/api/deleteUser")
    public Result deleteUser(@RequestBody User userId) throws Exception {
        //因为前端只是传了一个 id 过来，所以 teacherId 里面只有一个 id 没有其他信息
        //所以要再通过 id 查询 teacher 的其他信息
        User user = userService.findById(userId.getId());
        if (user != null){
            userService.deleteById(user.getId());
            //   删除成功返回码 100
            return new Result(100);
        } else {
            //   删除失败返回码 400
            return new Result(400);
        }
    }
}
