package com.example.dcmatch.controller;

import com.example.dcmatch.model.Teacher;
import com.example.dcmatch.result.Result;
import com.example.dcmatch.result.Search;
import com.example.dcmatch.service.TeacherService;
import com.example.dcmatch.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 控制层  转发调用
 */
@CrossOrigin
@RestController
public class TeacherController {
    @Autowired
    TeacherService teacherService;
    @Autowired
    UserService userService;

    @GetMapping("/api/getAllTeacher")
    public List<Teacher> getAllTeacher() throws Exception {
        return teacherService.teacherList();
    }

    @PostMapping("/api/searchTeacher")
    public List<Teacher> teacherFindAllByNameLikeOrUser_AccountLike(@RequestBody Search s) throws Exception {

        return teacherService.findAllByUser_NameLikeOrUser_AccountLike(s.getKeywords());
    }

    @PostMapping("/api/searchTeacherByAccount")
    public Teacher getTeacherByUser_Account(@RequestBody Search s) throws Exception {

        return teacherService.getByUser_Account(s.getKeywords());
    }


    @PostMapping("/api/addTeacher")
    public Teacher addOrUpdateTeacher(@RequestBody Teacher teacher) throws Exception {

        boolean bl = userService.accountIsExist(teacher.getUser().getAccount());
        if (bl == true){
            return null;
        }else {
            userService.add(teacher.getUser());
            teacher = teacherService.addOrUpStudent(teacher);

            return teacher;
        }
    }

    @PostMapping("/api/updateTeacher")
    public Teacher updateTeacher(@RequestBody Teacher teacher) throws Exception {
        boolean bl = userService.accountIsExist(teacher.getUser().getAccount());
        if (bl == true){
            userService.add(teacher.getUser());
            teacher = teacherService.addOrUpStudent(teacher);
            return teacher;
        }else {
            return null;
        }
    }


    @PostMapping("/api/deleteTeacher")
    public Result deleteTeacher(@RequestBody Teacher teacherId) throws Exception {
        //因为前端只是传了一个 id 过来，所以 teacherId 里面只有一个 id 没有其他信息
        //所以要再通过 id 查询 teacher 的其他信息
        Teacher teacher = teacherService.findById(teacherId.getId());
        if (teacher != null){
            teacherService.deleteById(teacherId.getId());
            userService.deleteById(teacher.getUser().getId());
            //   删除成功返回码 100
            return new Result(100);
        } else {
            //   删除失败返回码 400
            return new Result(400);
        }
    }
}
