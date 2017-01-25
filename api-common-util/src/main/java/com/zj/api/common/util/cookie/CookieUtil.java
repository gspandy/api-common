package com.zj.api.common.util.cookie;

import org.springframework.util.StringUtils;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by js on 2017/1/25.
 */
public class CookieUtil {


    public static String getCookie(HttpServletRequest request, String cookieName) {
        if (request == null || !StringUtils.hasText(cookieName)) {
            throw new IllegalArgumentException("参数不能为空");
        }
        Cookie[] cookies = request.getCookies();
        for (Cookie cookie : cookies) {
            if (cookie.getName().equals(cookieName)) {
                return cookie.getValue();
            }
        }
        return null;
    }

    /**
     * 添加cookie
     *
     * @param response
     * @param name     名称
     * @param domain   域名
     * @param value    值
     * @param expiry   时间
     */
    public static void setCookie(HttpServletResponse response, String name, String domain, String value, int expiry) {
        if (response == null || StringUtils.isEmpty(name) || StringUtils.isEmpty(value)) {
            throw new IllegalArgumentException("参数不能为空");
        }
        Cookie cookie = new Cookie(name, value);
        if (StringUtils.hasText(domain)) {
            cookie.setDomain(domain);
        }
        cookie.setMaxAge(expiry);
        cookie.setPath("/");
        response.addCookie(cookie);
    }

}
