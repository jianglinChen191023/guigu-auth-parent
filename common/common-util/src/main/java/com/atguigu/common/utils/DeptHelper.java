package com.atguigu.common.utils;

import com.atguigu.model.system.SysDept;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author 陈江林
 * @date 2022/11/25 09:11
 */
public class DeptHelper {

    /**
     * 构建树型菜单
     *
     * @param SysDeptList 系统菜单列表
     * @return {@link List}<{@link SysDept}>
     */
    public static List<SysDept> buildTree(List<SysDept> SysDeptList) {
        // 2. 封装子菜单
        SysDeptList.forEach(SysDept -> {
            SysDeptList.forEach(SysDeptChildren -> {
                if (SysDept.getId().equals(SysDeptChildren.getParentId())) {
                    // 如果为空, 初始化集合
                    if (SysDept.getChildren() == null) {
                        SysDept.setChildren(new ArrayList<>());
                    }

                    // 添加子菜单
                    SysDept.getChildren().add(SysDeptChildren);
                }
            });
        });

        // 返回树形菜单
        return SysDeptList.stream().collect(Collectors.groupingBy(SysDept::getParentId)).get(0L);
    }

}
