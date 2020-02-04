package com.example.dcmatch.dao;

import com.example.dcmatch.model.Academy;
import com.example.dcmatch.model.Grade;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface GradeDao extends JpaRepository<Grade,Integer> {

    List<Grade> findAllByGradeNumberLike(String gradeName);

    Grade findById(int id);
}
