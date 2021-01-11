<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/functions" prefix = "fn" %>

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
		
		<!-- Forumulario BUSCAR-->
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
						<option value="0" selected>Todas</option>
					<c:forEach items="${tipoAulas}" var="tipoAula">
						<c:choose>
							<c:when test="${tipoAula.id == tipo}">
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
			
			<!-- Boton formulario BUSCAR -->
			<div class="botonEnviar">
				<button type="submit" class="btn btn-outline-default btn-lg font-weight-bold float-right text-white
						 cice-hover bg-cice mt-4 mb-4 btnbuscar" id="btnBuscar" onclick="validar()">Buscar</button>
			</div>
		</form>
		
		<!-- -------------------------------------------------------------------------------------------------------------------- -->
		<!-- ---------------------------------------------------RESERVA---------------------------------------------------------- -->
		<!-- -------------------------------------------------------------------------------------------------------------------- -->
		
		<!-- Forumulario RESERVAR-->
		<form action="realizarReservas" method="GET">
			<div>
				<input type="hidden" name="nombreCurso" value="${nombreCurso}">
				<input type="hidden" name="fechaInicio" value="${fechaInicio}">
				<input type="hidden" name="horasCurso" value="${cantidadHorasCurso}">
				<input type="hidden" name="lunes" value="${semana[0]}">
				<input type="hidden" name="martes" value="${semana[1]}">
				<input type="hidden" name="miercoles" value="${semana[2]}">
				<input type="hidden" name="jueves" value="${semana[3]}">
				<input type="hidden" name="viernes" value="${semana[4]}">
				<input type="hidden" name="sabado" value="${semana[5]}">
				<input type="hidden" name="man09" value="${horas[0]}">
				<input type="hidden" name="man10" value="${horas[1]}">
				<input type="hidden" name="man11" value="${horas[2]}">
				<input type="hidden" name="man12" value="${horas[3]}">
				<input type="hidden" name="man13" value="${horas[4]}">
				<input type="hidden" name="man14" value="${horas[5]}">
				<input type="hidden" name="tar17" value="${horas[6]}">
				<input type="hidden" name="tar18" value="${horas[7]}">
				<input type="hidden" name="tar19" value="${horas[8]}">
				<input type="hidden" name="tar20" value="${horas[9]}">
				<input type="hidden" name="tar21" value="${horas[10]}">
				<input type="hidden" name="tar22" value="${horas[11]}">
				<input type="hidden" name="tipoAula" value="${tipo}">
				<input type="hidden" name="capacidadAula" value="${capacidadAula}">
			</div>
				
			<table class="table table-sm table-bordered">
  				<thead class="bg-cice text-white">
    				<tr>
      					<th scope="col" class="text-center"></th>
      					<th scope="col" class="text-center">Aulas</th>
      					<th scope="col" class="text-center">Sede</th>
      					<th scope="col" class="text-center">Tipo</th>
      					<th scope="col" class="text-center">Coincidencias</th>
      					<th scope="col" class="text-center">Fecha final curso</th>	
      				</tr>
				</thead>
  				
  				<tbody>
    			<!-- Aulas validas -->
    			<c:forEach items="${aulasValidas}" var="aulasValida">
					<tr>
	      				<th scope="row" class="align-top text-dark bg-cice-ok text-center">
	      					<input type="radio" name="aulaSeleccionada" id="${aulasValida.idAula}" value="${aulasValida.idAula}" required>
	      				</th>
					
						<td class="align-middle text-dark bg-cice-ok text-center">
    							${aulasValida.nombreAula}
						</td>
						
						<td class="align-middle text-dark bg-cice-ok text-center">
							${aulasValida.nombreSede}
    					</td>
													
						<td class="align-middle text-dark bg-cice-ok text-center">
							${aulasValida.nombreTipoAula}
						</td>
						
						<td class="align-middle text-dark bg-cice-ok text-center">
							${aulasValida.coincidencias}
						</td>
						
						<td class="align-middle text-dark bg-cice-ok text-center">
							${fechaFinal}
						</td>
					</tr>
				</c:forEach>
				<!-- Aulas No validas -->
				<c:forEach items="${aulasNoValidas}" var="aulasNoValida">
					<tr>
	      				<th scope="row" class="align-top text-dark bg-cice-fail text-center">
	      					<input type="radio" name="aula" id="${aulasNoValida.idAula}" value="${aulasNoValida.idAula}" required disabled>
	      				</th>
						
						<td class="align-middle text-dark bg-cice-fail text-center">
							${aulasNoValida.nombreAula}
						</td>
						
						<td class="align-middle text-dark bg-cice-fail text-center">
							${aulasNoValida.nombreSede}
						</td>
						
						<td class="align-middle text-dark bg-cice-fail text-center">
							${aulasNoValida.nombreTipoAula}
						</td>
						
						<td class="align-middle text-dark bg-cice-fail text-center">
							${aulasNoValida.coincidencias}
						</td>
						
						<td class="align-middle text-dark bg-cice-fail text-center"></td>
					</tr>
				</c:forEach>
				</tbody>
			</table>
										
			<c:choose>
				<c:when test="${not empty numeroReservas}">
					<div class="alert alert-secondary">
						<p class="text-center">¡¡ La reserva se ha realizado con exito !!</p>
						<p class="text-center">Se han reservado ${numeroReservas} horas</p>
					</div>
				</c:when>    
    			<c:otherwise>
				</c:otherwise>
			</c:choose>		
			
			<!-- Boton formulario RESERVAR-->
			<div class="botonEnviar">
				<button type="submit" class="btn btn-outline-default btn-lg font-weight-bold float-right text-white 
					cice-hover bg-cice mt-4 mb-4">Reservar</button>
			</div>	
		</form>
	</div>

	
	
<script src="/aulas/js/validarCheckbox.js"></script>

</body>
</html>