package com.example.dcmatch.service;

import com.example.dcmatch.dao.RegisterDao;
import com.example.dcmatch.model.Register;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RegisterService {

    @Autowired
    RegisterDao registerDao;

    public List<Register> registerList() {
        //根据 id 由小到大排序，只能用于数值型数据
        Sort sort = new Sort(Sort.Direction.ASC, "id");
        return registerDao.findAll(sort);
    }

    //添加或更新号码信息
    public Register addOrUpdatePhone(Register register) {
        return registerDao.save(register);
    }

    //根据号码查询
    public Register findByPhone(String keywords) {
        return registerDao.findByPhone(keywords);
    }

    //    通过 id 删除
    public void deleteById(int id) {
        registerDao.deleteById(id);
    }

    //    通过  id 查询
    public Register findById(int id){
        return registerDao.findById(id);
    }

    public boolean isExist(int id) {
        Register grade = findById(id);
        return null!=grade;
    }

    //    通过  phone 和 password 查询
    public Register getByPhoneAndPassword(String phone, String password){
        return registerDao.findByPhoneAndPassword(phone, password);
    }

    public boolean phoneIsExist(String phone) {
        Register grade = findByPhone(phone);
        return null!=grade;
    }
}
