package com.example.dcmatch.dao;

import com.example.dcmatch.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StudentDao extends JpaRepository<Student,Integer> {

    List<Student> findAllByUser_NameLikeOrUser_AccountLike(String name, String account);

    Student findById(int id);

    Student findByUser_Account(String account);

}
