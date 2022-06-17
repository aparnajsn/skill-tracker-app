package com.skilltracker.repository;

import com.skilltracker.entity.SkillExpertiseTech;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;

@Repository
public interface TechnicalSkillsRepository extends CrudRepository<SkillExpertiseTech, BigInteger> {
}
