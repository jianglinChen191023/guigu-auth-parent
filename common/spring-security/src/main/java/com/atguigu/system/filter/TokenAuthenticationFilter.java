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
        // 如果是登录接口，直接放行
        // 或保存登录日志
        if ("/admin/system/index/login".equals(requestURI)
                || "/api/system/sysLoginLog/save".equals(requestURI)) {
            chain.doFilter(request, response);
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
