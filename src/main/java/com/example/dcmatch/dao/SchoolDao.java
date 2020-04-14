package com.example.dcmatch.dao;

import com.example.dcmatch.model.School;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SchoolDao extends JpaRepository<School,Integer> {

    List<School> findAllByNameLike(String className);

    School findById(int id);
}