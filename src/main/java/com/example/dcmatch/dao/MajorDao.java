package com.example.dcmatch.dao;

import com.example.dcmatch.model.Academy;
import com.example.dcmatch.model.Major;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MajorDao extends JpaRepository<Major,Integer> {

    List<Major> findAllByMajorNameLike(String majorName);

    Major findById(int id);
}
