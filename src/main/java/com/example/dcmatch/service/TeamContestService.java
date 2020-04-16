package com.example.dcmatch.service;

import com.example.dcmatch.dao.TeamContestDao;
import com.example.dcmatch.model.TeamContest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeamContestService {

    @Autowired
    TeamContestDao teamContestDao;

    public List<TeamContest> teamContestList() {
        //根据 id 由小到大排序，只能用于数值型数据
        Sort sort = new Sort(Sort.Direction.ASC, "id");
        return teamContestDao.findAll(sort);
    }

    //添加或更新比赛信息
    public TeamContest addOrUpdateTeamContest(TeamContest teamContest) {
        return teamContestDao.save(teamContest);
    }


    public List<TeamContest> findAllByStudentAccount(String keywords) {
        return teamContestDao.findAllByStudent_User_Account(keywords);
    }

    public List<TeamContest> findAllByTeacherAccount(String keywords) {
        return teamContestDao.findAllByTeacherAccount(keywords);
    }

    public List<TeamContest> findAllByOrganizerAccount(String keywords) {
        return teamContestDao.findAllByContestDetail_Organizer_User_Account(keywords);
    }

    public List<TeamContest> findAllByContestDetail_Id(int keywords) {
        return teamContestDao.findAllByContestDetail_Id(keywords);
    }

    //    通过 id 删除
    public void deleteById(int id) {
        teamContestDao.deleteById(id);
    }

    //    通过  id 查询
    public TeamContest findById(int id){
        return teamContestDao.findById(id);
    }

    //    通过  团队名称 查询
    public List<TeamContest> findAllByTeamName(String teamName){
        return teamContestDao.findAllByTeamName(teamName);
    }

    //    通过 团队名称 和 id 查询
    public List<TeamContest> findAllByTeamNameAndContestDetailId(String teamName, int contestDetailId){
        return teamContestDao.findAllByTeamNameAndContestDetail_Id(teamName, contestDetailId);
    }

    public boolean isExist(int id) {
        TeamContest teamContest = findById(id);
        return null != teamContest;
    }
}