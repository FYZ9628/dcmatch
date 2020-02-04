package com.example.dcmatch.dao;

import com.example.dcmatch.model.Class;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ClassDao extends JpaRepository<Class,Integer> {

    List<Class> findAllByClassNameLike(String className);

    Class findById(int id);
}
