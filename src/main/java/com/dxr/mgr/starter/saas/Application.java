package com.dxr.mgr.starter.saas;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

/**
 * Created by dongyang.wang on 2018/4/2 0002 .
 */

@SpringBootApplication(scanBasePackages = {"com.dxr.mgr"})
@MapperScan(basePackages = {"com.dxr.mgr.dao.saas.mapper"})
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

}
