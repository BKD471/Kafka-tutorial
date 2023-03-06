package com.example.springbootkafka.kafkaproducer;

import com.example.springbootkafka.payload.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class JsonKafkaConsumer {
    @KafkaListener(topics = "${spring.kafka.topic-json.name}", groupId = "${spring.kafka.consumer.group-id}")
    public void consumeMessages(User user) {
        log.info(String.format("Json message sent successfully: %s", user.toString()));
    }

}
