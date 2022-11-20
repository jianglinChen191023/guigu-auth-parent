package com.atguigu.system.service.impl;

import com.atguigu.common.result.ResultCodeEnum;
import com.atguigu.common.utils.MenuHelper;
import com.atguigu.common.utils.RouterHelper;
import com.atguigu.model.system.SysMenu;
import com.atguigu.model.system.SysRoleMenu;
import com.atguigu.model.vo.AssginMenuVo;
import com.atguigu.model.vo.RouterVo;
import com.atguigu.system.exception.GuiguException;
import com.atguigu.system.mapper.SysMenuMapper;
import com.atguigu.system.mapper.SysRoleMenuMapper;
import com.atguigu.system.service.SysMenuService;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.baomidou.mybatisplus.extension.toolkit.SqlHelper;
import org.springframework.beans.factory.annotation.Autowired;
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

    @Autowired
    private SysRoleMenuMapper sysRoleMenuMapper;

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
        return MenuHelper.buildTree(sysMenuList);
    }

    @Override
    public void saveRoleMenu(AssginMenuVo assginMenuVo) {
        if (assginMenuVo == null) {
            throw new GuiguException(ResultCodeEnum.SUCCESS.getCode(), "参数不能为空!");
        }

        if (assginMenuVo.getRoleId() == null
                || assginMenuVo.getMenuIdList() == null) {
            throw new GuiguException(ResultCodeEnum.SUCCESS.getCode(), "角色id或菜单不能为空!");
        }

        // 获取角色id
        Long roleId = assginMenuVo.getRoleId();

        /* 先删除再添加 */
        // 根据角色id删除菜单权限
        sysRoleMenuMapper.delete(
                new LambdaQueryWrapper<SysRoleMenu>()
                        .eq(SysRoleMenu::getRoleId, assginMenuVo.getRoleId())
        );

        // 添加菜单
        assginMenuVo.getMenuIdList()
                .forEach(menuId -> {
                    // 创建角色菜单中间表实体对象
                    SysRoleMenu sysRoleMenu = new SysRoleMenu();
                    sysRoleMenu.setMenuId(menuId);
                    sysRoleMenu.setRoleId(roleId);
                    // 添加
                    sysRoleMenuMapper.insert(sysRoleMenu);
                });
    }

    @Override
    public List<SysMenu> getMenuListByRoleId(Long roleId) {
        // 根据角色id查询已经分配的菜单id
        List<Long> menuIdList = sysRoleMenuMapper.selectList(
                new LambdaQueryWrapper<SysRoleMenu>()
                        .eq(SysRoleMenu::getRoleId, roleId)
        )
                .stream()
                .map(SysRoleMenu::getMenuId)
                .collect(Collectors.toList());

        return MenuHelper.buildTree(
                baseMapper.selectList(
                        // 获取所有可用菜单 status=1
                        new LambdaQueryWrapper<SysMenu>()
                                .eq(SysMenu::getStatus, 1)
                )
                        .stream()
                        .peek(sysMenu -> {
                            if (menuIdList.contains(sysMenu.getId())) {
                                sysMenu.setSelect(true);
                            }
                        })
                        .collect(Collectors.toList())
        );
    }

    @Override
    public List<RouterVo> getUserMenuList(Long userId) {
        // admin 是超级管理员, 操作所有
        // 判断id值[{1: 超级管理员}, {其他: 普通用户}]
        List<SysMenu> sysMenuList;
        // 判断
        if (userId.equals(1L)) {
            sysMenuList = baseMapper.selectList(
                    new LambdaQueryWrapper<SysMenu>()
                            .eq(SysMenu::getStatus, 1)
                            .orderByAsc(SysMenu::getSortValue)
            );
        } else {
            // 根据用户id查询权限
            sysMenuList = baseMapper.selectMenuListUserId(userId);
        }

        // 构建树形结构
        List<SysMenu> sysMenuTreeList = MenuHelper.buildTree(sysMenuList);
        // 转换成前端路由格式
        return RouterHelper.buildRouters(sysMenuTreeList);
    }

    @Override
    public List<String> getUserButtonList(Long userId) {
        // admin 是超级管理员, 操作所有
        // 判断id值[{1: 超级管理员}, {其他: 普通用户}]
        List<SysMenu> sysMenuList;
        // 判断
        if (userId.equals(1L)) {
            sysMenuList = baseMapper.selectList(
                    new LambdaQueryWrapper<SysMenu>()
                            .eq(SysMenu::getStatus, 1)
            );
        } else {
            // 根据用户id查询权限
            sysMenuList = baseMapper.selectMenuListUserId(userId);
        }

        return sysMenuList.stream().map(SysMenu::getPerms).collect(Collectors.toList());
    }

}
