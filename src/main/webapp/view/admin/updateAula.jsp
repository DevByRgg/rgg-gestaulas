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
			Aula <span class="badge text-white bg-cice">UPDATE</span>
		</h2>
		
		<!-- Forumulario -->
		<form action="updateAulaControl" method="GET">
			
			<!-- Nombre -->
			<div class="form-group mt-4">
				<label class="text-secondary font-weight-bold" for="id">Id</label>
				<input type="text" class="form-control" name="id" id="id" placeholder="Nombre" value="${aula.id}" readonly>
			</div>
			
			<!-- Nombre -->
			<div class="form-group mt-4">
				<label class="text-secondary font-weight-bold" for="nombre">Nombre</label>
				<input type="text" class="form-control" name="nombre" id="nombre" placeholder="Nombre" value="${aula.nombre}" required>
			</div>
			
			<!-- Tipo -->
			<div class="form-group w-50 mt-1">
				<label class="text-secondary font-weight-bold" for="tipo">Tipo de Aula</label>
				<select	class="form-control" id="tipo" name="tipo" required>
						<option disabled></option>
					<c:forEach items="${tipoAulas}" var="tipoAula">
						<c:choose>
							<c:when test="${tipoAula.id == aula.tipo}">
								<option value="${tipoAula.id}" selected>${tipoAula.nombre}</option>
							</c:when>    
    						<c:otherwise>
								<option value="${tipoAula.id}">${tipoAula.nombre}</option>
							</c:otherwise>
						</c:choose>		
					</c:forEach>
				</select>
			</div>
			
			
			<!-- Sede del Aula -->
			<div class="form-group w-25 mt-1">
				<label class="text-secondary font-weight-bold" for="sede">Sede del aula</label>
				<select	class="form-control" id="sede" name="sede" required>
					<c:forEach items="${sedes}" var="sede">
						<c:choose>
							<c:when test="${sede.id == aula.sede}">
								<option value="${sede.id}" selected>${sede.nombre}</option>
							</c:when>    
    						<c:otherwise>
								<option value="${sede.id}">${sede.nombre}</option>
							</c:otherwise>
						</c:choose>		
					</c:forEach>
				</select>
			</div>
			
			<!-- Numero de puestos -->
			<div class="form-group w-25 mt-4">
				<label class="text-secondary font-weight-bold" for="capacidad">Capacidad</label>
				<input type="number" class="form-control" name="capacidad" id="capacidad" value="${aula.capacidad}" required>
			</div>
			
			<!-- Equipo profesor -->
			<div class="form-group w-50 mt-1">
				<label class="text-secondary font-weight-bold" for="equipoProfesor">Equipo profesor</label>
				<select	class="form-control" id="equipoProfesor" name="equipoProfesor" required>
					<c:forEach items="${ordenadores}" var="ordenador">
						<c:choose>
							<c:when test="${ordenador.id == aula.equipoProfesor}">
								<option value="${ordenador.id}" selected>${ordenador.nombre}</option>
							</c:when>    
    						<c:otherwise>
								<option value="${ordenador.id}">${ordenador.nombre}</option>
							</c:otherwise>
						</c:choose>		
					</c:forEach>
				</select>
			</div>
			
			<!-- Equipo alumnos -->
			<div class="form-group w-50 mt-1">
				<label class="text-secondary font-weight-bold" for="equipoAlumno">Equipo alumnos</label>
				<select	class="form-control" id="equipoAlumno" name="equipoAlumno" required>
					<c:forEach items="${ordenadores}" var="ordenador">
						<c:choose>
							<c:when test="${ordenador.id == aula.equipoAlumno}">
								<option value="${ordenador.id}" selected>${ordenador.nombre}</option>
							</c:when>    
    						<c:otherwise>
								<option value="${ordenador.id}">${ordenador.nombre}</option>
							</c:otherwise>
						</c:choose>
					</c:forEach>
				</select>
			</div>
			
			<!-- Equipamiento -->
			<div class="form-group mt-1">
				<label class="text-secondary font-weight-bold" for="equipamiento">Equipamiento</label>
				<select	class="form-control " id="equipamiento" name="equipamiento" selected="${aula.equipoAlumno}" required>
					<c:forEach items="${equipamientos}" var="equipamiento">
						<c:choose>
							<c:when test="${equipamiento.id == aula.equipamiento}">
								<option value="${equipamiento.id}" selected>${equipamiento.nombre}</option>
							</c:when>    
    						<c:otherwise>
								<option value="${equipamiento.id}">${equipamiento.nombre}</option>
							</c:otherwise>
						</c:choose>
					</c:forEach>
				</select>
			</div>
			
			<!-- Boton enviar formulario -->
			<div class="botonEnviar mt-4">
				<button type="submit" class="btn btn-lg font-weight-bold text-white cice-hover bg-cice">Actualizar</button>
			</div>
		</form>
	</div>

</body>
</html>