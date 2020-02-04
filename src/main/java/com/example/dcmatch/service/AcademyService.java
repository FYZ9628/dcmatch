package com.example.dcmatch.service;

import com.example.dcmatch.dao.AcademyDao;
import com.example.dcmatch.dao.ClassDao;
import com.example.dcmatch.model.Academy;
import com.example.dcmatch.model.Class;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AcademyService {

    @Autowired
    AcademyDao academyDao;

    public List<Academy> academyList() {
        //根据 id 由小到大排序，只能用于数值型数据
        Sort sort = new Sort(Sort.Direction.ASC, "id");
        return academyDao.findAll(sort);
    }

    //添加或更新学院信息
    public Academy addOrUpdateAcademy(Academy academy) {
        return academyDao.save(academy);
    }

    //根据学院名称查询
    public List<Academy> findAllByAcademyNameLike(String keywords) {
        return academyDao.findAllByAcademyNameLike('%' + keywords + '%');
    }

    //    通过 id 删除
    public void deleteById(int id) {
        academyDao.deleteById(id);
    }

    //    通过  id 查询
    public Academy findById(int id){
        return academyDao.findById(id);
    }

    public boolean isExist(int id) {
        Academy academy = findById(id);
        return null!=academy;
    }


}
