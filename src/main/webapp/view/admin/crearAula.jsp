<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="ES">
<head>


<c:import url="../common/head.jsp"/>

		
<title>Zona Administracion - Crear Aula</title>

</head>
<body>
	
	<div class="container-md w-50">
		<!-- Titulo -->
		<h2 class="paddingTop20">
			Aulas <span class="badge badge-secondary bg-info text-white">CREAR</span>
		</h2>
		
		<!-- Forumulario -->
		<form action="crearAulaControl" method="GET">
			
			<!-- Id del Aula -->
			<div class="form-group mt-4">
				<label class="text-secondary font-weight-bold" for="id">Nombre</label>
				<input type="text" class="form-control" name="id" id="id" placeholder="Id del aula" required>
			</div>
			
			<!-- Tipo de Aula -->
			<div class="form-group w-25 mt-1">
				<label class="text-secondary font-weight-bold" for="idTipoAula">Tipo de Aula</label>
				<select	class="form-control" id="idTipoAula" name="idTipoAula">
					<c:forEach items="${tipoAulas}" var="tipoAula">
						<option value="${tipoAula.id}">${tipoAula.nombre}</option>
					</c:forEach>
				</select>
			</div>
			
			<!-- Numero de puestos -->
			<div class="form-group mt-4">
				<label class="text-secondary font-weight-bold" for="numeroPuestos">Numero de puestos</label>
				<input type="text" class="form-control" name="numeroPuestos" id="numeroPuestos" placeholder="Numero de puestos" required>
			</div>
			
			
			<!-- Boton enviar formulario -->
			<div class="botonEnviar mt-4">
				<button type="submit" class="btn btn-outline-info btn-lg font-weight-bold">Crear</button>
			</div>
		</form>
	</div>

</body>
</html>