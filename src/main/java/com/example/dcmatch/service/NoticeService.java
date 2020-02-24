package com.example.dcmatch.service;

import com.example.dcmatch.dao.NoticeDao;
import com.example.dcmatch.model.Notice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NoticeService {

    @Autowired
    NoticeDao noticeDao;

    public List<Notice> noticeList() {
        //根据 id 由小到大排序，只能用于数值型数据
        Sort sort = new Sort(Sort.Direction.ASC, "id");
        return noticeDao.findAll(sort);
    }

    //添加或更新通知信息
    public Notice addOrUpdateClass(Notice notice) {
        return noticeDao.save(notice);
    }

    //根据通知名称查询
    public List<Notice> findAllByTitleLike(String keywords) {
        return noticeDao.findAllByTitleLike('%' + keywords + '%');
    }

    //    通过 id 删除
    public void deleteById(int id) {
        noticeDao.deleteById(id);
    }

    //    通过  id 查询
    public Notice findById(int id){
        return noticeDao.findById(id);
    }

    public boolean isExist(int id) {
        Notice notice = findById(id);
        return null!=notice;
    }


}
