package com.atguigu.system;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;

/**
 * 权限服务启动类
 *
 * @author 陈江林
 * @date 2022/11/10 11:59
 */
@SpringBootApplication
@MapperScan("com.atguigu.system.mapper")
@ComponentScan(basePackages = "com.atguigu")
@EnableDiscoveryClient
public class ServiceAuthApplication {

    public static void main(String[] args) {
        SpringApplication.run(ServiceAuthApplication.class, args);
    }

}
