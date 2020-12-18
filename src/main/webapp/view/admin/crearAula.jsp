<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

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
			Aulas <span class="badge badge-secondary text-white" style="background-color: #ff00f7;">CREAR</span>
		</h2>
		
		<!-- Forumulario -->
		<form action="crearAulaControl" method="GET">
			
			<!-- Sede del Aula -->
			<div class="form-group w-25 mt-1">
				<label class="text-secondary font-weight-bold" for="idSede">Sede del aula</label>
				<select	class="form-control" id="idSede" name="idSede">
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
				<select	class="form-control" id="equipoProfesor" name="equipoProfesor">
					<c:forEach items="${ordenadores}" var="ordenador">
						<option value="${ordenador.id}">${ordenador.nombre}</option>
					</c:forEach>
				</select>
			</div>
			
			<!-- Equipo alumnos -->
			<div class="form-group w-50 mt-1">
				<label class="text-secondary font-weight-bold" for="equipoAlumno">Equipo alumnos</label>
				<select	class="form-control" id="equipoAlumno" name="equipoAlumno">
					<c:forEach items="${ordenadores}" var="ordenador">
						<option value="${ordenador.id}">${ordenador.nombre}</option>
					</c:forEach>
				</select>
			</div>
			
			<!-- Equipamiento -->
			<div class="form-group mt-1">
				<label class="text-secondary font-weight-bold" for="equipamiento">Equipamiento</label>
				<select	class="form-control " id=""equipamiento"" name=""equipamiento"">
					<c:forEach items="${equipamientos}" var="equipamiento">
						<option value="${equipamiento.id}">${equipamiento.nombre}</option>
					</c:forEach>
				</select>
			</div>
			
			<!-- Boton enviar formulario -->
			<div class="botonEnviar mt-4">
				<button type="submit" class="btn btn-outline-secondary btn-lg font-weight-bold">Crear</button>
			</div>
		</form>
	</div>

</body>
</html>