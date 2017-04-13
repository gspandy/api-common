package com.zj.api.common.message.producer;


import com.zj.api.common.message.model.MessageObject;
import com.zj.api.common.message.producer.core.JmsProducer;
import com.zj.api.common.message.service.MessageService;
import com.zj.api.common.message.util.ThreadUtil;
import org.springframework.beans.factory.InitializingBean;

import java.util.List;

import java.util.concurrent.atomic.AtomicBoolean;

/**
 * Created by ZJ on 2017/4/13.
 */
public class JmsSender implements InitializingBean {

    protected JmsProducer jmsProducer;

    protected String destinationName;

    protected MessageService messageService;

    private Thread thread;

    protected volatile AtomicBoolean atomicBoolean = new AtomicBoolean(true);


    public void sendMessage(MessageObject messageObject) {
        jmsProducer.sendMessage(destinationName, messageObject);
        if (atomicBoolean.get()) {
            thread = new Thread(new Runnable() {
                public void run() {
                    List<MessageObject> messageObjects = messageService.getMessagesByKey(destinationName);
                    for (MessageObject messageObject : messageObjects) {
                        jmsProducer.sendMessage(destinationName, messageObject);
                    }
                    ThreadUtil.sleep(60);
                }
            });
            thread.start();
            atomicBoolean.set(false);
        }
    }

    public void afterPropertiesSet() throws Exception {
        while (true) {
            if(!thread.isAlive()){
                thread.start();
            }
            ThreadUtil.sleep(120);
        }
    }
}
