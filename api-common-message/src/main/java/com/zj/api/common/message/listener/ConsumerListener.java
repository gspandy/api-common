package com.zj.api.common.message.listener;

import com.zj.api.common.message.model.MessageObject;
import com.zj.api.common.message.service.MessageService;

import java.io.Serializable;

/**
 * Created by js on 2017/1/18.
 */
public abstract class ConsumerListener<T extends Serializable> {


    private MessageService messageService;

    /**
     * 做消息前的一些处理
     *
     * @param message
     */
    public void receive(T message) {
        MessageObject<Serializable> messageObject = (MessageObject<Serializable>) message;

        //检查消息是否存在已消费的消息列表中
        if (messageService.checkMessage(messageObject.getMessageId())) {
            return;
        } else {
            if (messageService.saveUserdMessage(messageObject)) {
                messageService.deleteMessage(messageObject.getMessageId());
                receiveMessage((T) messageObject.getT());
            }
        }


    }

    /**
     * 消费消息
     *
     * @param t
     */
    abstract void receiveMessage(T t);
}
