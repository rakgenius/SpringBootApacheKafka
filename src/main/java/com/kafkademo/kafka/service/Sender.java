package com.kafkademo.kafka.service;

import com.kafkademo.kafka.model.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.support.MessageBuilder;

@Slf4j
public class Sender {

    @Autowired
    private KafkaTemplate<String, ?> kafkaTemplate;

    public void send(String topic, User payload) {
        log.info("sending payload='{}' to topic='{}'", payload.toString(), topic);
        kafkaTemplate
                .send(MessageBuilder.withPayload(payload).setHeader(KafkaHeaders.TOPIC, topic).build());
    }
}
