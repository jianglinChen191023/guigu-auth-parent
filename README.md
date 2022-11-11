- [一 搭建环境](#一-搭建环境)
    - [1 项目介绍](#1-项目介绍)
        - [1.2 核心技术](#12-核心技术)
        - [1.3 项目模块](#13-项目模块)
        - [1.4 项目演示地址](#14-项目演示地址)
        - [1.5 数据库设计](#15-数据库设计)
    - [2 搭建环境](#2-搭建环境)
        - [2.1 搭建项目结构](#21-搭建项目结构)
            - [2.1.1 搭建父工程 `guigu-auth-parent`](#211-搭建父工程-guigu-auth-parent)
            - [2.1.2 `common`](#212-common)
            - [2.1.3 `common-log`](#213-common-log)
            - [2.1.4 `common-util`](#214-common-util)
            - [2.1.5 `service-util`](#215-service-util)
            - [2.1.6 `spring-security`](#216-spring-security)
            - [2.1.7 `model`](#217-model)
            - [2.1.8 `service`](#218-service)
            - [!img](#)
            - [2.1.9 `service-system`](#219-service-system)
        - [2.2 配置依赖关系](#22-配置依赖关系)
            - [2.2.1 父工程依赖](#221-父工程依赖)
            - [2.2.2 `common` 无依赖](#222-common-无依赖)
            - [2.2.3 `common-log` 依赖](#223-common-log-依赖)
            - [2.2.4 `common-util` 依赖](#224-common-util-依赖)
            - [2.2.5 `service-util` 依赖](#225-service-util-依赖)
            - [2.2.6 `spring-security` 依赖](#226-spring-security-依赖)
            - [2.2.7 `model` 依赖](#227-model-依赖)
            - [2.2.8 `service` 无依赖](#228-service-无依赖)
            - [2.2.9 `service-system` 依赖](#229-service-system-依赖)
        - [2.3 确保 `github` 上项目结构的完整](#23-确保-github-上项目结构的完整)
    - [3 使用 `Mybatis-plus`](#3-使用-mybatis-plus)
        - [3.1 依赖<已引入>](#31-依赖已引入)
        - [3.2 配置文件](#32-配置文件)
        - [3.3 启动类](#33-启动类)
        - [3.4 新建 `Mapper` 接口](#34-新建-mapper-接口)
        - [3.5 新建测试类](#35-新建测试类)
        - [3.6 新建服务接口类](#36-新建服务接口类)
        - [3.7 新建服务实现类](#37-新建服务实现类)
        - [3.8 新建测试类](#38-新建测试类)
    - [4 整合 `swagger2`](#4-整合-swagger2)
        - [4.1 集成 `knife4j`](#41-集成-knife4j)
            - [4.1.1 第一步 添加依赖包](#411-第一步-添加依赖包)
            - [4.1.2 添加`knife4j`配置](#412-添加knife4j配置)
        - [4.2 新建控制类, 使用 `swagger`注解](#42-新建控制类-使用-swagger注解)
        - [4.3 测试](#43-测试)
    - [5 统一返回结果类](#5-统一返回结果类)
        - [5.1 新建 `Result`](#51-新建-result)
        - [5.2 新建 `ResultCodeEnum`](#52-新建-resultcodeenum)
        - [5.3 修改角色管理控制类](#53-修改角色管理控制类)
    - [6 角色管理接口](#6-角色管理接口)
        - [6.1 实体类](#61-实体类)
            - [6.1.1 通用属性类 `BaseEntity`](#611-通用属性类-baseentity)
            - [6.1.2 角色实体类`SysRole`](#612-角色实体类sysrole)
            - [6.1.2 角色查询条件视图类 `SysRoleQueryVo`](#612-角色查询条件视图类-sysrolequeryvo)
        - [6.2 条件分页查询](#62-条件分页查询)
            - [6.2.1 分页插件](#621-分页插件)
            - [6.2.2 控制类](#622-控制类)
            - [6.2.3 服务接口类](#623-服务接口类)
            - [6.2.4 服务实现类](#624-服务实现类)
            - [6.2.5 `Mapper`接口](#625-mapper接口)
            - [6.2.6 `Mapper.xml`](#626-mapperxml)
        - [6.3 角色添加](#63-角色添加)
        - [6.4 角色修改](#64-角色修改)
        - [6.5 批量删除](#65-批量删除)
    - [7 统一异常处理](#7-统一异常处理)
        - [7.1 新建全局异常处理类 `GlobalExceptionHandler`](#71-新建全局异常处理类-globalexceptionhandler)
            - [7.1.1 测试](#711-测试)
        - [7.2 特定异常处理](#72-特定异常处理)
            - [7.2.1 测试](#721-测试)
        - [7.3 自定义异常处理](#73-自定义异常处理)
            - [7.3.1 新建 `GuiguException`](#731-新建-guiguexception)
            - [7.3.2 测试](#732-测试)
    - [1 项目介绍](#1-项目介绍-1)
        - [1.2 核心技术](#12-核心技术-1)
        - [1.3 项目模块](#13-项目模块-1)
        - [1.4 项目演示地址](#14-项目演示地址-1)
        - [1.5 数据库设计](#15-数据库设计-1)
    - [2 搭建环境](#2-搭建环境-1)
        - [2.1 搭建项目结构](#21-搭建项目结构-1)
            - [2.1.1 搭建父工程 `guigu-auth-parent`](#211-搭建父工程-guigu-auth-parent-1)
            - [2.1.2 `common`](#212-common-1)
            - [2.1.3 `common-log`](#213-common-log-1)
            - [2.1.4 `common-util`](#214-common-util-1)
            - [2.1.5 `service-util`](#215-service-util-1)
            - [2.1.6 `spring-security`](#216-spring-security-1)
            - [2.1.7 `model`](#217-model-1)
            - [2.1.8 `service`](#218-service-1)
            - [!img](#-1)
            - [2.1.9 `service-system`](#219-service-system-1)
        - [2.2 配置依赖关系](#22-配置依赖关系-1)
            - [2.2.1 父工程依赖](#221-父工程依赖-1)
            - [2.2.2 `common` 无依赖](#222-common-无依赖-1)
            - [2.2.3 `common-log` 依赖](#223-common-log-依赖-1)
            - [2.2.4 `common-util` 依赖](#224-common-util-依赖-1)
            - [2.2.5 `service-util` 依赖](#225-service-util-依赖-1)
            - [2.2.6 `spring-security` 依赖](#226-spring-security-依赖-1)
            - [2.2.7 `model` 依赖](#227-model-依赖-1)
            - [2.2.8 `service` 无依赖](#228-service-无依赖-1)
            - [2.2.9 `service-system` 依赖](#229-service-system-依赖-1)
        - [2.3 确保 `github` 上项目结构的完整](#23-确保-github-上项目结构的完整-1)
    - [3 使用 `Mybatis-plus`](#3-使用-mybatis-plus-1)
        - [3.1 依赖<已引入>](#31-依赖已引入-1)
        - [3.2 配置文件](#32-配置文件-1)
        - [3.3 启动类](#33-启动类-1)
        - [3.4 新建 `Mapper` 接口](#34-新建-mapper-接口-1)
        - [3.5 新建测试类](#35-新建测试类-1)
        - [3.6 新建服务接口类](#36-新建服务接口类-1)
        - [3.7 新建服务实现类](#37-新建服务实现类-1)
        - [3.8 新建测试类](#38-新建测试类-1)
    - [4 整合 `swagger2`](#4-整合-swagger2-1)
        - [4.1 集成 `knife4j`](#41-集成-knife4j-1)
            - [4.1.1 第一步 添加依赖包](#411-第一步-添加依赖包-1)
            - [4.1.2 添加`knife4j`配置](#412-添加knife4j配置-1)
        - [4.2 新建控制类, 使用 `swagger`注解](#42-新建控制类-使用-swagger注解-1)
        - [4.3 测试](#43-测试-1)
    - [5 统一返回结果类](#5-统一返回结果类-1)
        - [5.1 新建 `Result`](#51-新建-result-1)
        - [5.2 新建 `ResultCodeEnum`](#52-新建-resultcodeenum-1)
        - [5.3 修改角色管理控制类](#53-修改角色管理控制类-1)
    - [6 角色管理接口](#6-角色管理接口-1)
        - [6.1 实体类](#61-实体类-1)
            - [6.1.1 通用属性类 `BaseEntity`](#611-通用属性类-baseentity-1)
            - [6.1.2 角色实体类`SysRole`](#612-角色实体类sysrole-1)
            - [6.1.2 角色查询条件视图类 `SysRoleQueryVo`](#612-角色查询条件视图类-sysrolequeryvo-1)
        - [6.2 条件分页查询](#62-条件分页查询-1)
            - [6.2.1 分页插件](#621-分页插件-1)
            - [6.2.2 控制类](#622-控制类-1)
            - [6.2.3 服务接口类](#623-服务接口类-1)
            - [6.2.4 服务实现类](#624-服务实现类-1)
            - [6.2.5 `Mapper`接口](#625-mapper接口-1)
            - [6.2.6 `Mapper.xml`](#626-mapperxml-1)
        - [6.3 角色添加](#63-角色添加-1)
        - [6.4 角色修改](#64-角色修改-1)
        - [6.5 批量删除](#65-批量删除-1)
    - [7 统一异常处理](#7-统一异常处理-1)
        - [7.1 新建全局异常处理类 `GlobalExceptionHandler`](#71-新建全局异常处理类-globalexceptionhandler-1)
            - [7.1.1 测试](#711-测试-1)
        - [7.2 特定异常处理](#72-特定异常处理-1)
            - [7.2.1 测试](#721-测试-1)
        - [7.3 自定义异常处理](#73-自定义异常处理-1)
            - [7.3.1 新建 `GuiguException`](#731-新建-guiguexception-1)
            - [7.3.2 测试](#732-测试-1)

# 一 搭建环境

```
git checkout -b 1.0.0_init
```

## 1 项目介绍

- 权限管理是所有后台系统都会涉及的一个重要组成部分，而权限管理的核心流程是相似的，如果每个后台单独开发一套权限管理系统，就是重复造轮子，是人力的极大浪费，本项目就是针对这个问题，提供了一套通用的权限解决方案。
- 项目服务器端架构：`SpringBoot` + `MyBatisPlus` + `SpringSecurity`
- 前端架构：`Node.js` + `Npm` + `Vue` + `ElementUI` + `Axios`

![img](https://cdn.nlark.com/yuque/0/2022/jpeg/12811585/1668045105781-ef2cfcc6-89db-4b6a-9db6-28245282ba62.jpeg)



### 1.2 核心技术

| 基础框架：`SpringBoot`                                      |
| ----------------------------------------------------------- |
| 数据缓存：`Redis`                                           |
| 数据库：`Mysql`                                             |
| 权限控制：`SpringSecurity`                                  |
| 全局日志记录：`AOP`                                         |
| 前端模板：`vue-admin-template`                              |
| 前端技术：`Node.js` + `Npm` + `Vue` + `ElementUI` + `Axios` |



### 1.3 项目模块

![img](https://cdn.nlark.com/yuque/0/2022/jpeg/12811585/1668050770126-a42d171d-a429-4b4b-8fa8-5adbefc8cc2c.jpeg)

`guigu-auth-parent`：根目录，管理子模块：

​	`common`：公共类父模块

​		`common-log`：系统操作日志模块

​		`common-util`：核心工具类

​		`service-util`：`service`模块工具类

​		`spring-security`：`spring-security`业务模块

​	`model`：实体类模块

​	`service`: 服务类父模块

​    `service-system`：系统权限模块

### 1.4 项目演示地址

- 硅谷通用权限系统演示地址：`http://139.198.152.148:8810/`
- 根据演示了解项目相关业务

### 1.5 数据库设计





## 2 搭建环境

- 总目录（包含前后端） `system-auth`

![img](https://cdn.nlark.com/yuque/0/2022/png/12811585/1668049198563-6b61fe34-7da4-4606-9fa6-299c58d5ed97.png)

- 删除 `src` 目录

### 2.1 搭建项目结构

#### 2.1.1 搭建父工程 `guigu-auth-parent`

- `GroupId`: `com.atguigu`
- `ArtifactId`: `guigu-auth-parent`

![img](https://cdn.nlark.com/yuque/0/2022/png/12811585/1668050540198-947d8ed9-a8a3-4733-8e51-c7a68aff2dd1.png)

- 删除 `src` 目录
- 新建 `.gitignore`

```latex
### Java template
# Compiled class file
*.class

# Log file
*.log

# BlueJ files
*.ctxt

# Mobile Tools for Java (J2ME)
.mtj.tmp/

# Package Files #
*.jar
*.war
*.nar
*.ear
*.zip
*.tar.gz
*.rar

# virtual machine crash logs, see http://www.java.com/en/download/help/error_hotspot.xml
hs_err_pid*

### Example user template template
### Example user template

# IntelliJ project files
.idea
*.iml
out
gen
```



#### 2.1.2 `common`

![img](https://cdn.nlark.com/yuque/0/2022/png/12811585/1668046554413-5a482a58-44ec-4d3f-9807-4ccaff61ed94.png)

- 删除 `src` 目录

#### 2.1.3 `common-log`

![img](https://cdn.nlark.com/yuque/0/2022/png/12811585/1668046799627-0bf06661-b0af-4482-9a50-561efdf934bc.png)

#### 2.1.4 `common-util`

#### 2.1.5 `service-util`

![img](https://cdn.nlark.com/yuque/0/2022/png/12811585/1668046848161-f35517c7-2f46-42e6-b57a-4ef55da38371.png)

#### 2.1.6 `spring-security`

![img](https://cdn.nlark.com/yuque/0/2022/png/12811585/1668046891842-a27c937d-2d88-4602-8318-d5451041e4d9.png)

#### 2.1.7 `model`

![img](https://cdn.nlark.com/yuque/0/2022/png/12811585/1668046734074-767fbcb6-40d2-4e69-a610-f027e457b73c.png)

- 将实体类复制到该模块中



#### 2.1.8 `service`

#### ![img](https://cdn.nlark.com/yuque/0/2022/png/12811585/1668050868508-4daa201a-b7af-4d4d-990c-a3b8eab123d2.png)

#### 2.1.9 `service-system`

![img](https://cdn.nlark.com/yuque/0/2022/png/12811585/1668046753917-3cd6ba60-6aa2-42bb-abaa-0e5cf2ebe0a4.png)





### 2.2 配置依赖关系

![img](https://cdn.nlark.com/yuque/0/2022/jpeg/12811585/1668048215439-fe86cb08-6880-45c2-a4f8-fb6977272ac8.jpeg)

#### 2.2.1 父工程依赖

```xml
<properties>
    <maven.compiler.source>8</maven.compiler.source>
    <maven.compiler.target>8</maven.compiler.target>
    <java.version>1.8</java.version>
    <alibaba.version>2.2.0.RELEASE</alibaba.version>
    <mybatis-plus.version>3.4.1</mybatis-plus.version>
    <mysql.version>8.0.23</mysql.version>
    <knife4j.version>2.0.8</knife4j.version>
    <jwt.version>0.7.0</jwt.version>
    <fastjson.version>1.2.29</fastjson.version>
</properties>

<parent>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-parent</artifactId>
    <version>2.3.6.RELEASE</version>
</parent>

<!--配置dependencyManagement锁定依赖的版本-->
<dependencyManagement>
    <dependencies>
        <!--mybatis-plus 持久层-->
        <dependency>
            <groupId>com.baomidou</groupId>
            <artifactId>mybatis-plus-boot-starter</artifactId>
            <version>${mybatis-plus.version}</version>
        </dependency>
        <!--mysql-->
        <dependency>
            <groupId>mysql</groupId>
            <artifactId>mysql-connector-java</artifactId>
            <version>${mysql.version}</version>
        </dependency>
        <!--knife4j-->
        <dependency>
            <groupId>com.github.xiaoymin</groupId>
            <artifactId>knife4j-spring-boot-starter</artifactId>
            <version>${knife4j.version}</version>
        </dependency>
        <!--jjwt-->
        <dependency>
            <groupId>io.jsonwebtoken</groupId>
            <artifactId>jjwt</artifactId>
            <version>${jwt.version}</version>
        </dependency>
        <!--fastjson-->
        <dependency>
            <groupId>com.alibaba</groupId>
            <artifactId>fastjson</artifactId>
            <version>${fastjson.version}</version>
        </dependency>
    </dependencies>
</dependencyManagement>

<build>
    <plugins>
        <plugin>
            <groupId>org.apache.maven.plugins</groupId>
            <artifactId>maven-compiler-plugin</artifactId>
            <version>3.1</version>
            <configuration>
                <source>1.8</source>
                <target>1.8</target>
            </configuration>
        </plugin>
    </plugins>
</build>
```



#### 2.2.2 `common` 无依赖

#### 2.2.3 `common-log` 依赖





#### 2.2.4 `common-util` 依赖

```xml
<dependencies>
    <dependency>
        <groupId>com.atguigu</groupId>
        <artifactId>model</artifactId>
        <version>1.0</version>
    </dependency>
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-web</artifactId>
        <scope>provided</scope>
    </dependency>
    <dependency>
        <groupId>io.jsonwebtoken</groupId>
        <artifactId>jjwt</artifactId>
    </dependency>
    <dependency>
        <groupId>org.projectlombok</groupId>
        <artifactId>lombok</artifactId>
    </dependency>
    <dependency>
        <groupId>com.alibaba</groupId>
        <artifactId>fastjson</artifactId>
    </dependency>
</dependencies>
```



#### 2.2.5 `service-util` 依赖

```xml
<dependencies>
    <dependency>
        <groupId>com.atguigu</groupId>
        <artifactId>common-util</artifactId>
        <version>1.0</version>
    </dependency>
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-web</artifactId>
    </dependency>
    <dependency>
        <groupId>com.baomidou</groupId>
        <artifactId>mybatis-plus-boot-starter</artifactId>
    </dependency>
    <!--mysql-->
    <dependency>
        <groupId>mysql</groupId>
        <artifactId>mysql-connector-java</artifactId>
    </dependency>
</dependencies>
```



#### 2.2.6 `spring-security` 依赖





#### 2.2.7 `model` 依赖

```xml
<dependencies>
    <!--lombok用来简化实体类-->
    <dependency>
        <groupId>org.projectlombok</groupId>
        <artifactId>lombok</artifactId>
    </dependency>
    <dependency>
        <groupId>com.github.xiaoymin</groupId>
        <artifactId>knife4j-spring-boot-starter</artifactId>
        <scope>provided</scope>
    </dependency>
    <dependency>
        <groupId>com.baomidou</groupId>
        <artifactId>mybatis-plus-boot-starter</artifactId>
        <scope>provided</scope>
    </dependency>
</dependencies>
```



#### 2.2.8 `service` 无依赖

#### 2.2.9 `service-system` 依赖

```xml
<packaging>jar</packaging>

 <dependencies>
     <dependency>
         <groupId>com.atguigu</groupId>
         <artifactId>service-util</artifactId>
         <version>1.0</version>
     </dependency>
     
     <dependency>
         <groupId>org.springframework.boot</groupId>
         <artifactId>spring-boot-starter-test</artifactId>
         <scope>test</scope>
     </dependency>
 </dependencies>

 <build>
     <finalName>${project.artifactId}</finalName>
     <plugins>
         <plugin>
             <groupId>org.springframework.boot</groupId>
             <artifactId>spring-boot-maven-plugin</artifactId>
         </plugin>
     </plugins>
 </build>
```



### 2.3 确保 `github` 上项目结构的完整

- 因为 `github` 上不能保存空文件夹, 所以要在项目空文件夹下创建文件, 确保 `github` 上的项目结构的完整

```bash
find . \( -type d -empty \) -exec touch {}/.gitxxx \;
```



## 3 使用 `Mybatis-plus`

### 3.1 依赖<已引入>

```xml
<dependency>
    <groupId>com.baomidou</groupId>
    <artifactId>mybatis-plus-boot-starter</artifactId>
    <version>3.4.1</version>
</dependency>
```



### 3.2 配置文件

- `application.yml`

```yaml
spring:
  application:
    name: service-system
  profiles:
    active: prod
```

- `application-dev.yml`

```yaml
server:
  port: 1110
mybatis-plus:
  configuration:
    # 查看日志
    log-impl: org.apache.ibatis.logging.stdout.StdOutImpl
spring:
  datasource:
    driver-class-name: com.mysql.cj.jdbc.Driver
    url: jdbc:mysql://localhost:3306/guigu-auth?characterEncoding=utf-8&useSSL=false
    username: root
    password: 12345678
```

- `application-prod.yml`

```yaml
server:
  port: 1110
mybatis-plus:
  configuration:
    # 查看日志
    log-impl: org.apache.ibatis.logging.stdout.StdOutImpl 
spring:
  datasource:
    driver-class-name: com.mysql.cj.jdbc.Driver
    url: ${SPRING_DATASOURCE_URL}
    username: root
    password: ${SPRING_DATASOURCE_PASSWORD}
```

- 环境

![img](https://cdn.nlark.com/yuque/0/2022/png/12811585/1668125403729-34de49d3-0db6-4dd0-8cb4-2888eee6aa08.png)

- `java -jar service-system.jar `

```
--spring.profiles.active='prod' 
--spring.datasource.url='jdbc:mysql://localhost:3306/guigu-auth?characterEncoding=utf-8&useSSL=false' 
--spring.datasource.password='xxx'
```

### 3.3 启动类

![img](https://cdn.nlark.com/yuque/0/2022/png/12811585/1668048564393-bab40f78-74f9-4496-a053-a829b8c5fe13.png)

```java
package com.atguigu.system;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 权限服务启动类
 *
 * @author 陈江林
 * @date 2022/11/10 11:59
 */
@SpringBootApplication
@MapperScan("com.atguigu.system.mapper")
@ComponentScan(basePackages = "com.atguigu")
public class ServiceAuthApplication {

    public static void main(String[] args) {
        SpringApplication.run(ServiceAuthApplication.class, args);
    }

}
```



### 3.4 新建 `Mapper` 接口

![img](https://cdn.nlark.com/yuque/0/2022/png/12811585/1668065316255-f2a7a074-09a3-4156-a6d9-811357f25cf8.png)

```java
package com.atguigu.system.mapper;

import com.atguigu.model.system.SysRole;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.springframework.stereotype.Repository;

/**
 * Mapper 接口
 *
 * @author 陈江林
 * @date 2022/11/10 14:22
 */
@Repository
public interface SysRoleMapper extends BaseMapper<SysRole> {
}
```

### 3.5 新建测试类

```java
package com.atguigu.system;

import com.atguigu.model.system.SysRole;
import com.atguigu.system.mapper.SysRoleMapper;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.function.Supplier;

/**
 * 测试一下 CURD
 *
 * @author 陈江林
 * @date 2022/11/10 14:18
 */
@SpringBootTest
public class ServiceAuthApplicationTest {

    @Autowired
    private SysRoleMapper sysRoleMapper;

    /**
     * 根据 id 获取系统角色实体对象
     */
    @Test
    public void findSysRoleById() {
        SysRole sysRole = sysRoleMapper.selectById(1L);
        System.out.println(sysRole);
    }

    /**
     * 查询所有
     */
    @Test
    public void findAll() {
        List<SysRole> sysRoles = sysRoleMapper.selectList(null);
        System.out.println(sysRoles);
    }

    /**
     * 添加数据
     */
    @Test
    public void saveSysRole() {
        sysRoleMapper.insert(
                ((Supplier<SysRole>) () -> {
                    SysRole sysRole = new SysRole();
                    sysRole.setRoleName("测试角色");
                    sysRole.setRoleCode("TEST_ROLE");
                    sysRole.setDescription("测试角色");
                    return sysRole;
                }).get()
        );

        // 查看
        System.out.println(sysRoleMapper.selectList(null));
    }

    /**
     * 修改数据
     */
    @Test
    public void updateSysRole() {
        sysRoleMapper.updateById(
                ((Supplier<SysRole>) () -> {
                    // 根据 id 获取实体对象
                    SysRole sysRole = sysRoleMapper.selectOne(
                            new LambdaQueryWrapper<SysRole>()
                                    .eq(SysRole::getRoleCode, "TEST_ROLE")
                    );

                    sysRole.setDescription("测试修改角色信息");
                    return sysRole;
                }).get()
        );

        // 查看
        System.out.println(sysRoleMapper.selectOne(
                new LambdaQueryWrapper<SysRole>()
                        .eq(SysRole::getRoleCode, "TEST_ROLE")
        ));
    }

    /**
     * 删除数据
     */
    @Test
    public void removeSysRole() {
        sysRoleMapper.delete(new LambdaQueryWrapper<SysRole>()
                .eq(SysRole::getRoleCode, "TEST_ROLE")
        );

        // 查看
        System.out.println(sysRoleMapper.selectList(null));
    }

}
```



### 3.6 新建服务接口类

![img](https://cdn.nlark.com/yuque/0/2022/png/12811585/1668066107110-dd3f1c6e-b890-4100-921f-dd7daae4a8f3.png)

```java
package com.atguigu.system.service;

import com.atguigu.model.system.SysRole;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * 系统角色 服务接口类
 *
 * @author 陈江林
 * @date 2022/11/10 15:40
 */
public interface SysRoleService extends IService<SysRole> {
}
```

### 3.7 新建服务实现类

![img](https://cdn.nlark.com/yuque/0/2022/png/12811585/1668066142959-a1307eab-f76e-4a7c-849a-45aa197b801a.png)

```java
package com.atguigu.system.service.impl;

import com.atguigu.model.system.SysRole;
import com.atguigu.system.mapper.SysRoleMapper;
import com.atguigu.system.service.SysRoleService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * 系统角色 服务实现类
 *
 * @author 陈江林
 * @date 2022/11/10 15:42
 */
@Service
public class SysRoleServiceImpl extends ServiceImpl<SysRoleMapper, SysRole> implements SysRoleService {
}
```



### 3.8 新建测试类

![img](https://cdn.nlark.com/yuque/0/2022/png/12811585/1668066910304-9559637f-fd32-47f1-afcf-47e461f1234c.png)

```java
package com.atguigu.system;

import com.atguigu.model.system.SysRole;
import com.atguigu.system.service.SysRoleService;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.List;
import java.util.function.Supplier;

/**
 * 测试 Mybatis Plus 的 服务接口的 CURD
 *
 * @author 陈江林
 * @date 2022/11/10 15:46
 */
@SpringBootTest
public class MpServiceTest {

    @Autowired
    private SysRoleService sysRoleService;

    /**
     * 根据 id 获取系统角色实体对象
     */
    @Test
    public void findSysRoleById() {
        SysRole sysRole = sysRoleService.getById(1L);
        System.out.println(sysRole);
    }

    /**
     * 查询所有
     */
    @Test
    public void findAll() {
        List<SysRole> sysRoles = sysRoleService.list();
        System.out.println(sysRoles);
    }

    /**
     * 添加数据
     */
    @Test
    public void saveSysRole() {
        sysRoleService.save(
                ((Supplier<SysRole>) () -> {
                    SysRole sysRole = new SysRole();
                    sysRole.setRoleName("测试角色");
                    sysRole.setRoleCode("TEST_ROLE");
                    sysRole.setDescription("测试角色");
                    return sysRole;
                }).get()
        );

        // 查看
        System.out.println(sysRoleService.list());
    }

    /**
     * 修改数据
     */
    @Test
    public void updateSysRole() {
        sysRoleService.updateById(
                ((Supplier<SysRole>) () -> {
                    // 根据 id 获取实体对象
                    SysRole sysRole = sysRoleService.getOne(
                            new LambdaQueryWrapper<SysRole>()
                                    .eq(SysRole::getRoleCode, "TEST_ROLE")
                    );

                    sysRole.setDescription("测试修改角色信息");
                    return sysRole;
                }).get()
        );

        // 查看
        System.out.println(sysRoleService.getOne(
                new LambdaQueryWrapper<SysRole>()
                        .eq(SysRole::getRoleCode, "TEST_ROLE")
        ));
    }

    /**
     * 删除数据 - 逻辑删除
     */
    @Test
    public void removeSysRole() {
        sysRoleService.remove(new LambdaQueryWrapper<SysRole>()
                .eq(SysRole::getRoleCode, "TEST_ROLE")
        );

        // 查看
        System.out.println(sysRoleService.list());
    }

    /**
     * 批量删除
     */
    @Test
    public void removeSysRoles() {
        sysRoleService.removeByIds(Arrays.asList(1, 2));

        // 查看
        System.out.println(sysRoleService.list());
    }

}
```



## 4 整合 `swagger2`

### 4.1 集成 `knife4j`

- 文档: `https://doc.xiaominfo.com/`
- 地址: `http://localhost:1110/doc.html`

- `knife4j` 是为 `JAVA MVC` 框架集成 `Swagger` 生成 `API` 文档的增强解决方案

#### 4.1.1 第一步 添加依赖包

- `knife4j`属于`service`模块公共资源, 因此我们集成到`service-util`模块中

1. 添加依赖

```xml
<!--引入Knife4j的官方start包,Swagger2基于Springfox2.10.5项目-->
<dependency>
    <groupId>com.github.xiaoymin</groupId>
    <!--使用Swagger2-->
    <artifactId>knife4j-spring-boot-starter</artifactId>
</dependency>
```

#### 4.1.2 添加`knife4j`配置



```java
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
```



### 4.2 新建控制类, 使用 `swagger`注解

![img](https://cdn.nlark.com/yuque/0/2022/png/12811585/1668067739641-700323a2-1083-4ce6-9fa4-80238ac812b7.png)

```java
package com.atguigu.system.controller;

import com.atguigu.model.system.SysRole;
import com.atguigu.system.service.SysRoleService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author 陈江林
 * @date 2022/11/10 16:08
 */
@Api(tags = "角色管理接口")
@RestController
@RequestMapping("/admin/system/sysRole")
public class SysRoleController {

    @Autowired
    private SysRoleService sysRoleService;

    /**
     * 查询所有
     *
     * @return {@link List}<{@link SysRole}>
     */
    @ApiOperation(value = "查询所有")
    @GetMapping("/findAll")
    public List<SysRole> findAll() {
        return sysRoleService.list();
    }

    /**
     * 根据 id 删除数据
     *
     * @return {@link List}<{@link SysRole}>
     */
    @ApiImplicitParam(name = "id", value = "角色id", required = true)
    @ApiOperation(value = "逻辑删除")
    @DeleteMapping("/remove/{id}")
    public boolean removeById(
            @PathVariable Long id
    ) {
        return sysRoleService.removeById(id);
    }

}
```



### 4.3 测试

![img](https://cdn.nlark.com/yuque/0/2022/png/12811585/1668122757367-aaa0a3be-1bc5-428e-87c7-b054067e25fb.png)



## 5 统一返回结果类

列表：

```json
{
  "code": 200,
  "message": "成功",
  "data": [
    {
      "id": 2,
      "roleName": "系统管理员"
    }
  ],
  "ok": true
}
```

分页：

```json
{
  "code": 200,
  "message": "成功",
  "data": {
    "records": [
      {
        "id": 2,
        "roleName": "系统管理员"
      },
      {
        "id": 3,
        "name": "普通管理员"
      }
    ],
    "total": 10,
    "size": 3,
    "current": 1,
    "orders": [],
    "hitCount": false,
    "searchCount": true,
    "pages": 2
  },
  "ok": true
}
```

成功-没有返回数据：

```json
{
  "code": 200,
  "message": "成功",
  "data": null,
  "ok": true
}
```

失败：

```json
{
  "code": 201,
  "message": "失败",
  "data": null,
  "ok": false
}
```



### 5.1 新建 `Result`

![img](https://cdn.nlark.com/yuque/0/2022/png/12811585/1668131586050-8511a5e7-bb6a-4e72-a652-a2562d900723.png)

```java
package com.atguigu.common.result;

import lombok.Data;

/**
 * 统一返回结果类
 *
 * @author 陈江林
 * @date 2022/11/11 09:33
 */
@Data
public class Result<T> {

    /**
     * 返回码
     */
    private Integer code;

    /**
     * 返回消息
     */
    private String message;

    /**
     * 返回数据
     */
    private T data;

    public Result() {
    }

    /**
     * 返回数据
     *
     * @param data 数据
     * @return {@link Result}<{@link T}>
     */
    protected static <T> Result<T> build(T data) {
        Result<T> result = new Result<T>();
        if (data != null) {
            result.setData(data);
        }

        return result;
    }

    public static <T> Result<T> build(T body, Integer code, String message) {
        Result<T> result = build(body);
        result.setCode(code);
        result.setMessage(message);
        return result;
    }

    public static <T> Result<T> build(T body, ResultCodeEnum resultCodeEnum) {
        Result<T> result = build(body);
        result.setCode(resultCodeEnum.getCode());
        result.setMessage(resultCodeEnum.getMessage());
        return result;
    }

    public static <T> Result<T> ok() {
        return Result.ok(null);
    }

    /**
     * 操作成功
     *
     * @param data baseCategory1List
     * @return {@link Result}<{@link T}>
     */
    public static <T> Result<T> ok(T data) {
        return build(data, ResultCodeEnum.SUCCESS);
    }

    public static <T> Result<T> fail() {
        return Result.fail(null);
    }

    /**
     * 操作失败
     *
     * @param data 数据
     * @return {@link Result}<{@link T}>
     */
    public static <T> Result<T> fail(T data) {
        return build(data, ResultCodeEnum.FAIL);
    }

    public Result<T> message(String msg) {
        this.setMessage(msg);
        return this;
    }

    public Result<T> code(Integer code) {
        this.setCode(code);
        return this;
    }
}
```

### 5.2 新建 `ResultCodeEnum`

![img](https://cdn.nlark.com/yuque/0/2022/png/12811585/1668131611438-98b55230-116d-476a-85b6-6ea4b803e7db.png)

```java
package com.atguigu.common.result;

import lombok.Getter;

/**
 * 统一返回结果状态信息类
 *
 * @author 陈江林
 * @date 2022/11/11 09:40
 */
@Getter
public enum ResultCodeEnum {

    SUCCESS(200, "成功"),
    FAIL(201, "失败"),
    SERVICE_ERROR(2012, "服务异常"),
    DATA_ERROR(204, "数据异常"),
    ILLEGAL_REQUEST(205, "非法请求"),
    REPEAT_SUBMIT(206, "重复提交"),
    ARGUMENT_VALID_ERROR(210, "参数校验异常"),

    LOGIN_AUTH(208, "未登陆"),
    PERMISSION(209, "没有权限"),
    ACCOUNT_ERROR(214, "账号不正确"),
    PASSWORD_ERROR(215, "密码不正确"),
    LOGIN_MOBLE_ERROR(216, "账号不正确"),
    ACCOUNT_STOP(217, "账号已停用"),
    NODE_ERROR(218, "该节点下有子节点，不可以删除");

    private Integer code;

    private String message;

    ResultCodeEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
```

### 5.3 修改角色管理控制类

```java
package com.atguigu.system.controller;

import com.atguigu.common.result.Result;
import com.atguigu.model.system.SysRole;
import com.atguigu.system.service.SysRoleService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author 陈江林
 * @date 2022/11/10 16:08
 */
@Api(tags = "角色管理接口")
@RestController
@RequestMapping("/admin/system/sysRole")
public class SysRoleController {

    @Autowired
    private SysRoleService sysRoleService;

    /**
     * 查询所有
     *
     * @return {@link List}<{@link SysRole}>
     */
    @ApiOperation(value = "查询所有")
    @GetMapping("/findAll")
    public Result<List<SysRole>> findAll() {
        return Result.ok(sysRoleService.list());
    }

    /**
     * 根据 id 删除数据
     *
     * @return {@link List}<{@link SysRole}>
     */
    @ApiImplicitParam(name = "id", value = "角色id", required = true)
    @ApiOperation(value = "逻辑删除")
    @DeleteMapping("/remove/{id}")
    public Result<Boolean> removeById(
            @PathVariable Long id
    ) {
        boolean isSuccess = sysRoleService.removeById(id);
        if (isSuccess) {
            return Result.ok();
        } else {
            return Result.fail();
        }
    }

}
```



## 6 角色管理接口

![img](https://cdn.nlark.com/yuque/0/2022/jpeg/12811585/1668131915182-837672ab-b745-48cc-9105-a06220fcd8cb.jpeg)



### 6.1 实体类

#### 6.1.1 通用属性类 `BaseEntity`

```java
package com.atguigu.model.base;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableLogic;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * 通用属性类
 *
 * @author 陈江林
 * @date 2022/11/11
 */
@Data
public class BaseEntity implements Serializable {

    //@TableId(type = IdType.AUTO)
    @ApiModelProperty("唯一标识")
    private String id;

    @ApiModelProperty("创建时间")
    @TableField("create_time")
    private Date createTime;

    @ApiModelProperty("更新时间")
    @TableField("update_time")
    private Date updateTime;

    @ApiModelProperty("逻辑删除{0: 没有删除,1: 已经删除}")
    @TableLogic
    @TableField("is_deleted")
    private Integer isDeleted;

    @ApiModelProperty("其他参数")
    @TableField(exist = false)
    private Map<String, Object> param = new HashMap<>();
}
```



#### 6.1.2 角色实体类`SysRole`

```java
package com.atguigu.model.system;

import com.atguigu.model.base.BaseEntity;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@ApiModel("角色实体类")
@Data
@TableName("sys_role")
public class SysRole extends BaseEntity {
	
	private static final long serialVersionUID = 1L;

	@ApiModelProperty("角色名称")
	@TableField("role_name")
	private String roleName;

	@ApiModelProperty("角色编码")
	@TableField("role_code")
	private String roleCode;

	@ApiModelProperty("描述")
	@TableField("description")
	private String description;

}
```



#### 6.1.2 角色查询条件视图类 `SysRoleQueryVo`

```java
package com.atguigu.model.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

@ApiModel("角色查询条件视图类")
@Data
public class SysRoleQueryVo implements Serializable {

	private static final long serialVersionUID = 1L;

	@ApiModelProperty("角色名称")
	private String roleName;

}
```



### 6.2 条件分页查询

#### 6.2.1 分页插件

![img](https://cdn.nlark.com/yuque/0/2022/png/12811585/1668132299744-25c34efd-0f06-481f-974e-301f223a7f3d.png)

```java
package com.atguigu.system.config;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.autoconfigure.ConfigurationCustomizer;
import com.baomidou.mybatisplus.extension.plugins.MybatisPlusInterceptor;
import com.baomidou.mybatisplus.extension.plugins.inner.PaginationInnerInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * MybatisPlus 配置类
 *
 * @author 陈江林
 * @date 2022/11/11 10:04
 */
@Configuration
public class MybatisPlusConfig {

    @Bean
    public MybatisPlusInterceptor mybatisPlusInterceptor() {
        MybatisPlusInterceptor interceptor = new MybatisPlusInterceptor();
        interceptor.addInnerInterceptor(new PaginationInnerInterceptor(DbType.MYSQL));
        return interceptor;
    }

}
```



#### 6.2.2 控制类

```java
@ApiOperation(value = "条件分页查询")
@GetMapping("/{page}/{limit}")
public Result<IPage<SysRole>> findQueryRole(
        @PathVariable Long page,
        @PathVariable Long limit,
        SysRoleQueryVo sysRoleQueryVo
) {
    return Result.ok(sysRoleService.getPage(new Page<>(page, limit), sysRoleQueryVo));
}
```

#### 6.2.3 服务接口类

```java
package com.atguigu.system.service;

import com.atguigu.model.system.SysRole;
import com.atguigu.model.vo.SysRoleQueryVo;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * 系统角色 服务接口类
 *
 * @author 陈江林
 * @date 2022/11/10 15:40
 */
public interface SysRoleService extends IService<SysRole> {
    /**
     * 获取分页数据
     *
     * @param sysRolePage
     * @param sysRoleQueryVo
     * @return {@link IPage}<{@link SysRole}>
     */
    IPage<SysRole> getPage(Page<SysRole> sysRolePage, SysRoleQueryVo sysRoleQueryVo);
}
```

#### 6.2.4 服务实现类

```java
package com.atguigu.system.service.impl;

import com.atguigu.model.system.SysRole;
import com.atguigu.model.vo.SysRoleQueryVo;
import com.atguigu.system.mapper.SysRoleMapper;
import com.atguigu.system.service.SysRoleService;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * 系统角色 服务实现类
 *
 * @author 陈江林
 * @date 2022/11/10 15:42
 */
@Service
public class SysRoleServiceImpl extends ServiceImpl<SysRoleMapper, SysRole> implements SysRoleService {
///    @Override
///    public IPage<SysRole> getPage(Page<SysRole> sysRolePage, SysRoleQueryVo sysRoleQueryVo) {
///        LambdaQueryWrapper<SysRole> wrapper = new LambdaQueryWrapper<>();
///        if (sysRoleQueryVo != null) {
///            String roleName = sysRoleQueryVo.getRoleName();
///            if (StringUtils.isEmpty(roleName)) {
///                wrapper.like(SysRole::getRoleName, roleName);
///            }
///        }
///
///        return baseMapper.selectPage(sysRolePage, wrapper);
///    }

    @Override
    public IPage<SysRole> getPage(Page<SysRole> sysRolePage, SysRoleQueryVo sysRoleQueryVo) {
        return baseMapper.selectPage(sysRolePage, sysRoleQueryVo);
    }
}
```

#### 6.2.5 `Mapper`接口

```java
package com.atguigu.system.mapper;

import com.atguigu.model.system.SysRole;
import com.atguigu.model.vo.SysRoleQueryVo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * Mapper 接口
 *
 * @author 陈江林
 * @date 2022/11/10 14:22
 */
@Repository
public interface SysRoleMapper extends BaseMapper<SysRole> {
    /**
     * 条件分页查询
     *
     * @param sysRolePage
     * @param sysRoleQueryVo
     * @return {@link IPage}<{@link SysRole}>
     */
    IPage<SysRole> selectPage(Page<SysRole> sysRolePage, @Param("vo") SysRoleQueryVo sysRoleQueryVo);
}
```

#### 6.2.6 `Mapper.xml`

```xml
<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE mapper
        PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN"
        "http://mybatis.org/dtd/mybatis-3-mapper.dtd">
<mapper namespace="com.atguigu.system.mapper.SysRoleMapper">

    <resultMap id="RoleMap" type="com.atguigu.model.system.SysRole" autoMapping="true"/>

    <!-- 用于select查询公用抽取的列 -->
    <sql id="columns">
        id,role_name,role_code,description,create_time,update_time,is_deleted
    </sql>

    <select id="selectPage" resultMap="RoleMap">
        select <include refid="columns" />
        from sys_role
        <where>
            <if test="vo.roleName != null and vo.roleName != ''">
                and role_name like CONCAT('%',#{vo.roleName},'%')
            </if>
            and is_deleted = 0
        </where>
        order by id desc
    </select>

</mapper>
```



### 6.3 角色添加

```java
@ApiOperation("角色添加")
@PostMapping("/save")
public Result saveRole(
        @RequestBody SysRole sysRole
) {
    if (sysRoleService.save(sysRole)) {
        return Result.ok();
    } else {
        return Result.fail();
    }
}
```



### 6.4 角色修改

```java
@ApiOperation("角色修改")
@PutMapping("/update")
public Result updateRole(
        @RequestBody SysRole sysRole
) {
    if (sysRoleService.updateById(sysRole)) {
        return Result.ok();
    } else {
        return Result.fail();
    }
}

@ApiOperation("根据id查询角色")
@GetMapping("/findRoleById/{id}")
public Result<SysRole> findRoleById(
        @PathVariable Long id
) {
    return Result.ok(sysRoleService.getById(id));
}
```



### 6.5 批量删除

```java
@ApiOperation("批量删除")
@DeleteMapping("/batchRemove")
public Result batchRemove(
        @RequestBody List<Long> ids
) {
    if (sysRoleService.removeByIds(ids)) {
        return Result.ok();
    } else {
        return Result.fail();
    }
}
```



## 7 统一异常处理

### 7.1 新建全局异常处理类 `GlobalExceptionHandler`

![img](https://cdn.nlark.com/yuque/0/2022/png/12811585/1668157491479-b5c47dc9-d148-4fd1-9599-1c0e4fe9bb2a.png)

```java
package com.atguigu.system.exception;

import com.atguigu.common.result.Result;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 全局异常处理类
 *
 * @author 陈江林
 * @date 2022/11/11 17:02
 */
@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    @ResponseBody
    public Result error(Exception e) {
        e.printStackTrace();
        return Result.fail();
    }

}
```

#### 7.1.1 测试

![img](https://cdn.nlark.com/yuque/0/2022/png/12811585/1668160434986-c9321598-16cc-4466-abd7-07c23896c209.png)

![img](https://cdn.nlark.com/yuque/0/2022/png/12811585/1668160598457-50d51759-277e-4a9a-984b-0d0908e5c215.png)



### 7.2 特定异常处理

```java
package com.atguigu.system.exception;

import com.atguigu.common.result.Result;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

/**
 * 全局异常处理类
 *
 * @author 陈江林
 * @date 2022/11/11 17:02
 */
@ControllerAdvice
@RestController
public class GlobalExceptionHandler {

    /**
     * 全局异常处理
     *
     * @param e e
     * @return {@link Result}
     */
    @ExceptionHandler(Exception.class)
    public Result error(Exception e) {
        e.printStackTrace();
        return Result.fail();
    }

    /**
     * 特定异常处理
     *
     * @param e e
     * @return {@link Result}
     */
    @ExceptionHandler(ArithmeticException.class)
    public Result error(ArithmeticException e) {
        e.printStackTrace();
        return Result.fail().message("算数运算异常!");
    }

}
```

#### 7.2.1 测试

![img](https://cdn.nlark.com/yuque/0/2022/png/12811585/1668158292487-1153bc36-42d3-4bb9-b133-fa55101f7b88.png)

![img](https://cdn.nlark.com/yuque/0/2022/png/12811585/1668159786757-c2bb9eea-6892-4a85-bc8a-9b06f05a6a59.png)



### 7.3 自定义异常处理

```java
    /**
     * 自定义异常处理
     *
     * @param e e
     * @return {@link Result}
     */
    @ExceptionHandler(GuiguException.class)
    public Result error(GuiguException e) {
        e.printStackTrace();
        return Result.fail().code(e.getCode()).message(e.getMessage());
    }
```

#### 7.3.1 新建 `GuiguException`

```java
package com.atguigu.system.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 自定义异常
 *
 * @author 陈江林
 * @date 2022/11/11 17:13
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class GuiguException extends RuntimeException {

    private Integer code;
    private String msg;

}
```

#### 7.3.2 测试

![img](https://cdn.nlark.com/yuque/0/2022/png/12811585/1668159203042-4c097e82-c8a8-45eb-a1fc-b7b58964aebf.png)

![img](https://cdn.nlark.com/yuque/0/2022/png/12811585/1668160219316-9aad2c93-c667-4365-83c5-b877b2a11e6d.png)# 一 搭建环境

```
git checkout -b 1.0.0_init
```

## 1 项目介绍

- 权限管理是所有后台系统都会涉及的一个重要组成部分，而权限管理的核心流程是相似的，如果每个后台单独开发一套权限管理系统，就是重复造轮子，是人力的极大浪费，本项目就是针对这个问题，提供了一套通用的权限解决方案。
- 项目服务器端架构：`SpringBoot` + `MyBatisPlus` + `SpringSecurity`
- 前端架构：`Node.js` + `Npm` + `Vue` + `ElementUI` + `Axios`

![img](https://cdn.nlark.com/yuque/0/2022/jpeg/12811585/1668045105781-ef2cfcc6-89db-4b6a-9db6-28245282ba62.jpeg)



### 1.2 核心技术

| 基础框架：`SpringBoot`                                      |
| ----------------------------------------------------------- |
| 数据缓存：`Redis`                                           |
| 数据库：`Mysql`                                             |
| 权限控制：`SpringSecurity`                                  |
| 全局日志记录：`AOP`                                         |
| 前端模板：`vue-admin-template`                              |
| 前端技术：`Node.js` + `Npm` + `Vue` + `ElementUI` + `Axios` |



### 1.3 项目模块

![img](https://cdn.nlark.com/yuque/0/2022/jpeg/12811585/1668050770126-a42d171d-a429-4b4b-8fa8-5adbefc8cc2c.jpeg)

`guigu-auth-parent`：根目录，管理子模块：

​	`common`：公共类父模块

​		`common-log`：系统操作日志模块

​		`common-util`：核心工具类

​		`service-util`：`service`模块工具类

​		`spring-security`：`spring-security`业务模块

​	`model`：实体类模块

​	`service`: 服务类父模块

​    `service-system`：系统权限模块

### 1.4 项目演示地址

- 硅谷通用权限系统演示地址：`http://139.198.152.148:8810/`
- 根据演示了解项目相关业务

### 1.5 数据库设计





## 2 搭建环境

- 总目录（包含前后端） `system-auth`

![img](https://cdn.nlark.com/yuque/0/2022/png/12811585/1668049198563-6b61fe34-7da4-4606-9fa6-299c58d5ed97.png)

- 删除 `src` 目录

### 2.1 搭建项目结构

#### 2.1.1 搭建父工程 `guigu-auth-parent`

- `GroupId`: `com.atguigu`
- `ArtifactId`: `guigu-auth-parent`

![img](https://cdn.nlark.com/yuque/0/2022/png/12811585/1668050540198-947d8ed9-a8a3-4733-8e51-c7a68aff2dd1.png)

- 删除 `src` 目录
- 新建 `.gitignore`

```latex
### Java template
# Compiled class file
*.class

# Log file
*.log

# BlueJ files
*.ctxt

# Mobile Tools for Java (J2ME)
.mtj.tmp/

# Package Files #
*.jar
*.war
*.nar
*.ear
*.zip
*.tar.gz
*.rar

# virtual machine crash logs, see http://www.java.com/en/download/help/error_hotspot.xml
hs_err_pid*

### Example user template template
### Example user template

# IntelliJ project files
.idea
*.iml
out
gen
```



#### 2.1.2 `common`

![img](https://cdn.nlark.com/yuque/0/2022/png/12811585/1668046554413-5a482a58-44ec-4d3f-9807-4ccaff61ed94.png)

- 删除 `src` 目录

#### 2.1.3 `common-log`

![img](https://cdn.nlark.com/yuque/0/2022/png/12811585/1668046799627-0bf06661-b0af-4482-9a50-561efdf934bc.png)

#### 2.1.4 `common-util`

#### 2.1.5 `service-util`

![img](https://cdn.nlark.com/yuque/0/2022/png/12811585/1668046848161-f35517c7-2f46-42e6-b57a-4ef55da38371.png)

#### 2.1.6 `spring-security`

![img](https://cdn.nlark.com/yuque/0/2022/png/12811585/1668046891842-a27c937d-2d88-4602-8318-d5451041e4d9.png)

#### 2.1.7 `model`

![img](https://cdn.nlark.com/yuque/0/2022/png/12811585/1668046734074-767fbcb6-40d2-4e69-a610-f027e457b73c.png)

- 将实体类复制到该模块中



#### 2.1.8 `service`

#### ![img](https://cdn.nlark.com/yuque/0/2022/png/12811585/1668050868508-4daa201a-b7af-4d4d-990c-a3b8eab123d2.png)

#### 2.1.9 `service-system`

![img](https://cdn.nlark.com/yuque/0/2022/png/12811585/1668046753917-3cd6ba60-6aa2-42bb-abaa-0e5cf2ebe0a4.png)





### 2.2 配置依赖关系

![img](https://cdn.nlark.com/yuque/0/2022/jpeg/12811585/1668048215439-fe86cb08-6880-45c2-a4f8-fb6977272ac8.jpeg)

#### 2.2.1 父工程依赖

```xml
<properties>
    <maven.compiler.source>8</maven.compiler.source>
    <maven.compiler.target>8</maven.compiler.target>
    <java.version>1.8</java.version>
    <alibaba.version>2.2.0.RELEASE</alibaba.version>
    <mybatis-plus.version>3.4.1</mybatis-plus.version>
    <mysql.version>8.0.23</mysql.version>
    <knife4j.version>2.0.8</knife4j.version>
    <jwt.version>0.7.0</jwt.version>
    <fastjson.version>1.2.29</fastjson.version>
</properties>

<parent>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-parent</artifactId>
    <version>2.3.6.RELEASE</version>
</parent>

<!--配置dependencyManagement锁定依赖的版本-->
<dependencyManagement>
    <dependencies>
        <!--mybatis-plus 持久层-->
        <dependency>
            <groupId>com.baomidou</groupId>
            <artifactId>mybatis-plus-boot-starter</artifactId>
            <version>${mybatis-plus.version}</version>
        </dependency>
        <!--mysql-->
        <dependency>
            <groupId>mysql</groupId>
            <artifactId>mysql-connector-java</artifactId>
            <version>${mysql.version}</version>
        </dependency>
        <!--knife4j-->
        <dependency>
            <groupId>com.github.xiaoymin</groupId>
            <artifactId>knife4j-spring-boot-starter</artifactId>
            <version>${knife4j.version}</version>
        </dependency>
        <!--jjwt-->
        <dependency>
            <groupId>io.jsonwebtoken</groupId>
            <artifactId>jjwt</artifactId>
            <version>${jwt.version}</version>
        </dependency>
        <!--fastjson-->
        <dependency>
            <groupId>com.alibaba</groupId>
            <artifactId>fastjson</artifactId>
            <version>${fastjson.version}</version>
        </dependency>
    </dependencies>
</dependencyManagement>

<build>
    <plugins>
        <plugin>
            <groupId>org.apache.maven.plugins</groupId>
            <artifactId>maven-compiler-plugin</artifactId>
            <version>3.1</version>
            <configuration>
                <source>1.8</source>
                <target>1.8</target>
            </configuration>
        </plugin>
    </plugins>
</build>
```



#### 2.2.2 `common` 无依赖

#### 2.2.3 `common-log` 依赖





#### 2.2.4 `common-util` 依赖

```xml
<dependencies>
    <dependency>
        <groupId>com.atguigu</groupId>
        <artifactId>model</artifactId>
        <version>1.0</version>
    </dependency>
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-web</artifactId>
        <scope>provided</scope>
    </dependency>
    <dependency>
        <groupId>io.jsonwebtoken</groupId>
        <artifactId>jjwt</artifactId>
    </dependency>
    <dependency>
        <groupId>org.projectlombok</groupId>
        <artifactId>lombok</artifactId>
    </dependency>
    <dependency>
        <groupId>com.alibaba</groupId>
        <artifactId>fastjson</artifactId>
    </dependency>
</dependencies>
```



#### 2.2.5 `service-util` 依赖

```xml
<dependencies>
    <dependency>
        <groupId>com.atguigu</groupId>
        <artifactId>common-util</artifactId>
        <version>1.0</version>
    </dependency>
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-web</artifactId>
    </dependency>
    <dependency>
        <groupId>com.baomidou</groupId>
        <artifactId>mybatis-plus-boot-starter</artifactId>
    </dependency>
    <!--mysql-->
    <dependency>
        <groupId>mysql</groupId>
        <artifactId>mysql-connector-java</artifactId>
    </dependency>
</dependencies>
```



#### 2.2.6 `spring-security` 依赖





#### 2.2.7 `model` 依赖

```xml
<dependencies>
    <!--lombok用来简化实体类-->
    <dependency>
        <groupId>org.projectlombok</groupId>
        <artifactId>lombok</artifactId>
    </dependency>
    <dependency>
        <groupId>com.github.xiaoymin</groupId>
        <artifactId>knife4j-spring-boot-starter</artifactId>
        <scope>provided</scope>
    </dependency>
    <dependency>
        <groupId>com.baomidou</groupId>
        <artifactId>mybatis-plus-boot-starter</artifactId>
        <scope>provided</scope>
    </dependency>
</dependencies>
```



#### 2.2.8 `service` 无依赖

#### 2.2.9 `service-system` 依赖

```xml
<packaging>jar</packaging>

 <dependencies>
     <dependency>
         <groupId>com.atguigu</groupId>
         <artifactId>service-util</artifactId>
         <version>1.0</version>
     </dependency>
     
     <dependency>
         <groupId>org.springframework.boot</groupId>
         <artifactId>spring-boot-starter-test</artifactId>
         <scope>test</scope>
     </dependency>
 </dependencies>

 <build>
     <finalName>${project.artifactId}</finalName>
     <plugins>
         <plugin>
             <groupId>org.springframework.boot</groupId>
             <artifactId>spring-boot-maven-plugin</artifactId>
         </plugin>
     </plugins>
 </build>
```



### 2.3 确保 `github` 上项目结构的完整

- 因为 `github` 上不能保存空文件夹, 所以要在项目空文件夹下创建文件, 确保 `github` 上的项目结构的完整

```bash
find . \( -type d -empty \) -exec touch {}/.gitxxx \;
```



## 3 使用 `Mybatis-plus`

### 3.1 依赖<已引入>

```xml
<dependency>
    <groupId>com.baomidou</groupId>
    <artifactId>mybatis-plus-boot-starter</artifactId>
    <version>3.4.1</version>
</dependency>
```



### 3.2 配置文件

- `application.yml`

```yaml
spring:
  application:
    name: service-system
  profiles:
    active: prod
```

- `application-dev.yml`

```yaml
server:
  port: 1110
mybatis-plus:
  configuration:
    # 查看日志
    log-impl: org.apache.ibatis.logging.stdout.StdOutImpl
spring:
  datasource:
    driver-class-name: com.mysql.cj.jdbc.Driver
    url: jdbc:mysql://localhost:3306/guigu-auth?characterEncoding=utf-8&useSSL=false
    username: root
    password: 12345678
```

- `application-prod.yml`

```yaml
server:
  port: 1110
mybatis-plus:
  configuration:
    # 查看日志
    log-impl: org.apache.ibatis.logging.stdout.StdOutImpl 
spring:
  datasource:
    driver-class-name: com.mysql.cj.jdbc.Driver
    url: ${SPRING_DATASOURCE_URL}
    username: root
    password: ${SPRING_DATASOURCE_PASSWORD}
```

- 环境

![img](https://cdn.nlark.com/yuque/0/2022/png/12811585/1668125403729-34de49d3-0db6-4dd0-8cb4-2888eee6aa08.png)

- `java -jar service-system.jar `

```
--spring.profiles.active='prod' 
--spring.datasource.url='jdbc:mysql://localhost:3306/guigu-auth?characterEncoding=utf-8&useSSL=false' 
--spring.datasource.password='xxx'
```

### 3.3 启动类

![img](https://cdn.nlark.com/yuque/0/2022/png/12811585/1668048564393-bab40f78-74f9-4496-a053-a829b8c5fe13.png)

```java
package com.atguigu.system;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 权限服务启动类
 *
 * @author 陈江林
 * @date 2022/11/10 11:59
 */
@SpringBootApplication
@MapperScan("com.atguigu.system.mapper")
@ComponentScan(basePackages = "com.atguigu")
public class ServiceAuthApplication {

    public static void main(String[] args) {
        SpringApplication.run(ServiceAuthApplication.class, args);
    }

}
```



### 3.4 新建 `Mapper` 接口

![img](https://cdn.nlark.com/yuque/0/2022/png/12811585/1668065316255-f2a7a074-09a3-4156-a6d9-811357f25cf8.png)

```java
package com.atguigu.system.mapper;

import com.atguigu.model.system.SysRole;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.springframework.stereotype.Repository;

/**
 * Mapper 接口
 *
 * @author 陈江林
 * @date 2022/11/10 14:22
 */
@Repository
public interface SysRoleMapper extends BaseMapper<SysRole> {
}
```

### 3.5 新建测试类

```java
package com.atguigu.system;

import com.atguigu.model.system.SysRole;
import com.atguigu.system.mapper.SysRoleMapper;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.function.Supplier;

/**
 * 测试一下 CURD
 *
 * @author 陈江林
 * @date 2022/11/10 14:18
 */
@SpringBootTest
public class ServiceAuthApplicationTest {

    @Autowired
    private SysRoleMapper sysRoleMapper;

    /**
     * 根据 id 获取系统角色实体对象
     */
    @Test
    public void findSysRoleById() {
        SysRole sysRole = sysRoleMapper.selectById(1L);
        System.out.println(sysRole);
    }

    /**
     * 查询所有
     */
    @Test
    public void findAll() {
        List<SysRole> sysRoles = sysRoleMapper.selectList(null);
        System.out.println(sysRoles);
    }

    /**
     * 添加数据
     */
    @Test
    public void saveSysRole() {
        sysRoleMapper.insert(
                ((Supplier<SysRole>) () -> {
                    SysRole sysRole = new SysRole();
                    sysRole.setRoleName("测试角色");
                    sysRole.setRoleCode("TEST_ROLE");
                    sysRole.setDescription("测试角色");
                    return sysRole;
                }).get()
        );

        // 查看
        System.out.println(sysRoleMapper.selectList(null));
    }

    /**
     * 修改数据
     */
    @Test
    public void updateSysRole() {
        sysRoleMapper.updateById(
                ((Supplier<SysRole>) () -> {
                    // 根据 id 获取实体对象
                    SysRole sysRole = sysRoleMapper.selectOne(
                            new LambdaQueryWrapper<SysRole>()
                                    .eq(SysRole::getRoleCode, "TEST_ROLE")
                    );

                    sysRole.setDescription("测试修改角色信息");
                    return sysRole;
                }).get()
        );

        // 查看
        System.out.println(sysRoleMapper.selectOne(
                new LambdaQueryWrapper<SysRole>()
                        .eq(SysRole::getRoleCode, "TEST_ROLE")
        ));
    }

    /**
     * 删除数据
     */
    @Test
    public void removeSysRole() {
        sysRoleMapper.delete(new LambdaQueryWrapper<SysRole>()
                .eq(SysRole::getRoleCode, "TEST_ROLE")
        );

        // 查看
        System.out.println(sysRoleMapper.selectList(null));
    }

}
```



### 3.6 新建服务接口类

![img](https://cdn.nlark.com/yuque/0/2022/png/12811585/1668066107110-dd3f1c6e-b890-4100-921f-dd7daae4a8f3.png)

```java
package com.atguigu.system.service;

import com.atguigu.model.system.SysRole;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * 系统角色 服务接口类
 *
 * @author 陈江林
 * @date 2022/11/10 15:40
 */
public interface SysRoleService extends IService<SysRole> {
}
```

### 3.7 新建服务实现类

![img](https://cdn.nlark.com/yuque/0/2022/png/12811585/1668066142959-a1307eab-f76e-4a7c-849a-45aa197b801a.png)

```java
package com.atguigu.system.service.impl;

import com.atguigu.model.system.SysRole;
import com.atguigu.system.mapper.SysRoleMapper;
import com.atguigu.system.service.SysRoleService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * 系统角色 服务实现类
 *
 * @author 陈江林
 * @date 2022/11/10 15:42
 */
@Service
public class SysRoleServiceImpl extends ServiceImpl<SysRoleMapper, SysRole> implements SysRoleService {
}
```



### 3.8 新建测试类

![img](https://cdn.nlark.com/yuque/0/2022/png/12811585/1668066910304-9559637f-fd32-47f1-afcf-47e461f1234c.png)

```java
package com.atguigu.system;

import com.atguigu.model.system.SysRole;
import com.atguigu.system.service.SysRoleService;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.List;
import java.util.function.Supplier;

/**
 * 测试 Mybatis Plus 的 服务接口的 CURD
 *
 * @author 陈江林
 * @date 2022/11/10 15:46
 */
@SpringBootTest
public class MpServiceTest {

    @Autowired
    private SysRoleService sysRoleService;

    /**
     * 根据 id 获取系统角色实体对象
     */
    @Test
    public void findSysRoleById() {
        SysRole sysRole = sysRoleService.getById(1L);
        System.out.println(sysRole);
    }

    /**
     * 查询所有
     */
    @Test
    public void findAll() {
        List<SysRole> sysRoles = sysRoleService.list();
        System.out.println(sysRoles);
    }

    /**
     * 添加数据
     */
    @Test
    public void saveSysRole() {
        sysRoleService.save(
                ((Supplier<SysRole>) () -> {
                    SysRole sysRole = new SysRole();
                    sysRole.setRoleName("测试角色");
                    sysRole.setRoleCode("TEST_ROLE");
                    sysRole.setDescription("测试角色");
                    return sysRole;
                }).get()
        );

        // 查看
        System.out.println(sysRoleService.list());
    }

    /**
     * 修改数据
     */
    @Test
    public void updateSysRole() {
        sysRoleService.updateById(
                ((Supplier<SysRole>) () -> {
                    // 根据 id 获取实体对象
                    SysRole sysRole = sysRoleService.getOne(
                            new LambdaQueryWrapper<SysRole>()
                                    .eq(SysRole::getRoleCode, "TEST_ROLE")
                    );

                    sysRole.setDescription("测试修改角色信息");
                    return sysRole;
                }).get()
        );

        // 查看
        System.out.println(sysRoleService.getOne(
                new LambdaQueryWrapper<SysRole>()
                        .eq(SysRole::getRoleCode, "TEST_ROLE")
        ));
    }

    /**
     * 删除数据 - 逻辑删除
     */
    @Test
    public void removeSysRole() {
        sysRoleService.remove(new LambdaQueryWrapper<SysRole>()
                .eq(SysRole::getRoleCode, "TEST_ROLE")
        );

        // 查看
        System.out.println(sysRoleService.list());
    }

    /**
     * 批量删除
     */
    @Test
    public void removeSysRoles() {
        sysRoleService.removeByIds(Arrays.asList(1, 2));

        // 查看
        System.out.println(sysRoleService.list());
    }

}
```



## 4 整合 `swagger2`

### 4.1 集成 `knife4j`

- 文档: `https://doc.xiaominfo.com/`
- 地址: `http://localhost:1110/doc.html`

- `knife4j` 是为 `JAVA MVC` 框架集成 `Swagger` 生成 `API` 文档的增强解决方案

#### 4.1.1 第一步 添加依赖包

- `knife4j`属于`service`模块公共资源, 因此我们集成到`service-util`模块中

1. 添加依赖

```xml
<!--引入Knife4j的官方start包,Swagger2基于Springfox2.10.5项目-->
<dependency>
    <groupId>com.github.xiaoymin</groupId>
    <!--使用Swagger2-->
    <artifactId>knife4j-spring-boot-starter</artifactId>
</dependency>
```

#### 4.1.2 添加`knife4j`配置



```java
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
```



### 4.2 新建控制类, 使用 `swagger`注解

![img](https://cdn.nlark.com/yuque/0/2022/png/12811585/1668067739641-700323a2-1083-4ce6-9fa4-80238ac812b7.png)

```java
package com.atguigu.system.controller;

import com.atguigu.model.system.SysRole;
import com.atguigu.system.service.SysRoleService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author 陈江林
 * @date 2022/11/10 16:08
 */
@Api(tags = "角色管理接口")
@RestController
@RequestMapping("/admin/system/sysRole")
public class SysRoleController {

    @Autowired
    private SysRoleService sysRoleService;

    /**
     * 查询所有
     *
     * @return {@link List}<{@link SysRole}>
     */
    @ApiOperation(value = "查询所有")
    @GetMapping("/findAll")
    public List<SysRole> findAll() {
        return sysRoleService.list();
    }

    /**
     * 根据 id 删除数据
     *
     * @return {@link List}<{@link SysRole}>
     */
    @ApiImplicitParam(name = "id", value = "角色id", required = true)
    @ApiOperation(value = "逻辑删除")
    @DeleteMapping("/remove/{id}")
    public boolean removeById(
            @PathVariable Long id
    ) {
        return sysRoleService.removeById(id);
    }

}
```



### 4.3 测试

![img](https://cdn.nlark.com/yuque/0/2022/png/12811585/1668122757367-aaa0a3be-1bc5-428e-87c7-b054067e25fb.png)



## 5 统一返回结果类

列表：

```json
{
  "code": 200,
  "message": "成功",
  "data": [
    {
      "id": 2,
      "roleName": "系统管理员"
    }
  ],
  "ok": true
}
```

分页：

```json
{
  "code": 200,
  "message": "成功",
  "data": {
    "records": [
      {
        "id": 2,
        "roleName": "系统管理员"
      },
      {
        "id": 3,
        "name": "普通管理员"
      }
    ],
    "total": 10,
    "size": 3,
    "current": 1,
    "orders": [],
    "hitCount": false,
    "searchCount": true,
    "pages": 2
  },
  "ok": true
}
```

成功-没有返回数据：

```json
{
  "code": 200,
  "message": "成功",
  "data": null,
  "ok": true
}
```

失败：

```json
{
  "code": 201,
  "message": "失败",
  "data": null,
  "ok": false
}
```



### 5.1 新建 `Result`

![img](https://cdn.nlark.com/yuque/0/2022/png/12811585/1668131586050-8511a5e7-bb6a-4e72-a652-a2562d900723.png)

```java
package com.atguigu.common.result;

import lombok.Data;

/**
 * 统一返回结果类
 *
 * @author 陈江林
 * @date 2022/11/11 09:33
 */
@Data
public class Result<T> {

    /**
     * 返回码
     */
    private Integer code;

    /**
     * 返回消息
     */
    private String message;

    /**
     * 返回数据
     */
    private T data;

    public Result() {
    }

    /**
     * 返回数据
     *
     * @param data 数据
     * @return {@link Result}<{@link T}>
     */
    protected static <T> Result<T> build(T data) {
        Result<T> result = new Result<T>();
        if (data != null) {
            result.setData(data);
        }

        return result;
    }

    public static <T> Result<T> build(T body, Integer code, String message) {
        Result<T> result = build(body);
        result.setCode(code);
        result.setMessage(message);
        return result;
    }

    public static <T> Result<T> build(T body, ResultCodeEnum resultCodeEnum) {
        Result<T> result = build(body);
        result.setCode(resultCodeEnum.getCode());
        result.setMessage(resultCodeEnum.getMessage());
        return result;
    }

    public static <T> Result<T> ok() {
        return Result.ok(null);
    }

    /**
     * 操作成功
     *
     * @param data baseCategory1List
     * @return {@link Result}<{@link T}>
     */
    public static <T> Result<T> ok(T data) {
        return build(data, ResultCodeEnum.SUCCESS);
    }

    public static <T> Result<T> fail() {
        return Result.fail(null);
    }

    /**
     * 操作失败
     *
     * @param data 数据
     * @return {@link Result}<{@link T}>
     */
    public static <T> Result<T> fail(T data) {
        return build(data, ResultCodeEnum.FAIL);
    }

    public Result<T> message(String msg) {
        this.setMessage(msg);
        return this;
    }

    public Result<T> code(Integer code) {
        this.setCode(code);
        return this;
    }
}
```

### 5.2 新建 `ResultCodeEnum`

![img](https://cdn.nlark.com/yuque/0/2022/png/12811585/1668131611438-98b55230-116d-476a-85b6-6ea4b803e7db.png)

```java
package com.atguigu.common.result;

import lombok.Getter;

/**
 * 统一返回结果状态信息类
 *
 * @author 陈江林
 * @date 2022/11/11 09:40
 */
@Getter
public enum ResultCodeEnum {

    SUCCESS(200, "成功"),
    FAIL(201, "失败"),
    SERVICE_ERROR(2012, "服务异常"),
    DATA_ERROR(204, "数据异常"),
    ILLEGAL_REQUEST(205, "非法请求"),
    REPEAT_SUBMIT(206, "重复提交"),
    ARGUMENT_VALID_ERROR(210, "参数校验异常"),

    LOGIN_AUTH(208, "未登陆"),
    PERMISSION(209, "没有权限"),
    ACCOUNT_ERROR(214, "账号不正确"),
    PASSWORD_ERROR(215, "密码不正确"),
    LOGIN_MOBLE_ERROR(216, "账号不正确"),
    ACCOUNT_STOP(217, "账号已停用"),
    NODE_ERROR(218, "该节点下有子节点，不可以删除");

    private Integer code;

    private String message;

    ResultCodeEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
```

### 5.3 修改角色管理控制类

```java
package com.atguigu.system.controller;

import com.atguigu.common.result.Result;
import com.atguigu.model.system.SysRole;
import com.atguigu.system.service.SysRoleService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author 陈江林
 * @date 2022/11/10 16:08
 */
@Api(tags = "角色管理接口")
@RestController
@RequestMapping("/admin/system/sysRole")
public class SysRoleController {

    @Autowired
    private SysRoleService sysRoleService;

    /**
     * 查询所有
     *
     * @return {@link List}<{@link SysRole}>
     */
    @ApiOperation(value = "查询所有")
    @GetMapping("/findAll")
    public Result<List<SysRole>> findAll() {
        return Result.ok(sysRoleService.list());
    }

    /**
     * 根据 id 删除数据
     *
     * @return {@link List}<{@link SysRole}>
     */
    @ApiImplicitParam(name = "id", value = "角色id", required = true)
    @ApiOperation(value = "逻辑删除")
    @DeleteMapping("/remove/{id}")
    public Result<Boolean> removeById(
            @PathVariable Long id
    ) {
        boolean isSuccess = sysRoleService.removeById(id);
        if (isSuccess) {
            return Result.ok();
        } else {
            return Result.fail();
        }
    }

}
```



## 6 角色管理接口

![img](https://cdn.nlark.com/yuque/0/2022/jpeg/12811585/1668131915182-837672ab-b745-48cc-9105-a06220fcd8cb.jpeg)



### 6.1 实体类

#### 6.1.1 通用属性类 `BaseEntity`

```java
package com.atguigu.model.base;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableLogic;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * 通用属性类
 *
 * @author 陈江林
 * @date 2022/11/11
 */
@Data
public class BaseEntity implements Serializable {

    //@TableId(type = IdType.AUTO)
    @ApiModelProperty("唯一标识")
    private String id;

    @ApiModelProperty("创建时间")
    @TableField("create_time")
    private Date createTime;

    @ApiModelProperty("更新时间")
    @TableField("update_time")
    private Date updateTime;

    @ApiModelProperty("逻辑删除{0: 没有删除,1: 已经删除}")
    @TableLogic
    @TableField("is_deleted")
    private Integer isDeleted;

    @ApiModelProperty("其他参数")
    @TableField(exist = false)
    private Map<String, Object> param = new HashMap<>();
}
```



#### 6.1.2 角色实体类`SysRole`

```java
package com.atguigu.model.system;

import com.atguigu.model.base.BaseEntity;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@ApiModel("角色实体类")
@Data
@TableName("sys_role")
public class SysRole extends BaseEntity {
	
	private static final long serialVersionUID = 1L;

	@ApiModelProperty("角色名称")
	@TableField("role_name")
	private String roleName;

	@ApiModelProperty("角色编码")
	@TableField("role_code")
	private String roleCode;

	@ApiModelProperty("描述")
	@TableField("description")
	private String description;

}
```



#### 6.1.2 角色查询条件视图类 `SysRoleQueryVo`

```java
package com.atguigu.model.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

@ApiModel("角色查询条件视图类")
@Data
public class SysRoleQueryVo implements Serializable {

	private static final long serialVersionUID = 1L;

	@ApiModelProperty("角色名称")
	private String roleName;

}
```



### 6.2 条件分页查询

#### 6.2.1 分页插件

![img](https://cdn.nlark.com/yuque/0/2022/png/12811585/1668132299744-25c34efd-0f06-481f-974e-301f223a7f3d.png)

```java
package com.atguigu.system.config;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.autoconfigure.ConfigurationCustomizer;
import com.baomidou.mybatisplus.extension.plugins.MybatisPlusInterceptor;
import com.baomidou.mybatisplus.extension.plugins.inner.PaginationInnerInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * MybatisPlus 配置类
 *
 * @author 陈江林
 * @date 2022/11/11 10:04
 */
@Configuration
public class MybatisPlusConfig {

    @Bean
    public MybatisPlusInterceptor mybatisPlusInterceptor() {
        MybatisPlusInterceptor interceptor = new MybatisPlusInterceptor();
        interceptor.addInnerInterceptor(new PaginationInnerInterceptor(DbType.MYSQL));
        return interceptor;
    }

}
```



#### 6.2.2 控制类

```java
@ApiOperation(value = "条件分页查询")
@GetMapping("/{page}/{limit}")
public Result<IPage<SysRole>> findQueryRole(
        @PathVariable Long page,
        @PathVariable Long limit,
        SysRoleQueryVo sysRoleQueryVo
) {
    return Result.ok(sysRoleService.getPage(new Page<>(page, limit), sysRoleQueryVo));
}
```

#### 6.2.3 服务接口类

```java
package com.atguigu.system.service;

import com.atguigu.model.system.SysRole;
import com.atguigu.model.vo.SysRoleQueryVo;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * 系统角色 服务接口类
 *
 * @author 陈江林
 * @date 2022/11/10 15:40
 */
public interface SysRoleService extends IService<SysRole> {
    /**
     * 获取分页数据
     *
     * @param sysRolePage
     * @param sysRoleQueryVo
     * @return {@link IPage}<{@link SysRole}>
     */
    IPage<SysRole> getPage(Page<SysRole> sysRolePage, SysRoleQueryVo sysRoleQueryVo);
}
```

#### 6.2.4 服务实现类

```java
package com.atguigu.system.service.impl;

import com.atguigu.model.system.SysRole;
import com.atguigu.model.vo.SysRoleQueryVo;
import com.atguigu.system.mapper.SysRoleMapper;
import com.atguigu.system.service.SysRoleService;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * 系统角色 服务实现类
 *
 * @author 陈江林
 * @date 2022/11/10 15:42
 */
@Service
public class SysRoleServiceImpl extends ServiceImpl<SysRoleMapper, SysRole> implements SysRoleService {
///    @Override
///    public IPage<SysRole> getPage(Page<SysRole> sysRolePage, SysRoleQueryVo sysRoleQueryVo) {
///        LambdaQueryWrapper<SysRole> wrapper = new LambdaQueryWrapper<>();
///        if (sysRoleQueryVo != null) {
///            String roleName = sysRoleQueryVo.getRoleName();
///            if (StringUtils.isEmpty(roleName)) {
///                wrapper.like(SysRole::getRoleName, roleName);
///            }
///        }
///
///        return baseMapper.selectPage(sysRolePage, wrapper);
///    }

    @Override
    public IPage<SysRole> getPage(Page<SysRole> sysRolePage, SysRoleQueryVo sysRoleQueryVo) {
        return baseMapper.selectPage(sysRolePage, sysRoleQueryVo);
    }
}
```

#### 6.2.5 `Mapper`接口

```java
package com.atguigu.system.mapper;

import com.atguigu.model.system.SysRole;
import com.atguigu.model.vo.SysRoleQueryVo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * Mapper 接口
 *
 * @author 陈江林
 * @date 2022/11/10 14:22
 */
@Repository
public interface SysRoleMapper extends BaseMapper<SysRole> {
    /**
     * 条件分页查询
     *
     * @param sysRolePage
     * @param sysRoleQueryVo
     * @return {@link IPage}<{@link SysRole}>
     */
    IPage<SysRole> selectPage(Page<SysRole> sysRolePage, @Param("vo") SysRoleQueryVo sysRoleQueryVo);
}
```

#### 6.2.6 `Mapper.xml`

```xml
<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE mapper
        PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN"
        "http://mybatis.org/dtd/mybatis-3-mapper.dtd">
<mapper namespace="com.atguigu.system.mapper.SysRoleMapper">

    <resultMap id="RoleMap" type="com.atguigu.model.system.SysRole" autoMapping="true"/>

    <!-- 用于select查询公用抽取的列 -->
    <sql id="columns">
        id,role_name,role_code,description,create_time,update_time,is_deleted
    </sql>

    <select id="selectPage" resultMap="RoleMap">
        select <include refid="columns" />
        from sys_role
        <where>
            <if test="vo.roleName != null and vo.roleName != ''">
                and role_name like CONCAT('%',#{vo.roleName},'%')
            </if>
            and is_deleted = 0
        </where>
        order by id desc
    </select>

</mapper>
```



### 6.3 角色添加

```java
@ApiOperation("角色添加")
@PostMapping("/save")
public Result saveRole(
        @RequestBody SysRole sysRole
) {
    if (sysRoleService.save(sysRole)) {
        return Result.ok();
    } else {
        return Result.fail();
    }
}
```



### 6.4 角色修改

```java
@ApiOperation("角色修改")
@PutMapping("/update")
public Result updateRole(
        @RequestBody SysRole sysRole
) {
    if (sysRoleService.updateById(sysRole)) {
        return Result.ok();
    } else {
        return Result.fail();
    }
}

@ApiOperation("根据id查询角色")
@GetMapping("/findRoleById/{id}")
public Result<SysRole> findRoleById(
        @PathVariable Long id
) {
    return Result.ok(sysRoleService.getById(id));
}
```



### 6.5 批量删除

```java
@ApiOperation("批量删除")
@DeleteMapping("/batchRemove")
public Result batchRemove(
        @RequestBody List<Long> ids
) {
    if (sysRoleService.removeByIds(ids)) {
        return Result.ok();
    } else {
        return Result.fail();
    }
}
```



## 7 统一异常处理

### 7.1 新建全局异常处理类 `GlobalExceptionHandler`

![img](https://cdn.nlark.com/yuque/0/2022/png/12811585/1668157491479-b5c47dc9-d148-4fd1-9599-1c0e4fe9bb2a.png)

```java
package com.atguigu.system.exception;

import com.atguigu.common.result.Result;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 全局异常处理类
 *
 * @author 陈江林
 * @date 2022/11/11 17:02
 */
@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    @ResponseBody
    public Result error(Exception e) {
        e.printStackTrace();
        return Result.fail();
    }

}
```

#### 7.1.1 测试

![img](https://cdn.nlark.com/yuque/0/2022/png/12811585/1668160434986-c9321598-16cc-4466-abd7-07c23896c209.png)

![img](https://cdn.nlark.com/yuque/0/2022/png/12811585/1668160598457-50d51759-277e-4a9a-984b-0d0908e5c215.png)



### 7.2 特定异常处理

```java
package com.atguigu.system.exception;

import com.atguigu.common.result.Result;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

/**
 * 全局异常处理类
 *
 * @author 陈江林
 * @date 2022/11/11 17:02
 */
@ControllerAdvice
@RestController
public class GlobalExceptionHandler {

    /**
     * 全局异常处理
     *
     * @param e e
     * @return {@link Result}
     */
    @ExceptionHandler(Exception.class)
    public Result error(Exception e) {
        e.printStackTrace();
        return Result.fail();
    }

    /**
     * 特定异常处理
     *
     * @param e e
     * @return {@link Result}
     */
    @ExceptionHandler(ArithmeticException.class)
    public Result error(ArithmeticException e) {
        e.printStackTrace();
        return Result.fail().message("算数运算异常!");
    }

}
```

#### 7.2.1 测试

![img](https://cdn.nlark.com/yuque/0/2022/png/12811585/1668158292487-1153bc36-42d3-4bb9-b133-fa55101f7b88.png)

![img](https://cdn.nlark.com/yuque/0/2022/png/12811585/1668159786757-c2bb9eea-6892-4a85-bc8a-9b06f05a6a59.png)



### 7.3 自定义异常处理

```java
    /**
     * 自定义异常处理
     *
     * @param e e
     * @return {@link Result}
     */
    @ExceptionHandler(GuiguException.class)
    public Result error(GuiguException e) {
        e.printStackTrace();
        return Result.fail().code(e.getCode()).message(e.getMessage());
    }
```

#### 7.3.1 新建 `GuiguException`

```java
package com.atguigu.system.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 自定义异常
 *
 * @author 陈江林
 * @date 2022/11/11 17:13
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class GuiguException extends RuntimeException {

    private Integer code;
    private String msg;

}
```

#### 7.3.2 测试

![img](https://cdn.nlark.com/yuque/0/2022/png/12811585/1668159203042-4c097e82-c8a8-45eb-a1fc-b7b58964aebf.png)

![img](https://cdn.nlark.com/yuque/0/2022/png/12811585/1668160219316-9aad2c93-c667-4365-83c5-b877b2a11e6d.png)
