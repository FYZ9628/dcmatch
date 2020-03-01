package com.example.dcmatch.controller.organizer;

import com.example.dcmatch.model.ContestDetail;
import com.example.dcmatch.result.Result;
import com.example.dcmatch.result.Search;
import com.example.dcmatch.service.ContestDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 控制层  转发调用
 */
@CrossOrigin
@RestController
public class OrganizerControllerContestDetail {

    @Autowired
    ContestDetailService contestDetailService;

    @GetMapping("/api/getAllContestDetail")
    public List<ContestDetail> getAllContestDetail() throws Exception {
        return contestDetailService.contestDetailList();
    }

    @PostMapping("/api/searchContestDetail")
    public List<ContestDetail> findAllByContestTitleLike(@RequestBody Search s) throws Exception {

        return contestDetailService.findAllByContestTitleLike(s.getKeywords());
    }


    @PostMapping("/api/addContestDetail")
    public ContestDetail addContestDetail(@RequestBody ContestDetail contestDetail) throws Exception {

        boolean bl = contestDetailService.isExist(contestDetail.getId());
        if (bl == true){
            return null;
        }else {

            contestDetail = contestDetailService.addOrUpdateContestDetail(contestDetail);

            return contestDetail;
        }
    }

    @PostMapping("/api/updateContestDetail")
    public ContestDetail updateContestDetail(@RequestBody ContestDetail contestDetail) throws Exception {

        boolean bl = contestDetailService.isExist(contestDetail.getId());
        if (bl == true){
            contestDetail = contestDetailService.addOrUpdateContestDetail(contestDetail);
            return contestDetail;
        }else {
            return null;
        }
    }


    @PostMapping("/api/deleteContestDetail")
    public Result deleteContestDetail(@RequestBody ContestDetail contestDetailId) throws Exception {
        //因为前端只是传了一个 id 过来，所以 teacherId 里面只有一个 id 没有其他信息
        //所以要再通过 id 查询 teacher 的其他信息
        ContestDetail contestDetail = contestDetailService.findById(contestDetailId.getId());
        if (contestDetail != null){
            contestDetailService.deleteById(contestDetailId.getId());
            //   删除成功返回码 100
            return new Result(100);
        } else {
            //   删除失败返回码 400
            return new Result(400);
        }
    }

}
