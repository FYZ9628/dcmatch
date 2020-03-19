package com.example.dcmatch.controller;

import com.example.dcmatch.result.ImagePath;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.Random;

/**
 * 控制层  转发调用
 */
@CrossOrigin
@RestController
public class UploadImgController {

    @PostMapping("/api/upLoadImg")
    public String coversUpload(MultipartFile file) {
        String folder = "D:/workspace/img/dcmatch";
        File imageFolder = new File(folder);
        File f = new File(imageFolder, getRandomString(6) + file.getOriginalFilename()
                .substring(file.getOriginalFilename().length() - 4));
        if (!f.getParentFile().exists())
            f.getParentFile().mkdirs();
        try {
            file.transferTo(f);
            String imgURL = "http://localhost:8999/api/file/" + f.getName();
            return imgURL;
        } catch (IOException e) {
            e.printStackTrace();
            return "";
        }
    }

    public String getRandomString(int length) {
        String base = "abcdefghijklmnopqrstuvwxyz0123456789";
        Random random = new Random();
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < length; i++) {
            int number = random.nextInt(base.length());
            sb.append(base.charAt(number));
        }
        return sb.toString();
    }

    //删除图片文件，只是删除文件，不删除数据库信息
    //    RequestBody 传参的model不能有其它构造函数，要有无参构造函数（默认会有）
    @PostMapping("/api/deleteImg")
    public String delFile(@RequestBody ImagePath imagePath) throws Exception  {
        //上篇中前端穿过来的是/imctemp-rainy/*.jpg格式的，只需要取出最后的文件名，写死路径，就可以准确找到文件了
        //前端页面处理路径，
        //var imgpath=path.split("/");
        //imgpath = imgpath[imgpath.length-1];
        String resultInfo = null;
        int lastIndexOf = imagePath.getImagePath().lastIndexOf("/");
        String img_path = imagePath.getImagePath().substring(lastIndexOf + 1,
                imagePath.getImagePath().length());
        img_path = "D:/workspace/img/dcmatch/" + img_path;
        File file = new File(img_path);
        if (file.exists()) {//文件是否存在
            file.delete();
        } else {
            resultInfo = "文件不存在！";
        }
        return resultInfo;
    }


}
