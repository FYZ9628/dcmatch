package com.example.dcmatch.dao;

import com.example.dcmatch.model.Register;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RegisterDao extends JpaRepository<Register,Integer> {

//    List<Register> findByPhoneLike(String phone);
    Register findByPhone(String phone);

    Register findById(int id);

}
