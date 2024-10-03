package com.sudip.kafka_demo.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sudip.kafka_demo.payload.Student;
import com.sudip.kafka_demo.poducer.KafkaProducer;
import com.sudip.kafka_demo.poducer.KafkajsonProducer;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/v1/message")
@RequiredArgsConstructor
public class MessageController {

    private final KafkaProducer kafkaProducer;
    private final KafkajsonProducer kafkajsonProducer;

    // normal string message
    @PostMapping
    public ResponseEntity<String> sendMessage(@RequestBody String message) {
        kafkaProducer.sendMessage(message);
        return ResponseEntity.ok("Message sent to Kafka topic");
    }

    // json message
    @PostMapping("/json")
    public ResponseEntity<String> sendJsonMessage(@RequestBody Student message) {
        kafkajsonProducer.sendMessage(message);
        return ResponseEntity.ok("Message sent to Kafka topic");
    }
}
