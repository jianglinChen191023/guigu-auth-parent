package com.atguigu.service.api;

import com.atguigu.common.result.Result;
import com.atguigu.model.system.SysLoginLog;
import com.atguigu.service.factory.SystemFallBackFactory;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * 系统模块
 *
 * @author 陈江林
 * @date 2022/11/28 02:06
 */
@FeignClient(value = "service-system", fallbackFactory = SystemFallBackFactory.class)
public interface SystemRemoteService {

    /**
     * 保存登录日志
     *
     * @param sysLoginLog 系统登录日志对象
     * @return {@link Result}
     */
    @PostMapping("/save")
    Result saveLoginLog(@RequestBody SysLoginLog sysLoginLog);

}
