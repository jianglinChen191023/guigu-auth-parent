package com.atguigu.system.controller;


import com.atguigu.common.result.Result;
import com.atguigu.model.system.SysDept;
import com.atguigu.system.service.SysDeptService;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

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

    @PreAuthorize("hasAuthority('btn.sysDept.list')")
    @ApiOperation(value = "条件分页查询")
    @GetMapping("/{page}/{limit}")
    public Result<IPage<Map<String, Object>>> getPage(
            @PathVariable Long page,
            @PathVariable Long limit
    ) {
        return Result.ok(sysDeptService.pageMaps(new Page<>(page, limit)));
    }

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

