<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    
<h1 class="m-3">New Term Course</h1>

<div class="d-flex justify-content-center mb-5">
	<div class="dep-box mt-3">
		<a data-toggle="collapse" href="#collapseTermCourse" role="button" aria-expanded="true" aria-controls="collapseTermCourse">
		    <strong style="color:blue; font-size: x-large;">· New Term Course</strong>
		</a>
		<div class="collapse show" id="collapseTermCourse">
		  <div class="card card-body">
		  	<form id="termCourseForm" method="post" action="/course/add_term_course">
		  	<div class="d-flex align-items-center mt-1">
			  	<span class="col-4" style="font-weight:bold;">Course</span>
			  	<div class="col-7" style="padding:0;">
			  		<select name="courseId" id="courseId" class="form-control">
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
		    
		    <div class="d-flex align-items-center mt-1">
			  	<span class="col-4" style="font-weight:bold;">Instructor</span>
			  	<div class="col-7" style="padding:0;" id="instId">
			  		<select name="instructorId" id="instructorId" class="form-control">
					    <option value="">Select Instructor</option>
					    
					    <%-- <c:forEach var="inst" items="${instList}">
					    	<option value="${inst.id}">${inst.name}</option>
					    </c:forEach> --%>
					    
					    <%-- <c:forEach var="dv" items="${depViewList}">
						    <optgroup label="${dv.dep.name}">
							    <c:forEach var="inst" items="${dv.instructorList}">
							    	<option value="${inst.id}">${inst.name}</option>
							    </c:forEach>
						    </optgroup>
					    </c:forEach> --%>
				    </select>
			    </div>
		    </div>
		    
		    <div class="d-flex align-items-center mt-1">
			  	<span class="col-4" style="font-weight:bold;">Term</span>
			  	<div class="col-7" style="padding:0;">
			  		<select name="term" class="form-control">
					    <option selected>Fall 2022</option>
					    <option>Spring 2023</option>
					    <option>Summer 2023</option>
				    </select>
			    </div>
		    </div>
		    
		    <div class="d-flex align-items-center mt-1">
				<span class="col-4" style="font-weight:bold;">Capacity</span>
				<input type="text" name="capacity" class="form-control col-3" onkeyPress="javascript:checkInputNum();" placeholder="Capacity">
			</div>
			
			<div class="d-flex align-items-center mt-1">
			  	<span class="col-4" style="font-weight:bold;">Room</span>
			  	<div class="col-7" style="padding:0;">
			  		<select name="room" class="form-control">
					    <option>3001</option>
					    <option>3002</option>
					    <option>3003</option>
				    </select>
			    </div>
		    </div>
		    
		    <div class="d-flex align-items-center mt-1">
				<span class="col-4" style="font-weight:bold;">Units</span>
				<input type="text" name="units" onkeyPress="javascript:checkInputNum();" class="form-control col-3" placeholder="# of units">
			</div>
			
			<div class="d-flex align-items-center mt-1">
			  	<span class="col-4" style="font-weight:bold;">Status</span>
			  	<div class="col-7" style="padding:0;">
			  		<select name="status" class="form-control">
					    <option selected>Open</option>
					    <option>Not opened</option>
				    </select>
			    </div>
		    </div>
		    
		    <br><div class="d-flex justify-content-center">
				<button type="submit" class="btn btn-info">Save</button>
			</div>
		  </form>
		  </div>
		</div>
	</div>
</div>

<script>
function checkInputNum(){	// regex: onKeyup="this.value=this.value.replace(/[^0-9]/g,'');"
    if ((event.keyCode < 48) || (event.keyCode > 57)){
        event.returnValue = false;
    }
}

$(document).ready(function(){
	$('select').selectize({
        sortField: 'text'
    });
	
	$('#courseId').on('change', function(){
    	var courseId = $(this).val(); 
    	
    	$.ajax({
			// request
			type: "POST"
			,url: "/course/get_instructors"
			,data: {"courseId":courseId}
			
			// response
			,success: function(data){
				if(data.result == "success"){
					var instList = data.data;		// instructorList
					var select = document.getElementById('instructorId');
					
					for(var i = 0; i < instList.length; i++){
						/* var opt = document.createElement('option');
				    	opt.value = instList[i].id;
					    opt.innerHTML = instList[i].name;
					    select.appendChild(opt); */
						
					    //$('#instId .selectize-control .selectize-input .selectize-dropdown .selectize-dropdown-content').append("<option value='"+ instList[i].id +"'>" + instList[i].name + "</option>");
					    //$('#instId').find(".selectize-control").find('.selectize-dropdown').find('.selectize-dropdown-content').append("<option value='"+ instList[i].id +"'>" + instList[i].name + "</option>");
					    //$('#instructorId').selectize.addOption({value:13,text:'foo'});
					    //$('#instructorId').selectize.refreshOptions();
					    
					    
					    /* var opt = document.createElement("option"); // 요소 생성
						opt.innerText = instList[i].name; // 옵션 이름 지정
						opt.value = instList[i].id; // 옵션 value 지정
						select.appendChild(opt); */
						
						if($('#instructorId').selectize) {
							$('#instructorId').selectize.addOption({value:1, text: '1'});
					    }
					}
					
					/* for(var i = 0; i < instList.length; i++){
						var opt = document.createElement("option");
					    opt.text = instList[i].name;
					    opt.value = instList[i].id;
					    select.options.add(opt);
					} */
				    
					/* let select = document.querySelector("instructorId");
				    $(select).append("<option value='"+ instList[i].id +"'>" + instList[i].name + "</option>"); */
				} else{
					alert("Getting instructor information failed. Please retry again.");
				}
			}
			,error: function(e){
				alert("Error: " + e);
			}
		});
    });
	
	
	/* $("input[name=date]").datepicker({
        dayNamesMin:["Sun","Mon","Tue","Wed","Thu","Fri","Sat"],
        dateFormat: "mm-dd-yyyy",
       	minDate:0
    }); */
	
	
	
	$('#termCourseForm').on('submit',function(e){
		e.preventDefault();
		
		let courseId = $('select[name=courseId]').val();
		if (courseId == "") {
			alert("Select the course.");
			return false;
		}
		
		let instructorId = $('select[name=instructorId]').val();
		if (instructorId == "") {
			alert("Select the instructor.");
			return false;
		}
		
		let capacity = $('input[name=capacity]').val();
		if (capacity == "") {
			alert("Enter the capacity.");
			return false;
		}
		
		let room = $('select[name=room]').val();
		if (room == "") {
			alert("Select the room.");
			return false;
		}
		
		let units = $('input[name=units]').val();
		if (units == "") {
			alert("Enter the units.");
			return false;
		}
		
		// send to server
		let url = $(this).attr("action");
		let params = $(this).serialize();
		
		$.post(url, params)
		.done(function(data) {
			if (data.result == "success") {
				alert("Term course successfully added.");
				location.reload();
			} else {
				alert("Adding term course failed. Please try it again.");
			}
		});
	});
});
</script>