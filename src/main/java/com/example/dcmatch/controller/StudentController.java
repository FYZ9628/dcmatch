package com.example.dcmatch.controller;

import com.example.dcmatch.model.Student;
import com.example.dcmatch.result.Result;
import com.example.dcmatch.result.Search;
import com.example.dcmatch.service.StudentService;
import com.example.dcmatch.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 控制层  转发调用
 */
@CrossOrigin
@RestController
public class StudentController {
    @Autowired
    StudentService studentService;
    @Autowired
    UserService userService;

    @GetMapping("/api/getAllStudent")
    public List<Student> getAllStudent() throws Exception {
        return studentService.studentList();
    }

    @PostMapping("/api/searchStudent")
    public List<Student> studentFindAllByNameLikeOrUser_AccountLike(@RequestBody Search s) throws Exception {

        return studentService.findAllByUser_NameLikeOrUser_AccountLike(s.getKeywords());
    }


    @PostMapping("/api/searchStudentByAccount")
    public Student getStudentByUser_Account(@RequestBody Search s) throws Exception {

        return studentService.getByUser_Account(s.getKeywords());
    }

    @PostMapping("/api/addStudent")
    public Student addOrUpdateStudent(@RequestBody Student student) throws Exception {

        boolean bl = userService.accountIsExist(student.getUser().getAccount());
        if (bl == true){
            return null;
        }else {
            userService.add(student.getUser());
            student = studentService.addOrUpStudent(student);

            return student;
        }
    }

    @PostMapping("/api/updateStudent")
    public Student updateStudent(@RequestBody Student student) throws Exception {
        boolean bl = userService.accountIsExist(student.getUser().getAccount());
        if (bl == true){
            userService.add(student.getUser());
            student = studentService.addOrUpStudent(student);
            return student;
        }else {
            return null;
        }
    }


    @PostMapping("/api/deleteStudent")
    public Result deleteStudent(@RequestBody Student studentId) throws Exception {
        //因为前端只是传了一个 id 过来，所以 teacherId 里面只有一个 id 没有其他信息
        //所以要再通过 id 查询 teacher 的其他信息
        Student student = studentService.findById(studentId.getId());
        if (student != null){
            studentService.deleteById(studentId.getId());
            userService.deleteById(student.getUser().getId());
            //   删除成功返回码 100
            return new Result(100);
        } else {
            //   删除失败返回码 400
            return new Result(400);
        }
    }
}
