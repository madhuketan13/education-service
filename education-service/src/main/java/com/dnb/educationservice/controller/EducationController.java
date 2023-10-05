package com.dnb.educationservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dnb.educationservice.dto.Education;
import com.dnb.educationservice.exceptions.IdNotFoundException;
import com.dnb.educationservice.payload.request.EducationRequest;
import com.dnb.educationservice.service.EducationService;
import com.dnb.educationservice.utils.EducationRequestToEntityMapper;

@RestController
@RequestMapping("/api/education")
public class EducationController {

	@Autowired
	EducationService educationService;
	
	@Autowired
	EducationRequestToEntityMapper mapper;

	@PostMapping("/create")
	public ResponseEntity<?> createEducation(@RequestBody EducationRequest education) throws IdNotFoundException {
		
		try {
			Education educationRequest = mapper.getEducationEntity(education);
			Education educationData = educationService.createEducation(educationRequest);
			return new ResponseEntity(educationData, HttpStatus.CREATED);
		}
		catch(Exception e){
			System.out.println(e.getMessage());
		}
		return null;

	}
	
	@GetMapping("/getEducation/{profileId}")
	public ResponseEntity<?> getEducationByProfileId(@PathVariable("profileId") String profileId) throws IdNotFoundException{
		List<Education> optional = educationService.getEducationByProfileId(profileId);
		if (optional.size() > 0) {

			return ResponseEntity.ok(optional);
		} else {

			throw new IdNotFoundException("profileId not found");
		}
		
	}

//	@GetMapping("/{profileId}")
//	public ResponseEntity<?> getProfile(@PathVariable("profileId") String profileId) throws IdNotFoundException {
//
//		Optional<Profile> optional = educationService.getProfile(profileId);
//		if (optional.isPresent()) {
//
//			return ResponseEntity.ok(optional.get());
//		} else {
//
//			throw new IdNotFoundException("ID not found");
//		}
//
//	}
//	
//	@DeleteMapping("/{profileId}")
//	public ResponseEntity<?> deleteProfile(@PathVariable("profileId") String profileId) throws IdNotFoundException{
//		if(profileService.existsById(profileId)) {
//			try
//			{
//				profileService.deleteProfile(profileId);
//				return ResponseEntity.ok("acc deleted");
//			} catch (IdNotFoundException e) {
//				// TODO Auto-generated catch block
//				throw new IdNotFoundException("Id not found");
//			}
//	}else {
//		throw new IdNotFoundException("Id not found");
//	}
//	}

}
