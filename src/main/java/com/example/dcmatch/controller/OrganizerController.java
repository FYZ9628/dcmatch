package com.example.dcmatch.controller;

import com.example.dcmatch.model.Organizer;
import com.example.dcmatch.result.Result;
import com.example.dcmatch.result.Search;
import com.example.dcmatch.service.OrganizerService;
import com.example.dcmatch.service.UserService;
import io.swagger.annotations.ApiImplicitParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 控制层  转发调用
 */
@CrossOrigin
@RestController
public class OrganizerController {
    //用Resource 注解也可以
    //  警告 Field injection is not recommended  的解决方法  百度
    @Autowired
    OrganizerService organizerService;

    @Autowired
    UserService userService;

    @GetMapping("/api/getAllOrganizer")
    public List<Organizer> getAllOrganizer() throws Exception {
        return organizerService.organizerList();
    }

    @GetMapping("/api/organizerInfo")
    public List<Organizer> organizerList() throws Exception {
        return organizerService.organizerList();
    }

    @PostMapping("/api/searchOrganizer")
    public List<Organizer> organizerFindAllByUser_NameLikeOrUser_AccountLike(@RequestBody Search s) throws Exception {

        return organizerService.findAllByUser_NameLikeOrUser_AccountLike(s.getKeywords());
    }


    @PostMapping("/api/searchOrganizerByAccount")
    public Organizer getOrganizerByUser_Account(@RequestBody Search s) throws Exception {

        return organizerService.getByUser_Account(s.getKeywords());
    }

    @PostMapping("/api/addOrganizer")
    public Organizer addOrganizer(@RequestBody Organizer organizer) throws Exception {

        boolean bl = userService.accountIsExist(organizer.getUser().getAccount());
        if (bl == true){
            return null;
        }else {
            userService.add(organizer.getUser());
            organizer = organizerService.addOrUpTeacher(organizer);

            return organizer;
        }
    }

    @PostMapping("/api/updateOrganizer")
    public Organizer updateOrganizer(@RequestBody Organizer organizer) throws Exception {

        boolean bl = userService.accountIsExist(organizer.getUser().getAccount());
        if (bl == true){
            userService.add(organizer.getUser());
            organizer = organizerService.addOrUpTeacher(organizer);
            return organizer;
        }else {
            return null;
        }

    }

    @PostMapping("/api/deleteOrganizer")
    public Result deleteTeacher(@RequestBody Organizer organizerId) throws Exception {
        //因为前端只是传了一个 id 过来，所以 teacherId 里面只有一个 id 没有其他信息
        //所以要再通过 id 查询 teacher 的其他信息
        Organizer organizer = organizerService.findById(organizerId.getId());
        if (organizer != null){
            organizerService.deleteById(organizerId.getId());
            userService.deleteById(organizer.getUser().getId());
            //   删除成功返回码 100
            return new Result(100);
        } else {
            //   删除失败返回码 400
            return new Result(400);
        }
    }

    //-------------------------------------- 没有用到的 -------------------------------------------------
    @ApiImplicitParam(name = "param", value = "查询举办方", required = true, dataType = "String", paramType = "query")
    @PostMapping(value = "/api/searchOrganizer2")
    public List<Organizer> searchOrganizer(@RequestParam(value = "param") String param) {
        return organizerService.findAllByUser_NameLikeOrUser_AccountLike(param);
    }
    //-------------------------------------- 没有用到的 -------------------------------------------------
}
