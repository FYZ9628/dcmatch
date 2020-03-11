package com.example.dcmatch.controller.login;

import com.example.dcmatch.model.Register;
import com.example.dcmatch.result.Result;
import com.example.dcmatch.result.Search;
import com.example.dcmatch.service.RegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 控制层  转发调用
 */
@CrossOrigin
@RestController
public class RegisterController {

    @Autowired
    RegisterService registerService;

    @GetMapping("/api/getAllRegister")
    public List<Register> getAllMajor() throws Exception {
        return registerService.registerList();
    }

    @PostMapping("/api/searchRegister")
    public Register findByPhone(@RequestBody Search s) throws Exception {

        return registerService.findByPhone(s.getKeywords());
    }


    @PostMapping("/api/addRegister")
    public Result addRegister(@RequestBody Register register) throws Exception {

        boolean bl = registerService.phoneIsExist(register.getPhone());
        if (bl == true){
            return null;
        }else {

            register = registerService.addOrUpdatePhone(register);

            return new Result(200);
        }
    }


    @PostMapping("/api/updateRegister")
    public Register updateRegister(@RequestBody Register register) throws Exception {

//        boolean bl = registerService.isExist(register.getId());
        boolean bl = registerService.phoneIsExist(register.getPhone());
        if (bl == true){
            register = registerService.addOrUpdatePhone(register);
            return register;
        }else {
            return null;
        }
    }


    @PostMapping("/api/deleteRegister")
    public Result deleteRegister(@RequestBody Register registerId) throws Exception {
        //因为前端只是传了一个 id 过来，所以 teacherId 里面只有一个 id 没有其他信息
        //所以要再通过 id 查询 teacher 的其他信息
        Register register = registerService.findById(registerId.getId());
        if (register != null){
            registerService.deleteById(registerId.getId());
            //   删除成功返回码 100
            return new Result(100);
        } else {
            //   删除失败返回码 400
            return new Result(400);
        }
    }

}
