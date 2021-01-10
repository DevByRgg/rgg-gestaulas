<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="context" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<c:import url="../common/head.jsp" />
<title>Error 404</title>
</head>
<body>

	<nav class="navbar fixed-top navbar-expand-lg navbar-light bg-cice">
		<a class="navbar-brand text-white" href="javascript:history.back()">
			<img src="/aulas/images/logo_blanco_total.svg" height="25"
			class="d-inline-block align-top" alt="">

		</a>

		<button class="navbar-toggler" type="button" data-toggle="collapse"
			data-target="#navbarSupportedContent"
			aria-controls="navbarSupportedContent" aria-expanded="false"
			aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>

		<div class="collapse navbar-collapse" id="navbarSupportedContent">


		</div>

		<a class="navbar-brand text-light" href="javascript:history.back()">

			<img src="/aulas/images/logo_blanco_total.svg" height="25"
			class="d-inline-block align-top" alt="">
		</a>

	</nav>

	<div class="container-md w-75">

		<div class="pt-5"></div>

		<h2 class="pt-3">
			Administration <span class="badge text-white bg-cice">Error</span>
		</h2>

		<ul>
			<li>status: <c:out value="${requestScope.status}" /></li>
			<li>error 404: <c:out value="${requestScope.error}" /></li>
			<li>Mensaje: <c:out value="${requestScope.mensaje}" /></li>
			<li>path: <c:out value="${requestScope.path}" /></li>
			<li>trace: <c:out value="${requestScope.trace}" /></li>
		</ul>

		<a type="button" class="btn cice-hover bg-cice text-white"
			href="javascript:history.back()"> Volver Atrás </a>
	</div>
</body>
</html>