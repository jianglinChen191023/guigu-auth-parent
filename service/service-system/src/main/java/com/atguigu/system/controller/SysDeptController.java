package com.atguigu.system.controller;


import com.atguigu.common.result.Result;
import com.atguigu.model.system.SysDept;
import com.atguigu.system.annotation.Log;
import com.atguigu.system.enums.BusinessType;
import com.atguigu.system.service.SysDeptService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 * 组织机构 前端控制器
 * </p>
 *
 * @author 陈江林
 * @since 2022-11-25
 */
@Api(tags = "部门管理接口")
@RestController
@RequestMapping("/admin/system/sysDept")
public class SysDeptController {

    @Autowired
    private SysDeptService sysDeptService;

    @Log(title = "部门管理", businessType = BusinessType.INSERT)
    @PreAuthorize("hasAuthority('btn.sysDept.add')")
    @ApiOperation(value = "保存")
    @PostMapping("/save")
    public Result save(
            @RequestBody SysDept sysDept
    ) {
        if (sysDeptService.save(sysDept)) {
            return Result.ok();
        } else {
            return Result.fail();
        }
    }

    @Log(title = "部门管理", businessType = BusinessType.UPDATE)
    @PreAuthorize("hasAuthority('btn.sysDept.update')")
    @ApiOperation(value = "修改")
    @PutMapping("/update")
    public Result update(
            @RequestBody SysDept sysDept
    ) {
        if (sysDeptService.updateById(sysDept)) {
            return Result.ok();
        } else {
            return Result.fail();
        }
    }

    @Log(title = "部门管理", businessType = BusinessType.STATUS)
    @PreAuthorize("hasAuthority('btn.sysPost.update')")
    @ApiOperation(value = "修改状态")
    @PutMapping("/update/{id}/{status}")
    public Result update(
            @PathVariable Long id,
            @PathVariable Integer status
    ) {
        SysDept sysDept = sysDeptService.getById(id);
        sysDept.setStatus(status);
        if (sysDeptService.updateById(sysDept)) {
            return Result.ok();
        } else {
            return Result.fail();
        }
    }

    @PreAuthorize("hasAuthority('btn.sysDept.list')")
    @ApiOperation(value = "根据id获取数据")
    @GetMapping("/getById/{id}")
    public Result<SysDept> getById(
            @PathVariable Long id
    ) {
        return Result.ok(sysDeptService.getById(id));
    }

    @PreAuthorize("hasAuthority('btn.sysDept.list')")
    @ApiOperation(value = "列表(树形)")
    @GetMapping("/getAll")
    public Result<List<SysDept>> getAll() {
        return Result.ok(sysDeptService.getAll());
    }

    @Log(title = "部门管理", businessType = BusinessType.DELETE)
    @PreAuthorize("hasAuthority('btn.sysDept.remove')")
    @ApiOperation(value = "删除")
    @DeleteMapping("/removeById/{id}")
    public Result removeById(
            @PathVariable Long id
    ) {
        if (sysDeptService.removeById(id)) {
            return Result.ok();
        } else {
            return Result.fail();
        }
    }

}

