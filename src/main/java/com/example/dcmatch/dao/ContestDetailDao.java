package com.example.dcmatch.dao;

import com.example.dcmatch.model.Academy;
import com.example.dcmatch.model.Contest;
import com.example.dcmatch.model.ContestDetail;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ContestDetailDao extends JpaRepository<ContestDetail,Integer> {

    List<ContestDetail> findAllByContestTitleLikeOrOrganizer_User_NameLike(String contestTitle, String organizerName);

    List<ContestDetail> findAllByOrganizer_User_Account(String account);

    ContestDetail findById(int id);

    ContestDetail findByContestTitle(String contestTitle);
}
