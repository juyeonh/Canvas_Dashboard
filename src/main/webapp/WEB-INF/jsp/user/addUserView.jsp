<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<h1 class="m-3">User</h1>

<div class="d-flex justify-content-center">
	<div class="dep-box mt-3">
		<!-- Register new user -->
		<a data-toggle="collapse" href="#collapseUserReg" role="button" aria-expanded="false" aria-controls="collapseExample">
		    <strong style="color:blue; font-size: x-large;">· User Registration</strong>
		</a>
		<div class="collapse" id="collapseUserReg">
		  <div class="card card-body">
		  <form id="userRegForm" method="post" action="/user/register_user">
		    <div class="d-flex m-1 align-items-center">
				<span class="user-reg-subject col-4">Computing ID</span>
				<input type="text" name="computingId" class="form-control col-7" placeholder="Computing ID">
				<!-- <button type="button" id="computingIdCheckBtn" class="btn btn-success ml-1">중복확인</button> -->
			</div>
			<%-- 아이디 체크 결과 --%>
			<!-- <div class="ml-3 mb-3">
				<div id="idCheckLength" class="small text-danger d-none">ID를 4자 이상 입력해주세요.</div>
				<div id="idCheckDuplicated" class="small text-danger d-none">이미 사용중인 ID입니다.</div>
				<div id="idCheckOk" class="small text-success d-none">사용 가능한 ID 입니다.</div>
			</div> -->
			
			<div class="d-flex m-1 align-items-center">
				<span class="user-reg-subject col-4">Name</span>
				<input type="text" name="name" class="form-control col-7" placeholder="Name">
			</div>
			
			<div class="d-flex m-1 align-items-center">
				<span class="user-reg-subject col-4">e-mail</span>
				<input type="text" name="email" class="form-control col-7" placeholder="SFU email">
			</div>
			
			<div class="d-flex m-1 align-items-center">
				<span class="user-reg-subject col-4">type</span>
				<select class="form-control col-3" name="type" id="exampleFormControlSelect1">
			      <option selected>Student</option>
			      <option>Instructor</option>
			      <option>Administrator</option>
			    </select>
			</div>
			
			<br><div class="d-flex justify-content-center m-1">
				<button type="submit" id="registerBtn" class="btn btn-info">Register</button>
			</div>
			</form>
		  </div>
		</div><br>
		
	</div>
</div>

<script>
$(document).ready(function(){
	$('#userRegForm').on('submit',function(e){
		e.preventDefault();
		let computingId = $('input[name=computingId]').val().trim();
		if (computingId == "") {
			alert("Enter the computing id.");
			return false;
		}
		
		let name = $('input[name=name]').val().trim();
		if (name == "") {
			alert("Enter the name.");
			return false;
		}
		
		let email = $('input[name=email]').val().trim();
		if (email == "") {
			alert("Enter the email.");
			return false;
		}
		
		// send to server
		let url = $(this).attr("action"); 	// get the 'action' location
		let params = $(this).serialize(); 	// get all the name tags
		
		$.post(url, params)
		.done(function(data) {
			if (data.result == "success") {
				alert("User successfully added.");
				location.reload();
			} else {
				alert("User registration failed. Please try it again.");
			}
		});
	});
});
</script>