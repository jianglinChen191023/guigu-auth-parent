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
- [三 用户管理](#三-用户管理)
    - [1 后端](#1-后端)
        - [1.1 代码生成器(旧)](#11-代码生成器旧)
            - [1.1.1 代码生成器依赖](#111-代码生成器依赖)
            - [1.1.2 代码生成器 `CodeGet`](#112-代码生成器-codeget)
        - [1.2 控制类](#12-控制类)
        - [1.3 服务接口](#13-服务接口)
        - [1.4 服务实现类](#14-服务实现类)
        - [1.5 `Mapper` 接口](#15-mapper-接口)
        - [1.6 `XML`](#16-xml)
            - [1.6.1 扩展](#161-扩展)
    - [2 前端](#2-前端)
        - [2.1 `API`](#21-api)
        - [2.2 路由](#22-路由)
        - [2.3 页面](#23-页面)
    - [3 分配角色功能-后端实现](#3-分配角色功能-后端实现)
        - [3.1 角色管理控制类](#31-角色管理控制类)
        - [3.2 新建用户角色中间表的`Mapper`接口](#32-新建用户角色中间表的mapper接口)
        - [3.3 用户角色中间表实体类`SysUserRole`](#33-用户角色中间表实体类sysuserrole)
- [四 菜单管理](#四-菜单管理)
    - [1 后端接口](#1-后端接口)
        - [1.1 控制层](#11-控制层)
        - [1.2 服务接口](#12-服务接口)
        - [1.3 服务实现](#13-服务实现)
    - [2 前端](#2-前端-1)
        - [2.1 `API`](#21-api-1)
        - [2.2 路由](#22-路由-1)
        - [2.3 列表显示](#23-列表显示)
            - [2.3.1 示例-`Table`表格](#231-示例-table表格)
            - [2.3.2 最终实现](#232-最终实现)
        - [2.4 添加/修改功能](#24-添加修改功能)
            - [2.4.1 示例-`Dialog`对话框](#241-示例-dialog对话框)
            - [2.4.2 演化示例](#242-演化示例)
            - [2.4.3 最终代码](#243-最终代码)
- [五 给角色分配权限(菜单)](#五-给角色分配权限菜单)
    - [1 后端](#1-后端-1)
        - [1.1 控制层`SysMenuController`](#11-控制层sysmenucontroller)
        - [1.2 服务接口](#12-服务接口-1)
        - [1.3 服务实现](#13-服务实现-1)
        - [1.4 新建`SysRoleMenuMapper`接口](#14-新建sysrolemenumapper接口)
        - [1.5 视图类`AssginMenuVo`](#15-视图类assginmenuvo)
        - [1.6 实体类`SysRoleMenu`](#16-实体类sysrolemenu)
    - [2 前端](#2-前端-2)
        - [2.1 路由](#21-路由)
        - [2.2 `API`](#22-api)
        - [2.3 角色管理-分配权限](#23-角色管理-分配权限)
- [六 权限管理](#六-权限管理)
    - [1 权限管理介绍](#1-权限管理介绍)
        - [1.1 菜单权限](#11-菜单权限)
        - [1.2 按钮权限](#12-按钮权限)
        - [1.3 权限管理设计思路](#13-权限管理设计思路)
    - [2 `JWT`](#2-jwt)
        - [2.1 `JWT`介绍](#21-jwt介绍)
        - [2.2 `JWT`令牌的组成](#22-jwt令牌的组成)
            - [2.2.1 `JWT`头](#221-jwt头)
            - [2.2.2 有效载荷](#222-有效载荷)
            - [2.2.3 签名哈希](#223-签名哈希)
            - [2.2.4 `Base64URL`算法](#224-base64url算法)
    - [3 登录保存用户状态（用户`id`，用户昵称）](#3-登录保存用户状态用户id用户昵称)
        - [3.2 方案一：使用`session`](#32-方案一使用session)
        - [3.2 方案二：使用`token`<我们使用`token`>](#32-方案二使用token我们使用token)
            - [3.2.1 `token`如何共享](#321-token如何共享)
    - [4 操作-项目集成`JWT`](#4-操作-项目集成jwt)
        - [4.1 依赖](#41-依赖)
        - [4.2 新建`JWT`帮助类](#42-新建jwt帮助类)
    - [5 用户登录](#5-用户登录)
        - [5.1 控制类](#51-控制类)
        - [5.2 服务接口](#52-服务接口)
        - [5.3 服务实现](#53-服务实现)
        - [5.4 `sysMenuService`](#54-sysmenuservice)
            - [5.4.1 接口](#541-接口)
            - [5.4.2 实现](#542-实现)
            - [5.4.3 `Mapper`接口](#543-mapper接口)
            - [5.4.4 `Mapper.xml`](#544-mapperxml)
    - [6 前端](#6-前端)
        - [6.1 修改`axios`请求工具`request.js`](#61-修改axios请求工具requestjs)
        - [6.2 修改仓库`store/modules/user.js`](#62-修改仓库storemodulesuserjs)
        - [6.3 `store/getter.js`](#63-storegetterjs)
        - [6.4 `src/router`](#64-srcrouter)
            - [6.4.1 `_import_production.js`](#641-_import_productionjs)
            - [6.4.2 `_import_development.js`](#642-_import_developmentjs)
        - [6.5 替换`src/permission.js`](#65-替换srcpermissionjs)
        - [6.6 `src/router`](#66-srcrouter)
        - [6.7 在`src/components`下新建 `/ParentView/index.vue`](#67-在srccomponents下新建-parentviewindexvue)
        - [6.8 修改`layout/components/SideBar/index.vue`](#68-修改layoutcomponentssidebarindexvue)
        - [6.9 在`util`目录下新建`btn-permission.js`文件](#69-在util目录下新建btn-permissionjs文件)
        - [6.10 `main.js`](#610-mainjs)
        - [6.11 按钮控制权限](#611-按钮控制权限)
- [七 整合 Spring Security](#七-整合-spring-security)
    - [1 `Spring Security`简介](#1-spring-security简介)
    - [2 历史](#2-历史)
    - [3 同款产品对比](#3-同款产品对比)
        - [3.1 `Spring Security`](#31-spring-security)
        - [3.2 `Shiro`](#32-shiro)
        - [3.3 `Spring-Security`和`shiro`对比](#33-spring-security和shiro对比)
    - [4 `Spring Security`实现权限](#4-spring-security实现权限)
    - [5 `Spirng Security`入门](#5-spirng-security入门)
        - [5.1 创建`spring-security`模块](#51-创建spring-security模块)
        - [5.2 依赖](#52-依赖)
        - [5.3 新建配置类](#53-新建配置类)
        - [5.4 `service-system`模块引入](#54-service-system模块引入)
        - [5.5 启动项目测试](#55-启动项目测试)
    - [6 用户认证](#6-用户认证)
        - [6.1 用户认证核心组件](#61-用户认证核心组件)
        - [6.2 `Authentication`中有什么信息?](#62-authentication中有什么信息)
        - [6.3 如何进行用户认证](#63-如何进行用户认证)
        - [6.4 加密器`PasswordEncoder`](#64-加密器passwordencoder)
        - [6.5 用户对象`UserDetails`](#65-用户对象userdetails)
        - [6.6 业务对象`UserDetailsService`](#66-业务对象userdetailsservice)
        - [6.7 自定义用户认证接口`TokenLoginFilter`](#67-自定义用户认证接口tokenloginfilter)
        - [6.8 认证解析`token`](#68-认证解析token)
        - [6.9 认证解析`token`](#69-认证解析token)
        - [6.10 通过`swagger`测试登录](#610-通过swagger测试登录)
    - [7 用户授权](#7-用户授权)
        - [7.1 修改`loadUserByUsername`接口方法](#71-修改loaduserbyusername接口方法)
        - [7.2 配置`redis`](#72-配置redis)
        - [7.3 修改`TokenLoginFilter`登录成功方法](#73-修改tokenloginfilter登录成功方法)
        - [7.4 修改`TokenAuthenticationFitler`](#74-修改tokenauthenticationfitler)
        - [7.5 修改配置类](#75-修改配置类)
        - [7.6 `service-system`模块添加`redis`配置](#76-service-system模块添加redis配置)
        - [7.7 控制`controller`层接口权限](#77-控制controller层接口权限)
        - [7.8 测试服务器端权限](#78-测试服务器端权限)
            - [7.8.1 用户无法登录-修改规则--`validate.js`](#781-用户无法登录-修改规则--validatejs)
        - [7.9 异常处理](#79-异常处理)
- [八 部门管理](#八-部门管理)
    - [1 后端](#1-后端-2)
        - [1.1 代码生成器，数据库表`sys_dept`](#11-代码生成器数据库表sys_dept)
        - [1.2 控制类](#12-控制类-1)
        - [1.3 服务接口](#13-服务接口-1)
        - [1.4 服务实现](#14-服务实现)
    - [2 前端](#2-前端-3)
        - [2.1 新建`sysDept/list.vue`](#21-新建sysdeptlistvue)
    - [](#-1)
        - [2.2 新建`API`](#22-新建api)
        - [2.3 表单规则 `@/utils/validate`](#23-表单规则-utilsvalidate)
- [九 岗位管理](#九-岗位管理)
    - [1 后端](#1-后端-3)
        - [1.1 代码生成器，数据库表`sys_post`](#11-代码生成器数据库表sys_post)
        - [1.2 控制类](#12-控制类-2)
        - [1.3 服务接口](#13-服务接口-2)
        - [1.4 服务实现](#14-服务实现-1)
        - [1.5 `Mapper`接口](#15-mapper接口)
        - [1.6 `Mapper.xml`](#16-mapperxml)
    - [2 前端](#2-前端-4)
        - [2.1 新建`sysPost/list.vue`](#21-新建syspostlistvue)
    - [](#-2)
        - [2.2 新建`API`](#22-新建api-1)
- [十 日志记录](#十-日志记录)
    - [1 后端功能实现-登录日志](#1-后端功能实现-登录日志)
        - [1.1 在`spring-security`模块创建`AsyncLoginLogService`](#11-在spring-security模块创建asyncloginlogservice)
        - [1.2 在`service-system`实现添加日志方法](#12-在service-system实现添加日志方法)
        - [1.3 在`TokenLoginFilter`调用方法实现](#13-在tokenloginfilter调用方法实现)
        - [1.4 配置`WebSecurityConfig`](#14-配置websecurityconfig)
        - [1.5 测试登录](#15-测试登录)
    - [2 功能实现-登录日志接口`SysLoginLogController`](#2-功能实现-登录日志接口sysloginlogcontroller)
    - [3 前端显示登录日志](#3-前端显示登录日志)
        - [3.1 新建`views/sysLoginLog/list.vue`](#31-新建viewssysloginloglistvue)
        - [3.2 `API`](#32-api)
    - [4 操作日志](#4-操作日志)
        - [4.1 页面效果](#41-页面效果)
        - [4.2 实现方式](#42-实现方式)
            - [4.2.1 创建`common-log`模块](#421-创建common-log模块)
            - [4.2.2 引入依赖](#422-引入依赖)
            - [4.2.3 新建自定义注解`Log`](#423-新建自定义注解log)
            - [4.2.4 创建枚举类](#424-创建枚举类)
            - [4.2.5 新建`aspect.LogAspect`](#425-新建aspectlogaspect)
            - [4.2.6 新建系统日志服务接口](#426-新建系统日志服务接口)
            - [4.2.7 `service-util`模块](#427-service-util模块)
            - [](#-3)
            - [4.2.8 `service-system`模块](#428-service-system模块)
        - [4.3 使用方式](#43-使用方式)
        - [4.4 操作日志接口](#44-操作日志接口)
            - [4.4.1 编写`SysOperLogController`](#441-编写sysoperlogcontroller)
            - [](#-4)
            - [4.4.2 服务接口](#442-服务接口)
            - [4.4.3 服务实现](#443-服务实现)
            - [4.4.4 `mapper`接口](#444-mapper接口)
        - [4.5 操作日志显示-前端](#45-操作日志显示-前端)
            - [4.5.1 `API`](#451-api)
            - [4.5.2 `sysOperLog/list`](#452-sysoperloglist)
- [十一 微服务](#十一-微服务)
    - [1 服务模块整合`Nacos`](#1-服务模块整合nacos)
        - [1.1 `common-sersvice`依赖](#11-common-sersvice依赖)
        - [1.2 父项目依赖](#12-父项目依赖)
        - [1.3 `service-system`配置](#13-service-system配置)
        - [1.4 启动类注解`@EnableDiscoveryClient`](#14-启动类注解enablediscoveryclient)
    - [2 使用`GateWay`网关](#2-使用gateway网关)
        - [2.1 新建模块`service-gateway`](#21-新建模块service-gateway)
        - [2.2 依赖](#22-依赖)
        - [2.3 启动类](#23-启动类)
        - [2.4 配置文件](#24-配置文件)
    - [3 `service-api`远程调用模块](#3-service-api远程调用模块)
        - [3.1 新建模块](#31-新建模块)
        - [3.2 依赖](#32-依赖)
        - [3.3 新建文件](#33-新建文件)
        - [3.4 `service-system`模块](#34-service-system模块)
            - [3.4.1 依赖](#341-依赖)
            - [3.4.2 接口](#342-接口)
    - [4 优化`保存登录日志`，使用远程调用<`spring-security`模块>](#4-优化保存登录日志使用远程调用spring-security模块)
        - [4.1 `spring-security`加入依赖](#41-spring-security加入依赖)
        - [4.2 更改保存](#42-更改保存)
        - [4.3 对应更改](#43-对应更改)
    - [5 `BUG`-`service-gateway`服务启动失败](#5-bug-service-gateway服务启动失败)
        - [5.1 解决方案-添加依赖](#51-解决方案-添加依赖)
    - [6 测试登录日志是否能正常保存](#6-测试登录日志是否能正常保存)
        - [6.1 （1）解决-请求白名单](#61-1解决-请求白名单)
        - [6.1 （2）解决`403`错误，配置`Spring-Security`](#61-2解决403错误配置spring-security)
- [十二 项目部署](#十二-项目部署)
    - [1 一般项目部署](#1-一般项目部署)
        - [1.1 前端部署](#11-前端部署)
    - [1.2 后端部署](#12-后端部署)
    - [2 `阿里云效`自动化部署](#2-阿里云效自动化部署)
        - [2.1 前端自动化部署](#21-前端自动化部署)
            - [2.1.1 新建流水线](#211-新建流水线)
        - [2.2 后端自动化部署](#22-后端自动化部署)
            - [2.2.1 推送`Maven`仓库](#221-推送maven仓库)
            - [2.2.2 覆盖推送-重复（仓库是禁止覆盖的）](#222-覆盖推送-重复仓库是禁止覆盖的)
            - [2.2.3 流水线](#223-流水线)
            - [2.2.4 流水线源](#224-流水线源)
            - [2.2.5 `Java`构建物上传](#225-java构建物上传)
            - [2.2.6 主机部署](#226-主机部署)
    - [3 前端使用`GitHub`的`Actions`自动化部署](#3-前端使用github的actions自动化部署)


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

```plsql
DROP DATABASE IF EXISTS `guigu-auth`;
CREATE DATABASE `guigu-auth` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci;
USE `guigu-auth`;

#
# Structure for table "sys_dept"
#
DROP TABLE IF EXISTS `sys_dept`;
CREATE TABLE `sys_dept`
(
    `id`          bigint(20)  NOT NULL AUTO_INCREMENT,
    `name`        varchar(50) NOT NULL DEFAULT '' COMMENT '部门名称',
    `parent_id`   bigint(20)           DEFAULT '0' COMMENT '上级部门id',
    `tree_path`   varchar(255)         DEFAULT ',' COMMENT '树结构',
    `sort_value`  int(11)              DEFAULT '1' COMMENT '排序',
    `leader`      varchar(20)          DEFAULT NULL COMMENT '负责人',
    `phone`       varchar(11)          DEFAULT NULL COMMENT '电话',
    `status`      tinyint(1)           DEFAULT '1' COMMENT '状态（1正常 0停用）',
    `create_time` timestamp   NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    `update_time` timestamp   NULL     DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
    `is_deleted`  bigint(20)  NOT NULL DEFAULT '0' COMMENT '删除标记（0:可用 其他:已删除）',
    PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB
  AUTO_INCREMENT = 2018
  DEFAULT CHARSET = utf8mb4
  ROW_FORMAT = COMPACT COMMENT ='组织机构';

#
# Data for table "sys_dept"
#

INSERT INTO `sys_dept`
VALUES (1, '硅谷集团有限公司', 0, ',1,', 1, '张老师', '15659090912', 1, '2022-05-24 16:13:13', '2022-05-24 16:13:13', 0),
       (10, '北京校区', 1, ',1,10,', 1, '李老师', '18790007789', 1, '2022-05-24 16:13:15', '2022-05-24 16:13:15', 0),
       (20, '上海校区', 1, ',1,20,', 1, '王老师', '15090987678', 1, '2022-05-25 14:02:25', '2022-05-25 14:02:25', 0),
       (30, '深圳校区', 1, ',1,30,', 1, '李老师', '15090987678', 1, '2022-05-25 14:02:24', '2022-05-25 14:02:24', 0),
       (1010, '教学部分', 10, ',1,10,1010,', 1, '李老师', '15090987678', 1, '2022-05-25 14:02:24', '2022-05-25 14:02:24', 0),
       (1020, '运营部门', 10, ',1,10,1020,', 1, '王老师', '15090987678', 1, '2022-05-25 14:02:29', '2022-05-25 14:02:29', 0),
       (1021, 'Java学科', 1010, ',1,10,1010,1021,', 1, '王老师', '15090987678', 1, '2022-05-24 16:13:31',
        '2022-05-24 16:13:31', 0),
       (1022, '大数据学科', 1010, ',1,10,1010,1022,', 1, '王老师', '15090987678', 1, '2022-05-25 14:02:22',
        '2022-05-25 14:02:22', 0),
       (1024, '前端学科', 1010, ',1,10,1010,1024,', 1, '李老师', '15090987678', 1, '2022-05-25 14:02:22',
        '2022-05-25 14:02:22', 0),
       (1025, '客服', 1020, ',1,10,1020,1025,', 1, '李老师', '15090987678', 1, '2022-05-25 14:02:23', '2022-05-25 14:02:23',
        0),
       (1026, '网站推广', 1020, ',1,10,1020,1026,', 1, '30.607366', '15090987678', 1, '2022-05-25 14:02:26',
        '2022-05-25 14:02:26', 0),
       (1027, '线下运营', 1020, ',1,10,1020,1027,', 1, '李老师', '15090987678', 1, '2022-05-25 14:02:26',
        '2022-05-25 14:02:26', 0),
       (1028, '设计', 1020, ',1,10,1020,1028,', 1, '李老师', '15090987678', 1, '2022-05-25 14:02:27', '2022-05-25 14:02:27',
        0),
       (2012, '教学部门', 20, ',1,20,2012,', 1, '王老师', '18909890765', 1, '2022-05-24 16:13:51', '2022-05-24 16:13:51', 0),
       (2013, '教学部门', 30, ',1,30,2013,', 1, '李老师', '18567867895', 1, '2022-05-24 16:13:50', '2022-05-24 16:13:50', 0),
       (2016, 'Java学科', 2012, ',1,20,2012,2012,', 1, '张老师', '15090909909', 1, '2022-05-25 10:51:12',
        '2022-05-25 10:51:12', 0),
       (2017, '大数据学科', 2012, ',1,20,2012,2012,', 1, '李老师', '15090980989', 1, '2022-05-27 09:11:54', NULL, 0);

#
# Structure for table "sys_login_log"
#
DROP TABLE IF EXISTS `sys_login_log`;
CREATE TABLE `sys_login_log`
(
    `id`          bigint(20) NOT NULL AUTO_INCREMENT COMMENT '访问ID',
    `username`    varchar(50)         DEFAULT '' COMMENT '用户账号',
    `ipaddr`      varchar(128)        DEFAULT '' COMMENT '登录IP地址',
    `status`      tinyint(1)          DEFAULT '0' COMMENT '登录状态（0成功 1失败）',
    `msg`         varchar(255)        DEFAULT '' COMMENT '提示信息',
    `access_time` datetime            DEFAULT NULL COMMENT '访问时间',
    `create_time` timestamp  NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    `update_time` timestamp  NULL     DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
    `is_deleted`  bigint(20) NOT NULL DEFAULT '0' COMMENT '删除标记（0:可用 其他:已删除）',
    PRIMARY KEY (`id`)
) ENGINE = InnoDB
  AUTO_INCREMENT = 3
  DEFAULT CHARSET = utf8 COMMENT ='系统访问记录';

#
# Data for table "sys_login_log"
#

INSERT INTO `sys_login_log`
VALUES (1, 'admin', '0:0:0:0:0:0:0:1', 1, '登录成功', NULL, '2022-06-10 11:24:14', NULL, 0),
       (2, 'admin', '127.0.0.1', 1, '登录成功', NULL, '2022-06-10 11:53:43', NULL, 0);

#
# Structure for table "sys_menu"
#
DROP TABLE IF EXISTS `sys_menu`;
CREATE TABLE `sys_menu`
(
    `id`          bigint(20)  NOT NULL AUTO_INCREMENT COMMENT '编号',
    `parent_id`   bigint(20)  NOT NULL DEFAULT '0' COMMENT '所属上级',
    `name`        varchar(20) NOT NULL DEFAULT '' COMMENT '名称',
    `type`        tinyint(3)  NOT NULL DEFAULT '0' COMMENT '类型(0:目录,1:菜单,2:按钮)',
    `path`        varchar(100)         DEFAULT NULL COMMENT '路由地址',
    `component`   varchar(100)         DEFAULT NULL COMMENT '组件路径',
    `perms`       varchar(100)         DEFAULT NULL COMMENT '权限标识',
    `icon`        varchar(100)         DEFAULT NULL COMMENT '图标',
    `sort_value`  int(11)              DEFAULT NULL COMMENT '排序',
    `status`      tinyint(4)           DEFAULT NULL COMMENT '状态(0:禁止,1:正常)',
    `create_time` timestamp   NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `update_time` timestamp   NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    `is_deleted`  bigint(20)  NOT NULL DEFAULT '0' COMMENT '删除标记（0:可用 其他:已删除）',
    PRIMARY KEY (`id`),
    KEY `idx_parent_id` (`parent_id`)
) ENGINE = InnoDB
  AUTO_INCREMENT = 35
  DEFAULT CHARSET = utf8mb4 COMMENT ='菜单表';


#
# Data for table "sys_menu"
#

INSERT INTO `sys_menu` (`id`, `parent_id`, `name`, `type`, `path`, `component`, `perms`, `icon`, `sort_value`, `status`,
                        `create_time`, `update_time`, `is_deleted`)
VALUES (2, 0, '系统管理', 0, 'system', 'Layout', NULL, 'el-icon-s-tools', 1, 1, '2021-05-31 18:05:37',
        '2022-06-09 09:23:24', 0),
       (3, 2, '用户管理', 1, 'sysUser', 'system/sysUser/list', '', 'el-icon-s-custom', 1, 1, '2021-05-31 18:05:37',
        '2022-06-09 09:22:47', 0),
       (4, 2, '角色管理', 1, 'sysRole', 'system/sysRole/list', '', 'el-icon-user-solid', 2, 1, '2021-05-31 18:05:37',
        '2022-06-09 09:37:18', 0),
       (5, 2, '菜单管理', 1, 'sysMenu', 'system/sysMenu/list', '', 'el-icon-s-unfold', 3, 1, '2021-05-31 18:05:37',
        '2022-06-09 09:37:21', 0),
       (6, 3, '查看', 2, NULL, NULL, 'btn.sysUser.list', NULL, 1, 1, '2021-05-31 18:05:37', '2022-06-09 09:22:38', 0),
       (7, 3, '添加', 2, NULL, NULL, 'btn.sysUser.add', NULL, 1, 1, '2021-05-31 18:05:37', '2022-06-09 09:22:38', 0),
       (8, 3, '修改', 2, NULL, NULL, 'btn.sysUser.update', NULL, 1, 1, '2021-05-31 18:05:37', '2022-06-09 09:22:38', 0),
       (9, 3, '删除', 2, NULL, NULL, 'btn.sysUser.remove', NULL, 1, 1, '2021-05-31 18:05:37', '2022-06-09 09:22:38', 0),
       (10, 4, '查看', 2, NULL, NULL, 'btn.sysRole.list', NULL, 1, 1, '2021-05-31 18:05:37', '2022-06-09 09:22:38', 0),
       (11, 4, '添加', 2, NULL, NULL, 'btn.sysRole.add', NULL, 1, 1, '2021-05-31 18:05:37', '2022-06-09 09:22:38', 0),
       (12, 4, '修改', 2, NULL, NULL, 'btn.sysRole.update', NULL, 1, 1, '2021-05-31 18:05:37', '2022-06-09 09:22:38', 0),
       (13, 4, '删除', 2, NULL, NULL, 'btn.sysRole.remove', NULL, 1, 1, '2021-05-31 18:05:37', '2022-06-09 09:22:38', 0),
       (14, 5, '查看', 2, NULL, NULL, 'btn.sysMenu.list', NULL, 1, 1, '2021-05-31 18:05:37', '2022-06-09 09:22:38', 0),
       (15, 5, '添加', 2, NULL, NULL, 'btn.sysMenu.add', NULL, 1, 1, '2021-05-31 18:05:37', '2022-06-09 09:22:38', 0),
       (16, 5, '修改', 2, NULL, NULL, 'btn.sysMenu.update', NULL, 1, 1, '2021-05-31 18:05:37', '2022-06-09 09:22:38', 0),
       (17, 5, '删除', 2, NULL, NULL, 'btn.sysMenu.remove', NULL, 1, 1, '2021-05-31 18:05:37', '2022-06-09 09:22:38', 0),
       (18, 3, '分配角色', 2, NULL, NULL, 'btn.sysUser.assignRole', NULL, 1, 1, '2022-05-23 17:14:32',
        '2022-06-09 09:22:38', 0),
       (19, 4, '分配权限', 2, 'assignAuth', 'system/sysRole/assignAuth', 'btn.sysRole.assignAuth', NULL, 1, 1,
        '2022-05-23 17:18:14', '2022-06-09 09:22:38', 0),
       (20, 2, '部门管理', 1, 'sysDept', 'system/sysDept/list', '', 'el-icon-s-operation', 4, 1, '2022-05-24 10:07:05',
        '2022-06-09 09:38:12', 0),
       (21, 20, '查看', 2, NULL, NULL, 'btn.sysDept.list', NULL, 1, 1, '2022-05-24 10:07:44', '2022-06-09 09:22:38', 0),
       (22, 2, '岗位管理', 1, 'sysPost', 'system/sysPost/list', '', 'el-icon-more-outline', 5, 1, '2022-05-24 10:25:30',
        '2022-06-09 09:38:13', 0),
       (23, 22, '查看', 2, NULL, NULL, 'btn.sysPost.list', NULL, 1, 1, '2022-05-24 10:25:45', '2022-06-09 09:22:38', 0),
       (24, 20, '添加', 2, NULL, NULL, 'btn.sysDept.add', NULL, 1, 1, '2022-05-25 15:31:27', '2022-06-09 09:22:38', 0),
       (25, 20, '修改', 2, NULL, NULL, 'btn.sysDept.update', NULL, 1, 1, '2022-05-25 15:31:41', '2022-06-09 09:22:38', 0),
       (26, 20, '删除', 2, NULL, NULL, 'btn.sysDept.remove', NULL, 1, 1, '2022-05-25 15:31:59', '2022-06-09 09:22:38', 0),
       (27, 22, '添加', 2, NULL, NULL, 'btn.sysPost.add', NULL, 1, 1, '2022-05-25 15:32:44', '2022-06-09 09:22:38', 0),
       (28, 22, '修改', 2, NULL, NULL, 'btn.sysPost.update', NULL, 1, 1, '2022-05-25 15:32:58', '2022-06-09 09:22:38', 0),
       (29, 22, '删除', 2, NULL, NULL, 'btn.sysPost.remove', NULL, 1, 1, '2022-05-25 15:33:11', '2022-06-09 09:22:38', 0),
       (30, 34, '操作日志', 1, 'sysOperLog', 'system/sysOperLog/list', '', 'el-icon-document-remove', 7, 1,
        '2022-05-26 16:09:59', '2022-06-09 09:39:23', 0),
       (31, 30, '查看', 2, NULL, NULL, 'btn.sysOperLog.list', NULL, 1, 1, '2022-05-26 16:10:17', '2022-06-09 09:22:38',
        0),
       (32, 34, '登录日志', 1, 'sysLoginLog', 'system/sysLoginLog/list', '', 'el-icon-s-goods', 8, 1, '2022-05-26 16:36:13',
        '2022-06-09 09:39:24', 0),
       (33, 32, '查看', 2, NULL, NULL, 'btn.sysLoginLog.list', NULL, 1, 1, '2022-05-26 16:36:31', '2022-06-09 09:36:36',
        0),
       (34, 2, '日志管理', 0, 'log', 'ParentView', '', 'el-icon-tickets', 6, 1, '2022-05-31 13:23:07',
        '2022-06-09 09:39:22', 0);

#
# Structure for table "sys_oper_log"
#
DROP TABLE IF EXISTS `sys_oper_log`;
CREATE TABLE `sys_oper_log`
(
    `id`             bigint(20) NOT NULL AUTO_INCREMENT COMMENT '日志主键',
    `title`          varchar(50)         DEFAULT '' COMMENT '模块标题',
    `business_type`  varchar(20)         DEFAULT '0' COMMENT '业务类型（0其它 1新增 2修改 3删除）',
    `method`         varchar(100)        DEFAULT '' COMMENT '方法名称',
    `request_method` varchar(10)         DEFAULT '' COMMENT '请求方式',
    `operator_type`  varchar(20)         DEFAULT '0' COMMENT '操作类别（0其它 1后台用户 2手机端用户）',
    `oper_name`      varchar(50)         DEFAULT '' COMMENT '操作人员',
    `dept_name`      varchar(50)         DEFAULT '' COMMENT '部门名称',
    `oper_url`       varchar(255)        DEFAULT '' COMMENT '请求URL',
    `oper_ip`        varchar(128)        DEFAULT '' COMMENT '主机地址',
    `oper_param`     varchar(2000)       DEFAULT '' COMMENT '请求参数',
    `json_result`    varchar(2000)       DEFAULT '' COMMENT '返回参数',
    `status`         int(1)              DEFAULT '0' COMMENT '操作状态（0正常 1异常）',
    `error_msg`      varchar(2000)       DEFAULT '' COMMENT '错误消息',
    `oper_time`      datetime            DEFAULT NULL COMMENT '操作时间',
    `create_time`    timestamp  NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    `update_time`    timestamp  NULL     DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
    `is_deleted`     tinyint(3) NOT NULL DEFAULT '0' COMMENT '删除标记（0:可用 其他:已删除）',
    PRIMARY KEY (`id`)
) ENGINE = InnoDB
  AUTO_INCREMENT = 64
  DEFAULT CHARSET = utf8 COMMENT ='操作日志记录';

#
# Data for table "sys_oper_log"
#

INSERT INTO `sys_oper_log`
VALUES (1, '角色管理', '1', 'com.atguigu.auth.controller.SysRoleController.save()', 'POST', '1', 'admin', '',
        '/admin/auth/sysRole/save', '', '{\"param\":{},\"roleCode\":\"\",\"roleName\":\"test\",\"id\":5}',
        '{\"code\":200,\"message\":\"成功\"}', 0, '', NULL, '2022-05-26 15:59:44', NULL, 0),
       (2, '角色管理', 'DELETE', 'com.atguigu.auth.controller.SysRoleController.remove()', 'DELETE', 'MANAGE', 'admin', '',
        '/admin/auth/sysRole/remove/5', '', '', '{\"code\":200,\"message\":\"成功\"}', 0, '', NULL, '2022-05-26 16:05:27',
        NULL, 0),
       (3, '角色管理', 'DELETE', 'com.atguigu.auth.controller.SysRoleController.remove()', 'DELETE', 'MANAGE', 'admin', '',
        '/admin/auth/sysRole/remove/4', '127.0.0.1', '', '{\"code\":200,\"message\":\"成功\"}', 1, '', NULL,
        '2022-05-26 16:52:40', NULL, 0),
       (4, '角色管理', 'UPDATE', 'com.atguigu.auth.controller.SysRoleController.updateById()', 'PUT', 'MANAGE', 'admin', '',
        '/admin/auth/sysRole/update', '127.0.0.1',
        '{\"isDeleted\":0,\"createTime\":1622507920000,\"param\":{},\"roleCode\":\"\",\"roleName\":\"普通管理员\",\"description\":\"普通管理员\",\"updateTime\":1645670566000,\"id\":2}',
        '{\"code\":200,\"message\":\"成功\"}', 1, '', NULL, '2022-05-27 08:47:54', NULL, 0),
       (5, '菜单管理', 'UPDATE', 'com.atguigu.auth.controller.SysMenuController.updateById()', 'PUT', 'MANAGE', 'admin', '',
        '/admin/auth/sysMenu/update', '127.0.0.1',
        '{\"code\":\"SysRole\",\"select\":false,\"level\":3,\"updateTime\":1653287810000,\"type\":1,\"parentId\":2,\"isDeleted\":0,\"children\":[{\"code\":\"btn.SysRole.list\",\"select\":false,\"level\":4,\"updateTime\":1622460772000,\"type\":2,\"parentId\":4,\"isDeleted\":0,\"children\":[],\"createTime\":1622455537000,\"param\":{},\"name\":\"查看\",\"id\":10},{\"code\":\"btn.SysRole.add\",\"select\":false,\"level\":4,\"updateTime\":1653547976000,\"type\":2,\"parentId\":4,\"isDeleted\":0,\"children\":[],\"createTime\":1622455537000,\"param\":{},\"name\":\"添加\",\"id\":11},{\"code\":\"btn.SysRole.update\",\"select\":false,\"level\":4,\"updateTime\":1653547981000,\"type\":2,\"parentId\":4,\"isDeleted\":0,\"children\":[],\"createTime\":1622455537000,\"param\":{},\"name\":\"修改\",\"id\":12},{\"code\":\"btn.SysRole.remove\",\"select\":false,\"level\":4,\"updateTime\":1622507874000,\"type\":2,\"parentId\":4,\"isDeleted\":0,\"children\":[],\"createTime\":1622455537000,\"param\":{},\"name\":\"删除\",\"id\":13},{\"code\":\"btn.SysRole.assignAuth\",\"select\":false,\"level\":4,\"toCode\":\"AssignAuth\",\"updateTime\":1653376735000,\"type\":2,\"parentId\":4,\"isDeleted\":0,\"children\":[],\"createTime\":1653297494000,\"param\":{},\"name\":\"分配权限\",\"id\":19}],\"createTime\":1622455537000,\"param\":{},\"name\":\"角色管理\",\"id\":4}',
        '{\"code\":200,\"message\":\"成功\"}', 1, '', NULL, '2022-05-27 08:48:08', NULL, 0),
       (6, '岗位管理', 'UPDATE', 'com.atguigu.auth.controller.SysPostController.updateById()', 'PUT', 'MANAGE', 'admin', '',
        '/admin/auth/sysPost/update', '127.0.0.1',
        '{\"isDeleted\":0,\"createTime\":1653359648000,\"param\":{},\"name\":\"总经理\",\"description\":\"2\",\"postCode\":\"zjl\",\"id\":6,\"status\":1}',
        '{\"code\":200,\"message\":\"成功\"}', 1, '', NULL, '2022-05-27 08:56:29', NULL, 0),
       (7, '岗位管理', 'INSERT', 'com.atguigu.auth.controller.SysPostController.save()', 'POST', 'MANAGE', 'admin', '',
        '/admin/auth/sysPost/save', '127.0.0.1',
        '{\"param\":{},\"name\":\"网咨\",\"description\":\"\",\"postCode\":\"wz\",\"id\":7,\"status\":1}',
        '{\"code\":200,\"message\":\"成功\"}', 1, '', NULL, '2022-05-27 08:56:37', NULL, 0),
       (8, '岗位管理', 'DELETE', 'com.atguigu.auth.controller.SysPostController.remove()', 'DELETE', 'MANAGE', 'admin', '',
        '/admin/auth/sysPost/remove/7', '127.0.0.1', '', '{\"code\":200,\"message\":\"成功\"}', 1, '', NULL,
        '2022-05-27 08:56:41', NULL, 0),
       (9, '菜单管理', 'UPDATE', 'com.atguigu.auth.controller.SysMenuController.updateById()', 'PUT', 'MANAGE', 'admin', '',
        '/admin/auth/sysMenu/update', '127.0.0.1',
        '{\"code\":\"btn.sysDept.list\",\"select\":false,\"level\":4,\"toCode\":\"\",\"updateTime\":1653358064000,\"type\":2,\"parentId\":20,\"isDeleted\":0,\"children\":[],\"createTime\":1653358064000,\"param\":{},\"name\":\"查看\",\"id\":21}',
        '{\"code\":200,\"message\":\"成功\"}', 1, '', NULL, '2022-05-27 09:02:49', NULL, 0),
       (10, '菜单管理', 'UPDATE', 'com.atguigu.auth.controller.SysMenuController.updateById()', 'PUT', 'MANAGE', 'admin',
        '', '/admin/auth/sysMenu/update', '127.0.0.1',
        '{\"code\":\"btn.sysDept.add\",\"select\":false,\"level\":4,\"toCode\":\"\",\"updateTime\":1653463887000,\"type\":2,\"parentId\":20,\"isDeleted\":0,\"children\":[],\"createTime\":1653463887000,\"param\":{},\"name\":\"添加\",\"id\":24}',
        '{\"code\":200,\"message\":\"成功\"}', 1, '', NULL, '2022-05-27 09:02:55', NULL, 0),
       (11, '菜单管理', 'UPDATE', 'com.atguigu.auth.controller.SysMenuController.updateById()', 'PUT', 'MANAGE', 'admin',
        '', '/admin/auth/sysMenu/update', '127.0.0.1',
        '{\"code\":\"btn.sysDept.update\",\"select\":false,\"level\":4,\"toCode\":\"\",\"updateTime\":1653463901000,\"type\":2,\"parentId\":20,\"isDeleted\":0,\"children\":[],\"createTime\":1653463901000,\"param\":{},\"name\":\"修改\",\"id\":25}',
        '{\"code\":200,\"message\":\"成功\"}', 1, '', NULL, '2022-05-27 09:03:01', NULL, 0),
       (12, '菜单管理', 'UPDATE', 'com.atguigu.auth.controller.SysMenuController.updateById()', 'PUT', 'MANAGE', 'admin',
        '', '/admin/auth/sysMenu/update', '127.0.0.1',
        '{\"code\":\"btn.sysDept.remove\",\"select\":false,\"level\":4,\"toCode\":\"\",\"updateTime\":1653463919000,\"type\":2,\"parentId\":20,\"isDeleted\":0,\"children\":[],\"createTime\":1653463919000,\"param\":{},\"name\":\"删除\",\"id\":26}',
        '{\"code\":200,\"message\":\"成功\"}', 1, '', NULL, '2022-05-27 09:03:07', NULL, 0),
       (13, '部门管理', 'UPDATE', 'com.atguigu.auth.controller.SysDeptController.updateById()', 'PUT', 'MANAGE', 'admin',
        '', '/admin/auth/sysDept/update', '127.0.0.1',
        '{\"leader\":\"张老师\",\"updateTime\":1653447072000,\"parentId\":2012,\"sortValue\":1,\"isDeleted\":0,\"createTime\":1653447072000,\"param\":{},\"phone\":\"15090909909\",\"name\":\"Java学科\",\"id\":2016,\"treePath\":\",1,20,2012,2012,\",\"status\":1}',
        '{\"code\":200,\"message\":\"成功\"}', 1, '', NULL, '2022-05-27 09:11:28', NULL, 0),
       (14, '部门管理', 'INSERT', 'com.atguigu.auth.controller.SysDeptController.save()', 'POST', 'MANAGE', 'admin', '',
        '/admin/auth/sysDept/save', '127.0.0.1',
        '{\"leader\":\"李老师\",\"parentId\":2012,\"param\":{},\"phone\":\"15090980989\",\"name\":\"大数据学科\",\"id\":2017,\"treePath\":\",1,20,2012,2012,\"}',
        '{\"code\":200,\"message\":\"成功\"}', 1, '', NULL, '2022-05-27 09:11:54', NULL, 0),
       (15, '部门管理', 'UPDATE', 'com.atguigu.auth.controller.SysDeptController.updateById()', 'PUT', 'MANAGE', 'admin',
        '', '/admin/auth/sysDept/update', '127.0.0.1',
        '{\"leader\":\"李老师\",\"parentId\":2012,\"sortValue\":1,\"isDeleted\":0,\"createTime\":1653613914000,\"param\":{},\"phone\":\"15090980989\",\"name\":\"大数据学科\",\"id\":2017,\"treePath\":\",1,20,2012,2012,\",\"status\":1}',
        '{\"code\":200,\"message\":\"成功\"}', 1, '', NULL, '2022-05-27 09:16:38', NULL, 0),
       (16, '角色管理', 'UPDATE', 'com.atguigu.auth.controller.SysRoleController.updateById()', 'PUT', 'MANAGE', 'admin',
        '', '/admin/auth/sysRole/update', '127.0.0.1',
        '{\"isDeleted\":0,\"createTime\":1622507920000,\"param\":{},\"roleCode\":\"COMMON\",\"roleName\":\"普通管理员\",\"description\":\"普通管理员\",\"updateTime\":1645670566000,\"id\":2}',
        '{\"code\":200,\"message\":\"成功\"}', 1, '', NULL, '2022-05-27 09:28:15', NULL, 0),
       (17, '角色管理', 'INSERT', 'com.atguigu.auth.controller.SysRoleController.save()', 'POST', 'MANAGE', 'admin', '',
        '/admin/auth/sysRole/save', '127.0.0.1', '{\"param\":{},\"roleCode\":\"\",\"roleName\":\"用户管理员\",\"id\":6}',
        '{\"code\":200,\"message\":\"成功\"}', 1, '', NULL, '2022-05-27 10:42:18', NULL, 0),
       (18, '角色管理', 'UPDATE', 'com.atguigu.auth.controller.SysRoleController.updateById()', 'PUT', 'MANAGE', 'admin',
        '', '/admin/auth/sysRole/update', '127.0.0.1',
        '{\"isDeleted\":0,\"createTime\":1653619337000,\"param\":{},\"roleCode\":\"\",\"roleName\":\"用户管理员\",\"updateTime\":1653619337000,\"id\":6}',
        '{\"code\":200,\"message\":\"成功\"}', 1, '', NULL, '2022-05-27 10:43:59', NULL, 0),
       (19, '菜单管理', 'UPDATE', 'com.atguigu.auth.controller.SysMenuController.updateById()', 'PUT', 'MANAGE', 'admin',
        '', '/admin/auth/sysMenu/update', '127.0.0.1',
        '{\"code\":\"sysUser\",\"select\":false,\"level\":3,\"updateTime\":1653957062000,\"type\":1,\"parentId\":2,\"path\":\"sysUser/list\",\"sortValue\":1,\"component\":\"auth/sysUser/list\",\"isDeleted\":0,\"children\":[{\"code\":\"btn.sysUser.list\",\"select\":false,\"level\":4,\"updateTime\":1653957062000,\"type\":2,\"parentId\":3,\"isDeleted\":0,\"children\":[],\"createTime\":1622455537000,\"param\":{},\"name\":\"查看\",\"id\":6,\"status\":1},{\"code\":\"btn.sysUser.add\",\"select\":false,\"level\":4,\"updateTime\":1653957062000,\"type\":2,\"parentId\":3,\"isDeleted\":0,\"children\":[],\"createTime\":1622455537000,\"param\":{},\"name\":\"添加\",\"id\":7,\"status\":1},{\"code\":\"btn.sysUser.update\",\"select\":false,\"level\":4,\"updateTime\":1653957062000,\"type\":2,\"parentId\":3,\"isDeleted\":0,\"children\":[],\"createTime\":1622455537000,\"param\":{},\"name\":\"修改\",\"id\":8,\"status\":1},{\"code\":\"btn.sysUser.remove\",\"select\":false,\"level\":4,\"updateTime\":1653957062000,\"type\":2,\"parentId\":3,\"isDeleted\":0,\"children\":[],\"createTime\":1622455537000,\"param\":{},\"name\":\"删除\",\"id\":9,\"status\":1},{\"code\":\"btn.sysUser.assignRole\",\"select\":false,\"level\":4,\"toCode\":\"\",\"updateTime\":1653957062000,\"type\":2,\"parentId\":3,\"isDeleted\":0,\"children\":[],\"createTime\":1653297272000,\"param\":{},\"name\":\"分配角色\",\"id\":18,\"status\":1}],\"createTime\":1622455537000,\"param\":{},\"name\":\"用户管理\",\"perms\":\"btn.sysUser.list\",\"id\":3,\"status\":1}',
        '{\"code\":200,\"message\":\"成功\"}', 1, '', NULL, '2022-05-31 09:14:26', NULL, 0),
       (20, '菜单管理', 'UPDATE', 'com.atguigu.auth.controller.SysMenuController.updateById()', 'PUT', 'MANAGE', 'admin',
        '', '/admin/auth/sysMenu/update', '127.0.0.1',
        '{\"code\":\"sysRole\",\"select\":false,\"level\":3,\"updateTime\":1653957062000,\"type\":1,\"parentId\":2,\"path\":\"sysRole/list\",\"sortValue\":0,\"component\":\"auth/sysRole/list\",\"isDeleted\":0,\"children\":[{\"code\":\"btn.sysRole.list\",\"select\":false,\"level\":4,\"updateTime\":1653959708000,\"type\":2,\"parentId\":4,\"isDeleted\":0,\"children\":[],\"createTime\":1622455537000,\"param\":{},\"name\":\"查看\",\"perms\":\"btn.sysRole.list\",\"id\":10,\"status\":1},{\"code\":\"btn.sysRole.add\",\"select\":false,\"level\":4,\"updateTime\":1653959708000,\"type\":2,\"parentId\":4,\"isDeleted\":0,\"children\":[],\"createTime\":1622455537000,\"param\":{},\"name\":\"添加\",\"perms\":\"btn.sysRole.add\",\"id\":11,\"status\":1},{\"code\":\"btn.sysRole.update\",\"select\":false,\"level\":4,\"updateTime\":1653959708000,\"type\":2,\"parentId\":4,\"isDeleted\":0,\"children\":[],\"createTime\":1622455537000,\"param\":{},\"name\":\"修改\",\"perms\":\"btn.sysRole.update\",\"id\":12,\"status\":1},{\"code\":\"btn.sysRole.remove\",\"select\":false,\"level\":4,\"updateTime\":1653959708000,\"type\":2,\"parentId\":4,\"isDeleted\":0,\"children\":[],\"createTime\":1622455537000,\"param\":{},\"name\":\"删除\",\"perms\":\"btn.sysRole.remove\",\"id\":13,\"status\":1},{\"code\":\"btn.sysRole.assignAuth\",\"select\":false,\"level\":4,\"toCode\":\"assignAuth\",\"updateTime\":1653959708000,\"type\":2,\"parentId\":4,\"isDeleted\":0,\"children\":[],\"createTime\":1653297494000,\"param\":{},\"name\":\"分配权限\",\"perms\":\"btn.sysRole.assignAuth\",\"id\":19,\"status\":1}],\"createTime\":1622455537000,\"param\":{},\"name\":\"角色管理\",\"perms\":\" btn.sysRole.list\",\"id\":4,\"status\":1}',
        '{\"code\":200,\"message\":\"成功\"}', 1, '', NULL, '2022-05-31 09:18:12', NULL, 0),
       (21, '菜单管理', 'UPDATE', 'com.atguigu.auth.controller.SysMenuController.updateById()', 'PUT', 'MANAGE', 'admin',
        '', '/admin/auth/sysMenu/update', '127.0.0.1',
        '{\"code\":\"sysMenu\",\"select\":false,\"level\":3,\"updateTime\":1653957062000,\"type\":1,\"parentId\":2,\"path\":\"sysMenu/list\",\"sortValue\":0,\"component\":\"auth/sysMenu/list\",\"isDeleted\":0,\"children\":[{\"code\":\"btn.sysMenu.list\",\"select\":false,\"level\":4,\"updateTime\":1653959708000,\"type\":2,\"parentId\":5,\"isDeleted\":0,\"children\":[],\"createTime\":1622455537000,\"param\":{},\"name\":\"查看\",\"perms\":\"btn.sysMenu.list\",\"id\":14,\"status\":1},{\"code\":\"btn.sysMenu.add\",\"select\":false,\"level\":4,\"updateTime\":1653959708000,\"type\":2,\"parentId\":5,\"isDeleted\":0,\"children\":[],\"createTime\":1622455537000,\"param\":{},\"name\":\"添加\",\"perms\":\"btn.sysMenu.add\",\"id\":15,\"status\":1},{\"code\":\"btn.sysMenu.update\",\"select\":false,\"level\":4,\"updateTime\":1653959708000,\"type\":2,\"parentId\":5,\"isDeleted\":0,\"children\":[],\"createTime\":1622455537000,\"param\":{},\"name\":\"修改\",\"perms\":\"btn.sysMenu.update\",\"id\":16,\"status\":1},{\"code\":\"btn.sysMenu.remove\",\"select\":false,\"level\":4,\"updateTime\":1653959708000,\"type\":2,\"parentId\":5,\"isDeleted\":0,\"children\":[],\"createTime\":1622455537000,\"param\":{},\"name\":\"删除\",\"perms\":\"btn.sysMenu.remove\",\"id\":17,\"status\":1}],\"createTime\":1622455537000,\"param\":{},\"name\":\"菜单管理\",\"perms\":\"btn.sysMenu.list\",\"id\":5,\"status\":1}',
        '{\"code\":200,\"message\":\"成功\"}', 1, '', NULL, '2022-05-31 09:18:37', NULL, 0),
       (22, '菜单管理', 'UPDATE', 'com.atguigu.auth.controller.SysMenuController.updateById()', 'PUT', 'MANAGE', 'admin',
        '', '/admin/auth/sysMenu/update', '127.0.0.1',
        '{\"code\":\"sysDept\",\"select\":false,\"level\":3,\"toCode\":\"\",\"updateTime\":1653957062000,\"type\":1,\"parentId\":2,\"path\":\"sysDept/list\",\"sortValue\":0,\"component\":\"auth/sysDept/list\",\"isDeleted\":0,\"children\":[{\"code\":\"btn.sysDept.list\",\"select\":false,\"level\":4,\"toCode\":\"\",\"updateTime\":1653959708000,\"type\":2,\"parentId\":20,\"isDeleted\":0,\"children\":[],\"createTime\":1653358064000,\"param\":{},\"name\":\"查看\",\"perms\":\"btn.sysDept.list\",\"id\":21,\"status\":1},{\"code\":\"btn.sysDept.add\",\"select\":false,\"level\":4,\"toCode\":\"\",\"updateTime\":1653959708000,\"type\":2,\"parentId\":20,\"isDeleted\":0,\"children\":[],\"createTime\":1653463887000,\"param\":{},\"name\":\"添加\",\"perms\":\"btn.sysDept.add\",\"id\":24,\"status\":1},{\"code\":\"btn.sysDept.update\",\"select\":false,\"level\":4,\"toCode\":\"\",\"updateTime\":1653959708000,\"type\":2,\"parentId\":20,\"isDeleted\":0,\"children\":[],\"createTime\":1653463901000,\"param\":{},\"name\":\"修改\",\"perms\":\"btn.sysDept.update\",\"id\":25,\"status\":1},{\"code\":\"btn.sysDept.remove\",\"select\":false,\"level\":4,\"toCode\":\"\",\"updateTime\":1653959708000,\"type\":2,\"parentId\":20,\"isDeleted\":0,\"children\":[],\"createTime\":1653463919000,\"param\":{},\"name\":\"删除\",\"perms\":\"btn.sysDept.remove\",\"id\":26,\"status\":1}],\"createTime\":1653358025000,\"param\":{},\"name\":\"部门管理\",\"perms\":\"btn.sysDept.list\",\"id\":20,\"status\":1}',
        '{\"code\":200,\"message\":\"成功\"}', 1, '', NULL, '2022-05-31 09:19:04', NULL, 0),
       (23, '菜单管理', 'UPDATE', 'com.atguigu.auth.controller.SysMenuController.updateById()', 'PUT', 'MANAGE', 'admin',
        '', '/admin/auth/sysMenu/update', '127.0.0.1',
        '{\"code\":\"sysPost\",\"select\":false,\"level\":3,\"toCode\":\"\",\"updateTime\":1653957062000,\"type\":1,\"parentId\":2,\"path\":\"sysPost/list\",\"sortValue\":0,\"component\":\"auth/sysPost/list\",\"isDeleted\":0,\"children\":[{\"code\":\"btn.sysPost.list\",\"select\":false,\"level\":4,\"toCode\":\"\",\"updateTime\":1653959708000,\"type\":2,\"parentId\":22,\"isDeleted\":0,\"children\":[],\"createTime\":1653359145000,\"param\":{},\"name\":\"查看\",\"perms\":\"btn.sysPost.list\",\"id\":23,\"status\":1},{\"code\":\"btn.sysPost.add\",\"select\":false,\"level\":4,\"toCode\":\"\",\"updateTime\":1653959708000,\"type\":2,\"parentId\":22,\"isDeleted\":0,\"children\":[],\"createTime\":1653463964000,\"param\":{},\"name\":\"添加\",\"perms\":\"btn.sysPost.add\",\"id\":27,\"status\":1},{\"code\":\"btn.sysPost.update\",\"select\":false,\"level\":4,\"toCode\":\"\",\"updateTime\":1653959708000,\"type\":2,\"parentId\":22,\"isDeleted\":0,\"children\":[],\"createTime\":1653463978000,\"param\":{},\"name\":\"修改\",\"perms\":\"btn.sysPost.update\",\"id\":28,\"status\":1},{\"code\":\"btn.sysPost.remove\",\"select\":false,\"level\":4,\"toCode\":\"\",\"updateTime\":1653959708000,\"type\":2,\"parentId\":22,\"isDeleted\":0,\"children\":[],\"createTime\":1653463991000,\"param\":{},\"name\":\"删除\",\"perms\":\"btn.sysPost.remove\",\"id\":29,\"status\":1}],\"createTime\":1653359130000,\"param\":{},\"name\":\"岗位管理\",\"perms\":\"btn.sysPost.list\",\"id\":22,\"status\":1}',
        '{\"code\":200,\"message\":\"成功\"}', 1, '', NULL, '2022-05-31 09:19:23', NULL, 0),
       (24, '菜单管理', 'UPDATE', 'com.atguigu.auth.controller.SysMenuController.updateById()', 'PUT', 'MANAGE', 'admin',
        '', '/admin/auth/sysMenu/update', '127.0.0.1',
        '{\"code\":\"sysOperLog\",\"select\":false,\"level\":3,\"toCode\":\"\",\"updateTime\":1653957062000,\"type\":1,\"parentId\":2,\"path\":\"sysOperLog/list\",\"sortValue\":0,\"component\":\"auth/sysOperLog/list\",\"isDeleted\":0,\"children\":[{\"code\":\"btn.sysOperLog.list\",\"select\":false,\"level\":4,\"toCode\":\"\",\"updateTime\":1653959708000,\"type\":2,\"parentId\":30,\"isDeleted\":0,\"children\":[],\"createTime\":1653552617000,\"param\":{},\"name\":\"查看\",\"perms\":\"btn.sysOperLog.list\",\"id\":31,\"status\":1}],\"createTime\":1653552599000,\"param\":{},\"name\":\"操作日志\",\"perms\":\"btn.sysOperLog.list\",\"id\":30,\"status\":1}',
        '{\"code\":200,\"message\":\"成功\"}', 1, '', NULL, '2022-05-31 09:19:40', NULL, 0),
       (25, '菜单管理', 'UPDATE', 'com.atguigu.auth.controller.SysMenuController.updateById()', 'PUT', 'MANAGE', 'admin',
        '', '/admin/auth/sysMenu/update', '127.0.0.1',
        '{\"code\":\"sysLoginLog\",\"select\":false,\"level\":3,\"toCode\":\"\",\"updateTime\":1653957062000,\"type\":1,\"parentId\":2,\"path\":\"sysLoginLog/list\",\"sortValue\":0,\"component\":\"auth/sysLoginLog/list\",\"isDeleted\":0,\"children\":[{\"code\":\"btn.sysLoginLog.list\",\"select\":false,\"level\":4,\"toCode\":\"\",\"updateTime\":1653957062000,\"type\":1,\"parentId\":32,\"isDeleted\":0,\"children\":[],\"createTime\":1653554191000,\"param\":{},\"name\":\"查看\",\"id\":33,\"status\":1}],\"createTime\":1653554173000,\"param\":{},\"name\":\"登录日志\",\"perms\":\" btn.sysLoginLog.list\",\"id\":32,\"status\":1}',
        '{\"code\":200,\"message\":\"成功\"}', 1, '', NULL, '2022-05-31 09:20:09', NULL, 0),
       (26, '菜单管理', 'UPDATE', 'com.atguigu.auth.controller.SysMenuController.updateById()', 'PUT', 'MANAGE', 'admin',
        '', '/admin/auth/sysMenu/update', '127.0.0.1',
        '{\"code\":\"sysUser\",\"select\":false,\"level\":2,\"updateTime\":1653957062000,\"type\":1,\"parentId\":2,\"path\":\"sysUser\",\"sortValue\":1,\"component\":\"auth/sysUser/list\",\"isDeleted\":0,\"children\":[{\"code\":\"btn.sysUser.list\",\"select\":false,\"level\":3,\"updateTime\":1653959708000,\"type\":2,\"parentId\":3,\"isDeleted\":0,\"children\":[],\"createTime\":1622455537000,\"param\":{},\"name\":\"查看\",\"perms\":\"btn.sysUser.list\",\"id\":6,\"status\":1},{\"code\":\"btn.sysUser.add\",\"select\":false,\"level\":3,\"updateTime\":1653959708000,\"type\":2,\"parentId\":3,\"isDeleted\":0,\"children\":[],\"createTime\":1622455537000,\"param\":{},\"name\":\"添加\",\"perms\":\"btn.sysUser.add\",\"id\":7,\"status\":1},{\"code\":\"btn.sysUser.update\",\"select\":false,\"level\":3,\"updateTime\":1653959708000,\"type\":2,\"parentId\":3,\"isDeleted\":0,\"children\":[],\"createTime\":1622455537000,\"param\":{},\"name\":\"修改\",\"perms\":\"btn.sysUser.update\",\"id\":8,\"status\":1},{\"code\":\"btn.sysUser.remove\",\"select\":false,\"level\":3,\"updateTime\":1653959708000,\"type\":2,\"parentId\":3,\"isDeleted\":0,\"children\":[],\"createTime\":1622455537000,\"param\":{},\"name\":\"删除\",\"perms\":\"btn.sysUser.remove\",\"id\":9,\"status\":1},{\"code\":\"btn.sysUser.assignRole\",\"select\":false,\"level\":3,\"toCode\":\"\",\"updateTime\":1653959708000,\"type\":2,\"parentId\":3,\"isDeleted\":0,\"children\":[],\"createTime\":1653297272000,\"param\":{},\"name\":\"分配角色\",\"perms\":\"btn.sysUser.assignRole\",\"id\":18,\"status\":1}],\"createTime\":1622455537000,\"param\":{},\"name\":\"用户管理\",\"perms\":\"btn.sysUser.list\",\"id\":3,\"status\":1}',
        '{\"code\":200,\"message\":\"成功\"}', 1, '', NULL, '2022-05-31 09:41:35', NULL, 0),
       (27, '菜单管理', 'UPDATE', 'com.atguigu.auth.controller.SysMenuController.updateById()', 'PUT', 'MANAGE', 'admin',
        '', '/admin/auth/sysMenu/update', '127.0.0.1',
        '{\"code\":\"sysRole\",\"select\":false,\"level\":2,\"updateTime\":1653957062000,\"type\":1,\"parentId\":2,\"path\":\"sysRole\",\"sortValue\":0,\"component\":\"auth/sysRole/list\",\"isDeleted\":0,\"children\":[{\"code\":\"btn.sysRole.list\",\"select\":false,\"level\":3,\"updateTime\":1653959708000,\"type\":2,\"parentId\":4,\"isDeleted\":0,\"children\":[],\"createTime\":1622455537000,\"param\":{},\"name\":\"查看\",\"perms\":\"btn.sysRole.list\",\"id\":10,\"status\":1},{\"code\":\"btn.sysRole.add\",\"select\":false,\"level\":3,\"updateTime\":1653959708000,\"type\":2,\"parentId\":4,\"isDeleted\":0,\"children\":[],\"createTime\":1622455537000,\"param\":{},\"name\":\"添加\",\"perms\":\"btn.sysRole.add\",\"id\":11,\"status\":1},{\"code\":\"btn.sysRole.update\",\"select\":false,\"level\":3,\"updateTime\":1653959708000,\"type\":2,\"parentId\":4,\"isDeleted\":0,\"children\":[],\"createTime\":1622455537000,\"param\":{},\"name\":\"修改\",\"perms\":\"btn.sysRole.update\",\"id\":12,\"status\":1},{\"code\":\"btn.sysRole.remove\",\"select\":false,\"level\":3,\"updateTime\":1653959708000,\"type\":2,\"parentId\":4,\"isDeleted\":0,\"children\":[],\"createTime\":1622455537000,\"param\":{},\"name\":\"删除\",\"perms\":\"btn.sysRole.remove\",\"id\":13,\"status\":1},{\"code\":\"btn.sysRole.assignAuth\",\"select\":false,\"level\":3,\"toCode\":\"assignAuth\",\"updateTime\":1653959708000,\"type\":2,\"parentId\":4,\"isDeleted\":0,\"children\":[],\"createTime\":1653297494000,\"param\":{},\"name\":\"分配权限\",\"perms\":\"btn.sysRole.assignAuth\",\"id\":19,\"status\":1}],\"createTime\":1622455537000,\"param\":{},\"name\":\"角色管理\",\"perms\":\" btn.sysRole.list\",\"id\":4,\"status\":1}',
        '{\"code\":200,\"message\":\"成功\"}', 1, '', NULL, '2022-05-31 09:41:42', NULL, 0),
       (28, '菜单管理', 'UPDATE', 'com.atguigu.auth.controller.SysMenuController.updateById()', 'PUT', 'MANAGE', 'admin',
        '', '/admin/auth/sysMenu/update', '127.0.0.1',
        '{\"code\":\"sysMenu\",\"select\":false,\"level\":2,\"updateTime\":1653957062000,\"type\":1,\"parentId\":2,\"path\":\"sysMenu\",\"sortValue\":0,\"component\":\"auth/sysMenu/list\",\"isDeleted\":0,\"children\":[{\"code\":\"btn.sysMenu.list\",\"select\":false,\"level\":3,\"updateTime\":1653959708000,\"type\":2,\"parentId\":5,\"isDeleted\":0,\"children\":[],\"createTime\":1622455537000,\"param\":{},\"name\":\"查看\",\"perms\":\"btn.sysMenu.list\",\"id\":14,\"status\":1},{\"code\":\"btn.sysMenu.add\",\"select\":false,\"level\":3,\"updateTime\":1653959708000,\"type\":2,\"parentId\":5,\"isDeleted\":0,\"children\":[],\"createTime\":1622455537000,\"param\":{},\"name\":\"添加\",\"perms\":\"btn.sysMenu.add\",\"id\":15,\"status\":1},{\"code\":\"btn.sysMenu.update\",\"select\":false,\"level\":3,\"updateTime\":1653959708000,\"type\":2,\"parentId\":5,\"isDeleted\":0,\"children\":[],\"createTime\":1622455537000,\"param\":{},\"name\":\"修改\",\"perms\":\"btn.sysMenu.update\",\"id\":16,\"status\":1},{\"code\":\"btn.sysMenu.remove\",\"select\":false,\"level\":3,\"updateTime\":1653959708000,\"type\":2,\"parentId\":5,\"isDeleted\":0,\"children\":[],\"createTime\":1622455537000,\"param\":{},\"name\":\"删除\",\"perms\":\"btn.sysMenu.remove\",\"id\":17,\"status\":1}],\"createTime\":1622455537000,\"param\":{},\"name\":\"菜单管理\",\"perms\":\"btn.sysMenu.list\",\"id\":5,\"status\":1}',
        '{\"code\":200,\"message\":\"成功\"}', 1, '', NULL, '2022-05-31 09:41:51', NULL, 0),
       (29, '菜单管理', 'UPDATE', 'com.atguigu.auth.controller.SysMenuController.updateById()', 'PUT', 'MANAGE', 'admin',
        '', '/admin/auth/sysMenu/update', '127.0.0.1',
        '{\"code\":\"sysDept\",\"select\":false,\"level\":2,\"toCode\":\"\",\"updateTime\":1653957062000,\"type\":1,\"parentId\":2,\"path\":\"sysDept\",\"sortValue\":0,\"component\":\"auth/sysDept/list\",\"isDeleted\":0,\"children\":[{\"code\":\"btn.sysDept.list\",\"select\":false,\"level\":3,\"toCode\":\"\",\"updateTime\":1653959708000,\"type\":2,\"parentId\":20,\"isDeleted\":0,\"children\":[],\"createTime\":1653358064000,\"param\":{},\"name\":\"查看\",\"perms\":\"btn.sysDept.list\",\"id\":21,\"status\":1},{\"code\":\"btn.sysDept.add\",\"select\":false,\"level\":3,\"toCode\":\"\",\"updateTime\":1653959708000,\"type\":2,\"parentId\":20,\"isDeleted\":0,\"children\":[],\"createTime\":1653463887000,\"param\":{},\"name\":\"添加\",\"perms\":\"btn.sysDept.add\",\"id\":24,\"status\":1},{\"code\":\"btn.sysDept.update\",\"select\":false,\"level\":3,\"toCode\":\"\",\"updateTime\":1653959708000,\"type\":2,\"parentId\":20,\"isDeleted\":0,\"children\":[],\"createTime\":1653463901000,\"param\":{},\"name\":\"修改\",\"perms\":\"btn.sysDept.update\",\"id\":25,\"status\":1},{\"code\":\"btn.sysDept.remove\",\"select\":false,\"level\":3,\"toCode\":\"\",\"updateTime\":1653959708000,\"type\":2,\"parentId\":20,\"isDeleted\":0,\"children\":[],\"createTime\":1653463919000,\"param\":{},\"name\":\"删除\",\"perms\":\"btn.sysDept.remove\",\"id\":26,\"status\":1}],\"createTime\":1653358025000,\"param\":{},\"name\":\"部门管理\",\"perms\":\"btn.sysDept.list\",\"id\":20,\"status\":1}',
        '{\"code\":200,\"message\":\"成功\"}', 1, '', NULL, '2022-05-31 09:41:58', NULL, 0),
       (30, '菜单管理', 'UPDATE', 'com.atguigu.auth.controller.SysMenuController.updateById()', 'PUT', 'MANAGE', 'admin',
        '', '/admin/auth/sysMenu/update', '127.0.0.1',
        '{\"code\":\"sysPost\",\"select\":false,\"level\":2,\"toCode\":\"\",\"updateTime\":1653957062000,\"type\":1,\"parentId\":2,\"path\":\"sysPost\",\"sortValue\":0,\"component\":\"auth/sysPost/list\",\"isDeleted\":0,\"children\":[{\"code\":\"btn.sysPost.list\",\"select\":false,\"level\":3,\"toCode\":\"\",\"updateTime\":1653959708000,\"type\":2,\"parentId\":22,\"isDeleted\":0,\"children\":[],\"createTime\":1653359145000,\"param\":{},\"name\":\"查看\",\"perms\":\"btn.sysPost.list\",\"id\":23,\"status\":1},{\"code\":\"btn.sysPost.add\",\"select\":false,\"level\":3,\"toCode\":\"\",\"updateTime\":1653959708000,\"type\":2,\"parentId\":22,\"isDeleted\":0,\"children\":[],\"createTime\":1653463964000,\"param\":{},\"name\":\"添加\",\"perms\":\"btn.sysPost.add\",\"id\":27,\"status\":1},{\"code\":\"btn.sysPost.update\",\"select\":false,\"level\":3,\"toCode\":\"\",\"updateTime\":1653959708000,\"type\":2,\"parentId\":22,\"isDeleted\":0,\"children\":[],\"createTime\":1653463978000,\"param\":{},\"name\":\"修改\",\"perms\":\"btn.sysPost.update\",\"id\":28,\"status\":1},{\"code\":\"btn.sysPost.remove\",\"select\":false,\"level\":3,\"toCode\":\"\",\"updateTime\":1653959708000,\"type\":2,\"parentId\":22,\"isDeleted\":0,\"children\":[],\"createTime\":1653463991000,\"param\":{},\"name\":\"删除\",\"perms\":\"btn.sysPost.remove\",\"id\":29,\"status\":1}],\"createTime\":1653359130000,\"param\":{},\"name\":\"岗位管理\",\"perms\":\"btn.sysPost.list\",\"id\":22,\"status\":1}',
        '{\"code\":200,\"message\":\"成功\"}', 1, '', NULL, '2022-05-31 09:42:04', NULL, 0),
       (31, '菜单管理', 'UPDATE', 'com.atguigu.auth.controller.SysMenuController.updateById()', 'PUT', 'MANAGE', 'admin',
        '', '/admin/auth/sysMenu/update', '127.0.0.1',
        '{\"code\":\"sysOperLog\",\"select\":false,\"level\":2,\"toCode\":\"\",\"updateTime\":1653957062000,\"type\":1,\"parentId\":2,\"path\":\"sysOperLog\",\"sortValue\":0,\"component\":\"auth/sysOperLog/list\",\"isDeleted\":0,\"children\":[{\"code\":\"btn.sysOperLog.list\",\"select\":false,\"level\":3,\"toCode\":\"\",\"updateTime\":1653959708000,\"type\":2,\"parentId\":30,\"isDeleted\":0,\"children\":[],\"createTime\":1653552617000,\"param\":{},\"name\":\"查看\",\"perms\":\"btn.sysOperLog.list\",\"id\":31,\"status\":1}],\"createTime\":1653552599000,\"param\":{},\"name\":\"操作日志\",\"perms\":\"btn.sysOperLog.list\",\"id\":30,\"status\":1}',
        '{\"code\":200,\"message\":\"成功\"}', 1, '', NULL, '2022-05-31 09:42:09', NULL, 0),
       (32, '菜单管理', 'UPDATE', 'com.atguigu.auth.controller.SysMenuController.updateById()', 'PUT', 'MANAGE', 'admin',
        '', '/admin/auth/sysMenu/update', '127.0.0.1',
        '{\"code\":\"sysLoginLog\",\"select\":false,\"level\":2,\"toCode\":\"\",\"updateTime\":1653957062000,\"type\":1,\"parentId\":2,\"path\":\"sysLoginLog\",\"sortValue\":0,\"component\":\"auth/sysLoginLog/list\",\"isDeleted\":0,\"children\":[{\"code\":\"btn.sysLoginLog.list\",\"select\":false,\"level\":3,\"toCode\":\"\",\"updateTime\":1653957062000,\"type\":1,\"parentId\":32,\"isDeleted\":0,\"children\":[],\"createTime\":1653554191000,\"param\":{},\"name\":\"查看\",\"id\":33,\"status\":1}],\"createTime\":1653554173000,\"param\":{},\"name\":\"登录日志\",\"perms\":\" btn.sysLoginLog.list\",\"id\":32,\"status\":1}',
        '{\"code\":200,\"message\":\"成功\"}', 1, '', NULL, '2022-05-31 09:42:15', NULL, 0),
       (33, '菜单管理', 'INSERT', 'com.atguigu.system.controller.SysMenuController.save()', 'POST', 'MANAGE', 'admin', '',
        '/admin/system/sysMenu/save', '127.0.0.1',
        '{\"select\":false,\"icon\":\"\",\"type\":0,\"parentId\":2,\"path\":\"log\",\"sortValue\":1,\"component\":\"\",\"param\":{},\"name\":\"日志管理\",\"perms\":\"\",\"id\":34,\"status\":1}',
        '{\"code\":200,\"message\":\"成功\"}', 1, '', NULL, '2022-05-31 13:23:07', NULL, 0),
       (34, '菜单管理', 'INSERT', 'com.atguigu.system.controller.SysMenuController.save()', 'POST', 'MANAGE', 'admin', '',
        '/admin/system/sysMenu/save', '127.0.0.1',
        '{\"select\":false,\"visible\":1,\"icon\":\"\",\"type\":0,\"parentId\":0,\"path\":\"order\",\"sortValue\":1,\"component\":\"Layout\",\"param\":{},\"name\":\"订单管理\",\"perms\":\"\",\"id\":35,\"status\":1}',
        '{\"code\":200,\"message\":\"成功\"}', 1, '', NULL, '2022-05-31 13:57:50', NULL, 0),
       (35, '菜单管理', 'INSERT', 'com.atguigu.system.controller.SysMenuController.save()', 'POST', 'MANAGE', 'admin', '',
        '/admin/system/sysMenu/save', '127.0.0.1',
        '{\"select\":false,\"visible\":1,\"icon\":\"\",\"type\":1,\"parentId\":35,\"path\":\"orderInfo\",\"sortValue\":1,\"component\":\"order/orderInfo/list\",\"param\":{},\"name\":\"订单列表\",\"perms\":\"btn.orderInfo.list\",\"id\":36,\"status\":1}',
        '{\"code\":200,\"message\":\"成功\"}', 1, '', NULL, '2022-05-31 13:58:37', NULL, 0),
       (36, '岗位管理', 'INSERT', 'com.atguigu.system.controller.SysPostController.save()', 'POST', 'MANAGE', 'admin', '',
        '/admin/system/sysPost/save', '127.0.0.1',
        '{\"param\":{},\"name\":\"运营总监\",\"description\":\"\",\"postCode\":\"yyzj\",\"id\":8,\"status\":1}',
        '{\"code\":200,\"message\":\"成功\"}', 1, '', NULL, '2022-06-08 17:14:21', NULL, 0),
       (37, '角色管理', 'INSERT', 'com.atguigu.system.controller.SysRoleController.save()', 'POST', 'MANAGE', 'admin', '',
        '/admin/system/sysRole/save', '127.0.0.1', '{\"param\":{},\"roleCode\":\"\",\"roleName\":\"\",\"id\":8}',
        '{\"code\":200,\"message\":\"成功\"}', 1, '', NULL, '2022-06-08 17:39:04', NULL, 0),
       (38, '角色管理', 'UPDATE', 'com.atguigu.system.controller.SysRoleController.updateById()', 'PUT', 'MANAGE', 'admin',
        '', '/admin/system/sysRole/update', '127.0.0.1',
        '{\"isDeleted\":0,\"createTime\":1654681144000,\"param\":{},\"roleCode\":\"\",\"roleName\":\"\",\"updateTime\":1654681144000,\"id\":8}',
        '{\"code\":200,\"message\":\"成功\"}', 1, '', NULL, '2022-06-08 17:39:08', NULL, 0),
       (39, '角色管理', 'UPDATE', 'com.atguigu.system.controller.SysRoleController.updateById()', 'PUT', 'MANAGE', 'admin',
        '', '/admin/system/sysRole/update', '127.0.0.1',
        '{\"isDeleted\":0,\"createTime\":1654681144000,\"param\":{},\"roleCode\":\"\",\"roleName\":\"\",\"updateTime\":1654681144000,\"id\":8}',
        '{\"code\":200,\"message\":\"成功\"}', 1, '', NULL, '2022-06-08 17:39:41', NULL, 0),
       (40, '角色管理', 'UPDATE', 'com.atguigu.system.controller.SysRoleController.updateById()', 'PUT', 'MANAGE', 'admin',
        '', '/admin/system/sysRole/update', '127.0.0.1',
        '{\"isDeleted\":0,\"createTime\":1654681144000,\"param\":{},\"roleCode\":\"yhgly\",\"roleName\":\"用户管理员\",\"updateTime\":1654681144000,\"id\":8}',
        '{\"code\":200,\"message\":\"成功\"}', 1, '', NULL, '2022-06-08 17:42:46', NULL, 0),
       (41, '菜单管理', 'INSERT', 'com.atguigu.system.controller.SysMenuController.save()', 'POST', 'MANAGE', 'admin', '',
        '/admin/system/sysMenu/save', '127.0.0.1',
        '{\"select\":false,\"icon\":\"el-icon-phone\",\"type\":0,\"parentId\":0,\"path\":\"order\",\"sortValue\":1,\"component\":\"Layout\",\"param\":{},\"name\":\"订单管理\",\"perms\":\"\",\"id\":35,\"status\":1}',
        '{\"code\":200,\"message\":\"成功\"}', 1, '', NULL, '2022-06-09 08:50:13', NULL, 0),
       (42, '菜单管理', 'UPDATE', 'com.atguigu.system.controller.SysMenuController.updateById()', 'PUT', 'MANAGE', 'admin',
        '', '/admin/system/sysMenu/update', '127.0.0.1',
        '{\"select\":false,\"icon\":\"el-icon-phone\",\"updateTime\":1654735813000,\"type\":0,\"parentId\":0,\"path\":\"order\",\"sortValue\":1,\"component\":\"Layout\",\"isDeleted\":0,\"children\":[],\"createTime\":1654735813000,\"param\":{},\"name\":\"订单管理\",\"perms\":\"\",\"id\":35,\"status\":1}',
        '{\"code\":200,\"message\":\"成功\"}', 1, '', NULL, '2022-06-09 08:50:22', NULL, 0),
       (43, '菜单管理', 'INSERT', 'com.atguigu.system.controller.SysMenuController.save()', 'POST', 'MANAGE', 'admin', '',
        '/admin/system/sysMenu/save', '127.0.0.1',
        '{\"select\":false,\"icon\":\"el-icon-s-help\",\"type\":1,\"parentId\":35,\"path\":\"orderInfo\",\"sortValue\":1,\"component\":\"order/orderInfo/list\",\"param\":{},\"name\":\"订单列表\",\"perms\":\"btn.orderInfo.list\",\"id\":36,\"status\":1}',
        '{\"code\":200,\"message\":\"成功\"}', 1, '', NULL, '2022-06-09 08:51:22', NULL, 0),
       (44, '菜单管理', 'INSERT', 'com.atguigu.system.controller.SysMenuController.save()', 'POST', 'MANAGE', 'admin', '',
        '/admin/system/sysMenu/save', '127.0.0.1',
        '{\"select\":false,\"icon\":\"\",\"type\":2,\"parentId\":36,\"path\":\"\",\"sortValue\":1,\"component\":\"\",\"param\":{},\"name\":\"添加\",\"perms\":\"btn.add\",\"id\":37,\"status\":1}',
        '{\"code\":200,\"message\":\"成功\"}', 1, '', NULL, '2022-06-09 08:52:37', NULL, 0),
       (45, '菜单管理', 'DELETE', 'com.atguigu.system.controller.SysMenuController.remove()', 'DELETE', 'MANAGE', 'admin',
        '', '/admin/system/sysMenu/remove/37', '127.0.0.1', '', '{\"code\":200,\"message\":\"成功\"}', 1, '', NULL,
        '2022-06-09 08:53:01', NULL, 0),
       (46, '菜单管理', 'DELETE', 'com.atguigu.system.controller.SysMenuController.remove()', 'DELETE', 'MANAGE', 'admin',
        '', '/admin/system/sysMenu/remove/36', '127.0.0.1', '', '{\"code\":200,\"message\":\"成功\"}', 1, '', NULL,
        '2022-06-09 08:53:04', NULL, 0),
       (47, '菜单管理', 'DELETE', 'com.atguigu.system.controller.SysMenuController.remove()', 'DELETE', 'MANAGE', 'admin',
        '', '/admin/system/sysMenu/remove/35', '127.0.0.1', '', '{\"code\":200,\"message\":\"成功\"}', 1, '', NULL,
        '2022-06-09 08:53:06', NULL, 0),
       (48, '菜单管理', 'UPDATE', 'com.atguigu.system.controller.SysMenuController.updateById()', 'PUT', 'MANAGE', 'admin',
        '', '/admin/system/sysMenu/update', '127.0.0.1',
        '{\"select\":false,\"icon\":\"el-icon-s-custom\",\"updateTime\":1654737767000,\"type\":1,\"parentId\":2,\"path\":\"sysUser\",\"sortValue\":1,\"component\":\"system/sysUser/list\",\"isDeleted\":0,\"children\":[{\"select\":false,\"updateTime\":1654737758000,\"type\":2,\"parentId\":3,\"sortValue\":1,\"isDeleted\":0,\"children\":[],\"createTime\":1622455537000,\"param\":{},\"name\":\"查看\",\"perms\":\"btn.sysUser.list\",\"id\":6,\"status\":1},{\"select\":false,\"updateTime\":1654737758000,\"type\":2,\"parentId\":3,\"sortValue\":1,\"isDeleted\":0,\"children\":[],\"createTime\":1622455537000,\"param\":{},\"name\":\"添加\",\"perms\":\"btn.sysUser.add\",\"id\":7,\"status\":1},{\"select\":false,\"updateTime\":1654737758000,\"type\":2,\"parentId\":3,\"sortValue\":1,\"isDeleted\":0,\"children\":[],\"createTime\":1622455537000,\"param\":{},\"name\":\"修改\",\"perms\":\"btn.sysUser.update\",\"id\":8,\"status\":1},{\"select\":false,\"updateTime\":1654737758000,\"type\":2,\"parentId\":3,\"sortValue\":1,\"isDeleted\":0,\"children\":[],\"createTime\":1622455537000,\"param\":{},\"name\":\"删除\",\"perms\":\"btn.sysUser.remove\",\"id\":9,\"status\":1},{\"select\":false,\"updateTime\":1654737758000,\"type\":2,\"parentId\":3,\"sortValue\":1,\"isDeleted\":0,\"children\":[],\"createTime\":1653297272000,\"param\":{},\"name\":\"分配角色\",\"perms\":\"btn.sysUser.assignRole\",\"id\":18,\"status\":1}],\"createTime\":1622455537000,\"param\":{},\"name\":\"用户管理\",\"perms\":\"\",\"id\":3,\"status\":1}',
        '{\"code\":200,\"message\":\"成功\"}', 1, '', NULL, '2022-06-09 09:24:01', NULL, 0),
       (49, '菜单管理', 'UPDATE', 'com.atguigu.system.controller.SysMenuController.updateById()', 'PUT', 'MANAGE', 'admin',
        '', '/admin/system/sysMenu/update', '127.0.0.1',
        '{\"select\":false,\"icon\":\"el-icon-user-solid\",\"updateTime\":1654737768000,\"type\":1,\"parentId\":2,\"path\":\"sysRole\",\"sortValue\":1,\"component\":\"system/sysRole/list\",\"isDeleted\":0,\"children\":[{\"select\":false,\"updateTime\":1654737758000,\"type\":2,\"parentId\":4,\"sortValue\":1,\"isDeleted\":0,\"children\":[],\"createTime\":1622455537000,\"param\":{},\"name\":\"查看\",\"perms\":\"btn.sysRole.list\",\"id\":10,\"status\":1},{\"select\":false,\"updateTime\":1654737758000,\"type\":2,\"parentId\":4,\"sortValue\":1,\"isDeleted\":0,\"children\":[],\"createTime\":1622455537000,\"param\":{},\"name\":\"添加\",\"perms\":\"btn.sysRole.add\",\"id\":11,\"status\":1},{\"select\":false,\"updateTime\":1654737758000,\"type\":2,\"parentId\":4,\"sortValue\":1,\"isDeleted\":0,\"children\":[],\"createTime\":1622455537000,\"param\":{},\"name\":\"修改\",\"perms\":\"btn.sysRole.update\",\"id\":12,\"status\":1},{\"select\":false,\"updateTime\":1654737758000,\"type\":2,\"parentId\":4,\"sortValue\":1,\"isDeleted\":0,\"children\":[],\"createTime\":1622455537000,\"param\":{},\"name\":\"删除\",\"perms\":\"btn.sysRole.remove\",\"id\":13,\"status\":1},{\"select\":false,\"updateTime\":1654737758000,\"type\":2,\"parentId\":4,\"path\":\"\",\"sortValue\":1,\"component\":\"\",\"isDeleted\":0,\"children\":[],\"createTime\":1653297494000,\"param\":{},\"name\":\"分配权限\",\"perms\":\"btn.sysRole.assignAuth\",\"id\":19,\"status\":1}],\"createTime\":1622455537000,\"param\":{},\"name\":\"角色管理\",\"perms\":\"\",\"id\":4,\"status\":1}',
        '{\"code\":200,\"message\":\"成功\"}', 1, '', NULL, '2022-06-09 09:24:10', NULL, 0),
       (50, '菜单管理', 'UPDATE', 'com.atguigu.system.controller.SysMenuController.updateById()', 'PUT', 'MANAGE', 'admin',
        '', '/admin/system/sysMenu/update', '127.0.0.1',
        '{\"select\":false,\"icon\":\"el-icon-s-unfold\",\"updateTime\":1654737769000,\"type\":1,\"parentId\":2,\"path\":\"sysMenu\",\"sortValue\":1,\"component\":\"system/sysMenu/list\",\"isDeleted\":0,\"children\":[{\"select\":false,\"updateTime\":1654737758000,\"type\":2,\"parentId\":5,\"sortValue\":1,\"isDeleted\":0,\"children\":[],\"createTime\":1622455537000,\"param\":{},\"name\":\"查看\",\"perms\":\"btn.sysMenu.list\",\"id\":14,\"status\":1},{\"select\":false,\"updateTime\":1654737758000,\"type\":2,\"parentId\":5,\"sortValue\":1,\"isDeleted\":0,\"children\":[],\"createTime\":1622455537000,\"param\":{},\"name\":\"添加\",\"perms\":\"btn.sysMenu.add\",\"id\":15,\"status\":1},{\"select\":false,\"updateTime\":1654737758000,\"type\":2,\"parentId\":5,\"sortValue\":1,\"isDeleted\":0,\"children\":[],\"createTime\":1622455537000,\"param\":{},\"name\":\"修改\",\"perms\":\"btn.sysMenu.update\",\"id\":16,\"status\":1},{\"select\":false,\"updateTime\":1654737758000,\"type\":2,\"parentId\":5,\"sortValue\":1,\"isDeleted\":0,\"children\":[],\"createTime\":1622455537000,\"param\":{},\"name\":\"删除\",\"perms\":\"btn.sysMenu.remove\",\"id\":17,\"status\":1}],\"createTime\":1622455537000,\"param\":{},\"name\":\"菜单管理\",\"perms\":\"\",\"id\":5,\"status\":1}',
        '{\"code\":200,\"message\":\"成功\"}', 1, '', NULL, '2022-06-09 09:24:21', NULL, 0),
       (51, '菜单管理', 'UPDATE', 'com.atguigu.system.controller.SysMenuController.updateById()', 'PUT', 'MANAGE', 'admin',
        '', '/admin/system/sysMenu/update', '127.0.0.1',
        '{\"select\":false,\"icon\":\"el-icon-s-operation\",\"updateTime\":1654737776000,\"type\":1,\"parentId\":2,\"path\":\"sysDept\",\"sortValue\":1,\"component\":\"system/sysDept/list\",\"isDeleted\":0,\"children\":[{\"select\":false,\"updateTime\":1654737758000,\"type\":2,\"parentId\":20,\"sortValue\":1,\"isDeleted\":0,\"children\":[],\"createTime\":1653358064000,\"param\":{},\"name\":\"查看\",\"perms\":\"btn.sysDept.list\",\"id\":21,\"status\":1},{\"select\":false,\"updateTime\":1654737758000,\"type\":2,\"parentId\":20,\"sortValue\":1,\"isDeleted\":0,\"children\":[],\"createTime\":1653463887000,\"param\":{},\"name\":\"添加\",\"perms\":\"btn.sysDept.add\",\"id\":24,\"status\":1},{\"select\":false,\"updateTime\":1654737758000,\"type\":2,\"parentId\":20,\"sortValue\":1,\"isDeleted\":0,\"children\":[],\"createTime\":1653463901000,\"param\":{},\"name\":\"修改\",\"perms\":\"btn.sysDept.update\",\"id\":25,\"status\":1},{\"select\":false,\"updateTime\":1654737758000,\"type\":2,\"parentId\":20,\"sortValue\":1,\"isDeleted\":0,\"children\":[],\"createTime\":1653463919000,\"param\":{},\"name\":\"删除\",\"perms\":\"btn.sysDept.remove\",\"id\":26,\"status\":1}],\"createTime\":1653358025000,\"param\":{},\"name\":\"部门管理\",\"perms\":\"\",\"id\":20,\"status\":1}',
        '{\"code\":200,\"message\":\"成功\"}', 1, '', NULL, '2022-06-09 09:24:28', NULL, 0),
       (52, '菜单管理', 'UPDATE', 'com.atguigu.system.controller.SysMenuController.updateById()', 'PUT', 'MANAGE', 'admin',
        '', '/admin/system/sysMenu/update', '127.0.0.1',
        '{\"select\":false,\"icon\":\"el-icon-more-outline\",\"updateTime\":1654737777000,\"type\":1,\"parentId\":2,\"path\":\"sysPost\",\"sortValue\":1,\"component\":\"system/sysPost/list\",\"isDeleted\":0,\"children\":[{\"select\":false,\"updateTime\":1654737758000,\"type\":2,\"parentId\":22,\"sortValue\":1,\"isDeleted\":0,\"children\":[],\"createTime\":1653359145000,\"param\":{},\"name\":\"查看\",\"perms\":\"btn.sysPost.list\",\"id\":23,\"status\":1},{\"select\":false,\"updateTime\":1654737758000,\"type\":2,\"parentId\":22,\"sortValue\":1,\"isDeleted\":0,\"children\":[],\"createTime\":1653463964000,\"param\":{},\"name\":\"添加\",\"perms\":\"btn.sysPost.add\",\"id\":27,\"status\":1},{\"select\":false,\"updateTime\":1654737758000,\"type\":2,\"parentId\":22,\"sortValue\":1,\"isDeleted\":0,\"children\":[],\"createTime\":1653463978000,\"param\":{},\"name\":\"修改\",\"perms\":\"btn.sysPost.update\",\"id\":28,\"status\":1},{\"select\":false,\"updateTime\":1654737758000,\"type\":2,\"parentId\":22,\"sortValue\":1,\"isDeleted\":0,\"children\":[],\"createTime\":1653463991000,\"param\":{},\"name\":\"删除\",\"perms\":\"btn.sysPost.remove\",\"id\":29,\"status\":1}],\"createTime\":1653359130000,\"param\":{},\"name\":\"岗位管理\",\"perms\":\"\",\"id\":22,\"status\":1}',
        '{\"code\":200,\"message\":\"成功\"}', 1, '', NULL, '2022-06-09 09:24:35', NULL, 0),
       (53, '菜单管理', 'UPDATE', 'com.atguigu.system.controller.SysMenuController.updateById()', 'PUT', 'MANAGE', 'admin',
        '', '/admin/system/sysMenu/update', '127.0.0.1',
        '{\"select\":false,\"icon\":\"el-icon-tickets\",\"updateTime\":1653974966000,\"type\":0,\"parentId\":2,\"path\":\"log\",\"sortValue\":1,\"component\":\"ParentView\",\"isDeleted\":0,\"children\":[{\"select\":false,\"updateTime\":1654737785000,\"type\":1,\"parentId\":34,\"path\":\"sysOperLog\",\"sortValue\":1,\"component\":\"system/sysOperLog/list\",\"isDeleted\":0,\"children\":[{\"select\":false,\"updateTime\":1654737758000,\"type\":2,\"parentId\":30,\"sortValue\":1,\"isDeleted\":0,\"children\":[],\"createTime\":1653552617000,\"param\":{},\"name\":\"查看\",\"perms\":\"btn.sysOperLog.list\",\"id\":31,\"status\":1}],\"createTime\":1653552599000,\"param\":{},\"name\":\"操作日志\",\"perms\":\"\",\"id\":30,\"status\":1},{\"select\":false,\"updateTime\":1654737787000,\"type\":1,\"parentId\":34,\"path\":\"sysLoginLog\",\"sortValue\":1,\"component\":\"system/sysLoginLog/list\",\"isDeleted\":0,\"children\":[{\"select\":false,\"updateTime\":1654737758000,\"type\":2,\"parentId\":32,\"sortValue\":1,\"isDeleted\":0,\"children\":[],\"createTime\":1653554191000,\"param\":{},\"name\":\"查看\",\"id\":33,\"status\":1}],\"createTime\":1653554173000,\"param\":{},\"name\":\"登录日志\",\"perms\":\"\",\"id\":32,\"status\":1}],\"createTime\":1653974587000,\"param\":{},\"name\":\"日志管理\",\"perms\":\"\",\"id\":34,\"status\":1}',
        '{\"code\":200,\"message\":\"成功\"}', 1, '', NULL, '2022-06-09 09:24:46', NULL, 0),
       (54, '菜单管理', 'UPDATE', 'com.atguigu.system.controller.SysMenuController.updateById()', 'PUT', 'MANAGE', 'admin',
        '', '/admin/system/sysMenu/update', '127.0.0.1',
        '{\"select\":false,\"icon\":\"el-icon-document-remove\",\"updateTime\":1654737785000,\"type\":1,\"parentId\":34,\"path\":\"sysOperLog\",\"sortValue\":1,\"component\":\"system/sysOperLog/list\",\"isDeleted\":0,\"children\":[{\"select\":false,\"updateTime\":1654737758000,\"type\":2,\"parentId\":30,\"sortValue\":1,\"isDeleted\":0,\"children\":[],\"createTime\":1653552617000,\"param\":{},\"name\":\"查看\",\"perms\":\"btn.sysOperLog.list\",\"id\":31,\"status\":1}],\"createTime\":1653552599000,\"param\":{},\"name\":\"操作日志\",\"perms\":\"\",\"id\":30,\"status\":1}',
        '{\"code\":200,\"message\":\"成功\"}', 1, '', NULL, '2022-06-09 09:24:55', NULL, 0),
       (55, '菜单管理', 'UPDATE', 'com.atguigu.system.controller.SysMenuController.updateById()', 'PUT', 'MANAGE', 'admin',
        '', '/admin/system/sysMenu/update', '127.0.0.1',
        '{\"select\":false,\"icon\":\"el-icon-s-goods\",\"updateTime\":1654737787000,\"type\":1,\"parentId\":34,\"path\":\"sysLoginLog\",\"sortValue\":1,\"component\":\"system/sysLoginLog/list\",\"isDeleted\":0,\"children\":[{\"select\":false,\"updateTime\":1654737758000,\"type\":2,\"parentId\":32,\"sortValue\":1,\"isDeleted\":0,\"children\":[],\"createTime\":1653554191000,\"param\":{},\"name\":\"查看\",\"id\":33,\"status\":1}],\"createTime\":1653554173000,\"param\":{},\"name\":\"登录日志\",\"perms\":\"\",\"id\":32,\"status\":1}',
        '{\"code\":200,\"message\":\"成功\"}', 1, '', NULL, '2022-06-09 09:25:07', NULL, 0),
       (56, '用户管理', 'DELETE', 'com.atguigu.system.controller.SysUserController.remove()', 'DELETE', 'MANAGE', 'admin',
        '', '/admin/system/sysUser/remove/4', '127.0.0.1', '', '{\"code\":200,\"message\":\"成功\"}', 1, '', NULL,
        '2022-06-09 09:25:21', NULL, 0),
       (57, '菜单管理', 'UPDATE', 'com.atguigu.system.controller.SysMenuController.updateById()', 'PUT', 'MANAGE', 'admin',
        '', '/admin/system/sysMenu/update', '127.0.0.1',
        '{\"select\":false,\"updateTime\":1654737758000,\"type\":2,\"parentId\":4,\"path\":\"assignAuth\",\"sortValue\":1,\"component\":\"system/sysRole/assignAuth\",\"isDeleted\":0,\"children\":[],\"createTime\":1653297494000,\"param\":{},\"name\":\"分配权限\",\"perms\":\"btn.sysRole.assignAuth\",\"id\":19,\"status\":1}',
        '{\"code\":200,\"message\":\"成功\"}', 1, '', NULL, '2022-06-09 09:26:07', NULL, 0),
       (58, '角色管理', 'ASSGIN', 'com.atguigu.system.controller.SysMenuController.doAssign()', 'POST', 'MANAGE', 'admin',
        '', '/admin/system/sysMenu/doAssign', '127.0.0.1', '{\"roleId\":2,\"menuIdList\":[2,3,6,7,8,5,14,20,21]}',
        '{\"code\":200,\"message\":\"成功\"}', 1, '', NULL, '2022-06-09 09:26:34', NULL, 0),
       (59, '菜单管理', 'INSERT', 'com.atguigu.system.controller.SysMenuController.save()', 'POST', 'MANAGE', 'admin', '',
        '/admin/system/sysMenu/save', '127.0.0.1',
        '{\"select\":false,\"icon\":\"el-icon-s-help\",\"type\":0,\"parentId\":0,\"path\":\"vod\",\"sortValue\":1,\"component\":\"Layout\",\"param\":{},\"name\":\"点播管理\",\"perms\":\"\",\"id\":35,\"status\":1}',
        '{\"code\":200,\"message\":\"成功\"}', 1, '', NULL, '2022-06-10 15:26:53', NULL, 0),
       (60, '菜单管理', 'INSERT', 'com.atguigu.system.controller.SysMenuController.save()', 'POST', 'MANAGE', 'admin', '',
        '/admin/system/sysMenu/save', '127.0.0.1',
        '{\"select\":false,\"icon\":\"el-icon-phone\",\"type\":1,\"parentId\":35,\"path\":\"teacher/list\",\"sortValue\":1,\"component\":\"vod/teacher/list\",\"param\":{},\"name\":\"讲师列表\",\"perms\":\"\",\"id\":36,\"status\":1}',
        '{\"code\":200,\"message\":\"成功\"}', 1, '', NULL, '2022-06-10 15:27:38', NULL, 0),
       (61, '菜单管理', 'INSERT', 'com.atguigu.system.controller.SysMenuController.save()', 'POST', 'MANAGE', 'admin', '',
        '/admin/system/sysMenu/save', '127.0.0.1',
        '{\"select\":false,\"icon\":\"\",\"type\":2,\"parentId\":36,\"path\":\"teacher/create\",\"sortValue\":1,\"component\":\"vod/teacher/form\",\"param\":{},\"name\":\"添加\",\"perms\":\"btn.teacher.add\",\"id\":37,\"status\":1}',
        '{\"code\":200,\"message\":\"成功\"}', 1, '', NULL, '2022-06-10 15:28:27', NULL, 0),
       (62, '菜单管理', 'INSERT', 'com.atguigu.system.controller.SysMenuController.save()', 'POST', 'MANAGE', 'admin', '',
        '/admin/system/sysMenu/save', '127.0.0.1',
        '{\"select\":false,\"icon\":\"\",\"type\":2,\"parentId\":36,\"path\":\"teacher/edit/:id\",\"sortValue\":1,\"component\":\"vod/teacher/form\",\"param\":{},\"name\":\"修改\",\"perms\":\"btn.teacher.update\",\"id\":38,\"status\":1}',
        '{\"code\":200,\"message\":\"成功\"}', 1, '', NULL, '2022-06-10 15:29:13', NULL, 0),
       (63, '菜单管理', 'INSERT', 'com.atguigu.system.controller.SysMenuController.save()', 'POST', 'MANAGE', 'admin', '',
        '/admin/system/sysMenu/save', '127.0.0.1',
        '{\"select\":false,\"icon\":\"\",\"type\":2,\"parentId\":36,\"path\":\"\",\"sortValue\":1,\"component\":\"\",\"param\":{},\"name\":\"查看\",\"perms\":\"btn.teacher.list\",\"id\":39,\"status\":1}',
        '{\"code\":200,\"message\":\"成功\"}', 1, '', NULL, '2022-06-10 15:35:30', NULL, 0);

#
# Structure for table "sys_post"
#

DROP TABLE IF EXISTS `sys_post`;
CREATE TABLE `sys_post`
(
    `id`          bigint(20)   NOT NULL AUTO_INCREMENT COMMENT '岗位ID',
    `post_code`   varchar(64)  NOT NULL COMMENT '岗位编码',
    `name`        varchar(50)  NOT NULL DEFAULT '' COMMENT '岗位名称',
    `description` varchar(255) NOT NULL DEFAULT '' COMMENT '描述',
    `status`      tinyint(1)   NOT NULL DEFAULT '1' COMMENT '状态（1正常 0停用）',
    `create_time` timestamp    NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    `update_time` timestamp    NULL     DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
    `is_deleted`  bigint(20)   NOT NULL DEFAULT '0' COMMENT '删除标记（0:可用 其他:已删除）',
    PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB
  AUTO_INCREMENT = 9
  DEFAULT CHARSET = utf8 COMMENT ='岗位信息表';

#
# Data for table "sys_post"
#
INSERT INTO `sys_post`
VALUES (5, 'dsz', '董事长', '1', 1, '2022-05-24 10:33:53', NULL, 0),
       (6, 'zjl', '总经理', '2', 1, '2022-05-24 10:34:08', NULL, 0),
       (7, 'wz', '网咨', '', 1, '2022-05-27 08:56:41', '2022-05-27 08:56:41', 1),
       (8, 'yyzj', '运营总监', '', 1, '2022-06-08 17:14:21', NULL, 0);

#
# Structure for table "sys_user_role"
#

DROP TABLE IF EXISTS `sys_user_role`;
CREATE TABLE `sys_user_role`
(
    `id`          bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键id',
    `role_id`     bigint(20) NOT NULL DEFAULT '0' COMMENT '角色id',
    `user_id`     bigint(20) NOT NULL DEFAULT '0' COMMENT '用户id',
    `create_time` timestamp  NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `update_time` timestamp  NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    `is_deleted`  bigint(20) NOT NULL DEFAULT '0' COMMENT '删除标记（0:可用 其他:已删除）',
    PRIMARY KEY (`id`),
    KEY `idx_role_id` (`role_id`),
    KEY `idx_admin_id` (`user_id`)
) ENGINE = InnoDB
  AUTO_INCREMENT = 11
  DEFAULT CHARSET = utf8 COMMENT ='用户角色';

#
# Data for table "sys_user_role"
#

INSERT INTO `sys_user_role`
VALUES (2, 2, 2, '2022-01-20 20:49:37', '2022-02-24 10:43:07', 0),
       (3, 1, 1, '2022-05-19 10:37:27', '2022-05-24 16:55:53', 1),
       (4, 2, 1, '2022-05-19 10:37:27', '2022-05-24 16:55:53', 1),
       (5, 1, 1, '2022-05-24 16:55:53', '2022-05-24 16:55:53', 0),
       (6, 2, 3, '2022-05-25 16:09:31', '2022-05-25 16:09:31', 0),
       (7, 2, 4, '2022-06-02 11:08:14', '2022-06-02 11:15:36', 1),
       (8, 2, 4, '2022-06-02 11:15:36', '2022-06-02 16:10:53', 1),
       (9, 1, 4, '2022-06-02 11:15:36', '2022-06-02 16:10:53', 1),
       (10, 1, 4, '2022-06-02 16:10:53', '2022-06-02 16:10:53', 0);

#
# Structure for table "sys_role"
#


#
# Data for table "sys_role"
#

DROP TABLE IF EXISTS `sys_role`;
CREATE TABLE `sys_role`
(
    `id`          bigint(20)  NOT NULL AUTO_INCREMENT COMMENT '角色id',
    `role_name`   varchar(20) NOT NULL DEFAULT '' COMMENT '角色名称',
    `role_code`   varchar(20)          DEFAULT NULL COMMENT '角色编码',
    `description` varchar(255)         DEFAULT NULL COMMENT '描述',
    `create_time` timestamp   NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `update_time` timestamp   NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    `is_deleted`  bigint(20)  NOT NULL DEFAULT '0' COMMENT '删除标记（0:可用 其他:已删除）',
    PRIMARY KEY (`id`)
) ENGINE = InnoDB
  AUTO_INCREMENT = 9
  DEFAULT CHARSET = utf8 COMMENT ='角色';

#
# Structure for table "sys_role_menu"
#

INSERT INTO `sys_role`
VALUES (1, '系统管理员', 'SYSTEM', '系统管理员', '2021-05-31 18:09:18', '2022-06-08 09:21:10', 0),
       (2, '普通管理员', 'COMMON', '普通管理员', '2021-06-01 08:38:40', '2022-02-24 10:42:46', 0),
       (8, '用户管理员', 'yhgly', NULL, '2022-06-08 17:39:04', '2022-06-08 17:39:04', 0);

#
# Data for table "sys_role_menu"
#

DROP TABLE IF EXISTS `sys_role_menu`;
CREATE TABLE `sys_role_menu`
(
    `id`          bigint(20) NOT NULL AUTO_INCREMENT,
    `role_id`     bigint(20) NOT NULL DEFAULT '0',
    `menu_id`     bigint(11) NOT NULL DEFAULT '0',
    `create_time` timestamp  NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `update_time` timestamp  NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    `is_deleted`  bigint(20) NOT NULL DEFAULT '0' COMMENT '删除标记（0:可用 其他:已删除）',
    PRIMARY KEY (`id`),
    KEY `idx_role_id` (`role_id`),
    KEY `idx_menu_id` (`menu_id`)
) ENGINE = InnoDB
  AUTO_INCREMENT = 33
  DEFAULT CHARSET = utf8 COMMENT ='角色菜单';

#
# Structure for table "sys_user"
#

INSERT INTO `sys_role_menu`
VALUES (1, 2, 2, '2022-06-02 16:11:27', '2022-06-02 16:16:10', 1),
       (2, 2, 3, '2022-06-02 16:11:27', '2022-06-02 16:16:10', 1),
       (3, 2, 6, '2022-06-02 16:11:27', '2022-06-02 16:16:10', 1),
       (4, 2, 7, '2022-06-02 16:11:27', '2022-06-02 16:16:10', 1),
       (5, 2, 8, '2022-06-02 16:11:27', '2022-06-02 16:16:10', 1),
       (6, 2, 9, '2022-06-02 16:11:27', '2022-06-02 16:16:10', 1),
       (7, 2, 18, '2022-06-02 16:11:27', '2022-06-02 16:16:10', 1),
       (8, 2, 4, '2022-06-02 16:11:27', '2022-06-02 16:16:10', 1),
       (9, 2, 10, '2022-06-02 16:11:27', '2022-06-02 16:16:10', 1),
       (10, 2, 11, '2022-06-02 16:11:27', '2022-06-02 16:16:10', 1),
       (11, 2, 12, '2022-06-02 16:11:27', '2022-06-02 16:16:10', 1),
       (12, 2, 13, '2022-06-02 16:11:27', '2022-06-02 16:16:10', 1),
       (13, 2, 19, '2022-06-02 16:11:27', '2022-06-02 16:16:10', 1),
       (14, 2, 5, '2022-06-02 16:11:27', '2022-06-02 16:16:10', 1),
       (15, 2, 14, '2022-06-02 16:11:27', '2022-06-02 16:16:10', 1),
       (16, 2, 15, '2022-06-02 16:11:27', '2022-06-02 16:16:10', 1),
       (17, 2, 16, '2022-06-02 16:11:27', '2022-06-02 16:16:10', 1),
       (18, 2, 17, '2022-06-02 16:11:27', '2022-06-02 16:16:10', 1),
       (19, 2, 2, '2022-06-02 16:16:10', '2022-06-09 09:26:34', 1),
       (20, 2, 3, '2022-06-02 16:16:10', '2022-06-09 09:26:34', 1),
       (21, 2, 6, '2022-06-02 16:16:10', '2022-06-09 09:26:34', 1),
       (22, 2, 7, '2022-06-02 16:16:10', '2022-06-09 09:26:34', 1),
       (23, 2, 8, '2022-06-02 16:16:10', '2022-06-09 09:26:34', 1),
       (24, 2, 2, '2022-06-09 09:26:34', '2022-06-09 09:26:34', 0),
       (25, 2, 3, '2022-06-09 09:26:34', '2022-06-09 09:26:34', 0),
       (26, 2, 6, '2022-06-09 09:26:34', '2022-06-09 09:26:34', 0),
       (27, 2, 7, '2022-06-09 09:26:34', '2022-06-09 09:26:34', 0),
       (28, 2, 8, '2022-06-09 09:26:34', '2022-06-09 09:26:34', 0),
       (29, 2, 5, '2022-06-09 09:26:34', '2022-06-09 09:26:34', 0),
       (30, 2, 14, '2022-06-09 09:26:34', '2022-06-09 09:26:34', 0),
       (31, 2, 20, '2022-06-09 09:26:34', '2022-06-09 09:26:34', 0),
       (32, 2, 21, '2022-06-09 09:26:34', '2022-06-09 09:26:34', 0);

#
# Data for table "sys_user"
#

DROP TABLE IF EXISTS `sys_user`;
CREATE TABLE `sys_user`
(
    `id`          bigint(20)  NOT NULL AUTO_INCREMENT COMMENT '会员id',
    `username`    varchar(20) NOT NULL DEFAULT '' COMMENT '用户名',
    `password`    varchar(255) NOT NULL DEFAULT '' COMMENT '密码',
    `name`        varchar(50)          DEFAULT NULL COMMENT '姓名',
    `phone`       varchar(11)          DEFAULT NULL COMMENT '手机',
    `head_url`    varchar(200)         DEFAULT NULL COMMENT '头像地址',
    `dept_id`     bigint(20)           DEFAULT NULL COMMENT '部门id',
    `post_id`     bigint(20)           DEFAULT NULL COMMENT '岗位id',
    `description` varchar(255)         DEFAULT NULL COMMENT '描述',
    `status`      tinyint(3)           DEFAULT NULL COMMENT '状态（1：正常 0：停用）',
    `create_time` timestamp   NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `update_time` timestamp   NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    `is_deleted`  bigint(20)  NOT NULL DEFAULT '0' COMMENT '删除标记（0:可用 其他:已删除）',
    PRIMARY KEY (`id`),
    UNIQUE KEY `idx_username_is_deleted` (`username`, `is_deleted`)
) ENGINE = InnoDB
  AUTO_INCREMENT = 4
  DEFAULT CHARSET = utf8mb4 COMMENT ='用户表';

INSERT INTO `sys_user`
VALUES (1, 'admin', '$2a$10$ods1/2iEPBgm5uXUYWGALOUCZpP24H7tD0wXBfPhgt172PVNRFntO', 'admin', '15099909888',
        'http://r61cnlsfq.hn-bkt.clouddn.com/7daa4595-dfde-45da-8513-c5c2b81d20cc', 1021, 5, NULL, 1,
        '2021-05-31 18:08:43', '2022-05-25 11:34:25', 0),
       (2, 'wangqq', '$2a$10$ods1/2iEPBgm5uXUYWGALOUCZpP24H7tD0wXBfPhgt172PVNRFntO', '王倩倩', '15010546381',
        'http://r61cnlsfq.hn-bkt.clouddn.com/b09b3467-3d99-437a-bd2e-dd8c9be92bb8', 1022, 6, NULL, 1,
        '2022-02-08 10:35:38', '2022-05-25 15:58:31', 0),
       (3, 'wanggang', '$2a$10$ods1/2iEPBgm5uXUYWGALOUCZpP24H7tD0wXBfPhgt172PVNRFntO', '王刚', '18909098909', NULL, 1024, 5, NULL, 0,
        '2022-05-24 11:05:40', '2022-06-02 10:19:25', 0);
```



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
    private Long id;

    @ApiModelProperty("创建时间")
    @TableField("create_time")
    private Date createTime;

    @ApiModelProperty("更新时间")
    @TableField("update_time")
    private Date updateTime;

    @ApiModelProperty("逻辑删除{0: 没有删除, 其他: 已经删除}")
    @TableLogic(delval = "id")
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


# 三 用户管理

```
git checkout -b 3.0.0_user
```

## 1 后端

![img](https://cdn.nlark.com/yuque/0/2022/jpeg/12811585/1668323733703-4b05face-2fe8-4c48-bd58-bcc32cb89ae8.jpeg)

### 1.1 代码生成器(旧)

#### 1.1.1 代码生成器依赖

```xml
	<!-- 代码生成器 -->
	<dependency>
		<groupId>com.baomidou</groupId>
		<artifactId>mybatis-plus-generator</artifactId>
		<version>3.4.1</version>
	</dependency>

	<dependency>
		<groupId>org.apache.velocity</groupId>
		<artifactId>velocity-engine-core</artifactId>
		<version>2.0</version>
	</dependency>
```



#### 1.1.2 代码生成器 `CodeGet`

```java
package com.atguigu.system;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.core.exceptions.MybatisPlusException;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.config.PackageConfig;
import com.baomidou.mybatisplus.generator.config.StrategyConfig;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import org.apache.commons.lang3.StringUtils;

import java.util.Scanner;

/**
 * 代码生成器
 *
 * @author 陈江林
 * @date 2022/11/13 16:24
 */
public class CodeGet {

    public static void main(String[] args) {
        // 1、创建代码生成器
        AutoGenerator mpg = new AutoGenerator();

        // 2、全局配置
        // 全局配置
        GlobalConfig gc = new GlobalConfig();
        String projectPath = System.getProperty("user.dir");
        //gc.setOutputDir(projectPath + "/src/main/java");
        gc.setOutputDir("/Users/chenjianglin/IdeaProjects/system-auth/guigu-auth-parent/service/service-system" + "/src/main/java");

        //去掉Service接口的首字母I
        gc.setServiceName("%sService");
        // 作者
        gc.setAuthor("陈江林");
        gc.setOpen(false);
        mpg.setGlobalConfig(gc);

        // 3、数据源配置
        DataSourceConfig dsc = new DataSourceConfig();
        dsc.setUrl("jdbc:mysql://175.178.174.83:3306/guigu-auth");
        dsc.setDriverName("com.mysql.jdbc.Driver");
        dsc.setUsername("root");
        dsc.setPassword(scanner("数据库密码"));
        dsc.setDbType(DbType.MYSQL);
        mpg.setDataSource(dsc);

        // 4、包配置
        PackageConfig pc = new PackageConfig();
        pc.setParent("com.atguigu");
        // 模块名
        pc.setModuleName("system");
        pc.setController("controller");
        pc.setEntity("entity");
        pc.setService("service");
        pc.setMapper("mapper");
        mpg.setPackageInfo(pc);

        // 5、策略配置
        StrategyConfig strategy = new StrategyConfig();

        // 表名
        strategy.setInclude(scanner("表名，多个英文逗号分割").split(","));
        //数据库表映射到实体的命名策略
        strategy.setNaming(NamingStrategy.underline_to_camel);
        //数据库表字段映射到实体的命名策略
        strategy.setColumnNaming(NamingStrategy.underline_to_camel);
        // lombok 模型 @Accessors(chain = true) setter链式操作
        strategy.setEntityLombokModel(true);
        //restful api风格控制器
        strategy.setRestControllerStyle(true);
        //url中驼峰转连字符
        strategy.setControllerMappingHyphenStyle(true);

        mpg.setStrategy(strategy);

        // 6、执行
        mpg.execute();
    }

    /**
     * <p>
     * 读取控制台内容
     * </p>
     */
    public static String scanner(String tip) {
        Scanner scanner = new Scanner(System.in);
        StringBuilder help = new StringBuilder();
        help.append("请输入" + tip + "：");
        System.out.println(help);
        if (scanner.hasNext()) {
            String ipt = scanner.next();
            if (StringUtils.isNotBlank(ipt)) {
                return ipt;
            }
        }
        throw new MybatisPlusException("请输入正确的" + tip + "！");
    }

}
```



### 1.2 控制类

```java
package com.atguigu.system.controller;

import com.atguigu.common.result.Result;
import com.atguigu.model.system.SysUser;
import com.atguigu.model.vo.SysUserQueryVo;
import com.atguigu.system.service.SysUserService;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 * 用户表 前端控制器
 * </p>
 *
 * @author 陈江林
 * @since 2022-11-13
 */
@Api(tags = "用户管理接口")
@RestController
@RequestMapping("/admin/system/sysUser")
public class SysUserController {

    @Autowired
    private SysUserService sysUserService;

    @ApiOperation("用户保存")
    @PostMapping("/save")
    public Result save(@RequestBody SysUser sysUser) {
        if (sysUserService.save(sysUser)) {
            return Result.ok();
        } else {
            return Result.fail();
        }
    }

    @ApiOperation("用户修改")
    @PutMapping("/update")
    public Result update(@RequestBody SysUser sysUser) {
        if (sysUserService.updateById(sysUser)) {
            return Result.ok();
        } else {
            return Result.fail();
        }
    }

    @ApiOperation("根据id获取用户信息")
    @GetMapping("/getById/{id}")
    public Result<SysUser> getById(
            @PathVariable Long id
    ) {
        return Result.ok(sysUserService.getById(id));
    }

    @ApiOperation("分页查询")
    @GetMapping("/{page}/{limit}")
    public Result<IPage<SysUser>> getPage(
            @PathVariable Long page,
            @PathVariable Long limit,
            SysUserQueryVo sysUserQueryVo
    ) {
        return Result.ok(sysUserService.getPage(new Page<>(page, limit), sysUserQueryVo));
    }

    @ApiOperation("根据id删除")
    @DeleteMapping("/removeById/{id}")
    public Result removeById(
            @PathVariable Long id
    ) {
        if (sysUserService.removeById(id)) {
            return Result.ok();
        } else {
            return Result.fail();
        }
    }

    @ApiOperation("批量删除")
    @DeleteMapping("/removeByIds")
    public Result removeByIds(
            @RequestBody List<Long> ids
    ) {
        if (sysUserService.removeByIds(ids)) {
            return Result.ok();
        } else {
            return Result.fail();
        }
    }

}
```



### 1.3 服务接口

```java
package com.atguigu.system.service;

import com.atguigu.model.system.SysUser;
import com.atguigu.model.vo.SysUserQueryVo;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 用户表 服务类
 * </p>
 *
 * @author 陈江林
 * @since 2022-11-13
 */
public interface SysUserService extends IService<SysUser> {

    /**
     * 分页查询
     *
     * @param objectPage
     * @param sysUserQueryVo
     * @return {@link IPage}<{@link SysUser}>
     */
    IPage<SysUser> getPage(Page<SysUser> objectPage, SysUserQueryVo sysUserQueryVo);
}
```



### 1.4 服务实现类

```java
package com.atguigu.system.service.impl;

import com.atguigu.model.system.SysUser;
import com.atguigu.model.vo.SysUserQueryVo;
import com.atguigu.system.mapper.SysUserMapper;
import com.atguigu.system.service.SysUserService;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户表 服务实现类
 * </p>
 *
 * @author 陈江林
 * @since 2022-11-13
 */
@Service
public class SysUserServiceImpl extends ServiceImpl<SysUserMapper, SysUser> implements SysUserService {

    @Override
    public IPage<SysUser> getPage(Page<SysUser> objectPage, SysUserQueryVo sysUserQueryVo) {
        return baseMapper.selectPage(objectPage, sysUserQueryVo);
    }
}
```



### 1.5 `Mapper` 接口

```java
package com.atguigu.system.mapper;

import com.atguigu.model.system.SysUser;
import com.atguigu.model.vo.SysUserQueryVo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Param;

/**
 * <p>
 * 用户表 Mapper 接口
 * </p>
 *
 * @author 陈江林
 * @since 2022-11-13
 */
public interface SysUserMapper extends BaseMapper<SysUser> {
    /**
     * 分页查询
     *
     * @param objectPage
     * @param sysUserQueryVo
     * @return {@link IPage}<{@link SysUser}>
     */
    IPage<SysUser> selectPage(Page<SysUser> objectPage, @Param("vo") SysUserQueryVo sysUserQueryVo);
}
```



### 1.6 `XML`

```xml
<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE mapper PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN" "http://mybatis.org/dtd/mybatis-3-mapper.dtd">
<mapper namespace="com.atguigu.system.mapper.SysUserMapper">

    <resultMap id="RoleMap" type="com.atguigu.model.system.SysUser" autoMapping="true"/>

    <!-- 用于select查询公用抽取的列 -->
    <sql id="columns">
        id ,username ,password ,name ,phone ,head_url ,dept_id ,post_id ,description ,status ,create_time ,update_time ,is_deleted
    </sql>

    <select id="selectPage" resultType="com.atguigu.model.system.SysUser">
        select
        <include refid="columns"/>
        from sys_user
        <where>
            <if test="vo.keyword != null and vo.keyword != ''">
                and (
                username like CONCAT('%',#{vo.keyword},'%')
                or name like CONCAT('%',#{vo.keyword},'%')
                or phone like CONCAT('%',#{vo.keyword},'%')
                )
            </if>
            <if test="vo.createTimeBegin != null and vo.createTimeBegin != ''">
                and create_time >= #{vo.createTimeBegin}
            </if>
            <if test="vo.createTimeEnd != null and vo.createTimeEnd != ''">
                and create_time &lt;= #{vo.createTimeEnd}
            </if>
            and is_deleted = 0
        </where>
        order by id desc
    </select>


</mapper>
```

#### 1.6.1 扩展

```latex
&lt;     <    小于号
&gt;     >    大于号
&amp;    &    和
&apos;   '    单引号
&quot;   "    双引号
&lt;=    <=   小于等于
&gt;=    >=   大于等于
```



## 2 前端

### 2.1 `API`

![img](https://cdn.nlark.com/yuque/0/2022/png/12811585/1668415002311-a8c144a2-3da2-43cf-ace4-30abe226536d.png)

```javascript
import request from '@/utils/request'

const api_name = '/admin/system/sysUser'

// 保存
export function save(data) {
  return request({
    url: `${api_name}/save`,
    method: 'post',
    data
  })
}

// 修改
export function update(data) {
  return request({
    url: `${api_name}/update`,
    method: 'put',
    data
  })
}

// 根据 id 获取信息
export function getById(id) {
  return request({
    url: `${api_name}/getById/${id}`,
    method: 'get'
  })
}

// 获取分页数据
export function getPageList(page, limit, params) {
  return request({
    url: `${api_name}/${page}/${limit}`,
    method: 'get',
    params
  })
}

// 根据 id 删除
export function removeById(id) {
  return request({
    url: `${api_name}/removeById/${id}`,
    method: 'delete'
  })
}

// 批量删除
export function removeByIds(ids) {
  return request({
    url: `${api_name}/removeByIds`,
    method: 'delete',
    data: {
      ids
    }
  })
}
```



### 2.2 路由

```javascript
{
  path: 'sysUser',
  name: 'SysUser',
  component: () => import('@/views/system/sysUser/list'),
  meta: { title: '用户管理', icon: 'table' }
}
```



### 2.3 页面

```vue
<template>
  <div>
    <!-- 卡片视图区域 -->
    <el-card>
      <el-row :gutter="22">
        <el-col :span="8">
          <el-input
            v-model="searchObj.keyword"
            placeholder="请输入用户名/姓名/手机号码"
            class="input-with-select"
            clearable
            @clear="getList"
          >
            <el-button slot="append" icon="el-icon-search" @click="getList" />
          </el-input>
        </el-col>
        <el-col :span="8">
          <el-date-picker
            v-model="createTimes"
            type="daterange"
            align="right"
            unlink-panels
            range-separator="至"
            start-placeholder="开始日期"
            end-placeholder="结束日期"
            value-format="yyyy-MM-dd HH:mm:ss"
            :picker-options="pickerOptions"
          />
        </el-col>
        <el-col :span="6">
          <el-button type="primary" @click="showAddDialogVisible()">添加用户</el-button>
          <el-button type="danger" @click="removeRoles()">批量删除</el-button>
        </el-col>
      </el-row>

      <!-- table 表格区域 -->
      <el-table
        :data="list"
        border
        stripe
        @selection-change="handleSelectionChange"
      >
        <el-table-column type="selection" />
        <el-table-column
          label="序号"
          width="70"
          align="center"
        >
          <template slot-scope="scope">
            {{ (page - 1) * limit + scope.$index + 1 }}
          </template>
        </el-table-column>
        <el-table-column prop="username" label="用户名" width="180" />
        <el-table-column prop="name" label="姓名" width="110" />
        <el-table-column prop="phone" label="手机" />
        <el-table-column label="状态" width="80">
          <template slot-scope="scope">
            <el-switch
              :value="scope.row.status === 1"
              @change="switchStatus(scope.row)"
            />
          </template>
        </el-table-column>
        <el-table-column prop="createTime" label="创建时间" />
        <el-table-column label="操作" width="180px">
          <template slot-scope="scope">
            <!-- 修改 -->
            <el-button size="mini" type="primary" icon="el-icon-edit" @click="showEditDialogVisible(scope.row.id)" />
            <!-- 删除 -->
            <el-button
              size="mini"
              type="danger"
              icon="el-icon-delete"
              @click="removeDataById(scope.row.id)"
            />
            <!-- 分配角色按钮 -->
            <el-tooltip effect="dark" content="分配角色" placement="top-start" :enterable="false">
              <el-button
                type="warning"
                icon="el-icon-setting"
                size="mini"
                @click="showAssignRole(scope.row)"
              />
            </el-tooltip>
          </template>
        </el-table-column>
      </el-table>

      <!-- 分页区域 -->
      <el-pagination
        :current-page="page"
        :page-sizes="[5, 10, 15, 20]"
        :page-size="limit"
        layout="total, sizes, prev, pager, next, jumper"
        :total="total"
        background
        @size-change="handleSizeChange"
        @current-change="handleCurrentChange"
      />
    </el-card>

    <!-- 添加/修改 对话框 -->
    <el-dialog
      :title="saveOrUpdateTitle"
      :visible.sync="saveOrUpdateDialogVisible"
      width="50%"
      @close="saveOrUpdateDialogClose"
    >
      <!-- 内容主体区域 -->
      <el-form ref="saveOrUpdateFormRef" :model="saveOrUpdateForm" :rules="saveOrUpdateFormRules" label-width="80px">
        <el-form-item label="用户名" prop="username">
          <el-input v-model="saveOrUpdateForm.username" />
        </el-form-item>
        <el-form-item v-if="!saveOrUpdateForm.id" label="密码" prop="password">
          <el-input v-model="saveOrUpdateForm.password" type="password" />
        </el-form-item>
        <el-form-item label="姓名" prop="name">
          <el-input v-model="saveOrUpdateForm.name" />
        </el-form-item>
        <el-form-item label="手机" prop="phone">
          <el-input v-model="saveOrUpdateForm.phone" />
        </el-form-item>
      </el-form>
      <!-- 底部区域 -->
      <span slot="footer" class="dialog-footer">
        <el-button @click="saveOrUpdateDialogVisible = false">取 消</el-button>
        <el-button type="primary" @click="saveOrUpdate">确 定</el-button>
      </span>
    </el-dialog>

    <!-- 分配角色对话框 -->
    <el-dialog title="分配角色" :visible.sync="dialogRoleVisible">
      <el-form label-width="80px">
        <el-form-item label="用户名">
          <el-input disabled :value="sysUser.username" />
        </el-form-item>

        <el-form-item label="角色列表">
          <el-checkbox v-model="checkAll" :indeterminate="isIndeterminate" @change="handleCheckAllChange">全选
          </el-checkbox>
          <div style="margin: 15px 0;" />
          <el-checkbox-group v-model="userRoleIds" @change="handleCheckedChange">
            <el-checkbox v-for="role in allRoles" :key="role.id" :label="role.id">{{ role.roleName }}</el-checkbox>
          </el-checkbox-group>
        </el-form-item>
      </el-form>
      <div slot="footer">
        <el-button type="primary" size="small" @click="assignRole">保存</el-button>
        <el-button size="small" @click="dialogRoleVisible = false">取消</el-button>
      </div>
    </el-dialog>
  </div>
</template>

<script>
import { save, updateStatus, update, getById, getPageList, removeById, removeByIds } from '@/api/system/user'
import { getRolesByUserId, doAssign } from '@/api/system/role'

export default {
  name: 'List',
  data() {
    // 验证手机号的规则
    const checkMobile = (rule, value, cb) => {
      // 验证手机号的正则表达式
      const regMobile = /^(0|86|17951)?(13[0-9]|15[0123456789]|17[678]|18[0-9]|14[57])[0-9]{8}$/

      if (regMobile.test(value)) {
        // 合法的手机号
        return cb()
      }

      cb(new Error('请输入合法的手机号'))
    }

    return {
      // 用户列表
      list: [],
      // 总记录数
      total: 0,
      // 当前页
      page: 1,
      // 每页显示记录数
      limit: 10,
      // 时间条件
      createTimes: [],
      // 条件查询封装对象
      searchObj: {
        keyword: '',
        createTimeBegin: '',
        createTimeEnd: ''
      },
      // - 批量删除
      // 选中的数据
      multipleSelection: [],
      // - 添加或修改
      // 控制对话框的显示与隐藏
      saveOrUpdateDialogVisible: false,
      // 标题
      saveOrUpdateTitle: '',
      // 表单数据
      saveOrUpdateForm: {
        roleName: '',
        roleCode: ''
      },
      // 表单规则
      saveOrUpdateFormRules: {
        username: [
          {
            required: true,
            message: '请输入用户名称',
            trigger: 'blur'
          }
        ],
        password: [
          {
            required: true,
            message: '请输入用户密码',
            trigger: 'blur'
          },
          {
            min: 6,
            max: 15,
            message: '密码的长度在 6-15 个字符之间',
            trigger: 'blur'
          }
        ],
        name: [
          {
            required: true,
            message: '请输入姓名',
            trigger: 'blur'
          }
        ],
        phone: [
          {
            required: true,
            message: '请输入手机号码',
            trigger: 'blur'
          },
          {
            validator: checkMobile,
            trigger: 'blur'
          }
        ]
      },
      pickerOptions: {
        shortcuts: [{
          text: '最近一周',
          onClick(picker) {
            const end = new Date()
            const start = new Date()
            start.setTime(start.getTime() - 3600 * 1000 * 24 * 7)
            picker.$emit('pick', [start, end])
          }
        }, {
          text: '最近一个月',
          onClick(picker) {
            const end = new Date()
            const start = new Date()
            start.setTime(start.getTime() - 3600 * 1000 * 24 * 30)
            picker.$emit('pick', [start, end])
          }
        }, {
          text: '最近三个月',
          onClick(picker) {
            const end = new Date()
            const start = new Date()
            start.setTime(start.getTime() - 3600 * 1000 * 24 * 90)
            picker.$emit('pick', [start, end])
          }
        }]
      },
      /* 分配角色 */
      sysUser: {},
      // 分配角色控制对话框的显示与隐藏
      dialogRoleVisible: false,
      // 所有角色列表
      allRoles: [],
      // 用户的角色ID的列表
      userRoleIds: [],
      // 是否是不确定的
      isIndeterminate: false,
      // 是否全选
      checkAll: false
    }
  },
  watch: {
    createTimes(newValue) {
      if (newValue && newValue.length === 2) {
        // 选择时间
        this.searchObj.createTimeBegin = newValue[0]
        this.searchObj.createTimeEnd = newValue[1]
      } else {
        // 取消时间
        this.searchObj.createTimeBegin = ''
        this.searchObj.createTimeEnd = ''
      }

      this.getList()
    }
  },
  created() {
    this.getList()
  },
  methods: {
    // 切换用户状态
    switchStatus(row) {
      row.status = row.status === 1 ? 0 : 1
      updateStatus(row.id, row.status).then(res => {
        if (res.code) {
          this.$message.success(res.message || '操作成功')
          this.getList()
        }
      })
    },
    // 获取列表数据
    getList() {
      getPageList(this.page, this.limit, this.searchObj).then(res => {
        this.list = res.data.records
        this.total = res.data.total
      })
    },
    handleSizeChange(newSize) {
      this.limit = newSize
      this.getList()
    },
    handleCurrentChange(newPage) {
      this.page = newPage
      this.getList()
    },
    // 保存或修改用户
    saveOrUpdate() {
      // 判断 id 是否存在 {true: 修改用户, false: 保存用户}
      if (!this.saveOrUpdateForm.id) {
        this.saveRole()
      } else {
        this.updateRole()
      }
    },
    saveRole() {
      // 表单验证
      this.$refs.saveOrUpdateFormRef.validate(valid => {
        if (!valid) return

        save(this.saveOrUpdateForm).then(res => {
          this.$message.success('保存用户成功!')
          // 关闭弹框
          this.saveOrUpdateDialogVisible = false
          // 刷新数据
          this.getList()
        })
      })
    },
    updateRole() {
      // 表单验证
      this.$refs.saveOrUpdateFormRef.validate(valid => {
        if (!valid) return
        update(this.saveOrUpdateForm).then(res => {
          this.$message.success('修改用户成功!')
          // 关闭弹框
          this.saveOrUpdateDialogVisible = false
          // 刷新数据
          this.getList()
        })
      })
    },
    showEditDialogVisible(id) {
      getById(id).then(res => {
        // 修改用户对应数据
        this.saveOrUpdateForm = res.data
        // 弹框标题
        this.saveOrUpdateTitle = '修改用户'
        // 显示弹框
        this.saveOrUpdateDialogVisible = true
      })
    },
    showAddDialogVisible() {
      // 弹框标题
      this.saveOrUpdateTitle = '添加用户'
      // 显示弹框
      this.saveOrUpdateDialogVisible = true
    },
    // 重置表单
    saveOrUpdateDialogClose() {
      // 清空表单数据
      this.saveOrUpdateForm = {}
    },
    removeDataById(id) {
      // 弹框询问用户是否删除数据
      this.$confirm('此操作将永久删除该用户, 是否继续?', '提示', {
        confirmButtonText: '确定',
        cancelButtonText: '取消',
        type: 'warning'
      }).then(() => {
        removeById(id).then(res => {
          this.$message.success('删除成功!')
          // 刷新数据
          this.getList()
        })
      }).catch(() => {
        this.$message({
          type: 'info',
          message: '已取消删除'
        })
      })
    },
    handleSelectionChange(val) {
      this.multipleSelection = val
    },
    removeRoles() {
      if (this.multipleSelection.length === 0) {
        this.$message.warning('请选择要删除的用户!')
        return
      }

      // 弹框询问用户是否删除数据
      this.$confirm('此操作将永久删除这些用户, 是否继续?', '提示', {
        confirmButtonText: '确定',
        cancelButtonText: '取消',
        type: 'warning'
      }).then(() => {
        const ids = []
        // 循环选中的用户信息, 取出 id 值
        this.multipleSelection.forEach(item => {
          // 精度问题: js 的数值存储为 2的53次方, 数据库ID是19位数值, 所以需要处理
          ids.push(item.id + '')
        })
        // 请求批量删除
        removeByIds(ids).then(res => {
          this.$message.success('批量删除成功!')
          // 刷新数据
          this.getList()
        })
      }).catch(() => {
        this.$message({
          type: 'info',
          message: '已取消删除'
        })
      })
    },
    /* 分配权限 */
    // 展示分配角色
    showAssignRole(row) {
      this.sysUser = row
      getRolesByUserId(row.id).then(response => {
        this.allRoles = response.data.allRoles
        this.userRoleIds = response.data.userRoleIds
        this.checkAll = this.userRoleIds.length === this.allRoles.length
        this.isIndeterminate = this.userRoleIds.length > 0 && this.userRoleIds.length < this.allRoles.length

        // 显示弹框
        this.dialogRoleVisible = true
      })
    },

    // 全选勾选状态发生改变的监听
    // value 当前勾选状态 true/false
    handleCheckAllChange(value) {
      // 如果当前全选, userRoleIds就是所有角色id的数组, 否则是空数组
      this.userRoleIds = value ? this.allRoles.map(item => item.id) : []
      // 如果当前不是全选也不全不选时, 指定为false
      this.isIndeterminate = false
    },

    // 角色列表选中项发生改变的监听
    handleCheckedChange(value) {
      const { userRoleIds, allRoles } = this
      this.checkAll = userRoleIds.length === allRoles.length && allRoles.length > 0
      this.isIndeterminate = userRoleIds.length > 0 && userRoleIds.length < allRoles.length
    },

    // 分配角色
    assignRole() {
      const assginRoleVo = {
        userId: this.sysUser.id,
        roleIdList: this.userRoleIds
      }

      doAssign(assginRoleVo).then(res => {
        this.$message.success('分配角色成功!')
        this.dialogRoleVisible = false
        this.getList()
      })
    }
  }
}
</script>

<style scoped>

</style>
```



## 3 分配角色功能-后端实现

### 3.1 角色管理控制类

```java
    @ApiOperation(value = "根据用户id获取对应角色")
    @GetMapping("/getRolesByUserId/{userId}")
    public Result<Map<String, Object>> getRolesByUserId(
            @PathVariable Long userId
    ) {
        return Result.ok(sysRoleService.getRolesByUserId(userId));
    }

    @ApiOperation(value = "给用户分配角色")
    @PostMapping("/doAssign")
    public Result<List<SysRole>> doAssign(
            @RequestBody AssginRoleVo assginRoleVo
    ) {
        sysRoleService.doAssign(assginRoleVo);
        return Result.ok();
    }
```

- 分配角色视图类 `AssginRoleVo`

```java
package com.atguigu.model.vo;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

@ApiModel(description = "分配菜单")
@Data
public class AssginRoleVo {

    @ApiModelProperty(value = "用户id")
    private String userId;

    @ApiModelProperty(value = "角色id列表")
    private List<String> roleIdList;

}
```

- 服务接口

```java
    /**
     * 根据用户id获取对应角色
     *
     * @param userId 用户id
     * @return {@link Map}<{@link String}, {@link Object}>
     */
    Map<String, Object> getRolesByUserId(Long userId);

    /**
     * 给用户分配角色
     *
     * @param assginRoleVo
     */
    void doAssign(AssginRoleVo assginRoleVo);
```

- 服务实现

```java
    @Override
    public Map<String, Object> getRolesByUserId(Long userId) {
        Map<String, Object> resultMap = new HashMap<>();
        resultMap.put("userRoleIds",
                // 根据用户id查询已经分配的角色
                sysUserRoleMapper.selectList(new LambdaQueryWrapper<SysUserRole>().eq(SysUserRole::getUserId, userId))
                        // 取出对应的角色id
                        .stream().map(SysUserRole::getRoleId).collect(Collectors.toList()));
        // 获取所有角色
        resultMap.put("allRoles", baseMapper.selectList(null));
        return resultMap;
    }

    @Override
    public void doAssign(AssginRoleVo assginRoleVo) {
        // - 重新分配角色
        // - - 先删除
        sysUserRoleMapper.delete(
                new LambdaQueryWrapper<SysUserRole>()
                        .eq(SysUserRole::getUserId, assginRoleVo.getUserId())
        );
        // - - 重新添加
        assginRoleVo.getRoleIdList().forEach(roleId -> {
            SysUserRole sysUserRole = new SysUserRole();
            sysUserRole.setUserId(assginRoleVo.getUserId());
            sysUserRole.setRoleId(roleId);
            sysUserRoleMapper.insert(sysUserRole);
        });
    }
```



### 3.2 新建用户角色中间表的`Mapper`接口

![img](https://cdn.nlark.com/yuque/0/2022/png/12811585/1668494894604-e92e2337-6266-4ca4-bc8c-3ba9a820c662.png)

```java
package com.atguigu.system.mapper;

import com.atguigu.model.system.SysUserRole;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * 用户角色中间表
 *
 * @author 陈江林
 * @date 2022/11/15 13:56
 */
public interface SysUserRoleMapper extends BaseMapper<SysUserRole> {
}
```



### 3.3 用户角色中间表实体类`SysUserRole`

```java
package com.atguigu.model.system;

import com.atguigu.model.base.BaseEntity;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(description = "用户角色")
@TableName("sys_user_role")
public class SysUserRole extends BaseEntity {
	
	private static final long serialVersionUID = 1L;

	@ApiModelProperty(value = "角色id")
	@TableField("role_id")
	private String roleId;

	@ApiModelProperty(value = "用户id")
	@TableField("user_id")
	private String userId;
}
```


# 四 菜单管理

```
git checkout -b 4.0.0_menu
```



## 1 后端接口

### 1.1 控制层

```java
package com.atguigu.system.controller;


import com.atguigu.common.result.Result;
import com.atguigu.model.system.SysMenu;
import com.atguigu.system.service.SysMenuService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 * 菜单表 前端控制器
 * </p>
 *
 * @author 陈江林
 * @since 2022-11-15
 */
@Api(tags="菜单管理接口")
@RestController
@RequestMapping("/admin/system/sysMenu")
public class SysMenuController {

    @Autowired
    private SysMenuService sysMenuService;

    @ApiOperation("菜单保存")
    @PostMapping("/save")
    public Result save(@RequestBody SysMenu sysMenu) {
        if (sysMenuService.save(sysMenu)) {
            return Result.ok();
        } else {
            return Result.fail();
        }
    }

    @ApiOperation("菜单修改")
    @PutMapping("/update")
    public Result update(@RequestBody SysMenu sysMenu) {
        if (sysMenuService.updateById(sysMenu)) {
            return Result.ok();
        } else {
            return Result.fail();
        }
    }

    @ApiOperation("根据id获取菜单信息")
    @GetMapping("/getById/{id}")
    public Result<SysMenu> getById(
            @PathVariable Long id
    ) {
        return Result.ok(sysMenuService.getById(id));
    }

    @ApiOperation("菜单列表(树形)")
    @GetMapping("/getAll")
    public Result<List<SysMenu>> getAll() {
        return Result.ok(sysMenuService.getAll());
    }

    @ApiOperation("根据id删除菜单")
    @DeleteMapping("/removeById/{id}")
    public Result removeById(
            @PathVariable Long id
    ) {
        if (sysMenuService.removeMenuById(id)) {
            return Result.ok();
        } else {
            return Result.fail();
        }
    }

}
```



### 1.2 服务接口

```java
package com.atguigu.system.service;

import com.atguigu.model.system.SysMenu;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 菜单表 服务类
 * </p>
 *
 * @author 陈江林
 * @since 2022-11-15
 */
public interface SysMenuService extends IService<SysMenu> {

    /**
     * 根据id删除菜单
     *
     * @param id id
     * @return boolean
     */
    boolean removeMenuById(Long id);

    /**
     * 菜单列表(树形)
     *
     * @return {@link List}<{@link SysMenu}>
     */
    List<SysMenu> getAll();
}
```



### 1.3 服务实现

```java
package com.atguigu.system.service.impl;

import com.atguigu.common.result.ResultCodeEnum;
import com.atguigu.model.system.SysMenu;
import com.atguigu.system.exception.GuiguException;
import com.atguigu.system.mapper.SysMenuMapper;
import com.atguigu.system.service.SysMenuService;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.baomidou.mybatisplus.extension.toolkit.SqlHelper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * <p>
 * 菜单表 服务实现类
 * </p>
 *
 * @author 陈江林
 * @since 2022-11-15
 */
@Service
public class SysMenuServiceImpl extends ServiceImpl<SysMenuMapper, SysMenu> implements SysMenuService {

    @Override
    public boolean removeMenuById(Long id) {
        // 如果有子菜单, 禁止删除
        if (0 < baseMapper.selectCount(new LambdaQueryWrapper<SysMenu>()
                .eq(SysMenu::getParentId, id))) {
            throw new GuiguException(ResultCodeEnum.FAIL.getCode(), "请先删除子菜单!");
        }

        // 删除该菜单
        return SqlHelper.retBool(baseMapper.deleteById(id));
    }

    @Override
    public List<SysMenu> getAll() {
        // 1. 查询所有
        List<SysMenu> sysMenuList = baseMapper.selectList(null);

        // 2. 封装子菜单
        sysMenuList.forEach(sysMenu -> {
            sysMenuList.forEach(sysMenuChildren -> {
                if (sysMenu.getId().equals(sysMenuChildren.getParentId())) {
                    // 如果为空, 初始化集合
                    if (sysMenu.getChildren() == null) {
                        sysMenu.setChildren(new ArrayList<>());
                    }

                    // 添加子菜单
                    sysMenu.getChildren().add(sysMenuChildren);
                }
            });
        });

        // 3. 返回一级菜单
        return sysMenuList
                .stream()
                .collect(Collectors.groupingBy(SysMenu::getParentId))
                .get(0L);
    }

}
```



## 2 前端

### 2.1 `API`

```javascript
import request from '@/utils/request'

const api_name = '/admin/system/sysMenu'

// 保存
export function save(data) {
  return request({
    url: `${api_name}/save`,
    method: 'post',
    data
  })
}

// 修改
export function update(data) {
  return request({
    url: `${api_name}/update`,
    method: 'put',
    data
  })
}

// 根据 id 获取信息
export function getById(id) {
  return request({
    url: `${api_name}/getById/${id}`,
    method: 'get'
  })
}

// 获取列表数据
export function getAll() {
  return request({
    url: `${api_name}/getAll`,
    method: 'get'
  })
}

// 根据 id 删除
export function removeById(id) {
  return request({
    url: `${api_name}/removeById/${id}`,
    method: 'delete'
  })
}
```



### 2.2 路由

```javascript
{
  path: 'sysMenu',
  name: 'SysMenu',
  component: () => import('@/views/system/sysMenu/list'),
  meta: { title: '菜单管理', icon: 'table' }
}
```



### 2.3 列表显示

![img](https://cdn.nlark.com/yuque/0/2022/png/12811585/1668581300434-1916e81f-7af6-4c7c-a783-fc1e44fac9af.png)

#### 2.3.1 示例-`Table`表格

```vue
<template>
<div>
  <el-table
    :data="tableData1"
    style="width: 100%"
    row-key="id"
    border
    :tree-props="{children: 'children'}">
    <el-table-column
      prop="date"
      label="日期"
      width="180">
    </el-table-column>
    <el-table-column
      prop="name"
      label="姓名"
      width="180">
    </el-table-column>
    <el-table-column
      prop="address"
      label="地址">
    </el-table-column>
  </el-table>
</div>
</template>
<script>
  export default {
    data() {
      return {
        tableData: [{
          id: 1,
          date: '2016-05-02',
          name: '王小虎',
          address: '上海市普陀区金沙江路 1518 弄'
        }, {
          id: 2,
          date: '2016-05-04',
          name: '王小虎',
          address: '上海市普陀区金沙江路 1517 弄'
        }, {
          id: 3,
          date: '2016-05-01',
          name: '王小虎',
          address: '上海市普陀区金沙江路 1519 弄',
          children: [{
              id: 31,
              date: '2016-05-01',
              name: '王小虎',
              address: '上海市普陀区金沙江路 1519 弄'
            }, {
              id: 32,
              date: '2016-05-01',
              name: '王小虎',
              address: '上海市普陀区金沙江路 1519 弄'
          }]
        }, {
          id: 4,
          date: '2016-05-03',
          name: '王小虎',
          address: '上海市普陀区金沙江路 1516 弄'
        }],
        tableData1: [{
          id: 1,
          date: '2016-05-02',
          name: '王小虎',
          address: '上海市普陀区金沙江路 1518 弄'
        }, {
          id: 2,
          date: '2016-05-04',
          name: '王小虎',
          address: '上海市普陀区金沙江路 1517 弄'
        }, {
          id: 3,
          date: '2016-05-01',
          name: '王小虎',
          address: '上海市普陀区金沙江路 1519 弄',
          hasChildren: true
        }, {
          id: 4,
          date: '2016-05-03',
          name: '王小虎',
          address: '上海市普陀区金沙江路 1516 弄'
        }]
      }
    },
    methods: {
      load(tree, treeNode, resolve) {
        setTimeout(() => {
          resolve([
            {
              id: 31,
              date: '2016-05-01',
              name: '王小虎',
              address: '上海市普陀区金沙江路 1519 弄'
            }, {
              id: 32,
              date: '2016-05-01',
              name: '王小虎',
              address: '上海市普陀区金沙江路 1519 弄'
            }
          ])
        }, 1000)
      }
    },
  }
</script>
```



#### 2.3.2 最终实现

```vue
<template>
  <div class="app-container">
    <!-- 卡片视图区域 -->
    <el-card>
      <el-row>
        <el-col>
          <el-button type="primary" @click="add()">添加菜单</el-button>
        </el-col>
      </el-row>

      <!-- 表格-懒加载 -->
      <el-table
        :data="list"
        style="width: 100%"
        row-key="id"
        border
        lazy
        :load="load"
        :tree-props="{children: 'children', hasChildren: 'hasChildren'}"
      >
        <el-table-column prop="name" label="菜单名称" width="160" />
        <el-table-column label="图标">
          <template slot-scope="scope">
            <i :class="scope.row.icon" />
          </template>
        </el-table-column>
        <el-table-column prop="perms" label="权限标识" width="160" />
        <el-table-column prop="path" label="路由地址" width="120" />
        <el-table-column prop="component" label="组件路径" width="160" />
        <el-table-column prop="sortValue" label="排序" width="60" />
        <el-table-column label="状态" width="80">
          <template slot-scope="scope">
            <el-switch
              :value="scope.row.status === 1"
              disabled
            />
          </template>
        </el-table-column>
        <el-table-column prop="createTime" label="创建时间" width="160" />
        <el-table-column label="操作" width="180" align="center" fixed="right">
          <template slot-scope="scope">
            <el-button v-if="scope.row.type !== 2" type="success" icon="el-icon-plus" size="mini" title="添加下级节点" @click="add(scope.row)" />
            <el-button type="primary" icon="el-icon-edit" size="mini" title="修改" @click="edit(scope.row)" />
            <el-button type="danger" icon="el-icon-delete" size="mini" title="删除" :disabled="scope.row.hasChildren" @click="removeDataById(scope.row.id)" />
          </template>
        </el-table-column>
      </el-table>
    </el-card>

  </div>
</template>

<script>
import { getChildMenu } from '@/api/system/menu'

export default {
  // 定义数据
  data() {
    return {
      list: [],
      iconList: [
        {
          class: 'el-icon-s-tools'
        },
        {
          class: 'el-icon-s-custom'
        },
        {
          class: 'el-icon-setting'
        },
        {
          class: 'el-icon-user-solid'
        },
        {
          class: 'el-icon-s-help'
        },
        {
          class: 'el-icon-phone'
        },
        {
          class: 'el-icon-s-unfold'
        },
        {
          class: 'el-icon-s-operation'
        },
        {
          class: 'el-icon-more-outline'
        },
        {
          class: 'el-icon-s-check'
        },
        {
          class: 'el-icon-tickets'
        },
        {
          class: 'el-icon-s-goods'
        },
        {
          class: 'el-icon-document-remove'
        },
        {
          class: 'el-icon-warning'
        },
        {
          class: 'el-icon-warning-outline'
        },
        {
          class: 'el-icon-question'
        },
        {
          class: 'el-icon-info'
        }
      ]
    }
  },

  // 当页面加载时获取数据
  created() {
    this.getList()
  },

  methods: {
    // 懒加载-获取子菜单
    load(tree, treeNode, resolve) {
      getChildMenu(tree.id).then(res => {
        resolve(res.data)
      })
    },

    // 调用api层获取数据库中的数据
    getList() {
      getChildMenu(0).then(res => {
        this.list = res.data
      })
    },

    // 根据id删除数据
    removeDataById(id) {
    },

    // 弹出添加或更新的表单
    add(row) {
    },

    // 编辑
    edit(row) {
    },

    // 添加或更新
    saveOrUpdate() {
    },

    // 添加
    save() {
    },

    // 更新
    update() {
    }
  }
}
</script>
```



### 2.4 添加/修改功能

![img](https://cdn.nlark.com/yuque/0/2022/png/12811585/1668605041279-0bf476f6-11c8-4608-b0c3-3cc752feaa7e.png)



#### 2.4.1 示例-`Dialog`对话框

```vue
<!-- Form -->
<el-button type="text" @click="dialogFormVisible = true">打开嵌套表单的 Dialog</el-button>

<el-dialog title="收货地址" :visible.sync="dialogFormVisible">
  <el-form :model="form">
    <el-form-item label="活动名称" :label-width="formLabelWidth">
      <el-input v-model="form.name" autocomplete="off"></el-input>
    </el-form-item>
    <el-form-item label="活动区域" :label-width="formLabelWidth">
      <el-select v-model="form.region" placeholder="请选择活动区域">
        <el-option label="区域一" value="shanghai"></el-option>
        <el-option label="区域二" value="beijing"></el-option>
      </el-select>
    </el-form-item>
  </el-form>
  <div slot="footer" class="dialog-footer">
    <el-button @click="dialogFormVisible = false">取 消</el-button>
    <el-button type="primary" @click="dialogFormVisible = false">确 定</el-button>
  </div>
</el-dialog>

<s
  
  cript>
  export default {
    data() {
      return {
        gridData: [{
          date: '2016-05-02',
          name: '王小虎',
          address: '上海市普陀区金沙江路 1518 弄'
        }, {
          date: '2016-05-04',
          name: '王小虎',
          address: '上海市普陀区金沙江路 1518 弄'
        }, {
          date: '2016-05-01',
          name: '王小虎',
          address: '上海市普陀区金沙江路 1518 弄'
        }, {
          date: '2016-05-03',
          name: '王小虎',
          address: '上海市普陀区金沙江路 1518 弄'
        }],
        dialogTableVisible: false,
        dialogFormVisible: false,
        form: {
          name: '',
          region: '',
          date1: '',
          date2: '',
          delivery: false,
          type: [],
          resource: '',
          desc: ''
        },
        formLabelWidth: '120px'
      };
    }
  };
</script>
```



#### 2.4.2 演化示例

```vue
    <!-- 添加/修改对话框 -->
    <!--
    {
      data() {
        return {
          /* 添加/修改对话框 */
          // 对话框标题
          dialogTitle: '',
          // 控制添加/修改对话框显示或隐藏(默认)
          addOrUpdateDialogFormVisible: false,
          // 表单对象
          sysMenu: {}
        }
      },
      methods: {
        // 关闭对话框
        saveOrUpdateDialogClose() {
           this.sysMenu = {}
        },
        // 打开保存对话框
        openSaveDialog() {
          // 对话框标题
          this.dialogTitle = '添加菜单'
          // 打开对话框
          this.addOrUpdateDialogFormVisible = true
        },
        // 打开修改对话框
        openUpdateDialog(id) {
          // 根据id获取对象
          getById(id).then(res => {
            // 保存表单数据
            this.sysMenu = res.data
            // 对话框标题
            this.dialogTitle = '修改菜单'
            // 打开对话框
            this.addOrUpdateDialogFormVisible = true
          })
        },
        // 保存或删除
        saveOrUpdate() {
          if (!this.sysMenu.id) {
            // 无id保存
            this.save()
          } else {
            // 有id修改
            this.update()
          }
        },
        // 调用API保存
        save() {
          save.then(res => {
            // 关闭对话框
            this.addOrUpdateDialogFormVisible = true
            // 提示
            this.$message.success('保存成功!')
          })
        },
        // 调用API修改
        update(id) {
          update.then(res => {
            // 关闭对话框
            this.addOrUpdateDialogFormVisible = true
            // 提示
            this.$message.success('修改成功!')
          })
        },

      }
    }
    -->
    <el-dialog
      :title="dialogTitle"
      :visible.sync="addOrUpdateDialogFormVisible"
      width="50%"
      @close="saveOrUpdateDialogClose"
    >
      <el-form ref="addOrUpdateForm" :model="sysMenu">
        <el-form-item v-if="sysMenu.id === ''" label="上级部门">
          <el-input v-model="sysMenu.parentName" disabled />
        </el-form-item>
        <el-form-item label="菜单类型" prop="type">
          <el-radio-group v-model="sysMenu.type" :disabled="typeDisabled">
            <el-radio :label="0" :disabled="type0Disabled">目录</el-radio>
            <el-radio :label="1" :disabled="type1Disabled">菜单</el-radio>
            <el-radio :label="2" :disabled="type2Disabled">按钮</el-radio>
          </el-radio-group>
        </el-form-item>
        <el-form-item label="菜单名称" prop="name">
          <el-input v-model="sysMenu.name" />
        </el-form-item>
        <el-form-item v-if="sysMenu.type !== 2" label="图标" prop="icon">
          <el-select v-model="sysMenu.icon" clearable>
            <el-option v-for="item in iconList" :key="item.class" :label="item.class" :value="item.class">
              <span style="float: left;">
                <i :class="item.class" />  <!-- 如果动态显示图标，这里添加判断 -->
              </span>
              <span style="padding-left: 6px;">{{ item.class }}</span>
            </el-option>
          </el-select>
        </el-form-item>
        <el-form-item label="排序">
          <el-input-number v-model="sysMenu.sortValue" controls-position="right" :min="0" />
        </el-form-item>
        <el-form-item v-if="sysMenu.type !== 2" prop="path">
          <span slot="label">
            <el-tooltip content="访问的路由地址，如：`sysUser`" placement="top">
              <i class="el-icon-question" />
            </el-tooltip>
            路由地址
          </span>
          <el-input v-model="sysMenu.path" placeholder="请输入路由地址" />
        </el-form-item>
        <el-form-item v-if="sysMenu.type !== 0 && sysMenu.type !== 2" prop="component">
          <span slot="label">
            <el-tooltip content="访问的组件路径，如：`system/user/index`，默认在`views`目录下" placement="top">
              <i class="el-icon-question" />
            </el-tooltip>
            组件路径
          </span>
          <el-input v-model="sysMenu.component" placeholder="请输入组件路径" />
        </el-form-item>
        <el-form-item v-if="sysMenu.type === 2">
          <el-input v-model="sysMenu.perms" placeholder="请输入权限标识" maxlength="100" />
          <span slot="label">
            <el-tooltip content="控制器中定义的权限字符，如：@PreAuthorize(hasAuthority('bnt.sysRole.list'))" placement="top">
              <i class="el-icon-question" />
            </el-tooltip>
            权限字符
          </span>
        </el-form-item>
        <el-form-item label="状态" prop="type">
          <el-radio-group v-model="sysMenu.status">
            <el-radio :label="1">正常</el-radio>
            <el-radio :label="0">停用</el-radio>
          </el-radio-group>
        </el-form-item>
      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button @click="addOrUpdateDialogFormVisible = false">取 消</el-button>
        <el-button type="primary" @click="saveOrUpdate()">确 定</el-button>
      </div>
    </el-dialog>
```



#### 2.4.3 最终代码

```vue
<template>
  <div class="app-container">
    <!-- 卡片视图区域 -->
    <el-card>
      <el-row>
        <el-col>
          <el-button type="primary" @click="openSaveDialog()">添加菜单</el-button>
        </el-col>
      </el-row>

      <!-- 表格-懒加载 -->
      <el-table
        :data="list"
        style="width: 100%"
        row-key="id"
        border
        :tree-props="{children: 'children'}"
      >
        <el-table-column prop="name" label="菜单名称" width="160" />
        <el-table-column label="图标">
          <template slot-scope="scope">
            <i :class="scope.row.icon" />
          </template>
        </el-table-column>
        <el-table-column prop="perms" label="权限标识" width="160" />
        <el-table-column prop="path" label="路由地址" width="120" />
        <el-table-column prop="component" label="组件路径" width="160" />
        <el-table-column prop="sortValue" label="排序" width="60" />
        <el-table-column label="状态" width="80">
          <template slot-scope="scope">
            <el-switch
              :value="scope.row.status === 1"
              disabled
            />
          </template>
        </el-table-column>
        <el-table-column prop="createTime" label="创建时间" width="160" />
        <el-table-column label="操作" width="180" align="center" fixed="right">
          <template slot-scope="scope">
            <el-button
              v-if="scope.row.type !== 2"
              type="success"
              icon="el-icon-plus"
              size="mini"
              title="添加下级节点"
              @click="openSaveDialog(scope.row)"
            />
            <el-button type="primary" icon="el-icon-edit" size="mini" title="修改" @click="openUpdateDialog(scope.row)" />
            <el-button
              type="danger"
              icon="el-icon-delete"
              size="mini"
              title="删除"
              :disabled="scope.row.hasChildren"
              @click="removeById(scope.row)"
            />
          </template>
        </el-table-column>
      </el-table>
    </el-card>

    <!-- 添加/修改对话框 -->
    <!--
    {
      data() {
        return {
          /* 添加/修改对话框 */
          // 对话框标题
          dialogTitle: '',
          // 控制添加/修改对话框显示或隐藏(默认)
          addOrUpdateDialogFormVisible: false,
          // 表单对象
          sysMenu: {}
        }
      },
      methods: {
        // 关闭对话框
        saveOrUpdateDialogClose() {
           this.sysMenu = {}
        },
        // 打开保存对话框
        openSaveDialog() {
          // 对话框标题
          this.dialogTitle = '添加菜单'
          // 打开对话框
          this.addOrUpdateDialogFormVisible = true
        },
        // 打开修改对话框
        openUpdateDialog(id) {
          // 根据id获取对象
          getById(id).then(res => {
            // 保存表单数据
            this.sysMenu = res.data
            // 对话框标题
            this.dialogTitle = '修改菜单'
            // 打开对话框
            this.addOrUpdateDialogFormVisible = true
          })
        },
        // 保存或删除
        saveOrUpdate() {
          if (!this.sysMenu.id) {
            // 无id保存
            this.save()
          } else {
            // 有id修改
            this.update()
          }
        },
        // 调用API保存
        save() {
          save.then(res => {
            // 关闭对话框
            this.addOrUpdateDialogFormVisible = true
            // 提示
            this.$message.success('保存成功!')
          })
        },
        // 调用API修改
        update(id) {
          update.then(res => {
            // 关闭对话框
            this.addOrUpdateDialogFormVisible = true
            // 提示
            this.$message.success('修改成功!')
          })
        },

      }
    }
    -->
    <el-dialog
      :title="dialogTitle"
      :visible.sync="addOrUpdateDialogFormVisible"
      width="50%"
      @close="saveOrUpdateDialogClose"
    >
      <el-form ref="addOrUpdateForm" :model="sysMenu">
        <el-form-item v-if="sysMenu.id === ''" label="上级部门">
          <el-input v-model="sysMenu.parentName" disabled />
        </el-form-item>
        <el-form-item label="菜单类型" prop="type">
          <el-radio-group v-model="sysMenu.type" :disabled="typeDisabled">
            <el-radio :label="0" :disabled="type0Disabled">目录</el-radio>
            <el-radio :label="1" :disabled="type1Disabled">菜单</el-radio>
            <el-radio :label="2" :disabled="type2Disabled">按钮</el-radio>
          </el-radio-group>
        </el-form-item>
        <el-form-item label="菜单名称" prop="name">
          <el-input v-model="sysMenu.name" />
        </el-form-item>
        <el-form-item v-if="sysMenu.type !== 2" label="图标" prop="icon">
          <el-select v-model="sysMenu.icon" clearable>
            <el-option v-for="item in iconList" :key="item.class" :label="item.class" :value="item.class">
              <span style="float: left;">
                <i :class="item.class" />  <!-- 如果动态显示图标，这里添加判断 -->
              </span>
              <span style="padding-left: 6px;">{{ item.class }}</span>
            </el-option>
          </el-select>
        </el-form-item>
        <el-form-item label="排序">
          <el-input-number v-model="sysMenu.sortValue" controls-position="right" :min="0" />
        </el-form-item>
        <el-form-item v-if="sysMenu.type !== 2" prop="path">
          <span slot="label">
            <el-tooltip content="访问的路由地址，如：`sysUser`" placement="top">
              <i class="el-icon-question" />
            </el-tooltip>
            路由地址
          </span>
          <el-input v-model="sysMenu.path" placeholder="请输入路由地址" />
        </el-form-item>
        <el-form-item v-if="sysMenu.type !== 0 && sysMenu.type !== 2" prop="component">
          <span slot="label">
            <el-tooltip content="访问的组件路径，如：`system/user/index`，默认在`views`目录下" placement="top">
              <i class="el-icon-question" />
            </el-tooltip>
            组件路径
          </span>
          <el-input v-model="sysMenu.component" placeholder="请输入组件路径" />
        </el-form-item>
        <el-form-item v-if="sysMenu.type === 2">
          <el-input v-model="sysMenu.perms" placeholder="请输入权限标识" maxlength="100" />
          <span slot="label">
            <el-tooltip content="控制器中定义的权限字符，如：@PreAuthorize(hasAuthority('bnt.sysRole.list'))" placement="top">
              <i class="el-icon-question" />
            </el-tooltip>
            权限字符
          </span>
        </el-form-item>
        <el-form-item label="状态" prop="type">
          <el-radio-group v-model="sysMenu.status">
            <el-radio :label="1">正常</el-radio>
            <el-radio :label="0">停用</el-radio>
          </el-radio-group>
        </el-form-item>
      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button @click="addOrUpdateDialogFormVisible = false">取 消</el-button>
        <el-button type="primary" @click="saveOrUpdate()">确 定</el-button>
      </div>
    </el-dialog>
  </div>
</template>

<script>
import { save, update, getById, getAll, removeById } from '@/api/system/menu'

export default {
  // 定义数据
  data() {
    return {
      list: [],
      iconList: [
        {
          class: 'el-icon-s-tools'
        },
        {
          class: 'el-icon-s-custom'
        },
        {
          class: 'el-icon-setting'
        },
        {
          class: 'el-icon-user-solid'
        },
        {
          class: 'el-icon-s-help'
        },
        {
          class: 'el-icon-phone'
        },
        {
          class: 'el-icon-s-unfold'
        },
        {
          class: 'el-icon-s-operation'
        },
        {
          class: 'el-icon-more-outline'
        },
        {
          class: 'el-icon-s-check'
        },
        {
          class: 'el-icon-tickets'
        },
        {
          class: 'el-icon-s-goods'
        },
        {
          class: 'el-icon-document-remove'
        },
        {
          class: 'el-icon-warning'
        },
        {
          class: 'el-icon-warning-outline'
        },
        {
          class: 'el-icon-question'
        },
        {
          class: 'el-icon-info'
        }
      ],

      /* 添加/修改对话框 */
      typeDisabled: false,
      type0Disabled: false,
      type1Disabled: false,
      type2Disabled: false,
      // 对话框标题
      dialogTitle: '',
      // 控制添加/修改对话框显示或隐藏(默认)
      addOrUpdateDialogFormVisible: false,
      // 表单对象
      sysMenu: {
        id: '',
        parentId: '',
        name: '',
        type: 0,
        path: '',
        component: '',
        perms: '',
        icon: '',
        sortValue: 1,
        status: 1
      }
    }
  },

  // 当页面加载时获取数据
  created() {
    this.getList()
  },

  methods: {
    // 调用api层获取数据库中的数据
    getList() {
      getAll().then(res => {
        this.list = res.data
      })
    },

    /* ========= start - 添加/修改对话框 ========= */
    // 关闭对话框
    saveOrUpdateDialogClose() {
      this.sysMenu = {
        id: '',
        parentId: '',
        name: '',
        type: 0,
        path: '',
        component: '',
        perms: '',
        icon: '',
        sortValue: 1,
        status: 1
      }
    },
    // 打开保存对话框
    openSaveDialog(row) {
      console.log(this.sysMenu.id === '')
      if (row) {
        this.sysMenu.parentId = row.id
        this.sysMenu.parentName = row.name
        // 对话框标题
        this.dialogTitle = '添加子菜单'
        if (row.type === 0) {
          this.sysMenu.type = 1
          this.typeDisabled = false
          this.type0Disabled = false
          this.type1Disabled = false
          this.type2Disabled = true
        } else if (row.type === 1) {
          this.sysMenu.type = 2
          this.typeDisabled = true
        }
      } else {
        // 对话框标题
        this.dialogTitle = '添加目录节点'
        this.sysMenu.type = 0
        this.sysMenu.component = 'Layout'
        this.sysMenu.parentId = 0
        this.typeDisabled = true
      }

      // 打开对话框
      this.addOrUpdateDialogFormVisible = true
    },
    // 打开修改对话框
    openUpdateDialog(row) {
      // 根据id获取对象
      getById(row.id).then(res => {
        // 保存表单数据
        this.sysMenu = res.data
        // 对话框标题
        this.dialogTitle = '修改菜单'
        // 打开对话框
        this.addOrUpdateDialogFormVisible = true
      })
    },
    // 保存或删除
    saveOrUpdate() {
      // 校验表单
      this.$refs.addOrUpdateForm.validate(valid => {
        if (valid) {
          if (!this.sysMenu.id) {
            // 无id保存
            this.save()
          } else {
            // 有id修改
            this.update()
          }
        }
      })
    },
    // 调用API保存
    save() {
      save(this.sysMenu).then(res => {
        // 关闭对话框
        this.addOrUpdateDialogFormVisible = false
        // 提示
        this.$message.success('保存成功')
        // 刷新数据
        this.getList()
      })
    },
    // 调用API修改
    update() {
      update(this.sysMenu).then(res => {
        // 关闭对话框
        this.addOrUpdateDialogFormVisible = false
        // 提示
        this.$message.success('修改成功')
        // 刷新数据
        this.getList()
      })
    },
    /* ========= end - 添加/修改对话框 ========= */

    // 根据id删除数据
    removeById(row) {
      // 弹框询问用户是否删除数据
      this.$confirm('此操作将永久删除该数据, 是否继续?', '提示', {
        confirmButtonText: '确定',
        cancelButtonText: '取消',
        type: 'warning'
      }).then(() => {
        removeById(row.id).then(res => {
          // 提示
          this.$message.success('删除成功!')
          // 刷新数据
          this.getList()
        })
      }).catch(() => {
        this.$message({
          type: 'info',
          message: '已取消删除'
        })
      })
    }
  }
}
</script>
```


# 五 给角色分配权限(菜单)

```
git checkout -b 5.0.0_role_menu
```



## 1 后端

### 1.1 控制层`SysMenuController`

```java
   @ApiOperation("根据角色id获取菜单")
    @GetMapping("/getMenuListByRoleId/{roleId}")
    public Result<List<SysMenu>> getMenuListByRoleId(
            @PathVariable Long roleId
    ) {
        return Result.ok(sysMenuService.getMenuListByRoleId(roleId));
    }

    @ApiOperation("给角色分配菜单权限")
    @PostMapping("/saveRoleMenu")
    public Result<List<SysMenu>> saveRoleMenu(
            @RequestBody AssginMenuVo assginMenuVo
    ) {
        sysMenuService.saveRoleMenu(assginMenuVo);
        return Result.ok();
    }
```

### 1.2 服务接口

```java
  /**
     * 根据角色id获取菜单
     *
     * @param roleId 角色id
     * @return {@link List}<{@link SysMenu}>
     */
    List<SysMenu> getMenuListByRoleId(Long roleId);

    /**
     * 给角色分配菜单权限
     *
     * @param assginMenuVo
     */
    void saveRoleMenu(AssginMenuVo assginMenuVo);
```

### 1.3 服务实现

```java
   @Override
    public void saveRoleMenu(AssginMenuVo assginMenuVo) {
        if (assginMenuVo == null) {
            throw new GuiguException(ResultCodeEnum.SUCCESS.getCode(), "参数不能为空!");
        }

        if (assginMenuVo.getRoleId() == null
                || assginMenuVo.getMenuIdList() == null) {
            throw new GuiguException(ResultCodeEnum.SUCCESS.getCode(), "角色id或菜单不能为空!");
        }

        // 获取角色id
        Long roleId = assginMenuVo.getRoleId();

        /* 先删除再添加 */
        // 根据角色id删除菜单权限
        sysRoleMenuMapper.delete(
                new LambdaQueryWrapper<SysRoleMenu>()
                        .eq(SysRoleMenu::getRoleId, assginMenuVo.getRoleId())
        );

        // 添加菜单
        assginMenuVo.getMenuIdList()
                .forEach(menuId -> {
                    // 创建角色菜单中间表实体对象
                    SysRoleMenu sysRoleMenu = new SysRoleMenu();
                    sysRoleMenu.setMenuId(menuId);
                    sysRoleMenu.setRoleId(roleId);
                    // 添加
                    sysRoleMenuMapper.insert(sysRoleMenu);
                });
    }

    @Override
    public List<SysMenu> getMenuListByRoleId(Long roleId) {
        // 根据角色id查询已经分配的菜单id
        List<Long> menuIdList = sysRoleMenuMapper.selectList(
                new LambdaQueryWrapper<SysRoleMenu>()
                        .eq(SysRoleMenu::getRoleId, roleId)
        )
                .stream()
                .map(SysRoleMenu::getMenuId)
                .collect(Collectors.toList());

        return MenuHelper.buildTree(
                baseMapper.selectList(
                        // 获取所有可用菜单 status=1
                        new LambdaQueryWrapper<SysMenu>()
                                .eq(SysMenu::getStatus, 1)
                )
                        .stream()
                        .peek(sysMenu -> {
                            if (menuIdList.contains(sysMenu.getId())) {
                                sysMenu.setSelect(true);
                            }
                        })
                        .collect(Collectors.toList())
        )
                .stream()
                .collect(Collectors.groupingBy(SysMenu::getParentId))
                .get(0L);
    }
```

### 1.4 新建`SysRoleMenuMapper`接口

```java
package com.atguigu.system.mapper;

import com.atguigu.model.system.SysRoleMenu;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * 角色和菜单中间表 Mapper 接口
 *
 * @author 陈江林
 * @date 2022/11/16 21:54
 */
public interface SysRoleMenuMapper extends BaseMapper<SysRoleMenu> {
}
```



### 1.5 视图类`AssginMenuVo`

```java
package com.atguigu.model.vo;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

@ApiModel(description = "分配菜单")
@Data
public class AssginMenuVo {

    @ApiModelProperty(value = "角色id")
    private Long roleId;

    @ApiModelProperty(value = "菜单id列表")
    private List<Long> menuIdList;

}
```



### 1.6 实体类`SysRoleMenu`

```java
package com.atguigu.model.system;

import com.atguigu.model.base.BaseEntity;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(description = "角色菜单")
@TableName("sys_role_menu")
public class SysRoleMenu extends BaseEntity {
	
	private static final long serialVersionUID = 1L;

	@ApiModelProperty(value = "角色id")
	@TableField("role_id")
	private Long roleId;

	@ApiModelProperty(value = "菜单id")
	@TableField("menu_id")
	private Long menuId;

}
```



## 2 前端

### 2.1 路由

```javascript
      {
        path: 'sysMenu',
        name: 'SysMenu',
        component: () => import('@/views/system/sysMenu/list'),
        meta: { title: '菜单管理', icon: 'table' }
      }
```



### 2.2 `API`

```javascript
import request from '@/utils/request'

const api_name = '/admin/system/sysMenu'

// 角色菜单保存-分配权限
export function saveRoleMenu(data) {
  return request({
    url: `${api_name}/saveRoleMenu`,
    method: 'post',
    data
  })
}

// 根据角色id获取菜单
export function getMenuListByRoleId(roleId) {
  return request({
    url: `${api_name}/getMenuListByRoleId/${roleId}`,
    method: 'get'
  })
}
```



### 2.3 角色管理-分配权限

```vue
<template>
  <div>
    <!-- 卡片视图区域 -->
    <el-card>
      <el-row :gutter="20">
        <el-col :span="8">
          <el-input
            v-model="searchObj.roleName"
            placeholder="请输入角色名称"
            class="input-with-select"
            clearable
            @clear="getList"
          >
            <el-button slot="append" icon="el-icon-search" @click="getList" />
          </el-input>
        </el-col>
        <el-col :span="6">
          <el-button type="primary" @click="showAddDialogVisible()">添加角色</el-button>
          <el-button type="danger" @click="removeRoles()">批量删除</el-button>
        </el-col>
      </el-row>

      <!-- table 表格区域 -->
      <el-table
        :data="list"
        border
        stripe
        @selection-change="handleSelectionChange"
      >
        <!-- 索引列 -->
        <el-table-column type="selection" />
        <el-table-column prop="roleName" label="角色名称" />
        <el-table-column prop="roleCode" label="角色编码" />
        <el-table-column prop="createTime" label="创建时间" />
        <!-- 操作 -->
        <el-table-column label="操作" width="300px">
          <template slot-scope="scope">
            <!-- 修改 -->
            <el-button size="mini" type="primary" icon="el-icon-edit" @click="showEditDialogVisible(scope.row.id)">
              编辑
            </el-button>
            <!-- 删除 -->
            <el-button size="mini" type="danger" icon="el-icon-delete" @click="removeDataById(scope.row.id)">
              删除
            </el-button>
            <!-- 分配权限 -->
            <el-tooltip effect="dark" content="分配权限" placement="top-start" :enterable="false">
              <el-button type="warning" icon="el-icon-setting" size="mini" @click="openAssignDialog(scope.row.id)">
                分配权限
              </el-button>
            </el-tooltip>
          </template>
        </el-table-column>
      </el-table>

      <!-- 分页区域 -->
      <el-pagination
        :current-page="page"
        :page-sizes="[5, 10, 15, 20]"
        :page-size="limit"
        layout="total, sizes, prev, pager, next, jumper"
        :total="total"
        background
        @size-change="handleSizeChange"
        @current-change="handleCurrentChange"
      />
    </el-card>

    <!-- 添加/修改 对话框 -->
    <el-dialog
      :title="saveOrUpdateTitle"
      :visible.sync="saveOrUpdateDialogVisible"
      width="50%"
      @close="saveOrUpdateDialogClose"
    >
      <!-- 内容主体区域 -->
      <el-form ref="saveOrUpdateFormRef" :model="saveOrUpdateForm" :rules="saveOrUpdateFormRules" label-width="80px">
        <el-form-item label="角色名称" prop="roleName">
          <el-input v-model="saveOrUpdateForm.roleName" />
        </el-form-item>
        <el-form-item label="角色代码" prop="roleCode">
          <el-input v-model="saveOrUpdateForm.roleCode" />
        </el-form-item>
      </el-form>
      <!-- 底部区域 -->
      <span slot="footer" class="dialog-footer">
        <el-button @click="saveOrUpdateDialogVisible = false">取 消</el-button>
        <el-button type="primary" @click="saveOrUpdate">确 定</el-button>
      </span>
    </el-dialog>

    <el-dialog
      title="分配权限"
      :visible.sync="assignDialogVisible"
      width="50%"
      @close="assignDialogClose"
    >
      <el-tree
        ref="tree"
        :data="menuList"
        show-checkbox
        node-key="id"
        default-expand-all
        :default-checked-keys="defKeys"
        :props="defaultProps"
      />
      <!-- 底部区域 -->
      <span slot="footer" class="dialog-footer">
        <el-button @click="assignDialogVisible = false">取 消</el-button>
        <el-button type="primary" @click="saveRoleMenu">确 定</el-button>
      </span>
    </el-dialog>
  </div>
</template>

<script>
import { getPageList, removeById, getRoleById, update, save, batchRemove } from '@/api/system/role'
import { saveRoleMenu, getMenuListByRoleId } from '@/api/system/menu'

export default {
  name: 'List',
  data() {
    return {
      /* 分配权限 */
      // 控制对话框隐藏或显示
      assignDialogVisible: false,
      // 打开分配权限对话框时 存储角色id
      roleId: '',
      // 角色拥有的菜单id
      defKeys: [],
      // 树形菜单
      menuList: {},
      defaultProps: {
        children: 'children',
        label: 'name'
      },

      // 角色列表
      list: [],
      // 总记录数
      total: 0,
      // 当前页
      page: 1,
      // 每页显示记录数
      limit: 10,
      // 条件查询封装对象
      searchObj: {},
      // - 批量删除
      // 选中的数据
      multipleSelection: [],
      // - 添加或修改
      // 控制对话框的显示与隐藏
      saveOrUpdateDialogVisible: false,
      // 标题
      saveOrUpdateTitle: '',
      // 表单数据
      saveOrUpdateForm: {
        roleName: '',
        roleCode: ''
      },
      // 表单规则
      saveOrUpdateFormRules: {
        roleName: [
          {
            required: true,
            message: '请输入用户名称',
            trigger: 'blur'
          }
        ],
        roleCode: [
          {
            required: true,
            message: '请输入用户代码',
            trigger: 'blur'
          }
        ]
      }
    }
  },
  created() {
    this.getList()
  },
  methods: {
    /* 分配权限 */
    // 打开对话框
    openAssignDialog(id) {
      this.roleId = id
      // 获取角色拥有的菜单
      getMenuListByRoleId(id).then(res => {
        this.menuList = res.data
        if (this.menuList && this.menuList.length > 0) {
          this.menuList.forEach(menu => {
            // 设置选中菜单
            this.getLeafKeys(menu)
          })
        }

        // 显示对话框
        this.assignDialogVisible = true
      })
    },
    // 通过递归的形式, 获取角色下所有三级权限的 Id, 并保存到 defKeys 数组中
    getLeafKeys(node) {
      // 如果当前 node 节点不包含 children 属性, 则是三级节点或最后节点
      // 而且 select=true , 则是该角色拥有的权限
      if (!node.children && node.select) {
        return this.defKeys.push(node.id)
      }

      node.children && node.children.forEach(item => {
        this.getLeafKeys(item)
      })
    },
    // 关闭分配权限对话框
    assignDialogClose() {
      this.defKeys = []
      this.menuList = []
      this.roleId = ''
    },
    // 分配菜单
    saveRoleMenu() {
      // 获取到当前子节点及父节点
      const allCheckedNodes = this.$refs.tree.getCheckedNodes(false, true)
      const idList = allCheckedNodes.map(node => node.id)
      const assginMenuVo = {
        roleId: this.roleId,
        menuIdList: idList
      }

      saveRoleMenu(assginMenuVo).then(res => {
        // 关闭对话框
        this.assignDialogVisible = false
        this.$message.success('分配权限成功')
      })
    },

    // 获取列表数据
    getList() {
      getPageList(this.page, this.limit, this.searchObj).then(res => {
        this.list = res.data.records
        this.total = res.data.total
      })
    },
    handleSizeChange(newSize) {
      this.limit = newSize
      this.getList()
    },
    handleCurrentChange(newPage) {
      this.page = newPage
      this.getList()
    },
    // 保存或修改角色
    saveOrUpdate() {
      // 判断 id 是否存在 {true: 修改角色, false: 保存角色}
      if (!this.saveOrUpdateForm.id) {
        this.saveRole()
      } else {
        this.updateRole()
      }
    },
    saveRole() {
      // 表单验证
      this.$refs.saveOrUpdateFormRef.validate(valid => {
        if (!valid) return

        save(this.saveOrUpdateForm).then(res => {
          this.$message.success('保存角色成功!')
          // 关闭弹框
          this.saveOrUpdateDialogVisible = false
          // 刷新数据
          this.getList()
        })
      })
    },
    updateRole() {
      // 表单验证
      this.$refs.saveOrUpdateFormRef.validate(valid => {
        if (!valid) return
        update(this.saveOrUpdateForm).then(res => {
          this.$message.success('修改角色成功!')
          // 关闭弹框
          this.saveOrUpdateDialogVisible = false
          // 刷新数据
          this.getList()
        })
      })
    },
    showEditDialogVisible(id) {
      getRoleById(id).then(res => {
        // 修改角色对应数据
        this.saveOrUpdateForm = res.data
        // 弹框标题
        this.saveOrUpdateTitle = '修改角色'
        // 显示弹框
        this.saveOrUpdateDialogVisible = true
      })
    },
    showAddDialogVisible() {
      // 弹框标题
      this.saveOrUpdateTitle = '添加角色'
      // 显示弹框
      this.saveOrUpdateDialogVisible = true
    },
    // 重置表单
    saveOrUpdateDialogClose() {
      // 清空表单数据
      this.saveOrUpdateForm = {}
    },
    removeDataById(id) {
      // 弹框询问用户是否删除数据
      this.$confirm('此操作将永久删除该角色, 是否继续?', '提示', {
        confirmButtonText: '确定',
        cancelButtonText: '取消',
        type: 'warning'
      }).then(() => {
        removeById(id).then(res => {
          this.$message.success('删除成功!')
          // 刷新数据
          this.getList()
        })
      }).catch(() => {
        this.$message({
          type: 'info',
          message: '已取消删除'
        })
      })
    },
    handleSelectionChange(val) {
      this.multipleSelection = val
    },
    removeRoles() {
      if (this.multipleSelection.length === 0) {
        this.$message.warning('请选择要删除的角色!')
        return
      }

      // 弹框询问用户是否删除数据
      this.$confirm('此操作将永久删除这些角色, 是否继续?', '提示', {
        confirmButtonText: '确定',
        cancelButtonText: '取消',
        type: 'warning'
      }).then(() => {
        const ids = []
        // 循环选中的角色信息, 取出 id 值
        this.multipleSelection.forEach(item => {
          // 精度问题: js 的数值存储为 2的53次方, 数据库ID是19位数值, 所以需要处理
          ids.push(item.id + '')
        })
        // 请求批量删除
        batchRemove(ids).then(res => {
          this.$message.success('批量删除成功!')
          // 刷新数据
          this.getList()
        })
      }).catch(() => {
        this.$message({
          type: 'info',
          message: '已取消删除'
        })
      })
    }
  }
}
</script>

<style scoped>

</style>
```


# 六 权限管理

```
git checkout -b 6.0.0_jwt
```



## 1 权限管理介绍

- 每个系统的权限功能都不尽相同, 各有其自身的业务特点, 对权限管理的设计也都各有特色。不过不管是怎样的权限设计, 大致可归为三种

    -  页面权限（菜单级）
    - 操作权限（按钮级）
    - 数据权限

- 当前系统是菜单、按钮权限的控制

### 1.1 菜单权限

- 菜单权限就是对页面的控制, 就是有这个权限的用户才能访问这个页面, 没这个权限的用户就无法访问, 它是以整个页面为维度, 对权限的控制并没有那么细致, 所以是一种**粗颗粒权限**



### 1.2 按钮权限

- 按钮权限就是将页面的**操作**视为资源, 比如删除操作, 有些人可以操作有些人不能操作。对后端来说, 操作就是一个接口。对前端来说, 操作往往是一个按钮, 是一种**细颗粒权限**



### 1.3 权限管理设计思路

- 前面写了用户管理、角色管理及菜单管理, 我们把菜单权限分配给了角色, 把角色分配给用户, 那么用户就拥有了角色的所有权限（权限包含：菜单权限与按钮权限）
- 接下来实现:

    -  用户登录
    - 登录成功根据`token`获取用户相关信息（菜单权限及按钮权限）

- 用户登录需要用到`JWT`，接下来讲解`JWT`



## 2 `JWT`

### 2.1 `JWT`介绍

- `JWT`是`JSON Web Token`的缩写，及`JSON Web`令牌，是一种自包含令牌。是为了在网络应用环境间传递声明而执行的一种基于`JSON`的开发标准
- `JWT`是声明一般被用来在**身份提供者**和**服务提供者**间传递被认证的用户信息，以便于从资源服务器获取资源

`ps`：用在用户登录上

- `JWT`最重要的作用就是对`token`信息的防伪作用

### 2.2 `JWT`令牌的组成

- 一个`JWT`用三个部分组成

1. `JWT`头
2. 有效载荷
3. 签名哈希

- 最后由这三者进行`base64url`编码得到`JWT`
- 典型的，一个`JWT`看起来如下图：该对象为一个很长的字符串，字符之间通过`"."`分隔符分为三个字符串`https://jwt.io`

![img](https://cdn.nlark.com/yuque/0/2022/png/12811585/1668799506306-267fcb39-d63a-47bc-9192-5f5c8a290d4d.png)



#### 2.2.1 `JWT`头

- `JWT`头部分是一个描述`JWT`元数据的`JSON`对象，通常如下所示

```json
{
  "alg": "HS256",
  "typ": "JWT"
}
```

- `alg`属性表示签名使用的算法，默认为`HMAC SHA256（写为256）`
- `typ`属性表示令牌的类型，`JWT`令牌统一写为`JWT`
- 最后使用`Base64 URL`算法将上述`JSON`对象转换为字符串保存



#### 2.2.2 有效载荷

- 有效载荷部分，是`JWT`的主体内容部分，也是一个`JSON`对象，包含需要传递的数据。`JWT`指定七个默认字段选择

| **字段** | **声明**                                                     |
| -------- | ------------------------------------------------------------ |
| `iss`    | `jwt`签发者                                                  |
| `sub`    | 主题                                                         |
| `aud`    | 接收`jwt`的一方                                              |
| `exp`    | `jwt`的过期时间，这个过期时间必须要大于签发时间              |
| `nbf`    | 定义在什么时间之前，该`jwt`都是不可用的                      |
| `iat`    | `jwt`的签发时间                                              |
| `jti`    | `jwt`的唯一身份标识，主要用来作为一次性`token`，从而回避重放攻击 |

除以上默认字段外，我们还可以自定义私有字段，如下例：

```json
{
  "name": "Helen",
  "role": "editor",
  "avatar": "helen.jpg"
}
```

- 请注意，默认情况下`JWT`是未加密的，任何人都可以解读其内容，因此不要构建隐私信息字段，存放保密信息，以防止信息泄露
- `JSON`对象也使用`Base64 URL`算法转换为字符串保存



#### 2.2.3 签名哈希

- 签名哈希部分是对上面部分数据签名，通过指定的算法生成哈希，以确保数据不会被篡改

    -  首先，需要指定一个密码（`secret`）。该密码仅仅为保存在服务器中，并且不能向用户公开
    - 然后，使用标头中指定的签名算法（默认情况下为`HMAC SHA256`）根据以下公式生成签名

```latex
HMACSHA256(base64UrlEncode(header) + "." + base64UrlEncode(claims), secret)

==> 签名hash
```

- 在计算出签名哈希后，`JWT`头，有效载荷和签名哈希的三个部分组合成一个字符串，每个部分用`"."`分隔，就构成整个`JWT`对象



#### 2.2.4 `Base64URL`算法

- 如前所述，`JWT`头和有效载荷列化的算法都用到了`Base64URL`。该算法和常见`Base64`算法类似，稍有差别。
- 作为令牌的`JWT`可以放在`URL`中（例如`api.example/?token=xxx`）。`Base64`中用到的三个字符是`"+"，"/"和"="`，由于在`URL`中有特殊含义，因此`Base64URL`中对他们做了替换:

    -  `=` 去掉
    - `+`用`-`替换
    - `/`用`_`替换

- 这就是`Base64URL`算法



## 3 登录保存用户状态（用户`id`，用户昵称）

### 3.2 方案一：使用`session`

- `session`无法实现共享, 适用与**单一架构**

### 3.2 方案二：使用`token`<我们使用`token`>

- `token`按照约定规则生成一个字符串，字符串进行编码加密处理

#### 3.2.1 `token`如何共享

- 每次登录，登录成功之后，返回生成`token`字符串
- 前端把返回的`token`放到`cookie`里面（`cookie`不能跨域传递）
- 每次发生请求携带这个`token`发送（把`token`值放到**请求头**中传递）



## 4 操作-项目集成`JWT`

操作模块：`common-util`

### 4.1 依赖

```xml
<!-- 集成 JWT -->
<dependency>
    <groupId>io.jsonwebtoken</groupId>
    <artifactId>jjwt</artifactId>
</dependency>
```



### 4.2 新建`JWT`帮助类

```java
package com.atguigu.common.utils;

import io.jsonwebtoken.*;

import java.util.Date;
import java.util.HashMap;

/**
 * 生成JSON Web令牌的工具类
 *
 * @author 陈江林
 * @date 2022/11/20 18:59
 */
public class JwtHelper {

    /**
     * 令牌过期时间
     * 过期时间是3600秒，既是1个小时
     */
    private static final long EXPIRATION = 3600L;

    /**
     * 令牌秘钥
     */
    private static final String SECRET = "jwtsecretdemo";

    /**
     * 创建 token, 存储用户id和用户名称
     *
     * @param userId   用户id
     * @param username 用户名
     * @return {@link String}
     */
    public static String createToken(Long userId, String username) {
        HashMap<String, Object> map = new HashMap<>();
        map.put("userId", userId);
        map.put("username", username);

        return Jwts.builder()
                .setSubject("AUTH-USER")
                // 先调用setClaims， 在调用setExpiration
                .setClaims(map)
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRATION * 1000))
                .signWith(SignatureAlgorithm.HS512, SECRET)
                // 压缩字符串, 变成一行
                .compressWith(CompressionCodecs.GZIP)
                .compact();
    }

    /**
     * 得到用户id
     *
     * @param token 令牌
     * @return {@link Long}
     */
    public static Long getUserId(String token) {
        return Long.valueOf(getTokenBody(token).get("userId").toString());
    }

    /**
     * 获得用户名
     *
     * @param token 令牌
     * @return {@link String}
     */
    public static String getUsername(String token) {
        return String.valueOf(getTokenBody(token).get("username"));
    }

    /**
     * 是否已过期
     *
     * @param token 令牌
     * @return boolean
     */
    public static boolean isExpiration(String token) {
        try {
            return getTokenBody(token).getExpiration().before(new Date());
        } catch (ExpiredJwtException e) {
            return true;
        }
    }

    private static Claims getTokenBody(String token) {
        return Jwts.parser()
                .setSigningKey(SECRET)
                .parseClaimsJws(token)
                .getBody();
    }

    public static void removeToken(String token) {
        // jwt token无需删除，客户端扔掉即可。
    }

    public static void main(String[] args) {
        String token = JwtHelper.createToken(1592868656222597121L, "admin");
        System.out.println(token);
        System.out.println(JwtHelper.getUserId(token));
        System.out.println(JwtHelper.getUsername(token));
    }
}
```



## 5 用户登录

### 5.1 控制类

```java
package com.atguigu.system.controller;

import com.atguigu.common.result.Result;
import com.atguigu.common.result.ResultCodeEnum;
import com.atguigu.common.utils.JwtHelper;
import com.atguigu.model.system.SysUser;
import com.atguigu.model.vo.LoginVo;
import com.atguigu.system.exception.GuiguException;
import com.atguigu.system.service.SysUserService;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * @author 陈江林
 * @date 2022/11/12 20:03
 */
@Api(tags = "用户登录退出")
@RestController
@RequestMapping("/admin/system/index")
public class IndexController {

    @Autowired
    private SysUserService sysUserService;

    @ApiOperation("用户登录")
    @PostMapping("/login")
    public Result<Map<String, Object>> login(
            @RequestBody LoginVo loginVo
    ) {
        // 根据 username 查询数据
        SysUser sysUser = sysUserService.getOne(
                new LambdaQueryWrapper<SysUser>()
                        .eq(SysUser::getUsername, loginVo.getUsername())
        );

        // 非空判断
        if (sysUser == null) {
            throw new GuiguException(201, "用户不存在!");
        }

        // 判断密码是否一致 TODO 使用 spring security
        String password = loginVo.getPassword();

        // 判断用户是否可用
        if (sysUser.getStatus() == 0) {
            throw new GuiguException(201, "用户已经被禁用!");
        }

        // 根据用户id和用户名称生成 token 字符串，使用 map 返回
        String token = JwtHelper.createToken(sysUser.getId(), sysUser.getUsername());
        Map<String, Object> map = new HashMap<>();
        map.put("token", token);
        return Result.ok(map);
    }

    @ApiOperation("获取用户信息")
    @GetMapping("/info")
    public Result<Map<String, Object>> info(HttpServletRequest request) {
        // 从请求头中获取 token 字符串
        String token = request.getHeader("token");
        // 非空判断
        if (StringUtils.isEmpty(token)) {
            throw new GuiguException(ResultCodeEnum.FAIL.getCode(), "非法请求!");
        }

        // 判断 token 是否过期
        if (JwtHelper.isExpiration(token)) {
            throw new GuiguException(ResultCodeEnum.FAIL.getCode(), "token 已过期!");
        }

        // 根据用户id获取用户信息
        Map<String, Object> map = sysUserService.getUserInfo(JwtHelper.getUsername(token));
        // 返回数据
        return Result.ok(map);
    }

    @ApiOperation("用户退出登录")
    @PostMapping("/logout")
    public Result logout() {
        return Result.ok();
    }

}
```



### 5.2 服务接口

```java
    /**
     * 根据用户名称获取用户信息
     *
     * @param username 用户名
     * @return {@link Map}<{@link String}, {@link Object}>
     */
    Map<String, Object> getUserInfo(String username);
```



### 5.3 服务实现

```java
    @Override
    public Map<String, Object> getUserInfo(String username) {
        // 根据用户名称查询用户信息
        SysUser sysUser = baseMapper.selectOne(
                new LambdaQueryWrapper<SysUser>()
                        .eq(SysUser::getUsername, username)
        );

        // 根据用户id查询菜单权限值
        List<RouterVo> routerVoList = sysMenuService.getUserMenuList(sysUser.getId());
        // 根据用户id查询按钮权限值
        List<String> permsList = sysMenuService.getUserButtonList(sysUser.getId());

        Map<String, Object> result = new HashMap<>();
        result.put("name", username);
        result.put("avatar", "");
        result.put("roles", "[\"admin\"]");

        // 菜单权限数据
        result.put("routers", routerVoList);
        // 按钮权限数据
        result.put("buttons", permsList);
        return result;
    }
```



### 5.4 `sysMenuService`

#### 5.4.1 接口

```java
    /**
     * 获取用户路由菜单列表
     *
     * @param id id
     * @return {@link List}<{@link RouterVo}>
     */
    List<RouterVo> getUserMenuList(Long id);

    /**
     * 根据用户id查询按钮权限值
     *
     * @param id id
     * @return {@link List}<{@link String}>
     */
    List<String> getUserButtonList(Long id);
```



#### 5.4.2 实现

```java
    @Override
    public List<RouterVo> getUserMenuList(Long userId) {
        // admin 是超级管理员, 操作所有
        // 判断id值[{1: 超级管理员}, {其他: 普通用户}]
        List<SysMenu> sysMenuList;
        // 判断
        if (userId.equals(1L)) {
            sysMenuList = baseMapper.selectList(
                    new LambdaQueryWrapper<SysMenu>()
                            .eq(SysMenu::getStatus, 1)
                            .orderByAsc(SysMenu::getSortValue)
            );
        } else {
            // 根据用户id查询权限
            sysMenuList = baseMapper.selectMenuListUserId(userId);
        }

        // 构建树形结构
        List<SysMenu> sysMenuTreeList = MenuHelper.buildTree(sysMenuList);
        // 转换成前端路由格式
        return RouterHelper.buildRouters(sysMenuTreeList);
    }

    @Override
    public List<String> getUserButtonList(Long userId) {
        // admin 是超级管理员, 操作所有
        // 判断id值[{1: 超级管理员}, {其他: 普通用户}]
        List<SysMenu> sysMenuList;
        // 判断
        if (userId.equals(1L)) {
            sysMenuList = baseMapper.selectList(
                    new LambdaQueryWrapper<SysMenu>()
                            .eq(SysMenu::getStatus, 1)
            );
        } else {
            // 根据用户id查询权限
            sysMenuList = baseMapper.selectMenuListUserId(userId);
        }

        return sysMenuList.stream().map(SysMenu::getPerms).collect(Collectors.toList());
    }
```

#### 5.4.3 `Mapper`接口

```java
package com.atguigu.system.mapper;

import com.atguigu.model.system.SysMenu;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 * 菜单表 Mapper 接口
 * </p>
 *
 * @author 陈江林
 * @since 2022-11-15
 */
public interface SysMenuMapper extends BaseMapper<SysMenu> {

    /**
     * 根据用户id查询权限
     *
     * @param userId 用户id
     * @return {@link List}<{@link SysMenu}>
     */
    List<SysMenu> selectMenuListUserId(@Param("userId") Long userId);
}
```

#### 5.4.4 `Mapper.xml`

```xml
<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE mapper PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN" "http://mybatis.org/dtd/mybatis-3-mapper.dtd">
<mapper namespace="com.atguigu.system.mapper.SysMenuMapper">

    <select id="selectMenuListUserId" resultType="com.atguigu.model.system.SysMenu">
        SELECT DISTINCT m.id,
                        m.parent_id,
                        m.name,
                        m.type,
                        m.path,
                        m.component,
                        m.perms,
                        m.icon,
                        m.sort_value,
                        m.status,
                        m.create_time,
                        m.update_time,
                        m.is_deleted
        FROM sys_menu m
                 LEFT JOIN sys_role_menu rm ON m.id = rm.menu_id
                 LEFT JOIN sys_user_role ur ON rm.role_id = ur.role_id
        WHERE ur.user_id = #{userId}
          AND m.status = 1
          AND m.is_deleted = 0
          AND rm.is_deleted = 0
          AND ur.is_deleted = 0
    </select>

</mapper>
```

## 6 前端

### 6.1 修改`axios`请求工具`request.js`

![img](https://cdn.nlark.com/yuque/0/2022/png/12811585/1668945857943-ad9c8836-2827-490d-8f80-73cb66e272b7.png)



### 6.2 修改仓库`store/modules/user.js`

![img](https://cdn.nlark.com/yuque/0/2022/png/12811585/1668946087790-a1c6f673-8138-4897-a481-eb54b5662a55.png)

![img](https://cdn.nlark.com/yuque/0/2022/png/12811585/1668946388410-80275a14-dfa4-48c3-a3a6-0a3466f624f8.png)

![img](https://cdn.nlark.com/yuque/0/2022/png/12811585/1668946888722-5b03f11e-4607-4f5f-9df9-57d91ff11304.png)



### 6.3 `store/getter.js`

![img](https://cdn.nlark.com/yuque/0/2022/png/12811585/1668947067335-ada6dc22-f553-47fc-915b-fc9e4ff962d7.png)



### 6.4 `src/router`

#### 6.4.1 `_import_production.js`

```javascript
// 生产环境导入组件
module.exports = file => () => import('@/views/' + file + '.vue')
```

#### 6.4.2 `_import_development.js`

```javascript
// 开发环境导入组件
// vue-loader at least v13.0.0+
module.exports = file => require('@/views/' + file + '.vue').default	
```



### 6.5 替换`src/permission.js`

```javascript
import router from './router'
import store from './store'
import { getToken } from '@/utils/auth'
import { Message } from 'element-ui'
import NProgress from 'nprogress' // 水平进度条提示: 在跳转路由时使用
import 'nprogress/nprogress.css' // 水平进度条样式
import getPageTitle from '@/utils/get-page-title' // 获取应用头部标题的函数
import Layout from '@/layout'
import ParentView from '@/components/ParentView'
const _import = require('./router/_import_'+process.env.NODE_ENV) // 获取组件的方法

NProgress.configure({ showSpinner: false }) // NProgress Configuration
const whiteList = ['/login'] // no redirect whitelist
router.beforeEach(async(to, from, next) => {
  NProgress.start()
// set page title
  document.title = getPageTitle(to.meta.title)
// determine whether the user has logged in
  const hasToken = getToken()
  if (hasToken) {
    if (to.path === '/login') {
      // if is logged in, redirect to the home page
      next({ path: '/' })
      NProgress.done()
    } else {
      const hasGetUserInfo = store.getters.name
      if (hasGetUserInfo) {
        next()
      } else {
        try {
          // get user info
          await store.dispatch('user/getInfo')// 请求获取用户信息
          if (store.getters.menus.length < 1) {
            global.antRouter = []
            next()
          }
          const menus = filterAsyncRouter(store.getters.menus)// 1.过滤路由
          console.log(menus)
          router.addRoutes(menus) // 2.动态添加路由
          let lastRou = [{ path: '*', redirect: '/404', hidden: true }]
          router.addRoutes(lastRou)
          global.antRouter = menus // 3.将路由数据传递给全局变量，做侧边栏菜单渲染工作
          next({
            ...to,
            replace: true
          })
          //next()
        } catch (error) {
          // remove token and go to login page to re-login
          console.log(error)
          await store.dispatch('user/resetToken')
          Message.error(error || 'Has Error')
          next(`/login?redirect=${to.path}`)
          NProgress.done()
        }
      }
    }
  } else { /* has no token*/
    if (whiteList.indexOf(to.path) !== -1) {
      // in the free login whitelist, go directly
      next()
    } else {
      // other pages that do not have permission to access are redirected to the login page.
      next(`/login?redirect=${to.path}`)
      NProgress.done()
    }
  }
})

router.afterEach(() => { // finish progress bar
  NProgress.done()
}) // // 遍历后台传来的路由字符串，转换为组件对象
function filterAsyncRouter(asyncRouterMap) {
  const accessedRouters = asyncRouterMap.filter(route => {
    if (route.component) {
      if (route.component === 'Layout') {
        route.component = Layout
      } else if (route.component === 'ParentView') {
        route.component = ParentView
      } else {
        try {
          route.component = _import(route.component)// 导入组件
        } catch (error) {
          debugger
          console.log(error)
          route.component = _import('dashboard/index')// 导入组件
        }
      }
    }
    if (route.children && route.children.length > 0) {
      route.children = filterAsyncRouter(route.children)
    } else {
      delete route.children
    }
    return true
  })
  return accessedRouters
}
```



### 6.6 `src/router`

```javascript
export const constantRoutes = [
  {
    path: '/login',
    component: () => import('@/views/login/index'),
    hidden: true
  },

  // {
  //   path: '/404',
  //   component: () => import('@/views/404'),
  //   hidden: true
  // },

  {
    path: '/',
    component: Layout,
    redirect: '/dashboard',
    children: [{
      path: 'dashboard',
      name: 'Dashboard',
      component: () => import('@/views/dashboard/index'),
      meta: { title: 'Dashboard', icon: 'dashboard' }
    }]
  }


  //添加我们的路由
  // {
  //   path: '/system',
  //   component: Layout,
  //   meta: {
  //     title: '系统管理',
  //     icon: 'el-icon-s-tools'
  //   },
  //   alwaysShow: true,
  //   children: [
  //     {
  //       path: 'sysRole',
  //       component: () => import('@/views/system/sysRole/list'),
  //       meta: {
  //         title: '角色管理',
  //         icon: 'el-icon-s-help'
  //       },
  //     },
  //     {
  //       path: 'sysUser',
  //       component: () => import('@/views/system/sysUser/list'),
  //       meta: {
  //         title: '用户管理',
  //         icon: 'el-icon-s-help'
  //       },
  //     },

  //     {
  //       name: 'sysMenu',
  //       path: 'sysMenu',
  //       component: () => import('@/views/system/sysMenu/list'),
  //       meta: {
  //         title: '菜单管理',
  //         icon: 'el-icon-s-unfold'
  //       },
  //     },

  //     {
  //       path: 'assignAuth',
  //       component: () => import('@/views/system/sysRole/assignAuth'),
  //       meta: {
  //         activeMenu: '/system/sysRole',
  //         title: '角色授权'
  //       },
  //       hidden: true,
  //     }
  //   ]
  // },


  // 404 page must be placed at the end !!!
  // { path: '*', redirect: '/404', hidden: true }
]
```



### 6.7 在`src/components`下新建 `/ParentView/index.vue`

![img](https://cdn.nlark.com/yuque/0/2022/png/12811585/1668959969415-77f72989-068c-4aaf-9e8d-c36092c43e06.png)

```vue
<template>
  <router-view />
</template>

<script>
export default {
  name: 'Index'
}
</script>

<style scoped>

</style>
```



### 6.8 修改`layout/components/SideBar/index.vue`

```vue
routes() {
  // return this.$router.options.routes
  return this.$router.options.routes.concat(global.antRouter)
},
```



### 6.9 在`util`目录下新建`btn-permission.js`文件

```javascript
import store from '@/store'

/**
 * 判断当前用户是否有此按钮权限
 * 按钮权限字符串 permission 
 */
export default function hasBtnPermission(permission) {
  // 得到当前用户的所有按钮权限
  const myBtns = store.getters.buttons
  // 如果指定的功能权限在myBtns中, 返回true ==> 这个按钮就会显示, 否则隐藏
  return myBtns.indexOf(permission)
}
```



### 6.10 `main.js`

```javascript
// 按钮权限控制
import hasBtnPermission from '@/utils/btn-permission'
Vue.prototype.$hasBP = hasBtnPermission
```



### 6.11 按钮控制权限

- `$hasBP('btn.sysRole.add')`控制按钮是否显示
- 如：角色管理添加按钮，我们没让按钮隐藏，而是让按钮不可操作

```vue
<el-button type="success" icon="el-icon-plus" size="mini" @click="add" :disabled="$hasBP('btn.sysRole.add')">添加</el-button>
```


# 七 整合 Spring Security

```
git checkout -b 7.0.0_spring-security
```



## 1 `Spring Security`简介

- `Spring`是非常流行和成功的`Java`应用开发框架，`Spring Security`正是`Spring`家族中的成员。`Spring Security`基于`Spring`框架，提供了一套`Web`应用安全性的完整解决方案
- 正如你可能找到的关于安全方面的两个核心功能是

1. 认证
2. 授权

- 一般来说，`Web`应用的安全性包括`**用户认证（Authentication）和 用户授权（Authorization）**`两个部分，这两点也是`Spring Security`重要核心功能

1. 用户认证: 验证某个用户是否为系统中的合法主体，也就是说用户能否访问该系统。用户认证一般要求提供`用户名`和`密码`，系统通过校验用户名和密码来完成认证过程（通俗点来说就是系统认为用户是否能登录）
2. 用户授权：指的是验证某个用户能否有权限执行某个操作。在一个系统中，不同用户所具有的权限是不同的。比如对一个文件来说，有的用户只能进行读取，而有的用户可以进行修改。一般来说，系统会为不同的用户分配不同的角色，而每个角色则对应一系列的权限（通俗点来讲就是系统判断用户是否有权限去做某些事情）



## 2 历史

- `Spring Security`开始于`2003`年年底，`Spring`的`acegi`安全系统。起因是`Spring`开发者邮件列表中的一个问题，有人提问是否考虑提供一个基于`Spring`的安全实现
- `Spring Security`以`The Acegi Security System for Spring`的名字始于`2013`年晚些时候。一个问题提交到`Spring`开发者的邮件列表，询问是否已经有考虑一个机遇`Spring`的安全性社区实现。那时候`Spring`的社区相对较小（相对现在）。实现上`Spring`自己在`2013`年只是一个存在于`ScourseForge`的项目，这个问题的回答是一个值得研究的领域，虽然目前时间的缺乏组织了我们对它的探索
- 考虑到这一点，一个简单的安全实现建成但是并没有发布，几周后，`Spring`社区的其他成员询问了安全性，这次这个代码被发送给他们。其他几个请求也跟随而来。到`2014`年一月大约有`20万`人使用了这个代码。这些创作者的人提出一个`SourceForge`项目加入是为了，这是在`2004`三月正式成立
- 在早些时候，这个项目没有任何自己的验证模块，身份验证过程依赖于容器管理的安全性和`Acegi`安全性。而不是专注于授权。开始的时候这很适合，但是越来越多的用户请求额外的容器支持。容器特定的认证领域接口的基本限制变得清晰。还有一个相关的问题增加新的日期的路径，这是最终用户的困惑和错误配置的常见问题
- `Acegi`安全特定的认证服务介绍。大约一年后，`Acegi`安全正式成为了`Spring`框架的子项目。`1.0.0`最终版本是出版于`2006`，在超过两年半的大量生产的软件项目和数以百计的改进和积极利用社区的贡献
- `Acegi`安全`2007`年底正式成为了`Spring`组合项目，更名为`Srping Security`



## 3 同款产品对比

### 3.1 `Spring Security`

- `Spring`技术栈的组成部分: `https://spring.io/projects/spring-security`
- `Spring-Security`特点

1. 和`Spring`无缝整合
2. 全面的权限控制
3. 专门为`Web`开发而设计

1. 1. 旧版本不能脱离`Web`环境使用
2. 新版本对整个框架进行了分层抽取，分成了核心模块和`Web`模块。单独引入核心模块就可以脱离`Web`环境

1. 重量级



### 3.2 `Shiro`

- `Apache`旗下的轻量级权限控制框架
- 特点

1. 轻量级。`Shiro`主张的理念是把复杂的事情变简单，针对对性能有更高的要求的互联网应用有更好表现
2. 通用性

1. 1. 好处：不局限于`Web`环境，可以脱离`Web`环境使用
2. 缺陷：在`Web`环境下一些特定的需求需要手动编写代码定制



### 3.3 `Spring-Security`和`shiro`对比

- `Spring Security`是`Spirng`家族中的一个安全管理框架，实际上，在`Srping Boot`出现之前，`Srping Security`就已经发展了多年了，但是使用的并不多，安全管理这个领域，一直是`Shiro`的天下
- 相对于`Shiro`，在`SSM`中整合`Spring Security`都是比较麻烦的操作，所以，`Spring Security`虽然功能比`Shiro`强大，但是使用反而没有`Shiro`多（`Shiro`虽然功能没有`Spring Security`多，但是对于大部分项目而言，`Shiro`也够用了）
- 自从有了`Spring Boot`之后，`Spring Boot`对于`Spring Security`提供了自动化配置方案，可以使用更少的配置来使用`Spring Security`
- 因此，一般来说，常见的安全管理技术栈的组合是这样的

1. `SSM`+`Shiro`
2. `Spring Boot/Spring Cloud`+`Spring Security`

- 以上只是一个推荐的组合，如果单纯从技术上来说，无论怎么组合，都是可以运行的



## 4 `Spring Security`实现权限

- 要对`Web`资源进行保护，最好的办法莫过于`Filter`
- 要想对方法调用进行保护，最好的办法莫过于`AOP`
- `Spirng Security`进行认证和鉴权的时候，就是利用一系列的`Filter`来进行拦截

![img](https://cdn.nlark.com/yuque/0/2022/png/12811585/1669036415675-7a183fea-b19c-4043-bc6b-31f4e723ac1d.png)

- 如图所示，一个请求想要访问到`API`就会从左到右经过蓝线框里的过滤器，其中**绿色部分是负责认证的过滤器，蓝色部分是负责异常处理，橙色部分则是负责授权。**进行一系列拦截最终访问到我们的`API`
- 这里面我们只需要重点关注两个过滤器即可：`UsernamePasswordAuthenticationFilter`负责登录认证，`FilterSecurityInterceptor`负责权限授权
- 说明：`Spring Security`的核心逻辑全在这一套过滤器中，过滤器里会调用各种组件完成功能，掌握了这些过滤器和组件你就掌握了`Spring Security`，这个框架的使用方式就是对这些过滤器和组件进行扩展



## 5 `Spirng Security`入门

- 我们在现有的项目基础上做集成，`Spring Security`权限控制部分也是公共模块，后续哪个`service`服务模块需要，直接引入即可
- 后续我们的`Spring Cloud`微服务项目可能就基于该权限系统开发，因此我们要做好技术扩展



### 5.1 创建`spring-security`模块

- 在`common`模块下创建`spring-security`公共模块

### 5.2 依赖

```xml
<?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 https://maven.apache.org/xsd/maven-4.0.0.xsd">
    <modelVersion>4.0.0</modelVersion>

    <parent>
        <groupId>com.atguigu</groupId>
        <artifactId>common</artifactId>
        <version>1.0</version>
    </parent>

    <version>1.0</version>
    <artifactId>spring-security</artifactId>
    <packaging>jar</packaging>

    <dependencies>
        <dependency>
            <groupId>com.atguigu</groupId>
            <artifactId>common-util</artifactId>
            <version>1.0</version>
        </dependency>
         <dependency>
            <groupId>com.atguigu</groupId>
            <artifactId>model</artifactId>
            <version>1.0</version>
        </dependency>
        <!-- Spring Security依赖 -->
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-security</artifactId>
        </dependency>
        <dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-web</artifactId>
			<scope>provided </scope>
		</dependency>
    </dependencies>

</project>
```



### 5.3 新建配置类

```java
package com.atguigu.system.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * Spring Security 配置类
 *
 * @author 陈江林
 * @date 2022/11/21 21:33
 */
@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    
}
```



### 5.4 `service-system`模块引入

- 在`service-system`引入权限模块

```xml
<dependency>
    <groupId>com.atguigu</groupId>
    <artifactId>spring-security</artifactId>
    <version>1.0</version>
</dependency>
```



### 5.5 启动项目测试

- 自动跳转到登录页面

![img](https://cdn.nlark.com/yuque/0/2022/png/12811585/1669038858160-b6ed9288-abf2-4ab7-8165-0221baed08c3.png)

- 默认的用户名：user
- 密码在项目启动的时候在控制台会打印，注意每次启动的时候密码会发生变化

![img](https://cdn.nlark.com/yuque/0/2022/png/12811585/1669038858229-255dc420-e9a8-4382-b7a8-61fcfb487fff.png)



## 6 用户认证

![img](https://cdn.nlark.com/yuque/0/2022/png/12811585/1669039601643-8ea43a0f-683f-4bef-a179-1920c382087c.png)

### 6.1 用户认证核心组件

- 我们系统中会有许多用户，确认当前是哪个用户正在使用我们的系统就是登录认证的最终目的。这里我们就提取除了一个核心概念：**当前登录用户/当前认证用户。**整个系统安全都是围绕当前登录用户展开的，这个不难理解，要是当前登录用户都不能确认了，那`A`下了一个订单，下到了`B`的账户就乱套了。这一概念在`Spring Security`中体现就是`Authenticatoin`，它存储了认证信息，代表当前登录用户
- 我们在程序中如何获取并使用它呢？我们需要通过`securityContext`来获取`Authentication`，`SecurityContext`就是我们的上下文对象! 这个上下文对象则是交由`SecurityContextHolder`进行管理，你可以在程序任何地方使用它

```java
Authenticaton authentication = SecurityContextHolder.getContext().getAuthentication();
```

`SecurityContextHolder`原理非常简单，就是使用`ThreadLocal`来保证一个线程中传递同一个对象



`**Spring Security**`**中三个核心组件**

1. `Authenticaton`**：**存储了认证信息，代表当前登录用户
2. `SecurityContext`：上下文对象，用来获取`Authenticatoin`
3. `SecurityContextHolder`：上下文管理对象，用来在程序任何地方获取`SecurityContext`



### 6.2 `Authentication`中有什么信息?

1. `Principal`：用户信息，没有认证时一般是用户名，认证后一般是用户对象
2. `Credenttials`：用户凭证，一般是密码
3. `Authorities`：用户权限



### 6.3 如何进行用户认证

- `Spring Security`是怎么进行用户认证的呢？
- `AuthenticatoinManager`就是`Spring Security`用于执行身份验证的组件，只需要调用它的`authenticate`方法即可完成认证。`Spring Security`默认的认证方式就是在`UsernamePasswordAuthenticationFilter`这个过滤器中进行认证，该过滤器负责认证逻辑
- `Spring Security`用户认证关键代码如下：

```java
public Authentication authenticate(Authentication authentication) throws AuthenticationException {
...省略其他代码

    // 传递过来的用户名
    String username = authentication.getName();
    // 调用UserDetailService的方法，通过用户名查询出用户对象UserDetail（查询不出来UserDetailService则会抛出异常）
    UserDetails userDetails = this.getUserDetailsService().loadUserByUsername(username);
    String presentedPassword = authentication.getCredentials().toString();

    // 传递过来的密码
    String password = authentication.getCredentials().toString();
    // 使用密码解析器PasswordEncoder传递过来的密码是否和真实的用户密码匹配
    if (!passwordEncoder.matches(password, userDetails.getPassword())) {
        // 密码错误则抛出异常
        throw new BadCredentialsException("错误信息...");
    }

    // 注意哦，这里返回的已认证Authentication，是将整个UserDetails放进去充当Principal
    UsernamePasswordAuthenticationToken result = new UsernamePasswordAuthenticationToken(userDetails,
            authentication.getCredentials(), userDetails.getAuthorities());
    return result;

...省略其他代码
}
```

`UserDetailsService`、`UserDetails`、`PasswordEncoder`，这三个组件`Spring Security`都有默认实现，这一般都满足不了我们实际需求，所以这里我们自己来实现这些组件



### 6.4 加密器`PasswordEncoder`

- 采用`bCrypt`加密

```java
package com.atguigu.system.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * Spring Security 配置类
 *
 * @author 陈江林
 * @date 2022/11/21 21:33
 */
@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    /**
     * 加密方式
     *
     * @return {@link PasswordEncoder}
     */
    @Bean
    public PasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }

}
```

- 用户登录

```java
@Autowired
private PasswordEncoder passwordEncoder;
// 判断密码是否一致
String password = loginVo.getPassword();
String encode = passwordEncoder.encode(password);
if (encode.equals(sysUser.getPassword())) {
    throw new GuiguException(ResultCodeEnum.FAIL.getCode(), "密码不一致!");
}
```

- 保存用户

```java
@ApiOperation("用户保存")
@PostMapping("/save")
public Result save(@RequestBody SysUser sysUser) {
    if (0 != sysUserService.count(new LambdaQueryWrapper<SysUser>()
            .eq(SysUser::getUsername, sysUser.getUsername()))) {
        return Result.fail().message("用户名称已存在!");
    }

    if (0 != sysUserService.count(new LambdaQueryWrapper<SysUser>()
            .eq(SysUser::getPhone, sysUser.getPhone()))) {
        return Result.fail().message("手机号码已存在!");
    }

    if (0 != sysUserService.count(new LambdaQueryWrapper<SysUser>()
            .eq(SysUser::getName, sysUser.getName()))) {
        return Result.fail().message("昵称已存在!");
    }

    // 密码加密
    sysUser.setPassword(passwordEncoder.encode(sysUser.getPassword()));
    if (sysUserService.save(sysUser)) {
        return Result.ok();
    } else {
        return Result.fail();
    }
}
```

### 6.5 用户对象`UserDetails`

- 该接口就是用户对象，它提供了用户的一些通用属性，源码如下

```java
public interface UserDetails extends Serializable {
	/**
     * 用户权限集合（这个权限对象现在不管它，到权限时我会讲解）
     */
    Collection<? extends GrantedAuthority> getAuthorities();
    /**
     * 用户密码
     */
    String getPassword();
    /**
     * 用户名
     */
    String getUsername();
    /**
     * 用户没过期返回true，反之则false
     */
    boolean isAccountNonExpired();
    /**
     * 用户没锁定返回true，反之则false
     */
    boolean isAccountNonLocked();
    /**
     * 用户凭据(通常为密码)没过期返回true，反之则false
     */
    boolean isCredentialsNonExpired();
    /**
     * 用户是启用状态返回true，反之则false
     */
    boolean isEnabled();
}
```

- 实际开发中我们的用户属性各种各样，这些默认属性可能是满足不了，所以我们一般会自己实现该接口，然后设置好我们实际的用户实体对象。实现此接口要重写很多方法比较麻烦，我们可以继承`Spring Security`提供的`org.springframework.security.core.userdetails.User`类，该类实现了`UserDetails`接口拜我们省去了重写方法的工作



- 新建`CustomUser`对象

![img](https://cdn.nlark.com/yuque/0/2022/png/12811585/1669233158431-863c277e-9578-4af5-96c6-043445e3d2d0.png)

```java
package com.atguigu.system.custom;

import com.atguigu.model.system.SysUser;
import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import java.util.Collection;

/**
 * 自定义用户类
 * 
 * @author 陈江林
 * @date 2022/11/22 23:32
 */
@Getter
@Setter
public class CustomUser extends User {

    private SysUser sysUser;

    public CustomUser(SysUser sysUser, Collection<? extends GrantedAuthority> authorities) {
        super(sysUser.getUsername(), sysUser.getPassword(), authorities);
        this.sysUser = sysUser;
    }

}
```



### 6.6 业务对象`UserDetailsService`

- 该接口只有一个方法

```java
public interface UserDetailsService {
    /**
     * 根据用户名获取用户对象（获取不到直接抛异常）
     */
    UserDetails loadUserByUsername(String username) throws UsernameNotFoundException;
}
```

- 新建`UserDetailsServiceImpl`类，实现`UserDetailsService`

![img](https://cdn.nlark.com/yuque/0/2022/png/12811585/1669233188435-8cd9c13f-d537-4439-a0ee-d76806874421.png)

```java
package com.atguigu.system.service.impl;

import com.atguigu.model.system.SysUser;
import com.atguigu.system.custom.CustomUser;
import com.atguigu.system.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.Collections;

/**
 * @author 陈江林
 * @date 2022/11/23 00:11
 */
@Component
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private SysUserService sysUserService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        SysUser sysUser = sysUserService.getByUsername(username);
        if (null == sysUser) {
            throw new UsernameNotFoundException("用户名不存在!");
        }

        if (sysUser.getStatus() == 0) {
            throw new RuntimeException("账号已停用!");
        }

        return new CustomUser(sysUser, Collections.emptyList());
    }

}
```

- `AuthenticationManager`校验所调用的三个组件我们就已经做好实现了



### 6.7 自定义用户认证接口`TokenLoginFilter`

![img](https://cdn.nlark.com/yuque/0/2022/png/12811585/1669233257184-7dff9db6-312a-4c6b-9c60-fa6da17b2df5.png)

```java
package com.atguigu.system.filter;

import com.atguigu.common.result.Result;
import com.atguigu.common.result.ResultCodeEnum;
import com.atguigu.common.utils.JwtHelper;
import com.atguigu.common.utils.ResponseUtil;
import com.atguigu.model.vo.LoginVo;
import com.atguigu.system.custom.CustomUser;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * @author 陈江林
 * @date 2022/11/23 00:14
 */
public class TokenLoginFilter extends UsernamePasswordAuthenticationFilter {

    public TokenLoginFilter(AuthenticationManager authenticationManager) {
        this.setAuthenticationManager(authenticationManager);
        this.setPostOnly(false);
        // 指定登录接口及提交方式，可以指定任意路径
        this.setRequiresAuthenticationRequestMatcher(
                new AntPathRequestMatcher("/admin/system/index/login", "POST")
        );
    }

    /**
     * 登录认证
     *
     * @param req
     * @param res
     * @return
     * @throws AuthenticationException
     */
    @Override
    public Authentication attemptAuthentication(HttpServletRequest req, HttpServletResponse res)
            throws AuthenticationException {
        try {
            LoginVo loginVo = new ObjectMapper().readValue(req.getInputStream(), LoginVo.class);
            Authentication authenticationToken = new UsernamePasswordAuthenticationToken(loginVo.getUsername(), loginVo.getPassword());
            return this.getAuthenticationManager().authenticate(authenticationToken);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 登录成功
     *
     * @param request
     * @param response
     * @param chain
     * @param auth
     * @throws IOException
     * @throws ServletException
     */
    @Override
    protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain,
                                            Authentication auth) throws IOException, ServletException {
        // 获取认证对象
        CustomUser customUser = (CustomUser) auth.getPrincipal();
        // 生成 token
        String token = JwtHelper.createToken(customUser.getSysUser().getId(), customUser.getSysUser().getUsername());
        // 返回
        Map<String, Object> map = new HashMap<>();
        map.put("token", token);
        ResponseUtil.out(response, Result.ok(map));
    }

    /**
     * 登录失败
     *
     * @param request
     * @param response
     * @param e
     * @throws IOException
     * @throws ServletException
     */
    @Override
    protected void unsuccessfulAuthentication(HttpServletRequest request, HttpServletResponse response,
                                              AuthenticationException e) throws IOException, ServletException {
        if (e.getCause() instanceof RuntimeException) {
            ResponseUtil.out(response, Result.build(null, 204, e.getMessage()));
        } else {
            ResponseUtil.out(response, Result.build(null, ResultCodeEnum.LOGIN_MOBLE_ERROR));
        }
    }

}
```



- 新建工具类`ResponseUtil`

![img](https://cdn.nlark.com/yuque/0/2022/png/12811585/1669233290207-7c4af3e3-1868-464b-b8b1-d728f18d56b0.png)

```java
package com.atguigu.common.utils;

import com.atguigu.common.result.Result;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 返回工具类
 *
 * @author 陈江林
 * @date 2022/11/23 00:21
 */
public class ResponseUtil {

    public static void out(HttpServletResponse response, Result r) {
        ObjectMapper mapper = new ObjectMapper();
        response.setStatus(HttpStatus.OK.value());
        response.setContentType(MediaType.APPLICATION_JSON_UTF8_VALUE);
        try {
            mapper.writeValue(response.getWriter(), r);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
```



### 6.8 认证解析`token`

- 因为用户登录状态在`token`中存储在客户端，所以每次请求接口请求携带`token`，后台通过自定义`token`过滤器拦截解析`token`完成认证并填充用户信息实体

![img](https://cdn.nlark.com/yuque/0/2022/png/12811585/1669233325818-5952eb37-fc35-4a1b-8eae-fc6ed0e55757.png)

```java
package com.atguigu.system.filter;

import com.atguigu.common.result.Result;
import com.atguigu.common.result.ResultCodeEnum;
import com.atguigu.common.utils.JwtHelper;
import com.atguigu.common.utils.ResponseUtil;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Collections;

/**
 * 认证解析过滤器
 *
 * @author 陈江林
 * @date 2022/11/23 00:23
 */
public class TokenAuthenticationFilter extends OncePerRequestFilter {
    public TokenAuthenticationFilter() {

    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        logger.info("uri:" + request.getRequestURI());
        // 如果是登录接口，直接放行
        if ("/admin/system/index/login".equals(request.getRequestURI())) {
            chain.doFilter(request, response);
            return;
        }

        UsernamePasswordAuthenticationToken authentication = getAuthentication(request);
        if (null != authentication) {
            SecurityContextHolder.getContext().setAuthentication(authentication);
            chain.doFilter(request, response);
        } else {
            ResponseUtil.out(response, Result.build(null, ResultCodeEnum.PERMISSION));
        }
    }

    private UsernamePasswordAuthenticationToken getAuthentication(HttpServletRequest request) {
        // token置于header里
        String token = request.getHeader("token");
        logger.info("token:" + token);
        if (!StringUtils.isEmpty(token)) {
            String useruame = JwtHelper.getUsername(token);
            logger.info("useruame:" + useruame);
            if (!StringUtils.isEmpty(useruame)) {
                return new UsernamePasswordAuthenticationToken(useruame, null, Collections.emptyList());
            }
        }

        return null;
    }
}
```



### 6.9 认证解析`token`

```java
package com.atguigu.system.config;

import com.atguigu.system.filter.TokenAuthenticationFilter;
import com.atguigu.system.filter.TokenLoginFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

/**
 * Spring Security 配置类
 *
 * @author 陈江林
 * @date 2022/11/21 21:33
 */
@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    /**
     * 加密方式
     *
     * @return {@link PasswordEncoder}
     */
    @Bean
    public PasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        // 这是配置的关键，决定哪些接口开启防护，哪些接口绕过防护
        http
                // 关闭csrf
                .csrf().disable()
                // 开启跨域以便前端调用接口
                .cors().and()
                .authorizeRequests()
                // 指定某些接口不需要通过验证即可访问。登陆接口肯定是不需要认证的
                .antMatchers("/admin/system/index/login").permitAll()
                // 这里意思是其它所有接口需要认证才能访问
                .anyRequest().authenticated()
                .and()
                // TokenAuthenticationFilter放到UsernamePasswordAuthenticationFilter的前面，这样做就是为了除了登录的时候去查询数据库外，其他时候都用token进行认证。
                .addFilterBefore(new TokenAuthenticationFilter(), UsernamePasswordAuthenticationFilter.class)
                .addFilter(new TokenLoginFilter(authenticationManager()));

        // 禁用session
        http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
    }

    /**
     * 配置哪些请求不拦截
     * 排除swagger相关请求
     *
     * @param web
     * @throws Exception
     */
    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers("/favicon.ico", "/swagger-resources/**", "/webjars/**", "/v2/**", "/swagger-ui.html/**", "/doc.html");
    }
}
```

- 说明：

1. 我们是前后端分离项目，使用`jwt`生成`token`，即用户状态保存在客户端中，前后端交互`api`接口，无`session`生成，所以我们不需要配置`formLogin`，`session`禁用
2. 在浏览器访问时

```json
{
    "code": 209,
    "message": "没有权限",
    "data": null
}
```

![img](https://cdn.nlark.com/yuque/0/2022/png/12811585/1669233057837-91f2a8d5-3e4c-4c77-8b9f-4b0f487c0fa3.png)



### 6.10 通过`swagger`测试登录

![img](https://cdn.nlark.com/yuque/0/2022/png/12811585/1669229775811-d941fb41-f980-4231-a78a-1d09d2b3dbc7.png)

## 7 用户授权

- 在`Spring Security`中，会使用默认的`FilterSecurityInterceptor`来进行权限校验，在`FilterSecurityInterceptor`中会从`SecurityContextHolder`获取其中的`Authentication`，然后获取其中的权限信息。判断当前用户是否拥有访问当前资源所需的权限
- `Spring Security`中的`Authentication`类

```java
public interface Authentication extends Principal, Serializable {
	//权限数据列表
    Collection<? extends GrantedAuthority> getAuthorities();

    Object getCredentials();

    Object getDetails();

    Object getPrincipal();

    boolean isAuthenticated();

    void setAuthenticated(boolean var1) throws IllegalArgumentException;
}
```

- 前面登录时执行`loadUserByUsername`方法时，`return new CustomUser(sysUser, Collections.emptyList());`后面的空数据对接就是返回给`Spring Security`的权限数据
- 在`TokenAuthenticationFilter`中怎么获取权限数据呢？登录时我们把权限数据保存到`redis`中（用户名为`key`，权限数据为`value`即可），这样通过`token`获取用户名即可拿到权限数据，这样就可构成除完整的`Authenticatoin`对象



### 7.1 修改`loadUserByUsername`接口方法

```java
package com.atguigu.system.service.impl;

import com.alibaba.fastjson.JSON;
import com.atguigu.model.system.SysUser;
import com.atguigu.system.custom.CustomUser;
import com.atguigu.system.service.SysMenuService;
import com.atguigu.system.service.SysUserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 陈江林
 * @date 2022/11/23 00:11
 */
@Component
@Slf4j
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private SysUserService sysUserService;

    @Autowired
    private SysMenuService sysMenuService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        SysUser sysUser = sysUserService.getByUsername(username);
        if (null == sysUser) {
            throw new UsernameNotFoundException("用户名不存在!");
        }

        if (sysUser.getStatus() == 0) {
            throw new RuntimeException("账号已停用!");
        }

        List<String> userPermsList = sysMenuService.getUserButtonList(sysUser.getId());
        List<SimpleGrantedAuthority> authorities = new ArrayList<>();
        userPermsList.forEach(str -> {
            if (!StringUtils.isEmpty(str)) {
                authorities.add(new SimpleGrantedAuthority(str.trim()));
            }
        });

        return new CustomUser(sysUser, authorities);
    }

}
```



### 7.2 配置`redis`

```xml
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-data-redis</artifactId>
</dependency>
```



### 7.3 修改`TokenLoginFilter`登录成功方法

- 登录成功我们将权限数据保存到`redis`

```java
package com.atguigu.system.filter;

import com.alibaba.fastjson.JSON;
import com.atguigu.common.result.Result;
import com.atguigu.common.result.ResultCodeEnum;
import com.atguigu.common.utils.JwtHelper;
import com.atguigu.common.utils.ResponseUtil;
import com.atguigu.model.vo.LoginVo;
import com.atguigu.system.custom.CustomUser;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * @author 陈江林
 * @date 2022/11/23 00:14
 */
public class TokenLoginFilter extends UsernamePasswordAuthenticationFilter {

    private RedisTemplate redisTemplate;

    public TokenLoginFilter(AuthenticationManager authenticationManager, RedisTemplate redisTemplate) {
        this.setAuthenticationManager(authenticationManager);
        this.setPostOnly(false);
        // 指定登录接口及提交方式，可以指定任意路径
        this.setRequiresAuthenticationRequestMatcher(
                new AntPathRequestMatcher("/admin/system/index/login", "POST")
        );
        this.redisTemplate = redisTemplate;
    }

    /**
     * 登录认证
     *
     * @param req
     * @param res
     * @return
     * @throws AuthenticationException
     */
    @Override
    public Authentication attemptAuthentication(HttpServletRequest req, HttpServletResponse res)
            throws AuthenticationException {
        try {
            LoginVo loginVo = new ObjectMapper().readValue(req.getInputStream(), LoginVo.class);
            Authentication authenticationToken = new UsernamePasswordAuthenticationToken(loginVo.getUsername(), loginVo.getPassword());
            return this.getAuthenticationManager().authenticate(authenticationToken);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 登录成功
     *
     * @param request
     * @param response
     * @param chain
     * @param auth
     * @throws IOException
     * @throws ServletException
     */
    @Override
    protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain,
                                            Authentication auth) throws IOException, ServletException {
        // 获取认证对象
        CustomUser customUser = (CustomUser) auth.getPrincipal();
        // 保存权限数据
        redisTemplate.opsForValue().set(customUser.getUsername(),
                JSON.toJSONString(customUser.getAuthorities()));
        // 生成 token
        String token = JwtHelper.createToken(customUser.getSysUser().getId(), customUser.getSysUser().getUsername());
        // 返回
        Map<String, Object> map = new HashMap<>();
        map.put("token", token);
        ResponseUtil.out(response, Result.ok(map));
    }

    /**
     * 登录失败
     *
     * @param request
     * @param response
     * @param e
     * @throws IOException
     * @throws ServletException
     */
    @Override
    protected void unsuccessfulAuthentication(HttpServletRequest request, HttpServletResponse response,
                                              AuthenticationException e) throws IOException, ServletException {
        if (e.getCause() instanceof RuntimeException) {
            ResponseUtil.out(response, Result.build(null, 204, e.getMessage()));
        } else {
            ResponseUtil.out(response, Result.build(null, ResultCodeEnum.LOGIN_MOBLE_ERROR));
        }
    }

}
```

### 7.4 修改`TokenAuthenticationFitler`

- 认证是`redis`里面获取权限数据

```java
package com.atguigu.system.filter;

import com.alibaba.fastjson.JSON;
import com.atguigu.common.result.Result;
import com.atguigu.common.result.ResultCodeEnum;
import com.atguigu.common.utils.JwtHelper;
import com.atguigu.common.utils.ResponseUtil;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.*;

/**
 * 认证解析过滤器
 *
 * @author 陈江林
 * @date 2022/11/23 00:23
 */
public class TokenAuthenticationFilter extends OncePerRequestFilter {

    private RedisTemplate redisTemplate;

    public TokenAuthenticationFilter(RedisTemplate redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        logger.info("uri:" + request.getRequestURI());
        // 如果是登录接口，直接放行
        if ("/admin/system/index/login".equals(request.getRequestURI())) {
            chain.doFilter(request, response);
            return;
        }

        UsernamePasswordAuthenticationToken authentication = getAuthentication(request);
        if (null != authentication) {
            SecurityContextHolder.getContext().setAuthentication(authentication);
            chain.doFilter(request, response);
        } else {
            ResponseUtil.out(response, Result.build(null, ResultCodeEnum.PERMISSION));
        }
    }

    private UsernamePasswordAuthenticationToken getAuthentication(HttpServletRequest request) {
        // token置于header里
        String token = request.getHeader("token");
        logger.info("token:" + token);
        if (!StringUtils.isEmpty(token)) {
            String username = JwtHelper.getUsername(token);
            logger.info("useruame:" + username);
            if (!StringUtils.isEmpty(username)) {
                // 权限
                String authoritiesString = Objects.requireNonNull(redisTemplate.opsForValue().get(username)).toString();
                List<Map> mapList = JSON.parseArray(authoritiesString, Map.class);
                List<SimpleGrantedAuthority> authorities = new ArrayList<>();
                mapList.forEach(map -> {
                    authorities.add(new SimpleGrantedAuthority(map.get("authority").toString()));
                });

                return new UsernamePasswordAuthenticationToken(username, null, authorities);
            }
        }

        return null;
    }
}
```



### 7.5 修改配置类

- 修改`WebSecurityConfig`类
- 配置类添加注解
- 开启基于方法的安全认证机制，也就是说在`web`层的`controller`启用注解机制的安全确认

```java
@EnableGlobalMethodSecurity(prePostEnabled = true)
```

- 添加注入`bean`

```java
@Autowired
private RedisTemplate redisTemplate;
```

- 添加参数
- 两个`filter`添加`redisTempldate`参数

```java
package com.atguigu.system.config;

import com.atguigu.system.filter.TokenAuthenticationFilter;
import com.atguigu.system.filter.TokenLoginFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

/**
 * Spring Security 配置类
 * `@EnableGlobalMethodSecurity(prePostEnabled = true)`：开启注解功能，默认禁用注解
 *
 * @author 陈江林
 * @date 2022/11/21 21:33
 */
@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private RedisTemplate redisTemplate;

    /**
     * 加密方式
     *
     * @return {@link PasswordEncoder}
     */
    @Bean
    public PasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        // 这是配置的关键，决定哪些接口开启防护，哪些接口绕过防护
        http
                // 关闭csrf
                .csrf().disable()
                // 开启跨域以便前端调用接口
                .cors().and()
                .authorizeRequests()
                // 指定某些接口不需要通过验证即可访问。登陆接口肯定是不需要认证的
                .antMatchers("/admin/system/index/login").permitAll()
                // 这里意思是其它所有接口需要认证才能访问
                .anyRequest().authenticated()
                .and()
                // TokenAuthenticationFilter放到UsernamePasswordAuthenticationFilter的前面，这样做就是为了除了登录的时候去查询数据库外，其他时候都用token进行认证。
                .addFilterBefore(new TokenAuthenticationFilter(redisTemplate), UsernamePasswordAuthenticationFilter.class)
                .addFilter(new TokenLoginFilter(authenticationManager(), redisTemplate));

        // 禁用session
        http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
    }

    /**
     * 配置哪些请求不拦截
     * 排除swagger相关请求
     *
     * @param web
     * @throws Exception
     */
    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers("/favicon.ico", "/swagger-resources/**", "/webjars/**", "/v2/**", "/swagger-ui.html/**", "/doc.html");
    }
}
```

### 7.6 `service-system`模块添加`redis`配置

```yaml
spring:
  redis:
    host: 127.0.0.1
    port: 6379
    database: 0
    timeout: 1800000
    jedis:
      pool:
        max-active: 20 #最大连接数
        max-wait: -1    #最大阻塞等待时间(负数表示没限制)
        max-idle: 5    #最大空闲
        min-idle: 0     #最小空闲
```



### 7.7 控制`controller`层接口权限

- `Spring Security`默认是禁用注解的，要想开启注解，需要在继承`WebSecurityConfigurerAdaper`的类上加`@EnableGlobalMethodSecurity`注解，来判断用户对某个控制层的方法是否具有访问权限
- 通过`@PreAuthorize`标签控制`Controller`层接口权限

```java
package com.atguigu.system.controller;

import com.atguigu.common.result.Result;
import com.atguigu.model.system.SysRole;
import com.atguigu.model.vo.AssginRoleVo;
import com.atguigu.model.vo.SysRoleQueryVo;
import com.atguigu.system.service.SysRoleService;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

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

    @PreAuthorize("hasAuthority('btn.sysRole.list')")
    @ApiOperation(value = "根据用户id获取对应角色")
    @GetMapping("/getRolesByUserId/{userId}")
    public Result<Map<String, Object>> getRolesByUserId(
            @PathVariable Long userId
    ) {
        return Result.ok(sysRoleService.getRolesByUserId(userId));
    }

    @PreAuthorize("hasAuthority('btn.sysRole.add')")
    @ApiOperation(value = "给用户分配角色")
    @PostMapping("/doAssign")
    public Result<List<SysRole>> doAssign(
            @RequestBody AssginRoleVo assginRoleVo
    ) {
        sysRoleService.doAssign(assginRoleVo);
        return Result.ok();
    }

    @PreAuthorize("hasAuthority('btn.sysRole.list')")
    @ApiOperation(value = "查询所有角色")
    @GetMapping("/findAll")
    public Result<List<SysRole>> findAll() {
        return Result.ok(sysRoleService.list());
    }

    @PreAuthorize("hasAuthority('btn.sysRole.remove')")
    @ApiOperation(value = "逻辑删除")
    @DeleteMapping("/remove/{id}")
    public Result removeById(
            @PathVariable Long id
    ) {
        if (sysRoleService.removeById(id)) {
            return Result.ok();
        } else {
            return Result.fail();
        }
    }

    @PreAuthorize("hasAuthority('btn.sysRole.list')")
    @ApiOperation(value = "条件分页查询")
    @GetMapping("/{page}/{limit}")
    public Result<IPage<SysRole>> findQueryRole(
            @PathVariable Long page,
            @PathVariable Long limit,
            SysRoleQueryVo sysRoleQueryVo
    ) {
        return Result.ok(sysRoleService.getPage(new Page<>(page, limit), sysRoleQueryVo));
    }

    @PreAuthorize("hasAuthority('btn.sysRole.add')")
    @ApiOperation("角色添加")
    @PostMapping("/save")
    public Result saveRole(
            @RequestBody SysRole sysRole
    ) {
        if (0 != sysRoleService.count(new LambdaQueryWrapper<SysRole>()
                .eq(SysRole::getRoleName, sysRole.getRoleName()))) {
            return Result.fail().message("角色名称已存在!");
        }

        if (0 != sysRoleService.count(new LambdaQueryWrapper<SysRole>()
                .eq(SysRole::getRoleCode, sysRole.getRoleCode()))) {
            return Result.fail().message("角色编码已存在!");
        }

        if (sysRoleService.save(sysRole)) {
            return Result.ok();
        } else {
            return Result.fail();
        }
    }

    @PreAuthorize("hasAuthority('btn.sysRole.update')")
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

    @PreAuthorize("hasAuthority('btn.sysRole.list')")
    @ApiOperation("根据id查询角色")
    @GetMapping("/findRoleById/{id}")
    public Result<SysRole> findRoleById(
            @PathVariable Long id
    ) {
        return Result.ok(sysRoleService.getById(id));
    }

    @PreAuthorize("hasAuthority('btn.sysRole.remove')")
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
}
```



### 7.8 测试服务器端权限

- 用户名：`wangqq`
- 密码：`123456`

![img](https://cdn.nlark.com/yuque/0/2022/png/12811585/1669325339492-bc90b29d-66bd-47cf-94c9-fbc9edf42968.png)

#### 7.8.1 用户无法登录-修改规则--`validate.js`

![img](https://cdn.nlark.com/yuque/0/2022/png/12811585/1669326513429-afa6f0e8-a3ef-4423-b05c-161d5a7f58a0.png)



### 7.9 异常处理

- 异常处理有两种方式

1. 扩展`Spirng Security`异常处理类：`AccessDeniedHandler`、`AuthenticationEntryPoint`
2. 在`Spring Boot`全局异常统一处理

- 第一种方案说明：如果系统实现了全局异常处理，那么全局异常处理首先会获取`AccessDeniedException`异常，要想`Spring Security`扩展异常生效，必须在全局异常再次抛出该异常
- 我们使用第二种方案

```java
    /**
     * spring security 权限异常
     *
     * @param e e
     * @return {@link Result}
     */
    @ExceptionHandler(AccessDeniedException.class)
    public Result error(AccessDeniedException e) {
        e.printStackTrace();
        return Result.build(null, ResultCodeEnum.PERMISSION);
    }
    
```

- `AccessDeniedException`需要引入依赖，`Spring Security`对应的异常

```xml
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-security</artifactId>
    <scope>provided</scope>
</dependency>
```



# 八 部门管理

```
git checkout -b 8.0.0_dept
```

![img](https://cdn.nlark.com/yuque/0/2022/png/12811585/1669326034302-c2ea5a02-a9f2-436f-94d9-be0b01c03775.png)



## 1 后端

### 1.1 代码生成器，数据库表`sys_dept`

![img](https://cdn.nlark.com/yuque/0/2022/png/12811585/1669326287308-cd624ab9-3ada-4a1e-87de-f7e38aac2dfc.png)

### 1.2 控制类

```java
package com.atguigu.system.controller;


import com.atguigu.common.result.Result;
import com.atguigu.model.system.SysDept;
import com.atguigu.system.service.SysDeptService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 * 组织机构 前端控制器
 * </p>
 *
 * @author 陈江林
 * @since 2022-11-25
 */
@Api(tags = "部门管理接口")
@RestController
@RequestMapping("/admin/system/sysDept")
public class SysDeptController {

    @Autowired
    private SysDeptService sysDeptService;

    @PreAuthorize("hasAuthority('btn.sysDept.add')")
    @ApiOperation(value = "保存")
    @PostMapping("/save")
    public Result save(
            @RequestBody SysDept sysDept
    ) {
        if (sysDeptService.save(sysDept)) {
            return Result.ok();
        } else {
            return Result.fail();
        }
    }

    @PreAuthorize("hasAuthority('btn.sysDept.update')")
    @ApiOperation(value = "修改")
    @PutMapping("/update")
    public Result update(
            @RequestBody SysDept sysDept
    ) {
        if (sysDeptService.updateById(sysDept)) {
            return Result.ok();
        } else {
            return Result.fail();
        }
    }

    @PreAuthorize("hasAuthority('btn.sysDept.list')")
    @ApiOperation(value = "根据id获取数据")
    @GetMapping("/getById/{id}")
    public Result<SysDept> getById(
            @PathVariable Long id
    ) {
        return Result.ok(sysDeptService.getById(id));
    }

    @PreAuthorize("hasAuthority('btn.sysDept.list')")
    @ApiOperation(value = "列表(树形)")
    @GetMapping("/getAll")
    public Result<List<SysDept>> getAll() {
        return Result.ok(sysDeptService.getAll());
    }

    @PreAuthorize("hasAuthority('btn.sysDept.remove')")
    @ApiOperation(value = "删除")
    @DeleteMapping("/removeById/{id}")
    public Result removeById(
            @PathVariable Long id
    ) {
        if (sysDeptService.removeById(id)) {
            return Result.ok();
        } else {
            return Result.fail();
        }
    }

}
```



### 1.3 服务接口

```java
package com.atguigu.system.service;

import com.atguigu.model.system.SysDept;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 组织机构 服务类
 * </p>
 *
 * @author 陈江林
 * @since 2022-11-25
 */
public interface SysDeptService extends IService<SysDept> {

    /**
     * 列表(树形)
     *
     * @return {@link List}<{@link SysDept}>
     */
    List<SysDept> getAll();

}
```



### 1.4 服务实现

```java
package com.atguigu.system.service.impl;

import com.atguigu.common.utils.DeptHelper;
import com.atguigu.model.system.SysDept;
import com.atguigu.system.mapper.SysDeptMapper;
import com.atguigu.system.service.SysDeptService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 组织机构 服务实现类
 * </p>
 *
 * @author 陈江林
 * @since 2022-11-25
 */
@Service
public class SysDeptServiceImpl extends ServiceImpl<SysDeptMapper, SysDept> implements SysDeptService {

    @Override
    public List<SysDept> getAll() {
        List<SysDept> sysDeptList = baseMapper.selectList(null);
        return DeptHelper.buildTree(sysDeptList);
    }

}
```



## 2 前端

### 2.1 新建`sysDept/list.vue`

```vue
<template>
  <div>
    <!-- 卡片视图区域 -->
    <el-card>
      <el-row>
        <el-col>
          <el-button type="primary" :disabled="$hasBP('btn.sysDept.add')" @click="openSaveDialog()">添加部门</el-button>
        </el-col>
      </el-row>

      <!-- 表格 -->
      <el-table
        :data="list"
        style="width: 100%"
        row-key="id"
        border
        :tree-props="{children: 'children'}"
      >
        <el-table-column prop="name" label="名称" />
        <el-table-column prop="leader" label="项目负责人" width="160" />
        <el-table-column prop="phone" label="部门电话" width="180" />
        <el-table-column label="状态" width="80">
          <template slot-scope="scope">
            <el-switch
              :value="scope.row.status === 1"
              disabled
            />
          </template>
        </el-table-column>
        <el-table-column prop="createTime" label="创建时间" width="200" />
        <el-table-column label="操作" width="200" align="center">
          <template slot-scope="scope">
            <el-button
              type="success"
              icon="el-icon-plus"
              size="mini"
              title="添加下级部门"
              :disabled="$hasBP('btn.sysDept.add')"
              @click="openSaveDialog(scope.row)"
            />
            <el-button
              type="primary"
              icon="el-icon-edit"
              size="mini"
              title="修改"
              :disabled="$hasBP('btn.sysDept.update')"
              @click="openUpdateDialog(scope.row)"
            />
            <el-button
              type="danger"
              icon="el-icon-delete"
              size="mini"
              title="删除"
              :disabled="scope.row.hasChildren || $hasBP('btn.sysDept.remove')"
              @click="removeById(scope.row)"
            />
          </template>
        </el-table-column>
      </el-table>
    </el-card>

    <!-- 添加/修改对话框 -->
    <el-dialog
      :title="dialogTitle"
      :visible.sync="addOrUpdateDialogFormVisible"
      width="50%"
      @close="saveOrUpdateDialogClose"
    >
      <el-form ref="addOrUpdateForm" :model="sysDept" :rules="sysDeptRules" label-width="80px">
        <el-form-item v-if="sysDept.id === '' && sysDept.parentId !== 0" label="上级部门">
          <el-input v-model="sysDept.parentName" disabled />
        </el-form-item>
        <el-form-item label="名称" prop="name">
          <el-input v-model="sysDept.name" />
        </el-form-item>
        <el-form-item label="负责人" prop="leader">
          <el-input v-model="sysDept.leader" />
        </el-form-item>
        <el-form-item label="电话" prop="phone">
          <el-input v-model="sysDept.phone" />
        </el-form-item>
        <el-form-item label="状态" prop="type">
          <el-radio-group v-model="sysDept.status">
            <el-radio :label="1">正常</el-radio>
            <el-radio :label="0">停用</el-radio>
          </el-radio-group>
        </el-form-item>
      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button @click="addOrUpdateDialogFormVisible = false">取 消</el-button>
        <el-button type="primary" @click="saveOrUpdate()">确 定</el-button>
      </div>
    </el-dialog>
  </div>
</template>

<script>
import { save, update, getById, getAll, removeById } from '@/api/system/dept'
import { checkPhone } from '@/utils/validate'

const sysDeptObj = {
  id: '',
  parentId: '',
  parentName: '',
  name: '',
  leader: '',
  phone: '',
  status: 1
}

export default {
  // 定义数据
  data() {
    const validatorPhone = (rule, value, callback) => {
      if (!checkPhone(value)) {
        callback(new Error('请输入合法的手机号'))
      } else {
        callback()
      }
    }
    return {
      list: [],

      /* 添加/修改对话框 */
      // 对话框标题
      dialogTitle: '',
      // 控制添加/修改对话框显示或隐藏(默认)
      addOrUpdateDialogFormVisible: false,
      // 表单对象
      sysDept: JSON.parse(JSON.stringify(sysDeptObj)),
      sysDeptRules: {
        name: [{ required: true, message: '请输入名称', trigger: 'blur' }],
        leader: [{ required: true, message: '请输入负责人', trigger: 'blur' }],
        phone: [{ required: true, trigger: 'blur', validator: validatorPhone }]
      }
    }
  },

  // 当页面加载时获取数据
  created() {
    this.getList()
  },

  methods: {
    // 调用api层获取数据库中的数据
    getList() {
      getAll().then(res => {
        this.list = res.data
      })
    },

    /* ========= start - 添加/修改对话框 ========= */
    // 关闭对话框
    saveOrUpdateDialogClose() {
      this.sysDept = JSON.parse(JSON.stringify(sysDeptObj))
    },
    // 打开保存对话框
    openSaveDialog(row) {
      if (row) {
        this.sysDept.parentId = row.id
        this.sysDept.parentName = row.name
        // 对话框标题
        this.dialogTitle = '添加子部门'
      } else {
        // 对话框标题
        this.dialogTitle = '添加部门'
        this.sysDept.parentId = 0
      }

      // 打开对话框
      this.addOrUpdateDialogFormVisible = true
    },
    // 打开修改对话框
    openUpdateDialog(row) {
      // 根据id获取对象
      getById(row.id).then(res => {
        // 保存表单数据
        this.sysDept = res.data
        // 对话框标题
        this.dialogTitle = '修改菜单'
        // 打开对话框
        this.addOrUpdateDialogFormVisible = true
      })
    },
    // 保存或删除
    saveOrUpdate() {
      // 校验表单
      this.$refs.addOrUpdateForm.validate(valid => {
        if (valid) {
          if (!this.sysDept.id) {
            // 无id保存
            this.save()
          } else {
            // 有id修改
            this.update()
          }
        }
      })
    },
    // 调用API保存
    save() {
      save(this.sysDept).then(res => {
        // 关闭对话框
        this.addOrUpdateDialogFormVisible = false
        // 提示
        this.$message.success('保存成功')
        // 刷新数据
        this.getList()
      })
    },
    // 调用API修改
    update() {
      update(this.sysDept).then(res => {
        // 关闭对话框
        this.addOrUpdateDialogFormVisible = false
        // 提示
        this.$message.success('修改成功')
        // 刷新数据
        this.getList()
      })
    },
    /* ========= end - 添加/修改对话框 ========= */

    // 根据id删除数据
    removeById(row) {
      // 弹框询问用户是否删除数据
      this.$confirm('此操作将永久删除该数据, 是否继续?', '提示', {
        confirmButtonText: '确定',
        cancelButtonText: '取消',
        type: 'warning'
      }).then(() => {
        removeById(row.id).then(res => {
          // 提示
          this.$message.success('删除成功!')
          // 刷新数据
          this.getList()
        })
      }).catch(() => {
        this.$message({
          type: 'info',
          message: '已取消删除'
        })
      })
    }
  }
}
</script>
```

## 

### 2.2 新建`API`

```javascript
import request from '@/utils/request'

const api_name = '/admin/system/sysDept'

// 保存
export function save(data) {
  return request({
    url: `${api_name}/save`,
    method: 'post',
    data
  })
}

// 修改
export function update(data) {
  return request({
    url: `${api_name}/update`,
    method: 'put',
    data
  })
}

// 根据 id 获取信息
export function getById(id) {
  return request({
    url: `${api_name}/getById/${id}`,
    method: 'get'
  })
}

// 列表
export function getAll() {
  return request({
    url: `${api_name}/getAll`,
    method: 'get'
  })
}

// 根据 id 删除
export function removeById(id) {
  return request({
    url: `${api_name}/removeById/${id}`,
    method: 'delete'
  })
}
```



### 2.3 表单规则 `@/utils/validate`

```javascript
/**
 * Created by PanJiaChen on 16/11/18.
 */

/**
 * @param {string} path
 * @returns {Boolean}
 */
export function isExternal(path) {
  return /^(https?:|mailto:|tel:)/.test(path)
}

/**
 * @param {string} str
 * @returns {Boolean}
 */
export function validUsername(str) {
  // const valid_map = ['admin', 'editor']
  return str.trim().length > 0
}

/**
 * 验证手机号的规则
 *
 * @param {string} moble
 * @returns {Boolean}
 */
export function checkPhone(phone) {
  // 验证手机号的正则表达式
  return /^(0|86|17951)?(13[0-9]|15[0123456789]|17[678]|18[0-9]|14[57])[0-9]{8}$/.test(phone)
}
```


# 九 岗位管理

```
git checkout -b 9.0.0_post
```

![img](https://cdn.nlark.com/yuque/0/2022/png/12811585/1669426846492-86b95242-f2bd-4340-94f2-15415a27a677.png)



## 1 后端

### 1.1 代码生成器，数据库表`sys_post`

![img](https://cdn.nlark.com/yuque/0/2022/png/12811585/1669379667138-2ac1ba7d-aaeb-4be2-bac4-17b1763e5d87.png)

### 1.2 控制类

```java
package com.atguigu.system.controller;


import com.atguigu.common.result.Result;
import com.atguigu.model.system.SysPost;
import com.atguigu.model.vo.SysPostQueryVo;
import com.atguigu.system.service.SysPostService;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 * 岗位信息表 前端控制器
 * </p>
 *
 * @author 陈江林
 * @since 2022-11-25
 */
@Api(tags = "岗位管理接口")
@RestController
@RequestMapping("/admin/system/sysPost")
public class SysPostController {

    @Autowired
    private SysPostService sysPostService;

    @PreAuthorize("hasAuthority('btn.sysPost.add')")
    @ApiOperation(value = "保存")
    @PostMapping("/save")
    public Result save(
            @RequestBody SysPost sysPost
    ) {
        if (sysPostService.save(sysPost)) {
            return Result.ok();
        } else {
            return Result.fail();
        }
    }

    @PreAuthorize("hasAuthority('btn.sysPost.update')")
    @ApiOperation(value = "修改")
    @PutMapping("/update")
    public Result update(
            @RequestBody SysPost sysPost
    ) {
        if (sysPostService.updateById(sysPost)) {
            return Result.ok();
        } else {
            return Result.fail();
        }
    }

    @PreAuthorize("hasAuthority('btn.sysPost.update')")
    @ApiOperation(value = "修改状态")
    @PutMapping("/update/{id}/{status}")
    public Result update(
            @PathVariable Long id,
            @PathVariable Integer status
    ) {
        SysPost sysPost = sysPostService.getById(id);
        sysPost.setStatus(status);
        if (sysPostService.updateById(sysPost)) {
            return Result.ok();
        } else {
            return Result.fail();
        }
    }

    @PreAuthorize("hasAuthority('btn.sysPost.list')")
    @ApiOperation(value = "根据id获取数据")
    @GetMapping("/getById/{id}")
    public Result<SysPost> getById(
            @PathVariable Long id
    ) {
        return Result.ok(sysPostService.getById(id));
    }

    @PreAuthorize("hasAuthority('btn.sysPost.list')")
    @ApiOperation(value = "分页查询")
    @GetMapping("/{page}/{limit}")
    public Result<IPage<SysPost>> getPage(
            @PathVariable Long page,
            @PathVariable Long limit,
            SysPostQueryVo sysPostQueryVo
    ) {
        return Result.ok(sysPostService.getPage(new Page<>(page, limit), sysPostQueryVo));
    }

    @PreAuthorize("hasAuthority('btn.sysPost.remove')")
    @ApiOperation(value = "删除")
    @DeleteMapping("/removeById/{id}")
    public Result removeById(
            @PathVariable Long id
    ) {
        if (sysPostService.removeById(id)) {
            return Result.ok();
        } else {
            return Result.fail();
        }
    }

}
```



### 1.3 服务接口

```java
package com.atguigu.system.service;

import com.atguigu.model.system.SysPost;
import com.atguigu.model.vo.SysPostQueryVo;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 岗位信息表 服务类
 * </p>
 *
 * @author 陈江林
 * @since 2022-11-25
 */
public interface SysPostService extends IService<SysPost> {

    /**
     * 分页查询
     *
     * @param objectPage
     * @param sysPostQueryVo 条件对象
     * @return {@link IPage}<{@link SysPost}>
     */
    IPage<SysPost> getPage(Page<Object> objectPage, SysPostQueryVo sysPostQueryVo);
}
```



### 1.4 服务实现

```java
package com.atguigu.system.service.impl;

import com.atguigu.model.system.SysPost;
import com.atguigu.model.vo.SysPostQueryVo;
import com.atguigu.system.mapper.SysPostMapper;
import com.atguigu.system.service.SysPostService;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 岗位信息表 服务实现类
 * </p>
 *
 * @author 陈江林
 * @since 2022-11-25
 */
@Service
public class SysPostServiceImpl extends ServiceImpl<SysPostMapper, SysPost> implements SysPostService {

    @Override
    public IPage<SysPost> getPage(Page<Object> objectPage, SysPostQueryVo sysPostQueryVo) {
        return baseMapper.selectPage(objectPage, sysPostQueryVo);
    }

}
```



### 1.5 `Mapper`接口

```java
package com.atguigu.system.mapper;

import com.atguigu.model.system.SysPost;
import com.atguigu.model.vo.SysPostQueryVo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Param;

/**
 * <p>
 * 岗位信息表 Mapper 接口
 * </p>
 *
 * @author 陈江林
 * @since 2022-11-25
 */
public interface SysPostMapper extends BaseMapper<SysPost> {

    /**
     * 分页查询
     *
     * @param objectPage
     * @param sysPostQueryVo 条件对象
     * @return {@link IPage}<{@link SysPost}>
     */
    IPage<SysPost> selectPage(Page<Object> objectPage,@Param("vo") SysPostQueryVo sysPostQueryVo);

}
```



### 1.6 `Mapper.xml`

```xml
<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE mapper PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN" "http://mybatis.org/dtd/mybatis-3-mapper.dtd">
<mapper namespace="com.atguigu.system.mapper.SysPostMapper">
    <!-- Integer 类型只做null判断 -->
    <select id="selectPage" resultType="com.atguigu.model.system.SysPost">
        select id,
        post_code,
        name,
        description,
        status,
        create_time,
        update_time,
        is_deleted
        from sys_post
        <where>
            <if test="vo.name != null and vo.name != ''">
                and name = #{vo.name}
            </if>
            <if test="vo.postCode != null and vo.postCode != ''">
                and post_code = #{vo.postCode}
            </if>
            <if test="vo.status != null">
                and status = #{vo.status}
            </if>
            and is_deleted = 0
        </where>

    </select>
</mapper>
```



## 2 前端

### 2.1 新建`sysPost/list.vue`

```vue
<template>
  <div>
    <!-- 卡片视图区域 -->
    <el-card>
      <el-row :gutter="22">
        <el-col :span="6">
          <el-input
            v-model="searchObj.name"
            placeholder="请输入岗位名称"
            class="input-with-select"
            clearable
            @clear="getList"
          >
            <el-button slot="append" icon="el-icon-search" @click="getList" />
          </el-input>
        </el-col>
        <el-col :span="6">
          <el-input
            v-model="searchObj.postCode"
            placeholder="请输入岗位编号"
            class="input-with-select"
            clearable
            @clear="getList"
          >
            <el-button slot="append" icon="el-icon-search" @click="getList" />
          </el-input>
        </el-col>
        <el-col :span="4">
          <el-select v-model="searchObj.status" placeholder="请选择" @change="getList">
            <el-option
              v-for="item in options"
              :key="item.value"
              :label="item.label"
              :value="item.value"
            />
          </el-select>
        </el-col>
        <el-col :span="6">
          <el-button type="primary" :disabled="$hasBP('btn.sysPost.add')" @click="openSaveDialog()">添加用户</el-button>
        </el-col>
      </el-row>

      <!-- 表格 -->
      <el-table
        :data="list"
        style="width: 100%"
        border
      >
        <el-table-column
          label="序号"
          width="70"
          align="center"
        >
          <template slot-scope="scope">
            {{ (page - 1) * limit + scope.$index + 1 }}
          </template>
        </el-table-column>
        <el-table-column prop="name" label="岗位名称" />
        <el-table-column prop="postCode" label="岗位编码" width="160" />
        <el-table-column label="状态" width="80">
          <template slot-scope="scope">
            <el-switch
              :value="scope.row.status === 1"
              :disabled="$hasBP('btn.sysPost.update')"
              @change="switchStatus(scope.row)"
            />
          </template>
        </el-table-column>
        <el-table-column prop="createTime" label="创建时间" width="200" />
        <el-table-column label="操作" width="200" align="center">
          <template slot-scope="scope">
            <el-button
              type="primary"
              icon="el-icon-edit"
              size="mini"
              title="修改"
              :disabled="$hasBP('btn.sysPost.update')"
              @click="openUpdateDialog(scope.row)"
            />
            <el-button
              type="danger"
              icon="el-icon-delete"
              size="mini"
              title="删除"
              :disabled="$hasBP('btn.sysPost.remove')"
              @click="removeById(scope.row)"
            />
          </template>
        </el-table-column>
      </el-table>
    </el-card>

    <!-- 添加/修改对话框 -->
    <el-dialog
      :title="dialogTitle"
      :visible.sync="addOrUpdateDialogFormVisible"
      width="50%"
      @close="saveOrUpdateDialogClose"
    >
      <el-form ref="addOrUpdateForm" :model="sysPost" :rules="sysPostRules" label-width="80px">
        <el-form-item label="岗位名称" prop="name">
          <el-input v-model="sysPost.name" />
        </el-form-item>
        <el-form-item label="岗位编码" prop="postCode">
          <el-input v-model="sysPost.postCode" />
        </el-form-item>
        <el-form-item label="状态" prop="type">
          <el-radio-group v-model="sysPost.status">
            <el-radio :label="1">正常</el-radio>
            <el-radio :label="0">停用</el-radio>
          </el-radio-group>
        </el-form-item>
      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button @click="addOrUpdateDialogFormVisible = false">取 消</el-button>
        <el-button type="primary" @click="saveOrUpdate()">确 定</el-button>
      </div>
    </el-dialog>
  </div>
</template>

<script>
import { save, update, updateStatus, getById, getPageList, removeById } from '@/api/system/post'

const sysPostObj = {
  id: '',
  name: '',
  postCode: '',
  status: 1
}

export default {
  // 定义数据
  data() {
    return {
      list: [],
      // 总记录数
      total: 0,
      // 当前页
      page: 1,
      // 每页显示记录数
      limit: 10,
      // 条件查询封装对象
      searchObj: {
        name: '',
        postCode: '',
        status: ''
      },
      options: [
        {
          value: '',
          label: '全部'
        }, {
          value: '1',
          label: '正常'
        }, {
          value: '0',
          label: '停用'
        }],

      /* 添加/修改对话框 */
      // 对话框标题
      dialogTitle: '',
      // 控制添加/修改对话框显示或隐藏(默认)
      addOrUpdateDialogFormVisible: false,
      // 表单对象
      sysPost: JSON.parse(JSON.stringify(sysPostObj)),
      sysPostRules: {
        name: [{ required: true, message: '请输入岗位名称', trigger: 'blur' }],
        postCode: [{ required: true, message: '请输入岗位编码', trigger: 'blur' }]
      }
    }
  },

  // 当页面加载时获取数据
  created() {
    this.getList()
  },

  methods: {
    // 调用api层获取数据库中的数据
    getList() {
      getPageList(this.page, this.limit, this.searchObj).then(res => {
        this.list = res.data.records
        this.total = res.data.total
      })
    },

    /* ========= start - 添加/修改对话框 ========= */
    // 关闭对话框
    saveOrUpdateDialogClose() {
      this.sysPost = JSON.parse(JSON.stringify(sysPostObj))
    },
    // 打开保存对话框
    openSaveDialog(row) {
      if (row) {
        this.sysPost.parentId = row.id
        this.sysPost.parentName = row.name
        // 对话框标题
        this.dialogTitle = '添加子部门'
      } else {
        // 对话框标题
        this.dialogTitle = '添加部门'
        this.sysPost.parentId = 0
      }

      // 打开对话框
      this.addOrUpdateDialogFormVisible = true
    },
    // 打开修改对话框
    openUpdateDialog(row) {
      // 根据id获取对象
      getById(row.id).then(res => {
        // 保存表单数据
        this.sysPost = res.data
        // 对话框标题
        this.dialogTitle = '修改菜单'
        // 打开对话框
        this.addOrUpdateDialogFormVisible = true
      })
    },
    // 保存或删除
    saveOrUpdate() {
      // 校验表单
      this.$refs.addOrUpdateForm.validate(valid => {
        if (valid) {
          if (!this.sysPost.id) {
            // 无id保存
            this.save()
          } else {
            // 有id修改
            this.update()
          }
        }
      })
    },
    // 调用API保存
    save() {
      save(this.sysPost).then(res => {
        // 关闭对话框
        this.addOrUpdateDialogFormVisible = false
        // 提示
        this.$message.success('保存成功')
        // 刷新数据
        this.getList()
      })
    },
    // 调用API修改
    update() {
      update(this.sysPost).then(res => {
        // 关闭对话框
        this.addOrUpdateDialogFormVisible = false
        // 提示
        this.$message.success('修改成功')
        // 刷新数据
        this.getList()
      })
    },
    /* ========= end - 添加/修改对话框 ========= */

    // 根据id删除数据
    removeById(row) {
      // 弹框询问用户是否删除数据
      this.$confirm('此操作将永久删除该数据, 是否继续?', '提示', {
        confirmButtonText: '确定',
        cancelButtonText: '取消',
        type: 'warning'
      }).then(() => {
        removeById(row.id).then(res => {
          // 提示
          this.$message.success('删除成功!')
          // 刷新数据
          this.getList()
        })
      }).catch(() => {
        this.$message({
          type: 'info',
          message: '已取消删除'
        })
      })
    },
    // 切换状态
    switchStatus(row) {
      row.status = row.status === 1 ? 0 : 1
      updateStatus(row.id, row.status).then(res => {
        this.$message.success('操作成功')
        this.getList()
      })
    }
  }
}
</script>
```

## 

### 2.2 新建`API`

```javascript
import request from '@/utils/request'

const api_name = '/admin/system/sysPost'

// 保存
export function save(data) {
  return request({
    url: `${api_name}/save`,
    method: 'post',
    data
  })
}

// 修改
export function update(data) {
  return request({
    url: `${api_name}/update`,
    method: 'put',
    data
  })
}

// 修改状态
export function updateStatus(id, status) {
  return request({
    url: `${api_name}/update/${id}/${status}`,
    method: 'put'
  })
}

// 根据 id 获取信息
export function getById(id) {
  return request({
    url: `${api_name}/getById/${id}`,
    method: 'get'
  })
}

// 列表
export function getPageList(page, limit, params) {
  return request({
    url: `${api_name}/${page}/${limit}`,
    method: 'get',
    params
  })
}

// 根据 id 删除
export function removeById(id) {
  return request({
    url: `${api_name}/removeById/${id}`,
    method: 'delete'
  })
}
```


# 十 日志记录

```
git checkout -b 10.0.0_log
```

## 1 后端功能实现-登录日志

### 1.1 在`spring-security`模块创建`AsyncLoginLogService`

```java
package com.atguigu.system.service;

/**
 * 登录日志 服务接口类
 *
 * @author 陈江林
 * @date 2022/11/26 10:55
 */
public interface LoginLogService {

    /**
     * 保存登录日志
     *
     * @param username 用户名
     * @param status   状态
     * @param ipaddr   ip地址
     * @param message  消息
     */
    void saveLoginLog(String username, Integer status, String ipaddr, String message);

}
```



### 1.2 在`service-system`实现添加日志方法

```java
package com.atguigu.system.service.impl;

import com.atguigu.model.system.SysLoginLog;
import com.atguigu.system.mapper.LoginLogMapper;
import com.atguigu.system.service.LoginLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 登录日志 服务实现类
 *
 * @author 陈江林
 * @date 2022/11/26 11:10
 */
@Service
public class LoginLogServiceImpl implements LoginLogService {

    @Autowired
    private LoginLogMapper loginLogMapper;

    @Override
    public void saveLoginLog(String username, Integer status, String ipaddr, String message) {
        SysLoginLog sysLoginLog = new SysLoginLog();
        sysLoginLog.setUsername(username);
        sysLoginLog.setStatus(status);
        sysLoginLog.setIpaddr(ipaddr);
        sysLoginLog.setMsg(message);
        loginLogMapper.insert(sysLoginLog);
    }

}
```



### 1.3 在`TokenLoginFilter`调用方法实现

- 关键代码

```java
// 登录日志
loginLogService.saveLoginLog(customUser.getUsername(), 1,
        IpUtil.getIpAddress(request), "登录成功");
package com.atguigu.system.filter;

import com.alibaba.fastjson.JSON;
import com.atguigu.common.result.Result;
import com.atguigu.common.result.ResultCodeEnum;
import com.atguigu.common.utils.IpUtil;
import com.atguigu.common.utils.JwtHelper;
import com.atguigu.common.utils.ResponseUtil;
import com.atguigu.model.vo.LoginVo;
import com.atguigu.system.custom.CustomUser;
import com.atguigu.system.service.LoginLogService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * @author 陈江林
 * @date 2022/11/23 00:14
 */
public class TokenLoginFilter extends UsernamePasswordAuthenticationFilter {

    private RedisTemplate redisTemplate;

    private LoginLogService loginLogService;

    public TokenLoginFilter(AuthenticationManager authenticationManager,
                            RedisTemplate redisTemplate,
                            LoginLogService loginLogService) {
        this.setAuthenticationManager(authenticationManager);
        this.setPostOnly(false);
        // 指定登录接口及提交方式，可以指定任意路径
        this.setRequiresAuthenticationRequestMatcher(
                new AntPathRequestMatcher("/admin/system/index/login", "POST")
        );
        this.redisTemplate = redisTemplate;
        this.loginLogService = loginLogService;
    }

    /**
     * 登录认证
     *
     * @param req
     * @param res
     * @return
     * @throws AuthenticationException
     */
    @Override
    public Authentication attemptAuthentication(HttpServletRequest req, HttpServletResponse res)
            throws AuthenticationException {
        try {
            LoginVo loginVo = new ObjectMapper().readValue(req.getInputStream(), LoginVo.class);
            Authentication authenticationToken = new UsernamePasswordAuthenticationToken(loginVo.getUsername(), loginVo.getPassword());
            return this.getAuthenticationManager().authenticate(authenticationToken);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 登录成功
     *
     * @param request
     * @param response
     * @param chain
     * @param auth
     * @throws IOException
     * @throws ServletException
     */
    @Override
    protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain,
                                            Authentication auth) throws IOException, ServletException {
        // 获取认证对象
        CustomUser customUser = (CustomUser) auth.getPrincipal();
        // 保存权限数据
        redisTemplate.opsForValue().set(customUser.getUsername(),
                JSON.toJSONString(customUser.getAuthorities()));
        // 生成 token
        String token = JwtHelper.createToken(customUser.getSysUser().getId(), customUser.getSysUser().getUsername());
        // 登录日志
        loginLogService.saveLoginLog(customUser.getUsername(), 1,
                IpUtil.getIpAddress(request), "登录成功");
        // 返回
        Map<String, Object> map = new HashMap<>();
        map.put("token", token);
        ResponseUtil.out(response, Result.ok(map));
    }

    /**
     * 登录失败
     *
     * @param request
     * @param response
     * @param e
     */
    @Override
    protected void unsuccessfulAuthentication(HttpServletRequest request, HttpServletResponse response,
                                              AuthenticationException e) {
        if (e.getCause() instanceof RuntimeException) {
            ResponseUtil.out(response, Result.build(null, 204, e.getMessage()));
        } else {
            ResponseUtil.out(response, Result.build(null, ResultCodeEnum.LOGIN_MOBLE_ERROR));
        }
    }

}
```



### 1.4 配置`WebSecurityConfig`

- 关键代码

```java
.addFilter(new TokenLoginFilter(authenticationManager(), redisTemplate, loginLogService));
package com.atguigu.system.config;

import com.atguigu.system.filter.TokenAuthenticationFilter;
import com.atguigu.system.filter.TokenLoginFilter;
import com.atguigu.system.service.LoginLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

/**
 * Spring Security 配置类
 * `@EnableGlobalMethodSecurity(prePostEnabled = true)`：开启注解功能，默认禁用注解
 *
 * @author 陈江林
 * @date 2022/11/21 21:33
 */
@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private RedisTemplate redisTemplate;

    @Autowired
    private LoginLogService loginLogService;

    /**
     * 加密方式
     *
     * @return {@link PasswordEncoder}
     */
    @Bean
    public PasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        // 这是配置的关键，决定哪些接口开启防护，哪些接口绕过防护
        http
                // 关闭csrf
                .csrf().disable()
                // 开启跨域以便前端调用接口
                .cors().and()
                .authorizeRequests()
                // 指定某些接口不需要通过验证即可访问。登陆接口肯定是不需要认证的
                .antMatchers("/admin/system/index/login").permitAll()
                // 这里意思是其它所有接口需要认证才能访问
                .anyRequest().authenticated()
                .and()
                // TokenAuthenticationFilter放到UsernamePasswordAuthenticationFilter的前面，这样做就是为了除了登录的时候去查询数据库外，其他时候都用token进行认证。
                .addFilterBefore(new TokenAuthenticationFilter(redisTemplate), UsernamePasswordAuthenticationFilter.class)
                .addFilter(new TokenLoginFilter(authenticationManager(), redisTemplate, loginLogService));

        // 禁用session
        http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
    }

    /**
     * 配置哪些请求不拦截
     * 排除swagger相关请求
     *
     * @param web
     */
    @Override
    public void configure(WebSecurity web) {
        web.ignoring().antMatchers("/favicon.ico", "/swagger-resources/**", "/webjars/**", "/v2/**", "/swagger-ui.html/**", "/doc.html");
    }
}
```



### 1.5 测试登录

- 登录
- 查看数据库



## 2 功能实现-登录日志接口`SysLoginLogController`

```java
package com.atguigu.system.controller;

import com.atguigu.common.result.Result;
import com.atguigu.model.system.SysLoginLog;
import com.atguigu.model.vo.SysLoginLogQueryVo;
import com.atguigu.system.service.SysLoginLogService;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * 登录日志 控制类
 *
 * @author 陈江林
 * @date 2022/11/27 01:11
 */
@Api(tags = "登录日志接口")
@RestController
@RequestMapping(value = "/admin/system/sysLoginLog")
public class SysLoginLogController {

    @Autowired
    private SysLoginLogService sysLoginLogService;

    @PreAuthorize("hasAuthority('btn.sysLoginLog.list')")
    @ApiOperation(value = "获取分页列表")
    @GetMapping("/{page}/{limit}")
    public Result<IPage<SysLoginLog>> index(
            @ApiParam(name = "page", value = "当前页码", required = true)
            @PathVariable Long page,

            @ApiParam(name = "limit", value = "每页记录数", required = true)
            @PathVariable Long limit,

            @ApiParam(name = "sysLoginLogQueryVo", value = "查询对象")
                    SysLoginLogQueryVo sysLoginLogQueryVo) {
        return Result.ok(sysLoginLogService.getPage(new Page<>(page, limit), sysLoginLogQueryVo));
    }

}
```

- 服务接口

```java
public interface SysLoginLogService extends IService<SysLoginLog> {
	//列表显示
    IPage<SysLoginLog> selectPage(Page<SysLoginLog> pageParam, SysLoginLogQueryVo sysLoginLogQueryVo);
}
```

- 服务实现

```java
@Service
@SuppressWarnings({"unchecked", "rawtypes"})
public class SysLoginLogServiceImpl extends ServiceImpl<SysLoginLogMapper, SysLoginLog> implements SysLoginLogService {

	@Resource
	private SysLoginLogMapper sysLoginLogMapper;

	@Override
	public IPage<SysLoginLog> selectPage(Page<SysLoginLog> pageParam, SysLoginLogQueryVo sysLoginLogQueryVo) {
		return sysLoginLogMapper.selectPage(pageParam, sysLoginLogQueryVo);
	}
}
```

- `Mapper`接口

```java
@Mapper
@Repository
public interface SysLoginLogMapper extends BaseMapper<SysLoginLog> {

    IPage<SysLoginLog> selectPage(Page<SysLoginLog> page, @Param("vo") SysLoginLogQueryVo sysLoginLogQueryVo);
}
```

- `xml`

```xml
<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE mapper PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN" "http://mybatis.org/dtd/mybatis-3-mapper.dtd">

<mapper namespace="com.atguigu.system.mapper.SysLoginLogMapper">

	<resultMap id="sysLoginLogMap" type="com.atguigu.model.system.SysLoginLog" autoMapping="true">
	</resultMap>
	
	<!-- 用于select查询公用抽取的列 -->
	<sql id="columns">
		id,username,ipaddr,status,msg,access_time,create_time,update_time,is_deleted
	</sql>
	
	<sql id="findPageWhere">
		<where>	      				
	       <if test="vo.username != null and vo.username != ''">
				and username = #{vo.username}
			</if>
	       <if test="vo.createTimeBegin != null and vo.createTimeBegin != ''">
				and create_time >= #{vo.createTimeBegin}
		   </if>
		   <if test="vo.createTimeEnd != null and vo.createTimeEnd != ''">
				and create_time &lt;= #{vo.createTimeEnd}
		   </if>
			and is_deleted = 0
		</where>
	</sql>
    
    <select id="selectPage1" resultMap="sysLoginLogMap">
    	select <include refid="columns" />
	    from sys_login_log
		<include refid="findPageWhere"/>
		order by id desc
    </select>
</mapper>
```



## 3 前端显示登录日志

![img](https://cdn.nlark.com/yuque/0/2022/png/12811585/1669490811951-a4ee1366-e642-48d8-a250-0d03dfd48c9b.png)

### 3.1 新建`views/sysLoginLog/list.vue`

![img](https://cdn.nlark.com/yuque/0/2022/png/12811585/1669490855110-3ba839c0-4c36-4842-890f-d214e27b421e.png)

```vue
<template>
  <div>
    <el-card>
      <el-row :gutter="22">
        <el-col :span="6">
          <el-input
            v-model="searchObj.username"
            placeholder="请输入登录账号"
            class="input-with-select"
            clearable
            @clear="getList"
          >
            <el-button slot="append" icon="el-icon-search" @click="getList" />
          </el-input>
        </el-col>
        <el-col :span="8">
          <el-date-picker
            v-model="createTimes"
            type="daterange"
            align="right"
            unlink-panels
            range-separator="至"
            start-placeholder="开始日期"
            end-placeholder="结束日期"
            value-format="yyyy-MM-dd HH:mm:ss"
            :picker-options="pickerOptions"
          />
        </el-col>
      </el-row>

      <!-- table 表格区域 -->
      <el-table
        :data="list"
        border
        stripe
      >
        <el-table-column label="序号" width="70" align="center">
          <template slot-scope="scope">
            {{ (page - 1) * limit + scope.$index + 1 }}
          </template>
        </el-table-column>
        <el-table-column prop="username" label="登录账号" />
        <el-table-column prop="ipaddr" label="登录IP地址" />
        <el-table-column prop="status" label="状态">
          <template slot-scope="scope">
            <el-tag :type="scope.row.status === '0' ? 'primary' : 'success'">
              {{ scope.row.status === '0' ? '失败' : '成功' }}
            </el-tag>
          </template>
        </el-table-column>
        <el-table-column prop="msg" label="提示信息" />
        <el-table-column prop="createTime" label="创建时间" />
      </el-table>

      <!-- 分页区域 -->
      <el-pagination
        :current-page="page"
        :page-sizes="[5, 10, 15, 20]"
        :page-size="limit"
        layout="total, sizes, prev, pager, next, jumper"
        :total="total"
        background
        @size-change="handleSizeChange"
        @current-change="handleCurrentChange"
      />
    </el-card>
  </div>
</template>

<script>
import { getPageList } from '@/api/system/loginLog'

export default {
  name: 'List',
  data() {
    return {
      // 用户列表
      list: [],
      // 总记录数
      total: 0,
      // 当前页
      page: 1,
      // 每页显示记录数
      limit: 10,
      // 时间条件
      createTimes: [],
      // 条件查询封装对象
      searchObj: {
        username: '',
        createTimeBegin: '',
        createTimeEnd: ''
      },
      pickerOptions: {
        shortcuts: [{
          text: '最近一周',
          onClick(picker) {
            const end = new Date()
            const start = new Date()
            start.setTime(start.getTime() - 3600 * 1000 * 24 * 7)
            picker.$emit('pick', [start, end])
          }
        }, {
          text: '最近一个月',
          onClick(picker) {
            const end = new Date()
            const start = new Date()
            start.setTime(start.getTime() - 3600 * 1000 * 24 * 30)
            picker.$emit('pick', [start, end])
          }
        }, {
          text: '最近三个月',
          onClick(picker) {
            const end = new Date()
            const start = new Date()
            start.setTime(start.getTime() - 3600 * 1000 * 24 * 90)
            picker.$emit('pick', [start, end])
          }
        }]
      }
    }
  },
  watch: {
    createTimes(newValue) {
      if (newValue && newValue.length === 2) {
        // 选择时间
        this.searchObj.createTimeBegin = newValue[0]
        this.searchObj.createTimeEnd = newValue[1]
      } else {
        // 取消时间
        this.searchObj.createTimeBegin = ''
        this.searchObj.createTimeEnd = ''
      }

      this.getList()
    }
  },
  created() {
    this.getList()
  },
  methods: {
    // 获取列表数据
    getList() {
      getPageList(this.page, this.limit, this.searchObj).then(res => {
        this.list = res.data.records
        this.total = res.data.total
      })
    },
    handleSizeChange(newSize) {
      this.limit = newSize
      this.getList()
    },
    handleCurrentChange(newPage) {
      this.page = newPage
      this.getList()
    }
  }
}
</script>

<style scoped>

</style>
```



### 3.2 `API`

![img](https://cdn.nlark.com/yuque/0/2022/png/12811585/1669490899379-770330e1-629e-4d80-ab17-c7c4a894a23c.png)

```javascript
import request from '@/utils/request'

const api_name = '/admin/system/sysLoginLog'

// 列表
export function getPageList(page, limit, params) {
  return request({
    url: `${api_name}/${page}/${limit}`,
    method: 'get',
    params
  })
}
```



## 4 操作日志

### 4.1 页面效果

![img](https://cdn.nlark.com/yuque/0/2022/png/12811585/1669495514719-dbacf943-aeb3-4fd4-9f33-c40ce3571677.png)



### 4.2 实现方式

- 系统引入`common-log`模块，采用`AOP`及自定义标签操作日志记录



#### 4.2.1 创建`common-log`模块

![img](https://cdn.nlark.com/yuque/0/2022/png/12811585/1669495583199-b65f91cb-fb5f-4dd8-a825-ced1341b5308.png)



#### 4.2.2 引入依赖

```xml
<dependencies>
    <dependency>
        <groupId>com.atguigu</groupId>
        <artifactId>model</artifactId>
        <version>1.0</version>
    </dependency>
    <dependency>
        <groupId>com.atguigu</groupId>
        <artifactId>common-util</artifactId>
        <version>1.0</version>
    </dependency>
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-web</artifactId>
        <scope>provided</scope>
    </dependency>
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-aop</artifactId>
    </dependency>
</dependencies>
```



#### 4.2.3 新建自定义注解`Log`

- `com.atguigu.system.annotation.Log`

```java
package com.atguigu.system.annotation;

import com.atguigu.system.enums.BusinessType;
import com.atguigu.system.enums.OperatorType;

import java.lang.annotation.*;

/**
 * 自定义操作日志记录注解
 * - （参数，方法）Target 注解的目标（target）指定注解可以应用于哪个 Java 结构
 * - RetentionPolicy.RUNTIME 注解由编译器记录在类文件中，并由 JVM 在运行时保留
 *
 * @author 陈江林
 * @date 2022/11/27 04:50
 */
@Target({ElementType.PARAMETER, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Log {
    /**
     * 模块
     */
    String title() default "";

    /**
     * 功能
     */
    BusinessType businessType() default BusinessType.OTHER;

    /**
     * 操作人类别
     */
    OperatorType operatorType() default OperatorType.MANAGE;

    /**
     * 是否保存请求的参数
     */
    boolean isSaveRequestData() default true;

    /**
     * 是否保存响应的参数
     */
    boolean isSaveResponseData() default true;
}
```



#### 4.2.4 创建枚举类

- `OperatorType`

```java
package com.atguigu.system.enums;

/**
 * 操作人类别
 */
public enum OperatorType {
    /**
     * 其它
     */
    OTHER,

    /**
     * 后台用户
     */
    MANAGE,

    /**
     * 手机端用户
     */
    MOBILE
}
```

- `BusinessType`

```java
package com.atguigu.system.enums;

/**
 * 业务操作类型
 */
public enum BusinessType {
    /**
     * 其它
     */
    OTHER,

    /**
     * 新增
     */
    INSERT,

    /**
     * 修改
     */
    UPDATE,

    /**
     * 删除
     */
    DELETE,

    /**
     * 授权
     */
    ASSGIN,

    /**
     * 导出
     */
    EXPORT,

    /**
     * 导入
     */
    IMPORT,

    /**
     * 强退
     */
    FORCE,

    /**
     * 更新状态
     */
    STATUS,

    /**
     * 清空数据
     */
    CLEAN,
}
```



#### 4.2.5 新建`aspect.LogAspect`

```java
package com.atguigu.system.aspect;

import com.alibaba.fastjson.JSON;
import com.atguigu.common.utils.IpUtil;
import com.atguigu.common.utils.JwtHelper;
import com.atguigu.model.system.SysOperLog;
import com.atguigu.system.annotation.Log;
import com.atguigu.system.service.OperLogService;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Collection;
import java.util.Map;

/**
 * 操作日志记录处理
 *
 * @author 陈江林
 * @date 2022/11/27 05:22
 */
@Aspect
@Component
public class LogAspect {
    private static final Logger log = LoggerFactory.getLogger(LogAspect.class);

    /**
     * 微服务切换为feign调用接口
     */
    @Autowired
    private OperLogService operLogService;

    /**
     * 处理完请求后执行（后置通知）
     *
     * @param joinPoint 切点
     */
    @AfterReturning(pointcut = "@annotation(controllerLog)", returning = "jsonResult")
    public void doAfterReturning(JoinPoint joinPoint, Log controllerLog, Object jsonResult) {
        handleLog(joinPoint, controllerLog, null, jsonResult);
    }

    /**
     * 拦截异常操作
     *
     * @param joinPoint 切点
     * @param e         异常
     */
    @AfterThrowing(value = "@annotation(controllerLog)", throwing = "e")
    public void doAfterThrowing(JoinPoint joinPoint, Log controllerLog, Exception e) {
        handleLog(joinPoint, controllerLog, e, null);
    }

    protected void handleLog(final JoinPoint joinPoint, Log controllerLog, final Exception e, Object jsonResult) {
        try {
            RequestAttributes ra = RequestContextHolder.getRequestAttributes();
            ServletRequestAttributes sra = (ServletRequestAttributes) ra;
            HttpServletRequest request = sra.getRequest();

            // *========数据库日志=========*//
            SysOperLog operLog = new SysOperLog();
            operLog.setStatus(1);
            // 请求的地址
            // IpUtil.getIpAddr(ServletUtils.getRequest());
            String ip = IpUtil.getIpAddress(request);
            operLog.setOperIp(ip);
            operLog.setOperUrl(request.getRequestURI());

            String token = request.getHeader("token");
            String userName = JwtHelper.getUsername(token);
            operLog.setOperName(userName);

            if (e != null) {
                operLog.setStatus(0);
                operLog.setErrorMsg(e.getMessage());
            }
            // 设置方法名称
            String className = joinPoint.getTarget().getClass().getName();
            String methodName = joinPoint.getSignature().getName();
            operLog.setMethod(className + "." + methodName + "()");
            // 设置请求方式
            operLog.setRequestMethod(request.getMethod());
            // 处理设置注解上的参数
            getControllerMethodDescription(joinPoint, controllerLog, operLog, jsonResult);
            // 操作日志保存数据库
            operLogService.saveSysLog(operLog);
        } catch (Exception exp) {
            // 记录本地异常日志
            log.error("==前置通知异常==");
            log.error("异常信息:{}", exp.getMessage());
            exp.printStackTrace();
        }
    }

    /**
     * 获取注解中对方法的描述信息 用于Controller层注解
     *
     * @param log     日志
     * @param operLog 操作日志
     * @throws Exception
     */
    public void getControllerMethodDescription(JoinPoint joinPoint, Log log, SysOperLog operLog, Object jsonResult) throws Exception {
        // 设置action动作
        operLog.setBusinessType(log.businessType().name());
        // 设置标题
        operLog.setTitle(log.title());
        // 设置操作人类别
        operLog.setOperatorType(log.operatorType().name());
        // 是否需要保存request，参数和值
        if (log.isSaveRequestData()) {
            // 获取参数的信息，传入到数据库中。
            setRequestValue(joinPoint, operLog);
        }
        // 是否需要保存response，参数和值
        if (log.isSaveResponseData() && !StringUtils.isEmpty(jsonResult)) {
            operLog.setJsonResult(JSON.toJSONString(jsonResult));
        }
    }

    /**
     * 获取请求的参数，放到log中
     *
     * @param operLog 操作日志
     * @throws Exception 异常
     */
    private void setRequestValue(JoinPoint joinPoint, SysOperLog operLog) throws Exception {
        String requestMethod = operLog.getRequestMethod();
        if (HttpMethod.PUT.name().equals(requestMethod) || HttpMethod.POST.name().equals(requestMethod)) {
            String params = argsArrayToString(joinPoint.getArgs());
            operLog.setOperParam(params);
        }
    }

    /**
     * 参数拼装
     */
    private String argsArrayToString(Object[] paramsArray) {
        String params = "";
        if (paramsArray != null && paramsArray.length > 0) {
            for (Object o : paramsArray) {
                if (!StringUtils.isEmpty(o) && !isFilterObject(o)) {
                    try {
                        Object jsonObj = JSON.toJSON(o);
                        params += jsonObj.toString() + " ";
                    } catch (Exception e) {
                    }
                }
            }
        }
        return params.trim();
    }

    /**
     * 判断是否需要过滤的对象。
     *
     * @param o 对象信息。
     * @return 如果是需要过滤的对象，则返回true；否则返回false。
     */
    @SuppressWarnings("rawtypes")
    public boolean isFilterObject(final Object o) {
        Class<?> clazz = o.getClass();
        if (clazz.isArray()) {
            return clazz.getComponentType().isAssignableFrom(MultipartFile.class);
        } else if (Collection.class.isAssignableFrom(clazz)) {
            Collection collection = (Collection) o;
            for (Object value : collection) {
                return value instanceof MultipartFile;
            }
        } else if (Map.class.isAssignableFrom(clazz)) {
            Map map = (Map) o;
            for (Object value : map.entrySet()) {
                Map.Entry entry = (Map.Entry) value;
                return entry.getValue() instanceof MultipartFile;
            }
        }
        return o instanceof MultipartFile || o instanceof HttpServletRequest || o instanceof HttpServletResponse
                || o instanceof BindingResult;
    }
}
```



#### 4.2.6 新建系统日志服务接口

![img](https://cdn.nlark.com/yuque/0/2022/png/12811585/1669501679526-81e06417-90ee-4a08-981f-ae25d0fd5fc1.png)

```java
package com.atguigu.system.service;

import com.atguigu.model.system.SysOperLog;

/**
 * 系统日志 服务接口
 *
 * @author 陈江林
 * @date 2022/11/27 05:27
 */
public interface OperLogService {

    /**
     * 保存系统日志
     *
     * @param sysOperLog 系统日志对象
     */
    void saveSysLog(SysOperLog sysOperLog);

}
```



#### 4.2.7 `service-util`模块

- **引入依赖**

```xml
<dependency>
    <groupId>com.atguigu</groupId>
    <artifactId>common-log</artifactId>
    <version>1.0</version>
</dependency>
```

#### 

#### 4.2.8 `service-system`模块

- **实现系统日志服务接口**

```java
package com.atguigu.system.service.impl;

import com.atguigu.model.system.SysOperLog;
import com.atguigu.system.mapper.OperLogMapper;
import com.atguigu.system.service.OperLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 系统日志 服务实现类
 *
 * @author 陈江林
 * @date 2022/11/27 05:32
 */
@Service
public class OperLogServiceImpl implements OperLogService {

    @Autowired
    private OperLogMapper operLogMapper;

    @Override
    public void saveSysLog(SysOperLog sysOperLog) {
        operLogMapper.insert(sysOperLog);
    }

}
```

- **新建**`OperLogMapper`

```java
package com.atguigu.system.mapper;

import com.atguigu.model.system.SysOperLog;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * 系统日志 mapper 接口
 *
 * @author 陈江林
 * @date 2022/11/27 05:39
 */
public interface OperLogMapper extends BaseMapper<SysOperLog> {
}
```



### 4.3 使用方式

- 以角色管理为例
- 使用自定义标签记录日志
- `@Log(title="角色管理", businessType=BusinessType.INSTER)`

```java
@Log(title = "角色管理", businessType = BusinessType.INSERT)
@PreAuthorize("hasAuthority('btn.sysRole.add')")
@ApiOperation(value = "给用户分配角色")
@PostMapping("/doAssign")
public Result<List<SysRole>> doAssign(
        @RequestBody AssginRoleVo assginRoleVo
) {
    sysRoleService.doAssign(assginRoleVo);
    return Result.ok();
}
```



### 4.4 操作日志接口

#### 4.4.1 编写`SysOperLogController`

```java
package com.atguigu.system.controller;

import com.atguigu.common.result.Result;
import com.atguigu.model.system.SysOperLog;
import com.atguigu.model.vo.SysOperLogQueryVo;
import com.atguigu.system.service.SysOperLogService;
import com.baomidou.mybatisplus.core.metadata.IPage;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * 系统日志 控制类
 *
 * @author 陈江林
 * @date 2022/11/27 06:04
 */
@Api(tags = "登录日志接口")
@RestController
@RequestMapping(value = "/admin/system/sysOperLog")
public class SysOperLogController {

    @Resource
    private SysOperLogService sysOperLogService;

    @PreAuthorize("hasAuthority('btn.sysOperLog.list')")
    @ApiOperation(value = "获取分页列表")
    @GetMapping("/{page}/{limit}")
    public Result<IPage<SysOperLog>> index(
            @ApiParam(name = "page", value = "当前页码", required = true)
            @PathVariable Long page,

            @ApiParam(name = "limit", value = "每页记录数", required = true)
            @PathVariable Long limit,

            @ApiParam(name = "sysOperLogQueryVo", value = "查询对象")
                    SysOperLogQueryVo sysOperLogQueryVo) {
        return Result.ok(sysOperLogService.getPage(page, limit, sysOperLogQueryVo));
    }

}
```

#### 

#### 4.4.2 服务接口

```java
package com.atguigu.system.service;

import com.atguigu.model.system.SysOperLog;
import com.atguigu.model.vo.SysOperLogQueryVo;
import com.baomidou.mybatisplus.core.metadata.IPage;

/**
 * 系统日志 服务接口
 *
 * @author 陈江林
 * @date 2022/11/27 06:07
 */
public interface SysOperLogService {
    /**
     * 获取分页列表
     *
     * @param page              当前页码
     * @param limit             每页记录数
     * @param sysOperLogQueryVo 系统日志查询条件对象
     * @return {@link IPage}<{@link SysOperLog}>
     */
    IPage<SysOperLog> getPage(Long page, Long limit, SysOperLogQueryVo sysOperLogQueryVo);
}
```



#### 4.4.3 服务实现

```java
package com.atguigu.system.service.impl;

import com.atguigu.model.system.SysOperLog;
import com.atguigu.model.vo.SysOperLogQueryVo;
import com.atguigu.system.mapper.SysOperLogMapper;
import com.atguigu.system.service.SysOperLogService;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

/**
 * 系统日志 服务实现类
 *
 * @author 陈江林
 * @date 2022/11/27 06:08
 */
@Service
public class SysOperLogServiceImpl extends ServiceImpl<SysOperLogMapper, SysOperLog> implements SysOperLogService {
    @Override
    public IPage<SysOperLog> getPage(Long page, Long limit, SysOperLogQueryVo sysOperLogQueryVo) {
        LambdaQueryWrapper<SysOperLog> wrapper = new LambdaQueryWrapper<>();

        // 条件
        String operName = sysOperLogQueryVo.getOperName();
        String title = sysOperLogQueryVo.getTitle();
        String createTimeBegin = sysOperLogQueryVo.getCreateTimeBegin();
        String createTimeEnd = sysOperLogQueryVo.getCreateTimeEnd();

        // 操作人员
        if (!StringUtils.isEmpty(operName)) {
            wrapper.like(SysOperLog::getOperName, operName);
        }

        // 模块标题
        if (!StringUtils.isEmpty(title)) {
            wrapper.like(SysOperLog::getTitle, title);
        }

        // 时间
        if (!StringUtils.isEmpty(createTimeBegin) && !StringUtils.isEmpty(createTimeEnd) ) {
            wrapper.ge(SysOperLog::getCreateTime, createTimeBegin);
            wrapper.lt(SysOperLog::getCreateTime, createTimeEnd);
        }
        
        // 排序
        wrapper.orderByDesc(SysOperLog::getCreateTime);

        Page<SysOperLog> objectPage = new Page<>(page, limit);
        return this.baseMapper.selectPage(objectPage, wrapper);
    }
}
```



#### 4.4.4 `mapper`接口

```java
package com.atguigu.system.mapper;

import com.atguigu.model.system.SysOperLog;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * 系统日志 mapper 接口
 *
 * @author 陈江林
 * @date 2022/11/27 06:09
 */
public interface SysOperLogMapper extends BaseMapper<SysOperLog> {

}
```



### 4.5 操作日志显示-前端

![img](https://cdn.nlark.com/yuque/0/2022/png/12811585/1669515132589-1e363160-c2d4-437f-b39a-892cf2e8c177.png)

- 详情

![img](https://cdn.nlark.com/yuque/0/2022/png/12811585/1669515144327-e12b1328-fcdb-4974-83b9-5a8876a3e636.png)

#### 4.5.1 `API`

```javascript
import request from '@/utils/request'

const api_name = '/admin/system/sysOperLog'

// 列表
export function getPageList(page, limit, params) {
  return request({
    url: `${api_name}/${page}/${limit}`,
    method: 'get',
    params
  })
}
```



#### 4.5.2 `sysOperLog/list`

```vue
<template>
  <div>
    <!-- 卡片视图区域 -->
    <el-card>
      <el-row :gutter="22">
        <el-col :span="6">
          <el-input
            v-model="searchObj.name"
            placeholder="请输入岗位名称"
            class="input-with-select"
            clearable
            @clear="getList"
          >
            <el-button slot="append" icon="el-icon-search" @click="getList" />
          </el-input>
        </el-col>
        <el-col :span="6">
          <el-input
            v-model="searchObj.postCode"
            placeholder="请输入岗位编号"
            class="input-with-select"
            clearable
            @clear="getList"
          >
            <el-button slot="append" icon="el-icon-search" @click="getList" />
          </el-input>
        </el-col>
        <el-col :span="4">
          <el-select v-model="searchObj.status" placeholder="请选择" @change="getList">
            <el-option
              v-for="item in options"
              :key="item.value"
              :label="item.label"
              :value="item.value"
            />
          </el-select>
        </el-col>
        <el-col :span="6">
          <el-button type="primary" :disabled="$hasBP('btn.sysPost.add')" @click="openSaveDialog()">添加用户</el-button>
        </el-col>
      </el-row>

      <!-- 表格 -->
      <el-table
        :data="list"
        style="width: 100%"
        border
      >
        <el-table-column
          label="序号"
          width="70"
          align="center"
        >
          <template slot-scope="scope">
            {{ (page - 1) * limit + scope.$index + 1 }}
          </template>
        </el-table-column>
        <el-table-column prop="name" label="岗位名称" />
        <el-table-column prop="postCode" label="岗位编码" width="160" />
        <el-table-column label="状态" width="80">
          <template slot-scope="scope">
            <el-switch
              :value="scope.row.status === 1"
              :disabled="$hasBP('btn.sysPost.update')"
              @change="switchStatus(scope.row)"
            />
          </template>
        </el-table-column>
        <el-table-column prop="createTime" label="创建时间" width="200" />
        <el-table-column label="操作" width="200" align="center">
          <template slot-scope="scope">
            <el-button
              type="primary"
              icon="el-icon-edit"
              size="mini"
              title="修改"
              :disabled="$hasBP('btn.sysPost.update')"
              @click="openUpdateDialog(scope.row)"
            />
            <el-button
              type="danger"
              icon="el-icon-delete"
              size="mini"
              title="删除"
              :disabled="$hasBP('btn.sysPost.remove')"
              @click="removeById(scope.row)"
            />
          </template>
        </el-table-column>
      </el-table>

      <!-- 分页区域 -->
      <el-pagination
        :current-page="page"
        :page-sizes="[5, 10, 15, 20]"
        :page-size="limit"
        layout="total, sizes, prev, pager, next, jumper"
        :total="total"
        background
        @size-change="handleSizeChange"
        @current-change="handleCurrentChange"
      />
    </el-card>

    <!-- 添加/修改对话框 -->
    <el-dialog
      :title="dialogTitle"
      :visible.sync="addOrUpdateDialogFormVisible"
      width="50%"
      @close="saveOrUpdateDialogClose"
    >
      <el-form ref="addOrUpdateForm" :model="sysPost" :rules="sysPostRules" label-width="80px">
        <el-form-item label="岗位名称" prop="name">
          <el-input v-model="sysPost.name" />
        </el-form-item>
        <el-form-item label="岗位编码" prop="postCode">
          <el-input v-model="sysPost.postCode" />
        </el-form-item>
        <el-form-item label="状态" prop="type">
          <el-radio-group v-model="sysPost.status">
            <el-radio :label="1">正常</el-radio>
            <el-radio :label="0">停用</el-radio>
          </el-radio-group>
        </el-form-item>
      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button @click="addOrUpdateDialogFormVisible = false">取 消</el-button>
        <el-button type="primary" @click="saveOrUpdate()">确 定</el-button>
      </div>
    </el-dialog>
  </div>
</template>

<script>
import { save, update, updateStatus, getById, getPageList, removeById } from '@/api/system/post'

const sysPostObj = {
  id: '',
  name: '',
  postCode: '',
  status: 1
}

export default {
  // 定义数据
  data() {
    return {
      list: [],
      // 总记录数
      total: 0,
      // 当前页
      page: 1,
      // 每页显示记录数
      limit: 10,
      // 条件查询封装对象
      searchObj: {
        name: '',
        postCode: '',
        status: ''
      },
      options: [
        {
          value: '',
          label: '全部'
        }, {
          value: '1',
          label: '正常'
        }, {
          value: '0',
          label: '停用'
        }],

      /* 添加/修改对话框 */
      // 对话框标题
      dialogTitle: '',
      // 控制添加/修改对话框显示或隐藏(默认)
      addOrUpdateDialogFormVisible: false,
      // 表单对象
      sysPost: JSON.parse(JSON.stringify(sysPostObj)),
      sysPostRules: {
        name: [{ required: true, message: '请输入岗位名称', trigger: 'blur' }],
        postCode: [{ required: true, message: '请输入岗位编码', trigger: 'blur' }]
      }
    }
  },

  // 当页面加载时获取数据
  created() {
    this.getList()
  },

  methods: {
    // 调用api层获取数据库中的数据
    getList() {
      getPageList(this.page, this.limit, this.searchObj).then(res => {
        this.list = res.data.records
        this.total = res.data.total
      })
    },
    handleSizeChange(newSize) {
      this.limit = newSize
      this.getList()
    },
    handleCurrentChange(newPage) {
      this.page = newPage
      this.getList()
    },

    /* ========= start - 添加/修改对话框 ========= */
    // 关闭对话框
    saveOrUpdateDialogClose() {
      this.sysPost = JSON.parse(JSON.stringify(sysPostObj))
    },
    // 打开保存对话框
    openSaveDialog(row) {
      if (row) {
        this.sysPost.parentId = row.id
        this.sysPost.parentName = row.name
        // 对话框标题
        this.dialogTitle = '添加子部门'
      } else {
        // 对话框标题
        this.dialogTitle = '添加部门'
        this.sysPost.parentId = 0
      }

      // 打开对话框
      this.addOrUpdateDialogFormVisible = true
    },
    // 打开修改对话框
    openUpdateDialog(row) {
      // 根据id获取对象
      getById(row.id).then(res => {
        // 保存表单数据
        this.sysPost = res.data
        // 对话框标题
        this.dialogTitle = '修改菜单'
        // 打开对话框
        this.addOrUpdateDialogFormVisible = true
      })
    },
    // 保存或删除
    saveOrUpdate() {
      // 校验表单
      this.$refs.addOrUpdateForm.validate(valid => {
        if (valid) {
          if (!this.sysPost.id) {
            // 无id保存
            this.save()
          } else {
            // 有id修改
            this.update()
          }
        }
      })
    },
    // 调用API保存
    save() {
      save(this.sysPost).then(res => {
        // 关闭对话框
        this.addOrUpdateDialogFormVisible = false
        // 提示
        this.$message.success('保存成功')
        // 刷新数据
        this.getList()
      })
    },
    // 调用API修改
    update() {
      update(this.sysPost).then(res => {
        // 关闭对话框
        this.addOrUpdateDialogFormVisible = false
        // 提示
        this.$message.success('修改成功')
        // 刷新数据
        this.getList()
      })
    },
    /* ========= end - 添加/修改对话框 ========= */

    // 根据id删除数据
    removeById(row) {
      // 弹框询问用户是否删除数据
      this.$confirm('此操作将永久删除该数据, 是否继续?', '提示', {
        confirmButtonText: '确定',
        cancelButtonText: '取消',
        type: 'warning'
      }).then(() => {
        removeById(row.id).then(res => {
          // 提示
          this.$message.success('删除成功!')
          // 刷新数据
          this.getList()
        })
      }).catch(() => {
        this.$message({
          type: 'info',
          message: '已取消删除'
        })
      })
    },
    // 切换状态
    switchStatus(row) {
      row.status = row.status === 1 ? 0 : 1
      updateStatus(row.id, row.status).then(res => {
        this.$message.success('操作成功')
        this.getList()
      })
    }
  }
}
</script>
```


# 十一 微服务

```
git checkout -b 11.0.0_nacos_gateway
```

- `Nacos`服务
- `GateWay`网关

## 1 服务模块整合`Nacos`

### 1.1 `common-sersvice`依赖

```xml
<!-- 服务注册 -->
<dependency>
    <groupId>com.alibaba.cloud</groupId>
    <artifactId>spring-cloud-starter-alibaba-nacos-discovery</artifactId>
</dependency>
<!-- 服务调用 feign -->
<dependency>
    <groupId>org.springframework.cloud</groupId>
    <artifactId>spring-cloud-starter-openfeign</artifactId>
</dependency>
```



### 1.2 父项目依赖

```xml
<cloud.version>Hoxton.RELEASE</cloud.version>
<alibaba.version>2.2.0.RELEASE</alibaba.version>
<dependency>
    <groupId>org.springframework.cloud</groupId>
    <artifactId>spring-cloud-dependencies</artifactId>
    <version>${cloud.version}</version>
    <type>pom</type>
    <scope>import</scope>
</dependency>
<dependency>
    <groupId>com.alibaba.cloud</groupId>
    <artifactId>spring-cloud-alibaba-dependencies</artifactId>
    <version>${alibaba.version}</version>
    <type>pom</type>
    <scope>import</scope>
</dependency>
```

### 1.3 `service-system`配置

```yaml
spring:
	cloud:
  	nacos:
    	discovery:
      	# nacos 服务地址
      	server-addr: 127.0.0.1:8848
```



### 1.4 启动类注解`@EnableDiscoveryClient`

```java
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
```



## 2 使用`GateWay`网关

### 2.1 新建模块`service-gateway`

![img](https://cdn.nlark.com/yuque/0/2022/png/12811585/1669578423342-1250f479-2324-458d-ac66-73d2122308a9.png)

### 2.2 依赖

```xml
    <packaging>jar</packaging>

    <dependencies>
        <!-- 网关 -->
        <dependency>
            <groupId>org.springframework.cloud</groupId>
            <artifactId>spring-cloud-starter-gateway</artifactId>
        </dependency>

        <!-- 服务注册 -->
        <dependency>
            <groupId>com.alibaba.cloud</groupId>
            <artifactId>spring-cloud-starter-alibaba-nacos-discovery</artifactId>
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



### 2.3 启动类

```java
package com.atguigu.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author 陈江林
 * @date 2022/11/28 03:48
 */
@SpringBootApplication
@EnableDiscoveryClient
public class ApiGateWayApplication {

    public static void main(String[] args) {
        SpringApplication.run(ApiGateWayApplication.class, args);
    }

}
```



### 2.4 配置文件

```yaml
# 服务端口
server:
  port: 1128

spring:
  # 服务名
  application:
    name: service-gateway-1128
  # nacos服务地址
  cloud:
    nacos:
      discovery:
        server-addr: 127.0.0.1:8848
    # 使用服务发现路由
    gateway:
      discovery:
        locator:
          enabled: true
      # service-system 模块配置
      # 设置路由id
      routes: [{id: service-system, uri: lb://service-system, predicates: Path=/*/system/**}]
```





## 3 `service-api`远程调用模块

### 3.1 新建模块

![img](https://cdn.nlark.com/yuque/0/2022/png/12811585/1669572042409-4b7f3096-351e-4e14-836e-e256eb5354a0.png)

### 3.2 依赖

```xml
    <dependencies>
        <!-- 公共 -->
        <dependency>
            <groupId>com.atguigu</groupId>
            <artifactId>common-util</artifactId>
            <version>1.0</version>
        </dependency>
        <!-- 实体 -->
        <dependency>
            <groupId>com.atguigu</groupId>
            <artifactId>model</artifactId>
            <version>1.0</version>
        </dependency>
        <!-- 服务调用 -->
        <dependency>
            <groupId>org.springframework.cloud</groupId>
            <artifactId>spring-cloud-starter-openfeign</artifactId>
        </dependency>
        <!-- 整合 Hystrix -->
        <dependency>
            <groupId>org.springframework.cloud</groupId>
            <artifactId>spring-cloud-starter-netflix-hystrix</artifactId>
        </dependency>
    </dependencies>
```

### 3.3 新建文件

![img](https://cdn.nlark.com/yuque/0/2022/png/12811585/1669572581317-4b567439-19e8-4b4b-b45c-d0e85768fcdc.png)

- `SystemRemoteService`

```java
package com.atguigu.service.api;

import com.atguigu.common.result.Result;
import com.atguigu.model.system.SysLoginLog;
import com.atguigu.service.factory.SystemFallBackFactory;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * 系统模块
 *
 * @author 陈江林
 * @date 2022/11/28 02:06
 */
@FeignClient(value = "service-system", fallbackFactory = SystemFallBackFactory.class)
public interface SystemRemoteService {

    /**
     * 保存登录日志
     *
     * @param sysLoginLog 系统登录日志对象
     * @return {@link Result}
     */
    @PostMapping(value = "/api/system/sysLoginLog/save", consumes = "application/json")
    Result saveLoginLog(@RequestBody SysLoginLog sysLoginLog);

}
```

- `SystemFallBackFactory`

```java
package com.atguigu.service.factory;

import com.atguigu.common.result.Result;
import com.atguigu.model.system.SysLoginLog;
import com.atguigu.service.api.SystemRemoteService;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

/**
 * 降级机制
 * 
 * @author 陈江林
 * @date 2022/11/28 02:07
 */
@Component
public class SystemFallBackFactory implements FallbackFactory<SystemRemoteService> {
    @Override
    public SystemRemoteService create(Throwable cause) {
        return new SystemRemoteService() {
            @Override
            public Result saveLoginLog(SysLoginLog sysLoginLog) {
                return Result.fail("降级机制生效: " + cause.getMessage());
            }
        };
    }
}
```



### 3.4 `service-system`模块

#### 3.4.1 依赖

```xml
<!-- 整合 Hystrix -->
<dependency>
    <groupId>org.springframework.cloud</groupId>
    <artifactId>spring-cloud-starter-netflix-hystrix</artifactId>
</dependency>
```



#### 3.4.2 接口

![img](https://cdn.nlark.com/yuque/0/2022/png/12811585/1669573705477-126986ec-a365-44d8-be31-b65176ca6c16.png)

```java
package com.atguigu.system.api;

import com.atguigu.common.result.Result;
import com.atguigu.model.system.SysLoginLog;
import com.atguigu.system.service.SysLoginLogService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 陈江林
 * @date 2022/11/28 02:14
 */
@Api(tags = "登录日志远程接口")
@RestController
@RequestMapping(value = "/api/system/sysLoginLog")
public class SysLoginLogApiController {

    @Autowired
    private SysLoginLogService sysLoginLogService;

    @ApiOperation(value = "保存登录日志")
    @HystrixCommand(fallbackMethod = "saveLoginLogBackup")
    @PostMapping("/save")
    public Result saveLoginLog(@RequestBody SysLoginLog sysLoginLog) {
        if (sysLoginLogService.save(sysLoginLog)) {
            return Result.ok();
        } else {
            return Result.fail();
        }
    }

    public Result saveLoginLogBackup(@RequestBody SysLoginLog sysLoginLog) {
        return Result.fail("熔断机制生效: 方法执行出现问题");
    }
    
}
```



## 4 优化`保存登录日志`，使用远程调用<`spring-security`模块>

- 弃用

![img](https://cdn.nlark.com/yuque/0/2022/png/12811585/1669572675296-d1d99f00-d7d1-41a2-9ff1-c3bc0465f341.png)



### 4.1 `spring-security`加入依赖

```xml
<dependency>
    <groupId>com.atguigu</groupId>
    <artifactId>service-api</artifactId>
    <version>1.0</version>
</dependency>
```



### 4.2 更改保存

![img](https://cdn.nlark.com/yuque/0/2022/png/12811585/1669573791416-6ecefd04-047d-4b3e-bf48-37d14af48e0b.png)

- 更改区域

![img](https://cdn.nlark.com/yuque/0/2022/png/12811585/1669574012045-9769399e-d272-40d3-9889-b7e6e0421c4e.png)

![img](https://cdn.nlark.com/yuque/0/2022/png/12811585/1669574127116-2d820727-c6c9-4fa7-a969-6c0ef7f56093.png)

```java
package com.atguigu.system.filter;

import com.alibaba.fastjson.JSON;
import com.atguigu.common.result.Result;
import com.atguigu.common.result.ResultCodeEnum;
import com.atguigu.common.utils.IpUtil;
import com.atguigu.common.utils.JwtHelper;
import com.atguigu.common.utils.ResponseUtil;
import com.atguigu.model.system.SysLoginLog;
import com.atguigu.model.vo.LoginVo;
import com.atguigu.service.api.SystemRemoteService;
import com.atguigu.system.custom.CustomUser;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * @author 陈江林
 * @date 2022/11/23 00:14
 */
public class TokenLoginFilter extends UsernamePasswordAuthenticationFilter {

    private RedisTemplate redisTemplate;

    //    private LoginLogService loginLogService;
    private SystemRemoteService systemRemoteService;

    public TokenLoginFilter(AuthenticationManager authenticationManager,
                            RedisTemplate redisTemplate,
                            SystemRemoteService systemRemoteService) {
        this.setAuthenticationManager(authenticationManager);
        this.setPostOnly(false);
        // 指定登录接口及提交方式，可以指定任意路径
        this.setRequiresAuthenticationRequestMatcher(
                new AntPathRequestMatcher("/admin/system/index/login", "POST")
        );
        this.redisTemplate = redisTemplate;
        this.systemRemoteService = systemRemoteService;
    }

    /**
     * 登录认证
     *
     * @param req
     * @param res
     * @return
     * @throws AuthenticationException
     */
    @Override
    public Authentication attemptAuthentication(HttpServletRequest req, HttpServletResponse res)
            throws AuthenticationException {
        try {
            LoginVo loginVo = new ObjectMapper().readValue(req.getInputStream(), LoginVo.class);
            Authentication authenticationToken = new UsernamePasswordAuthenticationToken(loginVo.getUsername(), loginVo.getPassword());
            return this.getAuthenticationManager().authenticate(authenticationToken);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 登录成功
     *
     * @param request
     * @param response
     * @param chain
     * @param auth
     * @throws IOException
     * @throws ServletException
     */
    @Override
    protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain,
                                            Authentication auth) throws IOException, ServletException {
        // 获取认证对象
        CustomUser customUser = (CustomUser) auth.getPrincipal();
        // 保存权限数据
        redisTemplate.opsForValue().set(customUser.getUsername(),
                JSON.toJSONString(customUser.getAuthorities()));
        // 生成 token
        String token = JwtHelper.createToken(customUser.getSysUser().getId(), customUser.getSysUser().getUsername());
        // 登录日志
        SysLoginLog sysLoginLog = new SysLoginLog();
        sysLoginLog.setUsername(customUser.getUsername());
        sysLoginLog.setStatus(1);
        sysLoginLog.setIpaddr(IpUtil.getIpAddress(request));
        sysLoginLog.setMsg("登录成功");
        systemRemoteService.saveLoginLog(sysLoginLog);
        // 返回
        Map<String, Object> map = new HashMap<>();
        map.put("token", token);
        ResponseUtil.out(response, Result.ok(map));
    }

    /**
     * 登录失败
     *
     * @param request
     * @param response
     * @param e
     */
    @Override
    protected void unsuccessfulAuthentication(HttpServletRequest request, HttpServletResponse response,
                                              AuthenticationException e) {
        if (e.getCause() instanceof RuntimeException) {
            ResponseUtil.out(response, Result.build(null, 204, e.getMessage()));
        } else {
            ResponseUtil.out(response, Result.build(null, ResultCodeEnum.LOGIN_MOBLE_ERROR));
        }
    }

}
```



### 4.3 对应更改

![img](https://cdn.nlark.com/yuque/0/2022/png/12811585/1669573840871-d0752822-7d84-45af-ac09-7bb9d43a2ab4.png)

- 更改区域

![img](https://cdn.nlark.com/yuque/0/2022/png/12811585/1669574186260-b1eaade4-54e3-4b3e-8d2c-ed7e09013033.png)

```java
package com.atguigu.system.config;

import com.atguigu.service.api.SystemRemoteService;
import com.atguigu.system.filter.TokenAuthenticationFilter;
import com.atguigu.system.filter.TokenLoginFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

/**
 * Spring Security 配置类
 * `@EnableGlobalMethodSecurity(prePostEnabled = true)`：开启注解功能，默认禁用注解
 *
 * @author 陈江林
 * @date 2022/11/21 21:33
 */
@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private RedisTemplate redisTemplate;

//    @Autowired
//    private LoginLogService loginLogService;

    @Autowired
    private SystemRemoteService systemRemoteService;

    /**
     * 加密方式
     *
     * @return {@link PasswordEncoder}
     */
    @Bean
    public PasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        // 这是配置的关键，决定哪些接口开启防护，哪些接口绕过防护
        http
                // 关闭csrf
                .csrf().disable()
                // 开启跨域以便前端调用接口
                .cors().and()
                .authorizeRequests()
                // 指定某些接口不需要通过验证即可访问。登陆接口肯定是不需要认证的
                .antMatchers("/admin/system/index/login").permitAll()
                // 这里意思是其它所有接口需要认证才能访问
                .anyRequest().authenticated()
                .and()
                // TokenAuthenticationFilter放到UsernamePasswordAuthenticationFilter的前面，这样做就是为了除了登录的时候去查询数据库外，其他时候都用token进行认证。
                .addFilterBefore(new TokenAuthenticationFilter(redisTemplate), UsernamePasswordAuthenticationFilter.class)
                .addFilter(new TokenLoginFilter(authenticationManager(), redisTemplate, systemRemoteService));

        // 禁用session
        http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
    }

    /**
     * 配置哪些请求不拦截
     * 排除swagger相关请求
     *
     * @param web
     */
    @Override
    public void configure(WebSecurity web) {
        web.ignoring().antMatchers("/favicon.ico", "/swagger-resources/**", "/webjars/**", "/v2/**", "/swagger-ui.html/**", "/doc.html");
    }
}
```



## 5 `BUG`-`service-gateway`服务启动失败

```latex
2022-11-28 06:56:45.786  INFO 15063 --- [           main] trationDelegate$BeanPostProcessorChecker : Bean 'org.springframework.cloud.autoconfigure.ConfigurationPropertiesRebinderAutoConfiguration' of type [org.springframework.cloud.autoconfigure.ConfigurationPropertiesRebinderAutoConfiguration] is not eligible for getting processed by all BeanPostProcessors (for example: not eligible for auto-proxying)

  .   ____          _            __ _ _
 /\\ / ___'_ __ _ _(_)_ __  __ _ \ \ \ \
( ( )\___ | '_ | '_| | '_ \/ _` | \ \ \ \
 \\/  ___)| |_)| | | | | || (_| |  ) ) ) )
  '  |____| .__|_| |_|_| |_\__, | / / / /
 =========|_|==============|___/=/_/_/_/
 :: Spring Boot ::        (v2.3.6.RELEASE)

2022-11-28 06:56:46.033  INFO 15063 --- [           main] c.atguigu.gateway.ApiGateWayApplication  : No active profile set, falling back to default profiles: default
2022-11-28 06:56:47.019  INFO 15063 --- [           main] o.s.cloud.context.scope.GenericScope     : BeanFactory id=5ff3c339-84aa-3b57-873a-38bbbb2df036
2022-11-28 06:56:47.041  INFO 15063 --- [           main] trationDelegate$BeanPostProcessorChecker : Bean 'org.springframework.cloud.autoconfigure.ConfigurationPropertiesRebinderAutoConfiguration' of type [org.springframework.cloud.autoconfigure.ConfigurationPropertiesRebinderAutoConfiguration] is not eligible for getting processed by all BeanPostProcessors (for example: not eligible for auto-proxying)
2022-11-28 06:56:47.048  INFO 15063 --- [           main] trationDelegate$BeanPostProcessorChecker : Bean 'org.springframework.cloud.client.loadbalancer.reactive.LoadBalancerBeanPostProcessorAutoConfiguration' of type [org.springframework.cloud.client.loadbalancer.reactive.LoadBalancerBeanPostProcessorAutoConfiguration] is not eligible for getting processed by all BeanPostProcessors (for example: not eligible for auto-proxying)
2022-11-28 06:56:47.051  INFO 15063 --- [           main] trationDelegate$BeanPostProcessorChecker : Bean 'org.springframework.cloud.client.loadbalancer.reactive.LoadBalancerBeanPostProcessorAutoConfiguration$ReactiveLoadBalancerConfig' of type [org.springframework.cloud.client.loadbalancer.reactive.LoadBalancerBeanPostProcessorAutoConfiguration$ReactiveLoadBalancerConfig] is not eligible for getting processed by all BeanPostProcessors (for example: not eligible for auto-proxying)
2022-11-28 06:56:47.057  INFO 15063 --- [           main] trationDelegate$BeanPostProcessorChecker : Bean 'deferringLoadBalancerExchangeFilterFunction' of type [org.springframework.cloud.client.loadbalancer.reactive.DeferringLoadBalancerExchangeFilterFunction] is not eligible for getting processed by all BeanPostProcessors (for example: not eligible for auto-proxying)
2022-11-28 06:56:47.301  WARN 15063 --- [           main] c.n.c.sources.URLConfigurationSource     : No URLs will be polled as dynamic configuration sources.
2022-11-28 06:56:47.301  INFO 15063 --- [           main] c.n.c.sources.URLConfigurationSource     : To enable URLs as dynamic configuration sources, define System property archaius.configurationSource.additionalUrls or make config.properties available on classpath.
2022-11-28 06:56:47.309  WARN 15063 --- [           main] c.n.c.sources.URLConfigurationSource     : No URLs will be polled as dynamic configuration sources.
2022-11-28 06:56:47.309  INFO 15063 --- [           main] c.n.c.sources.URLConfigurationSource     : To enable URLs as dynamic configuration sources, define System property archaius.configurationSource.additionalUrls or make config.properties available on classpath.
2022-11-28 06:56:47.541  WARN 15063 --- [           main] onfigReactiveWebServerApplicationContext : Exception encountered during context initialization - cancelling refresh attempt: org.springframework.beans.factory.UnsatisfiedDependencyException: Error creating bean with name 'discoveryClientRouteDefinitionLocator' defined in class path resource [org/springframework/cloud/gateway/discovery/GatewayDiscoveryClientAutoConfiguration$ReactiveDiscoveryClientRouteDefinitionLocatorConfiguration.class]: Unsatisfied dependency expressed through method 'discoveryClientRouteDefinitionLocator' parameter 1; nested exception is org.springframework.beans.factory.BeanCreationException: Error creating bean with name 'discoveryLocatorProperties' defined in class path resource [org/springframework/cloud/gateway/discovery/GatewayDiscoveryClientAutoConfiguration.class]: Bean instantiation via factory method failed; nested exception is org.springframework.beans.BeanInstantiationException: Failed to instantiate [org.springframework.cloud.gateway.discovery.DiscoveryLocatorProperties]: Factory method 'discoveryLocatorProperties' threw exception; nested exception is java.lang.NoClassDefFoundError: javax/validation/ValidationException
2022-11-28 06:56:47.622  INFO 15063 --- [           main] ConditionEvaluationReportLoggingListener :

Error starting ApplicationContext. To display the conditions report re-run your application with 'debug' enabled.
2022-11-28 06:56:47.629 ERROR 15063 --- [           main] o.s.boot.SpringApplication               : Application run failed

org.springframework.beans.factory.UnsatisfiedDependencyException: Error creating bean with name 'discoveryClientRouteDefinitionLocator' defined in class path resource [org/springframework/cloud/gateway/discovery/GatewayDiscoveryClientAutoConfiguration$ReactiveDiscoveryClientRouteDefinitionLocatorConfiguration.class]: Unsatisfied dependency expressed through method 'discoveryClientRouteDefinitionLocator' parameter 1; nested exception is org.springframework.beans.factory.BeanCreationException: Error creating bean with name 'discoveryLocatorProperties' defined in class path resource [org/springframework/cloud/gateway/discovery/GatewayDiscoveryClientAutoConfiguration.class]: Bean instantiation via factory method failed; nested exception is org.springframework.beans.BeanInstantiationException: Failed to instantiate [org.springframework.cloud.gateway.discovery.DiscoveryLocatorProperties]: Factory method 'discoveryLocatorProperties' threw exception; nested exception is java.lang.NoClassDefFoundError: javax/validation/ValidationException
	at org.springframework.beans.factory.support.ConstructorResolver.createArgumentArray(ConstructorResolver.java:797) ~[spring-beans-5.2.11.RELEASE.jar!/:5.2.11.RELEASE]
	at org.springframework.beans.factory.support.ConstructorResolver.instantiateUsingFactoryMethod(ConstructorResolver.java:538) ~[spring-beans-5.2.11.RELEASE.jar!/:5.2.11.RELEASE]
	at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.instantiateUsingFactoryMethod(AbstractAutowireCapableBeanFactory.java:1336) ~[spring-beans-5.2.11.RELEASE.jar!/:5.2.11.RELEASE]
	at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.createBeanInstance(AbstractAutowireCapableBeanFactory.java:1176) ~[spring-beans-5.2.11.RELEASE.jar!/:5.2.11.RELEASE]
	at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.doCreateBean(AbstractAutowireCapableBeanFactory.java:556) ~[spring-beans-5.2.11.RELEASE.jar!/:5.2.11.RELEASE]
	at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.createBean(AbstractAutowireCapableBeanFactory.java:516) ~[spring-beans-5.2.11.RELEASE.jar!/:5.2.11.RELEASE]
	at org.springframework.beans.factory.support.AbstractBeanFactory.lambda$doGetBean$0(AbstractBeanFactory.java:324) ~[spring-beans-5.2.11.RELEASE.jar!/:5.2.11.RELEASE]
	at org.springframework.beans.factory.support.DefaultSingletonBeanRegistry.getSingleton(DefaultSingletonBeanRegistry.java:234) ~[spring-beans-5.2.11.RELEASE.jar!/:5.2.11.RELEASE]
	at org.springframework.beans.factory.support.AbstractBeanFactory.doGetBean(AbstractBeanFactory.java:322) ~[spring-beans-5.2.11.RELEASE.jar!/:5.2.11.RELEASE]
	at org.springframework.beans.factory.support.AbstractBeanFactory.getBean(AbstractBeanFactory.java:202) ~[spring-beans-5.2.11.RELEASE.jar!/:5.2.11.RELEASE]
	at org.springframework.beans.factory.support.DefaultListableBeanFactory.preInstantiateSingletons(DefaultListableBeanFactory.java:897) ~[spring-beans-5.2.11.RELEASE.jar!/:5.2.11.RELEASE]
	at org.springframework.context.support.AbstractApplicationContext.finishBeanFactoryInitialization(AbstractApplicationContext.java:879) ~[spring-context-5.2.11.RELEASE.jar!/:5.2.11.RELEASE]
	at org.springframework.context.support.AbstractApplicationContext.refresh(AbstractApplicationContext.java:551) ~[spring-context-5.2.11.RELEASE.jar!/:5.2.11.RELEASE]
	at org.springframework.boot.web.reactive.context.ReactiveWebServerApplicationContext.refresh(ReactiveWebServerApplicationContext.java:62) ~[spring-boot-2.3.6.RELEASE.jar!/:2.3.6.RELEASE]
	at org.springframework.boot.SpringApplication.refresh(SpringApplication.java:758) [spring-boot-2.3.6.RELEASE.jar!/:2.3.6.RELEASE]
	at org.springframework.boot.SpringApplication.refresh(SpringApplication.java:750) [spring-boot-2.3.6.RELEASE.jar!/:2.3.6.RELEASE]
	at org.springframework.boot.SpringApplication.refreshContext(SpringApplication.java:405) [spring-boot-2.3.6.RELEASE.jar!/:2.3.6.RELEASE]
	at org.springframework.boot.SpringApplication.run(SpringApplication.java:315) [spring-boot-2.3.6.RELEASE.jar!/:2.3.6.RELEASE]
	at org.springframework.boot.SpringApplication.run(SpringApplication.java:1237) [spring-boot-2.3.6.RELEASE.jar!/:2.3.6.RELEASE]
	at org.springframework.boot.SpringApplication.run(SpringApplication.java:1226) [spring-boot-2.3.6.RELEASE.jar!/:2.3.6.RELEASE]
	at com.atguigu.gateway.ApiGateWayApplication.main(ApiGateWayApplication.java:16) [classes!/:1.0]
	at sun.reflect.NativeMethodAccessorImpl.invoke0(Native Method) ~[na:1.8.0_121]
	at sun.reflect.NativeMethodAccessorImpl.invoke(NativeMethodAccessorImpl.java:62) ~[na:1.8.0_121]
	at sun.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43) ~[na:1.8.0_121]
	at java.lang.reflect.Method.invoke(Method.java:498) ~[na:1.8.0_121]
	at org.springframework.boot.loader.MainMethodRunner.run(MainMethodRunner.java:49) [service-gateway.jar:1.0]
	at org.springframework.boot.loader.Launcher.launch(Launcher.java:107) [service-gateway.jar:1.0]
	at org.springframework.boot.loader.Launcher.launch(Launcher.java:58) [service-gateway.jar:1.0]
	at org.springframework.boot.loader.JarLauncher.main(JarLauncher.java:88) [service-gateway.jar:1.0]
Caused by: org.springframework.beans.factory.BeanCreationException: Error creating bean with name 'discoveryLocatorProperties' defined in class path resource [org/springframework/cloud/gateway/discovery/GatewayDiscoveryClientAutoConfiguration.class]: Bean instantiation via factory method failed; nested exception is org.springframework.beans.BeanInstantiationException: Failed to instantiate [org.springframework.cloud.gateway.discovery.DiscoveryLocatorProperties]: Factory method 'discoveryLocatorProperties' threw exception; nested exception is java.lang.NoClassDefFoundError: javax/validation/ValidationException
	at org.springframework.beans.factory.support.ConstructorResolver.instantiate(ConstructorResolver.java:655) ~[spring-beans-5.2.11.RELEASE.jar!/:5.2.11.RELEASE]
	at org.springframework.beans.factory.support.ConstructorResolver.instantiateUsingFactoryMethod(ConstructorResolver.java:483) ~[spring-beans-5.2.11.RELEASE.jar!/:5.2.11.RELEASE]
	at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.instantiateUsingFactoryMethod(AbstractAutowireCapableBeanFactory.java:1336) ~[spring-beans-5.2.11.RELEASE.jar!/:5.2.11.RELEASE]
	at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.createBeanInstance(AbstractAutowireCapableBeanFactory.java:1176) ~[spring-beans-5.2.11.RELEASE.jar!/:5.2.11.RELEASE]
	at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.doCreateBean(AbstractAutowireCapableBeanFactory.java:556) ~[spring-beans-5.2.11.RELEASE.jar!/:5.2.11.RELEASE]
	at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.createBean(AbstractAutowireCapableBeanFactory.java:516) ~[spring-beans-5.2.11.RELEASE.jar!/:5.2.11.RELEASE]
	at org.springframework.beans.factory.support.AbstractBeanFactory.lambda$doGetBean$0(AbstractBeanFactory.java:324) ~[spring-beans-5.2.11.RELEASE.jar!/:5.2.11.RELEASE]
	at org.springframework.beans.factory.support.DefaultSingletonBeanRegistry.getSingleton(DefaultSingletonBeanRegistry.java:234) ~[spring-beans-5.2.11.RELEASE.jar!/:5.2.11.RELEASE]
	at org.springframework.beans.factory.support.AbstractBeanFactory.doGetBean(AbstractBeanFactory.java:322) ~[spring-beans-5.2.11.RELEASE.jar!/:5.2.11.RELEASE]
	at org.springframework.beans.factory.support.AbstractBeanFactory.getBean(AbstractBeanFactory.java:202) ~[spring-beans-5.2.11.RELEASE.jar!/:5.2.11.RELEASE]
	at org.springframework.beans.factory.config.DependencyDescriptor.resolveCandidate(DependencyDescriptor.java:276) ~[spring-beans-5.2.11.RELEASE.jar!/:5.2.11.RELEASE]
	at org.springframework.beans.factory.support.DefaultListableBeanFactory.doResolveDependency(DefaultListableBeanFactory.java:1307) ~[spring-beans-5.2.11.RELEASE.jar!/:5.2.11.RELEASE]
	at org.springframework.beans.factory.support.DefaultListableBeanFactory.resolveDependency(DefaultListableBeanFactory.java:1227) ~[spring-beans-5.2.11.RELEASE.jar!/:5.2.11.RELEASE]
	at org.springframework.beans.factory.support.ConstructorResolver.resolveAutowiredArgument(ConstructorResolver.java:884) ~[spring-beans-5.2.11.RELEASE.jar!/:5.2.11.RELEASE]
	at org.springframework.beans.factory.support.ConstructorResolver.createArgumentArray(ConstructorResolver.java:788) ~[spring-beans-5.2.11.RELEASE.jar!/:5.2.11.RELEASE]
	... 28 common frames omitted
Caused by: org.springframework.beans.BeanInstantiationException: Failed to instantiate [org.springframework.cloud.gateway.discovery.DiscoveryLocatorProperties]: Factory method 'discoveryLocatorProperties' threw exception; nested exception is java.lang.NoClassDefFoundError: javax/validation/ValidationException
	at org.springframework.beans.factory.support.SimpleInstantiationStrategy.instantiate(SimpleInstantiationStrategy.java:185) ~[spring-beans-5.2.11.RELEASE.jar!/:5.2.11.RELEASE]
	at org.springframework.beans.factory.support.ConstructorResolver.instantiate(ConstructorResolver.java:650) ~[spring-beans-5.2.11.RELEASE.jar!/:5.2.11.RELEASE]
	... 42 common frames omitted
Caused by: java.lang.NoClassDefFoundError: javax/validation/ValidationException
	at org.springframework.cloud.gateway.discovery.GatewayDiscoveryClientAutoConfiguration.initPredicates(GatewayDiscoveryClientAutoConfiguration.java:61) ~[spring-cloud-gateway-core-2.2.0.RELEASE.jar!/:2.2.0.RELEASE]
	at org.springframework.cloud.gateway.discovery.GatewayDiscoveryClientAutoConfiguration.discoveryLocatorProperties(GatewayDiscoveryClientAutoConfiguration.java:86) ~[spring-cloud-gateway-core-2.2.0.RELEASE.jar!/:2.2.0.RELEASE]
	at sun.reflect.NativeMethodAccessorImpl.invoke0(Native Method) ~[na:1.8.0_121]
	at sun.reflect.NativeMethodAccessorImpl.invoke(NativeMethodAccessorImpl.java:62) ~[na:1.8.0_121]
	at sun.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43) ~[na:1.8.0_121]
	at java.lang.reflect.Method.invoke(Method.java:498) ~[na:1.8.0_121]
	at org.springframework.beans.factory.support.SimpleInstantiationStrategy.instantiate(SimpleInstantiationStrategy.java:154) ~[spring-beans-5.2.11.RELEASE.jar!/:5.2.11.RELEASE]
	... 43 common frames omitted
Caused by: java.lang.ClassNotFoundException: javax.validation.ValidationException
	at java.net.URLClassLoader.findClass(URLClassLoader.java:381) ~[na:1.8.0_121]
	at java.lang.ClassLoader.loadClass(ClassLoader.java:424) ~[na:1.8.0_121]
	at org.springframework.boot.loader.LaunchedURLClassLoader.loadClass(LaunchedURLClassLoader.java:151) ~[service-gateway.jar:1.0]
	at java.lang.ClassLoader.loadClass(ClassLoader.java:357) ~[na:1.8.0_121]
	... 50 common frames omitted
```



### 5.1 解决方案-添加依赖

```xml
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-validation</artifactId>
</dependency>
```



## 6 测试登录日志是否能正常保存

1. 测试失败，原因：权限拦截了请求
2. 报错，原因：`spring-security`认证没有放行

```latex
2022-11-28 08:49:09.948  INFO 22540 --- [nio-1110-exec-2] c.a.s.filter.TokenAuthenticationFilter   : uri:/api/system/sysLoginLog/save
2022-11-28 08:49:10.112 ERROR 22540 --- [nio-1110-exec-1] o.a.c.c.C.[.[.[/].[dispatcherServlet]    : Servlet.service() for servlet [dispatcherServlet] in context with path [] threw exception

feign.FeignException$Forbidden: status 403 reading SystemRemoteService#saveLoginLog(SysLoginLog)
	at feign.FeignException.clientErrorStatus(FeignException.java:163) ~[feign-core-10.4.0.jar!/:na]
	at feign.FeignException.errorStatus(FeignException.java:141) ~[feign-core-10.4.0.jar!/:na]
	at feign.FeignException.errorStatus(FeignException.java:133) ~[feign-core-10.4.0.jar!/:na]
	at feign.codec.ErrorDecoder$Default.decode(ErrorDecoder.java:92) ~[feign-core-10.4.0.jar!/:na]
	at feign.SynchronousMethodHandler.executeAndDecode(SynchronousMethodHandler.java:151) ~[feign-core-10.4.0.jar!/:na]
	at feign.SynchronousMethodHandler.invoke(SynchronousMethodHandler.java:80) ~[feign-core-10.4.0.jar!/:na]
	at feign.ReflectiveFeign$FeignInvocationHandler.invoke(ReflectiveFeign.java:103) ~[feign-core-10.4.0.jar!/:na]
	at com.sun.proxy.$Proxy143.saveLoginLog(Unknown Source) ~[na:na]
	at com.atguigu.system.filter.TokenLoginFilter.successfulAuthentication(TokenLoginFilter.java:100) ~[spring-security-1.0.jar!/:1.0]
	at org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter.doFilter(AbstractAuthenticationProcessingFilter.java:240) ~[spring-security-web-5.3.5.RELEASE.jar!/:5.3.5.RELEASE]
	at org.springframework.security.web.FilterChainProxy$VirtualFilterChain.doFilter(FilterChainProxy.java:334) ~[spring-security-web-5.3.5.RELEASE.jar!/:5.3.5.RELEASE]
	at com.atguigu.system.filter.TokenAuthenticationFilter.doFilterInternal(TokenAuthenticationFilter.java:50) ~[spring-security-1.0.jar!/:1.0]
	at org.springframework.web.filter.OncePerRequestFilter.doFilter(OncePerRequestFilter.java:119) ~[spring-web-5.2.11.RELEASE.jar!/:5.2.11.RELEASE]
	at org.springframework.security.web.FilterChainProxy$VirtualFilterChain.doFilter(FilterChainProxy.java:334) ~[spring-security-web-5.3.5.RELEASE.jar!/:5.3.5.RELEASE]
	at org.springframework.security.web.authentication.logout.LogoutFilter.doFilter(LogoutFilter.java:116) ~[spring-security-web-5.3.5.RELEASE.jar!/:5.3.5.RELEASE]
	at org.springframework.security.web.FilterChainProxy$VirtualFilterChain.doFilter(FilterChainProxy.java:334) ~[spring-security-web-5.3.5.RELEASE.jar!/:5.3.5.RELEASE]
	at org.springframework.web.filter.CorsFilter.doFilterInternal(CorsFilter.java:92) ~[spring-web-5.2.11.RELEASE.jar!/:5.2.11.RELEASE]
	at org.springframework.web.filter.OncePerRequestFilter.doFilter(OncePerRequestFilter.java:119) ~[spring-web-5.2.11.RELEASE.jar!/:5.2.11.RELEASE]
	at org.springframework.security.web.FilterChainProxy$VirtualFilterChain.doFilter(FilterChainProxy.java:334) ~[spring-security-web-5.3.5.RELEASE.jar!/:5.3.5.RELEASE]
	at org.springframework.security.web.header.HeaderWriterFilter.doHeadersAfter(HeaderWriterFilter.java:92) ~[spring-security-web-5.3.5.RELEASE.jar!/:5.3.5.RELEASE]
	at org.springframework.security.web.header.HeaderWriterFilter.doFilterInternal(HeaderWriterFilter.java:77) ~[spring-security-web-5.3.5.RELEASE.jar!/:5.3.5.RELEASE]
	at org.springframework.web.filter.OncePerRequestFilter.doFilter(OncePerRequestFilter.java:119) ~[spring-web-5.2.11.RELEASE.jar!/:5.2.11.RELEASE]
	at org.springframework.security.web.FilterChainProxy$VirtualFilterChain.doFilter(FilterChainProxy.java:334) ~[spring-security-web-5.3.5.RELEASE.jar!/:5.3.5.RELEASE]
	at org.springframework.security.web.context.SecurityContextPersistenceFilter.doFilter(SecurityContextPersistenceFilter.java:105) ~[spring-security-web-5.3.5.RELEASE.jar!/:5.3.5.RELEASE]
	at org.springframework.security.web.FilterChainProxy$VirtualFilterChain.doFilter(FilterChainProxy.java:334) ~[spring-security-web-5.3.5.RELEASE.jar!/:5.3.5.RELEASE]
	at org.springframework.security.web.context.request.async.WebAsyncManagerIntegrationFilter.doFilterInternal(WebAsyncManagerIntegrationFilter.java:56) ~[spring-security-web-5.3.5.RELEASE.jar!/:5.3.5.RELEASE]
	at org.springframework.web.filter.OncePerRequestFilter.doFilter(OncePerRequestFilter.java:119) ~[spring-web-5.2.11.RELEASE.jar!/:5.2.11.RELEASE]
	at org.springframework.security.web.FilterChainProxy$VirtualFilterChain.doFilter(FilterChainProxy.java:334) ~[spring-security-web-5.3.5.RELEASE.jar!/:5.3.5.RELEASE]
	at org.springframework.security.web.FilterChainProxy.doFilterInternal(FilterChainProxy.java:215) ~[spring-security-web-5.3.5.RELEASE.jar!/:5.3.5.RELEASE]
	at org.springframework.security.web.FilterChainProxy.doFilter(FilterChainProxy.java:178) ~[spring-security-web-5.3.5.RELEASE.jar!/:5.3.5.RELEASE]
	at org.springframework.web.filter.DelegatingFilterProxy.invokeDelegate(DelegatingFilterProxy.java:358) ~[spring-web-5.2.11.RELEASE.jar!/:5.2.11.RELEASE]
	at org.springframework.web.filter.DelegatingFilterProxy.doFilter(DelegatingFilterProxy.java:271) ~[spring-web-5.2.11.RELEASE.jar!/:5.2.11.RELEASE]
	at org.apache.catalina.core.ApplicationFilterChain.internalDoFilter(ApplicationFilterChain.java:193) ~[tomcat-embed-core-9.0.39.jar!/:9.0.39]
	at org.apache.catalina.core.ApplicationFilterChain.doFilter(ApplicationFilterChain.java:166) ~[tomcat-embed-core-9.0.39.jar!/:9.0.39]
	at org.springframework.web.filter.RequestContextFilter.doFilterInternal(RequestContextFilter.java:100) ~[spring-web-5.2.11.RELEASE.jar!/:5.2.11.RELEASE]
	at org.springframework.web.filter.OncePerRequestFilter.doFilter(OncePerRequestFilter.java:119) ~[spring-web-5.2.11.RELEASE.jar!/:5.2.11.RELEASE]
	at org.apache.catalina.core.ApplicationFilterChain.internalDoFilter(ApplicationFilterChain.java:193) ~[tomcat-embed-core-9.0.39.jar!/:9.0.39]
	at org.apache.catalina.core.ApplicationFilterChain.doFilter(ApplicationFilterChain.java:166) ~[tomcat-embed-core-9.0.39.jar!/:9.0.39]
	at org.springframework.web.filter.FormContentFilter.doFilterInternal(FormContentFilter.java:93) ~[spring-web-5.2.11.RELEASE.jar!/:5.2.11.RELEASE]
	at org.springframework.web.filter.OncePerRequestFilter.doFilter(OncePerRequestFilter.java:119) ~[spring-web-5.2.11.RELEASE.jar!/:5.2.11.RELEASE]
	at org.apache.catalina.core.ApplicationFilterChain.internalDoFilter(ApplicationFilterChain.java:193) ~[tomcat-embed-core-9.0.39.jar!/:9.0.39]
	at org.apache.catalina.core.ApplicationFilterChain.doFilter(ApplicationFilterChain.java:166) ~[tomcat-embed-core-9.0.39.jar!/:9.0.39]
	at org.springframework.web.filter.CharacterEncodingFilter.doFilterInternal(CharacterEncodingFilter.java:201) ~[spring-web-5.2.11.RELEASE.jar!/:5.2.11.RELEASE]
	at org.springframework.web.filter.OncePerRequestFilter.doFilter(OncePerRequestFilter.java:119) ~[spring-web-5.2.11.RELEASE.jar!/:5.2.11.RELEASE]
	at org.apache.catalina.core.ApplicationFilterChain.internalDoFilter(ApplicationFilterChain.java:193) ~[tomcat-embed-core-9.0.39.jar!/:9.0.39]
	at org.apache.catalina.core.ApplicationFilterChain.doFilter(ApplicationFilterChain.java:166) ~[tomcat-embed-core-9.0.39.jar!/:9.0.39]
	at org.apache.catalina.core.StandardWrapperValve.invoke(StandardWrapperValve.java:202) ~[tomcat-embed-core-9.0.39.jar!/:9.0.39]
	at org.apache.catalina.core.StandardContextValve.invoke(StandardContextValve.java:97) [tomcat-embed-core-9.0.39.jar!/:9.0.39]
	at org.apache.catalina.authenticator.AuthenticatorBase.invoke(AuthenticatorBase.java:542) [tomcat-embed-core-9.0.39.jar!/:9.0.39]
	at org.apache.catalina.core.StandardHostValve.invoke(StandardHostValve.java:143) [tomcat-embed-core-9.0.39.jar!/:9.0.39]
	at org.apache.catalina.valves.ErrorReportValve.invoke(ErrorReportValve.java:92) [tomcat-embed-core-9.0.39.jar!/:9.0.39]
	at org.apache.catalina.core.StandardEngineValve.invoke(StandardEngineValve.java:78) [tomcat-embed-core-9.0.39.jar!/:9.0.39]
	at org.apache.catalina.connector.CoyoteAdapter.service(CoyoteAdapter.java:343) [tomcat-embed-core-9.0.39.jar!/:9.0.39]
	at org.apache.coyote.http11.Http11Processor.service(Http11Processor.java:374) [tomcat-embed-core-9.0.39.jar!/:9.0.39]
	at org.apache.coyote.AbstractProcessorLight.process(AbstractProcessorLight.java:65) [tomcat-embed-core-9.0.39.jar!/:9.0.39]
	at org.apache.coyote.AbstractProtocol$ConnectionHandler.process(AbstractProtocol.java:868) [tomcat-embed-core-9.0.39.jar!/:9.0.39]
	at org.apache.tomcat.util.net.NioEndpoint$SocketProcessor.doRun(NioEndpoint.java:1590) [tomcat-embed-core-9.0.39.jar!/:9.0.39]
	at org.apache.tomcat.util.net.SocketProcessorBase.run(SocketProcessorBase.java:49) [tomcat-embed-core-9.0.39.jar!/:9.0.39]
	at java.util.concurrent.ThreadPoolExecutor.runWorker(ThreadPoolExecutor.java:1142) [na:1.8.0_121]
	at java.util.concurrent.ThreadPoolExecutor$Worker.run(ThreadPoolExecutor.java:617) [na:1.8.0_121]
	at org.apache.tomcat.util.threads.TaskThread$WrappingRunnable.run(TaskThread.java:61) [tomcat-embed-core-9.0.39.jar!/:9.0.39]
	at java.lang.Thread.run(Thread.java:745) [na:1.8.0_121]
```

### 6.1 （1）解决-请求白名单

![img](https://cdn.nlark.com/yuque/0/2022/png/12811585/1669596591087-c18c3633-c63a-482b-b778-e18d4b2081bb.png)

![img](https://cdn.nlark.com/yuque/0/2022/png/12811585/1669596603522-b2a01eee-752f-4fd5-ba46-68238cc2c5d5.png)

```java
package com.atguigu.system.filter;

import com.alibaba.fastjson.JSON;
import com.atguigu.common.result.Result;
import com.atguigu.common.result.ResultCodeEnum;
import com.atguigu.common.utils.JwtHelper;
import com.atguigu.common.utils.ResponseUtil;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.*;

/**
 * 认证解析过滤器
 *
 * @author 陈江林
 * @date 2022/11/23 00:23
 */
public class TokenAuthenticationFilter extends OncePerRequestFilter {

    private RedisTemplate redisTemplate;

    public TokenAuthenticationFilter(RedisTemplate redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        String requestURI = request.getRequestURI();
        logger.info("uri:" + requestURI);
        // 请求白名单
        List<String> list = new ArrayList<>();
        // 登录接口
        list.add("/admin/system/index/login");
        // 保存登录日志
        list.add("/api/system/sysLoginLog/save");

        // 如果是登录接口，或保存登录日志...直接放行
        if (list.contains(requestURI)) {
            chain.doFilter(request, response);
            return;
        }

        UsernamePasswordAuthenticationToken authentication = getAuthentication(request);
        if (null != authentication) {
            SecurityContextHolder.getContext().setAuthentication(authentication);
            chain.doFilter(request, response);
        } else {
            ResponseUtil.out(response, Result.build(null, ResultCodeEnum.PERMISSION));
        }
    }

    private UsernamePasswordAuthenticationToken getAuthentication(HttpServletRequest request) {
        // token置于header里
        String token = request.getHeader("token");
        logger.info("token:" + token);
        if (!StringUtils.isEmpty(token)) {
            String username = JwtHelper.getUsername(token);
            logger.info("username:" + username);
            Object authoritiesObj = redisTemplate.opsForValue().get(username);
            if (!StringUtils.isEmpty(username) && null != authoritiesObj) {
                // 权限
                String authoritiesString = authoritiesObj.toString();
                List<Map> mapList = JSON.parseArray(authoritiesString, Map.class);
                List<SimpleGrantedAuthority> authorities = new ArrayList<>();
                mapList.forEach(map -> authorities.add(new SimpleGrantedAuthority(map.get("authority").toString())));

                return new UsernamePasswordAuthenticationToken(username, null, authorities);
            }
        }

        return null;
    }
}
```





### 6.1 （2）解决`403`错误，配置`Spring-Security`

![img](https://cdn.nlark.com/yuque/0/2022/png/12811585/1669610015814-aec5c714-86da-42e6-bfdf-1efb2d4f7390.png)

```java
package com.atguigu.system.config;

import com.atguigu.service.api.SystemRemoteService;
import com.atguigu.system.filter.TokenAuthenticationFilter;
import com.atguigu.system.filter.TokenLoginFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

/**
 * Spring Security 配置类
 * `@EnableGlobalMethodSecurity(prePostEnabled = true)`：开启注解功能，默认禁用注解
 *
 * @author 陈江林
 * @date 2022/11/21 21:33
 */
@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private RedisTemplate redisTemplate;

//    @Autowired
//    private LoginLogService loginLogService;

    @Autowired
    private SystemRemoteService systemRemoteService;

    /**
     * 加密方式
     *
     * @return {@link PasswordEncoder}
     */
    @Bean
    public PasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        // 这是配置的关键，决定哪些接口开启防护，哪些接口绕过防护
        http
                // 关闭csrf
                .csrf().disable()
                // 开启跨域以便前端调用接口
                .cors().and()
                .authorizeRequests()
                // 指定某些接口不需要通过验证即可访问。登陆接口肯定是不需要认证的
                .antMatchers("/admin/system/index/login").permitAll()
                .antMatchers("/api/**").permitAll()
                // 这里意思是其它所有接口需要认证才能访问
                .anyRequest().authenticated()
                .and()
                // TokenAuthenticationFilter放到UsernamePasswordAuthenticationFilter的前面，这样做就是为了除了登录的时候去查询数据库外，其他时候都用token进行认证。
                .addFilterBefore(new TokenAuthenticationFilter(redisTemplate), UsernamePasswordAuthenticationFilter.class)
                .addFilter(new TokenLoginFilter(authenticationManager(), redisTemplate, systemRemoteService));

        // 禁用session
        http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
    }

    /**
     * 配置哪些请求不拦截
     * 排除swagger相关请求
     *
     * @param web
     */
    @Override
    public void configure(WebSecurity web) {
        web.ignoring().antMatchers("/favicon.ico", "/swagger-resources/**", "/webjars/**", "/v2/**", "/swagger-ui.html/**", "/doc.html");
    }
}
```


# 十二 项目部署

项目地址：`http://175.178.174.83:1127/#/dashboard`

## 1 一般项目部署

### 1.1 前端部署

1. 编译`npm run build:prod`
2. 将`./dist`目录下文件上传至服务器
3. 配置`nginx`

```nginx
  server {
    listen 1127;
    server_name localhost;

    location / {
      root /usr/local/nginx/html/system;
      index index.html;
    }

    location /prod-api/ {
      proxy_pass http://127.0.0.1:1128/;
    }
  }
```

1. 重启`nginx`：`systemctl restart nginx`



## 1.2 后端部署

1. `maven`命令：`mvn clean package -Dmaven.test.skip=true`
2. 将`jar`包上传
3. 编写并运行脚本`restart.sh`

```shell
#!/bin/bash
echo -e "\033[32m重启通用权限系统服务模块\033[0m"
ps -ef | grep 'service-system.jar' | grep -v grep | cut -c 10-15 | xargs kill -9
ps -ef | grep 'service-gateway.jar' | grep -v grep | cut -c 10-15 | xargs kill -9

sleep 3s

nohup java -jar /root/apps/auth/jar/service/service-system/target/service-system.jar --spring.profiles.active='prod' --spring.datasource.url='jdbc:mysql://127.0.0.1:3306/guigu-auth?characterEncoding=utf-8&useSSL=false' --spring.datasource.password='12345678' > /root/apps/auth/sh/log/system.out &
nohup java -jar /root/apps/auth/jar/service-gateway/target/service-gateway.jar > /root/apps/auth/sh/log/gateway.out &
```





## 2 `阿里云效`自动化部署

使用`GitHub`：拉取`GitHub`代码可能会失败，导致部署失败，手动运行就好

### 2.1 前端自动化部署

#### 2.1.1 新建流水线

- 选择模板





### 2.2 后端自动化部署

- 使用`阿里云效`流水线自动化部署

#### 2.2.1 推送`Maven`仓库

![img](https://cdn.nlark.com/yuque/0/2022/png/12811585/1669585772336-479c756d-7d7e-484b-a8d7-830a2ec92a90.png)

![img](https://cdn.nlark.com/yuque/0/2022/png/12811585/1669585891151-a05b65c6-9a1d-4b7e-8af3-98cb04760cbc.png)

1. 下载你的`settings.xml`
2. `idea`设置`settings.xml`

![img](https://cdn.nlark.com/yuque/0/2022/png/12811585/1669586034854-d797c47e-1252-45dc-91c9-c8ec6c07cb46.png)

1. 执行命令`mvn clean install org.apache.maven.plugins:maven-deploy-plugin:2.8:deploy -DskipTests`
2. 推送成功

![img](https://cdn.nlark.com/yuque/0/2022/png/12811585/1669586504333-ace1c4c9-7ad6-4e51-bb77-438bd70d6099.png)



#### 2.2.2 覆盖推送-重复（仓库是禁止覆盖的）

- 仓库设置 -> 仓库策略 -> 打开允许覆盖

![img](https://cdn.nlark.com/yuque/0/2022/png/12811585/1669587825037-3933b312-5589-4d6b-b6f3-03d20e8fbbaa.png)



#### 2.2.3 流水线

1. 新建流水线
2. 选择模板

![img](https://cdn.nlark.com/yuque/0/2022/png/12811585/1669588286401-c2d37933-a646-4e9a-8b36-ff7d056fa84c.png)



#### 2.2.4 流水线源

1. 在 `Flow` 流水线，点击编辑流水线，点击编辑代码源。
2. 开启代码提交触发监听，并将对应的 `WebHook` 复制出来

![img](https://cdn.nlark.com/yuque/0/2022/png/12811585/1669588658228-4a2c04df-0dd9-4370-99aa-553a5dff0c53.png)

1. 在 `Github` 配置 `WebHook`

1. 1. `Github` 的代码库地址，在代码库 --> `Settings` (设置) ---> `Webhooks`中，点击 `Add Webhook`
2. 将 `Flow` 流水线上复制的 `WebHook` 地址，填入 `Payload URL`
3. 将 `Content Type` 选择为 `“application/json”`

![img](https://cdn.nlark.com/yuque/0/2022/png/12811585/1669588919280-0c40bee3-959e-42c2-b05a-4884d5a2ea5f.png)



#### 2.2.5 `Java`构建物上传

![img](https://cdn.nlark.com/yuque/0/2022/png/12811585/1669588010056-0e3bff5a-70fa-42e5-99d9-85c331c83897.png)



#### 2.2.6 主机部署

![img](https://cdn.nlark.com/yuque/0/2022/png/12811585/1669588053362-4e0d20b3-b0a9-4b4e-ba88-a6a3c26bb5ff.png)

- 下载路径`/root/apps/auth/package.tgz`
- 部署脚本

```shell
tar zxvf /root/apps/auth/package.tgz -C /root/apps/auth/jar/
sh /root/apps/auth/sh/restart.sh
```

- `restart`脚本

```shell
#!/bin/bash
echo -e "\033[32m重启通用权限系统服务模块\033[0m"
ps -ef | grep 'service-system.jar' | grep -v grep | cut -c 10-15 | xargs kill -9
ps -ef | grep 'service-gateway.jar' | grep -v grep | cut -c 10-15 | xargs kill -9

sleep 3s

nohup java -jar /root/apps/auth/jar/service/service-system/target/service-system.jar --spring.profiles.active='prod' --spring.datasource.url='jdbc:mysql://127.0.0.1:3306/guigu-auth?characterEncoding=utf-8&useSSL=false' --spring.datasource.password='12345678' > /root/apps/auth/sh/log/system.out &
nohup java -jar /root/apps/auth/jar/service-gateway/target/service-gateway.jar > /root/apps/auth/sh/log/gateway.out &
```



## 3 前端使用`GitHub`的`Actions`自动化部署

此处为语雀内容卡片，点击链接查看：https://www.yuque.com/lingchen-bf1rc/ukl25l/rtpxdp
