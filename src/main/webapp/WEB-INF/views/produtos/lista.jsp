<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<html>
<head>

<c:url value="/resources/css" var="cssPath"/>

<link rel="stylesheet" href="${cssPath}/bootstrap.min.css">
<link rel="stylesheet" href="${cssPath}/bootstrap-theme.min.css">

<title>Mercadinho-JT - Cadastro de Produtos</title>
</head>
<body>
	<%@ include file="/WEB-INF/views/header.jsp" %>
	<div>${sucesso }</div>
	<div class="container">
		<div class="form-group">
			<div class="col-md-12">
				<table class="table">
					<tr>
						<td>Nome do Produto</td>
						<td>Marca</td>
						<td>Categoria</td>
						<td>Valor do Produto</td>
						<td>Data de Validade</td>			
					</tr>
					<tr>
						<c:forEach items="${produtos}" var="produto">
							<tr>
								<td>${produto.nome}</td>
								<td>${produto.marca.nome}</td>
								<td>${produto.categoria.nome}</td>
								<td>${produto.preco.vlVenda}</td>
								<td>
								<fmt:formatDate pattern="dd/MM/yyyy" value="${produto.dataValidade.time}"/>
								</td>
							</tr>
						</c:forEach>
					</tr>
				</table>
			</div>
		</div>
	</div>
</body>  
</html>