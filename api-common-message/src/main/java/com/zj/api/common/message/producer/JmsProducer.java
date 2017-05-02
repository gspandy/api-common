package com.zj.api.common.message.producer;

import com.zj.api.common.message.model.MessageObject;
import com.zj.api.common.message.service.MessageService;
import com.zj.api.common.message.util.MessageUtil;
import org.apache.activemq.command.ActiveMQQueue;
import org.apache.activemq.command.ActiveMQTopic;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.util.Assert;
import org.springframework.util.StringUtils;

import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;
import java.io.Serializable;


/**
 * Created by js on 2017/1/17.
 */
public class JmsProducer {

    private JmsTemplate jmsTemplate;

    private MessageService messageService;

    /**
     * 第一次发消息
     *
     * @param destinationName
     * @param message
     */
    public void sendMessage(final String destinationName, Serializable message) {
        Assert.isTrue(!StringUtils.hasText(destinationName), "destinationName is null");
        Assert.notNull(message, "message is null");
        Destination destination = null;
        if (destinationName.contains("QUEUE")) {
            destination = new ActiveMQQueue(destinationName);
        } else if (destinationName.contains("TOPIC")) {
            destination = new ActiveMQTopic(destinationName);
        }

        final MessageObject<Serializable> messageObject = MessageUtil.getMessageObject(destinationName, message);
        //保存消息
        if (messageService.saveMessage(messageObject)) {
            jmsTemplate.send(destination, new MessageCreator() {
                public Message createMessage(Session session) throws JMSException {
                    return session.createObjectMessage(messageObject);
                }
            });
        }
    }


    /**
     * 供重发消息使用
     *
     * @param message 需要重发的消息
     */
    public void sendMessage(final MessageObject<Serializable> message) {
        jmsTemplate.send(message.getDestinationName(), new MessageCreator() {
            public Message createMessage(Session session) throws JMSException {
                return session.createObjectMessage(message);
            }
        });
    }

    public JmsTemplate getJmsTemplate() {
        return jmsTemplate;
    }

    public void setJmsTemplate(JmsTemplate jmsTemplate) {
        this.jmsTemplate = jmsTemplate;
    }

    public MessageService getMessageService() {
        return messageService;
    }

    public void setMessageService(MessageService messageService) {
        this.messageService = messageService;
    }

}
