package com.skilltracker.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Value;

import javax.persistence.Column;
import java.sql.Timestamp;
import java.util.List;

@Value
@Builder
public class UserProfile {
    private String name;
    private String associateId;
    private String email;
    private String mobile;
    Timestamp createdDate;
    Timestamp updatedDate;

    @JsonProperty("technical-skills")
    private List<SkillExpertiseTech> technicalSkills;

    @JsonProperty("non-technical-skills")
    private List<SkillExpertiseNonTech> nonTechnicalSkills;
}
