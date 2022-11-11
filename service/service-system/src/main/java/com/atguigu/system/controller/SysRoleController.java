package com.atguigu.system.controller;

import com.atguigu.common.result.Result;
import com.atguigu.model.system.SysRole;
import com.atguigu.model.vo.SysRoleQueryVo;
import com.atguigu.system.exception.GuiguException;
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
        // TODO 模拟异常
        try {
            int i = 9 / 0;
        } catch (Exception e) {
            throw new GuiguException(201, "执行自定义异常处理");
        }

        return Result.ok(sysRoleService.list());
    }

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

    @ApiOperation(value = "条件分页查询")
    @GetMapping("/{page}/{limit}")
    public Result<IPage<SysRole>> findQueryRole(
            @PathVariable Long page,
            @PathVariable Long limit,
            SysRoleQueryVo sysRoleQueryVo
    ) {
        return Result.ok(sysRoleService.getPage(new Page<>(page, limit), sysRoleQueryVo));
    }

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