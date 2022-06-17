package com.skilltracker.service;

import com.skilltracker.model.AddUserResponse;
import com.skilltracker.model.UpdateUserResponse;
import com.skilltracker.model.UserProfile;
import org.springframework.stereotype.Service;

@Service
public interface SkillTrackerService {

    public AddUserResponse addUser(UserProfile userProfile);

    public UpdateUserResponse updateUser(Integer userId, UserProfile userProfile);
}
