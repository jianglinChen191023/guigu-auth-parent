package com.atguigu.system;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

/**
 * 权限服务启动类
 * `@EnableCircuitBreaker`: 开启断路器功能
 * `@EnableFeignClients` 启用 Feign 客户端功能
 * `@EnableDiscoveryClient` 当前版本可以不写
 *
 * @author 陈江林
 * @date 2022/11/10 11:59
 */
@SpringBootApplication
@MapperScan("com.atguigu.system.mapper")
@ComponentScan(basePackages = "com.atguigu")
@EnableFeignClients(basePackages = "com.atguigu")
@EnableCircuitBreaker
public class ServiceAuthApplication {

    public static void main(String[] args) {
        SpringApplication.run(ServiceAuthApplication.class, args);
    }

}
