package com.skilltracker.admin.kafka.consumer;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.skilltracker.admin.kafka.event.KafkaEvent;
import com.skilltracker.admin.kafka.event.LocationChangeEvent;
import org.apache.kafka.common.serialization.Deserializer;

public class JsonDeSerializer implements Deserializer<LocationChangeEvent> {

    ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public LocationChangeEvent deserialize(String topic, byte[] data) {
        LocationChangeEvent kafkaEvent= null;
        try {
            kafkaEvent= objectMapper.readValue(data, LocationChangeEvent.class);
        }catch (Exception exception){
            exception.printStackTrace();
        }
        return kafkaEvent;
    }
}
