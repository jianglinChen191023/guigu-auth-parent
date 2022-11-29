package com.atguigu.system.filter;

import com.alibaba.fastjson.JSON;
import com.atguigu.common.result.Result;
import com.atguigu.common.result.ResultCodeEnum;
import com.atguigu.common.utils.JwtHelper;
import com.atguigu.common.utils.ResponseUtil;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.*;

/**
 * 认证解析过滤器
 *
 * @author 陈江林
 * @date 2022/11/23 00:23
 */
public class TokenAuthenticationFilter extends OncePerRequestFilter {

    private RedisTemplate redisTemplate;

    public TokenAuthenticationFilter(RedisTemplate redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        String requestURI = request.getRequestURI();
        logger.info("uri:" + requestURI);
        // 请求白名单
        List<String> list = new ArrayList<>();
        // 登录接口
        list.add("/admin/system/index/login");
        // 保存登录日志
        list.add("/api/system/sysLoginLog/save");

        // 如果是登录接口，或保存登录日志...直接放行
        if (list.contains(requestURI)) {
            chain.doFilter(request, response);
            return;
        }

        String token = request.getHeader("token");
        if (StringUtils.isEmpty(token)) {
            // 无效 token
            ResponseUtil.out(response, Result.build(null, ResultCodeEnum.ILLEGAL_TOKEN));
            return;
        }

        String username;
        try {
            username = JwtHelper.getUsername(token);
        } catch (Exception e) {
            // 无效 token
            ResponseUtil.out(response, Result.build(null, ResultCodeEnum.ILLEGAL_TOKEN));
            return;
        }

        // 判断 token 是否过期
        if (JwtHelper.isExpiration(token)) {
            ResponseUtil.out(response, Result.build(null, ResultCodeEnum.TOKEN_EXPIRED));
            return;
        }

        // 是否在其他客户端登录，当前请求的 token 是否与服务器 redis 中 token 一致
        Object redisToken = redisTemplate.opsForValue().get(JwtHelper.TOKEN_PREFIX + username);
        if (!token.equals(redisToken)) {
            ResponseUtil.out(response, Result.build(null, ResultCodeEnum.OTHER_CLIENTS_LOGGED_IN));
            return;
        }

        UsernamePasswordAuthenticationToken authentication = getAuthentication(request);
        if (null != authentication) {
            SecurityContextHolder.getContext().setAuthentication(authentication);
            chain.doFilter(request, response);
        } else {
            ResponseUtil.out(response, Result.build(null, ResultCodeEnum.PERMISSION));
        }
    }

    private UsernamePasswordAuthenticationToken getAuthentication(HttpServletRequest request) {
        // token置于header里
        String token = request.getHeader("token");

        logger.info("token:" + token);
        if (!StringUtils.isEmpty(token)) {
            String username = JwtHelper.getUsername(token);
            logger.info("username:" + username);
            Object authoritiesObj = redisTemplate.opsForValue().get(username);
            if (!StringUtils.isEmpty(username) && null != authoritiesObj) {
                // 权限
                String authoritiesString = authoritiesObj.toString();
                List<Map> mapList = JSON.parseArray(authoritiesString, Map.class);
                List<SimpleGrantedAuthority> authorities = new ArrayList<>();
                mapList.forEach(map -> authorities.add(new SimpleGrantedAuthority(map.get("authority").toString())));

                return new UsernamePasswordAuthenticationToken(username, null, authorities);
            }
        }

        return null;
    }
}
