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
			Reserva <span class="badge text-white bg-cice">UPDATE</span>
		</h2>
		
		<!-- Forumulario -->
		<form action="updateReservaControl" method="GET">
			
			<!-- Nombre del curso -->
			<div class="form-group mt-4">
				<label class="text-secondary font-weight-bold" for="id">Id</label>
				<input type="text" class="form-control" name="id" id="id" value="${reserva.id}" readonly>
			</div>
			
			<!-- Nombre del curso -->
			<div class="form-group mt-4">
				<label class="text-secondary font-weight-bold" for="nombreCurso">Nombre del curso</label>
				<input type="text" class="form-control" name="nombreCurso" id="nombreCurso" value="${reserva.nombreCurso}" required>
			</div>
			
			<!-- Aula -->
			<div class="form-group mt-4 w-50">
  				<label class="text-secondary font-weight-bold" for="aulaReserva">Aula de la reserva</label>
				<select	class="form-control" id="aulaReserva" name="aulaReserva" required>
					<option selected disabled></option>
				<c:forEach items="${aulas}" var="aula">
					<c:choose>
						<c:when test="${aula.id == reserva.idAula}">
							<option value="${aula.id}" selected>${aula.nombre}</option>
						</c:when>    
    					<c:otherwise>
							<option value="${aula.id}">${aula.nombre}</option>
						</c:otherwise>
					</c:choose>		
				</c:forEach>
				</select>		
			</div>
			
			<!-- Fecha -->
			<div class="form-group mt-4 w-25">
				<label class="text-secondary font-weight-bold" for="diaReserva">Fecha de la reserva</label>
				<input type="date" class="form-control" name="diaReserva" id="diaReserva" value="${fechaReserva}" required>
			</div>
			
			<!-- Horas -->
			<div class="form-group mt-2">
				<p class="text-secondary font-weight-bold">Horas reservadas</p>
				
				<!-- Turno Mañana -->
				<div class="form-check form-check-inline divHoras">
					<c:choose>
						<c:when test="${horas[0] == true}">
    						<input class="form-check-input mr-2 horas" type="radio" id="man09" name="hora" value="9" checked>
    					</c:when>
    					<c:otherwise>
							<input class="form-check-input mr-2 horas" type="radio" id="man09" name="hora" value="9">
						</c:otherwise>
					</c:choose>
					<label class="form-check-label mr-5" for="man09">09:00</label>
					
					<c:choose>
						<c:when test="${horas[1] == true}">
    						<input class="form-check-input mr-2 horas" type="radio" id="man10" name="hora" value="10" checked>
    					</c:when>
    					<c:otherwise>
							<input class="form-check-input mr-2 horas" type="radio" id="man10" name="hora" value="10">
						</c:otherwise>
					</c:choose>
					<label class="form-check-label mr-5" for="man10">10:00</label>
					
					<c:choose>
						<c:when test="${horas[2] == true}">
    						<input class="form-check-input mr-2 horas" type="radio" id="man11" name="hora" value="11" checked>
    					</c:when>
    					<c:otherwise>
							<input class="form-check-input mr-2 horas" type="radio" id="man11" name="hora" value="11">
						</c:otherwise>
					</c:choose>
	  				<label class="form-check-label mr-5" for="man11">11:00</label>

					<c:choose>
						<c:when test="${horas[3] == true}">
    						<input class="form-check-input mr-2 horas" type="radio" id="man12" name="hora" value="12" checked>
    					</c:when>
    					<c:otherwise>
							<input class="form-check-input mr-2 horas" type="radio" id="man12" name="hora" value="12">
						</c:otherwise>
					</c:choose>				
	  				<label class="form-check-label mr-5" for="man12">12:00</label>

					<c:choose>
						<c:when test="${horas[4] == true}">
    						<input class="form-check-input mr-2 horas" type="radio" id="man13" name="hora" value="13" checked>
    					</c:when>
    					<c:otherwise>
							<input class="form-check-input mr-2 horas" type="radio" id="man13" name="hora" value="13">
						</c:otherwise>
					</c:choose>				
	  				<label class="form-check-label mr-5" for="man13">13:00</label>

					<c:choose>
						<c:when test="${horas[5] == true}">
    						<input class="form-check-input mr-2 horas" type="radio" id="man14" name="hora" value="14" checked>
    					</c:when>
    					<c:otherwise>
							<input class="form-check-input mr-2 horas" type="radio" id="man14" name="hora" value="14">
						</c:otherwise>
					</c:choose>				
	  				<label class="form-check-label mr-5" for="man14">14:00</label>
				</div>
				
				<!-- Turno Tarde -->
				<div class="form-check form-check-inline mt-2">
					<c:choose>
						<c:when test="${horas[6] == true}">
    						<input class="form-check-input mr-2 horas" type="radio" id="tar17" name="hora" value="17" checked>
    					</c:when>
    					<c:otherwise>
							<input class="form-check-input mr-2 horas" type="radio" id="tar17" name="hora" value="17">
						</c:otherwise>
					</c:choose>
					<label class="form-check-label mr-5" for="tar17">17:00</label>
					
					<c:choose>
						<c:when test="${horas[7] == true}">
    						<input class="form-check-input mr-2 horas" type="radio" id="tar18" name="hora" value="18" checked>
    					</c:when>
    					<c:otherwise>
							<input class="form-check-input mr-2 horas" type="radio" id="tar18" name="hora" value="18">
						</c:otherwise>
					</c:choose>
					<label class="form-check-label mr-5" for="tar18">18:00</label>
					
					<c:choose>
						<c:when test="${horas[8] == true}">
    						<input class="form-check-input mr-2 horas" type="radio" id="tar19" name="hora" value="19" checked>
    					</c:when>
    					<c:otherwise>
							<input class="form-check-input mr-2 horas" type="radio" id="tar19" name="hora" value="19">
						</c:otherwise>
					</c:choose>
					<label class="form-check-label mr-5" for="tar19">19:00</label>
					
					<c:choose>
						<c:when test="${horas[9] == true}">
    						<input class="form-check-input mr-2 horas" type="radio" id="tar20" name="hora" value="20" checked>
    					</c:when>
    					<c:otherwise>
							<input class="form-check-input mr-2 horas" type="radio" id="tar20" name="hora" value="20">
						</c:otherwise>
					</c:choose>
	  				<label class="form-check-label mr-5" for="tar20">20:00</label>

					<c:choose>
						<c:when test="${horas[10] == true}">
    						<input class="form-check-input mr-2 horas" type="radio" id="tar21" name="hora" value="21" checked>
    					</c:when>
    					<c:otherwise>
							<input class="form-check-input mr-2 horas" type="radio" id="tar21" name="hora" value="21">
						</c:otherwise>
					</c:choose>
	  				<label class="form-check-label mr-5" for="tar21">21:00</label>

					<c:choose>
						<c:when test="${horas[11] == true}">
    						<input class="form-check-input mr-2 horas" type="radio" id="tar22" name="hora" value="22" checked>
    					</c:when>
    					<c:otherwise>
							<input class="form-check-input mr-2 horas" type="radio" id="tar22" name="hora" value="22">
						</c:otherwise>
					</c:choose>
	  				<label class="form-check-label mr-5" for="tar22">22:00</label>
				</div>
			</div>
			
			
			<!-- Boton enviar formulario -->
			<div class="botonEnviar mt-4">
				<button type="submit" class="btn btn-outline-default btn-lg font-weight-bold 
					text-white cice-hover bg-cice">Actualizar</button>
			</div>
		</form>
	</div>

</body>
</html>