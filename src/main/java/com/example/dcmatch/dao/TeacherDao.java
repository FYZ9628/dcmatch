package com.example.dcmatch.dao;

import com.example.dcmatch.model.Student;
import com.example.dcmatch.model.Teacher;
import com.example.dcmatch.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TeacherDao extends JpaRepository<Teacher, Integer> {

    List<Teacher> findAllByUser_NameLikeOrUser_AccountLike(String name, String account);

    Teacher findById(int id);

    Teacher getByUser_Account(String account);

}