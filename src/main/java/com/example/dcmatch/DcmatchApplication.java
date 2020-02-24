package com.example.dcmatch;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
//@ComponentScan(basePackages = {"com.example.dcmatch.controller","com.example.dcmatch.service"})
//因为访问本地资源（图片）的时候访问不了，所以注释了
//发现之前swager 的注释也显示不了（不起作用）的原因也是因为这个语句
public class DcmatchApplication {

    public static void main(String[] args) {
        SpringApplication.run(DcmatchApplication.class, args);
    }

}
