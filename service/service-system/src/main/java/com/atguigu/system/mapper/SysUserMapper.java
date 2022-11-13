package com.atguigu.system.mapper;

import com.atguigu.model.system.SysUser;
import com.atguigu.model.vo.SysUserQueryVo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Param;

/**
 * <p>
 * 用户表 Mapper 接口
 * </p>
 *
 * @author 陈江林
 * @since 2022-11-13
 */
public interface SysUserMapper extends BaseMapper<SysUser> {
    /**
     * 分页查询
     *
     * @param objectPage
     * @param sysUserQueryVo
     * @return {@link IPage}<{@link SysUser}>
     */
    IPage<SysUser> selectPage(Page<SysUser> objectPage, @Param("vo") SysUserQueryVo sysUserQueryVo);
}
