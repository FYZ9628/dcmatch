package com.example.dcmatch.dao;

import com.example.dcmatch.model.Notice;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface NoticeDao extends JpaRepository<Notice,Integer> {

    List<Notice> findAllByTitleLike(String title);

    Notice findById(int id);
}