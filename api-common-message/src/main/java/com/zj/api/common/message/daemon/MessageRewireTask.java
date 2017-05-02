package com.zj.api.common.message.daemon;

import com.zj.api.common.message.model.MessageObject;
import com.zj.api.common.message.producer.JmsProducer;
import com.zj.api.common.message.service.MessageService;
import org.springframework.beans.factory.InitializingBean;

import java.util.List;

/**
 * Created by zhaojian on 2017/5/2.
 */
public class MessageRewireTask implements InitializingBean {


    private JmsProducer jmsProducer;

    private MessageService messageService;

    private final int timeout = 5;

    public MessageService getMessageService() {
        return messageService;
    }

    public void setMessageService(MessageService messageService) {
        this.messageService = messageService;
    }

    public JmsProducer getJmsProducer() {
        return jmsProducer;
    }

    public void setJmsProducer(JmsProducer jmsProducer) {
        this.jmsProducer = jmsProducer;
    }


    public void afterPropertiesSet() throws Exception {
        //获取长时间未消费的消息
        List<MessageObject> messageObjects = messageService.getTimeOutMessage(timeout);
        //重发
        for (MessageObject messageObject : messageObjects) {
            jmsProducer.sendMessage(messageObject);
        }
    }
}
