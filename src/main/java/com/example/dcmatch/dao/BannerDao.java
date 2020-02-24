package com.example.dcmatch.dao;

import com.example.dcmatch.model.Banner;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BannerDao extends JpaRepository<Banner,Integer> {

    List<Banner> findAllByNameLike(String name);

    Banner findById(int id);
}
