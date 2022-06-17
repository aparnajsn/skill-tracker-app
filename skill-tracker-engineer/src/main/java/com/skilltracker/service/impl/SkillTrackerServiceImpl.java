package com.skilltracker.service.impl;

import com.skilltracker.entity.FullStackEngineers;
import com.skilltracker.kafka.event.FullStackEngineersEventTypeEnum;
import com.skilltracker.kafka.event.LocationChangeEvent;
import com.skilltracker.kafka.publisher.LocationChangeEventPublisher;
import com.skilltracker.model.*;
import com.skilltracker.repository.NonTechnicalSkillsRepository;
import com.skilltracker.repository.SkillTrackerRepository;
import com.skilltracker.repository.TechnicalSkillsRepository;
import com.skilltracker.service.SkillTrackerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class SkillTrackerServiceImpl implements SkillTrackerService {

    @Autowired
    SkillTrackerRepository repository;

    @Autowired
    TechnicalSkillsRepository technicalSkillsRepository;

    @Autowired
    NonTechnicalSkillsRepository nonTechnicalSkillsRepository;

    @Autowired
    LocationChangeEventPublisher locationChangeEventPublisher;

    public AddUserResponse addUser(UserProfile userProfile){
        log.info("Before Saving data into database");
        FullStackEngineers fullStackEngineers = new FullStackEngineers();
        BeanUtils.copyProperties(userProfile, fullStackEngineers);



        log.info("fullstackengineers {} ", userProfile);
        log.info("fullstackengineers {} ", fullStackEngineers);

        fullStackEngineers.setCreatedDate(new Timestamp(System.currentTimeMillis()));
        fullStackEngineers = repository.save(fullStackEngineers);

        List<com.skilltracker.entity.SkillExpertiseTech> list = new ArrayList<>();
        for (SkillExpertiseTech skillExpertiseTech: userProfile.getTechnicalSkills()) {
            com.skilltracker.entity.SkillExpertiseTech expertiseTech = new com.skilltracker.entity.SkillExpertiseTech();
            BeanUtils.copyProperties(skillExpertiseTech, expertiseTech);
            expertiseTech.setFullStackEngineers(fullStackEngineers);
            list.add(expertiseTech);
        }
        fullStackEngineers.setTechnicalSkills(list);
        technicalSkillsRepository.saveAll(list);

        List<com.skilltracker.entity.SkillExpertiseNonTech> listNonTech = new ArrayList<>();
        for (SkillExpertiseNonTech skillExpertiseNonTech: userProfile.getNonTechnicalSkills()) {
            com.skilltracker.entity.SkillExpertiseNonTech expertiseTech = new com.skilltracker.entity.SkillExpertiseNonTech();
            BeanUtils.copyProperties(skillExpertiseNonTech, expertiseTech);
            expertiseTech.setFullStackEngineers(fullStackEngineers);
            listNonTech.add(expertiseTech);
        }
        fullStackEngineers.setNonTechnicalSkills(listNonTech);
        nonTechnicalSkillsRepository.saveAll(listNonTech);


       // try {
       //     LocationChangeEvent locationChangeEvent = new LocationChangeEvent(FullStackEngineersEventTypeEnum.ADD, "", fullStackEngineers);
       //     locationChangeEventPublisher.generateAddEvent(locationChangeEvent);
       // } catch (InterruptedException e) {
        //    log.error("Event Publishing Error {} {} " + fullStackEngineers, e);
       // }*/

        log.info("after Saving data into database : " + fullStackEngineers.getId());
        return AddUserResponse.builder()
                .userId(fullStackEngineers.getId())
                .associateId(fullStackEngineers.getAssociateId())
                .build();
    }

    @Override
    public UpdateUserResponse updateUser(Integer userId, UserProfile userProfile) {

        log.info("Before Saving data into database");

        Optional<FullStackEngineers> fullStackEngineersResp = repository.findById(userId);

        FullStackEngineers fullStackEngineers = fullStackEngineersResp.get();

        if(fullStackEngineers == null){
            throw new IllegalArgumentException("Invalid User Id");
        }

        log.info("Before Saving data into database {} : ", fullStackEngineers);

        fullStackEngineers.setUpdatedDate(new Timestamp(System.currentTimeMillis()));
        fullStackEngineers = repository.save(fullStackEngineers);

        List<com.skilltracker.entity.SkillExpertiseTech> list = new ArrayList<>();
        for (SkillExpertiseTech skillExpertiseTech: userProfile.getTechnicalSkills()) {
            com.skilltracker.entity.SkillExpertiseTech expertiseTech = new com.skilltracker.entity.SkillExpertiseTech();
            BeanUtils.copyProperties(skillExpertiseTech, expertiseTech);
            expertiseTech.setFullStackEngineers(fullStackEngineers);
            list.add(expertiseTech);
        }
        fullStackEngineers.setTechnicalSkills(list);
        technicalSkillsRepository.saveAll(list);

        List<com.skilltracker.entity.SkillExpertiseNonTech> listNonTech = new ArrayList<>();
        for (SkillExpertiseNonTech skillExpertiseNonTech: userProfile.getNonTechnicalSkills()) {
            com.skilltracker.entity.SkillExpertiseNonTech expertiseTech = new com.skilltracker.entity.SkillExpertiseNonTech();
            BeanUtils.copyProperties(skillExpertiseNonTech, expertiseTech);
            expertiseTech.setFullStackEngineers(fullStackEngineers);
            listNonTech.add(expertiseTech);
        }

        fullStackEngineers.setNonTechnicalSkills(listNonTech);
        nonTechnicalSkillsRepository.saveAll(listNonTech);

        log.info("after Saving data into database : " + fullStackEngineers.getId());

        return UpdateUserResponse.builder()
                .userId(fullStackEngineers.getId())
                .message("User Updated Successfully!")
                .build();
    }
}
