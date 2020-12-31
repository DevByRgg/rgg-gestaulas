<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="ES">
<head>


<c:import url="../common/head.jsp"/>

		
<title>Reservas</title>

</head>
<body>

<c:import url="../common/navbarAdmin.jsp"/>
	
	<div class="container-md w-50">
		<div class="pt-5"></div>
		
		<!-- Titulo -->
		<h2 class="pt-3">
			Busqueda <span class="badge text-white bg-cice">AULAS</span>
		</h2>
		
		<!-- Forumulario -->
		<form action="buscarReservaControl" method="GET">
			
			
			<!-- Nombre del curso -->
			<div class="form-group mt-4">
				<label class="text-secondary font-weight-bold" for="nombreCurso">Nombre del curso</label>
				<input type="text" class="form-control" name="nombreCurso" id="nombreCurso" required>
			</div>
			
			
			<!-- Fecha de inicio -->
			<div class="form-group mt-4 w-25">
				<label class="text-secondary font-weight-bold" for="fechaInicio">Fecha de inicio</label>
				<input type="date" class="form-control" name="fechaInicio" id="fechaInicio" required>
			</div>
			
			 <!-- Duracion curso -->
			<div class="form-row mt-4">
    			<div class="form-group w-25 mr-5">
      				<label class="text-secondary font-weight-bold" for="horasCurso">Duracion del curso (horas)</label>
      				<input type="number" class="form-control" name="horasCurso" id="horasCurso" required>
    			</div>
    			
    			<div class="form-group w-25 ml-5">
      				<label class="text-secondary font-weight-bold" for="horasDia">Horas diarias</label>
      				<input type="number" class="form-control" name="horasDia" id="horasDia" min="1" max="12" required>
    			</div>
  			</div>
  			
			<!-- Dias lectivos -->
			<div class="form-group mt-3">
  				<p class="text-secondary font-weight-bold">Dias lectivos</p>
  				
  				<div class="form-check form-check-inline">
  					<input class="form-check-input" type="checkbox" id="lunes" name="lunes" value="true">
  					<label class="form-check-label mr-4" for="lunes">Lunes</label>
  				
  					<input class="form-check-input" type="checkbox" id="martes" name="martes" value="true">
  					<label class="form-check-label mr-4" for="martes">Martes</label>
  				
  					<input class="form-check-input" type="checkbox" id="miercoles" name="miercoles" value="true">
  					<label class="form-check-label mr-4" for="miercoles">Miercoles</label>
  					
  					<input class="form-check-input" type="checkbox" id="jueves" name="jueves" value="true">
  					<label class="form-check-label mr-4" for="jueves">Jueves</label>
  				
  					<input class="form-check-input" type="checkbox" id="viernes" name="viernes" value="true">
  					<label class="form-check-label mr-4" for="viernes">Viernes</label>
  				
  					<input class="form-check-input" type="checkbox" id="sabado" name="sabado" value="true">
  					<label class="form-check-label mr-4" for="sabado">Sabado</label>
  				</div>
			</div>


			
<!-- Horas -->
			<div class="form-group mt-3">
				
					<p class="text-secondary font-weight-bold">Horas reservadas</p>
				
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
			   
			
			
			<div class="form-row mt-4">
				<!-- Tipo Aula -->
				<div class="form-group col-md-7 mr-3">
					<label class="text-secondary font-weight-bold" for="tipoAula">Tipo de Aula</label>
					<select	class="form-control" id="tipoAula" name="tipoAula" required>
							<option selected disabled></option>
						<c:forEach items="${tipoAulas}" var="tipoAula">
							<option value="${tipoAula.id}">${tipoAula.nombre}</option>
						</c:forEach>
					</select>
				</div>
			
				<!-- Capacidad del Aula -->
				<div class="form-group col-md-3 mr-3">
					<label class="text-secondary font-weight-bold" for="capacidadAula">Capacidad del Aula</label>
					<input type="number" class="form-control" name="capacidadAula" id="capacidadAula" required>
				</div>
			
			</div>
			
			<!-- Boton enviar formulario -->
			<div class="botonEnviar mt-4">
				<button type="submit" class="btn btn-outline-default btn-lg font-weight-bold text-white bg-cice">Buscar</button>
			</div>
		</form>
	</div>

</body>
</html>