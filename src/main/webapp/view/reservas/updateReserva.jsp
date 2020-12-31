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
			Reservar <span class="badge text-white bg-cice">AULA</span>
		</h2>
		
		<!-- Forumulario -->
		<form action="crearReservaControl" method="GET">
			
			
			<!-- Nombre del curso -->
			<div class="form-group mt-4">
				<label class="text-secondary font-weight-bold" for="nombreCurso">Nombre del curso</label>
				<input type="text" class="form-control" name="nombreCurso" id="nombreCurso" placeholder="Nombre del curso" required>
			</div>
			
			<!-- Aula -->
			<div class="form-group mt-4 w-50">
  				<label class="text-secondary font-weight-bold" for="aulaReserva">Aula de la reserva</label>
				<select	class="form-control" id="aulaReserva" name="aulaReserva" required>
					<option selected disabled></option>
				<c:forEach items="${aulas}" var="aula">
					<option value="${aula.id}">${aula.nombre}</option>
				</c:forEach>
				</select>	
			</div>
			
			<!-- Fecha -->
			<div class="form-group mt-4 w-25">
				<label class="text-secondary font-weight-bold" for="diaReserva">Fecha de la reserva</label>
				<input type="date" class="form-control" name="diaReserva" id="diaReserva" placeholder="Fecha de la reserva" required>
			</div>
			
			
			<!-- Horas -->
			<div class="form-group mt-4 w-25">
  				<label class="text-secondary font-weight-bold" for="horaReserva">Hora de la reserva</label>
				<select	class="form-control" id="horaReserva" name="horaReserva" required>
					<option selected disabled></option>
				<c:forEach items="${horas}" var="hora">
					<option value="${hora.value}">${hora.value}</option>
				</c:forEach>
				</select>	
			</div>
			
			<!-- Boton enviar formulario -->
			<div class="botonEnviar mt-4">
				<button type="submit" class="btn btn-outline-default btn-lg font-weight-bold text-white cice-hover bg-cice">Reservar</button>
			</div>
		</form>
	</div>

</body>
</html>