<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<nav class="navbar fixed-top navbar-expand-lg navbar-light bg-cice">
	<a class="navbar-brand text-white" href="javascript:history.back()">
		<img src="/aulas/images/logo_blanco_total.svg" height="25"
		class="d-inline-block align-top" alt="">
	</a>

	<div class="collapse navbar-collapse" id="navbarSupportedContent"></div>

	<ul class="navbar-nav ml-auto mr-3">
		<li class="nav-item"><a class="btn btn-primary float-right"
			href="<c:url value="/logout" />">Logout</a></li>
	</ul>

	<a class="navbar-brand text-light" href="javascript:history.back()">
		<img src="/aulas/images/logo_blanco_total.svg" height="25"
		class="d-inline-block align-top" alt="">
	</a>

</nav>