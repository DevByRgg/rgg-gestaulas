<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="ES">
<head>


<c:import url="../common/head.jsp"/>

		
<title>Zona Administracion - Crear Equipamiento</title>

</head>
<body>
	
	
<c:import url="../common/navbarAdmin.jsp"/>
	
	
	
	<div class="container-md w-50">
		<div class="pt-5"></div>
		
		<!-- Titulo -->
		<h2 class="pt-3">
			Equipamientos <span class="badge badge-secondary text-white" style="background-color: #ff00f7;">CREAR</span>
		</h2>
		
		<!-- Forumulario -->
		<form action="crearEquipamientoControl" method="GET">
			
			<!-- Nombre -->
			<div class="form-group mt-4">
				<label class="text-secondary font-weight-bold" for="nombre">Nombre</label>
				<input type="text" class="form-control" name="nombre" id="nombre" placeholder="Nombre" required>
			</div>
			
			<!-- Descripcion -->
			<div class="form-group mt-4">
				<label class="text-secondary font-weight-bold" for="descripcion">Descripcion</label>
				<input type="text" class="form-control" name="descripcion" id="descripcion" placeholder="Descripcion" required>
			</div>
			
			
			<!-- Boton enviar formulario -->
			<div class="botonEnviar mt-4">
				<button type="submit" class="btn btn-outline-secondary btn-lg font-weight-bold">Crear</button>
			</div>
		</form>
	</div>

</body>
</html>