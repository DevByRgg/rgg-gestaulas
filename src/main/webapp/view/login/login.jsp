<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html xmlns:th="http://www.thymeleaf.org">
<head>

<c:import url="../common/head.jsp" />

</head>
<body>

<c:import url="../common/navbarLogin.jsp"/>

	<div class="container align-middle w-25 mt-5 mx-auto">
		
		<div class="pt-5"></div>
		
		<div class="card border-secondary text-center">
			<div class="card-header font-weight-bold bg-cice text-white">Iniciar Sesión</div>
			<div class="card-body">

				<c:choose>
					<c:when test="${error != null}">
						<div class="alert alert-danger text-center" role="alert">${error}</div>
					</c:when>					
				</c:choose>
				
				<c:choose>
					<c:when test="${success != null}">
						<div class="alert alert-success text-center" role="alert">${success}</div>
					</c:when>					
				</c:choose>

				<form action="login" method="post" autocomplete="off">

					<div class="form-group">
						<label for="username">Username</label>
						<input type="text" name="username" id="username"
							class="form-control" placeholder="Nombre de usuario" autofocus
							value="${user}"required />
					</div>

					<div class="form-group mb-5">
						<label for="password">Password</label>
						<input type="password" name="password" id="password"
							class="form-control" placeholder="Contraseña" value="${password}" required />
					</div>

					<div class="form-group">
						<button type="submit" class="btn btn-lg btn-block btn-light bg-cice font-weight-bold cice-hover text-white">Log in</button>
					</div>

				</form>
				
			</div>
		</div>
	</div>

</body>
</html>