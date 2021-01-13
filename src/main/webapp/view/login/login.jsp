<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html xmlns:th="http://www.thymeleaf.org">
<head>
<c:import url="../common/head.jsp" />
</head>
<body>

	<div class="container py-4">

		<div class="card border-primary text-center">
			<div class="card-header bg-cice text-white">Iniciar Sesión</div>
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

					<div class="form-group col-sm-6">
						<label for="username">Username</label>
						<input type="text" name="username" id="username"
							class="form-control" placeholder="Nombre de usuario" autofocus
							value="${user}"required />
					</div>

					<div class="form-group col-sm-6">
						<label for="password">Password</label>
						<input type="password" name="password" id="password"
							class="form-control" placeholder="Contraseña" value="${password}" required />
					</div>

					<div class="form-group col-sm-6">
						<button type="submit" class="btn btn-lg btn-primary btn-block">Log in</button>
					</div>

				</form>

			</div>
		</div>
	</div>

</body>
</html>