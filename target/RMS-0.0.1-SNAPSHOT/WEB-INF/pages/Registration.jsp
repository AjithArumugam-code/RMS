<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
			<form id="registration" class="stdform" method="post"
				action="<c:url value='/user/saveUser'/>">
				<h3>
					<B><font color="GREEN">REGISTRATION FORM</font></B>
				</h3>
				<input type="text" name="first_name" id="fname"
					placeholder="First Name" /> <input type="text" name="second_name"
					id="sname" placeholder="Second Name" /> <input type="text"
					name="user_id" id="user_id" placeholder="User Id" /> <input
					type="password" name="password" id="password"
					placeholder="Password" /> <input type="text" name="mobile"
					id="mobile" placeholder="Mobile" /> <input type="text"
					name="designation" id="designation" placeholder="Designation" />
				<textarea rows="4" cols="25" name="address" id="designation"
					placeholder="Address"></textarea>
				<input type="text" name="city" id="city" placeholder="City" /> <input
					type="text" name="state" id="state" placeholder="State" /> <select
					name="selectedRoles" id="selectedRoles">
					<option value="" disabled selected>Select your Roles</option>
					<c:forEach items="${registration.roles}" var="roles">
						<option value="${roles.oid}">${roles.role}</option>
					</c:forEach>
				</select>

				<button>REGISTER</button>
			</form>
		</div>
	</div>
</body>
</html>

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