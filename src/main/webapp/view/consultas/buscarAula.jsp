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
		<h2 class="pt-3">Cice <span class="badge text-white bg-cice">CONSULTAR</span></h2>
		
		<!-- Forumulario -->
		<form action="elegirAula" method="GET">
			
			
			<div class="row align-items-end mt-4">
				<!-- Sede -->	
				<div class="form-group col-md-2">
					<label class="text-secondary font-weight-bold" for="sede">Sede</label>
					<select	class="form-control" id="sede" name="sede">
							<option selected value="-1"></option>
						<c:forEach items="${sedes}" var="sede">
							<option value="${sede.id}">${sede.nombre}</option>
						</c:forEach>
					</select>
				</div>
			
				<!-- Tipo Aula -->
				<div class="form-group col-md-3">
					<label class="text-secondary font-weight-bold" for="tipo">Tipo de aula</label>
					<select	class="form-control" id="tipo" name="tipo">
							<option selected value="-1"></option>
						<c:forEach items="${tipoAulas}" var="tipoAula">
							<option value="${tipoAula.id}">${tipoAula.nombre}</option>
						</c:forEach>
					</select>
				</div>
				
				<!-- Boton enviar formulario -->
				<div class="form-group col-md-1">
					<button type="submit" class="btn font-weight-bold text-white cice-hover bg-cice">Buscar</button>
				</div>
			
			</div>
			
		</form>
		
		<!-- Opciones -->
		<div class="pt-3">
			<form action="verHorarioAula" method="GET">
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
    				<c:forEach items="${resAulas}" var="resAula">
						<tr>
	      					<th scope="row" class="align-top text-center">
	      						<input class="form-check-input" type="radio" name="aula" id="${resAula.id}" value="${resAula.id}" required>
	      					</th>
						
							<td class="align-middle text-left">
								<label class="form-check-label" for="${resAula.id}">
    								${resAula.nombre}
								</label>
							</td>
							
							<td class="align-middle text-left">
								<label class="form-check-label" for="${resAula.sede}">
    								${resAula.sede}
							</td>
							
							<td class="align-middle text-left">
								<label class="form-check-label" for="${resAula.tipo}">
    								${resAula.tipo}
								</label>
							</td>
							
							
							
						</tr>
					</c:forEach>
					</tbody>
				</table>
						
				<div class="row align-items-end mt-4">
				
				<!-- Mes -->
				<div class="form-group col-md-2">
					<label class="text-secondary font-weight-bold" for="mes">Mes</label>
					<select	class="form-control text-capitalize" id="mes" name="mes" required>
							<option selected disabled></option>
						<c:forEach items="${meses}" var="mes">
							<option value="${mes.key}">${mes.value}</option>
						</c:forEach>
      				</select>
				</div>
				
				<!-- Año -->
				<div class="form-group col-md-2">
					<label class="text-secondary font-weight-bold" for="anio">Año</label>
					<select	class="form-control" id="anio" name="anio" required>
							<option selected disabled></option>
						<c:forEach items="${anios}" var="anio">
							<option>${anio.value}</option>
						</c:forEach>
					</select>
				</div>
				
				<!-- Boton enviar formulario -->
				<div class="form-group col-md-1">
					<button type="submit" class="btn font-weight-bold text-white cice-hover bg-cice">Seleccionar</button>
				</div>
			
			</div>
						
				
									
  			
			</form>

		</div>
		
		
	</div>

</body>
</html>