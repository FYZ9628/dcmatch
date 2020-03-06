package com.example.dcmatch.controller.public_part;

import com.example.dcmatch.model.Organizer;
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
public class LoginController {

    @Autowired
    UserService userService;
    @Autowired
    StudentService studentService;
    @Autowired
    OrganizerService organizerService;
    @Autowired
    RegisterService registerService;

    @PostMapping(value = "api/login")
    @ResponseBody
    @ApiOperation(value="学生或教师登录")
    public Result login(@RequestBody User requestUser) {
        // 对 html 标签进行转义，防止 XSS 攻击
        String account = requestUser.getAccount();
        account = HtmlUtils.htmlEscape(account);

        // 返回码：100对应管理员，200对应教师，300对应学生，400是错误码，500是默认用户(即还没有认证的用户)
        // 前端返回的 account 可以是账号（account），也可以是电话号码（phone）
        // 亦可以是 注册了但未认证的用户号码（phone）
        User user = userService.getByAccountAndPassword(account, requestUser.getPassword());
        User user2 = userService.getByPhoneAndPassword(account, requestUser.getPassword());
        Register register = registerService.getByPhoneAndPassword(account, requestUser.getPassword());

        if (null != user) {
            if (user.getType() == 3) {
                String mAccount = user.getAccount();
                String mPassword = user.getPassword();
                String mName = user.getName();
                return new Result(300, mAccount, mPassword, mName);
            }else if (user.getType() == 2) {

//                Organizer organizer = organizerService.findByUser_Account(user.getAccount());
                String mAccount = user.getAccount();
                String mPassword = user.getPassword();
                String mName = user.getName();
//                String mName = organizer.getName();
                return new Result(200, mAccount, mPassword, mName);
            }
            return new Result(400);
        }

        if (null != user2) {
            if (user2.getType() == 3) {
                String mAccount = user2.getPhone();
                String mPassword = user2.getPassword();
                String mName = user2.getName();
                return new Result(300, mAccount, mPassword, mName);
            }else if (user2.getType() == 2) {

//                Organizer organizer = organizerService.findByUser_Account(user.getAccount());
                String mAccount = user2.getPhone();
                String mPassword = user2.getPassword();
                String mName = user2.getName();
//                String mName = organizer.getName();
                return new Result(200, mAccount, mPassword, mName);
            }
        }

        if (null != register) {
            String mAccount = register.getPhone();
            String mPassword = register.getPassword();
            String mName = register.getPhone();
            return new Result(500, mAccount, mPassword, mName);
        }

        return new Result(400);
    }

}

