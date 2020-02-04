package com.example.dcmatch;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
@ComponentScan(basePackages = {"com.example.dcmatch.controller","com.example.dcmatch.service"})
public class DcmatchApplication {

    public static void main(String[] args) {
        SpringApplication.run(DcmatchApplication.class, args);
    }

}
