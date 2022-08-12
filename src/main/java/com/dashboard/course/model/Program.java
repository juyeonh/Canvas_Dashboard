package com.dashboard.course.model;

import java.util.Date;

public class Program {
	private int id;
	private Integer stuUserId;	// Can be null
	private Integer instUserId;	// Can be null
	private int departmentId;	// Student => studying Major/Minor, Instructor => teaching department
	private String type;		// Student => Major/Minor, Instructor => X
	private Date createdAt;
	private Date updatedAt;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Integer getStuUserId() {
		return stuUserId;
	}
	public void setStuUserId(Integer stuUserId) {
		this.stuUserId = stuUserId;
	}
	public Integer getInstUserId() {
		return instUserId;
	}
	public void setInstUserId(Integer instUserId) {
		this.instUserId = instUserId;
	}
	public int getDepartmentId() {
		return departmentId;
	}
	public void setDepartmentId(int departmentId) {
		this.departmentId = departmentId;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public Date getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}
	public Date getUpdatedAt() {
		return updatedAt;
	}
	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}
}
