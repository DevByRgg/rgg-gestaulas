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
			Reservar <span class="badge text-white bg-cice">SESION</span>
		</h2>
		
		<!-- Forumulario -->
		<form action="crearReservaMultipleControl" method="GET">
			
			
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
			<div class="form-group mt-4">
				
					<p class="text-secondary font-weight-bold">Horas de la sesion</p>
				
				<div class="form-group">
					<div class="form-check form-check-inline mr-5">
	  					<input class="form-check-input" type="checkbox" id="man09" name="man09" value="true">
	  					<label class="form-check-label" for="man09">09:00</label>
					</div>
					<div class="form-check form-check-inline mr-5">
	  					<input class="form-check-input" type="checkbox" id="man10" name="man10" value="true">
	  					<label class="form-check-label" for="man10">10:00</label>
					</div>
					<div class="form-check form-check-inline mr-5">
	  					<input class="form-check-input" type="checkbox" id="man11" name="man11" value="true">
	  					<label class="form-check-label" for="man11">11:00</label>
					</div>
					<div class="form-check form-check-inline mr-5">
	  					<input class="form-check-input" type="checkbox" id="man12" name="man12" value="true">
	  					<label class="form-check-label" for="man12">12:00</label>
					</div>
					<div class="form-check form-check-inline mr-5">
	  					<input class="form-check-input" type="checkbox" id="man13" name="man13" value="true">
	  					<label class="form-check-label" for="man13">13:00</label>
					</div>
					<div class="form-check form-check-inline mr-5">
	  					<input class="form-check-input" type="checkbox" id="man14" name="man14" value="true">
	  					<label class="form-check-label" for="man14">14:00</label>
					</div>
				</div>
				
				<div class="form-group">
					<div class="form-check form-check-inline mr-5">
	  					<input class="form-check-input" type="checkbox" id="tar17" name="tar17" value="true">
	  					<label class="form-check-label" for="tar17">17:00</label>
					</div>
					<div class="form-check form-check-inline mr-5">
	  					<input class="form-check-input" type="checkbox" id="tar18" name="tar18" value="true">
	  					<label class="form-check-label" for="tar18">18:00</label>
					</div>
					<div class="form-check form-check-inline mr-5">
	  					<input class="form-check-input" type="checkbox" id="tar19" name="tar19" value="true">
	  					<label class="form-check-label" for="tar19">19:00</label>
					</div>
					<div class="form-check form-check-inline mr-5">
	  					<input class="form-check-input" type="checkbox" id="tar20" name="tar20" value="true">
	  					<label class="form-check-label" for="tar20">20:00</label>
					</div>
					<div class="form-check form-check-inline mr-5">
	  					<input class="form-check-input" type="checkbox" id="tar21" name="tar21" value="true">
	  					<label class="form-check-label" for="tar21">21:00</label>
					</div>
					<div class="form-check form-check-inline mr-5">
	  					<input class="form-check-input" type="checkbox" id="tar22" name="tar22" value="true">
	  					<label class="form-check-label" for="tar22">22:00</label>
					</div>
				</div>
			</div>
			
			
			<!-- Boton enviar formulario -->
			<div class="botonEnviar mt-4">
				<button type="submit" class="btn btn-outline-default btn-lg font-weight-bold text-white cice-hover bg-cice">Reservar</button>
			</div>
		</form>
	</div>

</body>
</html>