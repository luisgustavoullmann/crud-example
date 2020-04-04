<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="tags" tagdir="/WEB-INF/tags"%>
<tags:template title="Cadastro de Estacionamento">
	<h1>Cadastro de estacionamento</h1>
${msg }
<c:url value="/estacionamento/cadastrar" var="action" />
	<form:form action="${action }" method="post" commandName="estacionamento">
		<div class="form-group">
			<form:label path="nome">Nome</form:label>
			<form:input path="nome" cssClass="formcontrol" />
		</div>
		<div class="form-group">
			<form:label path="endereco">Endereço</form:label>
			<form:input path="endereco" cssClass="form-control" />
		</div>
		<div class="form-group">
			<form:label path="vagas">Número de Vagas</form:label>
			<form:input path="vagas" cssClass="formcontrol" />
		</div>
		<div class="form-group">
			<form:label path="preco">Preço</form:label>
			<form:input path="preco" cssClass="formcontrol" />
		</div>
		<input type="submit" value="Salvar" class="btn btn-primary">
	</form:form>
</tags:template>

