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
    `is_deleted`  tinyint(3)  NOT NULL DEFAULT '0' COMMENT '删除标记（0:可用 其他:已删除）',
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
    `is_deleted`  tinyint(3) NOT NULL DEFAULT '0' COMMENT '删除标记（0:可用 其他:已删除）',
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
    `is_deleted`  tinyint(3)  NOT NULL DEFAULT '0' COMMENT '删除标记（0:可用 其他:已删除）',
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
       (6, 3, '查看', 2, NULL, NULL, 'bnt.sysUser.list', NULL, 1, 1, '2021-05-31 18:05:37', '2022-06-09 09:22:38', 0),
       (7, 3, '添加', 2, NULL, NULL, 'bnt.sysUser.add', NULL, 1, 1, '2021-05-31 18:05:37', '2022-06-09 09:22:38', 0),
       (8, 3, '修改', 2, NULL, NULL, 'bnt.sysUser.update', NULL, 1, 1, '2021-05-31 18:05:37', '2022-06-09 09:22:38', 0),
       (9, 3, '删除', 2, NULL, NULL, 'bnt.sysUser.remove', NULL, 1, 1, '2021-05-31 18:05:37', '2022-06-09 09:22:38', 0),
       (10, 4, '查看', 2, NULL, NULL, 'bnt.sysRole.list', NULL, 1, 1, '2021-05-31 18:05:37', '2022-06-09 09:22:38', 0),
       (11, 4, '添加', 2, NULL, NULL, 'bnt.sysRole.add', NULL, 1, 1, '2021-05-31 18:05:37', '2022-06-09 09:22:38', 0),
       (12, 4, '修改', 2, NULL, NULL, 'bnt.sysRole.update', NULL, 1, 1, '2021-05-31 18:05:37', '2022-06-09 09:22:38', 0),
       (13, 4, '删除', 2, NULL, NULL, 'bnt.sysRole.remove', NULL, 1, 1, '2021-05-31 18:05:37', '2022-06-09 09:22:38', 0),
       (14, 5, '查看', 2, NULL, NULL, 'bnt.sysMenu.list', NULL, 1, 1, '2021-05-31 18:05:37', '2022-06-09 09:22:38', 0),
       (15, 5, '添加', 2, NULL, NULL, 'bnt.sysMenu.add', NULL, 1, 1, '2021-05-31 18:05:37', '2022-06-09 09:22:38', 0),
       (16, 5, '修改', 2, NULL, NULL, 'bnt.sysMenu.update', NULL, 1, 1, '2021-05-31 18:05:37', '2022-06-09 09:22:38', 0),
       (17, 5, '删除', 2, NULL, NULL, 'bnt.sysMenu.remove', NULL, 1, 1, '2021-05-31 18:05:37', '2022-06-09 09:22:38', 0),
       (18, 3, '分配角色', 2, NULL, NULL, 'bnt.sysUser.assignRole', NULL, 1, 1, '2022-05-23 17:14:32',
        '2022-06-09 09:22:38', 0),
       (19, 4, '分配权限', 2, 'assignAuth', 'system/sysRole/assignAuth', 'bnt.sysRole.assignAuth', NULL, 1, 1,
        '2022-05-23 17:18:14', '2022-06-09 09:22:38', 0),
       (20, 2, '部门管理', 1, 'sysDept', 'system/sysDept/list', '', 'el-icon-s-operation', 4, 1, '2022-05-24 10:07:05',
        '2022-06-09 09:38:12', 0),
       (21, 20, '查看', 2, NULL, NULL, 'bnt.sysDept.list', NULL, 1, 1, '2022-05-24 10:07:44', '2022-06-09 09:22:38', 0),
       (22, 2, '岗位管理', 1, 'sysPost', 'system/sysPost/list', '', 'el-icon-more-outline', 5, 1, '2022-05-24 10:25:30',
        '2022-06-09 09:38:13', 0),
       (23, 22, '查看', 2, NULL, NULL, 'bnt.sysPost.list', NULL, 1, 1, '2022-05-24 10:25:45', '2022-06-09 09:22:38', 0),
       (24, 20, '添加', 2, NULL, NULL, 'bnt.sysDept.add', NULL, 1, 1, '2022-05-25 15:31:27', '2022-06-09 09:22:38', 0),
       (25, 20, '修改', 2, NULL, NULL, 'bnt.sysDept.update', NULL, 1, 1, '2022-05-25 15:31:41', '2022-06-09 09:22:38', 0),
       (26, 20, '删除', 2, NULL, NULL, 'bnt.sysDept.remove', NULL, 1, 1, '2022-05-25 15:31:59', '2022-06-09 09:22:38', 0),
       (27, 22, '添加', 2, NULL, NULL, 'bnt.sysPost.add', NULL, 1, 1, '2022-05-25 15:32:44', '2022-06-09 09:22:38', 0),
       (28, 22, '修改', 2, NULL, NULL, 'bnt.sysPost.update', NULL, 1, 1, '2022-05-25 15:32:58', '2022-06-09 09:22:38', 0),
       (29, 22, '删除', 2, NULL, NULL, 'bnt.sysPost.remove', NULL, 1, 1, '2022-05-25 15:33:11', '2022-06-09 09:22:38', 0),
       (30, 34, '操作日志', 1, 'sysOperLog', 'system/sysOperLog/list', '', 'el-icon-document-remove', 7, 1,
        '2022-05-26 16:09:59', '2022-06-09 09:39:23', 0),
       (31, 30, '查看', 2, NULL, NULL, 'bnt.sysOperLog.list', NULL, 1, 1, '2022-05-26 16:10:17', '2022-06-09 09:22:38',
        0),
       (32, 34, '登录日志', 1, 'sysLoginLog', 'system/sysLoginLog/list', '', 'el-icon-s-goods', 8, 1, '2022-05-26 16:36:13',
        '2022-06-09 09:39:24', 0),
       (33, 32, '查看', 2, NULL, NULL, 'bnt.sysLoginLog.list', NULL, 1, 1, '2022-05-26 16:36:31', '2022-06-09 09:36:36',
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
        '{\"code\":\"sysUser\",\"select\":false,\"level\":3,\"updateTime\":1653957062000,\"type\":1,\"parentId\":2,\"path\":\"sysUser/list\",\"sortValue\":1,\"component\":\"auth/sysUser/list\",\"isDeleted\":0,\"children\":[{\"code\":\"bnt.sysUser.list\",\"select\":false,\"level\":4,\"updateTime\":1653957062000,\"type\":2,\"parentId\":3,\"isDeleted\":0,\"children\":[],\"createTime\":1622455537000,\"param\":{},\"name\":\"查看\",\"id\":6,\"status\":1},{\"code\":\"bnt.sysUser.add\",\"select\":false,\"level\":4,\"updateTime\":1653957062000,\"type\":2,\"parentId\":3,\"isDeleted\":0,\"children\":[],\"createTime\":1622455537000,\"param\":{},\"name\":\"添加\",\"id\":7,\"status\":1},{\"code\":\"bnt.sysUser.update\",\"select\":false,\"level\":4,\"updateTime\":1653957062000,\"type\":2,\"parentId\":3,\"isDeleted\":0,\"children\":[],\"createTime\":1622455537000,\"param\":{},\"name\":\"修改\",\"id\":8,\"status\":1},{\"code\":\"bnt.sysUser.remove\",\"select\":false,\"level\":4,\"updateTime\":1653957062000,\"type\":2,\"parentId\":3,\"isDeleted\":0,\"children\":[],\"createTime\":1622455537000,\"param\":{},\"name\":\"删除\",\"id\":9,\"status\":1},{\"code\":\"bnt.sysUser.assignRole\",\"select\":false,\"level\":4,\"toCode\":\"\",\"updateTime\":1653957062000,\"type\":2,\"parentId\":3,\"isDeleted\":0,\"children\":[],\"createTime\":1653297272000,\"param\":{},\"name\":\"分配角色\",\"id\":18,\"status\":1}],\"createTime\":1622455537000,\"param\":{},\"name\":\"用户管理\",\"perms\":\"bnt.sysUser.list\",\"id\":3,\"status\":1}',
        '{\"code\":200,\"message\":\"成功\"}', 1, '', NULL, '2022-05-31 09:14:26', NULL, 0),
       (20, '菜单管理', 'UPDATE', 'com.atguigu.auth.controller.SysMenuController.updateById()', 'PUT', 'MANAGE', 'admin',
        '', '/admin/auth/sysMenu/update', '127.0.0.1',
        '{\"code\":\"sysRole\",\"select\":false,\"level\":3,\"updateTime\":1653957062000,\"type\":1,\"parentId\":2,\"path\":\"sysRole/list\",\"sortValue\":0,\"component\":\"auth/sysRole/list\",\"isDeleted\":0,\"children\":[{\"code\":\"bnt.sysRole.list\",\"select\":false,\"level\":4,\"updateTime\":1653959708000,\"type\":2,\"parentId\":4,\"isDeleted\":0,\"children\":[],\"createTime\":1622455537000,\"param\":{},\"name\":\"查看\",\"perms\":\"bnt.sysRole.list\",\"id\":10,\"status\":1},{\"code\":\"bnt.sysRole.add\",\"select\":false,\"level\":4,\"updateTime\":1653959708000,\"type\":2,\"parentId\":4,\"isDeleted\":0,\"children\":[],\"createTime\":1622455537000,\"param\":{},\"name\":\"添加\",\"perms\":\"bnt.sysRole.add\",\"id\":11,\"status\":1},{\"code\":\"bnt.sysRole.update\",\"select\":false,\"level\":4,\"updateTime\":1653959708000,\"type\":2,\"parentId\":4,\"isDeleted\":0,\"children\":[],\"createTime\":1622455537000,\"param\":{},\"name\":\"修改\",\"perms\":\"bnt.sysRole.update\",\"id\":12,\"status\":1},{\"code\":\"bnt.sysRole.remove\",\"select\":false,\"level\":4,\"updateTime\":1653959708000,\"type\":2,\"parentId\":4,\"isDeleted\":0,\"children\":[],\"createTime\":1622455537000,\"param\":{},\"name\":\"删除\",\"perms\":\"bnt.sysRole.remove\",\"id\":13,\"status\":1},{\"code\":\"bnt.sysRole.assignAuth\",\"select\":false,\"level\":4,\"toCode\":\"assignAuth\",\"updateTime\":1653959708000,\"type\":2,\"parentId\":4,\"isDeleted\":0,\"children\":[],\"createTime\":1653297494000,\"param\":{},\"name\":\"分配权限\",\"perms\":\"bnt.sysRole.assignAuth\",\"id\":19,\"status\":1}],\"createTime\":1622455537000,\"param\":{},\"name\":\"角色管理\",\"perms\":\" bnt.sysRole.list\",\"id\":4,\"status\":1}',
        '{\"code\":200,\"message\":\"成功\"}', 1, '', NULL, '2022-05-31 09:18:12', NULL, 0),
       (21, '菜单管理', 'UPDATE', 'com.atguigu.auth.controller.SysMenuController.updateById()', 'PUT', 'MANAGE', 'admin',
        '', '/admin/auth/sysMenu/update', '127.0.0.1',
        '{\"code\":\"sysMenu\",\"select\":false,\"level\":3,\"updateTime\":1653957062000,\"type\":1,\"parentId\":2,\"path\":\"sysMenu/list\",\"sortValue\":0,\"component\":\"auth/sysMenu/list\",\"isDeleted\":0,\"children\":[{\"code\":\"bnt.sysMenu.list\",\"select\":false,\"level\":4,\"updateTime\":1653959708000,\"type\":2,\"parentId\":5,\"isDeleted\":0,\"children\":[],\"createTime\":1622455537000,\"param\":{},\"name\":\"查看\",\"perms\":\"bnt.sysMenu.list\",\"id\":14,\"status\":1},{\"code\":\"bnt.sysMenu.add\",\"select\":false,\"level\":4,\"updateTime\":1653959708000,\"type\":2,\"parentId\":5,\"isDeleted\":0,\"children\":[],\"createTime\":1622455537000,\"param\":{},\"name\":\"添加\",\"perms\":\"bnt.sysMenu.add\",\"id\":15,\"status\":1},{\"code\":\"bnt.sysMenu.update\",\"select\":false,\"level\":4,\"updateTime\":1653959708000,\"type\":2,\"parentId\":5,\"isDeleted\":0,\"children\":[],\"createTime\":1622455537000,\"param\":{},\"name\":\"修改\",\"perms\":\"bnt.sysMenu.update\",\"id\":16,\"status\":1},{\"code\":\"bnt.sysMenu.remove\",\"select\":false,\"level\":4,\"updateTime\":1653959708000,\"type\":2,\"parentId\":5,\"isDeleted\":0,\"children\":[],\"createTime\":1622455537000,\"param\":{},\"name\":\"删除\",\"perms\":\"bnt.sysMenu.remove\",\"id\":17,\"status\":1}],\"createTime\":1622455537000,\"param\":{},\"name\":\"菜单管理\",\"perms\":\"bnt.sysMenu.list\",\"id\":5,\"status\":1}',
        '{\"code\":200,\"message\":\"成功\"}', 1, '', NULL, '2022-05-31 09:18:37', NULL, 0),
       (22, '菜单管理', 'UPDATE', 'com.atguigu.auth.controller.SysMenuController.updateById()', 'PUT', 'MANAGE', 'admin',
        '', '/admin/auth/sysMenu/update', '127.0.0.1',
        '{\"code\":\"sysDept\",\"select\":false,\"level\":3,\"toCode\":\"\",\"updateTime\":1653957062000,\"type\":1,\"parentId\":2,\"path\":\"sysDept/list\",\"sortValue\":0,\"component\":\"auth/sysDept/list\",\"isDeleted\":0,\"children\":[{\"code\":\"bnt.sysDept.list\",\"select\":false,\"level\":4,\"toCode\":\"\",\"updateTime\":1653959708000,\"type\":2,\"parentId\":20,\"isDeleted\":0,\"children\":[],\"createTime\":1653358064000,\"param\":{},\"name\":\"查看\",\"perms\":\"bnt.sysDept.list\",\"id\":21,\"status\":1},{\"code\":\"bnt.sysDept.add\",\"select\":false,\"level\":4,\"toCode\":\"\",\"updateTime\":1653959708000,\"type\":2,\"parentId\":20,\"isDeleted\":0,\"children\":[],\"createTime\":1653463887000,\"param\":{},\"name\":\"添加\",\"perms\":\"bnt.sysDept.add\",\"id\":24,\"status\":1},{\"code\":\"bnt.sysDept.update\",\"select\":false,\"level\":4,\"toCode\":\"\",\"updateTime\":1653959708000,\"type\":2,\"parentId\":20,\"isDeleted\":0,\"children\":[],\"createTime\":1653463901000,\"param\":{},\"name\":\"修改\",\"perms\":\"bnt.sysDept.update\",\"id\":25,\"status\":1},{\"code\":\"bnt.sysDept.remove\",\"select\":false,\"level\":4,\"toCode\":\"\",\"updateTime\":1653959708000,\"type\":2,\"parentId\":20,\"isDeleted\":0,\"children\":[],\"createTime\":1653463919000,\"param\":{},\"name\":\"删除\",\"perms\":\"bnt.sysDept.remove\",\"id\":26,\"status\":1}],\"createTime\":1653358025000,\"param\":{},\"name\":\"部门管理\",\"perms\":\"bnt.sysDept.list\",\"id\":20,\"status\":1}',
        '{\"code\":200,\"message\":\"成功\"}', 1, '', NULL, '2022-05-31 09:19:04', NULL, 0),
       (23, '菜单管理', 'UPDATE', 'com.atguigu.auth.controller.SysMenuController.updateById()', 'PUT', 'MANAGE', 'admin',
        '', '/admin/auth/sysMenu/update', '127.0.0.1',
        '{\"code\":\"sysPost\",\"select\":false,\"level\":3,\"toCode\":\"\",\"updateTime\":1653957062000,\"type\":1,\"parentId\":2,\"path\":\"sysPost/list\",\"sortValue\":0,\"component\":\"auth/sysPost/list\",\"isDeleted\":0,\"children\":[{\"code\":\"bnt.sysPost.list\",\"select\":false,\"level\":4,\"toCode\":\"\",\"updateTime\":1653959708000,\"type\":2,\"parentId\":22,\"isDeleted\":0,\"children\":[],\"createTime\":1653359145000,\"param\":{},\"name\":\"查看\",\"perms\":\"bnt.sysPost.list\",\"id\":23,\"status\":1},{\"code\":\"bnt.sysPost.add\",\"select\":false,\"level\":4,\"toCode\":\"\",\"updateTime\":1653959708000,\"type\":2,\"parentId\":22,\"isDeleted\":0,\"children\":[],\"createTime\":1653463964000,\"param\":{},\"name\":\"添加\",\"perms\":\"bnt.sysPost.add\",\"id\":27,\"status\":1},{\"code\":\"bnt.sysPost.update\",\"select\":false,\"level\":4,\"toCode\":\"\",\"updateTime\":1653959708000,\"type\":2,\"parentId\":22,\"isDeleted\":0,\"children\":[],\"createTime\":1653463978000,\"param\":{},\"name\":\"修改\",\"perms\":\"bnt.sysPost.update\",\"id\":28,\"status\":1},{\"code\":\"bnt.sysPost.remove\",\"select\":false,\"level\":4,\"toCode\":\"\",\"updateTime\":1653959708000,\"type\":2,\"parentId\":22,\"isDeleted\":0,\"children\":[],\"createTime\":1653463991000,\"param\":{},\"name\":\"删除\",\"perms\":\"bnt.sysPost.remove\",\"id\":29,\"status\":1}],\"createTime\":1653359130000,\"param\":{},\"name\":\"岗位管理\",\"perms\":\"bnt.sysPost.list\",\"id\":22,\"status\":1}',
        '{\"code\":200,\"message\":\"成功\"}', 1, '', NULL, '2022-05-31 09:19:23', NULL, 0),
       (24, '菜单管理', 'UPDATE', 'com.atguigu.auth.controller.SysMenuController.updateById()', 'PUT', 'MANAGE', 'admin',
        '', '/admin/auth/sysMenu/update', '127.0.0.1',
        '{\"code\":\"sysOperLog\",\"select\":false,\"level\":3,\"toCode\":\"\",\"updateTime\":1653957062000,\"type\":1,\"parentId\":2,\"path\":\"sysOperLog/list\",\"sortValue\":0,\"component\":\"auth/sysOperLog/list\",\"isDeleted\":0,\"children\":[{\"code\":\"bnt.sysOperLog.list\",\"select\":false,\"level\":4,\"toCode\":\"\",\"updateTime\":1653959708000,\"type\":2,\"parentId\":30,\"isDeleted\":0,\"children\":[],\"createTime\":1653552617000,\"param\":{},\"name\":\"查看\",\"perms\":\"bnt.sysOperLog.list\",\"id\":31,\"status\":1}],\"createTime\":1653552599000,\"param\":{},\"name\":\"操作日志\",\"perms\":\"bnt.sysOperLog.list\",\"id\":30,\"status\":1}',
        '{\"code\":200,\"message\":\"成功\"}', 1, '', NULL, '2022-05-31 09:19:40', NULL, 0),
       (25, '菜单管理', 'UPDATE', 'com.atguigu.auth.controller.SysMenuController.updateById()', 'PUT', 'MANAGE', 'admin',
        '', '/admin/auth/sysMenu/update', '127.0.0.1',
        '{\"code\":\"sysLoginLog\",\"select\":false,\"level\":3,\"toCode\":\"\",\"updateTime\":1653957062000,\"type\":1,\"parentId\":2,\"path\":\"sysLoginLog/list\",\"sortValue\":0,\"component\":\"auth/sysLoginLog/list\",\"isDeleted\":0,\"children\":[{\"code\":\"bnt.sysLoginLog.list\",\"select\":false,\"level\":4,\"toCode\":\"\",\"updateTime\":1653957062000,\"type\":1,\"parentId\":32,\"isDeleted\":0,\"children\":[],\"createTime\":1653554191000,\"param\":{},\"name\":\"查看\",\"id\":33,\"status\":1}],\"createTime\":1653554173000,\"param\":{},\"name\":\"登录日志\",\"perms\":\" bnt.sysLoginLog.list\",\"id\":32,\"status\":1}',
        '{\"code\":200,\"message\":\"成功\"}', 1, '', NULL, '2022-05-31 09:20:09', NULL, 0),
       (26, '菜单管理', 'UPDATE', 'com.atguigu.auth.controller.SysMenuController.updateById()', 'PUT', 'MANAGE', 'admin',
        '', '/admin/auth/sysMenu/update', '127.0.0.1',
        '{\"code\":\"sysUser\",\"select\":false,\"level\":2,\"updateTime\":1653957062000,\"type\":1,\"parentId\":2,\"path\":\"sysUser\",\"sortValue\":1,\"component\":\"auth/sysUser/list\",\"isDeleted\":0,\"children\":[{\"code\":\"bnt.sysUser.list\",\"select\":false,\"level\":3,\"updateTime\":1653959708000,\"type\":2,\"parentId\":3,\"isDeleted\":0,\"children\":[],\"createTime\":1622455537000,\"param\":{},\"name\":\"查看\",\"perms\":\"bnt.sysUser.list\",\"id\":6,\"status\":1},{\"code\":\"bnt.sysUser.add\",\"select\":false,\"level\":3,\"updateTime\":1653959708000,\"type\":2,\"parentId\":3,\"isDeleted\":0,\"children\":[],\"createTime\":1622455537000,\"param\":{},\"name\":\"添加\",\"perms\":\"bnt.sysUser.add\",\"id\":7,\"status\":1},{\"code\":\"bnt.sysUser.update\",\"select\":false,\"level\":3,\"updateTime\":1653959708000,\"type\":2,\"parentId\":3,\"isDeleted\":0,\"children\":[],\"createTime\":1622455537000,\"param\":{},\"name\":\"修改\",\"perms\":\"bnt.sysUser.update\",\"id\":8,\"status\":1},{\"code\":\"bnt.sysUser.remove\",\"select\":false,\"level\":3,\"updateTime\":1653959708000,\"type\":2,\"parentId\":3,\"isDeleted\":0,\"children\":[],\"createTime\":1622455537000,\"param\":{},\"name\":\"删除\",\"perms\":\"bnt.sysUser.remove\",\"id\":9,\"status\":1},{\"code\":\"bnt.sysUser.assignRole\",\"select\":false,\"level\":3,\"toCode\":\"\",\"updateTime\":1653959708000,\"type\":2,\"parentId\":3,\"isDeleted\":0,\"children\":[],\"createTime\":1653297272000,\"param\":{},\"name\":\"分配角色\",\"perms\":\"bnt.sysUser.assignRole\",\"id\":18,\"status\":1}],\"createTime\":1622455537000,\"param\":{},\"name\":\"用户管理\",\"perms\":\"bnt.sysUser.list\",\"id\":3,\"status\":1}',
        '{\"code\":200,\"message\":\"成功\"}', 1, '', NULL, '2022-05-31 09:41:35', NULL, 0),
       (27, '菜单管理', 'UPDATE', 'com.atguigu.auth.controller.SysMenuController.updateById()', 'PUT', 'MANAGE', 'admin',
        '', '/admin/auth/sysMenu/update', '127.0.0.1',
        '{\"code\":\"sysRole\",\"select\":false,\"level\":2,\"updateTime\":1653957062000,\"type\":1,\"parentId\":2,\"path\":\"sysRole\",\"sortValue\":0,\"component\":\"auth/sysRole/list\",\"isDeleted\":0,\"children\":[{\"code\":\"bnt.sysRole.list\",\"select\":false,\"level\":3,\"updateTime\":1653959708000,\"type\":2,\"parentId\":4,\"isDeleted\":0,\"children\":[],\"createTime\":1622455537000,\"param\":{},\"name\":\"查看\",\"perms\":\"bnt.sysRole.list\",\"id\":10,\"status\":1},{\"code\":\"bnt.sysRole.add\",\"select\":false,\"level\":3,\"updateTime\":1653959708000,\"type\":2,\"parentId\":4,\"isDeleted\":0,\"children\":[],\"createTime\":1622455537000,\"param\":{},\"name\":\"添加\",\"perms\":\"bnt.sysRole.add\",\"id\":11,\"status\":1},{\"code\":\"bnt.sysRole.update\",\"select\":false,\"level\":3,\"updateTime\":1653959708000,\"type\":2,\"parentId\":4,\"isDeleted\":0,\"children\":[],\"createTime\":1622455537000,\"param\":{},\"name\":\"修改\",\"perms\":\"bnt.sysRole.update\",\"id\":12,\"status\":1},{\"code\":\"bnt.sysRole.remove\",\"select\":false,\"level\":3,\"updateTime\":1653959708000,\"type\":2,\"parentId\":4,\"isDeleted\":0,\"children\":[],\"createTime\":1622455537000,\"param\":{},\"name\":\"删除\",\"perms\":\"bnt.sysRole.remove\",\"id\":13,\"status\":1},{\"code\":\"bnt.sysRole.assignAuth\",\"select\":false,\"level\":3,\"toCode\":\"assignAuth\",\"updateTime\":1653959708000,\"type\":2,\"parentId\":4,\"isDeleted\":0,\"children\":[],\"createTime\":1653297494000,\"param\":{},\"name\":\"分配权限\",\"perms\":\"bnt.sysRole.assignAuth\",\"id\":19,\"status\":1}],\"createTime\":1622455537000,\"param\":{},\"name\":\"角色管理\",\"perms\":\" bnt.sysRole.list\",\"id\":4,\"status\":1}',
        '{\"code\":200,\"message\":\"成功\"}', 1, '', NULL, '2022-05-31 09:41:42', NULL, 0),
       (28, '菜单管理', 'UPDATE', 'com.atguigu.auth.controller.SysMenuController.updateById()', 'PUT', 'MANAGE', 'admin',
        '', '/admin/auth/sysMenu/update', '127.0.0.1',
        '{\"code\":\"sysMenu\",\"select\":false,\"level\":2,\"updateTime\":1653957062000,\"type\":1,\"parentId\":2,\"path\":\"sysMenu\",\"sortValue\":0,\"component\":\"auth/sysMenu/list\",\"isDeleted\":0,\"children\":[{\"code\":\"bnt.sysMenu.list\",\"select\":false,\"level\":3,\"updateTime\":1653959708000,\"type\":2,\"parentId\":5,\"isDeleted\":0,\"children\":[],\"createTime\":1622455537000,\"param\":{},\"name\":\"查看\",\"perms\":\"bnt.sysMenu.list\",\"id\":14,\"status\":1},{\"code\":\"bnt.sysMenu.add\",\"select\":false,\"level\":3,\"updateTime\":1653959708000,\"type\":2,\"parentId\":5,\"isDeleted\":0,\"children\":[],\"createTime\":1622455537000,\"param\":{},\"name\":\"添加\",\"perms\":\"bnt.sysMenu.add\",\"id\":15,\"status\":1},{\"code\":\"bnt.sysMenu.update\",\"select\":false,\"level\":3,\"updateTime\":1653959708000,\"type\":2,\"parentId\":5,\"isDeleted\":0,\"children\":[],\"createTime\":1622455537000,\"param\":{},\"name\":\"修改\",\"perms\":\"bnt.sysMenu.update\",\"id\":16,\"status\":1},{\"code\":\"bnt.sysMenu.remove\",\"select\":false,\"level\":3,\"updateTime\":1653959708000,\"type\":2,\"parentId\":5,\"isDeleted\":0,\"children\":[],\"createTime\":1622455537000,\"param\":{},\"name\":\"删除\",\"perms\":\"bnt.sysMenu.remove\",\"id\":17,\"status\":1}],\"createTime\":1622455537000,\"param\":{},\"name\":\"菜单管理\",\"perms\":\"bnt.sysMenu.list\",\"id\":5,\"status\":1}',
        '{\"code\":200,\"message\":\"成功\"}', 1, '', NULL, '2022-05-31 09:41:51', NULL, 0),
       (29, '菜单管理', 'UPDATE', 'com.atguigu.auth.controller.SysMenuController.updateById()', 'PUT', 'MANAGE', 'admin',
        '', '/admin/auth/sysMenu/update', '127.0.0.1',
        '{\"code\":\"sysDept\",\"select\":false,\"level\":2,\"toCode\":\"\",\"updateTime\":1653957062000,\"type\":1,\"parentId\":2,\"path\":\"sysDept\",\"sortValue\":0,\"component\":\"auth/sysDept/list\",\"isDeleted\":0,\"children\":[{\"code\":\"bnt.sysDept.list\",\"select\":false,\"level\":3,\"toCode\":\"\",\"updateTime\":1653959708000,\"type\":2,\"parentId\":20,\"isDeleted\":0,\"children\":[],\"createTime\":1653358064000,\"param\":{},\"name\":\"查看\",\"perms\":\"bnt.sysDept.list\",\"id\":21,\"status\":1},{\"code\":\"bnt.sysDept.add\",\"select\":false,\"level\":3,\"toCode\":\"\",\"updateTime\":1653959708000,\"type\":2,\"parentId\":20,\"isDeleted\":0,\"children\":[],\"createTime\":1653463887000,\"param\":{},\"name\":\"添加\",\"perms\":\"bnt.sysDept.add\",\"id\":24,\"status\":1},{\"code\":\"bnt.sysDept.update\",\"select\":false,\"level\":3,\"toCode\":\"\",\"updateTime\":1653959708000,\"type\":2,\"parentId\":20,\"isDeleted\":0,\"children\":[],\"createTime\":1653463901000,\"param\":{},\"name\":\"修改\",\"perms\":\"bnt.sysDept.update\",\"id\":25,\"status\":1},{\"code\":\"bnt.sysDept.remove\",\"select\":false,\"level\":3,\"toCode\":\"\",\"updateTime\":1653959708000,\"type\":2,\"parentId\":20,\"isDeleted\":0,\"children\":[],\"createTime\":1653463919000,\"param\":{},\"name\":\"删除\",\"perms\":\"bnt.sysDept.remove\",\"id\":26,\"status\":1}],\"createTime\":1653358025000,\"param\":{},\"name\":\"部门管理\",\"perms\":\"bnt.sysDept.list\",\"id\":20,\"status\":1}',
        '{\"code\":200,\"message\":\"成功\"}', 1, '', NULL, '2022-05-31 09:41:58', NULL, 0),
       (30, '菜单管理', 'UPDATE', 'com.atguigu.auth.controller.SysMenuController.updateById()', 'PUT', 'MANAGE', 'admin',
        '', '/admin/auth/sysMenu/update', '127.0.0.1',
        '{\"code\":\"sysPost\",\"select\":false,\"level\":2,\"toCode\":\"\",\"updateTime\":1653957062000,\"type\":1,\"parentId\":2,\"path\":\"sysPost\",\"sortValue\":0,\"component\":\"auth/sysPost/list\",\"isDeleted\":0,\"children\":[{\"code\":\"bnt.sysPost.list\",\"select\":false,\"level\":3,\"toCode\":\"\",\"updateTime\":1653959708000,\"type\":2,\"parentId\":22,\"isDeleted\":0,\"children\":[],\"createTime\":1653359145000,\"param\":{},\"name\":\"查看\",\"perms\":\"bnt.sysPost.list\",\"id\":23,\"status\":1},{\"code\":\"bnt.sysPost.add\",\"select\":false,\"level\":3,\"toCode\":\"\",\"updateTime\":1653959708000,\"type\":2,\"parentId\":22,\"isDeleted\":0,\"children\":[],\"createTime\":1653463964000,\"param\":{},\"name\":\"添加\",\"perms\":\"bnt.sysPost.add\",\"id\":27,\"status\":1},{\"code\":\"bnt.sysPost.update\",\"select\":false,\"level\":3,\"toCode\":\"\",\"updateTime\":1653959708000,\"type\":2,\"parentId\":22,\"isDeleted\":0,\"children\":[],\"createTime\":1653463978000,\"param\":{},\"name\":\"修改\",\"perms\":\"bnt.sysPost.update\",\"id\":28,\"status\":1},{\"code\":\"bnt.sysPost.remove\",\"select\":false,\"level\":3,\"toCode\":\"\",\"updateTime\":1653959708000,\"type\":2,\"parentId\":22,\"isDeleted\":0,\"children\":[],\"createTime\":1653463991000,\"param\":{},\"name\":\"删除\",\"perms\":\"bnt.sysPost.remove\",\"id\":29,\"status\":1}],\"createTime\":1653359130000,\"param\":{},\"name\":\"岗位管理\",\"perms\":\"bnt.sysPost.list\",\"id\":22,\"status\":1}',
        '{\"code\":200,\"message\":\"成功\"}', 1, '', NULL, '2022-05-31 09:42:04', NULL, 0),
       (31, '菜单管理', 'UPDATE', 'com.atguigu.auth.controller.SysMenuController.updateById()', 'PUT', 'MANAGE', 'admin',
        '', '/admin/auth/sysMenu/update', '127.0.0.1',
        '{\"code\":\"sysOperLog\",\"select\":false,\"level\":2,\"toCode\":\"\",\"updateTime\":1653957062000,\"type\":1,\"parentId\":2,\"path\":\"sysOperLog\",\"sortValue\":0,\"component\":\"auth/sysOperLog/list\",\"isDeleted\":0,\"children\":[{\"code\":\"bnt.sysOperLog.list\",\"select\":false,\"level\":3,\"toCode\":\"\",\"updateTime\":1653959708000,\"type\":2,\"parentId\":30,\"isDeleted\":0,\"children\":[],\"createTime\":1653552617000,\"param\":{},\"name\":\"查看\",\"perms\":\"bnt.sysOperLog.list\",\"id\":31,\"status\":1}],\"createTime\":1653552599000,\"param\":{},\"name\":\"操作日志\",\"perms\":\"bnt.sysOperLog.list\",\"id\":30,\"status\":1}',
        '{\"code\":200,\"message\":\"成功\"}', 1, '', NULL, '2022-05-31 09:42:09', NULL, 0),
       (32, '菜单管理', 'UPDATE', 'com.atguigu.auth.controller.SysMenuController.updateById()', 'PUT', 'MANAGE', 'admin',
        '', '/admin/auth/sysMenu/update', '127.0.0.1',
        '{\"code\":\"sysLoginLog\",\"select\":false,\"level\":2,\"toCode\":\"\",\"updateTime\":1653957062000,\"type\":1,\"parentId\":2,\"path\":\"sysLoginLog\",\"sortValue\":0,\"component\":\"auth/sysLoginLog/list\",\"isDeleted\":0,\"children\":[{\"code\":\"bnt.sysLoginLog.list\",\"select\":false,\"level\":3,\"toCode\":\"\",\"updateTime\":1653957062000,\"type\":1,\"parentId\":32,\"isDeleted\":0,\"children\":[],\"createTime\":1653554191000,\"param\":{},\"name\":\"查看\",\"id\":33,\"status\":1}],\"createTime\":1653554173000,\"param\":{},\"name\":\"登录日志\",\"perms\":\" bnt.sysLoginLog.list\",\"id\":32,\"status\":1}',
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
        '{\"select\":false,\"visible\":1,\"icon\":\"\",\"type\":1,\"parentId\":35,\"path\":\"orderInfo\",\"sortValue\":1,\"component\":\"order/orderInfo/list\",\"param\":{},\"name\":\"订单列表\",\"perms\":\"bnt.orderInfo.list\",\"id\":36,\"status\":1}',
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
        '{\"select\":false,\"icon\":\"el-icon-s-help\",\"type\":1,\"parentId\":35,\"path\":\"orderInfo\",\"sortValue\":1,\"component\":\"order/orderInfo/list\",\"param\":{},\"name\":\"订单列表\",\"perms\":\"bnt.orderInfo.list\",\"id\":36,\"status\":1}',
        '{\"code\":200,\"message\":\"成功\"}', 1, '', NULL, '2022-06-09 08:51:22', NULL, 0),
       (44, '菜单管理', 'INSERT', 'com.atguigu.system.controller.SysMenuController.save()', 'POST', 'MANAGE', 'admin', '',
        '/admin/system/sysMenu/save', '127.0.0.1',
        '{\"select\":false,\"icon\":\"\",\"type\":2,\"parentId\":36,\"path\":\"\",\"sortValue\":1,\"component\":\"\",\"param\":{},\"name\":\"添加\",\"perms\":\"bnt.add\",\"id\":37,\"status\":1}',
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
        '{\"select\":false,\"icon\":\"el-icon-s-custom\",\"updateTime\":1654737767000,\"type\":1,\"parentId\":2,\"path\":\"sysUser\",\"sortValue\":1,\"component\":\"system/sysUser/list\",\"isDeleted\":0,\"children\":[{\"select\":false,\"updateTime\":1654737758000,\"type\":2,\"parentId\":3,\"sortValue\":1,\"isDeleted\":0,\"children\":[],\"createTime\":1622455537000,\"param\":{},\"name\":\"查看\",\"perms\":\"bnt.sysUser.list\",\"id\":6,\"status\":1},{\"select\":false,\"updateTime\":1654737758000,\"type\":2,\"parentId\":3,\"sortValue\":1,\"isDeleted\":0,\"children\":[],\"createTime\":1622455537000,\"param\":{},\"name\":\"添加\",\"perms\":\"bnt.sysUser.add\",\"id\":7,\"status\":1},{\"select\":false,\"updateTime\":1654737758000,\"type\":2,\"parentId\":3,\"sortValue\":1,\"isDeleted\":0,\"children\":[],\"createTime\":1622455537000,\"param\":{},\"name\":\"修改\",\"perms\":\"bnt.sysUser.update\",\"id\":8,\"status\":1},{\"select\":false,\"updateTime\":1654737758000,\"type\":2,\"parentId\":3,\"sortValue\":1,\"isDeleted\":0,\"children\":[],\"createTime\":1622455537000,\"param\":{},\"name\":\"删除\",\"perms\":\"bnt.sysUser.remove\",\"id\":9,\"status\":1},{\"select\":false,\"updateTime\":1654737758000,\"type\":2,\"parentId\":3,\"sortValue\":1,\"isDeleted\":0,\"children\":[],\"createTime\":1653297272000,\"param\":{},\"name\":\"分配角色\",\"perms\":\"bnt.sysUser.assignRole\",\"id\":18,\"status\":1}],\"createTime\":1622455537000,\"param\":{},\"name\":\"用户管理\",\"perms\":\"\",\"id\":3,\"status\":1}',
        '{\"code\":200,\"message\":\"成功\"}', 1, '', NULL, '2022-06-09 09:24:01', NULL, 0),
       (49, '菜单管理', 'UPDATE', 'com.atguigu.system.controller.SysMenuController.updateById()', 'PUT', 'MANAGE', 'admin',
        '', '/admin/system/sysMenu/update', '127.0.0.1',
        '{\"select\":false,\"icon\":\"el-icon-user-solid\",\"updateTime\":1654737768000,\"type\":1,\"parentId\":2,\"path\":\"sysRole\",\"sortValue\":1,\"component\":\"system/sysRole/list\",\"isDeleted\":0,\"children\":[{\"select\":false,\"updateTime\":1654737758000,\"type\":2,\"parentId\":4,\"sortValue\":1,\"isDeleted\":0,\"children\":[],\"createTime\":1622455537000,\"param\":{},\"name\":\"查看\",\"perms\":\"bnt.sysRole.list\",\"id\":10,\"status\":1},{\"select\":false,\"updateTime\":1654737758000,\"type\":2,\"parentId\":4,\"sortValue\":1,\"isDeleted\":0,\"children\":[],\"createTime\":1622455537000,\"param\":{},\"name\":\"添加\",\"perms\":\"bnt.sysRole.add\",\"id\":11,\"status\":1},{\"select\":false,\"updateTime\":1654737758000,\"type\":2,\"parentId\":4,\"sortValue\":1,\"isDeleted\":0,\"children\":[],\"createTime\":1622455537000,\"param\":{},\"name\":\"修改\",\"perms\":\"bnt.sysRole.update\",\"id\":12,\"status\":1},{\"select\":false,\"updateTime\":1654737758000,\"type\":2,\"parentId\":4,\"sortValue\":1,\"isDeleted\":0,\"children\":[],\"createTime\":1622455537000,\"param\":{},\"name\":\"删除\",\"perms\":\"bnt.sysRole.remove\",\"id\":13,\"status\":1},{\"select\":false,\"updateTime\":1654737758000,\"type\":2,\"parentId\":4,\"path\":\"\",\"sortValue\":1,\"component\":\"\",\"isDeleted\":0,\"children\":[],\"createTime\":1653297494000,\"param\":{},\"name\":\"分配权限\",\"perms\":\"bnt.sysRole.assignAuth\",\"id\":19,\"status\":1}],\"createTime\":1622455537000,\"param\":{},\"name\":\"角色管理\",\"perms\":\"\",\"id\":4,\"status\":1}',
        '{\"code\":200,\"message\":\"成功\"}', 1, '', NULL, '2022-06-09 09:24:10', NULL, 0),
       (50, '菜单管理', 'UPDATE', 'com.atguigu.system.controller.SysMenuController.updateById()', 'PUT', 'MANAGE', 'admin',
        '', '/admin/system/sysMenu/update', '127.0.0.1',
        '{\"select\":false,\"icon\":\"el-icon-s-unfold\",\"updateTime\":1654737769000,\"type\":1,\"parentId\":2,\"path\":\"sysMenu\",\"sortValue\":1,\"component\":\"system/sysMenu/list\",\"isDeleted\":0,\"children\":[{\"select\":false,\"updateTime\":1654737758000,\"type\":2,\"parentId\":5,\"sortValue\":1,\"isDeleted\":0,\"children\":[],\"createTime\":1622455537000,\"param\":{},\"name\":\"查看\",\"perms\":\"bnt.sysMenu.list\",\"id\":14,\"status\":1},{\"select\":false,\"updateTime\":1654737758000,\"type\":2,\"parentId\":5,\"sortValue\":1,\"isDeleted\":0,\"children\":[],\"createTime\":1622455537000,\"param\":{},\"name\":\"添加\",\"perms\":\"bnt.sysMenu.add\",\"id\":15,\"status\":1},{\"select\":false,\"updateTime\":1654737758000,\"type\":2,\"parentId\":5,\"sortValue\":1,\"isDeleted\":0,\"children\":[],\"createTime\":1622455537000,\"param\":{},\"name\":\"修改\",\"perms\":\"bnt.sysMenu.update\",\"id\":16,\"status\":1},{\"select\":false,\"updateTime\":1654737758000,\"type\":2,\"parentId\":5,\"sortValue\":1,\"isDeleted\":0,\"children\":[],\"createTime\":1622455537000,\"param\":{},\"name\":\"删除\",\"perms\":\"bnt.sysMenu.remove\",\"id\":17,\"status\":1}],\"createTime\":1622455537000,\"param\":{},\"name\":\"菜单管理\",\"perms\":\"\",\"id\":5,\"status\":1}',
        '{\"code\":200,\"message\":\"成功\"}', 1, '', NULL, '2022-06-09 09:24:21', NULL, 0),
       (51, '菜单管理', 'UPDATE', 'com.atguigu.system.controller.SysMenuController.updateById()', 'PUT', 'MANAGE', 'admin',
        '', '/admin/system/sysMenu/update', '127.0.0.1',
        '{\"select\":false,\"icon\":\"el-icon-s-operation\",\"updateTime\":1654737776000,\"type\":1,\"parentId\":2,\"path\":\"sysDept\",\"sortValue\":1,\"component\":\"system/sysDept/list\",\"isDeleted\":0,\"children\":[{\"select\":false,\"updateTime\":1654737758000,\"type\":2,\"parentId\":20,\"sortValue\":1,\"isDeleted\":0,\"children\":[],\"createTime\":1653358064000,\"param\":{},\"name\":\"查看\",\"perms\":\"bnt.sysDept.list\",\"id\":21,\"status\":1},{\"select\":false,\"updateTime\":1654737758000,\"type\":2,\"parentId\":20,\"sortValue\":1,\"isDeleted\":0,\"children\":[],\"createTime\":1653463887000,\"param\":{},\"name\":\"添加\",\"perms\":\"bnt.sysDept.add\",\"id\":24,\"status\":1},{\"select\":false,\"updateTime\":1654737758000,\"type\":2,\"parentId\":20,\"sortValue\":1,\"isDeleted\":0,\"children\":[],\"createTime\":1653463901000,\"param\":{},\"name\":\"修改\",\"perms\":\"bnt.sysDept.update\",\"id\":25,\"status\":1},{\"select\":false,\"updateTime\":1654737758000,\"type\":2,\"parentId\":20,\"sortValue\":1,\"isDeleted\":0,\"children\":[],\"createTime\":1653463919000,\"param\":{},\"name\":\"删除\",\"perms\":\"bnt.sysDept.remove\",\"id\":26,\"status\":1}],\"createTime\":1653358025000,\"param\":{},\"name\":\"部门管理\",\"perms\":\"\",\"id\":20,\"status\":1}',
        '{\"code\":200,\"message\":\"成功\"}', 1, '', NULL, '2022-06-09 09:24:28', NULL, 0),
       (52, '菜单管理', 'UPDATE', 'com.atguigu.system.controller.SysMenuController.updateById()', 'PUT', 'MANAGE', 'admin',
        '', '/admin/system/sysMenu/update', '127.0.0.1',
        '{\"select\":false,\"icon\":\"el-icon-more-outline\",\"updateTime\":1654737777000,\"type\":1,\"parentId\":2,\"path\":\"sysPost\",\"sortValue\":1,\"component\":\"system/sysPost/list\",\"isDeleted\":0,\"children\":[{\"select\":false,\"updateTime\":1654737758000,\"type\":2,\"parentId\":22,\"sortValue\":1,\"isDeleted\":0,\"children\":[],\"createTime\":1653359145000,\"param\":{},\"name\":\"查看\",\"perms\":\"bnt.sysPost.list\",\"id\":23,\"status\":1},{\"select\":false,\"updateTime\":1654737758000,\"type\":2,\"parentId\":22,\"sortValue\":1,\"isDeleted\":0,\"children\":[],\"createTime\":1653463964000,\"param\":{},\"name\":\"添加\",\"perms\":\"bnt.sysPost.add\",\"id\":27,\"status\":1},{\"select\":false,\"updateTime\":1654737758000,\"type\":2,\"parentId\":22,\"sortValue\":1,\"isDeleted\":0,\"children\":[],\"createTime\":1653463978000,\"param\":{},\"name\":\"修改\",\"perms\":\"bnt.sysPost.update\",\"id\":28,\"status\":1},{\"select\":false,\"updateTime\":1654737758000,\"type\":2,\"parentId\":22,\"sortValue\":1,\"isDeleted\":0,\"children\":[],\"createTime\":1653463991000,\"param\":{},\"name\":\"删除\",\"perms\":\"bnt.sysPost.remove\",\"id\":29,\"status\":1}],\"createTime\":1653359130000,\"param\":{},\"name\":\"岗位管理\",\"perms\":\"\",\"id\":22,\"status\":1}',
        '{\"code\":200,\"message\":\"成功\"}', 1, '', NULL, '2022-06-09 09:24:35', NULL, 0),
       (53, '菜单管理', 'UPDATE', 'com.atguigu.system.controller.SysMenuController.updateById()', 'PUT', 'MANAGE', 'admin',
        '', '/admin/system/sysMenu/update', '127.0.0.1',
        '{\"select\":false,\"icon\":\"el-icon-tickets\",\"updateTime\":1653974966000,\"type\":0,\"parentId\":2,\"path\":\"log\",\"sortValue\":1,\"component\":\"ParentView\",\"isDeleted\":0,\"children\":[{\"select\":false,\"updateTime\":1654737785000,\"type\":1,\"parentId\":34,\"path\":\"sysOperLog\",\"sortValue\":1,\"component\":\"system/sysOperLog/list\",\"isDeleted\":0,\"children\":[{\"select\":false,\"updateTime\":1654737758000,\"type\":2,\"parentId\":30,\"sortValue\":1,\"isDeleted\":0,\"children\":[],\"createTime\":1653552617000,\"param\":{},\"name\":\"查看\",\"perms\":\"bnt.sysOperLog.list\",\"id\":31,\"status\":1}],\"createTime\":1653552599000,\"param\":{},\"name\":\"操作日志\",\"perms\":\"\",\"id\":30,\"status\":1},{\"select\":false,\"updateTime\":1654737787000,\"type\":1,\"parentId\":34,\"path\":\"sysLoginLog\",\"sortValue\":1,\"component\":\"system/sysLoginLog/list\",\"isDeleted\":0,\"children\":[{\"select\":false,\"updateTime\":1654737758000,\"type\":2,\"parentId\":32,\"sortValue\":1,\"isDeleted\":0,\"children\":[],\"createTime\":1653554191000,\"param\":{},\"name\":\"查看\",\"id\":33,\"status\":1}],\"createTime\":1653554173000,\"param\":{},\"name\":\"登录日志\",\"perms\":\"\",\"id\":32,\"status\":1}],\"createTime\":1653974587000,\"param\":{},\"name\":\"日志管理\",\"perms\":\"\",\"id\":34,\"status\":1}',
        '{\"code\":200,\"message\":\"成功\"}', 1, '', NULL, '2022-06-09 09:24:46', NULL, 0),
       (54, '菜单管理', 'UPDATE', 'com.atguigu.system.controller.SysMenuController.updateById()', 'PUT', 'MANAGE', 'admin',
        '', '/admin/system/sysMenu/update', '127.0.0.1',
        '{\"select\":false,\"icon\":\"el-icon-document-remove\",\"updateTime\":1654737785000,\"type\":1,\"parentId\":34,\"path\":\"sysOperLog\",\"sortValue\":1,\"component\":\"system/sysOperLog/list\",\"isDeleted\":0,\"children\":[{\"select\":false,\"updateTime\":1654737758000,\"type\":2,\"parentId\":30,\"sortValue\":1,\"isDeleted\":0,\"children\":[],\"createTime\":1653552617000,\"param\":{},\"name\":\"查看\",\"perms\":\"bnt.sysOperLog.list\",\"id\":31,\"status\":1}],\"createTime\":1653552599000,\"param\":{},\"name\":\"操作日志\",\"perms\":\"\",\"id\":30,\"status\":1}',
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
        '{\"select\":false,\"updateTime\":1654737758000,\"type\":2,\"parentId\":4,\"path\":\"assignAuth\",\"sortValue\":1,\"component\":\"system/sysRole/assignAuth\",\"isDeleted\":0,\"children\":[],\"createTime\":1653297494000,\"param\":{},\"name\":\"分配权限\",\"perms\":\"bnt.sysRole.assignAuth\",\"id\":19,\"status\":1}',
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
        '{\"select\":false,\"icon\":\"\",\"type\":2,\"parentId\":36,\"path\":\"teacher/create\",\"sortValue\":1,\"component\":\"vod/teacher/form\",\"param\":{},\"name\":\"添加\",\"perms\":\"bnt.teacher.add\",\"id\":37,\"status\":1}',
        '{\"code\":200,\"message\":\"成功\"}', 1, '', NULL, '2022-06-10 15:28:27', NULL, 0),
       (62, '菜单管理', 'INSERT', 'com.atguigu.system.controller.SysMenuController.save()', 'POST', 'MANAGE', 'admin', '',
        '/admin/system/sysMenu/save', '127.0.0.1',
        '{\"select\":false,\"icon\":\"\",\"type\":2,\"parentId\":36,\"path\":\"teacher/edit/:id\",\"sortValue\":1,\"component\":\"vod/teacher/form\",\"param\":{},\"name\":\"修改\",\"perms\":\"bnt.teacher.update\",\"id\":38,\"status\":1}',
        '{\"code\":200,\"message\":\"成功\"}', 1, '', NULL, '2022-06-10 15:29:13', NULL, 0),
       (63, '菜单管理', 'INSERT', 'com.atguigu.system.controller.SysMenuController.save()', 'POST', 'MANAGE', 'admin', '',
        '/admin/system/sysMenu/save', '127.0.0.1',
        '{\"select\":false,\"icon\":\"\",\"type\":2,\"parentId\":36,\"path\":\"\",\"sortValue\":1,\"component\":\"\",\"param\":{},\"name\":\"查看\",\"perms\":\"bnt.teacher.list\",\"id\":39,\"status\":1}',
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
    `is_deleted`  tinyint(3)   NOT NULL DEFAULT '0' COMMENT '删除标记（0:可用 其他:已删除）',
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
    `is_deleted`  tinyint(3) NOT NULL DEFAULT '0' COMMENT '删除标记（0:可用 其他:已删除）',
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
    `is_deleted`  tinyint(3)  NOT NULL DEFAULT '0' COMMENT '删除标记（0:可用 其他:已删除）',
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
    `is_deleted`  tinyint(3) NOT NULL DEFAULT '0' COMMENT '删除标记（0:可用 其他:已删除）',
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
    `password`    varchar(32) NOT NULL DEFAULT '' COMMENT '密码',
    `name`        varchar(50)          DEFAULT NULL COMMENT '姓名',
    `phone`       varchar(11)          DEFAULT NULL COMMENT '手机',
    `head_url`    varchar(200)         DEFAULT NULL COMMENT '头像地址',
    `dept_id`     bigint(20)           DEFAULT NULL COMMENT '部门id',
    `post_id`     bigint(20)           DEFAULT NULL COMMENT '岗位id',
    `description` varchar(255)         DEFAULT NULL COMMENT '描述',
    `status`      tinyint(3)           DEFAULT NULL COMMENT '状态（1：正常 0：停用）',
    `create_time` timestamp   NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `update_time` timestamp   NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    `is_deleted`  tinyint(3)  NOT NULL DEFAULT '0' COMMENT '删除标记（0:可用 其他:已删除）',
    PRIMARY KEY (`id`),
    UNIQUE KEY `idx_username_is_deleted` (`username`, `is_deleted`)
) ENGINE = InnoDB
  AUTO_INCREMENT = 4
  DEFAULT CHARSET = utf8mb4 COMMENT ='用户表';

INSERT INTO `sys_user`
VALUES (1, 'admin', '96e79218965eb72c92a549dd5a330112', 'admin', '15099909888',
        'http://r61cnlsfq.hn-bkt.clouddn.com/7daa4595-dfde-45da-8513-c5c2b81d20cc', 1021, 5, NULL, 1,
        '2021-05-31 18:08:43', '2022-05-25 11:34:25', 0),
       (2, 'wangqq', '96e79218965eb72c92a549dd5a330112', '王倩倩', '15010546381',
        'http://r61cnlsfq.hn-bkt.clouddn.com/b09b3467-3d99-437a-bd2e-dd8c9be92bb8', 1022, 6, NULL, 1,
        '2022-02-08 10:35:38', '2022-05-25 15:58:31', 0),
       (3, 'wanggang', '96e79218965eb72c92a549dd5a330112', '王刚', '18909098909', NULL, 1024, 5, NULL, 0,
        '2022-05-24 11:05:40', '2022-06-02 10:19:25', 0);
