package com.skilltracker.admin.service;

import com.skilltracker.admin.model.SkillTrackerResponse;
import org.springframework.stereotype.Service;

@Service
public interface SkillTrackerAdminService {

    public SkillTrackerResponse searchProfile(String criteria, String criteriaValue);
}
