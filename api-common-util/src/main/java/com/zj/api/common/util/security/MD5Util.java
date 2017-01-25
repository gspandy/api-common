package com.zj.api.common.util.security;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.math.BigInteger;
import java.security.MessageDigest;

public class MD5Util {

    private static final Logger logger = LoggerFactory.getLogger(MD5Util.class);

    private static MessageDigest md = null;

    static {
        try {
            md = MessageDigest.getInstance("MD5");
        } catch (Exception e) {
            logger.error("MessageDigest 初始化失败,e{}", e);
        }
    }

    /**
     * @param value
     * @param salt  盐
     * @return
     */
    public static final String encrypt(String value, String salt) {
        md.update((value + salt).getBytes());
        return new BigInteger(1, md.digest()).toString(16);
    }

}
