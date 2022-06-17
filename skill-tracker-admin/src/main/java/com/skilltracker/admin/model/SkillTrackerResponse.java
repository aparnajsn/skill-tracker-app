package com.skilltracker.admin.model;

import com.skilltracker.admin.entity.FullStackEngineers;
import lombok.Builder;
import lombok.Value;

import java.io.Serializable;
import java.util.List;

@Value
@Builder
public class SkillTrackerResponse implements Serializable {
    List<FullStackEngineers> fullStackEngineers;
}
