package com.atguigu.system.controller;

import com.atguigu.common.result.Result;
import com.atguigu.model.system.SysRole;
import com.atguigu.model.system.SysUser;
import com.atguigu.model.vo.AssginRoleVo;
import com.atguigu.model.vo.SysUserQueryVo;
import com.atguigu.system.annotation.Log;
import com.atguigu.system.enums.BusinessType;
import com.atguigu.system.service.SysRoleService;
import com.atguigu.system.service.SysUserService;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.password.PasswordEncoder;
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

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private SysRoleService sysRoleService;

    @Log(title = "用户管理", businessType = BusinessType.ASSGIN)
    @PreAuthorize("hasAuthority('btn.sysUser.assignRole')")
    @ApiOperation(value = "给用户分配角色")
    @PostMapping("/doAssign")
    public Result<List<SysRole>> doAssign(
            @RequestBody AssginRoleVo assginRoleVo
    ) {
        sysRoleService.doAssign(assginRoleVo);
        return Result.ok();
    }

    @Log(title = "用户管理", businessType = BusinessType.INSERT)
    @PreAuthorize("hasAuthority('btn.sysUser.add')")
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

    @Log(title = "用户管理", businessType = BusinessType.STATUS)
    @PreAuthorize("hasAuthority('btn.sysUser.update')")
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

    @Log(title = "用户管理", businessType = BusinessType.UPDATE)
    @PreAuthorize("hasAuthority('btn.sysUser.update')")
    @ApiOperation("用户修改")
    @PutMapping("/update")
    public Result update(@RequestBody SysUser sysUser) {
        if (sysUserService.updateById(sysUser)) {
            return Result.ok();
        } else {
            return Result.fail();
        }
    }

    @PreAuthorize("hasAuthority('btn.sysUser.list')")
    @ApiOperation("根据id获取用户信息")
    @GetMapping("/getById/{id}")
    public Result<SysUser> getById(
            @PathVariable Long id
    ) {
        return Result.ok(sysUserService.getById(id));
    }

    @PreAuthorize("hasAuthority('btn.sysUser.list')")
    @ApiOperation("分页查询")
    @GetMapping("/{page}/{limit}")
    public Result<IPage<SysUser>> getPage(
            @PathVariable Long page,
            @PathVariable Long limit,
            SysUserQueryVo sysUserQueryVo
    ) {
        return Result.ok(sysUserService.getPage(new Page<>(page, limit), sysUserQueryVo));
    }

    @Log(title = "用户管理", businessType = BusinessType.DELETE)
    @PreAuthorize("hasAuthority('btn.sysUser.remove')")
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

    @Log(title = "用户管理", businessType = BusinessType.DELETE)
    @PreAuthorize("hasAuthority('btn.sysUser.remove')")
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

