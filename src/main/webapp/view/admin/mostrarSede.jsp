<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="ES">
<head>

<c:import url="../common/head.jsp"/>

<script src="/aulas/js/borrarSede.js"></script>

<title>Zona Administracion</title>


</head>
<body>
	
<c:import url="../common/navbarAdmin.jsp"/>
	
	<div class="container-md w-75">
		<!-- Titulo -->
		
		<div class="pt-5"></div>
		
		<h2 class="pt-3 pb-2">
			Sedes <span class="badge badge-secondary  bg-cice text-white">LISTADO</span>
		</h2>

		<!-- Forumulario -->
		<table class="table table-bordered table-dark table-striped">
				<thead>
					<tr tr class="thead-dark">
						<th class="align-middle text-center" scope="col">Id</th>
						<th class="align-middle text-left" scope="col">Nombre</th>
						<th class="align-middle text-left" scope="col">Direccion</th>
						<th class="align-middle text-right" scope="col">Codigo postal</th>
						<th class="align-middle text-right" scope="col">Telefono</th>
						<th class="align-middle text-center" scope="col">Borrar</th>
						<th class="align-middle text-center" scope="col">Update</th>					
					</tr>
				</thead>
				
				<tbody>
					<c:forEach items="${sedes}" var="sede">
					<tr>
	      				<th scope="row" class="align-middle text-center">${sede.id}</th>
						<td class="align-middle text-left">${sede.nombre}</td>
						<td class="align-middle text-left">${sede.direccion}</td>
						<td class="align-middle text-right">${sede.codigoPostal}</td>
						<td class="align-middle text-right">${sede.telefono}</td>
						<td class="align-middle text-center">
							<button type="button" class="btn bg-cice text-white" data-toggle="modal" data-target="#divBorrado"
							onclick="configurarBorrado('${sede.id}')">
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
				<div class="modal-header">
					<h5 class="modal-title" id="exampleModalLongTitle">Sede</h5>
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