<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<div id="login">
	<form id="loginForm" action="<c:url value="/j_spring_security_check" />" method="post">
		<div id="username">
			<label for="j_username">Email:</label>
			<input id="j_username" name="j_username" value="" size="20" maxlength="256" tabindex="1" type="text" />
		</div>
		<div id="password">
			<label for="j_password">Password:</label>
			<input id="j_password" name="j_password" value="" size="20" maxlength="256" tabindex="1" type="password" />
		</div>
		<div id="loginButton">
			<button id="loginButton" type="submit">Login</button>
		</div>
		<div id="register">
			<a href='<c:url value="/users/new"/>'>Register</a>
		</div>
	</form>
</div>
