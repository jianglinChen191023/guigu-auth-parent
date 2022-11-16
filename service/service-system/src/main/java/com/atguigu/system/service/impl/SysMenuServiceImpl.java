package com.atguigu.system.service.impl;

import com.atguigu.common.result.ResultCodeEnum;
import com.atguigu.model.system.SysMenu;
import com.atguigu.system.exception.GuiguException;
import com.atguigu.system.mapper.SysMenuMapper;
import com.atguigu.system.service.SysMenuService;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.baomidou.mybatisplus.extension.toolkit.SqlHelper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * <p>
 * 菜单表 服务实现类
 * </p>
 *
 * @author 陈江林
 * @since 2022-11-15
 */
@Service
public class SysMenuServiceImpl extends ServiceImpl<SysMenuMapper, SysMenu> implements SysMenuService {

    @Override
    public boolean removeMenuById(Long id) {
        // 如果有子菜单, 禁止删除
        if (0 < baseMapper.selectCount(new LambdaQueryWrapper<SysMenu>()
                .eq(SysMenu::getParentId, id))) {
            throw new GuiguException(ResultCodeEnum.FAIL.getCode(), "请先删除子菜单!");
        }

        // 删除该菜单
        return SqlHelper.retBool(baseMapper.deleteById(id));
    }

    @Override
    public List<SysMenu> getAll() {
        // 1. 查询所有
        List<SysMenu> sysMenuList = baseMapper.selectList(null);

        // 2. 封装子菜单
        sysMenuList.forEach(sysMenu -> {
            sysMenuList.forEach(sysMenuChildren -> {
                if (sysMenu.getId().equals(sysMenuChildren.getParentId())) {
                    // 如果为空, 初始化集合
                    if (sysMenu.getChildren() == null) {
                        sysMenu.setChildren(new ArrayList<>());
                    }

                    // 添加子菜单
                    sysMenu.getChildren().add(sysMenuChildren);
                }
            });
        });

        // 3. 返回一级菜单
        return sysMenuList
                .stream()
                .collect(Collectors.groupingBy(SysMenu::getParentId))
                .get(0L);
    }

}
