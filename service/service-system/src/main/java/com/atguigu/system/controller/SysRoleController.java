package com.atguigu.system.controller;

import com.atguigu.common.result.Result;
import com.atguigu.model.system.SysRole;
import com.atguigu.model.vo.AssginRoleVo;
import com.atguigu.model.vo.SysRoleQueryVo;
import com.atguigu.system.annotation.Log;
import com.atguigu.system.enums.BusinessType;
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

    @PreAuthorize("hasAuthority('btn.sysRole.list')")
    @ApiOperation(value = "查询所有角色")
    @GetMapping("/findAll")
    public Result<List<SysRole>> findAll() {
        return Result.ok(sysRoleService.list());
    }

    @Log(title = "角色管理", businessType = BusinessType.DELETE)
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

    @Log(title = "角色管理", businessType = BusinessType.INSERT)
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

    @Log(title = "角色管理", businessType = BusinessType.UPDATE)
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

    @Log(title = "角色管理", businessType = BusinessType.DELETE)
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