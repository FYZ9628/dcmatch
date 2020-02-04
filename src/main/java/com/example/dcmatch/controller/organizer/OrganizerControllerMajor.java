package com.example.dcmatch.controller.organizer;

import com.example.dcmatch.model.Major;
import com.example.dcmatch.result.Result;
import com.example.dcmatch.result.Search;
import com.example.dcmatch.service.MajorService;
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
public class OrganizerControllerMajor {

    @Autowired
    MajorService majorService;

    @GetMapping("/api/getAllMajor")
    public List<Major> getAllMajor() throws Exception {
        return majorService.majorList();
    }

    @PostMapping("/api/searchMajor")
    public List<Major> findAllByMajorNameLike(@RequestBody Search s) throws Exception {

        return majorService.findAllByMajorNameLike(s.getKeywords());
    }


    @PostMapping("/api/addMajor")
    public Major addMajor(@RequestBody Major major) throws Exception {

        boolean bl = majorService.isExist(major.getId());
        if (bl == true){
            return null;
        }else {

            major = majorService.addOrUpdateMajor(major);

            return major;
        }
    }

    @PostMapping("/api/updateMajor")
    public Major updateMajor(@RequestBody Major major) throws Exception {

        boolean bl = majorService.isExist(major.getId());
        if (bl == true){
            major = majorService.addOrUpdateMajor(major);
            return major;
        }else {
            return null;
        }
    }


    @PostMapping("/api/deleteMajor")
    public Result deleteMajor(@RequestBody Major majorId) throws Exception {
        //因为前端只是传了一个 id 过来，所以 teacherId 里面只有一个 id 没有其他信息
        //所以要再通过 id 查询 teacher 的其他信息
        Major major = majorService.findById(majorId.getId());
        if (major != null){
            majorService.deleteById(majorId.getId());
            //   删除成功返回码 100
            return new Result(100);
        } else {
            //   删除失败返回码 400
            return new Result(400);
        }
    }
}
