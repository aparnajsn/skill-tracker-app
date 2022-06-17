package com.skilltracker.controller;

import com.skilltracker.model.AddUserResponse;
import com.skilltracker.model.UpdateUserResponse;
import com.skilltracker.model.UserProfile;
import com.skilltracker.service.SkillTrackerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/skill-tracker/api/v1/")
public class SkillTrackerUserController {

    @Autowired
    SkillTrackerService service;

    @PostMapping("engineer/add-profile")
    public ResponseEntity addProfile(@RequestBody UserProfile userProfile){

        AddUserResponse response =  service.addUser(userProfile);
        response.setMessage("User Added Successfully!");
        return ResponseEntity.ok().body(response);
    }
    

    @PutMapping("engineer/update-profile/{userId}")
    public ResponseEntity updateProfile( @PathVariable Integer userId, @RequestBody UserProfile userProfile){

        UpdateUserResponse updateResponse = service.updateUser(userId, userProfile);
        return ResponseEntity.ok().body(updateResponse);
    }

}
