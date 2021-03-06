<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="ES">
<head>

<c:import url="../common/head.jsp" />

<script src="/js/borrarUsuario.js"></script>

<title>Zona Administracion</title>


</head>
<body>

	<c:import url="../common/navbarAdmin.jsp" />

	<div class="container-md w-50">
		<!-- Titulo -->

		<div class="pt-5"></div>

		<h2 class="pt-3 pb-2">
			Usuarios <span class="badge text-white bg-cice">LISTADO</span>
		</h2>
		
		<c:if test="${msg != null}">
			<p class="alert border border-${alert} alert-${alert} font-weight-bold" role="alert">${msg}</p>
		</c:if>

		<table class="table table-bordered table-hover">
			<thead>
				<tr class="thead text-white bg-cice">
					<th class="align-middle text-center" scope="col">Id</th>
					<th class="align-middle text-center" scope="col">Activo</th>
					<th class="align-middle text-left" scope="col">Usuario</th>
					<th class="align-middle text-center" scope="col">Lock</th>
					<th class="align-middle text-center" scope="col">Update</th>
					<th class="align-middle text-center" scope="col">Borrar</th>
				</tr>
			</thead>

			<tbody>
				<c:forEach items="${usuarios}" var="usuario">
					<tr>
						<th scope="row" class="align-middle text-center">${usuario.id}</th>
						<td class="align-middle text-center">${usuario.enabled}</td>
						<td class="align-middle text-left">${usuario.username}</td>
						<td class="align-middle text-center">
						<a type="button" class="btn cice-hover bg-cice text-white" href="/admin/unlockUsuario?id=${usuario.id}">
								<c:choose>
									<c:when test="${usuario.enabled == true}">
										Lock
									</c:when>    
    								<c:otherwise>
										Unlock
									</c:otherwise>
								</c:choose>
							</a>
						</td>
						
						<td class="align-middle text-center">
							<a type="button" class="btn cice-hover bg-cice text-white" href="/admin/updateUsuario?id=${usuario.id}">
								Update
							</a>
						</td>
						
						<td class="align-middle text-center">
							<button type="button" class="btn cice-hover bg-cice text-white"
								data-toggle="modal" data-target="#divBorrado"
								onclick="configurarBorrado('${usuario.id}')">Borrar</button>
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
	<!-- Modal -->
	<div class="modal fade" id="divBorrado" tabindex="-1" role="dialog"
		aria-labelledby="exampleModalCenterTitle" aria-hidden="true">
		<div class="modal-dialog modal-dialog-centered" role="document">
			<div class="modal-content">
				<div class="modal-header bg-cice">
					<h5 class="modal-title text-white" id="exampleModalLongTitle">Borrar
						usuario</h5>
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
				</div>
				<div class="modal-body">??Estas seguro que quieres borrar este
					registro?</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-dark" onclick="borrar()">Aceptar</button>
					<button type="button" class="btn btn-light" data-dismiss="modal">Cancelar</button>
				</div>
			</div>
		</div>
	</div>


</body>
</html>

