package com.ssm.service;

import java.util.List;

import com.ssm.entity.Student;
import com.ssm.vo.StudentVo;

public interface StudentService {
	
	void updateStudent(Student student);
	
	void updateById(Integer userId,StudentVo studentVo);
	
	public List<StudentVo> findStudents();

	StudentVo findStudentById(Integer id);
	
	boolean saveSudent(Student student);
	
	void deleteStudent(Integer id);
	
	public List<StudentVo> findByName(String userName);
	
}
