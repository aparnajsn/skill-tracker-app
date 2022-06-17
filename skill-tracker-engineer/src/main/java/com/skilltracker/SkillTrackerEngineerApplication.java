package com.skilltracker;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@Slf4j
@SpringBootApplication
public class SkillTrackerEngineerApplication {

	public static void main(String[] args) {
		log.info("*********** Starting SkillTrackerEngineerApplication.... ***********");
		SpringApplication.run(SkillTrackerEngineerApplication.class, args);
		log.info("*********** Started SkillTrackerEngineerApplication ***********");
	}

}
