package com.example.dcmatch.dao;

import com.example.dcmatch.model.Contest;
import com.example.dcmatch.model.ContestDetail;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ContestDao extends JpaRepository<Contest,Integer> {

//    给学生端用，也可以作为给举办方总结用，就像支付宝的年度总结
//    List<Contest> findAllByContestDetail_ContestTitleLikeOrOrganizerId_User_AccountLike(String contestTitle,String organizerAccount);
    List<Contest> findAllByContestDetail_ContestTitleLikeOrContestDetail_Organizer_User_AccountLike(String contestTitle,String organizerAccount);

//    给举办方端用，也可以作为给学生总结用，就像支付宝的年度总结
//    List<Contest> findAllByContestDetail_ContestTitleLikeOrStudentId_User_AccountLike(String contestTitle,String studentAccount);
    List<Contest> findAllByContestDetail_ContestTitleLikeOrStudent_User_AccountLike(String contestTitle,String studentAccount);

    List<Contest> findAllByStudent_User_Account(String account);

    List<Contest> findAllByContestDetail_Organizer_User_Account(String account);

    Contest findById(int id);
}
