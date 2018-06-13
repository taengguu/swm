package com.ssm.dao;

import java.util.List;

import com.ssm.entity.Teacher;
import com.ssm.vo.TeacherVo;

public interface TeacherMapper {

	/**
	 * 删除操作
	 * @param userid 教师id
	 * @return 
	 */
    int deleteByPrimaryKey(Integer userid);


    /**
     * 插入操作 
     * @param record 教师
     * @return
     */
    int insert(Teacher record);

    /**
     * 插入操作(插入值为空则跳过该列)
     * @param record 教师
     * @return
     */
    int insertSelective(Teacher record);

    /**
     * 通过教师id查找教师
     * @param userid 教师id
     * @return
     */
    Teacher selectByPrimaryKey(Integer userid);
    /**
     * 查找所有教师
     * @return
     */
    List<TeacherVo> selectAlls();
    /**
     * 通过教师名称查找
     * @param userName 教师名称
     * @return
     */
    List<TeacherVo> selectByName(String userName);

    /**
     * 选择性更新操作(空值则跳过该列)
     * @param record
     * @return
     */
    int updateByPrimaryKeySelective(Teacher record);


    /**
     * 更新操作
     * @param record
     * @return
     */
    int updateByPrimaryKey(Teacher record);
}