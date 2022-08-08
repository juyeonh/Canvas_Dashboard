<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:if test="${not empty userId && userType ne 'Administrator'}">
<div style="width:98px;background-color: #354c65;height:100vh;">

	<div class="d-flex justify-content-center align-items-center flex-column">
		<a href="/board/board_view" class="m-4">
			<img src="/static/img/canvas.png" width="50px;">
		</a>
		<a href="#" onclick="openNav()" id="account" class="w-100 nav-btn block d-flex align-items-center flex-column pt-2" style="height:90px;">
			<img src="/static/img/pfp.png" width="50px;">
			<small>Account</small>
		</a>
		<a href="/board/board_view" class="dashboard w-100 nav-btn block d-flex align-items-center flex-column pt-1" style="height:90px;">
			<img src="/static/img/dashboard.png" width="50px;">
			<small>Dashboard</small>
		</a>
		<a href="#" id="calendar" class="w-100 nav-btn block d-flex align-items-center flex-column pt-2" style="height:90px;">
			<img src="/static/img/calendar.png" width="50px;">
			<small>Calendar</small>
		</a>
		<a href="#" id="message" class="w-100 nav-btn block d-flex align-items-center flex-column pt-2" style="height:90px;">
			<img src="/static/img/message.png" width="50px;">
			<small>Message</small>
		</a>
	</div>
	
	<div id="sidebar" class="sidebar">
	  <a href="javascript:void(0)" class="closebtn" onclick="closeNav()">×</a>
	  <a href="#">Edit Profile</a>
	  <a href="#">Enrollment</a>
	  <div class="w-100 text-center">
	  	<button class="btn btn-dark m-5" onclick = "location.href='/user/sign_out'">Sign Out</button>
	  </div>
	</div>
</div>

<script>
function openNav() {
  document.getElementById("sidebar").style.width = "350px";
  document.getElementById("sidebar").style.marginLeft = "98px";
}

function closeNav() {
  document.getElementById("sidebar").style.width = "0";
}
</script>
</c:if>

<c:if test="${userType eq 'Administrator'}">
<!-- reference: https://www.w3schools.com/howto/howto_js_collapse_sidebar.asp -->
<div id="sidebar" class="sidebar">
  <a href="javascript:void(0)" class="closebtn" onclick="closeNav()">×</a>
  <a href="/user/add_user_view">User</a>
  <a href="/course/add_course_view">Departments/Courses</a>
  <a href="#">Term Courses</a>
  <div class="w-100 text-center">
  	<button class="btn btn-dark m-5" onclick = "location.href='/user/sign_out'">Sign Out</button>
  </div>
</div>

<div id="main">
	<button class="openbtn" onclick="openNav()">☰</button>
</div>

<script>
function openNav() {
  document.getElementById("sidebar").style.width = "350px";
  document.getElementById("main").style.marginLeft = "350px";
}

function closeNav() {
  document.getElementById("sidebar").style.width = "0";
  document.getElementById("main").style.marginLeft= "0";
}
</script>
</c:if>

