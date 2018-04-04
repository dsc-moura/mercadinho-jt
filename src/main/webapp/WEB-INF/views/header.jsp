<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="security" %>


<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<nav class="navbar navbar-default">
	  <div class="container-fluid">
	    <div class="navbar-header">
	      <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
	        <span class="sr-only">Toggle navigation</span>
	        <span class="icon-bar"></span>
	        <span class="icon-bar"></span>
	        <span class="icon-bar"></span>
	      </button>
	      <a class="navbar-brand" href="${s:mvcUrl('HC#index').build()} " >Mercadinho J-T</a>
	    </div>
	    <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
	      <ul class="nav navbar-nav">
	         <li><a href="${s:mvcUrl('PC#executa').build()}">Produtos</a></li>
	         <li><a href="${s:mvcUrl('PC#listaProdutos').build()}">Lista de Produtos</a></li>
	         <li><a href="${s:mvcUrl('UC#cadastroUser').build()}">Usuários</a></li>
	         <li><a data-toggle="modal" data-target="#myModalProduto">Cadastro de Produtos</a></li>
	         <li><a data-toggle="modal" data-target="#myModalUser">Cadastro de Produtos</a></li>
	      </ul>  
	      <ul class="nav navbar-nav navbar-right">
	  			<li>
	    			<a href="#">
	        		<security:authentication property="principal" var="usuario"/>
	        		Usuário: ${usuario.username}
	    			</a>
	  			</li>
		  </ul>
	           
	    </div><!-- /.navbar-collapse -->
	  </div>
	</nav>	
</body>
</html>