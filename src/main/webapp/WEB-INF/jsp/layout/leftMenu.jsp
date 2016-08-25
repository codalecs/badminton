<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<tiles:importAttribute name="leftMenuItems" />

<ul class="leftMenu">
	<c:forEach var="item" items="${leftMenuItems}">
		<li>
 			<a class="navigationLink" href="<c:url value="${item.link}" />"><fmt:message key="${item.value}" /></a>
		</li>
	</c:forEach>
</ul>
