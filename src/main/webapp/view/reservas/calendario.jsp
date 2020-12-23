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
	
	<div class="container-md w-75">
		<div class="pt-5"></div>
		
		<!-- Titulo -->
		<h2 class="pt-3">
			Cice <span class="badge text-white bg-cice">CALENDAR</span>
		</h2>
		
		<!-- Forumulario -->
		<form action="crearReservaControl" method="GET">
			
			
			<div class="form-row mt-4">
				<!-- Sede -->	
				<div class="form-group col-md-2 mt-1">
					<label class="text-secondary font-weight-bold" for="idSede">Sede</label>
					<select	class="form-control" id="idSede" name="idSede">
						<c:forEach items="${sedes}" var="sede">
							<option value="${sede.id}">${sede.nombre}</option>
						</c:forEach>
					</select>
				</div>
			
				<!-- Tipo Aula -->
				<div class="form-group col-md-6 mt-1">
					<label class="text-secondary font-weight-bold" for="idAula">Tipo de aula</label>
					<select	class="form-control" id="idAula" name="idAula">
						<c:forEach items="${aulas}" var="aula">
							<option value="${aula.id}">${aula.nombre}</option>
						</c:forEach>
					</select>
				</div>
			
				<!-- Mes -->
				<div class="form-group col-md-2 mt-1">
					<label class="text-secondary font-weight-bold" for="mes">Mes</label>
					<select	class="form-control" id="mes" name="mes" required>
						<c:forEach items="${meses}" var="mes">
							<option value="${mes.key}">${mes.value}</option>
						</c:forEach>
      				</select>
				</div>
				
				<!-- Año -->
				<div class="form-group col-md-2 mt-1">
					<label class="text-secondary font-weight-bold" for="anio">Año</label>
					<select	class="form-control" id="anio" name="anio">
						<c:forEach items="${anios}" var="anio">
							<option>${anio.value}</option>
						</c:forEach>
					</select>
				</div>
			</div>
				
				
			<!-- Turno -->
			<div class="form-group mt-1">
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
			
			<!-- Boton enviar formulario -->
			<div class="botonEnviar mt-4">
				<button type="submit" class="btn btn-outline-default btn-lg font-weight-bold text-white bg-cice">Buscar</button>
			</div>
		</form>
	</div>

</body>
</html>