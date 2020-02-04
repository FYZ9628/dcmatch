package com.example.dcmatch.service;

import com.example.dcmatch.dao.GradeDao;
import com.example.dcmatch.model.Grade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GradeService {

    @Autowired
    GradeDao gradeDao;

    public List<Grade> gradeList() {
        //根据 id 由小到大排序，只能用于数值型数据
        Sort sort = new Sort(Sort.Direction.ASC, "id");
        return gradeDao.findAll(sort);
    }

    //添加或更新年级信息
    public Grade addOrUpdateGrade(Grade grade) {
        return gradeDao.save(grade);
    }

    //根据年级名称查询
    public List<Grade> findAllByGradeNumberLike(String keywords) {
        return gradeDao.findAllByGradeNumberLike('%' + keywords + '%');
    }

    //    通过 id 删除
    public void deleteById(int id) {
        gradeDao.deleteById(id);
    }

    //    通过  id 查询
    public Grade findById(int id){
        return gradeDao.findById(id);
    }

    public boolean isExist(int id) {
        Grade grade = findById(id);
        return null!=grade;
    }


}
