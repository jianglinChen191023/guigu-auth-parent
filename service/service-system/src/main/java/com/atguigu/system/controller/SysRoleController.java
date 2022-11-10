package com.atguigu.system.controller;

import com.atguigu.model.system.SysRole;
import com.atguigu.system.service.SysRoleService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
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

    /**
     * 查询所有
     *
     * @return {@link List}<{@link SysRole}>
     */
    @ApiOperation(value = "查询所有")
    @GetMapping("/findAll")
    public List<SysRole> findAll() {
        return sysRoleService.list();
    }

    /**
     * 根据 id 删除数据
     *
     * @return {@link List}<{@link SysRole}>
     */
    @ApiImplicitParam(name = "id", value = "角色id", required = true)
    @ApiOperation(value = "逻辑删除")
    @DeleteMapping("/remove/{id}")
    public boolean removeById(
            @PathVariable Long id
    ) {
        return sysRoleService.removeById(id);
    }

}
