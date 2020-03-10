package com.example.dcmatch.dao;

import com.example.dcmatch.model.Organizer;
import com.example.dcmatch.model.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrganizerDao extends JpaRepository<Organizer,Integer> {

    List<Organizer> findAllByUser_NameLikeOrUser_AccountLike(String name, String account);

    Organizer findById(int id);

    Organizer getByUser_Account(String account);
}
