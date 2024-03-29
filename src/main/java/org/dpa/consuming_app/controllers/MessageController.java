package org.dpa.consuming_app.controllers;

import org.dpa.mkrs5.repository.UserRepository;
import org.dpa.mkrs5.repository.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
public class MessageController {
    @RequestMapping("/accept")
    public String acceptMessage(@RequestParam String message) {
        return "Received message: " + message;
    }
}
