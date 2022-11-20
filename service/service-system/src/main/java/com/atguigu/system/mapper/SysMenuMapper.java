package com.atguigu.system.mapper;

import com.atguigu.model.system.SysMenu;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 * 菜单表 Mapper 接口
 * </p>
 *
 * @author 陈江林
 * @since 2022-11-15
 */
public interface SysMenuMapper extends BaseMapper<SysMenu> {

    /**
     * 根据用户id查询权限
     *
     * @param userId 用户id
     * @return {@link List}<{@link SysMenu}>
     */
    List<SysMenu> selectMenuListUserId(@Param("userId") Long userId);
}
