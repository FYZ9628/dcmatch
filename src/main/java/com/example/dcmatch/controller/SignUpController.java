package com.example.dcmatch.controller;

import com.example.dcmatch.model.Register;
import com.example.dcmatch.model.Student;
import com.example.dcmatch.model.User;
import com.example.dcmatch.result.Result;
import com.example.dcmatch.service.OrganizerService;
import com.example.dcmatch.service.RegisterService;
import com.example.dcmatch.service.StudentService;
import com.example.dcmatch.service.UserService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.util.HtmlUtils;

/**
 * 控制层  转发调用
 */
@CrossOrigin
@Controller
public class SignUpController {

    @Autowired
    UserService userService;
    @Autowired
    StudentService studentService;

    @PostMapping(value = "api/teamSignUpAddStudent")
    @ResponseBody
    @ApiOperation(value="团队赛报名接口")
    public Student teamSignUpAddStudent(@RequestBody User requestUser) {
        // 对 html 标签进行转义，防止 XSS 攻击
        String account = requestUser.getAccount();
        account = HtmlUtils.htmlEscape(account);

        // 前端返回的 account 可以是账号（account），也可以是电话号码（phone）
        User user = userService.getByAccountAndPassword(account, requestUser.getPassword());
        User user2 = userService.getByPhoneAndPassword(account, requestUser.getPassword());

        // 通过account和password验证登录
        if (null != user) {
            return studentService.getByUser_Account(user.getAccount());
        }

        // 通过phone和password验证登录
        if (null != user2) {
            return studentService.getByUser_Account(user2.getAccount());
        }

        return null;
    }

}

