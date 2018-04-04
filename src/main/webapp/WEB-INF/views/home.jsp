<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="security"%>
<html>
<head>


<c:url value="/resources/css" var="cssPath"/>
<c:url value="/resources/js" var="jsPath"/>

<link rel="stylesheet" href="${cssPath}/bootstrap.min.css">
<link rel="stylesheet" href="${cssPath}/bootstrap-theme.min.css">

<script src="${jsPath}/jquery.js"></script>
<script src="${jsPath}/bootstrap.min.js"></script>

</head>
<body>
	<%@ include file="/WEB-INF/views/header.jsp" %>
	
</body>
</html>