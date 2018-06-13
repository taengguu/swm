package com.ssm.vo;

import java.util.Date;

public class TeacherVo {
	  private Integer userId;

	    private String userName;

	    private String sex;

	    private Date birthYear;

	    private String degree;

	    private String title;

	    private Date grade;
	    private Integer collegeId;
	    
	    private String collegeName;

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

		public String getDegree() {
			return degree;
		}

		public void setDegree(String degree) {
			this.degree = degree;
		}

		public String getTitle() {
			return title;
		}

		public void setTitle(String title) {
			this.title = title;
		}

		public Date getGrade() {
			return grade;
		}

		public void setGrade(Date grade) {
			this.grade = grade;
		}

		public Integer getCollegeId() {
			return collegeId;
		}

		public void setCollegeId(Integer collegeId) {
			this.collegeId = collegeId;
		}

		public String getCollegeName() {
			return collegeName;
		}

		public void setCollegeName(String collegeName) {
			this.collegeName = collegeName;
		}

		@Override
		public String toString() {
			return "TeacherVo [userId=" + userId + ", userName=" + userName + ", sex=" + sex + ", birthYear="
					+ birthYear + ", degree=" + degree + ", title=" + title + ", grade=" + grade + ", collegeId="
					+ collegeId + ", collegeName=" + collegeName + ", getUserId()=" + getUserId() + ", getUserName()="
					+ getUserName() + ", getSex()=" + getSex() + ", getBirthYear()=" + getBirthYear() + ", getDegree()="
					+ getDegree() + ", getTitle()=" + getTitle() + ", getGrade()=" + getGrade() + ", getCollegeId()="
					+ getCollegeId() + ", getCollegeName()=" + getCollegeName() + ", getClass()=" + getClass()
					+ ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
		}
	    
	    
	    
}
