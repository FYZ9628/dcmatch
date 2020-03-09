package com.example.dcmatch.service;

import com.example.dcmatch.dao.StudentDao;
import com.example.dcmatch.dao.TeacherDao;
import com.example.dcmatch.model.Student;
import com.example.dcmatch.model.Teacher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeacherService {
    @Autowired
    TeacherDao teacherDao;

    public List<Teacher> teacherList() {
        //根据 id 由小到大排序，只能用于数值型数据
        Sort sort = new Sort(Sort.Direction.ASC, "id");
        return teacherDao.findAll(sort);
    }

    //添加或更新学生信息
    public Teacher addOrUpStudent(Teacher teacher) {
        return teacherDao.save(teacher);
    }


    //根据姓名或账号查询
    public List<Teacher> findAllByUser_NameLikeOrUser_AccountLike(String keywords) {
        return teacherDao.findAllByUser_NameLikeOrUser_AccountLike('%'
                + keywords + '%', '%' + keywords + '%');
    }


    //    通过 id 删除
    public void deleteById(int id) {
        teacherDao.deleteById(id);
    }

    //    通过  id 查询
    public Teacher findById(int id){
        return teacherDao.findById(id);
    }


    //    通过  account 查询
    public Teacher findByUser_Account(String account){
        return teacherDao.findByUser_Account(account);
    }

}
