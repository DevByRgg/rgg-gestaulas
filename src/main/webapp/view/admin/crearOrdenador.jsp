<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="ES">
<head>


<c:import url="../common/head.jsp"/>

		
<title>Zona Administracion - Crear Ordenador</title>

</head>
<body>
			
	<div class="container-md w-50">
		<!-- Titulo -->
		<h2 class="paddingTop20">
			Ordenadores <span class="badge badge-secondary bg-info text-white">CREAR</span>
		</h2>
		
		<!-- Forumulario -->
		<form action="crearAulaControl" method="GET">
			
			<!-- Nombre -->
			<div class="form-group mt-4">
				<label class="text-secondary font-weight-bold" for="tipo">Tipo</label>
				<input type="text" class="form-control" name="tipo" id="tipo" placeholder="Tipo de equipo" required>
			</div>
			
			<!-- Sistema operativo -->
			<div class="form-group mt-4">
				<label class="text-secondary font-weight-bold" for="sistemaOperativo">Tipo</label>
				<input type="text" class="form-control" name="sistemaOperativo" id="sistemaOperativo" placeholder="Sistema operativo" required>
			</div>
			
			<!-- Tamaño de la pantalla -->
			<div class="form-group mt-4">
				<label class="text-secondary font-weight-bold" for="dimensionPantalla">Tamaño de pantalla</label>
				<input type="number" class="form-control" name="dimensionPantalla" id="dimensionPantalla" placeholder="Tamaño pantalla" required>
			</div>
			
			<!-- Cpu -->
			<div class="form-group mt-4">
				<label class="text-secondary font-weight-bold" for="cpu">Cpu</label>
				<input type="text" class="form-control" name="cpu" id="cpu" placeholder="Cpu" required>
			</div>
			
			<!-- Ram -->
			<div class="form-group mt-4">
				<label class="text-secondary font-weight-bold" for="ram">Ram</label>
				<input type="number" class="form-control" name="ram" id="ram" placeholder="Ram" required>
			</div>
			
			<!-- Tarjeta grafica -->
			<div class="form-group mt-4">
				<label class="text-secondary font-weight-bold" for="tarjetaGrafica">Tarjeta grafica</label>
				<input type="number" class="form-control" name="tarjetaGrafica" id="tarjetaGrafica" placeholder="Tarjeta grafica" required>
			</div>			
						
			<!-- Boton enviar formulario -->
			<div class="botonEnviar mt-4">
				<button type="submit" class="btn btn-outline-info btn-lg font-weight-bold">Crear</button>
			</div>
		</form>
	</div>

</body>
</html>