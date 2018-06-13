package com.ssm.service;

import java.util.List;

import com.ssm.entity.Teacher;
import com.ssm.vo.TeacherVo;

public interface TeacherService {
	
	
	/**
	 * 查找所有教师
	 * @return
	 */
	public List<TeacherVo> findTeachers();
	
	/**
	 * 插入新的教师信息
	 * @param teacher
	 * @return
	 */
	boolean save(Teacher teacher);
	
	/**
	 * 通过名字查找教师
	 * @param userName 教师名字
	 * @return
	 */
	List<TeacherVo> findByName(String userName);
	
	/**
	 * 通过id查找教师
	 * @param userId 教师id
	 * @return
	 */
	public Teacher findById(Integer userId);
	/**
	 * 更新
	 * @param teacher
	 * @return
	 */
	public int update(Teacher teacher);
	/**
	 * 删除教师
	 * @param userId
	 * @return
	 */
	public int removeById(Integer userId);
	

}
