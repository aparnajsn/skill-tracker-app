package com.skilltracker.kafka.event;

import com.skilltracker.entity.FullStackEngineers;
import lombok.Builder;
import lombok.Getter;

@Getter
public class LocationChangeEvent extends KafkaEvent {
    FullStackEngineers location;

    @Builder
    public LocationChangeEvent(FullStackEngineersEventTypeEnum eventType, String eventDateTime, FullStackEngineers location){
        super(eventType,eventDateTime);
        this.location = location;
    }
}
