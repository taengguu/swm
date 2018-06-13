package com.ssm.service;

import java.util.List;

import com.ssm.entity.College;

public interface CollegeService {
	
	List<College> findColleges();
	
	College findByCollegeId(Integer id);

}
