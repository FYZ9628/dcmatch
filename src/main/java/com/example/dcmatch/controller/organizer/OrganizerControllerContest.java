package com.example.dcmatch.controller.organizer;

import com.example.dcmatch.model.Contest;
import com.example.dcmatch.result.Result;
import com.example.dcmatch.result.Search;
import com.example.dcmatch.service.ContestService;
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
public class OrganizerControllerContest {

    @Autowired
    ContestService contestService;

    @GetMapping("/api/getAllContest")
    public List<Contest> getAllContestDetail() throws Exception {
        return contestService.contestList();
    }

    //根据比赛标题或举办方账号查询
    //给学生端用，也可以作为给举办方总结用，就像支付宝的年度总结
    @PostMapping("/api/searchContest_for_Student")
    public List<Contest> findAllByContestTitleLikeOrOrganizerAccount(@RequestBody Search s) throws Exception {

        return contestService.findAllByContestTitleLikeOrOrganizerAccount(s.getKeywords());
    }

    //根据比赛标题或学生账号查询
    //给举办方端用，也可以作为给学生总结用，就像支付宝的年度总结
    @PostMapping("/api/searchContest_for_Organizer")
    public List<Contest> findAllByContestTitleLikeOrStudentAccount(@RequestBody Search s) throws Exception {

        return contestService.findAllByContestTitleLikeOrStudentAccount(s.getKeywords());
    }


    //每一个报名的学生都会产生一个比赛记录，只是contest添加，但contestDetail不用添加
    //当contestDetail删除记录时，contest里所有有关的比赛记录都要被删除
    @PostMapping("/api/addContest")
    public Contest addContest(@RequestBody Contest contest) throws Exception {

        boolean bl = contestService.isExist(contest.getId());
        if (bl == true){
            return null;
        }else {

            contest = contestService.addOrUpdateContest(contest);

            return contest;
        }
    }

    @PostMapping("/api/updateContest")
    public Contest updateContest(@RequestBody Contest contest) throws Exception {

        boolean bl = contestService.isExist(contest.getId());
        if (bl == true){
            contest = contestService.addOrUpdateContest(contest);
            return contest;
        }else {
            return null;
        }
    }


    @PostMapping("/api/deleteContest")
    public Result deleteContest(@RequestBody Contest contestId) throws Exception {
        //因为前端只是传了一个 id 过来，所以 teacherId 里面只有一个 id 没有其他信息
        //所以要再通过 id 查询 teacher 的其他信息
        Contest contest = contestService.findById(contestId.getId());
        if (contest != null){
            contestService.deleteById(contestId.getId());
            //   删除成功返回码 100
            return new Result(100);
        } else {
            //   删除失败返回码 400
            return new Result(400);
        }
    }
}
