package com.atguigu.system.mapper;

import com.atguigu.model.system.SysPost;
import com.atguigu.model.vo.SysPostQueryVo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Param;

/**
 * <p>
 * 岗位信息表 Mapper 接口
 * </p>
 *
 * @author 陈江林
 * @since 2022-11-25
 */
public interface SysPostMapper extends BaseMapper<SysPost> {

    /**
     * 分页查询
     *
     * @param objectPage
     * @param sysPostQueryVo 条件对象
     * @return {@link IPage}<{@link SysPost}>
     */
    IPage<SysPost> selectPage(Page<Object> objectPage,@Param("vo") SysPostQueryVo sysPostQueryVo);

}
