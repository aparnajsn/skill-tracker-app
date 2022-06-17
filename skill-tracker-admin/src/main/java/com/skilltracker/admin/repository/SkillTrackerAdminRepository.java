package com.skilltracker.admin.repository;

import com.skilltracker.admin.entity.FullStackEngineers;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SkillTrackerAdminRepository extends CrudRepository<FullStackEngineers, String> {

    List<FullStackEngineers> findByNameContains(String name);

    List<FullStackEngineers> findByAssociateId(String associateId);

}