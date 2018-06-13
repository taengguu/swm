package com.ssm.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssm.dao.CollegeMapper;
import com.ssm.dao.StudentMapper;
import com.ssm.entity.College;
import com.ssm.entity.Student;
import com.ssm.service.StudentService;
import com.ssm.utils.copyPropertiesUtils;
import com.ssm.vo.StudentVo;

@Service
public class StudentServiceImpl implements StudentService{

	@Autowired
	private StudentMapper studentMapper;
	@Autowired
	private CollegeMapper collegeMapper;

	public void updateStudent(Student student) {
		this.studentMapper.updateByPrimaryKeySelective(student);
		
	}
	
	public void updateById(Integer userId,StudentVo studentVo){
		this.studentMapper.updateById(studentVo);
	}
	

	public List<StudentVo> findStudents() {
		// TODO Auto-generated method stub
		return this.studentMapper.selectAll();
	}

	public StudentVo findStudentById(Integer id) {
		// TODO Auto-generated method stub
		return this.studentMapper.selectByPrimaryKey(id);
	}

	public boolean saveSudent(Student student) {
		if(student!=null){
//			College college = collegeMapper.selectByPrimaryKey(studentVo.getCollegeid());
//			Student student = new Student();
//			copyPropertiesUtils.copyPropertiesInoreNull(studentVo, student);
			this.studentMapper.insertSelective(student);
			return true;
		}else{
			return false;
		}
		
		
	}

	public void deleteStudent(Integer id) {
		this.studentMapper.deleteByPrimaryKey(id);
		
	}
	
	public  List<StudentVo> findByName(String userName){
		
		return this.studentMapper.selectByName(userName);
	}


}
