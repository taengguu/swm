package com.ssm.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssm.dao.CollegeMapper;
import com.ssm.entity.College;
import com.ssm.service.CollegeService;

@Service
public class CollegeServiceImpl implements CollegeService{

	@Autowired
	private CollegeMapper collegeMapper;
	
	public List<College> findColleges() {
		// TODO Auto-generated method stub
		return collegeMapper.selectAll();
	}

	public College findByCollegeId(Integer id) {
		// TODO Auto-generated method stub
		return collegeMapper.selectByPrimaryKey(id);
	}

}
