package com.zj.api.web.security.sso.service;

import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

/**
 * Created by js on 2017/1/25.
 */
public interface SsoService {

    boolean filter(HttpServletRequest request, ServletResponse response);

}
