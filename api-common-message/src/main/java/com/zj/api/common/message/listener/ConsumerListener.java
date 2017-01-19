package com.zj.api.common.message.listener;

import java.io.Serializable;

/**
 * Created by js on 2017/1/18.
 */
public interface ConsumerListener<T extends Serializable> {

    void receiveMessage(T t);
}
