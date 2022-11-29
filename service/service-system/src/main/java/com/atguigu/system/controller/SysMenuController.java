package com.atguigu.system.controller;


import com.atguigu.common.result.Result;
import com.atguigu.model.system.SysMenu;
import com.atguigu.system.annotation.Log;
import com.atguigu.system.enums.BusinessType;
import com.atguigu.system.service.SysMenuService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
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
@Api(tags = "菜单管理接口")
@RestController
@RequestMapping("/admin/system/sysMenu")
public class SysMenuController {

    @Autowired
    private SysMenuService sysMenuService;

    @PreAuthorize("hasAuthority('btn.sysMenu.list')")
    @ApiOperation("根据角色id获取菜单")
    @GetMapping("/getMenuListByRoleId/{roleId}")
    public Result<List<SysMenu>> getMenuListByRoleId(
            @PathVariable Long roleId
    ) {
        return Result.ok(sysMenuService.getMenuListByRoleId(roleId));
    }

    @Log(title = "菜单管理", businessType = BusinessType.INSERT)
    @PreAuthorize("hasAuthority('btn.sysMenu.add')")
    @ApiOperation("菜单保存")
    @PostMapping("/save")
    public Result save(@RequestBody SysMenu sysMenu) {
        if (sysMenuService.save(sysMenu)) {
            return Result.ok();
        } else {
            return Result.fail();
        }
    }

    @Log(title = "菜单管理", businessType = BusinessType.UPDATE)
    @PreAuthorize("hasAuthority('btn.sysMenu.update')")
    @ApiOperation("菜单修改")
    @PutMapping("/update")
    public Result update(@RequestBody SysMenu sysMenu) {
        if (sysMenuService.updateById(sysMenu)) {
            return Result.ok();
        } else {
            return Result.fail();
        }
    }

    @PreAuthorize("hasAuthority('btn.sysMenu.list')")
    @ApiOperation("根据id获取菜单信息")
    @GetMapping("/getById/{id}")
    public Result<SysMenu> getById(
            @PathVariable Long id
    ) {
        return Result.ok(sysMenuService.getById(id));
    }

    @PreAuthorize("hasAuthority('btn.sysMenu.list')")
    @ApiOperation("菜单列表(树形)")
    @GetMapping("/getAll")
    public Result<List<SysMenu>> getAll() {
        return Result.ok(sysMenuService.getAll());
    }

    @Log(title = "菜单管理", businessType = BusinessType.DELETE)
    @PreAuthorize("hasAuthority('btn.sysMenu.remove')")
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

