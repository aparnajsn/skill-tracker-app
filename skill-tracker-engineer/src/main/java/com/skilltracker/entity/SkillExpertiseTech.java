package com.skilltracker.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigInteger;
import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
@Setter
@Getter
@Table(name = "skill_expertise_technical")
public class SkillExpertiseTech {
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
