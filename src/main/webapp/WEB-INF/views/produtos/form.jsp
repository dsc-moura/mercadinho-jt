<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="security"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<c:url value="/resources/css" var="cssPath"/>
<c:url value="/resources/js" var="jsPath"/>

<link rel="stylesheet" href="${cssPath}/bootstrap.min.css">
<link rel="stylesheet" href="${cssPath}/bootstrap-theme.min.css">

<script src="${jsPath}/jquery.js"></script>
<script src="${jsPath}/bootstrap.min.js"></script>

<title>Mercadinho-JT - Cadastro de Produtos</title>
</head>
<body>	
	<%@ include file="/WEB-INF/views/header.jsp" %>
	<!-- Modal Cadastro de Produtos-->
	
	<div class="container">       
	   <div class="modal fade" id="myModalProduto" role="dialog">
	    <div class="modal-dialog modal-lg">
	      <div class="modal-content">
	        <div class="modal-header">
	          <button type="button" class="close" data-dismiss="modal">&times;</button>
	              <h4 class="modal-title">Cadastro de Produto</h4>
	        </div>
	        <div class="modal-body">
	        	<form:form id="formularioCadProdutos" action="${s:mvcUrl('PC#cadastrarProduto').build()}" method="POST" commandName="produto" enctype="multipart/form-data">                
		            <div class="form-group">                     
			            <div class="col-md-12">    
				            <div class="col-md-4">                               		
					        	<label>Imagem do Produto</label>
								<input type="image" src="\arquivos-produto\Tomate-destaque.jpg" width="80" height="50"/>   
				            </div>  
				            <div class="col-md-8">
				            	<label for="inputCodBarras">Código de Barras</label>
				            	<form:input type="text" cssClass="form-control" id="inputCodBarras" name="codigoBarras" path="codigoBarras" placeholder="Código de Barras"/>
				            </div>                            
			            </div>                        
		            </div>
		            <div class="form-group">                        
		                <div class="col-md-12">
				            <div class="col-md-4">
					            <label for="nomeProduto">Nome Produto</label>
					            <form:input type="text" cssClass="form-control" id="nomeProduto" name="nomeProduto" path="nome" placeholder="Nome Produto"/>
				        	</div>
			
				            <div class="col-md-4">
					            <label>Marca Produto</label>
								<form:select cssClass="form-control" id="marca.idMarca" path="marca.idMarca">
									<option value="">Selecione a Marca</option>
									<c:forEach items="${marcas }" var="marcas">
										<option value="${marcas.idMarca }">${marcas.nome }</option>
									</c:forEach>						
								</form:select>
				            </div>
			                          
			                <div class="col-md-4">
				               	<label>Categória do Produto</label>			
								<form:select cssClass="form-control" id="categoria.id_Categoria" path="categoria.id_Categoria">
									<option value="">Selecione a Categória</option>
									<c:forEach items="${categorias }" var="categoria">
										<option value="${categoria.id_Categoria }"> ${categoria.nome}</option>
									</c:forEach>	
								</form:select>	
			                </div>
						</div>
					</div>
					<div class="form-group">   
						<div class="col-md-12">
					        <div class="col-md-4">
							    <label for="selectFornecedor">Fornecedor</label>
							    <form:select cssClass="form-control" id="fornecedor.idFornecedor" path="fornecedor.idFornecedor">
									<option value="">Selecione o Fornecedor</option>
									<c:forEach items="${fornecedores }" var="fornecedor">
										<option value="${fornecedor.idFornecedor }"> ${fornecedor.nome}</option>
									</c:forEach>	
								</form:select>	                
					        </div>
					                          
					        <div class="col-md-3">
						        <label for="inputVlVenda">Número Nota Fiscal</label>
						        <form:input type="text" cssClass="form-control" id="numeroNF" path="numeroNF" placeholder="Nº Nota Fiscal"/>
					        </div>                       
					                     	  
					        <div class="col-md-2">
						        <label>Quantidade</label>	
						        <form:input type="text" cssClass="form-control" id="quantidade" path="quantidade"/>
								<form:errors path="quantidade"/>
					        </div>	                     
					                         
					        <div class="col-md-3">	
								<label>Data Pedido</label>	
								<form:input type="text" cssClass="form-control" id="dataPedido" path="dataPedido"/>
								<form:errors path="dataPedido"/>
							</div>
						</div>
					</div>
					<div class="form-group">   
						<div class="col-md-12">
					        <div class="col-md-3">
						        <label for="inputVlCompra">Valor de Compra</label>
						        <form:input type="text" cssClass="form-control" id="preco.vlCusto" path="preco.vlCusto" name="preco.vlCompra" placeholder="Valor de Compra"/>
					        </div>
					
					        <div class="col-md-3">
						        <label for="inputVlVenda">Valor de Venda</label>
						        <form:input type="text" cssClass="form-control" id="preco.vlVenda" path="preco.vlVenda" name="preco.vlVenda" placeholder="Valor de Venda"/>
					        </div>
					                     
					        <div class="col-md-3">	
								<label>Data Registro</label>	
								<form:input type="text" cssClass="form-control" id="dataRegistro" path="dataRegistro"/>
								<form:errors path="dataRegistro"/>
							</div>					
											
							<div class="col-md-3">	
								<label>Data Validade</label>	
								<form:input type="text" cssClass="form-control" id="dataValidade" path="dataValidade"/>
								<form:errors path="dataValidade"/>		 	
							</div>									
			            </div>
		            </div>
		           	<div>
		            	<p>.</p>
		            </div>
		            <div class="container" class="rigthButton">
			           	<div class="form-group">
			            	<button type="submit" class="btn btn-success btn-lg" id="btn-cadastrar">Cadastrar</button>
			            </div>
		            </div>
	        	</form:form>   
	         </div>               
	      </div>      
	   </div>
	</div>  
</div>
</body>	 
</html>