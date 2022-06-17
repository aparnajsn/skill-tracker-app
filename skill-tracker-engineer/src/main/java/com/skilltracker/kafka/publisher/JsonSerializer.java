package com.skilltracker.kafka.publisher;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.skilltracker.kafka.event.KafkaEvent;
import org.apache.kafka.common.serialization.Serializer;

public class JsonSerializer implements Serializer<KafkaEvent> {

    ObjectMapper objectMapper = new ObjectMapper();
    @Override
    public byte[] serialize(String topic, KafkaEvent data) {
        byte[] serializedData= null;
        try {
            serializedData = objectMapper.writeValueAsString(data).getBytes();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return serializedData;
    }
}
