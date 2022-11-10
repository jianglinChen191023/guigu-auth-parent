package com.atguigu.system;

import com.atguigu.model.system.SysRole;
import com.atguigu.system.service.SysRoleService;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.List;
import java.util.function.Supplier;

/**
 * 测试 Mybatis Plus 的 服务接口的 CURD
 *
 * @author 陈江林
 * @date 2022/11/10 15:46
 */
@SpringBootTest
public class MpServiceTest {

    @Autowired
    private SysRoleService sysRoleService;

    /**
     * 根据 id 获取系统角色实体对象
     */
    @Test
    public void findSysRoleById() {
        SysRole sysRole = sysRoleService.getById(1L);
        System.out.println(sysRole);
    }

    /**
     * 查询所有
     */
    @Test
    public void findAll() {
        List<SysRole> sysRoles = sysRoleService.list();
        System.out.println(sysRoles);
    }

    /**
     * 添加数据
     */
    @Test
    public void saveSysRole() {
        sysRoleService.save(
                ((Supplier<SysRole>) () -> {
                    SysRole sysRole = new SysRole();
                    sysRole.setRoleName("测试角色");
                    sysRole.setRoleCode("TEST_ROLE");
                    sysRole.setDescription("测试角色");
                    return sysRole;
                }).get()
        );

        // 查看
        System.out.println(sysRoleService.list());
    }

    /**
     * 修改数据
     */
    @Test
    public void updateSysRole() {
        sysRoleService.updateById(
                ((Supplier<SysRole>) () -> {
                    // 根据 id 获取实体对象
                    SysRole sysRole = sysRoleService.getOne(
                            new LambdaQueryWrapper<SysRole>()
                                    .eq(SysRole::getRoleCode, "TEST_ROLE")
                    );

                    sysRole.setDescription("测试修改角色信息");
                    return sysRole;
                }).get()
        );

        // 查看
        System.out.println(sysRoleService.getOne(
                new LambdaQueryWrapper<SysRole>()
                        .eq(SysRole::getRoleCode, "TEST_ROLE")
        ));
    }

    /**
     * 删除数据 - 逻辑删除
     */
    @Test
    public void removeSysRole() {
        sysRoleService.remove(new LambdaQueryWrapper<SysRole>()
                .eq(SysRole::getRoleCode, "TEST_ROLE")
        );

        // 查看
        System.out.println(sysRoleService.list());
    }

    /**
     * 批量删除
     */
    @Test
    public void removeSysRoles() {
        sysRoleService.removeByIds(Arrays.asList(1, 2));

        // 查看
        System.out.println(sysRoleService.list());
    }

}
