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
			Buscar <span class="badge text-white bg-cice">AULAS</span>
		</h2>
		
		<!-- Forumulario -->
		<form action="buscarReservaControl" method="GET">
			
			<div class="form-row mt-2">
				<!-- Nombre del curso -->
				<div class="form-group w-50 mr-5">
					<label class="text-secondary font-weight-bold" for="nombreCurso">Nombre del curso</label>
					<input type="text" class="form-control" name="nombreCurso" id="nombreCurso" value="${nombreCurso}" required>
				</div>
			
				<!-- Fecha de inicio -->
				<div class="form-group w-25">
					<label class="text-secondary font-weight-bold" for="fechaInicio">Fecha de inicio</label>
					<input type="date" class="form-control" name="fechaInicio" id="fechaInicio" value="${fechaInicio}" required>
				</div>
			</div>
			
			<div class="form-row mt-2">
				<!-- Duracion curso -->
				<div class="form-group w-25 mr-5">
      				<label class="text-secondary font-weight-bold" for="horasCurso">Duracion del curso (horas)</label>
      				<input type="number" class="form-control" name="horasCurso" id="horasCurso" value="${cantidadHorasCurso}" required>
    			</div>
    			
    			<!-- Tipo Aula -->
				<div class="form-group w-25 mr-5">
					<label class="text-secondary font-weight-bold" for="tipoAula">Tipo de Aula</label>
					<select	class="form-control" id="tipoAula" name="tipoAula" required>
						<option selected disabled></option>
					<c:forEach items="${tipoAulas}" var="tipoAula">
						<c:choose>
							<c:when test="${tipoAula.id == idAula}">
								<option value="${tipoAula.id}" selected>${tipoAula.nombre}</option>
							</c:when>    
    						<c:otherwise>
								<option value="${tipoAula.id}">${tipoAula.nombre}</option>
							</c:otherwise>
						</c:choose>		
					</c:forEach>
					</select>
				</div>
			
				<!-- Capacidad del Aula -->
				<div class="form-group w-25 mr-5">
					<label class="text-secondary font-weight-bold" for="capacidadAula">Capacidad del Aula</label>
					<input type="number" class="form-control" name="capacidadAula" id="capacidadAula" value="${capacidadAula}" required>
				</div>
  			</div>
  			
			<!-- Dias lectivos -->
			<div class="form-group mt-2">
  				<p class="text-secondary font-weight-bold">Dias lectivos</p>
  				
  				<div class="form-check form-check-inline">
  					<c:choose>
    					<c:when test="${semana[0] == true}">
    						<input class="form-check-input mr-2 dias" type="checkbox" id="lunes" name="lunes" value="true" checked required>
    					</c:when>
    					<c:otherwise>
							<input class="form-check-input mr-2 dias" type="checkbox" id="lunes" name="lunes" value="true" required>
						</c:otherwise>
					</c:choose>
  					<label class="form-check-label mr-5" for="lunes">Lunes</label>
  					
  					<c:choose>
    					<c:when test="${semana[1] == true}">
    						<input class="form-check-input mr-2 dias" type="checkbox" id="martes" name="martes" value="true" checked>
    					</c:when>
    					<c:otherwise>
							<input class="form-check-input mr-2 dias" type="checkbox" id="martes" name="martes" value="true">
						</c:otherwise>
					</c:choose>
  					<label class="form-check-label mr-5" for="martes">Martes</label>
  				
  					<c:choose>
    					<c:when test="${semana[2] == true}">
    						<input class="form-check-input mr-2 dias" type="checkbox" id="miercoles" name="miercoles" value="true" checked>
    					</c:when>
    					<c:otherwise>
							<input class="form-check-input mr-2 dias" type="checkbox" id="miercoles" name="miercoles" value="true">
						</c:otherwise>
					</c:choose>
  					<label class="form-check-label mr-5" for="miercoles">Miercoles</label>
  					
  					<c:choose>
    					<c:when test="${semana[3] == true}">
    						<input class="form-check-input mr-2 dias" type="checkbox" id="jueves" name="jueves" value="true" checked>
    					</c:when>
    					<c:otherwise>
							<input class="form-check-input mr-2 dias" type="checkbox" id="jueves" name="jueves" value="true">
						</c:otherwise>
					</c:choose>
  					<label class="form-check-label mr-5" for="jueves">Jueves</label>
					  	
					  	<c:choose>
    					<c:when test="${semana[4] == true}">
    						<input class="form-check-input mr-2 dias" type="checkbox" id="viernes" name="viernes" value="true" checked>
    					</c:when>
    					<c:otherwise>
							<input class="form-check-input mr-2 dias" type="checkbox" id="viernes" name="viernes" value="true">
						</c:otherwise>
					</c:choose>
  					<label class="form-check-label mr-5" for="viernes">Viernes</label>
  						
  					<c:choose>
    					<c:when test="${semana[5] == true}">
    						<input class="form-check-input mr-2" type="checkbox" id="sabado" name="sabado" value="true" checked>
    					</c:when>
    					<c:otherwise>
							<input class="form-check-input mr-2" type="checkbox" id="sabado" name="sabado" value="true">
						</c:otherwise>
					</c:choose>
  					<label class="form-check-label mr-5" for="sabado">Sabado</label>
  				</div>
			</div>
			
			<!-- Horas -->
			<div class="form-group mt-2">
				<p class="text-secondary font-weight-bold">Horas reservadas</p>
				
				<!-- Turno Mañana -->
				<div class="form-check form-check-inline">
					<c:choose>
						<c:when test="${horas[0] == true}">
    						<input class="form-check-input mr-2" type="checkbox" id="man09" name="man09" value="true" checked required>
    					</c:when>
    					<c:otherwise>
							<input class="form-check-input mr-2" type="checkbox" id="man09" name="man09" value="true" required>
						</c:otherwise>
					</c:choose>
					<label class="form-check-label mr-5" for="man09">09:00</label>
					
					<c:choose>
						<c:when test="${horas[1] == true}">
    						<input class="form-check-input mr-2" type="checkbox" id="man10" name="man10" value="true" checked>
    					</c:when>
    					<c:otherwise>
							<input class="form-check-input mr-2" type="checkbox" id="man10" name="man10" value="true">
						</c:otherwise>
					</c:choose>
					<label class="form-check-label mr-5" for="man10">10:00</label>
					
					<c:choose>
						<c:when test="${horas[2] == true}">
    						<input class="form-check-input mr-2" type="checkbox" id="man11" name="man11" value="true" checked>
    					</c:when>
    					<c:otherwise>
							<input class="form-check-input mr-2" type="checkbox" id="man11" name="man11" value="true">
						</c:otherwise>
					</c:choose>
	  				<label class="form-check-label mr-5" for="man11">11:00</label>

					<c:choose>
						<c:when test="${horas[3] == true}">
    						<input class="form-check-input mr-2" type="checkbox" id="man12" name="man12" value="true" checked>
    					</c:when>
    					<c:otherwise>
							<input class="form-check-input mr-2" type="checkbox" id="man12" name="man12" value="true">
						</c:otherwise>
					</c:choose>				
	  				<label class="form-check-label mr-5" for="man12">12:00</label>

					<c:choose>
						<c:when test="${horas[4] == true}">
    						<input class="form-check-input mr-2" type="checkbox" id="man13" name="man13" value="true" checked>
    					</c:when>
    					<c:otherwise>
							<input class="form-check-input mr-2" type="checkbox" id="man13" name="man13" value="true">
						</c:otherwise>
					</c:choose>				
	  				<label class="form-check-label mr-5" for="man13">13:00</label>

					<c:choose>
						<c:when test="${horas[5] == true}">
    						<input class="form-check-input mr-2" type="checkbox" id="man14" name="man14" value="true" checked>
    					</c:when>
    					<c:otherwise>
							<input class="form-check-input mr-2" type="checkbox" id="man14" name="man14" value="true">
						</c:otherwise>
					</c:choose>				
	  				<label class="form-check-label mr-5" for="man14">14:00</label>
				</div>
				
				<!-- Turno Tarde -->
				<div class="form-check form-check-inline mt-2">
					<c:choose>
						<c:when test="${horas[6] == true}">
    						<input class="form-check-input mr-2" type="checkbox" id="tar17" name="tar17" value="true" checked>
    					</c:when>
    					<c:otherwise>
							<input class="form-check-input mr-2" type="checkbox" id="tar17" name="tar17" value="true">
						</c:otherwise>
					</c:choose>
					<label class="form-check-label mr-5" for="tar17">17:00</label>
					
					<c:choose>
						<c:when test="${horas[7] == true}">
    						<input class="form-check-input mr-2" type="checkbox" id="tar18" name="tar18" value="true" checked>
    					</c:when>
    					<c:otherwise>
							<input class="form-check-input mr-2" type="checkbox" id="tar18" name="tar18" value="true">
						</c:otherwise>
					</c:choose>
					<label class="form-check-label mr-5" for="tar18">18:00</label>
					
					<c:choose>
						<c:when test="${horas[8] == true}">
    						<input class="form-check-input mr-2" type="checkbox" id="tar19" name="tar19" value="true" checked>
    					</c:when>
    					<c:otherwise>
							<input class="form-check-input mr-2" type="checkbox" id="tar19" name="tar19" value="true">
						</c:otherwise>
					</c:choose>
					<label class="form-check-label mr-5" for="tar19">19:00</label>
					
					<c:choose>
						<c:when test="${horas[9] == true}">
    						<input class="form-check-input mr-2" type="checkbox" id="tar20" name="tar20" value="true" checked>
    					</c:when>
    					<c:otherwise>
							<input class="form-check-input mr-2" type="checkbox" id="tar20" name="tar20" value="true">
						</c:otherwise>
					</c:choose>
	  				<label class="form-check-label mr-5" for="tar20">20:00</label>

					<c:choose>
						<c:when test="${horas[10] == true}">
    						<input class="form-check-input mr-2" type="checkbox" id="tar21" name="tar21" value="true" checked>
    					</c:when>
    					<c:otherwise>
							<input class="form-check-input mr-2" type="checkbox" id="tar21" name="tar21" value="true">
						</c:otherwise>
					</c:choose>
	  				<label class="form-check-label mr-5" for="tar21">21:00</label>

					<c:choose>
						<c:when test="${horas[11] == true}">
    						<input class="form-check-input mr-2" type="checkbox" id="tar22" name="tar22" value="true" checked>
    					</c:when>
    					<c:otherwise>
							<input class="form-check-input mr-2" type="checkbox" id="tar22" name="tar22" value="true">
						</c:otherwise>
					</c:choose>
	  				<label class="form-check-label mr-5" for="tar22">22:00</label>
				</div>
			</div>
			
			<!-- Boton enviar formulario -->
			<div class="botonEnviar">
				<button type="submit" class="btn btn-outline-default btn-lg font-weight-bold 
				float-right text-white cice-hover bg-cice mt-4 mb-4 btnbuscar" id="btnBuscar" onclick="validar()">Buscar</button>
			</div>
		</form>
		
		<!-- -------------------------------------------------------------------------------------------------------------------- -->
		<!-- ---------------------------------------------------RESERVA---------------------------------------------------------- -->
		<!-- -------------------------------------------------------------------------------------------------------------------- -->
		
		<form action="seleccionarReservas" method="GET">
			<table class="table">
  				<thead>
    				<tr>
      					<th scope="col" class="text-center"></th>
      					<th scope="col">Aulas</th>
      					<th scope="col">Sede</th>
      					<th scope="col">Tipo</th>
      				</tr>
				</thead>
  				
  				<tbody>
    			<c:forEach items="${aulasValidas}" var="aulasValida">
					<tr>
	      				<th scope="row" class="align-top text-white bg-success text-center">
	      					<input class="form-check-input" type="radio" name="aula" id="${aulasValida.id}" value="${aulasValida.id}" required>
	      				</th>
					
						<td class="align-middle text-white bg-success text-left">
							<label class="form-check-label" for="${aulasValida.id}">
    							${aulasValida.nombre}
							</label>
						</td>
						
						<td class="align-middle text-white bg-success text-left">
							<label class="form-check-label" for="${aulasValida.sede}">
    							${aulasValida.sede}
    						</label>
						</td>
							
						<td class="align-middle text-white bg-success text-left">
							<label class="form-check-label" for="${aulasValida.tipo}">
    							${aulasValida.tipo}
							</label>
						</td>
					</tr>
				</c:forEach>
				<c:forEach items="${aulasNoValidas}" var="aulasNoValida">
					<tr>
	      				<th scope="row" class="align-top text-white bg-danger text-center">
	      					<input class="form-check-input" type="radio" name="aula" id="${aulasNoValida.id}" value="${aulasNoValida.id}" required disabled>
	      				</th>
						
						<td class="align-middle text-white bg-danger text-left">
							<label class="form-check-label" for="${aulasNoValida.id}">
    							${aulasNoValida.nombre}
							</label>
						</td>
							
						<td class="align-middle text-white bg-danger text-left">
							<label class="form-check-label" for="${aulasNoValida.sede}">
    							${aulasNoValida.sede}
							</label>
						</td>
							
						<td class="align-middle text-white bg-danger text-left">
							<label class="form-check-label" for="${aulasNoValida.tipo}">
    							${aulasNoValida.tipo}
							</label>
						</td>
					</tr>
				</c:forEach>
				</tbody>
			</table>
			
			<!-- Boton enviar formulario -->
			<div class="botonEnviar">
				<button type="submit" class="btn btn-outline-default btn-lg font-weight-bold float-right text-white cice-hover bg-cice mt-4 mb-4">Reservar</button>
			</div>

		</form>
		
	</div>

	
<script src="/aulas/js/validarCheckbox.js"></script>

</body>
</html>