<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="context" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<c:import url="./common/head.jsp"/>
<title>Error</title>
</head>
<body>



	<div class="container-md w-75">

		<div class="pt-5"></div>

		<h2 class="pt-3">
			Administration <span class="badge text-white bg-cice">Error</span>
		</h2>
		
		<ul>
        	<li>status: <c:out value="${requestScope.status}" /></li>
	        <li>error: <c:out value="${requestScope.error}" /></li>
	        <li>message: <c:out value="${requestScope.message}" /></li>
	        <li>path: <c:out value="${requestScope.path}" /></li>
	        <li>trace: <c:out value="${requestScope.trace}" /></li>
    	</ul>
		
		<a type="button" class="btn cice-hover bg-cice text-white" href="javascript:history.back()">
								Volver Atrás
		</a>
	</div>

</body>
</html>