package com.atguigu.system;

import com.atguigu.model.system.SysRole;
import com.atguigu.model.vo.SysRoleQueryVo;
import com.atguigu.system.service.SysRoleService;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author 陈江林
 * @date 2022/11/11 12:13
 */
@SpringBootTest
public class SysRoleTest {

    @Autowired
    private SysRoleService sysRoleService;

    @Test
    public void getPage() {
        IPage<SysRole> page = sysRoleService.getPage(new Page<>(1L, 10L), new SysRoleQueryVo());
        System.out.println(page);
    }

}
