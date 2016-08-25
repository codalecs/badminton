<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<div id="user-edit-form">
	<c:choose>
		<c:when test="${newUser}">
			<c:url var="submitUrl" scope="page" value="/users/new" />
		</c:when>
		<c:otherwise>
			<c:url var="submitUrl" scope="page" value="/users/edit" />
		</c:otherwise>		
	</c:choose>	
	<form:form action="${submitUrl}"  method="post" commandName="user" enctype="multipart/form-data">
		<c:if test="${not newUser}">
			<form:label path="id">ID:</form:label>
			<form:input path="id" readonly="true" />
			<br />
		</c:if>
		<form:label path="firstName">First name:</form:label>
		<form:input path="firstName" />
		<form:errors path="firstName" cssClass="error" />
		<br />
		<form:label path="lastName">Last name:</form:label>
		<form:input path="lastName" />
		<form:errors path="lastName" cssClass="error" />
		<br />
		<form:label path="email">E-Mail:</form:label>
		<form:input path="email" />
		<form:errors path="email" cssClass="error" />
		<br />
		<form:label path="password">Password:</form:label>
		<form:password path="password" />
		<form:errors path="password" cssClass="error" />
		<br />
		<c:if test="${not newUser}">
			<c:url scope="page" var="picUrl" value="/users/${user.id}/picture" />
			<img src="${picUrl}" alt="Profile picture" />
			<br />
		</c:if>
		<label for="user.picture">Profile picture:</label>
		<input name="user.picture" type="file" />
		<form:errors path="picture" cssClass="error" />
		
		<input type="submit" value="Submit" />
		<input type="button" value="Cancel" onclick="javascript:window.location.href='${newUser ? '.' : user.id}'" />
	</form:form>
</div>