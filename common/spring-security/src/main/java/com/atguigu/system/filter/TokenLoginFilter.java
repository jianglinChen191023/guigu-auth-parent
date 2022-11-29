package com.atguigu.system.filter;

import com.alibaba.fastjson.JSON;
import com.atguigu.common.result.Result;
import com.atguigu.common.result.ResultCodeEnum;
import com.atguigu.common.utils.IpUtil;
import com.atguigu.common.utils.JwtHelper;
import com.atguigu.common.utils.ResponseUtil;
import com.atguigu.model.system.SysLoginLog;
import com.atguigu.model.vo.LoginVo;
import com.atguigu.service.api.SystemRemoteService;
import com.atguigu.system.custom.CustomUser;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * @author 陈江林
 * @date 2022/11/23 00:14
 */
public class TokenLoginFilter extends UsernamePasswordAuthenticationFilter {

    private RedisTemplate redisTemplate;

    //    private LoginLogService loginLogService;
    private SystemRemoteService systemRemoteService;

    public TokenLoginFilter(AuthenticationManager authenticationManager,
                            RedisTemplate redisTemplate,
                            SystemRemoteService systemRemoteService) {
        this.setAuthenticationManager(authenticationManager);
        this.setPostOnly(false);
        // 指定登录接口及提交方式，可以指定任意路径
        this.setRequiresAuthenticationRequestMatcher(
                new AntPathRequestMatcher("/admin/system/index/login", "POST")
        );
        this.redisTemplate = redisTemplate;
        this.systemRemoteService = systemRemoteService;
    }

    /**
     * 登录认证
     *
     * @param req
     * @param res
     * @return
     * @throws AuthenticationException
     */
    @Override
    public Authentication attemptAuthentication(HttpServletRequest req, HttpServletResponse res)
            throws AuthenticationException {
        try {
            LoginVo loginVo = new ObjectMapper().readValue(req.getInputStream(), LoginVo.class);
            Authentication authenticationToken = new UsernamePasswordAuthenticationToken(loginVo.getUsername(), loginVo.getPassword());
            return this.getAuthenticationManager().authenticate(authenticationToken);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 登录成功
     *
     * @param request
     * @param response
     * @param chain
     * @param auth
     * @throws IOException
     * @throws ServletException
     */
    @Override
    protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain,
                                            Authentication auth) throws IOException, ServletException {
        // 获取认证对象
        CustomUser customUser = (CustomUser) auth.getPrincipal();
        String username = customUser.getUsername();

        // 保存权限数据
        ValueOperations<String, String> operations = redisTemplate.opsForValue();
        operations.set(username,
                JSON.toJSONString(customUser.getAuthorities()));
        // 生成 token
        String token = JwtHelper.createToken(customUser.getSysUser().getId(), customUser.getSysUser().getUsername());
        // 设置超时时间的 token, token 唯一，
        operations.set(JwtHelper.TOKEN_PREFIX + username, token, JwtHelper.EXPIRATION, TimeUnit.SECONDS);
        // 登录日志
        SysLoginLog sysLoginLog = new SysLoginLog();
        sysLoginLog.setUsername(customUser.getUsername());
        sysLoginLog.setStatus(1);
        sysLoginLog.setIpaddr(IpUtil.getIpAddress(request));
        sysLoginLog.setMsg("登录成功");
        Result result = systemRemoteService.saveLoginLog(sysLoginLog);
        if (ResultCodeEnum.SUCCESS.getCode().equals(result.getCode())) {
            // 返回 token
            Map<String, Object> map = new HashMap<>();
            map.put("token", token);
            ResponseUtil.out(response, Result.ok(map));
        } else {
            // 返回服务无响应
            ResponseUtil.out(response, Result.fail().message("服务无响应，请重试"));
        }
    }

    /**
     * 登录失败
     *
     * @param request
     * @param response
     * @param e
     */
    @Override
    protected void unsuccessfulAuthentication(HttpServletRequest request, HttpServletResponse response,
                                              AuthenticationException e) {
        if (e.getCause() instanceof RuntimeException) {
            ResponseUtil.out(response, Result.build(null, 204, e.getMessage()));
        } else {
            ResponseUtil.out(response, Result.build(null, ResultCodeEnum.LOGIN_MOBLE_ERROR));
        }
    }

}
