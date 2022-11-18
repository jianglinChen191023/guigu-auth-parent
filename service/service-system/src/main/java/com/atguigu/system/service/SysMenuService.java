package com.atguigu.system.service;

import com.atguigu.model.system.SysMenu;
import com.atguigu.model.vo.AssginMenuVo;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 菜单表 服务类
 * </p>
 *
 * @author 陈江林
 * @since 2022-11-15
 */
public interface SysMenuService extends IService<SysMenu> {

    /**
     * 根据id删除菜单
     *
     * @param id id
     * @return boolean
     */
    boolean removeMenuById(Long id);

    /**
     * 菜单列表(树形)
     *
     * @return {@link List}<{@link SysMenu}>
     */
    List<SysMenu> getAll();

    /**
     * 根据角色id获取菜单树
     *
     * @param roleId 角色id
     * @return {@link List}<{@link SysMenu}>
     */
    List<SysMenu> getMenuListByRoleId(Long roleId);

    /**
     * 给角色分配菜单权限
     *
     * @param assginMenuVo
     */
    void saveRoleMenu(AssginMenuVo assginMenuVo);
}
