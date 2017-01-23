package com.zj.api.common.message.consumer;

import com.zj.api.common.message.listener.ConsumerListener;
import org.apache.activemq.command.ActiveMQQueue;
import org.apache.activemq.command.ActiveMQTopic;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.jms.listener.DefaultMessageListenerContainer;
import org.springframework.jms.listener.adapter.MessageListenerAdapter;
import org.springframework.jms.support.converter.MessageConverter;

import javax.jms.ConnectionFactory;
import javax.jms.Destination;


/**
 * Created by js on 2017/1/16.
 */
public class JmsConsumer implements InitializingBean {

    private String queueName;

    private ConnectionFactory connectionFactory;

    private MessageConverter messageConverter;

    private ConsumerListener<?> delegate;

    private String concurrency;

    private int concurrentConsumers;

    public int getConcurrentConsumers() {
        return concurrentConsumers;
    }

    public void setConcurrentConsumers(int concurrentConsumers) {
        this.concurrentConsumers = concurrentConsumers;
    }

    public String getConcurrency() {
        return concurrency;
    }

    public void setConcurrency(String concurrency) {
        this.concurrency = concurrency;
    }

    public String getQueueName() {
        return queueName;
    }

    public void setQueueName(String queueName) {
        this.queueName = queueName;
    }

    public ConnectionFactory getConnectionFactory() {
        return connectionFactory;
    }

    public void setConnectionFactory(ConnectionFactory connectionFactory) {
        this.connectionFactory = connectionFactory;
    }

    public MessageConverter getMessageConverter() {
        return messageConverter;
    }

    public void setMessageConverter(MessageConverter messageConverter) {
        this.messageConverter = messageConverter;
    }

    public ConsumerListener<?> getDelegate() {
        return delegate;
    }

    public void setDelegate(ConsumerListener<?> delegate) {
        this.delegate = delegate;
    }

    public void afterPropertiesSet() throws Exception {
        Destination destination = null;
        DefaultMessageListenerContainer defaultContainer = new DefaultMessageListenerContainer();
        defaultContainer.setConnectionFactory(this.connectionFactory);
        MessageListenerAdapter listenerAdapter = new MessageListenerAdapter();
        listenerAdapter.setDelegate(this.delegate);
        defaultContainer.setMessageConverter(this.messageConverter);
        listenerAdapter.setDefaultListenerMethod("receiveMessage");
        defaultContainer.setMessageListener(listenerAdapter);
        defaultContainer.setConcurrency(this.concurrency == null ? "1" : this.concurrency);
        defaultContainer.setConcurrentConsumers(this.concurrentConsumers == 0 ? 1 : this.concurrentConsumers);
        if (queueName.contains("QUEUE")) {
            destination = new ActiveMQQueue(queueName);
        } else if (queueName.contains("TOPIC")) {
            destination = new ActiveMQTopic(queueName);
        }
        defaultContainer.setDestination(destination);
        defaultContainer.initialize();
        defaultContainer.start();
    }


}
