<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<c:url value="/resources/css" var="cssPath"/>
<c:url value="/resources/js" var="jsPath"/>
<c:url value="/resources/img" var="imgPath"/>


<link rel="stylesheet" href="${cssPath}/index_style.css">



<script src="${jsPath}/jquery.js"></script>

<title>Mercadinho-JT - Cadastro de Produtos</title>
</head>
<body>	
		
	<header>
		
		<div class="contenedor" id="uno">
			<img class="icones" src="${imgPath}/home.png">
			<p class="texto">Home</p>
		</div>

		<div class="contenedor" style="cursor: hand;" onclick="window.location='${s:mvcUrl('PC#executa').build()}';" id="dos">
			<img class=icones src="${imgPath}/icon.png">			
			<p class="texto">Produtos</p>
		</div>

		<div class="contenedor" id="tres">
			<img class="icones" src="${imgPath}/user.png">
			<p class="texto">Usuários</p>
		</div>
	
		<div class="contenedor" id="cuatro" action="">
			<img class="icones" src="${imgPath}/list.png">
			<p class="texto">Lista de Produtos</p>
			
		</div>

		<div class="contenedor" id="cinco">
			<img class="icones" src="${imgPath}/pagamento.png">
			<p class="texto">Financeiro</p>
		</div>

		<div class="contenedor" id="seis">
			<img class="icones" src="${imgPath}/fornecedor.png">
			<p class="texto">Fornecedores</p>
		</div>

	</header>
	
</body>
</html>