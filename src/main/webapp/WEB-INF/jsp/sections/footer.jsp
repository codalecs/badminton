<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<div id="copyright"><fmt:message key="page.footer.copyright" /></div>
<div id="language">
	<fmt:message key="page.footer.language.caption" />:
	<a href="<c:out value="home?lang=sr" />"><fmt:message key="page.footer.language.serbian" /></a>
	<a href="<c:out value="home?lang=en" />"><fmt:message key="page.footer.language.english" /></a>
</div>

