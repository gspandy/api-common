package com.zj.api.common.message.service;

import com.zj.api.common.message.model.MessageObject;

import java.io.Serializable;
import java.util.List;


/**
 * Created by ZJ on 2017/4/13.
 */
public interface MessageService {
    /**
     * 保存消息
     *
     * @param messageObject 消息
     * @return
     */
    boolean saveMessage(MessageObject<Serializable> messageObject);

    /**
     * 删除消息
     *
     * @param messageId
     * @return
     */
    boolean deleteMessage(long messageId);

    /**
     * 获取队列下的所有消息
     *
     * @return
     */
    List<MessageObject> getAllMessage();


    /**
     * 判断消息是否存在
     *
     * @param messageId 消息ID
     * @return
     */
    boolean checkMessage(long messageId);


    /**
     * 获得一定超时时间的消息
     *
     * @param timeout 单位:秒
     * @return
     */
    List<MessageObject> getTimeOutMessage(int timeout);


    /**
     * 保存已经消费过的消息
     *
     * @param messageObject
     * @return
     */
    boolean saveUserdMessage(MessageObject<Serializable> messageObject);


}
