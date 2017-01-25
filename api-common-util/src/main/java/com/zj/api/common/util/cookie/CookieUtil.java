package com.zj.api.common.util.cookie;

import org.springframework.util.StringUtils;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

/**
 * Created by js on 2017/1/25.
 */
public class CookieUtil {


    public static String getCookie(HttpServletRequest httpServletRequest, String cookieName) {
        if (httpServletRequest == null || !StringUtils.hasText(cookieName)) {
            throw new IllegalArgumentException("参数不能为空");
        }
        Cookie[] cookies = httpServletRequest.getCookies();
        for (Cookie cookie : cookies) {
            if (cookie.getName().equals(cookieName)) {
                return cookie.getValue();
            }
        }
        return null;
    }

}
