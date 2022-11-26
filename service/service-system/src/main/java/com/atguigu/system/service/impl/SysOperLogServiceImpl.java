package com.atguigu.system.service.impl;

import com.atguigu.model.system.SysOperLog;
import com.atguigu.model.vo.SysOperLogQueryVo;
import com.atguigu.system.mapper.SysOperLogMapper;
import com.atguigu.system.service.SysOperLogService;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

/**
 * 系统日志 服务实现类
 *
 * @author 陈江林
 * @date 2022/11/27 06:08
 */
@Service
public class SysOperLogServiceImpl extends ServiceImpl<SysOperLogMapper, SysOperLog> implements SysOperLogService {
    @Override
    public IPage<SysOperLog> getPage(Long page, Long limit, SysOperLogQueryVo sysOperLogQueryVo) {
        LambdaQueryWrapper<SysOperLog> wrapper = new LambdaQueryWrapper<>();

        // 条件
        String operName = sysOperLogQueryVo.getOperName();
        String title = sysOperLogQueryVo.getTitle();
        String createTimeBegin = sysOperLogQueryVo.getCreateTimeBegin();
        String createTimeEnd = sysOperLogQueryVo.getCreateTimeEnd();

        // 操作人员
        if (!StringUtils.isEmpty(operName)) {
            wrapper.like(SysOperLog::getOperName, operName);
        }

        // 模块标题
        if (!StringUtils.isEmpty(title)) {
            wrapper.like(SysOperLog::getTitle, title);
        }

        // 时间
        if (!StringUtils.isEmpty(createTimeBegin) && !StringUtils.isEmpty(createTimeEnd) ) {
            wrapper.ge(SysOperLog::getCreateTime, createTimeBegin);
            wrapper.lt(SysOperLog::getCreateTime, createTimeEnd);
        }

        // 排序
        wrapper.orderByDesc(SysOperLog::getCreateTime);

        Page<SysOperLog> objectPage = new Page<>(page, limit);
        return this.baseMapper.selectPage(objectPage, wrapper);
    }
}
