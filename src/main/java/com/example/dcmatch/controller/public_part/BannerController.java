package com.example.dcmatch.controller.public_part;

import com.example.dcmatch.model.Banner;
import com.example.dcmatch.model.Notice;
import com.example.dcmatch.result.Result;
import com.example.dcmatch.result.Search;
import com.example.dcmatch.service.BannerService;
import com.example.dcmatch.service.NoticeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 控制层  转发调用
 */
@CrossOrigin
@RestController
public class BannerController {
    @Autowired
    BannerService bannerService;

    @GetMapping("/api/getAllBanner")
    public List<Banner> getAllBanner() throws Exception {
        return bannerService.noticeList();
    }

    @PostMapping("/api/searchBanner")
    public List<Banner> findAllByNameLike(@RequestBody Search s) throws Exception {

        return bannerService.findAllByNameLike(s.getKeywords());
    }

    @PostMapping("/api/addBanner")
    public Banner addClass(@RequestBody Banner banner) throws Exception {

        boolean bl = bannerService.isExist(banner.getId());
        if (bl == true){
            return null;
        }else {

            banner = bannerService.addOrUpdateClass(banner);

            return banner;
        }
    }


    @PostMapping("/api/updateBanner")
    public Banner updateStudent(@RequestBody Banner banner) throws Exception {

        boolean bl = bannerService.isExist(banner.getId());
        if (bl == true){
            banner = bannerService.addOrUpdateClass(banner);
            return banner;
        }else {
            return null;
        }
    }

    @PostMapping("/api/deleteBanner")
    public Result deleteStudent(@RequestBody Banner bannerId) throws Exception {
        //因为前端只是传了一个 id 过来，所以 teacherId 里面只有一个 id 没有其他信息
        //所以要再通过 id 查询 teacher 的其他信息
        Banner banner = bannerService.findById(bannerId.getId());
        if (banner != null){
            bannerService.deleteById(bannerId.getId());
            //   删除成功返回码 100
            return new Result(100);
        } else {
            //   删除失败返回码 400
            return new Result(400);
        }
    }
}
