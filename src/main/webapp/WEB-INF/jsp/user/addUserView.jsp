<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<div class="d-flex justify-content-center">
	<div class="sign-up-box">
		<h1 class="m-4">Add User</h1>
		<form id="addUserForm" method="post" action="/user/add_user">
			<span class="add-user-subject">Computing ID</span>
			<div class="d-flex m-3">
				<input type="text" name="loginId" class="form-control col-6" placeholder="ID를 입력해주세요">
				<!-- <button type="button" id="loginIdCheckBtn" class="btn btn-success ml-1">중복확인</button> -->
			</div>
			
			<%-- 아이디 체크 결과 --%>
			<!-- <div class="ml-3 mb-3">
				<div id="idCheckLength" class="small text-danger d-none">ID를 4자 이상 입력해주세요.</div>
				<div id="idCheckDuplicated" class="small text-danger d-none">이미 사용중인 ID입니다.</div>
				<div id="idCheckOk" class="small text-success d-none">사용 가능한 ID 입니다.</div>
			</div> -->
			
			<!-- <span class="add-user-subject">Password</span>
			<div class="m-3">
				<input type="password" name="password" class="form-control col-6" placeholder="비밀번호를 입력하세요">
			</div> 

			<span class="add-user-subject">Confirm password</span>
			<div class="m-3">
				<input type="password" name="confirmPassword" class="form-control col-6" placeholder="비밀번호를 입력하세요">
			</div>-->

			<span class="add-user-subject">Name</span>
			<div class="m-3">
				<input type="text" name="name" class="form-control col-6" placeholder="이름을 입력하세요">
			</div>

			<span class="add-user-subject">e-mail</span>
			<div class="m-3">
				<input type="text" name="email" class="form-control col-6" placeholder="이메일을 입력하세요">
			</div>
			
			<span class="add-user-subject">type</span>
			<div class="m-3 btn-group dropright">
				<button type="button" class="btn btn-secondary dropdown-toggle" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
					Dropright
				</button>
				<div class="dropdown-menu" aria-labelledby="dropdownMenuButton">
				  <span class="dropdown-item">Student</span>
				  <span class="dropdown-item">Instructor</span>
				  <span class="dropdown-item">Administrator</span>
				</div>
			</div>
			
			<br>
			<div class="d-flex justify-content-center m-3">
				<button type="submit" id="signUpBtn" class="btn btn-info">가입하기</button>
			</div>
		</form>
	</div>
</div>