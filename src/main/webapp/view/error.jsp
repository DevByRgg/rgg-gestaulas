<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="context" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<c:import url="./common/head.jsp" />
<title>Error</title>
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
		<c:out value="${requestScope.titulo}" />
			<span class="badge text-white bg-cice">ERROR</span>
		</h2>
		
<%-- 		<h4 class="mt-5"><c:out value="${requestScope.mensaje}"/></h4> --%>
		<c:forEach var="mensaje" items="${mensajesError}">
		  <h4 class="mt-5"><c:out value="${mensaje}"/></h4>
		</c:forEach>

		<a type="button" class="btn font-weight-bold cice-hover bg-cice text-white mt-5"
			href="javascript:history.back()"> Volver Atrás </a>
	</div>
</body>
</html>