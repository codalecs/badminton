<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<tiles:useAttribute name="title" />
<tiles:useAttribute name="includeJQueryCalendar" />

<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en-US" lang="en-US">
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
		<link rel="stylesheet" type="text/css"
			href="<c:url value="/css/main.css" />" />
		<c:if test="${includeJQueryCalendar == 'true'}">
			<link rel="stylesheet" type="text/css"
				href="<c:url value="css/jquery-ui-1.8.18.custom.css" />" />
			<link rel="stylesheet" type="text/css"
				href="<c:url value="css/fullcalendar.css" />" />
			<script type="text/javascript"
				src="<c:url value="js/jquery-1.7.1.min.js" />"></script>
			<script type="text/javascript"
				src="<c:url value="js/jquery-ui-1.8.18.custom.min.js" />"></script>
			<script type="text/javascript"
				src="<c:url value="js/fullcalendar.min.js" />"></script>
			<script type="text/javascript"
				src="<c:url value="js/court.js" />"></script>
		</c:if>
		<title><fmt:message key="${title}" /></title>
	</head>
	<body>
		<div id="mainContainer">
			<div id="header"><tiles:insertAttribute name="header" /></div>
			<div id="main">
				<div id="leftMenu"><tiles:insertAttribute name="leftMenu" /></div>
				<div id="content"><tiles:insertAttribute name="content" /></div>
			</div>
			<div id="footer"><tiles:insertAttribute name="footer" /></div>
		</div>
	</body>
</html>
