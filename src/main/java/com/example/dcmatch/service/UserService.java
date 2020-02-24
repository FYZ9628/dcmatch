package com.example.dcmatch.service;

import com.example.dcmatch.dao.UserDao;
import com.example.dcmatch.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    UserDao userDao;

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

    public boolean phoneIsExist(String phone) {
        User user = getByPhone(phone);
        return null!=user;
    }

    public User getByPhone(String phone) {
        return userDao.findByPhone(phone);
    }

    public User getByPhoneAndPassword(String phone, String password){
        return userDao.getByPhoneAndPassword(phone, password);
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
