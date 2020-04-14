package com.example.dcmatch.service;

import com.example.dcmatch.dao.SchoolDao;
import com.example.dcmatch.model.School;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SchoolService {

    @Autowired
    SchoolDao schoolDao;

    public List<School> schoolList() {
        //根据 id 由小到大排序，只能用于数值型数据
        Sort sort = new Sort(Sort.Direction.ASC, "id");
        return schoolDao.findAll(sort);
    }

    //添加或更新学校信息
    public School addOrUpdateSchool(School school) {
        return schoolDao.save(school);
    }

    //根据学校名称查询
    public List<School> findAllByNameLike(String keywords) {
        return schoolDao.findAllByNameLike('%' + keywords + '%');
    }

    //    通过 id 删除
    public void deleteById(int id) {
        schoolDao.deleteById(id);
    }

    //    通过  id 查询
    public School findById(int id){
        return schoolDao.findById(id);
    }

    public boolean isExist(int id) {
        School school = findById(id);
        return null!=school;
    }


}
