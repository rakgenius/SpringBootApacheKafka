package com.kafkademo.kafka.service;

import com.kafkademo.kafka.model.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;

import static com.kafkademo.kafka.config.Constants.TOPIC1;
import static com.kafkademo.kafka.config.Constants.TOPIC2;

@Slf4j
public class Receiver {
    @KafkaListener(topics = TOPIC1)
    public void receiveTopic1(User bar) {
        log.info("TOPIC: {} ; received {}", TOPIC1, bar.toString());
    }

    @KafkaListener(topics = TOPIC2)
    public void receiveTopic2(User foo) {
        log.info("TOPIC: {} : received {}", TOPIC2, foo.toString());
    }
}
