package com.skilltracker.admin.kafka.event;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class KafkaEvent {
    FullStackEngineersEventTypeEnum eventType;
    String eventDateTime;
}
