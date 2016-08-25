<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<c:set var="now" value="<%= new java.util.Date() %>" />

<span id="logo">&#160;</span>
<div class="separator">&#160;</div>
<span id="title"><fmt:message key="page.home.title" /></span>
<span id="date"><fmt:formatDate value="${now}" pattern="dd/MM/yyyy" /></span>
<span id="userInfo">
	<sec:authorize access="isAuthenticated()">
		<sec:authentication  property="principal.username" />
		<a href="<c:url value="/logout" />">Logout</a>
	</sec:authorize>	
</span>
