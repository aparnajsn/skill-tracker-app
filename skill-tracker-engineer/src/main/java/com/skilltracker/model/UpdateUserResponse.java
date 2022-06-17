package com.skilltracker.model;

import lombok.Builder;
import lombok.Value;

@Builder
@Value
public class UpdateUserResponse {
    Integer userId;
    String associateId;
    String message;
}
