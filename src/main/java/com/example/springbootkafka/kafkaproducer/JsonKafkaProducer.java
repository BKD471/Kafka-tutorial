package com.example.springbootkafka.kafkaproducer;

import com.example.springbootkafka.payload.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class JsonKafkaProducer {
    @Value("${spring.kafka.topic-json.name}")
    private String topicName;

    private KafkaTemplate<String, User> kafkaTemplate;

    JsonKafkaProducer(KafkaTemplate<String, User> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendMessage(User data) {
        log.info(String.format("Message sent successfully: %s ",data));

        //build the message that we are going to write into the kafka topic
        Message<User> message=MessageBuilder.withPayload(data).
                setHeader(KafkaHeaders.TOPIC,topicName).build();
        kafkaTemplate.send(message);
    }

}
