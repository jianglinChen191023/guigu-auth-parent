package com.atguigu.system.controller;

import com.atguigu.common.result.Result;
import com.atguigu.model.system.SysRole;
import com.atguigu.model.vo.SysRoleQueryVo;
import com.atguigu.system.service.SysRoleService;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
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

    @ApiOperation(value = "查询所有角色")
    @GetMapping("/findAll")
    public Result<List<SysRole>> findAll() {
        return Result.ok(sysRoleService.list());
    }

    @ApiOperation(value = "逻辑删除")
    @ApiImplicitParam(name = "id", value = "角色id", dataType = "Long", paramType = "path", required = true)
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

    @ApiOperation(value = "条件分页查询")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "page", value = "当前页", dataType = "Long", paramType = "path", required = true),
            @ApiImplicitParam(name = "limit", value = "每页显示条数", dataType = "Long", paramType = "path", required = true),
            @ApiImplicitParam(name = "sysRoleQueryVo", value = "角色条件视图对象", dataType = "SysRoleQueryVo", paramType = "query")
    })
    @GetMapping("/{page}/{limit}")
    public Result<IPage<SysRole>> findQueryRole(
            @PathVariable Long page,
            @PathVariable Long limit,
            SysRoleQueryVo sysRoleQueryVo
    ) {
        return Result.ok(sysRoleService.getPage(new Page<>(page, limit), sysRoleQueryVo));
    }

    @ApiOperation("角色添加")
    @ApiImplicitParam(name = "sysRole", value = "角色实体对象", dataType = "SysRole", paramType = "body")
    @PostMapping("/save")
    public Result<Boolean> saveRole(
            @RequestBody SysRole sysRole
    ) {
        if (sysRoleService.save(sysRole)) {
            return Result.ok();
        } else {
            return Result.fail();
        }
    }

    @ApiOperation("角色修改")
    @ApiImplicitParam(name = "sysRole", value = "角色实体对象", dataType = "SysRole", paramType = "body")
    @PutMapping("/update")
    public Result<Boolean> updateRole(
            @RequestBody SysRole sysRole
    ) {
        if (sysRoleService.updateById(sysRole)) {
            return Result.ok();
        } else {
            return Result.fail();
        }
    }

    @ApiOperation("根据id查询角色")
    @ApiImplicitParam(name = "id", value = "角色id", dataType = "Long", paramType = "path", required = true)
    @PutMapping("/findRoleById/{id}")
    public Result<SysRole> findRoleById(
            @PathVariable Long id
    ) {
        return Result.ok(sysRoleService.getById(id));
    }
}
