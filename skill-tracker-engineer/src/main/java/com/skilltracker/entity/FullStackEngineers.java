package com.skilltracker.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Setter
@Getter
@Entity
@Table(name = "full_stack_engineers")
public class FullStackEngineers {

    @Id
    @Column(name = "unique_id")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    Integer id;

    @Column(name = "name")
    String name;

    @Column(name = "associate_id")
    String associateId;

    @Column(name = "email")
    String email;

    @Column(name = "mobile")
    String mobile;

    @Column(name = "created_date")
    Timestamp createdDate;

    @Column(name = "updated_date")
    Timestamp updatedDate;

    @JsonManagedReference
    @OneToMany(mappedBy = "fullStackEngineers")
    private List<SkillExpertiseTech> technicalSkills;

    @JsonManagedReference
    @OneToMany(mappedBy = "fullStackEngineers")
    private List<SkillExpertiseNonTech> nonTechnicalSkills;

}
