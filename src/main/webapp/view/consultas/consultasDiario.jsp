<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="ES">
<head>


<c:import url="../common/head.jsp"/>

		
<title>Consultar</title>

</head>
<body>


<c:import url="../common/navbarPortatil.jsp"/>


	<div class="container-md w-100">
		<div class="pt-5"></div>
		
		<!-- Titulo -->
		<h3 class="pt-2">Consultar <span class="badge text-white bg-cice">DIARIO</span></h3>
		
		<!-- Aqui  va el formulario para los filtros -->
		<form class="form-group" action="filtrarAulasDisponibles" method="GET">
			
			<div class="form-group mt-2">
				<label class="font-weight-bold mr-3" for="fecha">Fecha</label>
				<input type="date" class="form-control-sm mr-4" name="fecha" id="fecha" required>
			</div>
			
			<div class="form-group float-left">
				<label class="font-weight-bold mr-3" for="aula">Aula</label>
	  			<select	class="form-control-sm mr-4" id="aula" name="aula" required>
					<option value="-1" disabled></option>
				<c:forEach items="${aulas}" var="aula">
					<option value="${aula.id}">${aula.nombre}</option>
				</c:forEach>
				</select>
	  		</div>
	  		
	  		<div class="form-group float-right">
				<button type="submit" class="btn btn-sm font-weight-bold text-white cice-hover bg-cice float-right mr-5">Filtrar</button>
			</div>
	  		
		</form>
		
		<!-- Aqui  va la tabla -->
			<div class="container-md w-100">	
				<table class="table table-sm table-striped">
  					<thead class="bg-cice text-white">
    					<tr>
      						<th scope="col">Hora</th>
      						<th scope="col">Fecha</th>
      					</tr>
					</thead>
  					
  					<tbody>
    				<c:forEach items="${horasDisponibles}" var="horaDisponible">
						<tr>
	      					<td class="align-middle text-left">
								<label class="form-check-label" for="${horaDisponible.key}">
    								${horaDisponible.key}
								</label>
							</td>
							
							<td class="align-middle text-left">
								<label class="form-check-label" for="${horaDisponible.value}">
    								${horaDisponible.value}
    							</label>
    							
    							<c:choose>
									<c:when test="${horaDisponible.value == 1}">
										<td class="align-middle text-center bg-cice-fail"></td>
									</c:when>
									<c:when test="${horaDisponible.value == 2}">
										<td class="align-middle text-center bg-cice-ok"></td>
									</c:when>
									<c:otherwise>
										<td class="align-middle text-center bg-secondary"></td>
									</c:otherwise>
								</c:choose>
    						</td>
    					</tr>	
					</c:forEach>
					</tbody>
				</table>
			</div>
	

</body>
</html>