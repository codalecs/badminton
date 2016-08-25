<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<div id="user-data">
	<c:if test="${not empty user}">
		<c:url scope="page" var="picUrl" value="/users/${user.id}/picture" />
		<img src="${picUrl}" alt="Profile picture" />
		<table>
			<tbody>
				<tr>
					<th>ID</th>
					<td>${user.id}</td>
				</tr>
				<tr>
					<th>First name:</th>
					<td>${user.firstName}</td>
				</tr>
				<tr>
					<th>Last name:</th>
					<td>${user.lastName}</td>
				</tr>
				<tr>
					<th>E-Mail:</th>
					<td>${user.email}</td>
				</tr>
			</tbody>
		</table>
	</c:if>
	<c:if test="${empty user}">Such a user does not exist.</c:if>
	<a href=".">Back to list</a>
</div>