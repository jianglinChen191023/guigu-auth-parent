package com.atguigu.system.enums;

/**
 * 业务操作类型
 *
 * @author 陈江林
 * @date 2022/11/27 05:18
 */
public enum BusinessType {
    /**
     * 其它
     */
    OTHER,

    /**
     * 新增
     */
    INSERT,

    /**
     * 修改
     */
    UPDATE,

    /**
     * 删除
     */
    DELETE,

    /**
     * 授权
     */
    ASSGIN,

    /**
     * 导出
     */
    EXPORT,

    /**
     * 导入
     */
    IMPORT,

    /**
     * 强退
     */
    FORCE,

    /**
     * 更新状态
     */
    STATUS,

    /**
     * 清空数据
     */
    CLEAN
}
