
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>

<html>
<head>

<c:url value="/resources/css" var="cssPath"/>
<c:url value="/resources/js" var="jsPath"/>

<link rel="stylesheet" href="${cssPath}/bootstrap.min.css">
<link rel="stylesheet" href="${cssPath}/bootstrap-theme.min.css">
<script src="${jsPath}/jquery.js"></script>
<script src="${jsPath}/bootstrap.min.js"></script>
<script src="${jsPath}/style"></script>

<title>Cadastro de Usuários</title>
</head>
<body>
	<%@ include file="/WEB-INF/views/header.jsp" %>	
		
	 <div class="container-fluid">
        <div class="modal fade" id="myModalUser" role="dialog">
            <div class="modal-dialog modal-lg">    
                <div class="modal-content">
                    <div class="modal-header">             
                        <h4 class="modal-title">Cadastro de Usuário</h4>
                    </div>
                    <div class="modal-body">
                      <form:form id="formularioCadUsuario" action="${s:mvcUrl('UC#cadastrarUsuario').build()}" method="POST" commandName="usuario" enctype="multipart/form-data">                
		             	<div class="form-group">                                     
                               <div class="col-md-12">                                                             
                                   <div class="col-md-10">
                                        <label for="nome">Nome Completo</label>
                                        <form:input type="text" cssClass="form-control" id="nomeUsuario" name="nome" path="nome" placeholder="Nome Completo"/>
                                   </div>  
                                   <div class="col-md-2">
                                      <label for="login">Login</label>
                                      <form:input  cssClass="form-control" type="text" name="login" id="loginUsuario" path="login" placeholder="Login"/>
                                  </div>                                  
                               </div>
                          </div>

                          <div class="form-group">  
                              <div class="col-md-12">
                                  <div class="col-md-4">
                                      <label for="email">E-mail</label>
                                      <form:input cssClass="form-control" type="text" id="emailUsuario" name="email" path="email" placeholder="E-mail"/>
                                  </div>
                                  <div class="col-md-6">
                                      <label for="endereco">Endereço</label>
                                      <form:input  cssClass="form-control" type="text" name="endereco" id="enderecoUsuario" path="endereco" placeholder="Endereço"/>
                                  </div>
                                  <div class="col-md-2">
                                      <label for="numero">Nº</label>
                                      <form:input cssClass="form-control" type="text" id="numeroUsuario" name="numero" path="numero" placeholder="Nº"/>
                                  </div> 
                              </div>  
                          </div>       
                          <div class="form-group">  
                              <div class="col-md-12">
                                  <div class="col-md-4">
                                      <label for="cpf">CPF</label>
                                      <form:input type="text" cssClass="form-control" id="cpfUsuario" path="cpf" name="cpf" placeholder="CPF"/>
                                  </div>
                                  <div class="col-md-4">
                                      <label for="rg">RG</label>
                                      <form:input type="text" cssClass="form-control" id="rgUsuario" name="rg"  path="rg" placeholder="RG"/>
                                  </div>
                                  <div class="col-md-4">
                                      <label for="telefone">Telefone</label>
                                      <form:input type="text" cssClass="form-control" id="telefoneUsuario" path="telefone" placeholder="Telefone"/>
                                  </div>
                              </div>
                          </div>

                          <div class="form-group"> 
                              <div class="col-md-12">
                                  <div class="col-md-4">
                                      <label for="tipoUsuario">Categória do Usuário</label>
                                       <form:input type="text" cssClass="form-control" id="idTipoUsuario" path="tipoUsuario" name="tipoUsuario"/>                                         
                                  </div>
                                  <div class="col-md-4">
                                      <label for="dataAdmissao">Data da Admissão</label>
                                      <form:input type="text" cssClass="form-control" id="dataAdmissaoUsuario" path="dataAdmissao" name="dataAdmissao"/>
                                  </div>
                                  
                                  <div class="col-md-4">
                                      <label for="dataNascimento">Data de Nascimento</label>
                                      <form:input type="text" cssClass="form-control" id="dataNascimentoUsuario" path="dataNascimento" name="dataNascimento"/>
                                  </div>
                             </div>
                          </div> 
                          <div class="form-group"> 
                              <div class="col-md-12">
                                  <div class="col-md-4">
                                      <label for="senha">Senha</label>
                                      <form:input type="password" cssClass="form-control" id="senhaUsuario" path="senha" name="senha" placeholder="Senha"/>
                                  </div>
                                  <div class="col-md-4">
                                      <label for="estadoCivil">Estado Civil</label>
                                      <form:input cssClass="form-control" id="estadoCivilUsuario" path="estadoCivil" name="estadoCivil"/>                                         
                                  </div>
                                  <div class="col-md-4">
                                      <label for="sexo">Sexo</label>
                                      <form:input cssClass="form-control" id="sexoUsuario" path="sexo" name="sexo"/>                                           
                                  </div>
                              </div>
                              <div class="container">
                                  <div class="form-group">
                                      <div class="col-md-12">
                                          <p>.</p>
                                          <button type="submit" class="btn btn-success btn-lg" id="btn-cadastrar">Cadastrar</button>
                                          <button type="submit" class="btn btn-danger btn-lg" data-dismiss="modal">Fechar</button>
                                      </div>
                                  </div>
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