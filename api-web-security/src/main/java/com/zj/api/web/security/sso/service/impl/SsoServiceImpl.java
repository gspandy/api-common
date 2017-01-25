package com.zj.api.web.security.sso.service.impl;

import com.whalin.MemCached.MemCachedClient;
import com.zj.api.common.util.cookie.CookieUtil;
import com.zj.api.web.security.sso.config.Config;
import com.zj.api.web.security.sso.constant.SsoConstant;
import com.zj.api.web.security.sso.service.SsoService;
import org.apache.commons.io.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StringUtils;

import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import java.io.OutputStream;
import java.util.Date;

/**
 * Created by js on 2017/1/25.
 */
public class SsoServiceImpl extends Config implements SsoService {


    private static final Logger logger = LoggerFactory.getLogger(SsoServiceImpl.class);

    private MemCachedClient memCachedClient;

    public MemCachedClient getMemCachedClient() {
        return memCachedClient;
    }

    public void setMemCachedClient(MemCachedClient memCachedClient) {
        this.memCachedClient = memCachedClient;
    }


    public boolean filter(HttpServletRequest request, ServletResponse response) {
        OutputStream ous = null;
        try {
            ous = response.getOutputStream();
            if (checkUrls(request)) {
                String cookie = CookieUtil.getCookie(request, SsoConstant.SSO_COOKIE_NAME);
                if (StringUtils.hasText(cookie)) {
                    Object object = memCachedClient.get(cookie);
                    if (object != null) {
                        memCachedClient.set(cookie, object, new Date(1000 * 60 * request.getSession().getMaxInactiveInterval()));
                        return true;
                    } else {
                        logger.info("SSO登录信息已过期,cookie:{}", cookie);
                        IOUtils.write("登录信息已过期", ous);
                        return false;
                    }
                } else {
                    logger.info("SSO登录的cookie不存在");
                    IOUtils.write("未登录", ous);
                    return false;
                }
            } else {
                return true;
            }
        } catch (Exception e) {
            logger.error("处理登录信息异常,e:{}", e);
            return false;
        } finally {
            IOUtils.closeQuietly(ous);
        }
    }

    /**
     * 判断请求的url是否需要过滤
     *
     * @param request
     * @return
     */
    private boolean checkUrls(HttpServletRequest request) {
        String requestURL = request.getRequestURL().toString();
        if (urls != null && !urls.isEmpty()) {
            for (String url : urls) {
                if (requestURL.contains(url)) {
                    return true;
                }
            }
        }
        return false;
    }
}
