package com.ssm.service;

import java.util.List;

import com.ssm.entity.Course;

public interface CourseService {
	
	public Course findById(Integer courseId);
	
	public List<Course> findByName(String courseName);
	
	public List<Course> findCourses();
	
	public int save(Course course);
	
	public int update(Course course);
	public int removeById(Integer id);

}
