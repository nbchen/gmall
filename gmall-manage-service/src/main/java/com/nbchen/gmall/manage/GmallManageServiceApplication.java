package com.nbchen.gmall.manage;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import tk.mybatis.spring.annotation.MapperScan;

/**
 * @author nbchen
 * @date 2019/08/31
 */
@SpringBootApplication
@MapperScan(basePackages = "com.nbchen.gmall.manage.mapper")
public class GmallManageServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(GmallManageServiceApplication.class,args);
    }
}
