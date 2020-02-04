package com.example.dcmatch.service;

import com.example.dcmatch.dao.UserDao;
import com.example.dcmatch.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    UserDao userDao;

    public boolean isExist(String account) {
        User user = getByAccount(account);
        return null!=user;
    }

    public User getByAccount(String account) {
        return userDao.findByAccount(account);
    }

    public User get(String account, String password){
        return userDao.getByAccountAndPassword(account, password);
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
