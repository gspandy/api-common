package com.zj.api.web.security.sso.filter;


import com.zj.api.web.security.sso.service.SsoService;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by js on 2017/1/25.
 * 问题
 * 1.未登录能不能访问页面还是未登录只能访问登录页面
 */
public class CoreFilter implements Filter {


    private SsoService ssoService;


    public void init(FilterConfig filterConfig) throws ServletException {

    }

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse rsp = (HttpServletResponse) response;
        if (ssoService.filter(req, rsp)) {
            chain.doFilter(req, rsp);
        }
    }

    public void destroy() {

    }

}
