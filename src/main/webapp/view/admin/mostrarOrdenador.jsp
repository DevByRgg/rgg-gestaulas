<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="ES">
<head>

<c:import url="../common/head.jsp"/>

<script src="/aulas/js/borrarOrdenador.js"></script>

<title>Zona Administracion</title>


</head>
<body>
	
<c:import url="../common/navbarAdmin.jsp"/>
	
	<div class="container-md w-75">
		<!-- Titulo -->
		
		<div class="pt-5"></div>
		
		<h2 class="pt-3 pb-2">
			Equipos <span class="badge text-white bg-cice">LISTADO</span>
		</h2>

		<!-- Forumulario -->
		<table class="table table-bordered table-dark table-striped">
				<thead>
					<tr tr class="thead-dark">
						<th class="align-middle text-center" scope="col">Tipo</th>
						<th class="align-middle text-center" scope="col">Nombre</th>
						<th class="align-middle text-center" scope="col">Sistema Operativo</th>
						<th class="align-middle text-center" scope="col">Tamaño pantalla</th>
						<th class="align-middle text-center" scope="col">Cpu</th>
						<th class="align-middle text-center" scope="col">Memoria Ram</th>
						<th class="align-middle text-center" scope="col">Hdd</th>
						<th class="align-middle text-center" scope="col">Tarjeta grafica</th>						
						<th class="align-middle text-center" scope="col">Borrar</th>
						<th class="align-middle text-center" scope="col">Update</th>					
					</tr>
				</thead>
				
				<tbody>
					<c:forEach items="${ordenadores}" var="ordenador">
					<tr>
	      				<th scope="row" class="align-middle text-center">${ordenador.id}</th>
						<td class="align-middle text-center">${ordenador.nombre}</td>
						<td class="align-middle text-center">${ordenador.sistemaOperativo}</td>
						<td class="align-middle text-center">${ordenador.dimensionPantalla}"</td>
						<td class="align-middle text-center">${ordenador.cpu}</td>
						<td class="align-middle text-center">${ordenador.ram} Gb</td>
						<td class="align-middle text-center">${ordenador.hdd}</td>
						<td class="align-middle text-center">${ordenador.tarjetaGrafica}</td>
						<td class="align-middle text-center">${ordenador.observaciones}</td>
						<td class="align-middle text-center">
							<button type="button" class="btn btn-secondary text-white bg-cice" data-toggle="modal" data-target="#divBorrado"
							onclick="configurarBorrado('${ordenador.id}')">
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
					<h5 class="modal-title text-white" id="exampleModalLongTitle">Borrar Equipo</h5>
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