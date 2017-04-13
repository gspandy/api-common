package com.zj.api.common.message.util;

import java.util.concurrent.TimeUnit;

/**
 * Created by ZJ on 2017/4/13.
 */
public class ThreadUtil {

    public static void sleep(long timeout){
        try {
            TimeUnit.SECONDS.sleep(timeout);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
