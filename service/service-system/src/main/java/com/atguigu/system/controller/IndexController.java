package com.atguigu.system.controller;

import com.atguigu.common.result.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

/**
 * @author 陈江林
 * @date 2022/11/12 20:03
 */
@Api("用户登录接口")
@RestController
@RequestMapping("/admin/system/index")
public class IndexController {

    @ApiOperation("用户登录")
    @PostMapping("/login")
    public Result<Map<String, Object>> login() {
        return Result.ok(
                ((Supplier<Map<String, Object>>) () -> {
                    Map<String, Object> map = new HashMap<>();
                    map.put("token", "admin-token");
                    return map;
                }).get()
        );
    }

    @ApiOperation("获取用户信息")
    @GetMapping("/info")
    public Result<Map<String, Object>> info() {
        return Result.ok(
                ((Supplier<Map<String, Object>>) () -> {
                    Map<String, Object> map = new HashMap<>();
                    map.put("roles", "[admin]");
                    map.put("introduction", "I am a super administrator");
                    map.put("avatar", "https://wpimg.wallstcn.com/f778738c-e4f8-4870-b634-56703b4acafe.gif");
                    map.put("name", "Super Admin");
                    return map;

                }).get()
        );
    }

    @ApiOperation("用户退出登录")
    @PostMapping("/logout")
    public Result logout() {
        return Result.ok();
    }

}

