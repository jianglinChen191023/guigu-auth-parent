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

    @ApiOperation("修改状态")
    @PutMapping("/updateStatus/{id}/{status}")
    public Result update(
            @PathVariable Long id,
            @PathVariable Integer status
    ) {
        SysUser sysUser = sysUserService.getById(id);
        sysUser.setStatus(status);
        if (sysUserService.updateById(sysUser)) {
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
            @RequestBody List<String> ids
    ) {
        if (sysUserService.removeByIds(ids)) {
            return Result.ok();
        } else {
            return Result.fail();
        }
    }

}

