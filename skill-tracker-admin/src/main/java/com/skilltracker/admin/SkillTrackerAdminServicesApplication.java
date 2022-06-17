package com.skilltracker.admin;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@EnableCaching
@SpringBootApplication
@Slf4j
public class SkillTrackerAdminServicesApplication {

	public static void main(String[] args) {
		log.info("******** Before Starting Admin Application ****************** ");
		SpringApplication.run(SkillTrackerAdminServicesApplication.class, args);
		log.info("******** After Starting Admin Application ******************** ");
	}

}
