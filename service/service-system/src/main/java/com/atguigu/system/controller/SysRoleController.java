package com.atguigu.system.controller;

import com.atguigu.model.system.SysRole;
import com.atguigu.system.service.SysRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author 陈江林
 * @date 2022/11/10 16:08
 */
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
    @GetMapping("/findAll")
    public List<SysRole> findAll() {
        return sysRoleService.list();
    }

    /**
     * 根据 id 删除数据
     *
     * @return {@link List}<{@link SysRole}>
     */
    @DeleteMapping("/remove/{id}")
    public boolean removeById(
            @PathVariable Long id
    ) {
        return sysRoleService.removeById(id);
    }

}
