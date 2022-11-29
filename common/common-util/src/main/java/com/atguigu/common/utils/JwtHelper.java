package com.atguigu.common.utils;

import io.jsonwebtoken.*;

import java.util.Date;
import java.util.HashMap;

/**
 * 生成JSON Web令牌的工具类
 *
 * @author 陈江林
 * @date 2022/11/20 18:59
 */
public class JwtHelper {

    /**
     * 令牌过期时间
     * 过期时间是3600秒，既是1个小时
     */
    private static final long EXPIRATION = 60L;

    /**
     * 令牌秘钥
     */
    private static final String SECRET = "jwtsecretdemo";

    /**
     * 创建 token, 存储用户id和用户名称
     *
     * @param userId   用户id
     * @param username 用户名
     * @return {@link String}
     */
    public static String createToken(Long userId, String username) {
        HashMap<String, Object> map = new HashMap<>();
        map.put("userId", userId);
        map.put("username", username);

        return Jwts.builder()
                .setSubject("AUTH-USER")
                // 先调用setClaims， 在调用setExpiration
                .setClaims(map)
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRATION * 1000))
                .signWith(SignatureAlgorithm.HS512, SECRET)
                // 压缩字符串, 变成一行
                .compressWith(CompressionCodecs.GZIP)
                .compact();
    }

    /**
     * 得到用户id
     *
     * @param token 令牌
     * @return {@link Long}
     */
    public static Long getUserId(String token) {
        return Long.valueOf(getTokenBody(token).get("userId").toString());
    }

    /**
     * 获得用户名
     *
     * @param token 令牌
     * @return {@link String}
     */
    public static String getUsername(String token) {
        return String.valueOf(getTokenBody(token).get("username"));
    }

    /**
     * 是否已过期
     *
     * @param token 令牌
     * @return boolean
     */
    public static boolean isExpiration(String token) {
        try {
            return getTokenBody(token).getExpiration().before(new Date());
        } catch (ExpiredJwtException e) {
            return true;
        }
    }

    private static Claims getTokenBody(String token) {
        return Jwts.parser()
                .setSigningKey(SECRET)
                .parseClaimsJws(token)
                .getBody();
    }

    public static void removeToken(String token) {
        // jwt token无需删除，客户端扔掉即可。
    }

    public static void main(String[] args) {
        String token = JwtHelper.createToken(1592868656222597121L, "admin");
        System.out.println(token);
        System.out.println(JwtHelper.getUserId(token));
        System.out.println(JwtHelper.getUsername(token));
    }
}