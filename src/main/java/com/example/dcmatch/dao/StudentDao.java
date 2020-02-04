package com.example.dcmatch.dao;

import com.example.dcmatch.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StudentDao extends JpaRepository<Student,Integer> {

    List<Student> findAllByNameLikeOrUser_AccountLike(String name, String account);

    Student findById(int id);

    Student findByUser_Account(String account);

    Student findByMClass_Id(int id);

    List<Student> findAllByMClass_Id(int id);

}
