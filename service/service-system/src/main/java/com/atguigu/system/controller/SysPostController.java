package com.atguigu.system.controller;


import com.atguigu.common.result.Result;
import com.atguigu.model.system.SysPost;
import com.atguigu.model.vo.SysPostQueryVo;
import com.atguigu.system.service.SysPostService;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 * 岗位信息表 前端控制器
 * </p>
 *
 * @author 陈江林
 * @since 2022-11-25
 */
@Api(tags = "岗位管理接口")
@RestController
@RequestMapping("/admin/system/sysPost")
public class SysPostController {

    @Autowired
    private SysPostService sysPostService;

    @PreAuthorize("hasAuthority('btn.sysPost.add')")
    @ApiOperation(value = "保存")
    @PostMapping("/save")
    public Result save(
            @RequestBody SysPost sysPost
    ) {
        if (sysPostService.save(sysPost)) {
            return Result.ok();
        } else {
            return Result.fail();
        }
    }

    @PreAuthorize("hasAuthority('btn.sysPost.update')")
    @ApiOperation(value = "修改")
    @PutMapping("/update")
    public Result update(
            @RequestBody SysPost sysPost
    ) {
        if (sysPostService.updateById(sysPost)) {
            return Result.ok();
        } else {
            return Result.fail();
        }
    }

    @PreAuthorize("hasAuthority('btn.sysPost.update')")
    @ApiOperation(value = "修改状态")
    @PutMapping("/update/{id}/{status}")
    public Result update(
            @PathVariable Long id,
            @PathVariable Integer status
    ) {
        SysPost sysPost = sysPostService.getById(id);
        sysPost.setStatus(status);
        if (sysPostService.updateById(sysPost)) {
            return Result.ok();
        } else {
            return Result.fail();
        }
    }

    @PreAuthorize("hasAuthority('btn.sysPost.list')")
    @ApiOperation(value = "根据id获取数据")
    @GetMapping("/getById/{id}")
    public Result<SysPost> getById(
            @PathVariable Long id
    ) {
        return Result.ok(sysPostService.getById(id));
    }

    @PreAuthorize("hasAuthority('btn.sysPost.list')")
    @ApiOperation(value = "分页查询")
    @GetMapping("/{page}/{limit}")
    public Result<IPage<SysPost>> getPage(
            @PathVariable Long page,
            @PathVariable Long limit,
            SysPostQueryVo sysPostQueryVo
    ) {
        return Result.ok(sysPostService.getPage(new Page<>(page, limit), sysPostQueryVo));
    }

    @PreAuthorize("hasAuthority('btn.sysPost.remove')")
    @ApiOperation(value = "删除")
    @DeleteMapping("/removeById/{id}")
    public Result removeById(
            @PathVariable Long id
    ) {
        if (sysPostService.removeById(id)) {
            return Result.ok();
        } else {
            return Result.fail();
        }
    }

}

