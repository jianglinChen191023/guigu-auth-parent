package com.atguigu.service.factory;

import com.atguigu.common.result.Result;
import com.atguigu.model.system.SysLoginLog;
import com.atguigu.service.api.SystemRemoteService;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

/**
 * 降级机制
 *
 * @author 陈江林
 * @date 2022/11/28 02:07
 */
@Component
public class SystemFallBackFactory implements FallbackFactory<SystemRemoteService> {
    @Override
    public SystemRemoteService create(Throwable cause) {
        return new SystemRemoteService() {
            @Override
            public Result saveLoginLog(SysLoginLog sysLoginLog) {
                return Result.fail("降级机制生效: " + cause.getMessage());
            }
        };
    }
}
