package com.example.springbootkafka.kafkaproducer;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;


//Notes if we are using SPring boot, then wed ont need to configure kafka template
// SB already provides autconfiguration for kafkatemplate , just inject it where you need it
//otherwise we have to configure kafka template
@Slf4j
@Service
public class KafkaProducer{
    @Value("${spring.kafka.topic.name}")
    private String topicName="Phoenix";
    private static final Logger LOGGER= (Logger) LoggerFactory.getLogger(KafkaProducer.class);

    private KafkaTemplate<String, String> kafkaTemplate;

    public KafkaProducer(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendMessage(String message){
        log.info(String.format("Message sent %s",message));
        kafkaTemplate.send(topicName,message);
    }
}
