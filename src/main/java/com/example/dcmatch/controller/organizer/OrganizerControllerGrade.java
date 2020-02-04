package com.example.dcmatch.controller.organizer;

import com.example.dcmatch.model.Grade;
import com.example.dcmatch.result.Result;
import com.example.dcmatch.result.Search;
import com.example.dcmatch.service.GradeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 控制层  转发调用
 */

@RestController
public class OrganizerControllerGrade {

    @Autowired
    GradeService gradeService;

    @GetMapping("/api/getAllGrade")
    public List<Grade> getAllGrade() throws Exception {
        return gradeService.gradeList();
    }

    @PostMapping("/api/searchGrade")
    public List<Grade> findAllByGradeNumberLike(@RequestBody Search s) throws Exception {

        return gradeService.findAllByGradeNumberLike(s.getKeywords());
    }


    @PostMapping("/api/addGrade")
    public Grade addAcademy(@RequestBody Grade grade) throws Exception {

        boolean bl = gradeService.isExist(grade.getId());
        if (bl == true){
            return null;
        }else {

            grade = gradeService.addOrUpdateGrade(grade);

            return grade;
        }
    }

    @PostMapping("/api/updateGrade")
    public Grade updateAcademy(@RequestBody Grade grade) throws Exception {

        boolean bl = gradeService.isExist(grade.getId());
        if (bl == true){
            grade = gradeService.addOrUpdateGrade(grade);
            return grade;
        }else {
            return null;
        }
    }


    @PostMapping("/api/deleteGrade")
    public Result deleteStudent(@RequestBody Grade gradeId) throws Exception {
        //因为前端只是传了一个 id 过来，所以 teacherId 里面只有一个 id 没有其他信息
        //所以要再通过 id 查询 teacher 的其他信息
        Grade grade = gradeService.findById(gradeId.getId());
        if (grade != null){
            gradeService.deleteById(gradeId.getId());
            //   删除成功返回码 100
            return new Result(100);
        } else {
            //   删除失败返回码 400
            return new Result(400);
        }
    }
}
