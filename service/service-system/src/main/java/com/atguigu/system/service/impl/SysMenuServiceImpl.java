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
        if(0 < baseMapper.selectCount(new LambdaQueryWrapper<SysMenu>()
                .eq(SysMenu::getParentId, id))) {
            throw new GuiguException(ResultCodeEnum.FAIL.getCode(), "请先删除子菜单!");
        }

        // 删除该菜单
        return SqlHelper.retBool(baseMapper.deleteById(id));
    }

    @Override
    public List<SysMenu> getMenuListByParentId(Long parentId) {
        return baseMapper.selectList(
                // 根据父id查询菜单
                new LambdaQueryWrapper<SysMenu>()
                        .eq(SysMenu::getParentId, parentId)
        ).stream()
                .peek(sysMenu -> {
                    // 判断有无子菜单
                    sysMenu.setHasChildren(
                            0 < baseMapper.selectCount(
                                    new LambdaQueryWrapper<SysMenu>()
                                            .eq(SysMenu::getParentId, sysMenu.getId())
                            )
                    );
                })
                .collect(Collectors.toList());
    }
}
