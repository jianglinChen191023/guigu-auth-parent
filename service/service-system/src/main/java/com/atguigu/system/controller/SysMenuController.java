package com.atguigu.system.controller;


import com.atguigu.common.result.Result;
import com.atguigu.model.system.SysMenu;
import com.atguigu.system.service.SysMenuService;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
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
        if (0 != sysMenuService.count(new LambdaQueryWrapper<SysMenu>()
                .eq(SysMenu::getName, sysMenu.getName()))) {
            return Result.fail().message("菜单名称已存在!");
        }

        if (sysMenuService.save(sysMenu)) {
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
        SysMenu SysMenu = sysMenuService.getById(id);
        SysMenu.setStatus(status);
        if (sysMenuService.updateById(SysMenu)) {
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

