package com.kafkademo.kafka.controller;

import com.kafkademo.kafka.model.User;
import com.kafkademo.kafka.service.Sender;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.kafkademo.kafka.config.Constants.TOPIC1;
import static com.kafkademo.kafka.config.Constants.TOPIC2;

@RestController
@RequestMapping("/kafka")
public class KafkaController {
    private Sender sender;

    KafkaController(Sender sender) {
        this.sender = sender;
    }

    @GetMapping("/topic1/{name}")
    public void username(@PathVariable("name") String name){
        User user = User.builder()
                .firstName(name)
                .lastName(name)
                .age(32)
                .build();

        this.sender.send(TOPIC1, user);
    }

    @GetMapping("/topic2/{name}")
    public void wtf(@PathVariable("name") String name){
        User user = User.builder()
                .firstName(name)
                .lastName(name)
                .age(32)
                .build();

        this.sender.send(TOPIC2, user);
    }
}
