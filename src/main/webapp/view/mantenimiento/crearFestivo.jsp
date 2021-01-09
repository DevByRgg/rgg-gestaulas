<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="ES">
<head>


<c:import url="../common/head.jsp"/>

		
<title>Mantenimiento</title>

</head>
<body>

<c:import url="../common/navbarAdmin.jsp"/>
	
	<div class="container-md w-50">
		<div class="pt-5"></div>
		
		<!-- Titulo -->
		<h2 class="pt-3">
			Crear <span class="badge text-white bg-cice">FESTIVO</span>
		</h2>
		
		<!-- Forumulario -->
		<form action="crearFestivoControl" method="GET">
			
			<!-- Nombre del festivo -->
			<div class="form-group mt-4">
				<label class="text-secondary font-weight-bold" for="nombre">Nombre del curso</label>
				<input type="text" class="form-control" name="nombre" id="nombre" required>
			</div>
			
			<!-- Fecha del festivo-->
			<div class="form-group mt-4 w-25">
				<label class="text-secondary font-weight-bold" for="fecha">Fecha de la reserva</label>
				<input type="date" class="form-control" name="fecha" id="fecha" required>
			</div>

			<!-- Boton enviar formulario -->
			<div class="botonEnviar mt-4">
				<button type="submit" class="btn btn-outline-default btn-lg font-weight-bold text-white cice-hover bg-cice">Crear</button>
			</div>
		</form>
	</div>

</body>
</html>