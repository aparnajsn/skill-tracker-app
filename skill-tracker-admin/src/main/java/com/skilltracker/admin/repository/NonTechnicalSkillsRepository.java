package com.skilltracker.admin.repository;

import com.skilltracker.admin.entity.SkillExpertiseNonTech;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;

@Repository
public interface NonTechnicalSkillsRepository extends CrudRepository<SkillExpertiseNonTech, BigInteger> {
}
