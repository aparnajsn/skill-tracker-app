package com.skilltracker.model;

import lombok.Builder;
import lombok.Data;
import lombok.Setter;

@Data
@Builder
@Setter
public class AddUserResponse {
    Integer userId;
    String associateId;
    String message;
}
