package com.skilltracker.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigInteger;

@Setter
@Getter
@Entity
@Table(name = "skill_expertise_non_technical")
public class SkillExpertiseNonTech {
    @Id
    @GeneratedValue( strategy= GenerationType.AUTO )
    @Column(name="skill_id")
    private BigInteger skillId;

    @Column(name="skill_name")
    private String skillName;

    @Column(name="expertise")
    private String expertise;

    @JsonBackReference
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id")
    private FullStackEngineers fullStackEngineers;
}
