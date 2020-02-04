package com.example.dcmatch.service;

import com.example.dcmatch.dao.MajorDao;
import com.example.dcmatch.model.Major;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MajorService {

    @Autowired
    MajorDao majorDao;

    public List<Major> majorList() {
        //根据 id 由小到大排序，只能用于数值型数据
        Sort sort = new Sort(Sort.Direction.ASC, "id");
        return majorDao.findAll(sort);
    }

    //添加或更新专业信息
    public Major addOrUpdateMajor(Major major) {
        return majorDao.save(major);
    }

    //根据专业名称查询
    public List<Major> findAllByMajorNameLike(String keywords) {
        return majorDao.findAllByMajorNameLike('%' + keywords + '%');
    }

    //    通过 id 删除
    public void deleteById(int id) {
        majorDao.deleteById(id);
    }

    //    通过  id 查询
    public Major findById(int id){
        return majorDao.findById(id);
    }

    public boolean isExist(int id) {
        Major grade = findById(id);
        return null!=grade;
    }


}
