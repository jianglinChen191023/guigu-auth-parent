package com.atguigu.system.mapper;

import com.atguigu.model.system.SysLoginLog;
import com.atguigu.model.vo.SysLoginLogQueryVo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Param;

/**
 * 日志登录 Mapper 接口
 *
 * @author 陈江林
 * @date 2022/11/27 01:16
 */
public interface SysLoginLogMapper extends BaseMapper<SysLoginLog> {

    /**
     * 分页查询
     *
     * @param pageParam          页面参数
     * @param sysLoginLogQueryVo 系统登录日志查询视图对象
     * @return {@link IPage}<{@link SysLoginLog}>
     */
    IPage<SysLoginLog> selectPage(Page<SysLoginLog> pageParam,@Param("vo") SysLoginLogQueryVo sysLoginLogQueryVo);

}
