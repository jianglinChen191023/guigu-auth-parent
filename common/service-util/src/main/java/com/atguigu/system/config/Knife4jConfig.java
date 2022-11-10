package com.atguigu.system.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.ParameterBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.Parameter;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2WebMvc;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

/**
 * Swagger 集成 Knife4j 配置类
 *
 * @author 陈江林
 * @date 2022/11/10 16:48
 */
@Configuration
@EnableSwagger2WebMvc
public class Knife4jConfig {

    @Bean(value = "dockerBean")
    public Docket dockerBean() {
        // 指定使用Swagger2规范
        Docket docket = new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(new ApiInfoBuilder()
                        // 描述字段支持Markdown语法
                        .title("后台管理系统-API文档")
                        .description("本文档描述了后台管理系统微服务接口定义")
                        .termsOfServiceUrl("https://doc.xiaominfo.com/")
                        .contact("xiaoymin@foxmail.com")
                        .version("1.0")
                        .build())
                // 分组名称
                .groupName("adminApi")
                .select()
                // 这里指定 Controller 扫描包路径
                .apis(RequestHandlerSelectors.basePackage("com.atguigu"))
//                .paths(PathSelectors.any())
                .paths(PathSelectors.regex("/admin/.*"))
                .build()
                // 请求消息头
                .globalOperationParameters(
                        ((Supplier<List<Parameter>>) () -> {
                            List<Parameter> list = new ArrayList<>();
                            list.add(new ParameterBuilder()
                                    .name("token")
                                    .description("用户token")
                                    .defaultValue("")
                                    .modelRef(new ModelRef("string"))
                                    .parameterType("header")
                                    .required(false)
                                    .build());
                            return list;
                        }).get()
                );
        return docket;
    }

}
