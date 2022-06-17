package com.skilltracker.admin.kafka.consumer;

import com.skilltracker.admin.entity.FullStackEngineers;
import com.skilltracker.admin.kafka.event.LocationChangeEvent;
import com.skilltracker.admin.repository.NonTechnicalSkillsRepository;
import com.skilltracker.admin.repository.SkillTrackerRepository;
import com.skilltracker.admin.repository.TechnicalSkillsRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class LocationKafkaListener {

    String LOCATION_TOPIC = "location";

    @Autowired
    SkillTrackerRepository repository;

    @Autowired
    TechnicalSkillsRepository technicalSkillsRepository;

    @Autowired
    NonTechnicalSkillsRepository nonTechnicalSkillsRepository;

    @KafkaListener(topics = "location", groupId = "uoo")
    public void listen(LocationChangeEvent event) throws Exception{
        handleEvent(event);
        log.info("Kafka Listener data : " + event.getLocation());
    }

    private void handleEvent(LocationChangeEvent event) throws Exception{
        String eventType = event.getEventType().toString();


        switch (eventType){
            case "ADD":
                log.info("QR Code generation successful - User id : {} & Location Id : {}");
                //FullStackEngineers fullStackEngineers = new FullStackEngineers();
                repository.save(event.getLocation());
                break;
            case "UPDATE":
                log.info("QR Code deletion successful - User id : {} & Location Id : {}");

                break;
            default:
                log.error("Error in Event type Received " + event.getEventType());

        }
    }
}
