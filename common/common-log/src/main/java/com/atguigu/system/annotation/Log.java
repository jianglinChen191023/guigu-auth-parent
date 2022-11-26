package com.atguigu.system.annotation;

import com.atguigu.system.enums.BusinessType;
import com.atguigu.system.enums.OperatorType;

import java.lang.annotation.*;

/**
 * 自定义操作日志记录注解
 * - （参数，方法）Target 注解的目标（target）指定注解可以应用于哪个 Java 结构
 * - RetentionPolicy.RUNTIME 注解由编译器记录在类文件中，并由 JVM 在运行时保留
 *
 * @author 陈江林
 * @date 2022/11/27 04:50
 */
@Target({ElementType.PARAMETER, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Log {
    /**
     * 模块
     */
    String title() default "";

    /**
     * 功能
     */
    BusinessType businessType() default BusinessType.OTHER;

    /**
     * 操作人类别
     */
    OperatorType operatorType() default OperatorType.MANAGE;

    /**
     * 是否保存请求的参数
     */
    boolean isSaveRequestData() default true;

    /**
     * 是否保存响应的参数
     */
    boolean isSaveResponseData() default true;
}