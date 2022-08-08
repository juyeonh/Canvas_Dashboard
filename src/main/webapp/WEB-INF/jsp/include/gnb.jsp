<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:if test="${not empty userId && userType ne 'Administrator'}">
<div style="background-color: #354c65;height:100vh;">
	<div class="d-flex justify-content-center align-items-center flex-column">
		<a href="/board/board_view">
			<img src="/static/img/canvas.png" class="m-3" width="50px;">
		</a>
		<a href="#" class="block d-flex align-items-center flex-column p-2">
			<img src="/static/img/pfp.png" width="50px;">
			<small>Account</small>
		</a>
		<a href="/board/board_view" class="block d-flex align-items-center flex-column m-2">
			<img src="/static/img/dashboard.png" width="50px;">
			<small>Dashboard</small>
		</a>
		<a href="#" class="block d-flex align-items-center flex-column m-2">
			<img src="/static/img/calendar.png" width="50px;">
			<small>Calendar</small>
		</a>
		<a href="#" class="block d-flex align-items-center flex-column m-2">
			<img src="/static/img/message.png" width="50px;">
			<small>Message</small>
		</a>
	</div>
</div>
</c:if>

<c:if test="${userType eq 'Administrator'}">
<!-- reference: https://www.w3schools.com/howto/howto_js_collapse_sidebar.asp -->
<div id="sidebar" class="sidebar">
  <a href="javascript:void(0)" class="closebtn" onclick="closeNav()">×</a>
  <a href="/user/add_user_view">User</a>
  <a href="/course/add_course_view">Departments/Courses</a>
  <a href="#">Term Courses</a>
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

