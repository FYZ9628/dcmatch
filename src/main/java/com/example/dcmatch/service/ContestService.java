package com.example.dcmatch.service;

import com.example.dcmatch.dao.ContestDao;
import com.example.dcmatch.model.Contest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContestService {

    @Autowired
    ContestDao contestDao;

    public List<Contest> contestList() {
        //根据 id 由小到大排序，只能用于数值型数据
        Sort sort = new Sort(Sort.Direction.ASC, "id");
        return contestDao.findAll(sort);
    }

    //添加或更新比赛信息
    public Contest addOrUpdateContest(Contest contest) {
        return contestDao.save(contest);
    }

    //根据比赛标题或举办方账号查询
    //给学生端用，也可以作为给举办方总结用，就像支付宝的年度总结
    public List<Contest> findAllByContestTitleLikeOrOrganizerAccount(String keywords) {
        return contestDao.findAllByContestDetail_ContestTitleLikeOrContestDetail_Organizer_User_AccountLike('%' + keywords + '%'
                ,'%' + keywords + '%');
    }

    //根据比赛标题或学生账号查询
    //给举办方端用，也可以作为给学生总结用，就像支付宝的年度总结
    public List<Contest> findAllByContestTitleLikeOrStudentAccount(String keywords) {
        return contestDao.findAllByContestDetail_ContestTitleLikeOrStudent_User_AccountLike('%' + keywords + '%'
                ,'%' + keywords + '%');
    }

    //    通过 id 删除
    public void deleteById(int id) {
        contestDao.deleteById(id);
    }

    //    通过  id 查询
    public Contest findById(int id){
        return contestDao.findById(id);
    }

    public boolean isExist(int id) {
        Contest mClass = findById(id);
        return null!=mClass;
    }
}
