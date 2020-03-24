package com.example.dcmatch.service;

import com.example.dcmatch.dao.ContestDetailDao;
import com.example.dcmatch.model.Contest;
import com.example.dcmatch.model.ContestDetail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContestDetailService {

    @Autowired
    ContestDetailDao contestDetailDao;

    public List<ContestDetail> contestDetailList() {
        //根据 id 由小到大排序，只能用于数值型数据
        Sort sort = new Sort(Sort.Direction.ASC, "id");
        return contestDetailDao.findAll(sort);
    }

    //添加或更新比赛信息
    public ContestDetail addOrUpdateContestDetail(ContestDetail contestDetail) {
        return contestDetailDao.save(contestDetail);
    }

    //根据班级名称查询（模糊查询）
    public List<ContestDetail> findAllByContestTitleLike(String keywords) {
        return contestDetailDao.findAllByContestTitleLikeOrOrganizer_User_NameLike('%' + keywords + '%', '%' + keywords + '%');
    }

    //根据班级名称查询（精确查询）
    public ContestDetail findByContestTitle(String keywords) {
        return contestDetailDao.findByContestTitle(keywords);
    }

    public List<ContestDetail> findAllByOrganizerAccount(String keywords) {
        return contestDetailDao.findAllByOrganizer_User_Account(keywords);
    }


    //    通过 id 删除
    public void deleteById(int id) {
        contestDetailDao.deleteById(id);
    }

    //    通过  id 查询
    public ContestDetail findById(int id){
        return contestDetailDao.findById(id);
    }

    public boolean isExist(int id) {
        ContestDetail mClass = findById(id);
        return null!=mClass;
    }


}
