package org.dpa.mkrs5.controllers;

import org.dpa.mkrs5.repository.entities.User;
import org.dpa.mkrs5.kafkaproducer.KafkaProducer;
import org.dpa.mkrs5.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;


import java.util.List;

@RestController
public class UserController {

    private UserRepository userRepository;
    @Autowired
    private KafkaProducer kafkaProducer;

    @Autowired
    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping("/user/all")
    public List<User> allUsers() {
        RestTemplate restTemplate = new RestTemplate();
        List<User> users = userRepository.findAll();
        String url = "http://localhost:8080/accept";
        ResponseEntity<String> response = restTemplate.postForEntity(url, users, String.class);
        String responseBody = response.getBody();
        sendResult("report send");

        return userRepository.findAll();
    }

    public void sendResult(String message) {
        kafkaProducer.sendMessage(message);
    }
}
