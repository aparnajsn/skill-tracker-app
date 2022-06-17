package com.skilltracker.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Value;

import java.math.BigInteger;

@Value
@Builder
public class SkillExpertiseNonTech {
    @JsonProperty("skill-id")
    private BigInteger skillId;

    @JsonProperty("skill-name")
    private String skillName;

    @JsonProperty("expertise")
    private String expertise;
}
