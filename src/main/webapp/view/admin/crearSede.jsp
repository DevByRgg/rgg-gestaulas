<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="ES">
<head>


<c:import url="../common/head.jsp"/>

		
<title>Zona Administracion - Crear Sede</title>

</head>
<body>
	
	<div class="container-md w-50">
		<!-- Titulo -->
		<h2 class="paddingTop20">
			Sedes <span class="badge badge-secondary bg-info text-white">CREAR</span>
		</h2>
		
		<!-- Forumulario -->
		<form action="crearSedeControl" method="GET">
			
			<!-- Nombre de la Sede -->
			<div class="form-group mt-4">
				<label class="text-secondary font-weight-bold" for="nombre">Nombre</label>
				<input type="text" class="form-control" name="nombre" id="nombre" placeholder="Nombre" required>
			</div>
			
			<!-- Direccion de la Sede -->
			<div class="form-group mt-4">
				<label class="text-secondary font-weight-bold" for="direccion">Direccion</label>
				<input type="text" class="form-control" name="direccion" id="direccion" placeholder="Direccion" required>
			</div>
			
			<!-- Codigo postal de la Sede -->
			<div class="form-group mt-4">
				<label class="text-secondary font-weight-bold" for="codigoPostal">Codigo postal</label>
				<input type="text" class="form-control" name="codigoPostal" id="codigoPostal" placeholder="Codigo postal" required>
			</div>
			
			<!-- Telefono de la Sede -->
			<div class="form-group mt-4">
				<label class="text-secondary font-weight-bold" for="telefono">Telefono</label>
				<input type="text" class="form-control" name="telefono" id="telefono" placeholder="Telefono" required>
			</div>
			
			<!-- Numero Aulas de la Sede -->
			<div class="form-group mt-4">
				<label class="text-secondary font-weight-bold" for="numeroAulas">Numero de aulas</label>
				<input type="number" class="form-control" name="numeroAulas" id="numeroAulas" placeholder="Numero de aulas" required>
			</div>
						
			
			<!-- Boton enviar formulario -->
			<div class="botonEnviar mt-4">
				<button type="submit" class="btn btn-outline-info btn-lg font-weight-bold">Crear</button>
			</div>
		</form>
	</div>

</body>
</html>