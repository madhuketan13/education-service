package com.dnb.educationservice.utils;

import org.springframework.stereotype.Component;

import com.dnb.educationservice.dto.Education;
import com.dnb.educationservice.payload.request.EducationRequest;

@Component
public class EducationRequestToEntityMapper {
	
	public Education getEducationEntity(EducationRequest educationRequest) {
		
		Education education = new Education();
		education.setSchoolName(educationRequest.getSchoolName());
		education.setStartDate(educationRequest.getStartDate());
		education.setEndDate(educationRequest.getEndDate());
		education.setDegree(educationRequest.getDegree());
		education.setFieldOfStudy(educationRequest.getFieldOfStudy());
		education.setProfileId(educationRequest.getProfileId());
		education.setDescription(educationRequest.getDescription());
		
		return education;
	}

}
