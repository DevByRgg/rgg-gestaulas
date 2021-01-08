<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="ES">
<head>


<c:import url="../common/head.jsp"/>

		
<title>Consultar</title>

</head>
<body>

<c:import url="../common/navbarAdmin.jsp"/>
	
	<div class="container-md w-50">
		<div class="pt-5"></div>
		
		<!-- Titulo -->
		<h2 class="pt-3">Consultar <span class="badge text-white bg-cice">AULA</span></h2>
		
		<!-- Aqui  va el formulario para los filtros -->
		<form class=form-inline" action="filtrarAulasDisponibles" method="GET">
			<div class="form-group mt-3">
				<label class="font-weight-bold mr-3" for="sede">Sede</label>
	  			<select	class="w-25 form-control-sm mr-4" id="sede" name="sede" required>
					<option value="-1" selected></option>
				<c:forEach items="${sedes}" var="sede">
					<c:choose>
						<c:when test="${sede.id == sedeSeleccionada}">
							<option value="${sede.id}" selected>${sede.nombre}</option>
						</c:when>    
	    				<c:otherwise>
							<option value="${sede.id}">${sede.nombre}</option>
						</c:otherwise>
					</c:choose>		
				</c:forEach>
				</select>
	  				
				<label class="font-weight-bold mr-3" for=""tipo"">Tipo de Aula</label>
	  			<select	class="w-25 form-control-sm mr-4" id=""tipo"" name="tipo" required>
					<option value="-1" selected></option>
				<c:forEach items="${tipoAulas}" var="tipoAulas">
					<c:choose>
						<c:when test="${tipoAulas.id == tipoSeleccionado}">
							<option value="${tipoAulas.id}" selected>${tipoAulas.nombre}</option>
						</c:when>    
	    				<c:otherwise>
							<option value="${tipoAulas.id}">${tipoAulas.nombre}</option>
						</c:otherwise>
					</c:choose>		
				</c:forEach>
				</select>			
			</div>
			
			<div class="form-group mt-2">
				<label class="font-weight-bold mr-3" for="mes">Mes</label>
	  			<select	class="form-control-sm text-capitalize mr-4" id="mes" name="mes" required>
					<option selected disabled></option>
				<c:forEach items="${meses}" var="mes">
					<c:choose>
						<c:when test="${mes.key == mesSeleccionado}">
							<option class="text-capitalize" value="${mes.key}" selected>${mes.value}</option>
						</c:when>    
	    				<c:otherwise>
							<option class="text-capitalize" value="${mes.key}">${mes.value}</option>
						</c:otherwise>
					</c:choose>		
				</c:forEach>
				</select>
	  				
				<label class="font-weight-bold mr-3" for="anio">Año</label>
	  			<select	class="form-control-sm mr-4" id="anio" name="anio" required>
					<option selected disabled></option>
				<c:forEach items="${anios}" var="anio">
					<c:choose>
						<c:when test="${anio.value == anioSeleccionado}">
							<option value="${anio.value}" selected>${anio.value}</option>
						</c:when>    
	    				<c:otherwise>
							<option value="${anio.value}">${anio.value}</option>
						</c:otherwise>
					</c:choose>		
				</c:forEach>
				</select>
					
				<label class="font-weight-bold mr-3" for="turno">Turno</label>
	  			<select	class="form-control-sm mr-4" id="turno" name="turno" required>
						<option value="0" selected></option>
					<c:choose>
						<c:when test="${turnoSeleccionado == 1}">
							<option value="1" selected>Mañana</option>
						</c:when>    
	    				<c:otherwise>
							<option value="1">Mañana</option>
						</c:otherwise>
					</c:choose>
					
					<c:choose>
						<c:when test="${turnoSeleccionado == 2}">
							<option value="2" selected>Tarde</option>
						</c:when>    
	    				<c:otherwise>
							<option value="2">Tarde</option>
						</c:otherwise>
					</c:choose>	
				</select>	

				<button type="submit" class="btn btn-sm font-weight-bold text-white cice-hover bg-cice float-right mr-5">Filtrar</button>


			</div>
		</form>
		<!-- Aqui  va el formulario para los filtros -->
		
		<!-- Opciones -->
		<div class="pt-3">
			<form action="verHorarioAula" method="GET">
				<input type="hidden" name="mes" value="${mesSeleccionado}">
				<input type="hidden" name="anio" value="${anioSeleccionado}">
				<input type="hidden" name="turno" value="${turnoSeleccionado}">
				
				
				<table class="table table-sm table-hover">
  					<thead class="bg-cice text-white">
    					<tr>
      						<th scope="col" class="text-center"></th>
      						<th scope="col">Aulas</th>
      						<th scope="col">Sede</th>
      						<th scope="col">Tipo</th>
      					</tr>
					</thead>
  					
  					<tbody>
    				<c:forEach items="${aulasDisponibles}" var="aulaDisponible">
						<tr>
	      					<th scope="row" class="align-top text-center">
	      						<input type="radio" name="aula" id="${aulaDisponible.idAula}" value="${aulaDisponible.idAula}" required>
	      					</th>
						
							<td class="align-middle text-left">
								<label class="form-check-label" for="${aulaDisponible.nombreAula}">
    								${aulaDisponible.nombreAula}
								</label>
							</td>
							
							<td class="align-middle text-left">
								<label class="form-check-label" for="${aulaDisponible.nombreSede}">
    								${aulaDisponible.nombreSede}
    							</label>
							</td>
							
							<td class="align-middle text-left">
								<label class="form-check-label" for="${aulaDisponible.nombreTipoAula}">
    								${aulaDisponible.nombreTipoAula}
								</label>
							</td>
						</tr>
					</c:forEach>
					</tbody>
				</table>
				
				<!-- Boton enviar formulario -->
				<div class="form-group float-right">
					<button type="submit" class="btn btn-sm font-weight-bold text-white cice-hover bg-cice float-right mr-5">Seleccionar</button>
				</div>
			
			</div>
						
				
									
  			
			</form>

		</div>
		
		
	</div>

</body>
</html>