package com.example.kafka.producer.config;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class MessageCreator {

    private final KafkaTemplate<String, String> kafkaTemplate;

    public MessageCreator(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    @Scheduled(fixedRate = 3000) // 3초마다 실행
    public void sendMessage() {
        String message = "Hello, Kafka!" + Math.random(); // 보낼 메시지 내용
        String topicName = "topic1";
        kafkaTemplate.send(topicName, message);
        System.out.println("Message sent to " + topicName + ": " + message);
    }
}
