package com.example.dcmatch.service;

import com.example.dcmatch.dao.UserDao;
import com.example.dcmatch.model.School;
import com.example.dcmatch.model.Student;
import com.example.dcmatch.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    UserDao userDao;

    public List<User> userList() {
        //根据 id 由小到大排序，只能用于数值型数据
        Sort sort = new Sort(Sort.Direction.ASC, "id");
        return userDao.findAll(sort);
    }

    public boolean accountIsExist(String account) {
        User user = getByAccount(account);
        return null!=user;
    }

    public User getByAccount(String account) {
        return userDao.findByAccount(account);
    }

    public User getByAccountAndPassword(String account, String password){
        return userDao.getByAccountAndPassword(account, password);
    }

    public User getByAccountAndName(String account, String name){
        return userDao.getByAccountAndName(account, name);
    }

    public boolean phoneIsExist(String phone) {
        User user = getByPhone(phone);
        return null!=user;
    }

    public User getByPhone(String phone) {
        return userDao.findByPhone(phone);
    }

    //根据用户姓名查询
    public List<User> findAllByNameLike(String keywords) {
        return userDao.findAllByNameLike('%' + keywords + '%');
    }

    //    通过  id 查询
    public User findById(int id){
        return userDao.findById(id);
    }

    public User getByPhoneAndPassword(String phone, String password){
        return userDao.getByPhoneAndPassword(phone, password);
    }

    public User getByPhoneAndName(String phone, String name){
        return userDao.getByPhoneAndName(phone, name);
    }

    public void add(User user) {
        userDao.save(user);
    }

    public User addOrUpdateUser(User user) {
        return userDao.save(user);
    }

    //    通过 id 删除
    public void deleteById(int id) {
        userDao.deleteById(id);
    }

}
