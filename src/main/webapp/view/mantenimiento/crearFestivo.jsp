<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html lang="ES">
<head>


<c:import url="../common/head.jsp"/>

		
<title>Mantenimiento</title>

</head>
<body>

<c:import url="../common/navbarAdmin.jsp"/>
	
	<div class="container-md w-50">
		<div class="pt-5"></div>
		
		<!-- Titulo -->
		<h2 class="pt-3">
			Crear <span class="badge text-white bg-cice">FESTIVO</span>
		</h2>
		
		<!-- Forumulario -->
		<form:form action="crearFestivoControl" method="POST" modelAttribute="festivo">
			<form:hidden path="id"/>
			<!-- Nombre del festivo -->
			<div class="form-group mt-4">
				<form:label class="text-secondary font-weight-bold" path="nombre" for="nombre">Nombre del festivo</form:label>
				<form:input class="form-control" path="nombre" id="nombre" required="required"></form:input>
				
				
			</div>
			
			<!-- Fecha del festivo-->
			<div class="form-group mt-4 w-25">
				<form:label class="text-secondary font-weight-bold" path="fecha" for="fecha">Fecha del festivo</form:label>
				<form:input type="date" class="form-control" path="fecha" id="fecha" required="required"></form:input>
				
			</div>

			<!-- Boton enviar formulario -->
			<div class="botonEnviar mt-4">
				<button type="submit" class="btn btn-outline-default btn-lg font-weight-bold text-white cice-hover bg-cice">Crear</button>
			</div>
			
			<div id="erroresFormulario">
				<form:errors></form:errors>
			</div>
		</form:form>
	</div>

</body>
</html>