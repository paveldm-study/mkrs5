package org.dpa.consuming_app.kafkalistener;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class MessageListener {

    @KafkaListener(topics = "report")
    public void listen(String message) {
        System.out.println("Received message: " + message);
    }
}
