package com.skilltracker.repository;

import com.skilltracker.entity.SkillExpertiseNonTech;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;

@Repository
public interface NonTechnicalSkillsRepository extends CrudRepository<SkillExpertiseNonTech, BigInteger> {
}
