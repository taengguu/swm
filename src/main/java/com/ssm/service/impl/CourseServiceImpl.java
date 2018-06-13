package com.ssm.service.impl;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssm.dao.CourseMapper;
import com.ssm.entity.Course;
import com.ssm.service.CourseService;

@Service
public class CourseServiceImpl implements CourseService{

	@Autowired
	private CourseMapper courseMapper;
	public List<Course> findCourses() {
		return this.courseMapper.selectAll();
	}
	public int save(Course course) {
		// TODO Auto-generated method stub
		return this.courseMapper.insertSelective(course);
	}
	public Course findById(Integer courseId) {
		
		return this.courseMapper.selectByPrimaryKey(courseId);
	}
	public int update(Course course) {
		return this.courseMapper.updateByPrimaryKeySelective(course);
		
	}
	public int removeById(Integer id) {
		// TODO Auto-generated method stub
		return this.courseMapper.deleteByPrimaryKey(id);
	}
	public List<Course> findByName(String courseName) {
		// TODO Auto-generated method stub
		return this.courseMapper.selectByName(courseName);
	}

}
