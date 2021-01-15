<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<c:import url="./common/head.jsp" />
<title>Error</title>
</head>
<body>

<c:import url="../common/navbarLogin.jsp"/>

	<div class="container-md w-75">

		<div class="pt-5"></div>

		<h2 class="pt-3 mb-5">${titulo} <span class="badge text-white bg-cice">ERROR</span></h2>
		
		<c:forEach items="${msnError}" var="mensaje">
			<div class="mt-3">
				<p><span class="font-weight-bold text-capitalize mr-2">- ${mensaje.key}:</span>${mensaje.value}</p>
			</div>
		</c:forEach>

		<a type="button" class="btn btn-lg font-weight-bold cice-hover bg-cice text-white mt-3"
			href="javascript:history.back()"><img alt="" src="/aulas/">Volver</a>
	</div>
</body>
</html>