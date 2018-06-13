package com.ssm.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssm.dao.TeacherMapper;
import com.ssm.entity.Teacher;
import com.ssm.service.TeacherService;
import com.ssm.vo.TeacherVo;

@Service
public class TeacherServiceImpl implements TeacherService{

	@Autowired
	private TeacherMapper teacherMapper;
	
	public List<TeacherVo> findTeachers() {
		return this.teacherMapper.selectAlls();
	}

	public boolean save(Teacher teacher) {
		if(this.teacherMapper.insertSelective(teacher)==1){
			return true;
		}else{
			return false;
		}
	}

	
	public List<TeacherVo> findByName(String userName) {
		return this.teacherMapper.selectByName(userName);
	}

	public Teacher findById(Integer userId) {
		return this.teacherMapper.selectByPrimaryKey(userId);
	}

	public int update(Teacher teacher) {
		return this.teacherMapper.updateByPrimaryKeySelective(teacher);
	}

	public int removeById(Integer userId) {
		return this.teacherMapper.deleteByPrimaryKey(userId);
		
	}
	
	

}
