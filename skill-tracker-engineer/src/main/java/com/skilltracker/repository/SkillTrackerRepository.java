package com.skilltracker.repository;


import com.skilltracker.entity.FullStackEngineers;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SkillTrackerRepository extends CrudRepository<FullStackEngineers, Integer> {

    Optional<FullStackEngineers> findById(Integer userId);
}