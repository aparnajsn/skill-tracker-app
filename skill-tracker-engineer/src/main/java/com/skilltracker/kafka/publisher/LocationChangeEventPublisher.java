package com.skilltracker.kafka.publisher;

import com.skilltracker.entity.FullStackEngineers;
import com.skilltracker.kafka.event.LocationChangeEvent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;

import java.util.Arrays;

@Service
@Slf4j
public class LocationChangeEventPublisher {
    @Autowired
    KafkaTemplate<String, Object> kafkaTemplate;

    String LOCATION_TOPIC = "location";

    public void generateAddEvent(LocationChangeEvent locationChangeEvent) throws InterruptedException {
        log.info("Before publishing the message to Kafka topic : " + locationChangeEvent);
        ListenableFuture<SendResult<String, Object>> listenableFuture = kafkaTemplate.send(LOCATION_TOPIC, locationChangeEvent);

        listenableFuture.addCallback(new ListenableFutureCallback<SendResult<String, Object>>() {

            @Override
            public void onSuccess(SendResult<String, Object> result) {
                log.info("Kafka Published Success : " + result.getProducerRecord());
            }

            @Override
            public void onFailure(Throwable ex) {
                log.info("Kafka Published Failed : " + Arrays.toString(ex.getStackTrace()));
            }

        });
    }

}
