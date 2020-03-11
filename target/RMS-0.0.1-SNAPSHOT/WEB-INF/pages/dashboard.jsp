<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<%
	response.setHeader("Cache-Control", "no-cache");
	response.setHeader("Cache-Control", "no-store");
	response.setHeader("Pragma", "no-cache");
	response.setDateHeader("Expires", 0);
%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Resource Registration</title>
</head>
<body>

	<div class="first">
		<div class="form">
			<form id="ResourceRegistration" method="post"
				action="<c:url value='/saveResource'/>">

				<h3>
					<B><font color="GREEN">REGISTRATION FORM</font><a></a></B>
				</h3>
				<input type="text" name="firstName" placeholder="First Name"
					form="ResourceRegistration" /> <input type="text"
					name="secondName" id="sname" placeholder="Second Name"
					form="ResourceRegistration" /> <input type="text" name="mobile"
					id="mobile" placeholder="Mobile" form="ResourceRegistration" /> <input
					type="text" name="designation" id="designation"
					placeholder="Designation" form="ResourceRegistration" />
				<textarea rows="4" cols="25" name="address" id="designation"
					placeholder="Address" form="ResourceRegistration"></textarea>
				<select name="currentStatus" id="current_status"
					form="ResourceRegistration">
					<option value="" disabled selected>Select your status</option>
					<option value="Employee">Employed</option>
					<option value="Job seekers">Job Seeking</option>
				</select> <input type="text" name="currentCompany" id="current_company"
					form="ResourceRegistration" placeholder="Current Company" /> <select
					name="selectedUser" id="selectedUser">
					<option value="" disabled selected>Resource Owner</option>
					<c:forEach items="${ResourceRegistration.user}" var="user">
						<option value="${user.oid}">${user.first_name}</option>
					</c:forEach>
				</select> <input type="file" id="resume" name="resume">
				<button>REGISTER</button>
		</div>

	</div>



	<script>
		function onSubmit() {
			ResourceRegistration.submit();
		}
	</script>

	<style>
.first {
	width: 800px;
	padding: 2% 0 0;
	margin: auto;
}

.form {
	position: relative;
	z-index: 1;
	background: #FFFFFF;
	max-width: 360px;
	margin: 0 auto 50px;
	padding: 10px 25px 10px 25px;
	text-align: center;
	box-shadow: 0 0 20px 0 rgba(0, 0, 0, 0.2), 0 5px 5px 0
		rgba(0, 0, 0, 0.24);
}

.form input, textarea, select {
	font-family: "Roboto", sans-serif;
	outline: 0;
	background: #f2f2f2;
	width: 100%;
	border: 0;
	margin: 0 0 15px;
	padding: 15px;
	box-sizing: border-box;
	font-size: 14px;
}

.form button {
	font-family: "Roboto", sans-serif;
	text-transform: uppercase;
	outline: 0;
	background: #4CAF50;
	width: 100%;
	border: 0;
	padding: 15px;
	color: #FFFFFF;
	font-size: 14px;
	transition: all 0.3 ease;
	cursor: pointer;
}

.form button:hover, .form button:active, .form button:focus {
	background: #43A047;
}

.form .message {
	margin: 15px 0 0;
	color: #b3b3b3;
	font-size: 12px;
}

.form .message a {
	color: #4CAF50;
	text-decoration: none;
}
</style>


</body>
</html>
