<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="ES">
<head>


<c:import url="../common/head.jsp"/>

		
<title>Consultar Aulas</title>

</head>
<body>

<c:import url="../common/navbarAdmin.jsp"/>
	
	<div class="container-md w-75">
		<div class="pt-5"></div>
		
		<!-- Titulo -->
		<h2 class="pt-3">Cice <span class="badge text-white bg-cice">CALENDAR</span></h2>
		
		<!-- Forumulario -->
		<form action="elegirAula" method="GET">
			
			
			<div class="row align-items-end mt-4">
				<!-- Sede -->	
				<div class="form-group col-md-2">
					<label class="text-secondary font-weight-bold" for="idSede">Sede</label>
					<select	class="form-control" id="idSede" name="idSede">
						<c:forEach items="${sedes}" var="sede">
							<option value="${sede.id}">${sede.nombre}</option>
						</c:forEach>
					</select>
				</div>
			
				<!-- Tipo Aula -->
				<div class="form-group col-md-3">
					<label class="text-secondary font-weight-bold" for="idAula">Tipo de aula</label>
					<select	class="form-control" id="idAula" name="idAula">
						<c:forEach items="${aulas}" var="aula">
							<option value="${aula.id}">${aula.nombre}</option>
						</c:forEach>
					</select>
				</div>
			
				<!-- Mes -->
				<div class="form-group col-md-2">
					<label class="text-secondary font-weight-bold" for="mes">Mes</label>
					<select	class="form-control" id="mes" name="mes" required>
						<c:forEach items="${meses}" var="mes">
							<option value="${mes.key}">${mes.value}</option>
						</c:forEach>
      				</select>
				</div>
				
				<!-- Año -->
				<div class="form-group col-md-2">
					<label class="text-secondary font-weight-bold" for="anio">Año</label>
					<select	class="form-control" id="anio" name="anio">
						<c:forEach items="${anios}" var="anio">
							<option>${anio.value}</option>
						</c:forEach>
					</select>
				</div>
			
				<!-- Turno -->
				<div class="form-group col-md-2">
					<label class="text-secondary font-weight-bold" for="turno">Turno</label>
					<select	class="form-control" id="turno" name="turno" required>
						<option value="1">Mañana</option>
						<option value="2">Tarde</option>
      				</select>
				</div>	
				
				<!-- Boton enviar formulario -->
				<div class="form-group col-md-1">
					<button type="submit" class="btn font-weight-bold text-white cice-hover bg-cice">Buscar</button>
				</div>
			
			</div>
			
		</form>
		
		<!-- Opciones -->
		<div class="container w-75 pt-3">
			<form action="elegirAulaReservaControl" method="GET">
				<table class="table">
  					<thead>
    					<tr>
      						<th scope="col text-center">#</th>
      						<th scope="col">Aulas busqueda</th>
      						<th scope="col"></th>	
						</tr>
					</thead>
  					
  					<tbody>
    				<c:forEach items="${resAulas}" var="resAula">
						<tr>
	      					<th scope="row" class="align-top text-center">
	      						<input class="form-check-input" type="radio" name="opcion" id="${resAula.id}" value="${resAula.id}">
	      					</th>
						
							<td class="align-middle text-left">
								<label class="form-check-label" for="${resAula.id}">
    								${resAula.nombre}
								</label>
							</td>
							
							<td class="align-middle text-left">
							</td>	
						</tr>
					</c:forEach>
						<tr>
							<th scope="row" class="align-middle text-center"></th>
						
							<td class="align-middle text-left"></td>
							
							<td class="align-middle text-right">
								<button type="submit" class="btn font-weight-bold text-white cice-hover bg-cice">Seleccionar</button>
							</td>	
						</tr>			
  					
  					</tbody>
			</table>
			</form>

		</div>
		
		
	</div>

</body>
</html>