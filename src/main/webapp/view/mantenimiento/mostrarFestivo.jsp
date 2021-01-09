<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="ES">
<head>

<c:import url="../common/head.jsp"/>

<script src="/aulas/js/borrarFestivo.js"></script>

<title>Mantenimiento</title>


</head>
<body>
	
<c:import url="../common/navbarAdmin.jsp"/>
	
	<div class="container-md w-50">
		<!-- Titulo -->
		
		<div class="pt-5"></div>
		
		<h2 class="pt-3 pb-2">
			Festivo <span class="badge text-white bg-cice">LISTADO</span>
		</h2>

		<!-- Forumulario -->
		<table class="table table-bordered table-hover">
				<thead>
					<tr tr class="thead text-white bg-cice">
						<th class="align-middle text-center" scope="col">Id</th>
						<th class="align-middle text-left" scope="col">Nombre</th>
						<th class="align-middle text-center" scope="col">Fecha</th>
						<th class="align-middle text-center" scope="col">Update</th>
						<th class="align-middle text-center" scope="col">Borrar</th>
						
					</tr>
				</thead>
				
				<tbody>
					<c:forEach items="${festivos}" var="festivo">
					<tr>
	      				<th scope="row" class="align-middle text-center">${festivo.id}</th>
						<td class="align-middle text-left">${festivo.nombre}</td>
						<td class="align-middle text-center">${festivo.fecha}</td>
						
						<td class="align-middle text-center">
							<a type="button" class="btn cice-hover bg-cice text-white" href="/aulas/mantenimiento/updateFestivo?id=${festivo.id}">
								Update
							</a>
						</td>
						
						<td class="align-middle text-center">
							<button type="button" class="btn cice-hover bg-cice text-white" data-toggle="modal" data-target="#divBorrado"
							onclick="configurarBorrado('${festivo.id}')">
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
					<h5 class="modal-title text-white" id="exampleModalLongTitle">Borrar Festivo</h5>
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