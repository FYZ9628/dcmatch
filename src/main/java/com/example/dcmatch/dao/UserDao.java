package com.example.dcmatch.dao;

import com.example.dcmatch.model.School;
import com.example.dcmatch.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserDao extends JpaRepository<User, Integer> {

    User findById(int id);

    User findByAccount(String account);

    User getByAccountAndPassword(String account,String password);

    User findByPhone(String phone);

    User getByPhoneAndPassword(String phone, String password);

    List<User> findAllByNameLike(String name);

}
