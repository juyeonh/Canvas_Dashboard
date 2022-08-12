<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    
<h1 class="m-3">New Department / New Course / Add Requirements</h1>

<div class="d-flex justify-content-center mb-5">
	<div class="dep-box mt-3">
		<!-- Add new department -->
		<a data-toggle="collapse" href="#collapseDepartment" role="button" aria-expanded="true" aria-controls="collapseDepartment">
		    <strong style="color:blue; font-size: x-large;">· New Department</strong>
		</a>
		<div class="collapse show" id="collapseDepartment">
		  <div class="card card-body">
		  <form id="departmentForm" method="post" action="/course/add_department">
		    <div class="d-flex align-items-center">
				<span class="col-4" style="font-weight:bold;">Department Name</span>
				<input type="text" name="department" class="form-control col-7" placeholder="Department">
			</div>
			<br><div class="d-flex justify-content-center">
				<button type="submit" id="saveDepBtn" class="btn btn-info">Save</button>
			</div>
		  </form>
		  </div>
		</div><br>
		
		<!-- Add new course & its department-->
		<a data-toggle="collapse" href="#collapseCourse" role="button" aria-expanded="true" aria-controls="collapseCourse">
		    <strong style="color:blue; font-size: x-large;">· New Course</strong>
		</a>
		<div class="collapse show" id="collapseCourse">
		  <div class="card card-body">
		  <form id="courseForm" method="post" action="/course/add_course">
			<div class="d-flex align-items-center">
				<span class="col-4" style="font-weight:bold;">Department</span>
				<div class="col-7" style="padding:0;">
					<select name="departmentId" class="form-control">
					    <option value="">Select a department</option>
					    <c:forEach var="dv" items="${depViewList}">
					    	<option value="${dv.dep.id}">${dv.dep.name}</option>
					    </c:forEach>
				    </select>
			    </div>
			</div>
			
		    <div class="d-flex align-items-center mt-1">
				<span class="col-4" style="font-weight:bold;">Course Name</span>
				<input type="text" name="course" class="form-control col-7" placeholder="course">
			</div>
			<br><div class="d-flex justify-content-center">
				<button type="submit" id="saveCourseBtn" class="btn btn-info">Save</button>
			</div>
		  </form>
		  </div>
		</div><br>
		
		<!-- Add Requirements for each course -->
		<a data-toggle="collapse" href="#collapseRequirements" role="button" aria-expanded="true" aria-controls="collapseRequirements">
		    <strong style="color:blue; font-size: x-large;">· Add Prerequisites</strong>
		</a>
		<div class="collapse show" id="collapseRequirements">
		  <div class="card card-body">
		  	<form id="prereqForm" method="post" action="/course/add_prerequisite">
		  	<div class="d-flex align-items-center mt-1">
			  	<span class="col-4" style="font-weight:bold;">Course</span>
			  	<div class="col-7" style="padding:0;">
			  		<select name="courseId" class="form-control">
					    <option value="">Select a course</option>
					    <c:forEach var="dv" items="${depViewList}">
						    <optgroup label="${dv.dep.name}">
							    <c:forEach var="course" items="${dv.courseList}">
							    	<option value="${course.id}">${course.name}</option>
							    </c:forEach>
						    </optgroup>
					    </c:forEach>
				    </select>
			    </div>
		    </div>
		    <div class="d-flex align-items-center mt-2">
			  	<span class="col-4" style="font-weight:bold;">Prerequisite Course</span>
			  	<div class="col-7" style="padding:0;">
				  	<select name="reqCourseId" class="form-control">
					    <option value="">Select a course</option>
					    <c:forEach var="dv" items="${depViewList}">
						    <optgroup label="${dv.dep.name}">
							    <c:forEach var="course" items="${dv.courseList}">
							    	<option value="${course.id}">${course.name}</option>
							    </c:forEach>
						    </optgroup>
					    </c:forEach>
				    </select>
			    </div>
		    </div>
		    
		    <br><div class="d-flex justify-content-center">
				<button type="submit" id="saveCourseBtn" class="btn btn-info">Save</button>
			</div>
		  </form>
		  </div>
		</div>
	</div>
</div>

<script>
$(document).ready(function(){
	$('select').selectize({
        sortField: 'text'
    });
	
	$('#departmentForm').on('submit',function(e){
		e.preventDefault();
		
		let department = $('input[name=department]').val().trim();
		if (department == "") {
			alert("Enter the department.");
			return false;
		}
		
		// send to server
		let url = $(this).attr("action"); 	// get the 'action' location
		let params = $(this).serialize(); 	// get all the name tags
		
		$.post(url, params)
		.done(function(data) {
			if (data.result == "success") {
				alert("Department successfully added.");
				location.reload();
			} else {
				alert("Adding department failed. Please try it again.");
			}
		});
	});
	
	$('#courseForm').on('submit',function(e){
		e.preventDefault();
		
		let course = $('input[name=course]').val().trim();
		if (course == "") {
			alert("Enter the course.");
			return false;
		}
		
		let departmentId = $('select[name=departmentId]').val();
		if (departmentId == "") {
			alert("Select the department.");
			return false;
		}
		
		// send to server
		let url = $(this).attr("action");
		let params = $(this).serialize();
		
		$.post(url, params)
		.done(function(data) {
			if (data.result == "success") {
				alert("Course successfully added.");
				location.reload();
			} else if(data.result == "duplicate"){
				alert("The course already exists.");
			} else {
				alert("Adding course failed. Please try it again.");
			}
		});
	});
	
	$('#prereqForm').on('submit',function(e){
		e.preventDefault();
		
		let courseId = $('select[name=courseId]').val();
		if (courseId == "") {
			alert("Select the course.");
			return false;
		}
		
		let reqCourseId = $('select[name=reqCourseId]').val();
		if (reqCourseId == "") {
			alert("Select the prerequisite course.");
			return false;
		}
		
		// send to server
		let url = $(this).attr("action");
		let params = $(this).serialize();
		
		$.post(url, params)
		.done(function(data) {
			if (data.result == "success") {
				alert("Prerequisite successfully added.");
				location.reload();
			} else {
				alert("Adding prerequisite failed. Please try it again.");
			}
		});
	});
});
</script>