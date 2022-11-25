package com.atguigu.system.service;

import com.atguigu.model.system.SysDept;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 组织机构 服务类
 * </p>
 *
 * @author 陈江林
 * @since 2022-11-25
 */
public interface SysDeptService extends IService<SysDept> {

    /**
     * 列表(树形)
     *
     * @return {@link List}<{@link SysDept}>
     */
    List<SysDept> getAll();

}
