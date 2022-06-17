package com.skilltracker.admin.kafka.event;

import com.skilltracker.admin.entity.FullStackEngineers;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class LocationChangeEvent extends KafkaEvent {
    FullStackEngineers location;

    @Builder
    public LocationChangeEvent(FullStackEngineersEventTypeEnum eventType, String eventDateTime, FullStackEngineers location){
        super(eventType,eventDateTime);
        this.location = location;
    }
}
