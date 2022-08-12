package com.dashboard.course.model;

import java.util.List;

import com.dashboard.user.model.User;

public class DepartmentView {	
	// 과 & 과 안의 모든 과목들 & 과를 가르치는 교수들 
	// department & all the courses in that dep & all the instructors who teach in that dep
	private Department dep;
	private List<Course> courseList;
	private List<User> instructorList;
	
	public Department getDep() {
		return dep;
	}
	public void setDep(Department dep) {
		this.dep = dep;
	}
	public List<Course> getCourseList() {
		return courseList;
	}
	public void setCourseList(List<Course> courseList) {
		this.courseList = courseList;
	}
	public List<User> getInstructorList() {
		return instructorList;
	}
	public void setInstructorList(List<User> instructorList) {
		this.instructorList = instructorList;
	}
}
