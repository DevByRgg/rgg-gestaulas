<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/functions" prefix = "fn" %>

<!DOCTYPE html>
<html lang="ES">
<head>


<c:import url="../common/head.jsp"/>

		
<title>Zona Administracion - Crear Aula</title>

</head>
<body>


<c:import url="../common/navbarAdmin.jsp"/>

	
	<div class="container-md w-50">
		<div class="pt-5"></div>
		
		<!-- Titulo -->
		<h2 class="pt-3">
			Aula <span class="badge text-white bg-cice">CREAR</span>
		</h2>
		
		<!-- Forumulario -->
		<form action="crearAulaControl" method="GET">
			
			<!-- Nombre -->
			<div class="form-group mt-4">
				<label class="text-secondary font-weight-bold" for="nombre">Nombre</label>
				<input type="text" class="form-control" name="nombre" id="nombre" placeholder="Nombre" required>
			</div>
			
			<!-- Tipo -->
			<div class="form-group w-50 mt-1">
				<label class="text-secondary font-weight-bold" for="tipo">Tipo de Aula</label>
				<select	class="form-control" id="tipo" name="tipo" required>
					<option selected disabled></option>
					<c:forEach items="${tipoAulas}" var="tipoAula">
						<option value="${tipoAula.id}">${tipoAula.nombre}</option>
					</c:forEach>
				</select>
			</div>
			
			
			<!-- Sede del Aula -->
			<div class="form-group w-25 mt-1">
				<label class="text-secondary font-weight-bold" for="sede">Sede del aula</label>
				<select	class="form-control" id="sede" name="sede" required>
						<option selected disabled></option>
					<c:forEach items="${sedes}" var="sede">
						<option value="${sede.id}">${sede.nombre}</option>
					</c:forEach>
				</select>
			</div>
			
			<!-- Numero de puestos -->
			<div class="form-group w-25 mt-4">
				<label class="text-secondary font-weight-bold" for="capacidad">Capacidad</label>
				<input type="number" class="form-control" name="capacidad" id="capacidad" placeholder="Capacidad" required>
			</div>
			
			<!-- Equipo profesor -->
			<div class="form-group w-50 mt-1">
				<label class="text-secondary font-weight-bold" for="equipoProfesor">Equipo profesor</label>
				<select	class="form-control" id="equipoProfesor" name="equipoProfesor" required>
						<option selected disabled></option>
					<c:forEach items="${ordenadores}" var="ordenador">
						<option value="${ordenador.id}">${ordenador.nombre}</option>
					</c:forEach>
				</select>
			</div>
			
			<!-- Equipo alumnos -->
			<div class="form-group w-50 mt-1">
				<label class="text-secondary font-weight-bold" for="equipoAlumno">Equipo alumnos</label>
				<select	class="form-control" id="equipoAlumno" name="equipoAlumno" required>
						<option selected disabled></option>
					<c:forEach items="${ordenadores}" var="ordenador">
						<option value="${ordenador.id}">${ordenador.nombre}</option>
					</c:forEach>
				</select>
			</div>
			
			<!-- Equipamiento -->
			<div class="form-group mt-1">
				<label class="text-secondary font-weight-bold" for="equipamiento">Equipamiento</label>
				<select	class="form-control " id="equipamiento" name="equipamiento" required>
						<option selected disabled></option>
					<c:forEach items="${equipamientos}" var="equipamiento">
						<option value="${equipamiento.id}">${equipamiento.nombre}</option>
					</c:forEach>
				</select>
			</div>
			
			<!-- Boton enviar formulario -->
			<div class="botonEnviar mt-4">
				<button type="submit" class="btn btn-lg font-weight-bold text-white cice-hover bg-cice">Crear</button>
			</div>
		</form>
	</div>

</body>
</html>