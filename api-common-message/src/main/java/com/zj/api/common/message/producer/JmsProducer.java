package com.zj.api.common.message.producer;

import org.apache.activemq.command.ActiveMQQueue;
import org.apache.activemq.command.ActiveMQTopic;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;

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


    public void sendMessage(final String destinationName, final Serializable message) {
        Destination destination = null;
        if (destinationName.contains("QUEUE")) {
            destination = new ActiveMQQueue(destinationName);
        } else if (destinationName.contains("TOPIC")) {
            destination = new ActiveMQTopic(destinationName);
        }
        jmsTemplate.send(destination, new MessageCreator() {
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
}
