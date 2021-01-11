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
			Sede <span class="badge text-white bg-cice">UPDATE</span>
		</h2>
		
		<!-- Forumulario -->
		<form action="updateFestivoControl" method="GET">
			
			<!-- Id del festivo -->
			<div class="form-group mt-4 w-25">
				<label class="text-secondary font-weight-bold" for="id">Id</label>
				<input type="text" class="form-control" name="id" id="id" value="${festivo.id}" readonly>
			</div>
			
			<!-- Nombre del festivo -->
			<div class="form-group mt-4">
				<label class="text-secondary font-weight-bold" for="nombre">Nombre</label>
				<input type="text" class="form-control" name="nombre" id="nombre" value="${festivo.nombre}" required>
			</div>
			
			<!-- Fecha del festivo -->
			<div class="form-group mt-4 w-25">
				<label class="text-secondary font-weight-bold" for="fecha">Fecha del festivo</label>
				<input type="date" class="form-control" name="fecha" id="fecha" value="${festivo.fecha}" required>
			</div>
			
			<!-- Boton enviar formulario -->
			<div class="botonEnviar mt-4">
				<button type="submit" class="btn btn-lg font-weight-bold text-white cice-hover bg-cice">Actualizar</button>
			</div>
		</form>
	</div>

</body>
</html>