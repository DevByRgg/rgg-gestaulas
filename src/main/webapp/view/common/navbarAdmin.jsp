<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<nav class="navbar fixed-top navbar-expand-lg navbar-light bg-cice">
	<a class="navbar-brand text-white" href="/"> 
        <img src="/images/logo_blanco_total.svg" height="25"	class="d-inline-block align-top" alt="">
    </a>

	<button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
		<span class="navbar-toggler-icon"></span>
	</button>

	<div class="collapse navbar-collapse" id="navbarSupportedContent">
		<ul class="navbar-nav ml-auto mr-auto">
			
			<li class="nav-item dropdown mr-5">
                <a class="nav-link dropdown-toggle text-white" href="#"	id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">Usuario</a>
				<div class="dropdown-menu bg-cice" aria-labelledby="navbarDropdown">
                    <a class="dropdown-item cice-hover text-white" href="/admin/crearUsuario">Crear Usuario</a>
                    <a class="dropdown-item cice-hover text-white" href="/admin/mostrarUsuario">Listado Usuario</a>
                </div>
            </li>
			
			<li class="nav-item dropdown ml-5 mr-2">
                <a class="nav-link dropdown-toggle text-white" href="#"	id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">Sede</a>
				<div class="dropdown-menu bg-cice" aria-labelledby="navbarDropdown">
                    <a class="dropdown-item cice-hover text-white" href="/admin/crearSede">Crear Sede</a>
                    <a class="dropdown-item cice-hover text-white" href="/admin/mostrarSede">Listado Sede</a>
                </div>
            </li>

			<li class="nav-item dropdown mr-2">
                <a class="nav-link dropdown-toggle text-white" href="#"	id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">Aula</a>
				<div class="dropdown-menu bg-cice" aria-labelledby="navbarDropdown">
                    <a class="dropdown-item cice-hover text-white" href="/admin/crearAula">Crear Aula</a>
                    <a class="dropdown-item cice-hover text-white" href="/admin/crearTipoAula">Crear Tipo Aula</a>
                    <div class="dropdown-divider"></div>
                    <a class="dropdown-item cice-hover text-white" href="/admin/mostrarAula">Listado Aula</a>
                    <a class="dropdown-item cice-hover text-white" href="/admin/mostrarTipoAula">Listado Tipo Aula</a>
                </div>
            </li>

            <li class="nav-item dropdown mr-2">
                <a class="nav-link dropdown-toggle text-white" href="#"	id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">Equipo</a>
				<div class="dropdown-menu bg-cice" aria-labelledby="navbarDropdown">
                    <a class="dropdown-item cice-hover text-white" href="/admin/crearOrdenador">Crear Equipo</a>
                    <a class="dropdown-item cice-hover text-white" href="/admin/mostrarOrdenador">Listado Equipo</a>
                </div>
            </li>

            <li class="nav-item dropdown mr-5">
                <a class="nav-link dropdown-toggle text-white" href="#"	id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">Equipamiento</a>
				<div class="dropdown-menu bg-cice" aria-labelledby="navbarDropdown">
                    <a class="dropdown-item cice-hover text-white" href="/admin/crearEquipamiento">Crear Equipamiento</a>
                    <a class="dropdown-item cice-hover text-white" href="/admin/mostrarEquipamiento">Listado Equipamiento</a>
                </div>
            </li>
            
            <li class="nav-item dropdown ml-5">
                <a class="nav-link dropdown-toggle text-white" href="#"	id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">Reserva</a>
				<div class="dropdown-menu bg-cice" aria-labelledby="navbarDropdown">
                    <a class="dropdown-item cice-hover text-white" href="/reservas/crearReserva">Reservar Dia</a>
                    <a class="dropdown-item cice-hover text-white" href="/reservas/buscarReserva">Reservar Curso</a>
                    <a class="dropdown-item cice-hover text-white" href="/reservas/borrarCursoReserva">Borrar Dia / Curso</a>
                    <div class="dropdown-divider"></div>
                    <a class="dropdown-item cice-hover text-white" href="/reservas/mostrarReserva">Listado Reserva</a>
				</div>
            </li>
            
            <li class="nav-item dropdown ml-2">
                <a class="nav-link dropdown-toggle text-white" href="#"	id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">Consulta</a>
				<div class="dropdown-menu bg-cice" aria-labelledby="navbarDropdown">
                    <a class="dropdown-item cice-hover text-white" href="/consultas/consultarAulasDisponibles">Buscar Aulas Disponibles</a>
                    <a class="dropdown-item cice-hover text-white" href="/consultas/consultarPortatil">Buscardor Portatil</a>
                </div>
            </li>
            
            <li class="nav-item dropdown ml-2">
                <a class="nav-link dropdown-toggle text-white" href="#"	id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">Festivo</a>
				<div class="dropdown-menu bg-cice" aria-labelledby="navbarDropdown">  
                    <a class="dropdown-item cice-hover text-white" href="/mantenimiento/crearFestivo">Crear Festivo</a>
                    <a class="dropdown-item cice-hover text-white" href="/mantenimiento/crearPeriodoFestivo">Crear Periodo festivo</a>
                    <div class="dropdown-divider"></div>
                    <a class="dropdown-item cice-hover text-white" href="/mantenimiento/mostrarFestivo">Listado Festivo</a>
                </div>
            </li>
			
		</ul>

	</div>

	<a class="btn btn-light font-weight-bold text-cice text-cice-hover" href="<c:url value="/logout" />">
		<svg xmlns="http://www.w3.org/2000/svg" width="20" height="20" fill="currentColor" class="bi bi-door-open" viewBox="0 0 20 20">
  			<path d="M8.5 10c-.276 0-.5-.448-.5-1s.224-1 .5-1 .5.448.5 1-.224 1-.5 1z"/>
			<path d="M10.828.122A.5.5 0 0 1 11 .5V1h.5A1.5 1.5 0 0 1 13 2.5V15h1.5a.5.5 0 0 1 0 1h-13a.5.5 0 0 1 0-1H3V1.5a.5.5 0 0 
					1 .43-.495l7-1a.5.5 0 0 1 .398.117zM11.5 2H11v13h1V2.5a.5.5 0 0 0-.5-.5zM4 1.934V15h6V1.077l-6 .857z"/>
		</svg>
		Logout - ${username}
	</a>

</nav>