package com.atguigu.common.utils;

import com.atguigu.model.system.SysMenu;

import java.util.ArrayList;
import java.util.List;

/**
 * 菜单工具类
 *
 * @author 陈江林
 * @date 2022/11/16 22:39
 */
public class MenuHelper {

    /**
     * 构建树型菜单
     *
     * @param sysMenuList 系统菜单列表
     * @return {@link List}<{@link SysMenu}>
     */
    public static List<SysMenu> buildTree(List<SysMenu> sysMenuList) {
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

        return sysMenuList;
    }

}
