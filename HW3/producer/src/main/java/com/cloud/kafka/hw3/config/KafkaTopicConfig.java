package com.cloud.kafka.hw3.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class KafkaTopicConfig {
    
    // @Bean
    // public NewTopic myTopic() {
    //     return TopicBuilder.name("myTopic")
    //             .build();
    // }

    // @Bean
    // public NewTopic myTopicJSON() {
    //     return TopicBuilder.name("myTopic_Json")
    //             .build();
    // }

    @Bean
    public NewTopic wikimediaRecentChanges() {
        return TopicBuilder.name("wikimedia_recent_changes")
                .build();
    }

    @Bean
    public NewTopic wikimediaPageCreate() {
        return TopicBuilder.name("wikimedia_page_create")
                .build();
    }

    @Bean
    public NewTopic wikimediaRevisionCreate() {
        return TopicBuilder.name("wikimedia_revision_create")
                .build();
    }
    
}
