package com.centreon.map.web.rest;

import com.centreon.map.service.AdvancedExampleKafkaProducer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/advanced-example-kafka")
public class AdvancedExampleKafkaResource {

    private final Logger log = LoggerFactory.getLogger(AdvancedExampleKafkaResource.class);

    private AdvancedExampleKafkaProducer kafkaProducer;

    public AdvancedExampleKafkaResource(AdvancedExampleKafkaProducer kafkaProducer) {
        this.kafkaProducer = kafkaProducer;
    }

    @PostMapping("/publish")
    public void sendMessageToKafkaTopic(@RequestParam("message") String message) {
        log.debug("REST request to send to Kafka topic the message : {}", message);
        this.kafkaProducer.send(message);
    }
}
