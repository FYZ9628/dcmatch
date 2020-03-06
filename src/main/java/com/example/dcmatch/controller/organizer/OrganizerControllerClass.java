package com.example.dcmatch.controller.organizer;

import com.example.dcmatch.model.Class;
import com.example.dcmatch.model.Student;
import com.example.dcmatch.result.Result;
import com.example.dcmatch.result.Search;
import com.example.dcmatch.service.ClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 控制层  转发调用
 */
@CrossOrigin
@RestController
public class OrganizerControllerClass {

    @Autowired
    ClassService classService;

    @GetMapping("/api/getAllClass")
    public List<Class> getAllClass() throws Exception {
        return classService.classList();
    }

    @PostMapping("/api/searchClass")
    public List<Class> findAllByClassNameLike(@RequestBody Search s) throws Exception {

        return classService.findAllByClassNameLike(s.getKeywords());
    }


    @PostMapping("/api/addClass")
    public Class addClass(@RequestBody Class mclass) throws Exception {

        boolean bl = classService.isExist(mclass.getId());
        if (bl == true){
            return null;
        }else {

            mclass = classService.addOrUpdateClass(mclass);

            return mclass;
        }
    }

    @PostMapping("/api/updateClass")
    public Class updateStudent(@RequestBody Class mclass) throws Exception {

        boolean bl = classService.isExist(mclass.getId());
        if (bl == true){
            mclass = classService.addOrUpdateClass(mclass);
            return mclass;
        }else {
            return null;
        }
    }


    @PostMapping("/api/deleteClass")
    public Result deleteStudent(@RequestBody Class classId) throws Exception {
        //因为前端只是传了一个 id 过来，所以 teacherId 里面只有一个 id 没有其他信息
        //所以要再通过 id 查询 teacher 的其他信息
        Class mclass = classService.findById(classId.getId());
        if (mclass != null){
            classService.deleteById(classId.getId());
            //   删除成功返回码 100
            return new Result(100);
        } else {
            //   删除失败返回码 400
            return new Result(400);
        }
    }

}
