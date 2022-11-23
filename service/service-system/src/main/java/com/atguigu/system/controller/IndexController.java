package com.atguigu.system.controller;

import com.atguigu.common.result.Result;
import com.atguigu.common.result.ResultCodeEnum;
import com.atguigu.common.utils.JwtHelper;
import com.atguigu.model.system.SysUser;
import com.atguigu.model.vo.LoginVo;
import com.atguigu.system.exception.GuiguException;
import com.atguigu.system.service.SysUserService;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * @author 陈江林
 * @date 2022/11/12 20:03
 */
@Api(tags = "用户登录退出")
@RestController
@RequestMapping("/admin/system/index")
public class IndexController {

    @Autowired
    private SysUserService sysUserService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @ApiOperation("用户登录")
    @PostMapping("/login")
    public Result<Map<String, Object>> login(
            @RequestBody LoginVo loginVo
    ) {
        // 根据 username 查询数据
        SysUser sysUser = sysUserService.getOne(
                new LambdaQueryWrapper<SysUser>()
                        .eq(SysUser::getUsername, loginVo.getUsername())
        );

        // 非空判断
        if (sysUser == null) {
            throw new GuiguException(ResultCodeEnum.FAIL.getCode(), "用户不存在!");
        }

        // 判断密码是否一致
        String password = loginVo.getPassword();
        String encode = passwordEncoder.encode(password);
        if (encode.equals(sysUser.getPassword())) {
            throw new GuiguException(ResultCodeEnum.FAIL.getCode(), "密码不一致!");
        }

        // 判断用户是否可用
        if (sysUser.getStatus() == 0) {
            throw new GuiguException(ResultCodeEnum.FAIL.getCode(), "用户已经被禁用!");
        }

        // 根据用户id和用户名称生成 token 字符串，使用 map 返回
        String token = JwtHelper.createToken(sysUser.getId(), sysUser.getUsername());
        Map<String, Object> map = new HashMap<>();
        map.put("token", token);
        return Result.ok(map);
    }

    @ApiOperation("获取用户信息")
    @GetMapping("/info")
    public Result<Map<String, Object>> info(HttpServletRequest request) {
        // 从请求头中获取 token 字符串
        String token = request.getHeader("token");
        // 非空判断
        if (StringUtils.isEmpty(token)) {
            throw new GuiguException(ResultCodeEnum.FAIL.getCode(), "非法请求!");
        }

        // 判断 token 是否过期
        if (JwtHelper.isExpiration(token)) {
            throw new GuiguException(ResultCodeEnum.FAIL.getCode(), "token 已过期!");
        }

        // 根据用户id获取用户信息
        Map<String, Object> map = sysUserService.getUserInfo(JwtHelper.getUsername(token));
        // 返回数据
        return Result.ok(map);
    }

    @ApiOperation("用户退出登录")
    @PostMapping("/logout")
    public Result logout() {
        return Result.ok();
    }

}

