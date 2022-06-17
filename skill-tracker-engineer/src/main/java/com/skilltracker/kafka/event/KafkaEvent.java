package com.skilltracker.kafka.event;

import com.skilltracker.entity.FullStackEngineers;
import lombok.AllArgsConstructor;
import lombok.Getter;


@Getter
@AllArgsConstructor
public class KafkaEvent {
    FullStackEngineersEventTypeEnum eventType;
    String eventDateTime;
}
