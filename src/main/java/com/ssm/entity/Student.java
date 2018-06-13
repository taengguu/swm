package com.ssm.entity;

import java.util.Date;

public class Student {
   
    private Integer userId;

 
    private String userName;

   
    private String sex;

   
    private Date birthYear;

    private Date grade;

   
    private String collegeId;


	public Integer getUserId() {
		return userId;
	}


	public void setUserId(Integer userId) {
		this.userId = userId;
	}



	public String getUserName() {
		return userName;
	}


	public void setUserName(String userName) {
		this.userName = userName;
	}


	public String getSex() {
		return sex;
	}


	public void setSex(String sex) {
		this.sex = sex;
	}




	public Date getBirthYear() {
		return birthYear;
	}


	public void setBirthYear(Date birthYear) {
		this.birthYear = birthYear;
	}


	public Date getGrade() {
		return grade;
	}


	public void setGrade(Date grade) {
		this.grade = grade;
	}


	public String getCollegeId() {
		return collegeId;
	}


	public void setCollegeId(String collegeId) {
		this.collegeId = collegeId;
	}




}