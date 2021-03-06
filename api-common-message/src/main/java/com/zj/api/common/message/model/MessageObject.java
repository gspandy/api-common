package com.zj.api.common.message.model;

import java.io.Serializable;

/**
 * Created by ZJ on 2017/4/13.
 */
public class MessageObject<T extends Serializable> implements Serializable {

    private String destinationName;

    private long messageId;

    private T t;

    public String getDestinationName() {
        return destinationName;
    }

    public void setDestinationName(String destinationName) {
        this.destinationName = destinationName;
    }

    public long getMessageId() {
        return messageId;
    }

    public void setMessageId(long messageId) {
        this.messageId = messageId;
    }

    public T getT() {
        return t;
    }

    public void setT(T t) {
        this.t = t;
    }

    @Override
    public String toString() {
        return "MessageObject{" +
                "destinationName='" + destinationName + '\'' +
                ", messageId=" + messageId +
                ", t=" + t +
                '}';
    }
}
