package com.example.dcmatch.controller.public_part;

import com.example.dcmatch.model.Organizer;
import com.example.dcmatch.model.Student;
import com.example.dcmatch.model.User;
import com.example.dcmatch.result.Result;
import com.example.dcmatch.service.OrganizerService;
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

@Controller
public class LoginController {

    @Autowired
    UserService userService;
    @Autowired
    StudentService studentService;
    @Autowired
    OrganizerService organizerService;

    @CrossOrigin
    @PostMapping(value = "api/login")
    @ResponseBody
    @ApiOperation(value="学生或教师登录")
    public Result login(@RequestBody User requestUser) {
        // 对 html 标签进行转义，防止 XSS 攻击
        String account = requestUser.getAccount();
        account = HtmlUtils.htmlEscape(account);

        // 返回码：100对应管理员，200对应教师，300对应学生，400是错误码
        User user = userService.get(account, requestUser.getPassword());
        if (null == user) {
            return new Result(400);
        } else if (user.getType() == 3){
            Student student = studentService.findByUser_Account(user.getAccount());
            String mAccount = user.getAccount();
            String mPassword = user.getPassword();
            String mName = student.getName();

            return new Result(300, mAccount, mPassword, mName);
        }else if (user.getType() == 2){

            Organizer organizer = organizerService.findByUser_Account(user.getAccount());
            String mAccount = user.getAccount();
            String mPassword = user.getPassword();
            String mName = organizer.getName();
            return new Result(200, mAccount, mPassword, mName);

        } else if (user.getType() == 1){

            User newUser = userService.getByAccount(user.getAccount());
            String mAccount = user.getAccount();
            String mPassword = user.getPassword();
            return new Result(100, mAccount, mPassword);
        } else {
            return new Result(400);
        }
    }

}

