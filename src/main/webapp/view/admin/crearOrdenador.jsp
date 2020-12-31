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
			Equipo <span class="badge text-white bg-cice">CREAR</span>
		</h2>
		
		<!-- Forumulario -->
		<form action="crearOrdenadorControl" method="GET">
			
			<!-- Nombre -->
			<div class="form-group mt-4">
				<label class="text-secondary font-weight-bold" for="nombre">Nombre</label>
				<input type="text" class="form-control" name="nombre" id="nombre" required>
			</div>
			
			<!-- Sistema operativo -->
			<div class="form-group mt-4">
				<label class="text-secondary font-weight-bold" for="sistemaOperativo">Sistema operativo</label>
				<input type="text" class="form-control" name="sistemaOperativo" id="sistemaOperativo" required>
			</div>
			
			<!-- Tamaño de la pantalla -->
			<div class="form-group w-25 mt-4">
				<label class="text-secondary font-weight-bold" for="dimensionPantalla">Tamaño de pantalla</label>
				<input type="number" class="form-control" name="dimensionPantalla" id="dimensionPantalla" required>
			</div>
			
			<!-- Cpu -->
			<div class="form-group mt-4">
				<label class="text-secondary font-weight-bold" for="cpu">Cpu</label>
				<input type="text" class="form-control" name="cpu" id="cpu" required>
			</div>
			
			<!-- Ram -->
			<div class="form-group w-25 mt-4">
				<label class="text-secondary font-weight-bold" for="ram">Ram</label>
				<input type="number" class="form-control" name="ram" id="ram" required>
			</div>
			
			<!-- Tarjeta grafica -->
			<div class="form-group mt-4">
				<label class="text-secondary font-weight-bold" for="tarjetaGrafica">Tarjeta grafica</label>
				<input type="text" class="form-control " name="tarjetaGrafica" id="tarjetaGrafica" required>
			</div>			
						
			<!-- Boton enviar formulario -->
			<div class="botonEnviar mt-4">
				<button type="submit" class="btn btn-lg font-weight-bold text-white cice-hover bg-cice">Crear</button>
			</div>
		</form>
	</div>

</body>
</html>