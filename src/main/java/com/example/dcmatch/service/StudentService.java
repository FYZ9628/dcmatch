package com.example.dcmatch.service;

import com.example.dcmatch.dao.StudentDao;
import com.example.dcmatch.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {
    @Autowired
    StudentDao studentDao;

    public List<Student> studentList() {
        //根据 id 由小到大排序，只能用于数值型数据
        Sort sort = new Sort(Sort.Direction.ASC, "id");
        return studentDao.findAll(sort);
    }

    //添加或更新学生信息
    public Student addOrUpStudent(Student student) {
        return studentDao.save(student);
    }


    //根据姓名或账号查询
    public List<Student> findAllByNameLikeOrUser_AccountLike(String keywords) {
        return studentDao.findAllByNameLikeOrUser_AccountLike('%'
                + keywords + '%', '%' + keywords + '%');
    }


    //    通过 id 删除
    public void deleteById(int id) {
        studentDao.deleteById(id);
    }

    //    通过  id 查询
    public Student findById(int id){
        return studentDao.findById(id);
    }


    //    通过  account 查询
    public Student findByUser_Account(String account){
        return studentDao.findByUser_Account(account);
    }

    //    通过  班级 id 查询
    public Student findByMClass_Id(int id){
        return studentDao.findByMClass_Id(id);
    }


    //    通过  班级 id 查询
    public List<Student> findAllByMClass_Id(int id){
        return studentDao.findAllByMClass_Id(id);
    }



}
