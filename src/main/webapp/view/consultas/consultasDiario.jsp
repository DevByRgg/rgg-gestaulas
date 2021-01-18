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
		<div class="container-md w-100">	
			<form class="form-group" action="horarioPortatil" method="GET">
			
				<div class="form-group mt-2">
					<label class="font-weight-bold mr-3" for="fecha">Fecha</label>
					<input type="date" class="form-control-sm mr-4" name="fecha" id="fecha" value="${fechaSel}" required>
				</div>
			
				<div class="form-group float-left">
					<label class="font-weight-bold mr-3" for="aula">Aula</label>
	  				<select	class="form-control-sm mr-4" id="aula" name="aula" required>
					<option value="-1" disabled></option>
				<c:forEach items="${aulas}" var="aula">
					<c:choose>
						<c:when test="${aula.id == aulaSel}">
							<option value="${aula.id}" selected>${aula.nombre}</option>
						</c:when>    
	    				<c:otherwise>
							<option value="${aula.id}">${aula.nombre}</option>
						</c:otherwise>
					</c:choose>		
				</c:forEach>
				</select>
	  			</div>
	  		
	  			<div class="form-group float-right">
					<button type="submit" class="btn btn-sm font-weight-bold text-white cice-hover bg-cice float-right">Filtrar</button>
				</div>
	  		
			</form>
		</div>
		
		
		<!-- Aqui  va la tabla -->
			<div class="container-md w-75">	
				<table class="table table-sm table-striped">
  					<thead class="bg-cice text-white">
    					<tr>
						<c:if test="${fechaSel != null}">
      						<th scope="col" class="align-middle text-center">Hora</th>
      						<th scope="col" class="align-middle text-center">${diaReserva}</th>
						</c:if>
      					</tr>
					</thead>
  					
  					<tbody>
    				<c:forEach items="${objetos}" var="objeto">
						<tr>
	      					<th scope="row" class="align-middle text-center">
								${objeto.hora}
							</th>
							
							<c:choose>
								<c:when test="${objeto.color == 1}">
									<td class="align-middle text-center bg-cice-fail" title="${objeto.nombreCurso}"></td>
								</c:when>
								<c:when test="${objeto.color == 2}">
									<td class="align-middle text-center bg-cice-ok" title="${objeto.nombreCurso}"></td>
								</c:when>
								<c:otherwise>
									<td class="align-middle text-center bg-secondary" title="${objeto.nombreCurso}"></td>
								</c:otherwise>
							</c:choose>
    					</tr>	
					</c:forEach>
					</tbody>
				</table>
			</div>
	

</body>
</html>