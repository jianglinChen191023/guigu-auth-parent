package com.atguigu.system.service;

import com.atguigu.model.system.SysMenu;
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
     * 根据id删除菜单及其子菜单
     *
     * @param id id
     * @return boolean
     */
    boolean removeMenuById(Long id);

    /**
     * 菜单列表(懒加载)
     *
     * @param parentId 父id
     * @return {@link List}<{@link SysMenu}>
     */
    List<SysMenu> getMenuListByParentId(Long parentId);
}
