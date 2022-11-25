package com.atguigu.system.service.impl;

import com.atguigu.model.system.SysPost;
import com.atguigu.model.vo.SysPostQueryVo;
import com.atguigu.system.mapper.SysPostMapper;
import com.atguigu.system.service.SysPostService;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 岗位信息表 服务实现类
 * </p>
 *
 * @author 陈江林
 * @since 2022-11-25
 */
@Service
public class SysPostServiceImpl extends ServiceImpl<SysPostMapper, SysPost> implements SysPostService {

    @Override
    public IPage<SysPost> getPage(Page<Object> objectPage, SysPostQueryVo sysPostQueryVo) {
        return baseMapper.selectPage(objectPage, sysPostQueryVo);
    }

}
