package com.zj.api.common.message.service.impl;


import com.zj.api.common.message.model.MessageObject;
import com.zj.api.common.message.service.MessageService;

import java.io.Serializable;
import java.util.List;


/**
 * Created by ZJ on 2017/4/13.
 */
public class MessageServiceImpl implements MessageService {


    public boolean saveMessage(MessageObject<Serializable> messageObject) {
        return false;
    }

    public boolean deleteMessage(long messageId) {
        return false;
    }

    public List<MessageObject> getAllMessage() {
        return null;
    }

    public boolean checkMessage(long messageId) {
        return false;
    }

    public List<MessageObject> getTimeOutMessage(int timeout) {
        return null;
    }
}
