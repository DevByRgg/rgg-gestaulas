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
			Equipamiento <span class="badge text-white bg-cice">CREAR</span>
		</h2>
		
		<!-- Forumulario -->
		<form action="crearEquipamientoControl" method="GET">
			
			<!-- Nombre -->
			<div class="form-group mt-4">
				<label class="text-secondary font-weight-bold" for="nombre">Nombre</label>
				<input type="text" class="form-control" name="nombre" id="nombre" required>
			</div>
			
			<!-- Descripcion -->
			<div class="form-group mt-4">
				<label class="text-secondary font-weight-bold" for="descripcion">Descripcion</label>
				<input type="text" class="form-control" name="descripcion" id="descripcion" required>
			</div>
						
			<!-- Boton enviar formulario -->
			<div class="botonEnviar mt-4">
				<button type="submit" class="btn btn-lg font-weight-bold text-white cice-hover bg-cice">Crear</button>
			</div>
		</form>
	</div>

</body>
</html>