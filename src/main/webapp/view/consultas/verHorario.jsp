<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="ES">
<head>

<c:import url="../common/head.jsp"/>



<title>Zona Administracion</title>


</head>
<body>
	
<c:import url="../common/navbarAdmin.jsp"/>

	
	<div class="container-md w-75">
		<!-- Titulo -->
		
		<div class="pt-5"></div>
		
		<h2 class="pt-3 pb-2">
			Ver <span class="badge text-white bg-cice mr-5">Horario</span> 
			<a href="restarMes?aula=${aula}&mes=${mes}&anio=${anio}"><img class="ml-5" alt="mes anterior" src="/aulas/icons/flecha2-black-izq-fill.svg" height="30px"></a>
			<span class="ml-2 mr-2 text-center text-capitalize">${mesTexto}</span>
			<a href="anadirMes?aula=${aula}&mes=${mes}&anio=${anio}"><img class="mr-2" alt="mes siguiente" src="/aulas/icons/flecha2-black-der-fill.svg" height="30px"></a>
			
			<a href="restarAnio?aula=${aula}&mes=${mes}&anio=${anio}"><img class="ml-2" alt="mes anterior" src="/aulas/icons/flecha2-black-izq-fill.svg" height="30px"></a>
			<span class="ml-2 mr-2 text-capitalize">${anio}</span>
			<a href="anadirAnio?aula=${aula}&mes=${mes}&anio=${anio}"><img class="mr-5" alt="mes siguiente" src="/aulas/icons/flecha2-black-der-fill.svg" height="30px"></a>
			
			
			Aula <span class="badge text-left text-white bg-cice">${nombreAula}</span>
			
		</h2>

		

		<table class="table table-bordered table-striped">
				<thead>
					<tr tr class="thead-dark">
						<th class="align-middle text-center" scope="col">Fecha</th>
						<th class="align-middle text-center" scope="col">09:00</th>
						<th class="align-middle text-center" scope="col">10:00</th>
						<th class="align-middle text-center" scope="col">11:00</th>
						<th class="align-middle text-center" scope="col">12:00</th>
						<th class="align-middle text-center" scope="col">13:00</th>
						<th class="align-middle text-center" scope="col">14:00</th>
						<th class="align-middle text-center" scope="col"></th>
						<th class="align-middle text-center" scope="col">17:00</th>
						<th class="align-middle text-center" scope="col">18:00</th>
						<th class="align-middle text-center" scope="col">19:00</th>
						<th class="align-middle text-center" scope="col">20:00</th>
						<th class="align-middle text-center" scope="col">21:00</th>
						<th class="align-middle text-center" scope="col">22:00</th>
						
										
					</tr>
				</thead>
				
				<tbody>
					<c:forEach items="${dias}" var="dia">
					<tr>
	      				<th scope="row" class="align-middle text-center">${dia.value}</th>
						
						<td class="align-middle text-center">
							<c:choose>
								<c:when test="${algo}">
									
								</c:when>
								<c:otherwise>
									Libre
								</c:otherwise>
							</c:choose>
						</td>
						
						<td class="align-middle text-center">
							<c:choose>
								<c:when test="${algo}">
									
								</c:when>
								<c:otherwise>
									Libre
								</c:otherwise>
							</c:choose>
						</td>
						
						<td class="align-middle text-center">
							<c:choose>
								<c:when test="${algo}">
									
								</c:when>
								<c:otherwise>
									Libre
								</c:otherwise>
							</c:choose>
						</td>
						
						<td class="align-middle text-center">
							<c:choose>
								<c:when test="${algo}">
									
								</c:when>
								<c:otherwise>
									Libre
								</c:otherwise>
							</c:choose>
						</td>
						
						<td class="align-middle text-center">
							<c:choose>
								<c:when test="${algo}">
									
								</c:when>
								<c:otherwise>
									Libre
								</c:otherwise>
							</c:choose>
						</td>
						
						<td class="align-middle text-center">
							<c:choose>
								<c:when test="${algo}">
									
								</c:when>
								<c:otherwise>
									Libre
								</c:otherwise>
							</c:choose>
						</td>
						
						<td class="align-middle text-center"></td>

						<td class="align-middle text-center">
							<c:choose>
								<c:when test="${algo}">
									
								</c:when>
								<c:otherwise>
									Libre
								</c:otherwise>
							</c:choose>
						</td>
						
						<td class="align-middle text-center">
							<c:choose>
								<c:when test="${algo}">
									
								</c:when>
								<c:otherwise>
									Libre
								</c:otherwise>
							</c:choose>
						</td>
						
						<td class="align-middle text-center">
							<c:choose>
								<c:when test="${algo}">
									
								</c:when>
								<c:otherwise>
									Libre
								</c:otherwise>
							</c:choose>
						</td>
						
						<td class="align-middle text-center">
							<c:choose>
								<c:when test="${algo}">
									
								</c:when>
								<c:otherwise>
									Libre
								</c:otherwise>
							</c:choose>
						</td>
						
						<td class="align-middle text-center">
							<c:choose>
								<c:when test="${algo}">
									
								</c:when>
								<c:otherwise>
									Libre
								</c:otherwise>
							</c:choose>
						</td>
						
						<td class="align-middle text-center">
							<c:choose>
								<c:when test="${algo}">
									
								</c:when>
								<c:otherwise>
									Libre
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


</body>
</html>