package com.atguigu.system.service.impl;

import com.atguigu.common.utils.DeptHelper;
import com.atguigu.model.system.SysDept;
import com.atguigu.system.mapper.SysDeptMapper;
import com.atguigu.system.service.SysDeptService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 组织机构 服务实现类
 * </p>
 *
 * @author 陈江林
 * @since 2022-11-25
 */
@Service
public class SysDeptServiceImpl extends ServiceImpl<SysDeptMapper, SysDept> implements SysDeptService {

    @Override
    public List<SysDept> getAll() {
        List<SysDept> sysDeptList = baseMapper.selectList(null);
        return DeptHelper.buildTree(sysDeptList);
    }

}
