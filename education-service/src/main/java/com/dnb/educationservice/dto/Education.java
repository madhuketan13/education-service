package com.dnb.educationservice.dto;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import com.dnb.educationservice.utils.CustomEducationIdGenerator;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class Education {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "education_seq")
	@GenericGenerator(name = "education_seq", strategy = "com.dnb.educationservice.utils.CustomEducationIdGenerator",
	parameters = {@Parameter(name = CustomEducationIdGenerator.INCREMENT_PARAM, value = "50"),
	@Parameter(name = CustomEducationIdGenerator.VALUE_PREFIX_PARAMETER, value = "edu_"),
	@Parameter(name = CustomEducationIdGenerator.NUMBER_FORMAT_PARAMETER, value = "%05d")})
	private String educationId;
	private String schoolName;
	private String startDate;
	private String endDate;
	private boolean currentSchool = false;
	private String degree;
	private String fieldOfStudy;
	private String description;
	private String profileId;

}
