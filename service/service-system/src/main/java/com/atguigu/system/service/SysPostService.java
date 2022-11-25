package com.atguigu.system.service;

import com.atguigu.model.system.SysPost;
import com.atguigu.model.vo.SysPostQueryVo;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 岗位信息表 服务类
 * </p>
 *
 * @author 陈江林
 * @since 2022-11-25
 */
public interface SysPostService extends IService<SysPost> {

    /**
     * 分页查询
     *
     * @param objectPage
     * @param sysPostQueryVo 条件对象
     * @return {@link IPage}<{@link SysPost}>
     */
    IPage<SysPost> getPage(Page<Object> objectPage, SysPostQueryVo sysPostQueryVo);
}
