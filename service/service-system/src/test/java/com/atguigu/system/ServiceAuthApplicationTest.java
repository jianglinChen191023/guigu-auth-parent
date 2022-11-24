package com.atguigu.system;

import com.atguigu.model.system.SysRole;
import com.atguigu.system.mapper.SysRoleMapper;
import com.atguigu.system.service.SysMenuService;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Arrays;
import java.util.List;
import java.util.function.Supplier;

/**
 * 测试一下 CURD
 *
 * @author 陈江林
 * @date 2022/11/10 14:18
 */
@SpringBootTest
public class ServiceAuthApplicationTest {

    @Autowired
    private SysRoleMapper sysRoleMapper;

    @Autowired
    private SysMenuService sysMenuService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private RedisTemplate redisTemplate;

    @Test
    public void passwordTest() {
        redisTemplate.opsForValue().set("1", "1");
        System.out.println(redisTemplate.opsForValue().get("1"));
    }

    /**
     * 根据 id 获取系统角色实体对象
     */
    @Test
    public void findSysRoleById() {
        System.out.println(sysMenuService.getAll());
//        SysRole sysRole = sysRoleMapper.selectById(1L);
//        System.out.println(sysRole);
    }

    /**
     * 查询所有
     */
    @Test
    public void findAll() {
        List<SysRole> sysRoles = sysRoleMapper.selectList(null);
        System.out.println(sysRoles);
    }

    /**
     * 添加数据
     */
    @Test
    public void saveSysRole() {
        sysRoleMapper.insert(
                ((Supplier<SysRole>) () -> {
                    SysRole sysRole = new SysRole();
                    sysRole.setRoleName("测试角色");
                    sysRole.setRoleCode("TEST_ROLE");
                    sysRole.setDescription("测试角色");
                    return sysRole;
                }).get()
        );

        // 查看
        System.out.println(sysRoleMapper.selectList(null));
    }

    /**
     * 修改数据
     */
    @Test
    public void updateSysRole() {
        sysRoleMapper.updateById(
                ((Supplier<SysRole>) () -> {
                    // 根据 id 获取实体对象
                    SysRole sysRole = sysRoleMapper.selectOne(
                            new LambdaQueryWrapper<SysRole>()
                                    .eq(SysRole::getRoleCode, "TEST_ROLE")
                    );

                    sysRole.setDescription("测试修改角色信息");
                    return sysRole;
                }).get()
        );

        // 查看
        System.out.println(sysRoleMapper.selectOne(
                new LambdaQueryWrapper<SysRole>()
                        .eq(SysRole::getRoleCode, "TEST_ROLE")
        ));
    }

    /**
     * 删除数据 - 逻辑删除
     */
    @Test
    public void removeSysRole() {
        sysRoleMapper.delete(new LambdaQueryWrapper<SysRole>()
                .eq(SysRole::getRoleCode, "TEST_ROLE")
        );

        // 查看
        System.out.println(sysRoleMapper.selectList(null));
    }

    /**
     * 批量删除
     */
    @Test
    public void removeSysRoles() {
        sysRoleMapper.deleteBatchIds(Arrays.asList(1, 2));

        // 查看
        System.out.println(sysRoleMapper.selectList(null));
    }

}
