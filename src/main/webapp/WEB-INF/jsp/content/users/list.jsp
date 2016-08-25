<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<div id="user-list">
	<table>
		<thead>
			<tr>
				<th>ID</th>
				<th>Name</th>
				<th>Surname</th>
				<th>E-Mail</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${users}" var="user" varStatus="status">
				<tr class="${(status.count % 2 == 0) ? 'even' : 'odd'}${status.last ? ' last' : ''}">
					<td><a href='<c:url value="/users/${user.id}"/>'>${user.id}</a></td>
					<td>${user.firstName}</td>
					<td>${user.lastName}</td>
					<td><a href="mailto:${user.email}">${user.email}</a></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>	
</div>