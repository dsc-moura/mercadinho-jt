<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<html>
<head>

<c:url value="/resources/css" var="cssPath"/>
<c:url value="/resources/js" var="jsPath"/>
<c:url value="/resources/img" var="imgPath"/>

<link rel="stylesheet" href="${cssPath}/style.css">

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login Mercadinho-JT</title>
</head>
<body>
	<div class="loginBox">
		<img alt="" src="${imgPath}/user.png" class="user">
		<h2>Login</h2>
		<form:form id="formularioCadProdutos" servletRelativeAction="/login" method="POST">  
			<p>Usuário</p>
			<input type="text" name="username" placeholder="Login do Usuário"/>
					
			<p>Senha</p>	
			<input type="password" name="password" placeholder="*********" />										 	
			         
			<input type="submit" value="Entrar"/>	
			<a href="#">Esqueci a Senha</a>			
		</form:form>   
	</div>
</body>
</html>