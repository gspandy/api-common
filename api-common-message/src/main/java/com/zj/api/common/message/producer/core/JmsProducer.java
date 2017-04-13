package com.zj.api.common.message.producer.core;

import com.zj.api.common.message.model.MessageObject;
import com.zj.api.common.message.service.MessageService;
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


/**
 * Created by js on 2017/1/17.
 */
public class JmsProducer {

    private JmsTemplate jmsTemplate;

    private MessageService messageService;

    public void sendMessage(final String destinationName, final MessageObject message) {
        Assert.isTrue(!StringUtils.hasText(destinationName), "destinationName is null");
        Assert.notNull(message, "message is null");
        Destination destination = null;
        if (destinationName.contains("QUEUE")) {
            destination = new ActiveMQQueue(destinationName);
        } else if (destinationName.contains("TOPIC")) {
            destination = new ActiveMQTopic(destinationName);
        }
        //保存消息
        if (messageService.saveMessage(destinationName, message)) {
            jmsTemplate.send(destination, new MessageCreator() {
                public Message createMessage(Session session) throws JMSException {
                    return session.createObjectMessage(message);
                }
            });
        }
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
