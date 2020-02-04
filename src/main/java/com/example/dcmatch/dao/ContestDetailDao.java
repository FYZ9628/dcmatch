package com.example.dcmatch.dao;

import com.example.dcmatch.model.Academy;
import com.example.dcmatch.model.ContestDetail;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ContestDetailDao extends JpaRepository<ContestDetail,Integer> {

    List<ContestDetail> findAllByContestTitleLike(String contestTitle);

    ContestDetail findById(int id);
}
