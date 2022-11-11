package com.atguigu.system.controller;

import com.atguigu.common.result.Result;
import com.atguigu.model.system.SysRole;
import com.atguigu.model.vo.SysRoleQueryVo;
import com.atguigu.system.service.SysRoleService;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.swagger.annotations.*;
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

    @ApiOperation(value = "查询所有角色")
    @GetMapping("/findAll")
    public Result<List<SysRole>> findAll() {
        return Result.ok(sysRoleService.list());
    }

    @ApiOperation(value = "逻辑删除")
    @DeleteMapping("/remove/{id}")
    public Result removeById(
            @ApiParam("角色id")
            @PathVariable Long id
    ) {
        if (sysRoleService.removeById(id)) {
            return Result.ok();
        } else {
            return Result.fail();
        }
    }

    @ApiOperation(value = "条件分页查询")
    @GetMapping("/{page}/{limit}")
    public Result<IPage<SysRole>> findQueryRole(
            @ApiParam("当前页数")
            @PathVariable Long page,
            @ApiParam("每页显示条数")
            @PathVariable Long limit,
            @ApiParam("角色条件视图对象")
            SysRoleQueryVo sysRoleQueryVo
    ) {
        return Result.ok(sysRoleService.getPage(new Page<>(page, limit), sysRoleQueryVo));
    }

    @ApiOperation("角色添加")
    @PostMapping("/save")
    public Result saveRole(
            @ApiParam(name = "sysRole", value = "角色实体对象")
            @RequestBody SysRole sysRole
    ) {
        if (sysRoleService.save(sysRole)) {
            return Result.ok();
        } else {
            return Result.fail();
        }
    }

    @ApiOperation("角色修改")
    @PutMapping("/update")
    public Result updateRole(
            @ApiParam(name = "sysRole", value = "角色实体对象")
            @RequestBody SysRole sysRole
    ) {
        if (sysRoleService.updateById(sysRole)) {
            return Result.ok();
        } else {
            return Result.fail();
        }
    }

    @ApiOperation("根据id查询角色")
    @PutMapping("/findRoleById/{id}")
    public Result<SysRole> findRoleById(
            @ApiParam(name = "id", value = "角色id")
            @PathVariable Long id
    ) {
        return Result.ok(sysRoleService.getById(id));
    }

    @ApiOperation("批量删除")
    @DeleteMapping("/batchRemove")
    public Result batchRemove(
            @ApiParam(name = "ids", value = "一些角色id")
            @RequestBody List<Long> ids
    ) {
        if (sysRoleService.removeByIds(ids)) {
            return Result.ok();
        } else {
            return Result.fail();
        }
    }
}
