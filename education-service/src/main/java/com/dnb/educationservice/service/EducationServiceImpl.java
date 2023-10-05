package com.dnb.educationservice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Profile;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.dnb.educationservice.dto.Education;
import com.dnb.educationservice.exceptions.IdNotFoundException;
import com.dnb.educationservice.repo.EducationRepository;

@Service
public class EducationServiceImpl implements EducationService {
	
	@Autowired
	EducationRepository educationRepository;
	
	@Autowired
	RestTemplate restTemplate;
	
	@Value("${api.profile}")
	private String URL;

	@Override
	public Education createEducation(Education education) throws IdNotFoundException {
		// TODO Auto-generated method stub
		try {
			System.out.println(education.getProfileId());
			ResponseEntity<?> responseEntity = restTemplate.getForEntity(URL+"/"+education.getProfileId(), com.dnb.educationservice.dto.Profile.class);
			return educationRepository.save(education);
		} catch (Exception e) {
			System.out.println(e.getMessage());
//			throw new IdNotFoundException("profileId Not Found");
		}
		return null;
	}

	@Override
	public List<Education> getEducationByProfileId(String profileId) {
		// TODO Auto-generated method stub
		return educationRepository.findByProfileId(profileId);
	}

}
