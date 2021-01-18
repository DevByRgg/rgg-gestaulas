<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="ES">
<head>

<c:import url="../common/head.jsp"/>



<title>Zona Administracion</title>


</head>
<body>


<c:choose>
	<c:when test="${zone == 0}">
		<c:import url="../common/navbarAdmin.jsp"/>	
	</c:when>    
	<c:otherwise>
		<c:import url="../common/navbarPublic.jsp"/>
	</c:otherwise>
</c:choose>		

	
	<div class="container-md w-75">
		<!-- Titulo -->
		
		<div class="pt-5"></div>
		
		<h2 class="pt-3 pb-2">
			Ver <span class="badge text-white bg-cice mr-5">Horario</span> 
			
		</h2>

		<div class="mb-2">
			<a href="restarMes?mes=${mes}&anio=${anio}&turno=${turno}&aula=${aula}">
				<img class="ml-5" alt="mes anterior" src="/aulas/icons/flecha2-black-izq-fill.svg" height="20px">
			</a>
			<span class="ml-2 mr-2 text-center text-capitalize">${mesTexto}</span>
			<a href="anadirMes?mes=${mes}&anio=${anio}&turno=${turno}&aula=${aula}">
				<img class="mr-2" alt="mes siguiente" src="/aulas/icons/flecha2-black-der-fill.svg" height="20px">
			</a>
			
			<a href="restarAnio?mes=${mes}&anio=${anio}&turno=${turno}&aula=${aula}">
				<img class="ml-2" alt="mes anterior" src="/aulas/icons/flecha2-black-izq-fill.svg" height="20px">
			</a>
			<span class="ml-2 mr-2 text-capitalize">${anio}</span>
			<a href="anadirAnio?mes=${mes}&anio=${anio}&turno=${turno}&aula=${aula}">
				<img class="mr-5" alt="mes siguiente" src="/aulas/icons/flecha2-black-der-fill.svg" height="20px">
			</a>
			
			<a href="restarAula?mes=${mes}&anio=${anio}&turno=${turno}&aula=${aula}">
				<img class="ml-5" alt="mes anterior" src="/aulas/icons/flecha2-black-izq-fill.svg" height="20px">
			</a>
			<span class="ml-2 mr-2 text-capitalize">${aulaTexto}</span>
			<a href="anadirAula?mes=${mes}&anio=${anio}&turno=${turno}&aula=${aula}">
				<img class="mr-5" alt="mes siguiente" src="/aulas/icons/flecha2-black-der-fill.svg" height="20px">
			</a>
			
			<a href="restarTurno?mes=${mes}&anio=${anio}&turno=${turno}&aula=${aula}">
				<img class="ml-5" alt="mes anterior" src="/aulas/icons/flecha2-black-izq-fill.svg" height="20px">
			</a>
			<span class="ml-2 mr-2 text-capitalize">${turnoTexto}</span>
			<a href="anadirTurno?mes=${mes}&anio=${anio}&turno=${turno}&aula=${aula}">
				<img class="mr-5" alt="mes siguiente" src="/aulas/icons/flecha2-black-der-fill.svg" height="20px">
			</a>
			
		</div>
		
		<table class="table  table-sm table-bordered">
				<thead>
					<tr tr class="thead bg-cice text-white">
						<th class="align-middle text-center" scope="col">Fecha</th>	
						
						<!-- Turno de Mañana -->
						<c:choose>
							<c:when test="${turno != 2}">
								<th class="align-middle text-center" scope="col">09:00</th>
								<th class="align-middle text-center" scope="col">10:00</th>
								<th class="align-middle text-center" scope="col">11:00</th>
								<th class="align-middle text-center" scope="col">12:00</th>
								<th class="align-middle text-center" scope="col">13:00</th>
								<th class="align-middle text-center" scope="col">14:00</th>
							</c:when>
							<c:otherwise></c:otherwise>
						</c:choose>
						<!-- Fin Turno de Mañana -->
						
						<!-- Separador -->
						<c:choose>
							<c:when test="${turno == 0}">
								<th class="align-middle bg-light text-center" scope="col"></th>
							</c:when>
							<c:otherwise></c:otherwise>
						</c:choose>
						<!-- Separador -->
						
						<!-- Turno de Tarde -->
						<c:choose>
							<c:when test="${turno != 1}">
								<th class="align-middle text-center" scope="col">17:00</th>
								<th class="align-middle text-center" scope="col">18:00</th>
								<th class="align-middle text-center" scope="col">19:00</th>
								<th class="align-middle text-center" scope="col">20:00</th>
								<th class="align-middle text-center" scope="col">21:00</th>
								<th class="align-middle text-center" scope="col">22:00</th>
							</c:when>
							<c:otherwise></c:otherwise>
						</c:choose>
						<!-- Fin Turno de Tarde -->
						
						
										
					</tr>
				</thead>
				
				<tbody>
					<c:forEach items="${horasDisponibles}" var="horaDisponible">
					<tr>
						<th scope="row" class="align-middle text-center">${horaDisponible.fecha}</th>
						
						<!-- Turno de Mañana -->
						<c:choose>
							<c:when test="${turno != 2}">
								<c:choose>
									<c:when test="${horaDisponible.man09 == 1}">
										<td class="align-middle text-center bg-cice-fail" title="${horaDisponible.manTitle09}"></td>
									</c:when>
									<c:when test="${horaDisponible.man09 == 2}">
										<td class="align-middle text-center bg-cice-ok" title="${horaDisponible.manTitle09}"></td>
									</c:when>
									<c:otherwise>
										<td class="align-middle text-center bg-secondary" title="${horaDisponible.manTitle09}"></td>
									</c:otherwise>
								</c:choose>
								
								<c:choose>
									<c:when test="${horaDisponible.man10 == 1}">
										<td class="align-middle text-center bg-cice-fail" title="${horaDisponible.manTitle10}"></td>
									</c:when>
									<c:when test="${horaDisponible.man10 == 2}">
										<td class="align-middle text-center bg-cice-ok" title="${horaDisponible.manTitle10}"></td>
									</c:when>
									<c:otherwise>
										<td class="align-middle text-center bg-secondary" title="${horaDisponible.manTitle10}"></td>
									</c:otherwise>
								</c:choose>
								
								<c:choose>
									<c:when test="${horaDisponible.man11 == 1}">
										<td class="align-middle text-center bg-cice-fail" title="${horaDisponible.manTitle11}"></td>
									</c:when>
									<c:when test="${horaDisponible.man11 == 2}">
										<td class="align-middle text-center bg-cice-ok" title="${horaDisponible.manTitle11}"></td>
									</c:when>
									<c:otherwise>
										<td class="align-middle text-center bg-secondary" title="${horaDisponible.manTitle11}"></td>
									</c:otherwise>
								</c:choose>
								
								<c:choose>
									<c:when test="${horaDisponible.man12 == 1}">
										<td class="align-middle text-center bg-cice-fail" title="${horaDisponible.manTitle12}"></td>
									</c:when>
									<c:when test="${horaDisponible.man12 == 2}">
										<td class="align-middle text-center bg-cice-ok" title="${horaDisponible.manTitle12}"></td>
									</c:when>
									<c:otherwise>
										<td class="align-middle text-center bg-secondary" title="${horaDisponible.manTitle12}"></td>
									</c:otherwise>
								</c:choose>
								
								<c:choose>
									<c:when test="${horaDisponible.man13 == 1}">
										<td class="align-middle text-center bg-cice-fail" title="${horaDisponible.manTitle13}"></td>
									</c:when>
									<c:when test="${horaDisponible.man13 == 2}">
										<td class="align-middle text-center bg-cice-ok" title="${horaDisponible.manTitle13}"></td>
									</c:when>
									<c:otherwise>
										<td class="align-middle text-center bg-secondary" title="${horaDisponible.manTitle13}"></td>
									</c:otherwise>
								</c:choose>
								
								<c:choose>
									<c:when test="${horaDisponible.man14 == 1}">
										<td class="align-middle text-center bg-cice-fail" title="${horaDisponible.manTitle14}"></td>
									</c:when>
									<c:when test="${horaDisponible.man14 == 2}">
										<td class="align-middle text-center bg-cice-ok" title="${horaDisponible.manTitle14}"></td>
									</c:when>
									<c:otherwise>
										<td class="align-middle text-center bg-secondary" title="${horaDisponible.manTitle14}"></td>
									</c:otherwise>
								</c:choose>
							</c:when>
							<c:otherwise></c:otherwise>
						</c:choose>
						<!-- Fin Turno de Mañana -->
						
						<!-- Separador -->
						<c:choose>
							<c:when test="${turno == 0}">
								<td class="align-middle text-center bg-light"></td>
							</c:when>
							<c:otherwise></c:otherwise>
						</c:choose>
						<!-- Separador -->
						
						<!-- Turno de Tarde -->
						<c:choose>
							<c:when test="${turno != 1}">
								<c:choose>
									<c:when test="${horaDisponible.tar17 == 1}">
										<td class="align-middle text-center bg-cice-fail" title="${horaDisponible.tarTitle17}"></td>
									</c:when>
									<c:when test="${horaDisponible.tar17 == 2}">
										<td class="align-middle text-center bg-cice-ok" title="${horaDisponible.tarTitle17}"></td>
									</c:when>
									<c:otherwise>
										<td class="align-middle text-center bg-secondary" title="${horaDisponible.tarTitle17}"></td>
									</c:otherwise>
								</c:choose>
								
								<c:choose>
									<c:when test="${horaDisponible.tar18 == 1}">
										<td class="align-middle text-center bg-cice-fail" title="${horaDisponible.tarTitle18}"></td>
									</c:when>
									<c:when test="${horaDisponible.tar18 == 2}">
										<td class="align-middle text-center bg-cice-ok" title="${horaDisponible.tarTitle18}"></td>
									</c:when>
									<c:otherwise>
										<td class="align-middle text-center bg-secondary" title="${horaDisponible.tarTitle18}"></td>
									</c:otherwise>
								</c:choose>
								
								<c:choose>
									<c:when test="${horaDisponible.tar19 == 1}">
										<td class="align-middle text-center bg-cice-fail" title="${horaDisponible.tarTitle19}"></td>
									</c:when>
									<c:when test="${horaDisponible.tar19 == 2}">
										<td class="align-middle text-center bg-cice-ok" title="${horaDisponible.tarTitle19}"></td>
									</c:when>
									<c:otherwise>
										<td class="align-middle text-center bg-secondary" title="${horaDisponible.tarTitle19}"></td>
									</c:otherwise>
								</c:choose>
								
								<c:choose>
									<c:when test="${horaDisponible.tar20 == 1}">
										<td class="align-middle text-center bg-cice-fail" title="${horaDisponible.tarTitle20}"></td>
									</c:when>
									<c:when test="${horaDisponible.tar20 == 2}">
										<td class="align-middle text-center bg-cice-ok" title="${horaDisponible.tarTitle20}"></td>
									</c:when>
									<c:otherwise>
										<td class="align-middle text-center bg-secondary" title="${horaDisponible.tarTitle20}"></td>
									</c:otherwise>
								</c:choose>
								
								<c:choose>
									<c:when test="${horaDisponible.tar21 == 1}">
										<td class="align-middle text-center bg-cice-fail" title="${horaDisponible.tarTitle21}"> </td>
									</c:when>
									<c:when test="${horaDisponible.tar21 == 2}">
										<td class="align-middle text-center bg-cice-ok" title="${horaDisponible.tarTitle21}"> </td>
									</c:when>
									<c:otherwise>
										<td class="align-middle text-center bg-secondary" title="${horaDisponible.tarTitle21}"> </td>
									</c:otherwise>
								</c:choose>
								
								<c:choose>
									<c:when test="${horaDisponible.tar22 == 1}">
										<td class="align-middle text-center bg-cice-fail" title="${horaDisponible.tarTitle22}"> </td>
									</c:when>
									<c:when test="${horaDisponible.tar22 == 2}">
										<td class="align-middle text-center bg-cice-ok" title="${horaDisponible.tarTitle22}"> </td>
									</c:when>
									<c:otherwise>
										<td class="align-middle text-center bg-secondary" title="${horaDisponible.tarTitle22}"> </td>
									</c:otherwise>
								</c:choose>
							</c:when>
							<c:otherwise></c:otherwise>
						</c:choose>
						<!--  Fin Turno de Tarde -->
						
					</tr>
				</c:forEach>
				</tbody>
			</table>
	</div>

</body>
</html>