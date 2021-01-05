<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="ES">
<head>


<c:import url="../common/head.jsp"/>

		
<title>Zona Administracion - Crear Sede</title>

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
		<form action="updateSedeControl" method="GET">
			
			<!-- Nombre de la Sede -->
			<div class="form-group mt-4">
				<label class="text-secondary font-weight-bold" for="id">Id</label>
				<input type="text" class="form-control" name="id" id="id" value="${sede.id}" readonly>
			</div>
			
			<!-- Nombre de la Sede -->
			<div class="form-group mt-4">
				<label class="text-secondary font-weight-bold" for="nombre">Nombre</label>
				<input type="text" class="form-control" name="nombre" id="nombre" placeholder="Nombre" value="${sede.nombre}" required>
			</div>
			
			<!-- Direccion de la Sede -->
			<div class="form-group mt-4">
				<label class="text-secondary font-weight-bold" for="direccion">Direccion</label>
				<input type="text" class="form-control" name="direccion" id="direccion" placeholder="Direccion" value="${sede.direccion}" required>
			</div>
			
			<!-- Codigo postal de la Sede -->
			<div class="form-group w-50 mt-4">
				<label class="text-secondary font-weight-bold" for="codigoPostal">Codigo postal</label>
				<input type="text" class="form-control" name="codigoPostal" id="codigoPostal" placeholder="Codigo postal" value="${sede.codigoPostal}" required>
			</div>
			
			<!-- Telefono de la Sede -->
			<div class="form-group w-25 mt-4">
				<label class="text-secondary font-weight-bold" for="telefono">Telefono</label>
				<input type="text" class="form-control" name="telefono" id="telefono" placeholder="Telefono" value="${sede.telefono}" required>
			</div>
			
			
			<!-- Boton enviar formulario -->
			<div class="botonEnviar mt-4">
				<button type="submit" class="btn btn-lg font-weight-bold text-white cice-hover bg-cice">Actualizar</button>
			</div>
		</form>
	</div>

</body>
</html>