package com.sudip.kafka_demo.comsumer;

import org.springframework.stereotype.Service;

import com.sudip.kafka_demo.payload.Student;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class KafkaConsumer {

    // @org.springframework.kafka.annotation.KafkaListener(topics = "topic1",
    // groupId = "group_id")
    // public void consume(String message) {
    // log.info(String.format("Consumed message: %s", message));

    // }

    @org.springframework.kafka.annotation.KafkaListener(topics = "topic1", groupId = "group_id")
    public void consume(Student message) {
        log.info(String.format("Consumed message: %s", message.toString()));

    }
}
