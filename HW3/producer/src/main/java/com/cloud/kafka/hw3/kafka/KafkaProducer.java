package com.cloud.kafka.hw3.kafka;
import java.net.URI;

import org.slf4j.Logger;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import com.cloud.kafka.hw3.WikimediaEventsHandler;

import com.launchdarkly.eventsource.EventHandler;
import com.launchdarkly.eventsource.EventSource;

@Service
public class KafkaProducer {
    
    private static final Logger LOGGER = org.slf4j.LoggerFactory.getLogger(KafkaProducer.class);
    private KafkaTemplate<String, String> kafkaTemplate;

    public KafkaProducer(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }
    public void sendMessage(){
        String topic = "wikimedia_page_create";
        EventHandler eventHandler = new WikimediaEventsHandler(kafkaTemplate, topic);
        String url = "https://stream.wikimedia.org/v2/stream/page-create";
        EventSource.Builder builder = new EventSource.Builder(eventHandler, URI.create(url));
        EventSource eventSource = builder.build();
        eventSource.start();

    }
}
