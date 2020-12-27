<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<nav class="navbar fixed-top navbar-expand-lg navbar-light bg-cice">
	<a class="navbar-brand text-white" href="#"> <img
		src="/aulas/images/logo_blanco_total.svg" height="25"
		class="d-inline-block align-top" alt="">

	</a>

	<button class="navbar-toggler" type="button" data-toggle="collapse"
		data-target="#navbarSupportedContent"
		aria-controls="navbarSupportedContent" aria-expanded="false"
		aria-label="Toggle navigation">
		<span class="navbar-toggler-icon"></span>
	</button>

	<div class="collapse navbar-collapse" id="navbarSupportedContent">
		<ul class="navbar-nav ml-auto mr-auto">

			<li class="nav-item active mr-3"><a class="nav-link text-white"
				href="/aulas/">Consulta aulas CICE </a></li>
				
				
			<li class="nav-item dropdown mr-3">
			
			
			<!-- <a
				class="nav-link dropdown-toggle text-white" href="#"
				id="navbarDropdown" role="button" data-toggle="dropdown"
				aria-haspopup="true" aria-expanded="false">Elegir Sede</a> -->
<!-- 				<div class="dropdown-menu bg-cice" aria-labelledby="navbarDropdown"> -->

				<select	class="form-control bg-cice" id="sede" name="sede">
							<option selected value="-1">Elegir Sede</option>
						<c:forEach items="${sedes}" var="sede">
							<option value="${sede.id}">${sede.nombre}</option>
						</c:forEach>
					</select>


					<!-- <a class="dropdown-item text-white" href="/aulas/mostrarSedes">Sede 1</a>
					<a class="dropdown-item text-white" href="/aulas/mostrarSedes">Sede 2</a> -->
					
<!-- 				</div> -->
			</li>
			
			
			<li class="nav-item dropdown mr-3"><a
				class="nav-link dropdown-toggle text-white" href="#"
				id="navbarDropdown" role="button" data-toggle="dropdown"
				aria-haspopup="true" aria-expanded="false">Elegir Aula</a>
				<div class="dropdown-menu bg-cice" aria-labelledby="navbarDropdown">


					<a class="dropdown-item cice-hover text-white" href="/aulas/mostrarAula">Aula 1</a>
					<a class="dropdown-item cice-hover text-white" href="/aulas/mostrarAula">Aula 2</a>
					<a class="dropdown-item cice-hover text-white" href="/aulas/mostrarAula">Aula 3</a>
					<a class="dropdown-item cice-hover text-white" href="/aulas/mostrarAula">Aula 4</a>
					<a class="dropdown-item cice-hover text-white" href="/aulas/mostrarAula">Aula 5</a>
					
				</div>
			</li>

			<li class="nav-item dropdown mr-3"><a
				class="nav-link dropdown-toggle text-white" href="#"
				id="navbarDropdown" role="button" data-toggle="dropdown"
				aria-haspopup="true" aria-expanded="false">Elegir Turno</a>
				<div class="dropdown-menu bg-cice" aria-labelledby="navbarDropdown">

					<a class="dropdown-item cice-hover text-white" href="/aulas/mostrarAula">Turno Mañana</a>
					<a class="dropdown-item cice-hover text-white" href="/aulas/mostrarAula">Turno Tarde</a>

				</div>
			</li>
			
			<li class="nav-item dropdown mr-3"><a
				class="nav-link dropdown-toggle text-white" href="#"
				id="navbarDropdown" role="button" data-toggle="dropdown"
				aria-haspopup="true" aria-expanded="false">Elegir Tipo de PC</a>
				<div class="dropdown-menu bg-cice" aria-labelledby="navbarDropdown">

					<a class="dropdown-item cice-hover text-white" href="/aulas/mostrarAula">Ordenador Mac</a>
					<a class="dropdown-item cice-hover text-white" href="/aulas/mostrarAula">Ordenador Windows</a>

				</div>
			</li>
						

		</ul>

	</div>

	<a class="navbar-brand text-light" href="#"> <img
		src="/aulas/images/logo_blanco_total.svg" height="25"
		class="d-inline-block align-top" alt="">
	</a>

</nav>