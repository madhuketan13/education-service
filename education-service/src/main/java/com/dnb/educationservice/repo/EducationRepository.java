package com.dnb.educationservice.repo;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.dnb.educationservice.dto.Education;

@Repository
public interface EducationRepository extends CrudRepository<Education, String> {

	List<Education> findByProfileId(String profileId);
}
