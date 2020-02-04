package com.example.dcmatch.service;

import com.example.dcmatch.dao.OrganizerDao;
import com.example.dcmatch.model.Organizer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrganizerService {

    @Autowired
    OrganizerDao organizerDao;
    @Autowired
    UserService userService;

    public List<Organizer> organizerList() {
//        根据 id 由小到大排序，只能用于数值型数据
        Sort sort = new Sort(Sort.Direction.ASC,"id");
        return organizerDao.findAll(sort);
    }

    //添加或更新教师信息
    public Organizer addOrUpTeacher(Organizer teacher) {
        return organizerDao.save(teacher);
    }


    //根据姓名或账号查询
    public List<Organizer> findAllByNameLikeOrUser_AccountLike(String keywords) {
        return organizerDao.findAllByNameLikeOrUser_AccountLike('%'
                + keywords + '%', '%' + keywords + '%');
    }


    //    通过 id 删除
    public void deleteById(int id) {
        organizerDao.deleteById(id);
    }

    //    通过  id 查询
    public Organizer findById(int id){
        return organizerDao.findById(id);
    }


    //    通过  account 查询
    public Organizer findByUser_Account(String account){
        return organizerDao.findByUser_Account(account);
    }

}
