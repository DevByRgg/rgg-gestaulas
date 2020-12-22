<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="ES">
<head>


<c:import url="../common/head.jsp"/>

		
<title>Realizar reservas</title>

</head>
<body>

<c:import url="../common/navbarAdmin.jsp"/>
	
	<div class="container-md w-50">
		<div class="pt-5"></div>
		
		<!-- Titulo -->
		<h2 class="pt-3">
			Reservar <span class="badge text-white bg-cice">AULAS</span>
		</h2>
		
		<!-- Forumulario -->
		<form action="crearReservaControl" method="GET">
			
			
			<!-- Nombre del curso -->
			<div class="form-group mt-4">
				<label class="text-secondary font-weight-bold" for="nombreCurso">Nombre del curso</label>
				<input type="text" class="form-control" name="nombreCurso" id="nombreCurso" placeholder="Nombre del curso" required>
			</div>
			
			
			<!-- Fecha de inicio -->
			<div class="form-group mt-4 w-25">
				<label class="text-secondary font-weight-bold" for="fechaInicio">Fecha de inicio</label>
				<input type="date" class="form-control" name="fechaInicio" id="fechaInicio" placeholder="Fecha de inicio" required>
			</div>
			
			
			<!-- Dias de la semana -->
			<div class="form-group mt-4">
  				<p class="text-secondary font-weight-bold">Dias lectivos</p>
  				
  				<div class="form-check form-check-inline">
  					<input class="form-check-input" type="checkbox" id="lunes" value="lunes">
  					<label class="form-check-label mr-4" for="lunes">Lunes</label>
  				
  					<input class="form-check-input" type="checkbox" id="martes" value="martes">
  					<label class="form-check-label mr-4" for="martes">Martes</label>
  				
  					<input class="form-check-input" type="checkbox" id="miercoles" value="miercoles">
  					<label class="form-check-label mr-4" for="miercoles">Miercoles</label>
  					
  					<input class="form-check-input" type="checkbox" id="jueves" value="jueves">
  					<label class="form-check-label mr-4" for="jueves">Jueves</label>
  				
  					<input class="form-check-input" type="checkbox" id="viernes" value="viernes">
  					<label class="form-check-label mr-4" for="viernes">Viernes</label>
  				
  					<input class="form-check-input" type="checkbox" id="sabado" value="sabado">
  					<label class="form-check-label mr-4" for="sabado">Sabado</label>
				</div>
			</div>

			
			<!-- Turno -->
			<div class="form-group mt-4">
  				<p class="text-secondary font-weight-bold">Turno lectivo</p>
  				
  				<div class="custom-control custom-radio custom-control-inline">
  					<input type="radio" id="turnoManana" name="turno" class="custom-control-input">
  					<label class="custom-control-label" for="turnoManana">Turno de Mañana</label>
				</div>
				
				<div class="custom-control custom-radio custom-control-inline">
  					<input type="radio" id="turnoTarde" name="turno" class="custom-control-input">
  					<label class="custom-control-label" for="turnoTarde">Turno de Tarde</label>
				</div>
				
			</div>
			
			
			<!-- Horas curso -->
			<div class="form-row mt-4">
    			<div class="form-group col-md-5 mr-3">
      				<label class="text-secondary font-weight-bold" for="horasDia" min="1" max="8">Horas diarias</label>
      				<input type="number" class="form-control" id="horasDia" placeholder="Horas diarias">
    			</div>
    
    			<div class="form-group col-md-5 mr-3">
      				<label class="text-secondary font-weight-bold" for="horasCurso">Horas curso</label>
      				<input type="number" class="form-control" id="horasCurso" placeholder="Horas curso">
    			</div>
  			</div>
			
			
			<div class="form-row mt-4">
				
				<!-- Tipo Aula -->
				<div class="form-group col-md-7 mr-3">
					<label class="text-secondary font-weight-bold" for="tipoAula">Tipo de aula</label>
					<input type="text" class="form-control" name="tipoAula" id="tipoAula" placeholder="Tipo de aula" required>
				</div>
			
				<!-- Capacidad del Aula -->
				<div class="form-group col-md-3 mr-3">
					<label class="text-secondary font-weight-bold" for="capacidadAula">Capacidad del Aula</label>
					<input type="number" class="form-control" name="capacidadAula" id="capacidadAula" placeholder="Capacidad" required>
				</div>
			
			</div>
			
			
			<!-- Boton enviar formulario -->
			<div class="botonEnviar mt-4">
				<button type="submit" class="btn btn-outline-default btn-lg font-weight-bold text-white bg-cice">Reservar</button>
			</div>
		</form>
	</div>

</body>
</html>