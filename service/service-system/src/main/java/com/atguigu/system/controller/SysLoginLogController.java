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