<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="tags" tagdir="/WEB-INF/tags"%>
<tags:template title="Lista de Estacionamento">
	<h1>Estacionamentos cadastrados</h1>
${msg }
<table class="table">
		<tr>
			<th>Nome</th>
			<th>Endereço</th>
			<th>Vagas</th>
			<th>Preço</th>
			<th></th>
		</tr>
		<c:forEach items="${estacionamentos }" var="e">
			<tr>
				<td>${e.nome }</td>
				<td>${e.endereco }</td>
				<td>${e.vagas }</td>
				<td>${e.preco }</td>
				<td>
					<c:url value="/estacionamento/editar/${e.codigo }" var="link"/>
					<a href="${link }" class="btn btn-primary btn-sm">Editar</a>
				</td>
			</tr>
		</c:forEach>
	</table>
</tags:template>