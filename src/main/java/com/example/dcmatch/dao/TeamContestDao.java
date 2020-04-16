package com.example.dcmatch.dao;

import com.example.dcmatch.model.Contest;
import com.example.dcmatch.model.TeamContest;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TeamContestDao extends JpaRepository<TeamContest,Integer> {

    List<TeamContest> findAllByStudent_User_Account(String account);

    List<TeamContest> findAllByTeacherAccount(String account);

    List<TeamContest> findAllByContestDetail_Organizer_User_Account(String account);

    List<TeamContest> findAllByContestDetail_Id(int id);

    TeamContest findById(int id);

    List<TeamContest> findAllByTeamName(String teamName);

    List<TeamContest> findAllByTeamNameAndContestDetail_Id(String teamName, int contestDetailId);
}