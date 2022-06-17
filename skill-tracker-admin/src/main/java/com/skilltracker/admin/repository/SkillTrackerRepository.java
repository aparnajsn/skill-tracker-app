package com.skilltracker.admin.repository;


import com.skilltracker.admin.entity.FullStackEngineers;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SkillTrackerRepository extends CrudRepository<FullStackEngineers, Integer> {

}