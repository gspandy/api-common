package com.zj.api.common.message.service;

import com.zj.api.common.message.model.MessageObject;

import java.util.List;


/**
 * Created by ZJ on 2017/4/13.
 */
public interface MessageService {
    /**
     * 保存消息
     * @param key  队列名字
     * @param message 消息
     * @return
     */
    boolean saveMessage(String key,MessageObject message);

    /**
     * 删除消息
     * @param messageId
     * @return
     */
    boolean deleteMessage(long messageId);

    /**
     * 获取队列下的所有消息
     * @param key 队列名字
     * @return
     */
    List<MessageObject> getMessagesByKey(String key);


    /**
     * 判断消息是否存在
     * @param key 队列名字
     * @param messageId 消息ID
     * @return
     */
    boolean checkMessage(String key,long messageId);

}
