<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="ES">
<head>

<c:import url="../common/head.jsp"/>

<script src="/aulas/js/borrarReserva.js"></script>

<title>Zona Administracion</title>


</head>
<body>
	
<c:import url="../common/navbarAdmin.jsp"/>
	
	<div class="container-md w-75">
		<!-- Titulo -->
		
		<div class="pt-5"></div>
		
		<h2 class="pt-3 pb-2">
			Reserva <span class="badge text-white bg-cice">LISTADO</span>
		</h2>

		<!-- Forumulario -->
		<table class="table table-sm table-hover">
				<thead>
					<tr tr class="thead text-white bg-cice">
						<th class="align-middle text-center" scope="col">
							<a class="btn btn-link font-weight-bold cice-hover text-white" href="orderByIdAsc">
								<svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-caret-down" viewBox="0 0 16 16">
  									<path d="M3.204 5h9.592L8 10.481 3.204 5zm-.753.659l4.796 5.48a1 1 0 0 0 1.506 0l4.796-5.48c.566-.647.106-1.659-.753-1.659H3.204a1 1 0 0 0-.753 1.659z"/>
								</svg>
  							</a>
  								Id
  							<a class="btn btn-link font-weight-bold cice-hover text-white" href="orderByIdDes">
								<svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-caret-up" viewBox="0 0 16 16">
  									<path d="M3.204 11h9.592L8 5.519 3.204 11zm-.753-.659l4.796-5.48a1 1 0 0 1 1.506 0l4.796 5.48c.566.647.106 1.659-.753 1.659H3.204a1 1 0 0 1-.753-1.659z"/>
								</svg>
							</a>
						</th>
						
						<th class="align-middle text-left" scope="col">
							<a class="btn btn-link font-weight-bold cice-hover text-white" href="orderByCursoAsc">
								<svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-caret-down" viewBox="0 0 16 16">
  									<path d="M3.204 5h9.592L8 10.481 3.204 5zm-.753.659l4.796 5.48a1 1 0 0 0 1.506 0l4.796-5.48c.566-.647.106-1.659-.753-1.659H3.204a1 1 0 0 0-.753 1.659z"/>
								</svg>
  							</a>
  								Curso
  							<a class="btn btn-link font-weight-bold cice-hover text-white" href="orderByCursoDes">
								<svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-caret-up" viewBox="0 0 16 16">
  									<path d="M3.204 11h9.592L8 5.519 3.204 11zm-.753-.659l4.796-5.48a1 1 0 0 1 1.506 0l4.796 5.48c.566.647.106 1.659-.753 1.659H3.204a1 1 0 0 1-.753-1.659z"/>
								</svg>
							</a>
						</th>
						
						<th class="align-middle text-center" scope="col">
							<a class="btn btn-link font-weight-bold cice-hover text-white" href="orderByAulaAsc">
								<svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-caret-down" viewBox="0 0 16 16">
  									<path d="M3.204 5h9.592L8 10.481 3.204 5zm-.753.659l4.796 5.48a1 1 0 0 0 1.506 0l4.796-5.48c.566-.647.106-1.659-.753-1.659H3.204a1 1 0 0 0-.753 1.659z"/>
								</svg>
  							</a>
  								Aula
  							<a class="btn btn-link font-weight-bold cice-hover text-white" href="orderByAulaDes">
								<svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-caret-up" viewBox="0 0 16 16">
  									<path d="M3.204 11h9.592L8 5.519 3.204 11zm-.753-.659l4.796-5.48a1 1 0 0 1 1.506 0l4.796 5.48c.566.647.106 1.659-.753 1.659H3.204a1 1 0 0 1-.753-1.659z"/>
								</svg>
							</a>
						</th>
						
						<th class="align-middle text-center" scope="col">
							<a class="btn btn-link font-weight-bold cice-hover text-white" href="orderByFechaAsc">
								<svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-caret-down" viewBox="0 0 16 16">
  									<path d="M3.204 5h9.592L8 10.481 3.204 5zm-.753.659l4.796 5.48a1 1 0 0 0 1.506 0l4.796-5.48c.566-.647.106-1.659-.753-1.659H3.204a1 1 0 0 0-.753 1.659z"/>
								</svg>
  							</a>
  								Fecha
  							<a class="btn btn-link font-weight-bold cice-hover text-white" href="orderByFechaDes">
								<svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-caret-up" viewBox="0 0 16 16">
  									<path d="M3.204 11h9.592L8 5.519 3.204 11zm-.753-.659l4.796-5.48a1 1 0 0 1 1.506 0l4.796 5.48c.566.647.106 1.659-.753 1.659H3.204a1 1 0 0 1-.753-1.659z"/>
								</svg>
							</a>
						</th>

						<th class="align-middle text-center" scope="col">Update</th>
						<th class="align-middle text-center" scope="col">Borrar</th>					
					</tr>
				</thead>
				
				<tbody>
					<c:forEach items="${reservas}" var="reserva">
					<tr>
	      				<th scope="row" class="align-middle text-center">${reserva.id}</th>
						<td class="align-middle text-left">${reserva.nombreCurso}</td>
						<td class="align-middle text-center">${reserva.idAula}</td>
						<td class="align-middle text-center">${reserva.fechaReserva}</td>
						
						<td class="align-middle text-center">
							<a type="button" class="btn font-weight-bold cice-hover bg-cice text-white" href="/aulas/reservas/updateReserva?id=${reserva.id}">
								Update
							</a>
						</td>
						
						<td class="align-middle text-center">
							<button type="button" class="btn font-weight-bold cice-hover bg-cice text-white" data-toggle="modal" data-target="#divBorrado"
							onclick="configurarBorrado('${reserva.id}')">
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
					<h5 class="modal-title text-white" id="exampleModalLongTitle">Borrar Reserva</h5>
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