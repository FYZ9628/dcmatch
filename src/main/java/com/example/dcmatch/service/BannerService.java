package com.example.dcmatch.service;

import com.example.dcmatch.dao.BannerDao;
import com.example.dcmatch.model.Banner;
import com.example.dcmatch.model.Notice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BannerService {
    @Autowired
    BannerDao bannerDao;

    public List<Banner> noticeList() {
        //根据 id 由小到大排序，只能用于数值型数据
        Sort sort = new Sort(Sort.Direction.ASC, "id");
        return bannerDao.findAll(sort);
    }

    //添加或更新轮播图信息
    public Banner addOrUpdateClass(Banner banner) {
        return bannerDao.save(banner);
    }

    //根据轮播图名称查询
    public List<Banner> findAllByNameLike(String keywords) {
        return bannerDao.findAllByNameLike('%' + keywords + '%');
    }

    //    通过 id 删除
    public void deleteById(int id) {
        bannerDao.deleteById(id);
    }

    //    通过  id 查询
    public Banner findById(int id){
        return bannerDao.findById(id);
    }

    public boolean isExist(int id) {
        Banner banner = findById(id);
        return null!=banner;
    }
}
