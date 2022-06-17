package com.skilltracker.admin.service.impl;

import com.skilltracker.admin.entity.FullStackEngineers;
import com.skilltracker.admin.model.SkillTrackerResponse;
import com.skilltracker.admin.repository.SkillTrackerAdminRepository;
import com.skilltracker.admin.service.SkillTrackerAdminService;
import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
public class SkillTrackerAdminServiceImpl implements SkillTrackerAdminService {

    @Autowired
    SkillTrackerAdminRepository skillTrackerAdminRepository;

    @Override
    //@Cacheable("fullstackEngineers")
    public SkillTrackerResponse searchProfile(String criteria, String criteriaValue) {

        List<FullStackEngineers> list = new ArrayList<>();

        switch (criteria) {
            case "name":
                log.info("Search Criteria is Name {} {} : ",  criteria, criteriaValue);
                List<FullStackEngineers> fullStackEngineers = skillTrackerAdminRepository.findByNameContains(criteriaValue);
                list.addAll(fullStackEngineers);
                break;
            case "associateId":
                log.info("Search Criteria is Name {} {} : ",  criteria, criteriaValue);
                List<FullStackEngineers> fullStackEngineers2 = skillTrackerAdminRepository.findByAssociateId(criteriaValue);
                list.addAll(fullStackEngineers2);
                break;
            case "skill":
                log.info("Search Criteria is Name {} {} : ",  criteria, criteriaValue);
                List<String> listReq = new ArrayList();
                listReq.add(criteriaValue);

                List<List<String>> Req2 = new ArrayList<>();
                Req2.add(listReq);
               // List<FullStackEngineers> fullStackEngineers3 = skillTrackerAdminRepository.findByTechnicalSkillsContains(Req2);
                //List<FullStackEngineers> fullStackEngineers4 = skillTrackerAdminRepository.findByNonTechnicalSkillsContains(criteriaValue);
                //list.addAll(fullStackEngineers3);
                //list.addAll(fullStackEngineers4);
                break;
            default:
                log.info("Invalid Searh Criteria {} {} : ",  criteria, criteriaValue);
        }

        return SkillTrackerResponse.builder()
                .fullStackEngineers(list)
                .build();
    }
}
