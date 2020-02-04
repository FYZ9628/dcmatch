package com.example.dcmatch.controller.organizer;

import com.example.dcmatch.model.Academy;
import com.example.dcmatch.result.Result;
import com.example.dcmatch.result.Search;
import com.example.dcmatch.service.AcademyService;
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
public class OrganizerControllerAcademy {

    @Autowired
    AcademyService academyService;

    @GetMapping("/api/getAllAcademy")
    public List<Academy> getAllAcademy() throws Exception {
        return academyService.academyList();
    }

    @PostMapping("/api/searchAcademy")
    public List<Academy> findAllByAcademyNameLike(@RequestBody Search s) throws Exception {

        return academyService.findAllByAcademyNameLike(s.getKeywords());
    }


    @PostMapping("/api/addAcademy")
    public Academy addAcademy(@RequestBody Academy academy) throws Exception {

        boolean bl = academyService.isExist(academy.getId());
        if (bl == true){
            return null;
        }else {

            academy = academyService.addOrUpdateAcademy(academy);

            return academy;
        }
    }

    @PostMapping("/api/updateAcademy")
    public Academy updateAcademy(@RequestBody Academy academy) throws Exception {

        boolean bl = academyService.isExist(academy.getId());
        if (bl == true){
            academy = academyService.addOrUpdateAcademy(academy);
            return academy;
        }else {
            return null;
        }
    }


    @PostMapping("/api/deleteAcademy")
    public Result deleteStudent(@RequestBody Academy academyId) throws Exception {
        //因为前端只是传了一个 id 过来，所以 teacherId 里面只有一个 id 没有其他信息
        //所以要再通过 id 查询 teacher 的其他信息
        Academy academy = academyService.findById(academyId.getId());
        if (academy != null){
            academyService.deleteById(academyId.getId());
            //   删除成功返回码 100
            return new Result(100);
        } else {
            //   删除失败返回码 400
            return new Result(400);
        }
    }

}
