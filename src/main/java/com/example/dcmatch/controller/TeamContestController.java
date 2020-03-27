package com.example.dcmatch.controller;

import com.example.dcmatch.model.Contest;
import com.example.dcmatch.model.TeamContest;
import com.example.dcmatch.result.Result;
import com.example.dcmatch.result.Search;
import com.example.dcmatch.result.SearchByInt;
import com.example.dcmatch.service.ContestService;
import com.example.dcmatch.service.TeamContestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 控制层  转发调用
 */
@CrossOrigin
@RestController
public class TeamContestController {

    @Autowired
    TeamContestService teamContestService;

    @GetMapping("/api/getAllTeamContest")
    public List<TeamContest> getAllTeamContest() throws Exception {
        return teamContestService.teamContestList();
    }

    @PostMapping("/api/searchTeamContestByStudentAccount")
    public List<TeamContest> findAllByStudentAccount(@RequestBody Search s) throws Exception {

        return teamContestService.findAllByStudentAccount(s.getKeywords());
    }

    @PostMapping("/api/searchTeamContestByOrganizerAccount")
    public List<TeamContest> findAllByOrganizerAccount(@RequestBody Search s) throws Exception {

        return teamContestService.findAllByOrganizerAccount(s.getKeywords());
    }

    @PostMapping("/api/searchTeamContestById")
    public TeamContest findByTeamContestId(@RequestBody SearchByInt searchByInt) throws Exception {

        return teamContestService.findById(searchByInt.getKeywords());
    }

    @PostMapping("/api/searchTeamContestByContestDetailId")
    public List<TeamContest> findByContestDetailId(@RequestBody SearchByInt searchByInt) throws Exception {

        return teamContestService.findAllByContestDetail_Id(searchByInt.getKeywords());
    }

    //每一个报名的学生都会产生一个比赛记录，只是contest添加，但contestDetail不用添加
    //当contestDetail删除记录时，contest里所有有关的比赛记录都要被删除
    @PostMapping("/api/addTeamContest")
    public TeamContest addContest(@RequestBody TeamContest teamContest) throws Exception {

        boolean bl = teamContestService.isExist(teamContest.getId());
        if (bl == true){
            return null;
        }else {

            teamContest = teamContestService.addOrUpdateTeamContest(teamContest);

            return teamContest;
        }
    }

    @PostMapping("/api/updateTeamContest")
    public TeamContest updateTeamContest(@RequestBody TeamContest teamContest) throws Exception {

        boolean bl = teamContestService.isExist(teamContest.getId());
        if (bl == true){
            teamContest = teamContestService.addOrUpdateTeamContest(teamContest);
            return teamContest;
        }else {
            return null;
        }
    }


    @PostMapping("/api/deleteTeamContest")
    public Result deleteTeamContest(@RequestBody TeamContest teamContestId) throws Exception {
        //因为前端只是传了一个 id 过来，所以 teacherId 里面只有一个 id 没有其他信息
        //所以要再通过 id 查询 teacher 的其他信息
        TeamContest teamContest = teamContestService.findById(teamContestId.getId());
        if (teamContest != null){
            teamContestService.deleteById(teamContestId.getId());
            //   删除成功返回码 100
            return new Result(100);
        } else {
            //   删除失败返回码 400
            return new Result(400);
        }
    }
}
