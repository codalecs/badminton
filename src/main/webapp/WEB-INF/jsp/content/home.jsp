<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix='fn' uri='http://java.sun.com/jsp/jstl/functions' %>

<script type="text/javascript">
	
function init() {
	<c:forEach var="i" begin="1" end="${fn:length(courts)}">
		initCalendar('<c:out value="${i}"/>');		
	</c:forEach>	
	$("#slots").tabs({
	    show: function(event, ui) {
	    	<c:forEach var="i" begin="1" end="${fn:length(courts)}">
	    		$('#calendar-<c:out value="${i}"/>').fullCalendar('render');		
			</c:forEach>
	    }
	});
	<c:forEach var="i" begin="1" end="${fn:length(courts)}">
		$('#calendar-<c:out value="${i}"/>').fullCalendar('render');		
	</c:forEach>
}

$(document).ready(init);
</script>

<div id="slots">
	<ul>
		<c:forEach items="${courts}" var="court" varStatus="loop">
	    	<li><a href="#calendar-<c:out value="${loop.index+1}"/>">${court.name}</a></li>		
		</c:forEach>
	</ul>	
	<c:forEach var="i" begin="1" end="${fn:length(courts)}">
	   	<div id="calendar-<c:out value="${i}"/>"></div>		
	</c:forEach>
</div>
