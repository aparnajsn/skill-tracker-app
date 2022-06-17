package com.skilltracker.admin.controller;

import com.skilltracker.admin.model.SkillTrackerResponse;
import com.skilltracker.admin.service.SkillTrackerAdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/skill-tracker/api/v1/")
public class SkillTrackerAdminController {

    @Autowired
    SkillTrackerAdminService skillTrackerAdminService;

    @GetMapping("admin/{criteria}/{criteriaValue}")
    public ResponseEntity searchProfile(@PathVariable String criteria, @PathVariable String criteriaValue){

        SkillTrackerResponse skillTrackerResponse = skillTrackerAdminService.searchProfile(criteria, criteriaValue);

        return ResponseEntity.ok().body(skillTrackerResponse);
    }

}
