package com.dashboard.course.model;

import java.util.List;

public class CourseView {
	private Department dep;
	private List<Course> courseList;
	
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
}
