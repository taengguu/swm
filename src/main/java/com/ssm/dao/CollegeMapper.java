package com.ssm.dao;

import java.util.List;

import com.ssm.entity.College;

public interface CollegeMapper {
	
	
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table college
     *
     * @mbggenerated
     */
    int deleteByPrimaryKey(Integer collegeid);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table college
     *
     * @mbggenerated
     */
    int insert(College record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table college
     *
     * @mbggenerated
     */
    int insertSelective(College record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table college
     *
     * @mbggenerated
     */
    College selectByPrimaryKey(Integer collegeid);

    
    List<College> selectAll();
    
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table college
     *
     * @mbggenerated
     */
    int updateByPrimaryKeySelective(College record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table college
     *
     * @mbggenerated
     */
    int updateByPrimaryKey(College record);
}