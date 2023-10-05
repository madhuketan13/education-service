package com.dnb.educationservice.payload.request;

import lombok.Data;

@Data
public class EducationRequest {
	
	private String schoolName;
	private String degree;
	private String fieldOfStudy;
	private String startDate;
	private String endDate;
	private String description;
	private String profileId;

}
