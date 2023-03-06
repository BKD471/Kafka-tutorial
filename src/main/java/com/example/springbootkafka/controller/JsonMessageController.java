package com.example.springbootkafka.controller;

import com.example.springbootkafka.kafkaproducer.JsonKafkaProducer;
import com.example.springbootkafka.payload.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/kafka")
public class JsonMessageController {
    private JsonKafkaProducer jsonKafkaProducer;

    JsonMessageController(JsonKafkaProducer jsonKafkaProducer) {
        this.jsonKafkaProducer = jsonKafkaProducer;
    }

    @PostMapping("/publish")
    public ResponseEntity<String> sendMessage(@RequestBody User user) {
        jsonKafkaProducer.sendMessage(user);
        return new ResponseEntity<>("Json msg sent successfully to kafka topic Phoenix", HttpStatus.OK);
    }
}
