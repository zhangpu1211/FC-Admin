package org.fcadmin;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import tk.mybatis.spring.annotation.MapperScan;

@SpringBootApplication(scanBasePackages = {"org.fcadmin","org.fcadmin.exception"})
//扫描mybatis mapper
@MapperScan(basePackages = "org.fcadmin.mapper")
public class FcadminApplication {

    public static void main(String[] args) {
        SpringApplication.run(FcadminApplication.class, args);
    }

}
