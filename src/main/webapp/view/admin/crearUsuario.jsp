<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="ES">
<head>


<c:import url="../common/head.jsp"/>

		
<title>Zona Administracion</title>

</head>
<body>
	
	
<c:import url="../common/navbarAdmin.jsp"/>
	
	
	
	<div class="container-md w-50">
		<div class="pt-5"></div>
		
		<!-- Titulo -->
		<h2 class="pt-3">
			Usuario <span class="badge text-white bg-cice">CREAR</span>
		</h2>
		
		<!-- Forumulario -->
		<form action="crearUsuarioControl" method="POST">
			
			<!-- User -->
			<div class="form-group mt-4">
				<label class="text-secondary font-weight-bold" for="username">Username</label>
				<input type="text" class="form-control" name="username" id="username" required>
			</div>
			
			<!-- Password -->
			<div class="form-group mt-4">
				<label class="text-secondary font-weight-bold" for="password">Password</label>
				<input type="password" class="form-control" name="password" id="password" required>
			</div>

			<div class="form-check form-check-inline ml-4 mt-4">
				<label class="text-secondary align-bottom font-weight-bold form-check-label" for="roleUser">Role User</label>
				<input class="form-check-input mx-3" type="radio" name="role" id="roleUser" value="1">
			</div>
			
			<div class="form-check form-check-inline ml-4 mt-4">
				<label class="text-secondary font-weight-bold form-check-label" for="roleAdmin">Role Admin</label>
				<input class="form-check-input mx-3" type="radio" name="role" id="roleAdmin" value="2" checked>
			</div>
			
			<!-- Boton enviar formulario -->
			<div class="botonEnviar mt-4 ">
				<button type="submit" class="btn btn-lg font-weight-bold text-white cice-hover bg-cice">Crear</button>
			</div>
		</form>
	</div>

</body>
</html>