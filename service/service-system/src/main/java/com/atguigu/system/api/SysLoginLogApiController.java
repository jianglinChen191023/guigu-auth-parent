package com.atguigu.system.api;

import com.atguigu.common.result.Result;
import com.atguigu.model.system.SysLoginLog;
import com.atguigu.system.service.SysLoginLogService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 陈江林
 * @date 2022/11/28 02:14
 */
@Api(tags = "登录日志远程接口")
@RestController
@RequestMapping(value = "/api/system/sysLoginLog")
public class SysLoginLogApiController {

    @Autowired
    private SysLoginLogService sysLoginLogService;

    @ApiOperation(value = "保存登录日志")
    @HystrixCommand(fallbackMethod = "saveLoginLogBackup")
    @PostMapping("/save")
    public Result saveLoginLog(@RequestBody SysLoginLog sysLoginLog) {
        if (sysLoginLogService.save(sysLoginLog)) {
            return Result.ok();
        } else {
            return Result.fail();
        }
    }

    public Result saveLoginLogBackup(@RequestBody SysLoginLog sysLoginLog) {
        return Result.fail("熔断机制生效: 方法执行出现问题");
    }

}
