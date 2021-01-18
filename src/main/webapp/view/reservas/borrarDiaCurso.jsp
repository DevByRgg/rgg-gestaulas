<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="ES">
<head>


<c:import url="../common/head.jsp"/>

		
<title>Zona Reservas</title>

</head>
<body>

<c:import url="../common/navbarAdmin.jsp"/>
	
	<div class="container-md w-50">
		<div class="pt-5"></div>
		
		<!-- Titulo -->
		<h2 class="pt-3">
			Borrar <span class="badge text-white bg-cice">DIA</span>
		</h2>
		
		<!-- Forumulario -->
		<form action="borrarDiaControl" method="GET">
			<!-- Fecha del dia -->
			<div class="form-group mt-4 w-25">
				<label class="text-secondary font-weight-bold" for="idAula">Aula</label>
				<select	class="form-control" id="idAula" name="idAula" required>
						<option value="-1" selected>Todas</option>
					<c:forEach items="${aulas}" var="aula">
						<option value="${aula.id}">${aula.nombre}</option>
					</c:forEach>
				</select>
			
			<!-- Fecha del dia -->
			<div class="form-group mt-4">
				<label class="text-secondary font-weight-bold" for="fechaDia">Fecha</label>
				<input type="date" class="form-control" name="fechaDia" id="fechaDia" required>
			</div>
			
			<!-- Boton enviar formulario -->
			<div class="botonEnviar mt-4">
				<button type="submit" class="btn btn-outline-default btn-lg font-weight-bold text-white cice-hover bg-cice">Borrar dia</button>
			</div>
		</form>
		
		
		<div class="pt-5 my-2"></div>
		
		
		<!-- Titulo -->
		<h2 class="pt-3">
			Borrar <span class="badge text-white bg-cice">CURSO</span>
		</h2>
		
		<!-- Forumulario -->
		<form action="borrarCursoControl" method="GET">
		
			<!-- Nombre del curso -->
			<div class="form-group mt-4">
				<label class="text-secondary font-weight-bold" for="nombreCurso">Nombre del curso</label>
				<select	class="form-control" id="nombreCurso" name="nombreCurso" required>
						<option disabled></option>
					<c:forEach items="${cursos}" var="curso">
						<option value="${curso}">${curso}</option>
					</c:forEach>
				</select>
			</div>

			<!-- Boton enviar formulario -->
			<div class="botonEnviar mt-4">
				<button type="submit" class="btn btn-outline-default btn-lg font-weight-bold text-white cice-hover bg-cice">Borrar curso</button>
			</div>
		</form>
			
	</div>

</body>
</html>