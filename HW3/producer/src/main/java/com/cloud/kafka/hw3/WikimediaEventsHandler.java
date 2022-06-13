package com.cloud.kafka.hw3;

import org.slf4j.Logger;
import org.springframework.kafka.core.KafkaTemplate;

import com.launchdarkly.eventsource.EventHandler;
import com.launchdarkly.eventsource.MessageEvent;

public class WikimediaEventsHandler implements EventHandler {

    private final static Logger LOGGER = org.slf4j.LoggerFactory.getLogger(WikimediaEventsHandler.class);
    private KafkaTemplate<String, String> kafkaTemplate;
    private String topic;

    public WikimediaEventsHandler(KafkaTemplate<String, String> kafkaTemplate, String topic) {
        this.kafkaTemplate = kafkaTemplate;
        this.topic = topic;
    }

    @Override
    public void onClosed() throws Exception {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void onComment(String arg0) throws Exception {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void onError(Throwable arg0) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void onMessage(String arg0, MessageEvent arg1) throws Exception {
        // TODO Auto-generated method stub
        LOGGER.info(String.format("Event data: %s", arg1.getData()));
        kafkaTemplate.send(topic, arg1.getData());
        
    }

    @Override
    public void onOpen() throws Exception {
        // TODO Auto-generated method stub
        
    }
    
}
