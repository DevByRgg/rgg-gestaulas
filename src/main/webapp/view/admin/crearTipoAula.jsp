<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="ES">
<head>


<c:import url="../common/head.jsp"/>

		
<title>Zona Administracion - Crear Tipo de Aula</title>

</head>
<body>
	
	<div class="container-md w-50">
		<!-- Titulo -->
		<h2 class="paddingTop20">
			Tipos de Aulas <span class="badge badge-secondary bg-info text-white">CREAR</span>
		</h2>
		
		<!-- Forumulario -->
		<form action="crearTipoAulaControl" method="GET">
			
			<!-- Id del Aula -->
			<div class="form-group mt-4">
				<label class="text-secondary font-weight-bold" for="nombre">Nombre</label>
				<input type="text" class="form-control" name="nombre" id="nombre" placeholder="Nombre" required>
			</div>
			
			<!-- Tipo de ordenadores -->
			<div class="form-group w-25 mt-1">
				<label class="text-secondary font-weight-bold" for="idOrdenador">Tipo de ordenadores</label>
				<select	class="form-control" id="idOrdenador" name="idOrdenador">
					<c:forEach items="${ordenadores}" var="ordenador">
						<option value="${ordenador.id}">${ordenador.tipo}</option>
					</c:forEach>
				</select>
			</div>

			<!-- Tipo de equipamiento -->
			<div class="form-group w-25 mt-1">
				<label class="text-secondary font-weight-bold" for="idEquipamiento">Tipo de equipamiento</label>
				<select	class="form-control" id="idEquipamiento" name="idEquipamiento">
					<c:forEach items="${equipamientos}" var="equipamiento">
						<option value="${equipamiento.id}">${equipamiento.nombre}</option>
					</c:forEach>
				</select>
			</div>
			
						
			<!-- Boton enviar formulario -->
			<div class="botonEnviar mt-4">
				<button type="submit" class="btn btn-outline-info btn-lg font-weight-bold">Crear</button>
			</div>
		</form>
	</div>

</body>
</html>