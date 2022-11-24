package com.atguigu.system.service.impl;

import com.atguigu.model.system.SysUser;
import com.atguigu.system.custom.CustomUser;
import com.atguigu.system.service.SysMenuService;
import com.atguigu.system.service.SysUserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 陈江林
 * @date 2022/11/23 00:11
 */
@Component
@Slf4j
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private SysUserService sysUserService;

    @Autowired
    private SysMenuService sysMenuService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        SysUser sysUser = sysUserService.getByUsername(username);
        if (null == sysUser) {
            throw new UsernameNotFoundException("用户名不存在!");
        }

        if (sysUser.getStatus() == 0) {
            throw new RuntimeException("账号已停用!");
        }

        List<String> userPermsList = sysMenuService.getUserButtonList(sysUser.getId());
        List<SimpleGrantedAuthority> authorities = new ArrayList<>();
        userPermsList.forEach(str -> {
            log.info("userPermsList: " + str);
            if (!StringUtils.isEmpty(str)) {
                authorities.add(new SimpleGrantedAuthority(str.trim()));
            }
        });

        return new CustomUser(sysUser, authorities);
    }

}
