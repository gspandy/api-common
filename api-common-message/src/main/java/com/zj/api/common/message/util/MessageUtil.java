package com.zj.api.common.message.util;

import com.zj.api.common.message.model.MessageObject;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by zhaojian on 2017/5/2.
 */
public class MessageUtil {

    /**
     * 获得一个消息的实例
     *
     * @param destinationName
     * @param message
     * @return
     */
    public static MessageObject<Serializable> getMessageObject(String destinationName, Serializable message) {
        MessageObject<Serializable> result = new MessageObject<Serializable>();
        result.setDestinationName(destinationName);
        result.setMessageId(new Date().getTime());
        result.setT(message);
        return result;
    }
}
