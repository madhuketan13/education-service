package com.dnb.educationservice.service;

import java.util.List;

import com.dnb.educationservice.dto.Education;
import com.dnb.educationservice.exceptions.IdNotFoundException;

public interface EducationService {
	
	public Education createEducation(Education education) throws IdNotFoundException;
	
	public List<Education> getEducationByProfileId(String profileId);

}
