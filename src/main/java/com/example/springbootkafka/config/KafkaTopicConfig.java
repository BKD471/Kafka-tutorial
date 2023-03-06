package com.example.springbootkafka.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;


//Component where we create kafka topics
@Configuration
public class KafkaTopicConfig {

    @Value("${spring.kafka.topic.name}")
    private String topicName;

    @Value("${spring.kafka.topic-json.name}")
    private String jsonTopicName;

    //For consuming  type String messages
    @Bean
    public NewTopic createTopic(){
        return TopicBuilder.name(topicName).build();
    }

    //For consuming type Json messages
    @Bean
    public NewTopic createJsonTopic(){
        return TopicBuilder.name(jsonTopicName).build();
    }
}
