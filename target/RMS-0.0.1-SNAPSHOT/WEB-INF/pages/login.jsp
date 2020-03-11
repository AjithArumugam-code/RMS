<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<%
	response.setHeader("Cache-Control", "no-cache");
	response.setHeader("Cache-Control", "no-store");
	response.setHeader("Pragma", "no-cache");
	response.setDateHeader("Expires", 0);
%>


<div class="loginwrapperinner">
	<c:if test="${not empty error}">
		<div class="alert alert-error">
			<strong>Your login attempt was not successful!</strong> <br />
			Caused :${sessionScope["SPRING_SECURITY_LAST_EXCEPTION"].message}.
		</div>
	</c:if>
	<div class="login-page">
		<div class="form">
			<form class="login-form"
				action="<c:url value='j_spring_security_check' />" method="post">
				<input type="text" id="j_username" name="j_username"
					placeholder="Username" /> <input type="password" id="j_password"
					name="j_password" placeholder="password" />
				<button>login</button>
				<p class="message">
					<a href="<c:url value='/user/showRegistration' />">Register New
						User</a>
				</p>
			</form>
		</div>
	</div>
</div>
<!--loginwrapperinner-->

<style>
.login-page {
	width: 360px;
	padding: 8% 0 0;
	margin: auto;
}

.form {
	position: relative;
	z-index: 1;
	background: #FFFFFF;
	max-width: 360px;
	margin: 0 auto 100px;
	padding: 45px;
	text-align: center;
	box-shadow: 0 0 20px 0 rgba(0, 0, 0, 0.2), 0 5px 5px 0
		rgba(0, 0, 0, 0.24);
}

.form input {
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
<!--loginwrapper-->

<!-- <script type="text/javascript">
jQuery.noConflict();

jQuery(document).ready(function(){
	
	var anievent = (jQuery.browser.webkit)? 'webkitAnimationEnd' : 'animationend';
	jQuery('.loginwrap').bind(anievent,function(){
		jQuery(this).removeClass('animate2 bounceInDown');
	});
	
	jQuery('#j_username,#j_password').focus(function(){
		if(jQuery(this).hasClass('error')) jQuery(this).removeClass('error');
	});
	
	jQuery('#loginform button').click(function(){
		if(!jQuery.browser.msie) {
			if(jQuery('#j_username').val() == '' || jQuery('#j_password').val() == '') {
				if(jQuery('#j_username').val() == '') jQuery('#j_username').addClass('error'); else jQuery('#j_username').removeClass('error');
				if(jQuery('#j_password').val() == '') jQuery('#j_password').addClass('error'); else jQuery('#j_password').removeClass('error');
				jQuery('.loginwrap').addClass('animate0 wobble').bind(anievent,function(){
					jQuery(this).removeClass('animate0 wobble');
				});
			} else {
				jQuery('.loginwrapper').addClass('animate0 fadeOutUp').bind(anievent,function(){
					jQuery('#loginform').submit();
				});
			}
			return false;
		}
	});
});
</script> -->