package com.zj.api.common.message.service.impl;


import com.zj.api.common.message.model.MessageObject;
import com.zj.api.common.message.service.MessageService;

import java.util.Date;
import java.util.List;


/**
 * Created by ZJ on 2017/4/13.
 */
public class MessageServiceImpl implements MessageService {

    public boolean saveMessage(String key, MessageObject message) {
        try {
            message.setMessageId(new Date().getTime());
        } catch (IllegalArgumentException e) {

        } catch (Exception e) {

        }

        return false;
    }

    public boolean deleteMessage(long messageId) {
        return false;
    }

    public List<MessageObject> getMessagesByKey(String key) {
        return null;
    }

    public boolean checkMessage(String key, long messageId) {
        return false;
    }
}
