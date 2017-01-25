package com.zj.api.web.security.sso.config;

import java.util.List;

/**
 * Created by js on 2017/1/25.
 */
public class Config {

    //需要过滤的url
    protected List<String> urls;

    public List<String> getUrls() {
        return urls;
    }

    public void setUrls(List<String> urls) {
        this.urls = urls;
    }
}
