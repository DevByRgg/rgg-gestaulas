<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="ES">
<head>

<c:import url="../common/head.jsp"/>

<script src="/js/borrarAula.js"></script>

<title>Zona Administracion</title>


</head>
<body>
	
<c:import url="../common/navbarAdmin.jsp"/>
	
	<div class="container-md w-75">
		<!-- Titulo -->
		
		<div class="pt-5"></div>
		
		<h2 class="pt-3 pb-2">
			Aula <span class="badge text-white bg-cice">LISTADO</span>
		</h2>
		
		<c:if test="${msg != null}">
			<p class="alert border border-${alert} alert-${alert} font-weight-bold" role="alert">${msg}</p>
		</c:if>
		
		<!-- Forumulario -->
		<table class="table table-bordered table-hover">
				<thead>
					<tr class="thead text-white bg-cice">
						<th class="align-middle text-center" scope="col">Id</th>
						<th class="align-middle text-center" scope="col">Nombre</th>
						<th class="align-middle text-center" scope="col">Tipo</th>
						<th class="align-middle text-center" scope="col">Sede</th>
						<th class="align-middle text-center" scope="col">Capacidad</th>
						<th class="align-middle text-center" scope="col">Equipo Profesor</th>
						<th class="align-middle text-center" scope="col">Equipo Alumnos</th>
						<th class="align-middle text-center" scope="col">Equipamiento</th>
						<th class="align-middle text-center" scope="col">Update</th>
						<th class="align-middle text-center" scope="col">Borrar</th>					
					</tr>
				</thead>
				
				<tbody>
					<c:forEach items="${aulas}" var="aula">
					<tr>
	      				<th scope="row" class="align-middle text-center">${aula.idAula}</th>
						<td class="align-middle text-left">${aula.nombreAula}</td>
						<td class="align-middle text-right">${aula.nombreTipoAula}</td>
						<td class="align-middle text-right">${aula.nombreSede}</td>
						<td class="align-middle text-right">${aula.capacidadAula}</td>
						<td class="align-middle text-right">${aula.nombreOrdenador}</td>
						<td class="align-middle text-right">${aula.nombreOrdenador}</td>
						<td class="align-middle text-right">${aula.nombreEquipamiento}</td>

						<td class="align-middle text-center">
							<a type="button" class="btn cice-hover bg-cice text-white" href="/admin/updateAula?id=${aula.idAula}">
								Update
							</a>
						</td>
							
						<td class="align-middle text-center">
							<button type="button" class="btn cice-hover bg-cice text-white" data-toggle="modal" data-target="#divBorrado"
							onclick="configurarBorrado('${aula.idAula}')">
								Borrar
							</button>
						</td>
					</tr>
				</c:forEach>
				</tbody>
			</table>
	</div>
<!-- Modal -->
	<div class="modal fade" id="divBorrado" tabindex="-1"
		role="dialog" aria-labelledby="exampleModalCenterTitle"
		aria-hidden="true">
		<div class="modal-dialog modal-dialog-centered" role="document">
			<div class="modal-content">
				<div class="modal-header bg-cice">
					<h5 class="modal-title text-white" id="exampleModalLongTitle">Borrar Aula</h5>
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
				</div>
				<div class="modal-body">
				¿Estas seguro que quieres borrar este registro?
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-dark" onclick="borrar()">Aceptar</button>
					<button type="button" class="btn btn-light" data-dismiss="modal">Cancelar</button>
				</div>
			</div>
		</div>
	</div>


</body>
</html>


</body>
</html>