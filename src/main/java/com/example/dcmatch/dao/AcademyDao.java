package com.example.dcmatch.dao;

import com.example.dcmatch.model.Academy;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AcademyDao extends JpaRepository<Academy,Integer> {

    List<Academy> findAllByAcademyNameLike(String academyName);

    Academy findById(int id);
}
